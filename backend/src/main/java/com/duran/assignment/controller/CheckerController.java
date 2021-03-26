package com.duran.assignment.controller;

import com.duran.assignment.models.PrimeCheckerForm;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class CheckerController {

    @PostMapping("/checker")
    public String checkPrimeNumber(@Valid PrimeCheckerForm primeCheckerForm, BindingResult bindingResult) {
        return String.format("Hello world");
    }

}
