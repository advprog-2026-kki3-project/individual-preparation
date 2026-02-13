package com.example.individualprep.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticUtilityTest {

    private final ArithmeticUtility service = new ArithmeticUtility();

    @Test
    void multiplyPositiveNumbers() {
        assertEquals(15.0, service.multiply(3,5));
    }

    @Test
    void multiplyByZero() {
        assertEquals(0.0, service.multiply(10,0));
    }

    @Test
    void multiplyNegativeNumbers() {
        assertEquals(-20.0, service.multiply(-4,5));
    }

    @Test
    void multiplyDecimalNumbers() {
        assertEquals(7.5, service.multiply(2.5,3), 0.0001);
    }



}
