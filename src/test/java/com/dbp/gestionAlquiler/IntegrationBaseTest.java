package com.dbp.gestionAlquiler;

import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.springframework.http.HttpEntity;

/**
 * Clase base para pruebas de integración de API REST con RestTestClient.
 * 
 * Esta clase extiende SpringBootBaseTest y está configurada con @AutoConfigureRestTestClient
 * para proporcionar un cliente de pruebas REST que permite realizar peticiones HTTP reales
 * a los endpoints de la aplicación durante las pruebas.
 * 
 * La anotación @AutoConfigureRestTestClient configura automáticamente un cliente
 * REST que puede ser utilizado para probar los endpoints REST de forma aislada y realista.
 * 
 * Esta clase inyecta TestRestTemplate como un atributo protegido para que las clases hijas
 * puedan utilizarlo directamente para realizar peticiones HTTP a los endpoints de la API.
 * 
 * También proporciona un método utilitario setupAuthHeaders(String token) para facilitar
 * la configuración de cabeceras de autenticación en peticiones protegidas.
 * 
 * Esta clase es abstracta y está diseñada para ser extendida por otras clases de prueba
 * que necesitan realizar pruebas de integración de endpoints REST con autenticación.
 */
@AutoConfigureRestTestClient
public abstract class IntegrationBaseTest extends SpringBootBaseTest {

    @Autowired
    protected RestTestClient restTestClient;

    /**
     * Configura las cabeceras HTTP para peticiones con autenticación.
     * 
     * @param token Token de autenticación JWT o similar
     * @return HttpEntity configurado con el token de autorización y content-type
     */
    protected HttpEntity<String> setupAuthHeaders(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        return new HttpEntity<>(headers);
    }

    /**
     * Configura las cabeceras HTTP para peticiones sin cuerpo.
     * 
     * @param token Token de autenticación JWT o similar
     * @return HttpHeaders configuradas con el token de autorización
     */
    protected HttpHeaders setupAuthHeadersOnly(String token) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        return headers;
    }
}