package com.perfect.booklist.dao.impl;

import com.perfect.booklist.dao.IUserDao;
import com.perfect.booklist.entity.User;
import org.hibernate.NonUniqueResultException;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

/**
 * Created by Zloy on 26.08.2017.
 */
@Repository
public class UserDaoImp extends  BaseDaoImp <User>  implements IUserDao {

    @Override
    public User getByLogin(String login) {
        try {
            TypedQuery<User> query = getSessionFactory().getCurrentSession().createQuery("select u from User u where u.login = :login", User.class);
            query.setParameter("login", login);
            return query.getSingleResult();
        }catch (NonUniqueResultException e){
            return null;
        }
    }
}
