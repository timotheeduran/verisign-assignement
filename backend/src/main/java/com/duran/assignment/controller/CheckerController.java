package com.duran.assignment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckerController {

    @GetMapping("/checker")
    public String hello(@RequestParam(value = "number", defaultValue = "0") String number) {
        return String.format("%s", number);
    }

}
