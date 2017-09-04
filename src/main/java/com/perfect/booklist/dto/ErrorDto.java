package com.perfect.booklist.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.perfect.booklist.constant.IMessage;

/**
 * Created by Zloy on 05.09.2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorDto extends ResponseDto {
    public ErrorDto(IMessage message) {
        super(true, message);
    }

    public ErrorDto( String message) {
        super(true, message);
    }
}
