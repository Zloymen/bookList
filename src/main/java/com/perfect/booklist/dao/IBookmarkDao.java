package com.perfect.booklist.dao;

import com.perfect.booklist.entity.Book;
import com.perfect.booklist.entity.Bookmark;
import com.perfect.booklist.entity.User;

import java.util.List;

/**
 * Created by Zloy on 03.09.2017.
 */
public interface IBookmarkDao {
    void save(Bookmark bookmark);
    List<Bookmark> getMark(Book book, User user);
}
