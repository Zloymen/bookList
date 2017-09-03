package com.perfect.booklist.constant;

/**
 * Created by Zloy on 02.09.2017.
 */
public enum MessageError implements IMessage {
    STANDART_ERROR_MESSAGE("Произошла ошибка, обратитесь в службу поддержки."),
    USER_EXISTS("Пользователь существует."),
    USER_NOT_FOUNT("Пользователь не найден."),
    BOOK_NOT_FOUNT("Книга не найдена."),
    BOOKMARK_EXISTS("Закладка уже есть."),
    BOOKMARK_NOT_FOUNT("Закладка не найдена.");

    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    MessageError(String message){
        this.message = message;
    }
}
