package com.dbp.gestionAlquiler.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;



@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureRestTestClient

public class StatusControllerTests {
    @Autowired
    private RestTestClient restTestClient;

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