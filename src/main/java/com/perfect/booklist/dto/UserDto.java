package com.perfect.booklist.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by Zloy on 02.09.2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
    private String login;

    private String email;

    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return new BCryptPasswordEncoder().encode(password);
    }

    public String getRealPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
