package com.perfect.booklist.dao.impl;

import com.perfect.booklist.dao.IBookmarkDao;
import com.perfect.booklist.entity.Book;
import com.perfect.booklist.entity.Bookmark;
import com.perfect.booklist.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Zloy on 03.09.2017.
 */
@Repository
public class BookmarkDaoImpl extends BaseDaoImp<Bookmark> implements IBookmarkDao {

    public void save(Bookmark bookmark){
        merge(bookmark);
    }

    public List<Bookmark> getMark(Book book, User user){
        TypedQuery<Bookmark> query = getEm().createQuery("select b from Bookmark b where b.user =:user and b.book = :book", Bookmark.class);

        return query.setParameter("user", user).setParameter("book", book).getResultList();
    }

    private static final String SELECT_BOOKMARK = "select b from Bookmark b where b.user =:user ";

    @Override
    public List<Bookmark> getMarkByUser(User user, boolean isDeleted) {

        TypedQuery<Bookmark> query = getEm().createQuery(SELECT_BOOKMARK + (isDeleted ? "" : "and b.dateDelete is null"), Bookmark.class);

        return query.setParameter("user", user).getResultList();
    }
}
