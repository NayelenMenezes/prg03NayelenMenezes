package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastruture.entity.PersistenceEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@SuppressWarnings("unchecked")
public class GenericDao <Entity extends PersistenceEntity> implements GenericIDao<Entity> {

    protected static EntityManager entityManager;
    
    static {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("cursoPU");
        entityManager = factory.createEntityManager();
    }
    
    @Override
    public Entity save(Entity entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public Entity update(Entity entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

    @Override
    public void delete(Entity entity) {
        entity = findById(entity.getId());
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Entity> findAll() {
        return entityManager.createQuery(("from " + getTypeClass().getName())).getResultList();
    }

    @Override
    public Entity findById(Long id) {
        return (Entity) entityManager.find(getTypeClass(), id);
    }
    
    protected Class<?> getTypeClass() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return (Class<?>) type;
    }
}
