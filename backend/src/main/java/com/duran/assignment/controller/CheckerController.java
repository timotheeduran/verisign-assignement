package com.duran.assignment.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckerController {

    @RequestMapping("/")
    public String hello()
    {
        return "Hello World";
    }

}
