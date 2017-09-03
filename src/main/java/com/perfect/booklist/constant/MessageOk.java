package com.perfect.booklist.constant;

/**
 * Created by Zloy on 02.09.2017.
 */
public enum MessageOk implements IMessage{
    CREATE_NEW_USER("Создан пользователь"),
    SUCCESS("Успешно")

    ;

    private String message;

    public String getMessage() {
        return message;
    }

    MessageOk(String message) {
        this.message = message;
    }
}
