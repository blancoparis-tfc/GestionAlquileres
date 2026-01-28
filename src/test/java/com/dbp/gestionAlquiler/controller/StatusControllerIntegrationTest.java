package com.dbp.gestionAlquiler.controller;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Prueba de integración para el controlador StatusController.
 * 
 * Esta clase extiende MockMvcBaseTest y está configurada para probar
 * el endpoint /api/status utilizando el framework de pruebas MockMvc.
 * 
 * Las pruebas verifican que:
 * - El endpoint responda con estado 200 OK
 * - La respuesta tenga el formato JSON correcto
 * - Los campos nombre, version y status estén presentes con valores válidos
 * - El campo db_check indique correctamente la conectividad a la base de datos
 */
public class StatusControllerIntegrationTest extends com.dbp.gestionAlquiler.MockMvcBaseTest {

    /**
     * Prueba que verifica la disponibilidad del controlador StatusController.
     * 
     * Esta prueba asegura que el endpoint /api/status esté disponible y
     * responda con un código HTTP 200 (OK).
     */
    @Test
    public void testStatusControllerIsAvailable() throws Exception {
        mockMvc.perform(get("/api/status"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.nombre").exists())
                .andExpect(jsonPath("$.version").exists())
                .andExpect(jsonPath("$.status").value("OPERATIONAL"));
    }

    /**
     * Prueba que verifica la conectividad a la base de datos.
     * 
     * Esta prueba asegura que el campo db_check en la respuesta
     * indique correctamente que la base de datos está conectada.
     */
    @Test
    public void testDatabaseConnectivityCheck() throws Exception {
        mockMvc.perform(get("/api/status"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.db_check").value(true));
    }
}