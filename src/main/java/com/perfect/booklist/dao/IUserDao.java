package com.perfect.booklist.dao;

import com.perfect.booklist.entity.User;

/**
 * Created by Zloy on 26.08.2017.
 */
public interface IUserDao {

    User getByLogin(String login);
    User save(User user);
}
