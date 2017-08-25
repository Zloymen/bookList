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
}
