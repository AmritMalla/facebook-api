package com.stech.social.app.facebook.api;

import com.restfb.types.User;
import com.stech.social.app.facebook.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserServiceImpl userService;


    @RequestMapping(value = "/getuser", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUser(){
        return userService.getUser();
    }

    @GetMapping(value = "/getPageAccess")
    public String getPageAccessToken(){
        return null;
    }
}


