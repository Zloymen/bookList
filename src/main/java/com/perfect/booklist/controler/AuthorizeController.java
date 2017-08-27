package com.perfect.booklist.controler;

import org.springframework.stereotype.Controller;
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

    @RequestMapping(value="/test", method= RequestMethod.GET)
    @ResponseBody
    public Integer test(){
        return 1;
    }
}
