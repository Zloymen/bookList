package com.perfect.booklist.service.impl;

import com.perfect.booklist.constant.MessageError;
import com.perfect.booklist.dao.IUserDao;
import com.perfect.booklist.dto.UserDto;
import com.perfect.booklist.entity.User;
import com.perfect.booklist.exception.AppException;
import com.perfect.booklist.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Zloy on 02.09.2017.
 */

@Service
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    public void createUser(UserDto userDto){
        User user = userDao.getByLogin(userDto.getLogin());
        if(user != null) throw new AppException(MessageError.USER_EXISTS);
        userDao.save(new User(userDto));
    }

    public User getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null) return null;
        String login = authentication.getName();
        return userDao.getByLogin(login);
    }
}
