package com.perfect.booklist.constant;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;

/**
 * Created by Zloy on 24.08.2017.
 */
public enum Roles {
    UNKNOWN(-1, "Неизвестная роль"),
    ADMIN(0, "Администратор"),
    USER(1, "Пользователь");

    private Integer roleId;
    private String name;

    public Integer getRoleId() {
        return roleId;
    }

    public String getName() {
        return name;
    }

    Roles(Integer id, String name){
        this.roleId = id;
        this.name = name;
    }

    public static Roles getRoleWithId(Integer roleId){
        return Arrays.stream(Roles.values()).filter(item -> item.getRoleId().equals(roleId == null ? -1 : roleId)).findFirst().orElse(UNKNOWN);
    }

    @Converter
    public static class RolesConverter implements AttributeConverter<Roles, Integer> {

        @Override
        public Integer convertToDatabaseColumn(Roles role) {
            return role == null ? null : role.getRoleId();
        }

        @Override
        public Roles convertToEntityAttribute(Integer roleId) {
            return Roles.getRoleWithId(roleId);
        }
    }
}
