package com.example.individualprep.controller;

import com.example.individualprep.controller.ArithmeticController;
import com.example.individualprep.service.ArithmeticUtility;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class ArithmeticControllerTest {

    private MockMvc mockMvc;

    private static final String baseUrl = "/api/arithmetic";

    @BeforeEach
    void setUp() {
        ArithmeticUtility service = new ArithmeticUtility();
        ArithmeticController controller = new ArithmeticController(service);

        mockMvc = MockMvcBuilders
                .standaloneSetup(controller)
                .build();
    }

    @Test
    void testMultiplyEndpoint() throws Exception {

        String jsonRequest = """
        {
            "operand1": 5,
            "operand2": 4
        }
        """;

        mockMvc.perform(post(baseUrl + "/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonRequest))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(20.0));
    }
}
