package com.perfect.booklist.service.impl;

import com.perfect.booklist.dao.IUserDao;
import com.perfect.booklist.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zloy on 24.08.2017.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserDao userDao;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        if(login.isEmpty()) throw new UsernameNotFoundException("Not user");
        User user = userDao.getByLogin(login);
        if(user == null) throw new UsernameNotFoundException("Not user");
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();
        //todo adding roles
        return authorities;
    }
}
