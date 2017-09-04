package com.perfect.booklist.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.perfect.booklist.dto.UserDto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by Zloy on 24.08.2017.
 */
@Entity
@Table(name="users")
public class User extends IdEntity {

    @Column
    private String login;
    @JsonIgnore
    @Column
    private String password;
    @Column
    private String email;

/*    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Bookmark> bookmarks;*/

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

    public User(String login, String password, String email) {
        if(this.getId() == null) this.setId(UUID.randomUUID());
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User() {
    }

    public User(UserDto userDto) {
        if(this.getId() == null) this.setId(UUID.randomUUID());
        this.login = userDto.getLogin();
        this.password = userDto.getPassword();
        this.email = userDto.getEmail();
    }

    /*    public List<Bookmark> getBookmarks() {
        return bookmarks;
    }

    public void setBookmarks(List<Bookmark> bookmarks) {
        this.bookmarks = bookmarks;
    }*/
}
