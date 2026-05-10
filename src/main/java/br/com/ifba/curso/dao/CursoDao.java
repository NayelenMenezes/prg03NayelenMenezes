
package br.com.ifba.curso.dao;

import br.com.ifba.curso.entity.Curso;
import br.com.ifba.infrastructure.dao.GenericDao;
import java.util.List;


public class CursoDao extends GenericDao<Curso> implements CursoIDao {
    //metodo para procurar o curso pelo nome ou por algum termo
    @Override
    public List<Curso> findByNomeOrDescricao(String termo) {
        String jpql = "SELECT c FROM Curso c WHERE lower(c.nome) LIKE lower(:termo) " +
                      "OR lower(c.descricao) LIKE lower(:termo)";
        
        return entityManager.createQuery(jpql, Curso.class)
                            .setParameter("termo", "%" + termo + "%")
                            .getResultList();
    }
    
}
