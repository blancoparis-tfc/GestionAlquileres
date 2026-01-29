package com.dbp.gestionAlquiler.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración de OpenAPI 3 para la aplicación.
 * Esta clase permite configurar la documentación API con Swagger.
 */
@Configuration
public class OpenApiConfig {

    /**
     * Bean que configura la información básica de la API para Swagger.
     * Incluye título, versión y descripción breve de la aplicación.
     *
     * @return OpenAPI configurado con información de la aplicación
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Mi Proyecto")
                        .version("1.0")
                        .description("Descripción breve de la API del proyecto de gestión de alquileres")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0")));
    }
}