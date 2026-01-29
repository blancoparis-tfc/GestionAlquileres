package com.dbp.gestionAlquiler.config;

import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;

/**
 * Clase abstracta que sirve como base para las pruebas de persistencia con Spring Data JPA.
 * Esta clase centraliza la configuración de tests de integración de datos para evitar duplicidad de código.
 * 
 * La clase utiliza @DataJpaTest para configurar el contexto de persistencia y
 * @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) 
 * para usar la base de datos real configurada en el entorno.
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public abstract class DataJpaBaseTest {
}