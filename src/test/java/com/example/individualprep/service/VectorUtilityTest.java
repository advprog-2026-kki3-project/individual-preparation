package com.example.individualprep.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class VectorUtilityTest {

    private VectorUtility vectorUtility;

    @BeforeEach
    void setUp() {
        vectorUtility = new VectorUtility();
    }

    @Test
    void multiplyVectorNormally() {
        double[] result = vectorUtility.multiply(new double[]{1,2,3}, 2);
        assertArrayEquals(new double[]{2,4,6}, result);
    }

    @Test
    void multiplyVectorByZero() {
        double[] result = vectorUtility.multiply(new double[]{5,7,9}, 0);
        assertArrayEquals(new double[]{0,0,0}, result);
    }

    @Test
    void multiplyVectorNegativeScalar() {
        double[] result = vectorUtility.multiply(new double[]{1,-2,3}, -2);
        assertArrayEquals(new double[]{-2,4,-6}, result);
    }

    @Test
    void multiplyInvalidVectorSize() {
        assertThrows(IllegalArgumentException.class,
                () -> vectorUtility.multiply(new double[]{1,2}, 2));
    }

    @Test
    void multiplyNullVector() {
        assertThrows(IllegalArgumentException.class,
                () -> vectorUtility.multiply(null, 2));
    }
}
