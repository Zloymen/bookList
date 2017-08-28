package com.perfect.booklist.dao.impl;

import com.perfect.booklist.dao.ISessionDao;
import com.perfect.booklist.entity.Session;
import com.perfect.booklist.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by admin on 28.08.2017.
 */
@Repository
public class SessionDaoImp extends BaseDaoImp<Session> implements ISessionDao {

    public Session save(Session session){
        return merge(session);
    }

    public Session getSession(String id){
        return fetchById(id);
    }

    public void deleteByUser(User user){
        TypedQuery<Session> query = getSessionFactory().getCurrentSession().createQuery("select s from Session s where s.user = :user", Session.class);
        query.setParameter("user", user);
        List<Session> sessions = query.getResultList();
        for(Session ss: sessions){
            delete(ss);
        }
    }


}
