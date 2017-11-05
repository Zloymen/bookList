package com.perfect.booklist.entity;

import javax.persistence.*;

/**
 * Created by admin on 25.08.2017.
 */

@Entity
@Table(name = "bookmarks")
public class Bookmark extends IdEntity {

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "date_create")
    private Long dateCreate;

    @Column(name = "date_delete")
    private Long dateDelete;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Long dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Long getDateDelete() {
        return dateDelete;
    }

    public void setDateDelete(Long dateDelete) {
        this.dateDelete = dateDelete;
    }

    @PrePersist
    public void prePersist(){
        dateCreate = System.currentTimeMillis();
    }
}
