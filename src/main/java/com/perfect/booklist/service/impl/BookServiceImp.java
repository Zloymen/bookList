package com.perfect.booklist.service.impl;

import com.perfect.booklist.dao.IBookDao;
import com.perfect.booklist.entity.Book;
import com.perfect.booklist.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

/**
 * Created by Zloy on 26.08.2017.
 */
@Service
@Transactional
public class BookServiceImp implements IBookService {

    @Autowired
    private IBookDao bookDao;

    @Override
    public List<Book> getAllBook() {
        return bookDao.fetchAll();
    }
}
