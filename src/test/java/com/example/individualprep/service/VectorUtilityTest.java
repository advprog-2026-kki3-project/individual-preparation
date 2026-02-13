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
    void testSubtractSuccess() {
        double[] v1 = {5.0, 10.0, 15.0};
        double[] v2 = {2.0, 4.0, 6.0};
        double[] expected = {3.0, 6.0, 9.0};

        assertArrayEquals(expected, vectorUtility.subtract(v1, v2), 0.0001);
    }

    @Test
    void testSubtractWithNegatives() {
        double[] v1 = {1.0, -2.0, 3.0};
        double[] v2 = {-1.0, 2.0, -3.0};
        double[] expected = {2.0, -4.0, 6.0};

        assertArrayEquals(expected, vectorUtility.subtract(v1, v2), 0.0001);
    }

    @Test
    void testSubtractThrowsExceptionOnNullV1() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.subtract(null, new double[]{1.0});
        });
        assertEquals("Vectors must be non-null and of the same dimension.", exception.getMessage());
    }

    @Test
    void testSubtractThrowsExceptionOnNullV2() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.subtract(new double[]{1.0}, null);
        });
        assertEquals("Vectors must be non-null and of the same dimension.", exception.getMessage());
    }

    @Test
    void testSubtractThrowsExceptionOnMismatchedDimensions() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtility.subtract(new double[]{1.0, 2.0}, new double[]{1.0});
        });
        assertEquals("Vectors must be non-null and of the same dimension.", exception.getMessage());
    }

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
