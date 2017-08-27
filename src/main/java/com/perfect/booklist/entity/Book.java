package com.perfect.booklist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ISBN
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
