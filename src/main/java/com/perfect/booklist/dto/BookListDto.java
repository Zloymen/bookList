package com.perfect.booklist.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.perfect.booklist.entity.Book;

import java.util.List;

import static com.perfect.booklist.constant.MessageOk.SUCCESS;

/**
 * Created by Zloy on 03.09.2017.
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookListDto extends ResponseDto {

    private List<Book> list;


    public List<Book> getList() {
        return list;
    }

    public void setList(List<Book> list) {
        this.list = list;
    }

    public BookListDto(){}

    public BookListDto(List<Book> list){
        super(false, SUCCESS);
        this.list = list;
    }

}
