package com.perfect.booklist.dao;

import com.perfect.booklist.entity.Book;

import java.util.List;

/**
 * Created by Zloy on 26.08.2017.
 */
public interface IBookDao {
    List<Book> fetchAll();
}