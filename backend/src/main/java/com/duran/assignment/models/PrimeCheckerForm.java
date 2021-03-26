package com.duran.assignment.models;

import javax.validation.constraints.NotNull;

public class PrimeCheckerForm {

    @NotNull
    private Integer number;

    public PrimeCheckerForm(@NotNull Integer number) {
        this.number = number;
    }

    public Integer getNumber() {
        return number;
    }

}
