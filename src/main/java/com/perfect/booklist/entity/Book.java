package com.perfect.booklist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by admin on 25.08.2017.
 */
@Entity
@Table(name = "book_list")
public class Book extends IdEntity{
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private Integer year;

}
