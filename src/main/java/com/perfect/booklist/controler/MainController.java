package com.perfect.booklist.controler;

import com.perfect.booklist.entity.Book;
import com.perfect.booklist.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Zloy on 26.08.2017.
 */

@Controller
@RequestMapping("/")
public class MainController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private IBookService bookService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        LOGGER.debug("Open main!");
        return "index";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public List<Book> getAllBooks() {
        return bookService.getAllBook();
    }
}