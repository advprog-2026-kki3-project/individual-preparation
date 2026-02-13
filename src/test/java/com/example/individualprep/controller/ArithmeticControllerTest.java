package com.example.individualprep.controller;

import com.example.individualprep.dto.ArithmeticRequest;
import com.example.individualprep.dto.ArithmeticResponse;
import com.example.individualprep.service.ArithmeticUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArithmeticControllerTest {

    private ArithmeticController arithmeticController;

    @BeforeEach
    void setUp() {
        ArithmeticUtility arithmeticUtility = new ArithmeticUtility();
        arithmeticController = new ArithmeticController(arithmeticUtility);
    }

    @Test
    void testDivideEndpoint() {
        ArithmeticRequest request = new ArithmeticRequest(10.0, 2.0, null);
        ResponseEntity<ArithmeticResponse> response = arithmeticController.divide(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(5.0, response.getBody().result(), 0.0001);
    }
}