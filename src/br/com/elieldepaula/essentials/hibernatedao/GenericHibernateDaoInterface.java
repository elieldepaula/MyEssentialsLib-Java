
package br.com.elieldepaula.essentials.hibernatedao;

import java.io.Serializable;
import java.util.List;

/**
 * Interface para o Dao genérico usando hibernate.
 * 
 * @since 0.1.0 24/08/2016
 * @author Eliel de Paula <dev@elieldepaula.com.br>
 * @param <T> Classe objeto da entidade.
 */
public interface GenericHibernateDaoInterface<T> {

    void delete(T obj);

    List<T> findByField(String fieldName, Serializable fieldValue);

    T getById(Serializable id);

    List<T> getList();

    List<T> getPagedList(int inic, int qtde);

    void insert(T obj);

    void saveOrUpdate(T obj);

    void update(T obj);
    
}
