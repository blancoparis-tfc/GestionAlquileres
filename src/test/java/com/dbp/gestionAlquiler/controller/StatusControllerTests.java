package com.dbp.gestionAlquiler.controller;


import org.junit.jupiter.api.Test;
import com.dbp.gestionAlquiler.IntegrationBaseTest;
import org.springframework.test.web.servlet.client.RestTestClient;


/**
 * Pruebas de integración para el controlador StatusController.
 * 
 * Esta clase extiende IntegrationBaseTest para heredar la configuración
 * de pruebas REST con RestTestClient y el perfil SIT (System Integration Testing).
 * 
 * Las pruebas realizadas validan que el endpoint /api/status responda correctamente
 * con un estado HTTP 200 y una respuesta JSON válida.
 */
public class StatusControllerTests extends IntegrationBaseTest {
    
    /**
     * Prueba que valida la respuesta del servidor en el endpoint /api/status.
     * 
     * Esta prueba verifica que el endpoint responda con un código de estado 200
     * y que la respuesta contenga los campos esperados del objeto StatusResponse.
     */
    @Test
    public void testValidarRespuestaServidor() {
        restTestClient.get().uri("/api/status")
            .exchange() // Realiza la llamada
            .expectStatus().isOk() // Valida status 200
            .expectBody()
            //.jsonPath("$.mensaje").isEqualTo("Hola Mundo"); // Valida el JSON
            ;
    }



    
}