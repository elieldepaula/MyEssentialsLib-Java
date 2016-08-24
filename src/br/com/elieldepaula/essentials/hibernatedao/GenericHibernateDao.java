
package br.com.elieldepaula.essentials.hibernatedao;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * Esta classe fornece os métodos necessários para um DAO genérico usando Hibernate.
 * 
 * @since 0.1.0 24/08/2016
 * @author Eliel de Paula <dev@elieldepaula.com.br>
 * @param <T> Classe objeto da entidade.
 */
public class GenericHibernateDao<T> implements GenericHibernateDaoInterface<T> {
    
    private final Session session;
    private Transaction transaction;
    private final Class classe;
    
    public GenericHibernateDao(Class<T> classe){
        this.classe = classe;
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    }
    
    @Override
    public void saveOrUpdate(T obj){
        transaction = session.beginTransaction();
        this.session.saveOrUpdate(obj);
        transaction.commit();
    }
    
    @Override
    public void insert(T obj){
        transaction = session.beginTransaction();
        this.session.save(obj);
        transaction.commit();
    }
    
    @Override
    public void update(T obj){
        transaction = session.beginTransaction();
        this.session.update(obj);
        transaction.commit();
    }
    
    @Override
    public void delete(T obj){
        transaction = session.beginTransaction();
        this.session.delete(obj);
        transaction.commit();
    }
    
    @Override
    public T getById(Serializable id){
        transaction = session.beginTransaction();
        Criteria criteria = this.session.createCriteria(classe);
        criteria.add(Restrictions.eq("id", id));
        T saida = (T) criteria.uniqueResult();
        transaction.commit();
        return saida;
    }
    
    @Override
    public List<T> findByField(String fieldName, Serializable fieldValue){
        transaction = session.beginTransaction();
        Criteria criteria = this.session.createCriteria(classe);
        criteria.add(Restrictions.like(fieldName, fieldValue));
        List<T> saida = criteria.list();
        transaction.commit();
        return saida;
    }
    
    @Override
    public List<T> getPagedList(int inic, int qtde){
        transaction = session.beginTransaction();
        Criteria criteria = this.session.createCriteria(classe);
        criteria.setFirstResult(inic);
        criteria.setMaxResults(qtde);
        List<T> saida = criteria.list();
        transaction.commit();
        return saida;
    }
    
    @Override
    public List<T> getList(){
        transaction = session.beginTransaction();
        Criteria criteria = this.session.createCriteria(classe);
        List<T> saida = criteria.list();
        transaction.commit();
        return saida;
    }
    
}