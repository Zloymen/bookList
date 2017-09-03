package com.perfect.booklist.dto;

import com.perfect.booklist.constant.IMessage;

/**
 * Created by Zloy on 02.09.2017.
 */
public class ResponseDto {

    private Boolean error;

    private String message;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseDto() {
    }

    public ResponseDto(Boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    public ResponseDto(Boolean error, IMessage message) {
        this.error = error;
        this.message = message.getMessage();
    }

}
