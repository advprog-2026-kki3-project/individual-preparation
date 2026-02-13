package com.example.individualprep.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArithmeticUtilityTest {

    private ArithmeticUtility arithmeticUtility;

    @BeforeEach
    void setUp() {
        arithmeticUtility = new ArithmeticUtility();
    }

    @Test
    void testDivideSuccess() {
        assertEquals(5.0, arithmeticUtility.divide(10.0, 2.0), 0.0001);
        assertEquals(-2.5, arithmeticUtility.divide(5.0, -2.0), 0.0001);
    }

    @Test
    void testDivideByZeroThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            arithmeticUtility.divide(10.0, 0.0);
        });
        assertEquals("Division by zero is not allowed.", exception.getMessage());
    }
}