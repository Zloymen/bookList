package com.perfect.booklist.entity;


import javax.persistence.*;
import java.util.List;
import java.util.UUID;

/**
 * Created by Zloy on 24.08.2017.
 */
@Entity
@Table(name="users")
public class User extends IdEntity {

    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Bookmark> bookmarks;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }
}
