package com.dbp.gestionAlquiler;

import org.junit.jupiter.api.Test;
import com.dbp.gestionAlquiler.SpringBootBaseTest;

/**
 * Pruebas de integración para la aplicación GestionAlquiler.
 * 
 * Esta clase extiende SpringBootBaseTest para heredar la configuración
 * de Spring Boot con el perfil SIT (System Integration Testing) activo.
 * 
 * La prueba principal verifica que el contexto de la aplicación se cargue correctamente,
 * lo cual es fundamental para asegurar que todos los componentes estén disponibles
 * y configurados correctamente antes de ejecutar otras pruebas.
 */
class GestionAlquilerApplicationTests extends SpringBootBaseTest {

	/**
	 * Prueba que verifica que el contexto de la aplicación se cargue correctamente.
	 * 
	 * Esta prueba es una verificación básica que asegura que la aplicación
	 * Spring Boot pueda inicializarse correctamente con su configuración de perfil SIT.
	 */
	@Test
	void contextLoads() {
	}
}
