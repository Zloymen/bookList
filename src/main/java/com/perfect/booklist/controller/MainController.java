package com.perfect.booklist.controller;

import com.perfect.booklist.constant.MessageError;
import com.perfect.booklist.constant.MessageOk;
import com.perfect.booklist.dto.BookListDto;
import com.perfect.booklist.dto.ResponseDto;
import com.perfect.booklist.dto.UserDto;
import com.perfect.booklist.entity.Book;
import com.perfect.booklist.service.IBookService;
import com.perfect.booklist.service.IUserService;
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

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home() {
        LOGGER.debug("Open main!");
        return "index";
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDto getAllBooks() {
        try{
            return new BookListDto(bookService.getAllBook());
        }catch(Exception e){
            LOGGER.error("errror getAllBooks", e);
            return new ResponseDto(true, MessageError.STANDART_ERROR_MESSAGE);
        }
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    @ResponseBody
    public ResponseDto registration(UserDto user) {
        try{
            userService.createUser(user);
            return new ResponseDto(false, MessageOk.CREATE_NEW_USER);
        }catch (Exception e){
            LOGGER.error("create user error:", e);
        }
        return new ResponseDto(true, MessageError.STANDART_ERROR_MESSAGE);
    }
}