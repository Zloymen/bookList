package com.perfect.booklist.service;

import com.perfect.booklist.dto.UserDto;
import com.perfect.booklist.entity.User;

/**
 * Created by Zloy on 02.09.2017.
 */
public interface IUserService {

    void createUser(UserDto userDto);

    User getCurrentUser();
}
