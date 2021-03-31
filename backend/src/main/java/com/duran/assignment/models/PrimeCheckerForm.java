package com.duran.assignment.models;

import javax.validation.constraints.NotNull;

/**
 * DTO representing a simple form containing:
 * <ul>
 * <li>'number'; An int
 * </ul>
 * <p>
 *
 * @author Timothée Duran
 */
public final class PrimeCheckerForm {

    @NotNull
    private final int number;

    /**
     * PrimeCheckerForm default constructor. Sets the number to 0.
     * Spring Boot requires a default constructor to work. (See https://stackoverflow.com/questions/48330613/objectmapper-cant-deserialize-without-default-constructor-after-upgrade-to-spri)
     */
    public PrimeCheckerForm()
    {
        super();
        this.number = 0;
    }

    /**
     * PrimeCheckerForm convenience constructor given any number.
     *
     * @param  number  any number
     */
    public PrimeCheckerForm(@NotNull int number) {
        super();
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

}
