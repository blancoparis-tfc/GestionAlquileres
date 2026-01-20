package com.dbp.gestionAlquiler.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest

public class StatusControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testStatusControllerIsAvailable() throws Exception {
        mockMvc.perform(get("/api/status"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.nombre").exists())
                .andExpect(jsonPath("$.version").exists())
                .andExpect(jsonPath("$.status").value("OPERATIONAL"));
    }

    @Test
    public void testDatabaseConnectivityCheck() throws Exception {
        mockMvc.perform(get("/api/status"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.db_check").value(true));
    }
}