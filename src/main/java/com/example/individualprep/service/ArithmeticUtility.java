package com.example.individualprep.service;

import org.springframework.stereotype.Service;

@Service
public class ArithmeticUtility {

    public double add(double o1, double o2) {
        return o1 + o2;
    }

    public double subtract(double o1, double o2) {
        return o1 - o2;
    }

    public double multiply(double o1, double o2) {
        return o1 * o2;
    }

    public double divide(double o1, double o2) {
        // TODO: Implement me properly!
        return 0.0;
    }

    public double exponent(double o1, int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative");
        }

        double result = 1.0;
        double base = o1;
        int exp = n;

        while (exp > 0) {
            if ((exp & 1) == 1) {   // if exp is odd
                result *= base;
            }
            base *= base;
            exp >>= 1;              // divide exp by 2
        }

        return result;
    }
}
