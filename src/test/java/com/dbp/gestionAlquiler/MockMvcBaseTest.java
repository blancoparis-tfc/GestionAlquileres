package com.dbp.gestionAlquiler;

import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Clase base para pruebas de controladores con MockMvc.
 * 
 * Esta clase extiende SpringBootBaseTest y está configurada con @AutoConfigureMockMvc
 * para proporcionar un entorno de pruebas para controladores Spring MVC sin necesidad
 * de un servidor web real.
 * 
 * MockMvc permite simular peticiones HTTP y verificar las respuestas de los
 * controladores de forma aislada, lo que es ideal para pruebas unitarias de
 * endpoints REST.
 * 
 * La anotación @AutoConfigureMockMvc configura automáticamente el bean MockMvc
 * que se inyecta mediante @Autowired para que esté disponible en todas las clases
 * que hereden de esta clase base.
 * 
 * Esta clase es abstracta y está diseñada para ser extendida por otras clases de prueba
 * que necesitan probar controladores Spring MVC con el framework de pruebas MockMvc.
 */
@AutoConfigureMockMvc
public abstract class MockMvcBaseTest extends SpringBootBaseTest {

    @Autowired
    protected MockMvc mockMvc;
}