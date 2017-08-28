package com.perfect.booklist.dao;

import com.perfect.booklist.entity.Session;
import com.perfect.booklist.entity.User;

/**
 * Created by admin on 28.08.2017.
 */
public interface ISessionDao {
    Session save(Session session);
    Session getSession(String id);
    void deleteByUser(User user);
}
