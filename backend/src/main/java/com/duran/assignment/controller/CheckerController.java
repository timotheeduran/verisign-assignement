package com.duran.assignment.controller;

import com.duran.assignment.models.PrimeCheckerAnswer;
import com.duran.assignment.models.PrimeCheckerForm;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.stream.IntStream;

/**
 * Controller responsible for handling API routes related to prime numbers.
 *
 * @author Timothée Duran
 */
@RestController
public class CheckerController {

    /**
     * POST route receiving a number and answering whether the given number is prime or not.
     *
     * @param  form  the received form DTO
     */
    @PostMapping(
            value = "/checker",
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public PrimeCheckerAnswer checkPrimeNumber(@RequestBody PrimeCheckerForm form) {
        int number = form.getNumber();
        boolean isPrime = number > 1 && IntStream.rangeClosed(2, (int) Math.sqrt(number)).noneMatch(n -> (number % n == 0));
        return new PrimeCheckerAnswer(isPrime);
    }

}
