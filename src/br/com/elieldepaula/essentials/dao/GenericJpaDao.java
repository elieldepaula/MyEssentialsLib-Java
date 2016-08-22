
package br.com.elieldepaula.essentials.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Esta classe fornece os métodos para um DAO genérico usando JPA. Para que ela
 * funcione corretamente o arquivo de persistência deve ter o nome
 * de "PersistenceConfigPU"
 * 
 * @since 22/08/2016
 * @version 0.0.1
 * @author Eliel de Paula <dev@elieldepaula.com.br>
 */
public class GenericJpaDao<T extends EntityBase> {
    
    /**
     * EntityManager do JPA
     */
    protected EntityManager entityManager;
        
    public GenericJpaDao(){
        entityManager = getEntityManager();
    }
    
    /**
     * Recupera um Entity Manager do JPA.
     * @return EntityManager
     */
    private EntityManager getEntityManager(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceConfigPU");
        if(entityManager == null)
            entityManager = factory.createEntityManager();
        return entityManager;
    }
    
    /**
     * Este método retorna uma lista de resultados baseando-se em uma query HQL.
     * 
     * @param varQuery Query ex: "From Pessoas"
     * @return List
     */
    public List<T> listQuery(String varQuery){
        List<T> lista;
        try {
            Query q = entityManager.createQuery(varQuery);
            lista = q.getResultList();
        } catch (Exception e){
            lista = new ArrayList();
        } finally {
            entityManager.close();
        }
        return lista;
    }
    
    /**
     * Este método salva um registro em uma tabela do banco de dados, ele já resolve
     * se faz um novo ou atualiza (persist ou merge) automaticamente.
     * 
     * @param t Objeto
     * @return T Objeto
     * @throws Exception Erro caso não consiga atualizar (merge)
     */
    public T save(T t) throws Exception {
        try {
            entityManager.getTransaction().begin();
            if(t.getId() == null){
                entityManager.persist(t);
            } else {
                if(!entityManager.contains(t)){
                    if(entityManager.find(t.getClass(), t.getId()) == null){
                        throw new Exception("Erro ao atualizar!");
                    }
                }
                t = entityManager.merge(t);
            }
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
        return t;
    }
    
    /**
     * Remove/Exclui um registro no banco de dados.
     * 
     * @param cl Classe
     * @param id Id do registro
     */
    public void remove(Class<T> cl, Long id){
        T t = entityManager.find(cl, id);
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(t);
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
    
    /**
     * Este método retorna um registro consultando pelo Id.
     * 
     * @param cl Classe
     * @param id Id do registro
     * @return T Objeto
     */
    public T getById(Class<T> cl, Long id){
        T t = null;
        try {
            t = entityManager.find(cl, id);
        } finally {
            entityManager.close();
        }
        return t;
    }

}