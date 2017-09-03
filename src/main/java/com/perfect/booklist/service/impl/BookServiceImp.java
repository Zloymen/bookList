package com.perfect.booklist.service.impl;

import com.perfect.booklist.dao.IBookDao;
import com.perfect.booklist.dao.IBookmarkDao;
import com.perfect.booklist.dto.BookMarkDto;
import com.perfect.booklist.entity.Book;
import com.perfect.booklist.entity.Bookmark;
import com.perfect.booklist.entity.User;
import com.perfect.booklist.exception.AppException;
import com.perfect.booklist.service.IBookService;
import com.perfect.booklist.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.perfect.booklist.constant.MessageError.*;

/**
 * Created by Zloy on 26.08.2017.
 */
@Service
@Transactional
public class BookServiceImp implements IBookService {

    @Autowired
    private IBookDao bookDao;
    @Autowired
    private IBookmarkDao bookmarkDao;

    @Autowired
    private IUserService userService;

    @Override
    public List<Book> getAllBook() {
        return bookDao.fetchAll();
    }

    public void saveBookMark(BookMarkDto dto){
        Bookmark bookmark = null;
        User currentUser = userService.getCurrentUser();
        if(currentUser == null) throw new AppException(USER_NOT_FOUNT);
        Book book = bookDao.fetchById(dto.getId());
        if(book == null) throw new AppException(BOOK_NOT_FOUNT);
        List<Bookmark> resultList = bookmarkDao.getMark(book, currentUser);
        Optional<Bookmark> optional = resultList.stream().filter(item -> item.getDateDelete() == null).findFirst();
        if(dto.getFavorite()){

            if(optional.isPresent()) throw new AppException(BOOKMARK_EXISTS);
            bookmark = new Bookmark();
            bookmark.setBook(book);
            bookmark.setUser(currentUser);
            bookmark.setDateCreate(System.currentTimeMillis());
            bookmark.setId(UUID.randomUUID());
        }else{
            if(!optional.isPresent()) throw new AppException(BOOKMARK_NOT_FOUNT);
            bookmark = optional.get();
            bookmark.setDateDelete(System.currentTimeMillis());
        }

        bookmarkDao.save(bookmark);
    }
}
