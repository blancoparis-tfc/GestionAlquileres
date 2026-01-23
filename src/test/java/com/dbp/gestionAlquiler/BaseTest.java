package com.dbp.gestionAlquiler;

import com.github.javafaker.Faker;
import java.util.Locale;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Clase base para pruebas que proporciona configuración común.
 * 
 * Esta clase abstracta ofrece funcionalidades útiles para las pruebas,
 * incluyendo la configuración de Faker con localización española y
 * un ObjectMapper de Jackson para serialización/deserialización.
 * 
 * No incluye anotaciones de Spring Test como @SpringBootTest para
 * mantener la independencia de la configuración de Spring.
 */
public abstract class BaseTest {
    
    /**
     * Instancia de Faker configurada con localización española.
     * Se utiliza para generar datos de prueba aleatorios en español.
     */
    protected final Faker faker = new Faker(new Locale("es"));
    
    /**
     * ObjectMapper de Jackson para operaciones de serialización y deserialización.
     * Útil para trabajar con JSON en las pruebas.
     */
    protected final ObjectMapper objectMapper = new ObjectMapper();
}