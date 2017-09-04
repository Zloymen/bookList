package com.perfect.booklist.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.perfect.booklist.constant.MessageOk;

/**
 * Created by Zloy on 04.09.2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ObjectDto <T> extends ResponseDto {
    private T object;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public ObjectDto(T object) {
        super(false, MessageOk.SUCCESS);
        this.object = object;
    }
}
