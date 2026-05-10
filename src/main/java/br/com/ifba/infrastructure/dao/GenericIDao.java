/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.com.ifba.infrastructure.dao;

import br.com.ifba.infrastruture.entity.PersistenceEntity;
import java.util.List;

/**
 *
 * @author mealf
 * @param <Entity>
 */
public interface GenericIDao<Entity extends PersistenceEntity> {
    //salva uma instancia de persistence entity
    public abstract Entity save (Entity obejto);
    
    //altera uma instancia de persistence entity
    public abstract Entity update (Entity objeto);
    
    //deleta uma instancia de persistence entity
    public abstract void delete (Entity objeto);
    
    //lista todas as instancias de persistence entity
    public abstract List<Entity> findAll();
    
    //encontra uma entidade pelo id
    public abstract Entity findById (Long id);
}
