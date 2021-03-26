package com.duran.assignment.controller;

import com.duran.assignment.models.PrimeCheckerAnswer;
import com.duran.assignment.models.PrimeCheckerForm;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class CheckerController {

    @RequestMapping(value = "/checker", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public PrimeCheckerAnswer checkPrimeNumber(@Valid PrimeCheckerForm primeCheckerForm, BindingResult bindingResult) {
        return new PrimeCheckerAnswer(false);
    }

}
