package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastruture.entity.PersistenceEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@SuppressWarnings("unchecked")
// Classe genérica para operações de banco de dados (CRUD) usando JPA
public class GenericDao<Entity extends PersistenceEntity> implements GenericIDao<Entity> {
    
    // Gerenciador de conexões centralizado (Singleton-like para a unidade de persistência)
    protected static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("cursoPU");

    // Cria um novo EntityManager para cada operação (isolamento de sessão)
    protected EntityManager getEntityManager() {
        return factory.createEntityManager();
    }

    @Override
    public Entity save(Entity entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            // Decide entre inserir (persist) ou atualizar (merge) baseado na existência do ID
            if (entity.getId() == null) {
                em.persist(entity);
            } else {
                entity = em.merge(entity);
            }
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            // Rollback em caso de erro para manter a integridade dos dados
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close(); // Garante o fechamento da conexão
        }
    }

    @Override
    public Entity update(Entity entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(entity); // Sincroniza o estado do objeto com o banco
            em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Entity entity) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            // Reanexa o objeto ao contexto do JPA antes de removê-lo
            Entity mergedEntity = em.merge(entity); 
            em.remove(mergedEntity);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Entity> findAll() {
        EntityManager em = getEntityManager();
        try {
            // Consulta dinâmica baseada no nome da classe da entidade
            return em.createQuery("from " + getTypeClass().getName()).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Entity findById(Long id) {
        EntityManager em = getEntityManager();
        try {
            // Busca direta pela chave primária
            return (Entity) em.find(getTypeClass(), id);
        } finally {
            em.close();
        }
    }

    // Técnica de Reflection para descobrir em tempo de execução o tipo da classe (Entity)
    protected Class<?> getTypeClass() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return (Class<?>) type;
    }
}