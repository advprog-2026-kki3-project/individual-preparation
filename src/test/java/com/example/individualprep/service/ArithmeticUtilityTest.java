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
  
    @Test
    void multiplyPositiveNumbers() {
        assertEquals(15.0, arithmeticUtility.multiply(3,5));
    }

    @Test
    void multiplyByZero() {
        assertEquals(0.0, arithmeticUtility.multiply(10,0));
    }

    @Test
    void multiplyNegativeNumbers() {
        assertEquals(-20.0, arithmeticUtility.multiply(-4,5));
    }

    @Test
    void multiplyDecimalNumbers() {
        assertEquals(7.5, arithmeticUtility.multiply(2.5,3), 0.0001);
    }
}
