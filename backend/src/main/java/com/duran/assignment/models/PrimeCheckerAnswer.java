package com.duran.assignment.models;

/**
 * DTO representing a server answer containing:
 * <ul>
 * <li>'isPrime'; A boolean
 * </ul>
 * <p>
 *
 * @author Timothée Duran
 */
public final class PrimeCheckerAnswer {

    private final Boolean isPrime;

    /**
     * PrimeCheckerAnswer convenience constructor given a boolean indicating if a number is prime or not.
     *
     * @param  isPrime  a boolean indicating if a number is prime or not
     */
    public PrimeCheckerAnswer(Boolean isPrime) {
        this.isPrime = isPrime;
    }

    public Boolean getIsPrime() {
        return isPrime;
    }

}
