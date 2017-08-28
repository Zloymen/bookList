package com.perfect.booklist.service;

import com.perfect.booklist.dao.ISessionDao;
import com.perfect.booklist.entity.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.rememberme.PersistentRememberMeToken;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Zloy on 27.08.2017.
 */
@Repository("tokenRepositoryDao")
@Transactional
public class TokenServiceImp implements PersistentTokenRepository {

    @Autowired
    private ISessionDao sessionDao;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        Session newSession = new Session();
/*        persistentLogin.setUsername(token.getUsername());
        newSession.setSeries(token.getSeries());
        newSession.setToken(token.getTokenValue());
        newSession.setLast_used(token.getDate());*/
        sessionDao.save(newSession);
    }

    @Override
    public void updateToken(String seriesId, String tokenValue, Date lastUsed) {

    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        return null;
    }

    @Override
    public void removeUserTokens(String user) {

    }
}

