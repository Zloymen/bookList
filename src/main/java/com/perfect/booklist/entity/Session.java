package com.perfect.booklist.entity;

import javax.persistence.*;

/**
 * Created by admin on 28.08.2017.
 */
@Entity
@Table(name = "active_session")
public class Session {
    @Id
    @Column(name = "series_id")
    private String seriesId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private String token;

    @Column(name = "last_used")
    private Long lastUsed;

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Long lastUsed) {
        this.lastUsed = lastUsed;
    }
}
