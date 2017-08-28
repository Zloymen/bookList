package com.perfect.booklist.service.impl;

import com.perfect.booklist.dao.ISessionDao;
import com.perfect.booklist.dao.IUserDao;
import com.perfect.booklist.entity.Session;
import com.perfect.booklist.entity.User;
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

    @Autowired
    private IUserDao userDao;

    @Override
    public void createNewToken(PersistentRememberMeToken token) {
        Session newSession = new Session();
        User user = userDao.getByLogin(token.getUsername());
        if(user == null) return;
        newSession.setUser(user);
        newSession.setSeriesId(token.getSeries());
        newSession.setToken(token.getTokenValue());
        newSession.setLastUsed(token.getDate().getTime());
        sessionDao.save(newSession);
    }

    @Override
    public void updateToken(String seriesId, String tokenValue, Date lastUsed) {
        Session session = sessionDao.getSession(seriesId);

        session.setToken(tokenValue);
        session.setLastUsed(lastUsed.getTime());

        sessionDao.save(session);
    }

    @Override
    public PersistentRememberMeToken getTokenForSeries(String seriesId) {
        Session session = sessionDao.getSession(seriesId);

        if(session == null) return null;

        return new PersistentRememberMeToken(session.getUser().getLogin(), session.getSeriesId(),  session.getToken(), new Date(session.getLastUsed()));
    }

    @Override
    public void removeUserTokens(String login) {
        User user = userDao.getByLogin(login);
        if (user == null) return;
        sessionDao.deleteByUser(user);
    }
}

