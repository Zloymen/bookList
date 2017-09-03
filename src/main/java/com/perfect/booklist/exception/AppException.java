package com.perfect.booklist.exception;

import com.perfect.booklist.constant.IMessage;

/**
 * Created by Zloy on 02.09.2017.
 */
public class AppException extends RuntimeException {

    public AppException(IMessage message) {
        super(message.getMessage());
    }
}
