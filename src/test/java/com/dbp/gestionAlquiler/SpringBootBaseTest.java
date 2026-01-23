package com.dbp.gestionAlquiler;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

/**
 * Clase base para pruebas de integración de Spring Boot.
 * 
 * Esta clase extiende BaseTest y está anotada con @SpringBootTest para
 * proporcionar configuración de Spring Boot necesaria para las pruebas de integración.
 * 
 * La anotación @ActiveProfiles("sit") asegura que las pruebas se ejecuten con el
 * perfil de configuración "sit" (SIT = System Integration Testing), lo que permite
 * usar una configuración de prueba específica sin afectar el entorno de desarrollo.
 * 
 * Esta clase es abstracta y está diseñada para ser extendida por otras clases de prueba
 * que necesitan funcionalidades de Spring Boot y configuración de perfil específico.
 */
@SpringBootTest
@ActiveProfiles("sit")
public abstract class SpringBootBaseTest extends BaseTest {
}