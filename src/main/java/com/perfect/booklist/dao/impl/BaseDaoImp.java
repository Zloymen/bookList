package com.perfect.booklist.dao.impl;


import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Zloy on 26.08.2017.
 */

@Repository
public abstract class BaseDaoImp <T> {

    /*@Autowired
    private SessionFactory sessionFactory;*/

    @PersistenceContext
    private EntityManager em;

    private Class<T> entityClass;

/*    protected Class<T> getEntityClass() {
        if (entityClass == null) {
            //only works if one extends DomainEntity, we will take care of it with CDI
            ParameterizedType genericSuperClass;
            if (getClass().getGenericSuperclass() instanceof ParameterizedType) {
                genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
            } else {
                genericSuperClass = (ParameterizedType) getClass().getSuperclass().getGenericSuperclass();
            }
            entityClass = (Class) genericSuperClass.getActualTypeArguments()[0];
        }
        return entityClass;
    }*/

    protected BaseDaoImp(){
        this.entityClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }


    public T merge(final T entity) {
        return (T) em.merge(entity);
    }

    public void delete(final T entity) {
        em.remove(entity);
    }

    public void delete(Serializable id) {
        T entity = fetchById(id);
        delete(entity);
    }

    public List<T> fetchAll() {
        return em.createQuery(" FROM "+ entityClass.getName(), entityClass).getResultList();
    }

    public List<T> fetchAll(String query) {
        return em.createNativeQuery(query, entityClass).getResultList();
    }

    public T fetchById(Serializable id) {
        return em.find(entityClass, id);
    }

    public EntityManager getEm() {
        return em;
    }

    /*public SessionFactory getSessionFactory() {
        return sessionFactory;
    }*/
}

