package com.perfect.booklist.service;

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
    @Override
    public void createNewToken(PersistentRememberMeToken persistentRememberMeToken) {

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

