package com.perfect.booklist.dao.impl;

import com.perfect.booklist.dao.IUserDao;
import com.perfect.booklist.entity.User;
import org.hibernate.NonUniqueResultException;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 * Created by Zloy on 26.08.2017.
 */
@Repository
public class UserDaoImp extends  BaseDaoImp <User>  implements IUserDao {

    @Override
    public User getByLogin(String login) {
        try {
            TypedQuery<User> query = getEm().createQuery("select u from User u where u.login = :login", User.class);
            query.setParameter("login", login);
            return query.getSingleResult();
        }catch (NonUniqueResultException | NoResultException e){
            return null;
        }
    }

    @Override
    public User save(User user){
        return merge(user);
    }


}
