package com.perfect.booklist.controller;

import com.perfect.booklist.constant.MessageError;
import com.perfect.booklist.constant.MessageOk;
import com.perfect.booklist.dto.BookMarkDto;
import com.perfect.booklist.dto.ResponseDto;
import com.perfect.booklist.exception.AppException;
import com.perfect.booklist.service.IBookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Zloy on 27.08.2017.
 */

@RestController
@RequestMapping("/authorize")
public class AuthorizeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorizeController.class);

    @Autowired
    private IBookService bookService;

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
            return new ResponseDto(true, ex.getMessage());
        }catch (Exception e){
            LOGGER.error("Exception favorite", e);
            return new ResponseDto(true, MessageError.STANDART_ERROR_MESSAGE);
        }
    }

}
