package com.perfect.booklist.entity;

import com.perfect.booklist.constant.Roles;

import javax.persistence.*;
import java.util.UUID;

/**
 * Created by Zloy on 24.08.2017.
 */

@Entity
@Table(name = "user_roles")
public class RoleUser extends IdEntity{

    @Column(name="users_id")
    private UUID usersId;

    @Column(name = "role_id")
    @Convert(converter = Roles.RolesConverter.class)
    private Roles role;

    public UUID getUsersId() {
        return usersId;
    }

    public void setUsersId(UUID usersId) {
        this.usersId = usersId;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
