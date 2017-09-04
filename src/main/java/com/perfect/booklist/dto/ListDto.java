package com.perfect.booklist.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

import static com.perfect.booklist.constant.MessageOk.SUCCESS;

/**
 * Created by Zloy on 03.09.2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class ListDto <T> extends ResponseDto {

    private List<T> list;


    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public ListDto(){}

    public ListDto(List<T> list){
        super(false, SUCCESS);
        this.list = list;
    }

}
