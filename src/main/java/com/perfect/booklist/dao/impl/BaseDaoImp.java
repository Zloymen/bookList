package com.perfect.booklist.dao.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Zloy on 26.08.2017.
 */

@Repository
public abstract class BaseDaoImp <T> {

    @Autowired
    private SessionFactory sessionFactory;

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


    public Serializable merge(final T entity) {
        return (Serializable) sessionFactory.getCurrentSession().merge(entity);
    }

    public void delete(final T entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    public void delete(Serializable id) {
        T entity = fetchById(id);
        delete(entity);
    }

    public List<T> fetchAll() {
        return sessionFactory.getCurrentSession().createQuery(" FROM "+ entityClass.getName()).list();
    }

    public List<T> fetchAll(String query) {
        return sessionFactory.getCurrentSession().createNativeQuery(query).list();
    }

    public T fetchById(Serializable id) {
        return sessionFactory.getCurrentSession().get(entityClass, id);
    }
}

