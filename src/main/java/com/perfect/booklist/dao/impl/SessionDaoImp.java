package com.perfect.booklist.dao.impl;

import com.perfect.booklist.dao.ISessionDao;
import com.perfect.booklist.entity.Session;
import org.springframework.stereotype.Repository;

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

}
