package com.perfect.booklist.controller;

import com.perfect.booklist.constant.MessageError;
import com.perfect.booklist.constant.MessageOk;
import com.perfect.booklist.dto.*;
import com.perfect.booklist.entity.User;
import com.perfect.booklist.exception.AppException;
import com.perfect.booklist.service.IBookService;
import com.perfect.booklist.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Zloy on 27.08.2017.
 */

@RestController
@RequestMapping("/authorize")
public class AuthorizeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizeController.class);

    @Autowired
    private IBookService bookService;

    @Autowired
    private IUserService userService;

    @RequestMapping(value="/test", method= RequestMethod.GET)
    @ResponseBody
    public Integer test(){
        return 1;
    }

    @RequestMapping(value="/whyAuthorize", method= RequestMethod.GET)
    @ResponseBody
    public String whyAutorize(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value="/favorite", method= RequestMethod.POST)
    @ResponseBody
    public ResponseDto favorite(BookMarkDto bookMarkDto){
        try{
            bookService.saveBookMark(bookMarkDto);
            return new ResponseDto(false, MessageOk.SUCCESS);
        }catch (AppException ex){
            LOGGER.error("AppException favorite", ex);
            return new ErrorDto(ex.getMessage());
        }catch (Exception e){
            LOGGER.error("Exception favorite", e);
            return new ErrorDto(MessageError.STANDART_ERROR_MESSAGE);
        }
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDto getAllBooks() {
        try{
            return new ListDto<>(bookService.getAllBook());
        }catch(Exception e){
            LOGGER.error("error getAllBooks", e);
            return new ErrorDto( MessageError.STANDART_ERROR_MESSAGE);
        }
    }

    @RequestMapping(value = "/bookmarks", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDto getAllBookMarks() {
        try{
            return new ListDto<>(bookService.getUserBookMark());
        }catch(Exception e){
            LOGGER.error("error bookmarks", e);
            return new ErrorDto( MessageError.STANDART_ERROR_MESSAGE);
        }
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDto getCurrentUser() {
        try{
            return new ObjectDto<User>(userService.getCurrentUser());
        }catch(Exception e){
            LOGGER.error("error getCurrentUser", e);
            return new ErrorDto( MessageError.STANDART_ERROR_MESSAGE);
        }
    }

    @RequestMapping(value = "/testTransaction", method = RequestMethod.GET)
    @ResponseBody
    public ResponseDto testTransaction(@RequestParam("param") Long param) {
        try{
            return new ListDto<>(bookService.testTransaction(param));
        }catch(Exception e){
            LOGGER.error("error getCurrentUser", e);
            return new ErrorDto( MessageError.STANDART_ERROR_MESSAGE);
        }
    }

}
