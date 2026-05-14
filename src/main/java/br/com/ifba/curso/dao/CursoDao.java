
package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import java.util.List;
import javax.persistence.EntityManager;


public class CursoDao extends GenericDao<Curso> implements CursoIDao {
    //metodo para procurar o curso pelo nome ou por algum termo
    @Override
    public List<Curso> findByNomeOrDescricao(String termo) {
        //buscamos um EntityManager novo através do método herdado do GenericDao
        EntityManager em = getEntityManager();

        try {
            String jpql = "SELECT c FROM Curso c WHERE lower(c.nome) LIKE lower(:termo) " +
                          "OR lower(c.descricao) LIKE lower(:termo)";

            return em.createQuery(jpql, Curso.class)
                     .setParameter("termo", "%" + termo + "%")
                     .getResultList();

        } finally {
            em.close();
        }
    }
}
