package com.perfect.booklist.service;

import com.perfect.booklist.dto.BookMarkDto;
import com.perfect.booklist.entity.Book;
import com.perfect.booklist.entity.Bookmark;

import java.util.List;

/**
 * Created by Zloy on 26.08.2017.
 */
public interface IBookService {
    List<Book> getAllBook();
    void saveBookMark(BookMarkDto dto);
    List<Bookmark> getUserBookMark();

}
