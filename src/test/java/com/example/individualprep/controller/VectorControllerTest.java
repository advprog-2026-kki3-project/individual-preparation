package com.example.individualprep.controller;

import com.example.individualprep.dto.VectorRequest;
import com.example.individualprep.dto.VectorResponse;
import com.example.individualprep.service.VectorUtility;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VectorControllerTest {

    private VectorController vectorController;

    @BeforeEach
    void setUp() {
        VectorUtility vectorUtility = new VectorUtility();
        vectorController = new VectorController(vectorUtility);
    }

    @Test
    void testSubtractEndpoint() {
        double[] v1 = {5.0, 10.0};
        double[] v2 = {2.0, 4.0};
        double[] expected = {3.0, 6.0};

        VectorRequest request = new VectorRequest(v1, v2, null);

        ResponseEntity<VectorResponse> response = vectorController.subtract(request);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertArrayEquals(expected, response.getBody().result(), 0.0001);
    }
}