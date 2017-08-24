package com.perfect.booklist.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * Created by Zloy on 24.08.2017.
 */
@Entity
@Table(name="users")
public class User  {

    @Id
    @Column
    private UUID id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String email;

}
