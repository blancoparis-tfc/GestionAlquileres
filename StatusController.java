package com.dbp.gestionAlquiler.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api")
public class StatusController {

    @Autowired
    private BuildProperties buildProperties;

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/status")
    public ResponseEntity<?> getStatus() {
        String appName = buildProperties.getName();
        String appVersion = buildProperties.getVersion();

        boolean dbCheck;
        try {
            // Perform a simple query to check if the database is responding
            entityManager.createQuery("SELECT 1 FROM SystemLog").getSingleResult();
            dbCheck = true;
        } catch (Exception e) {
            dbCheck = false;
        }

        return ResponseEntity.ok(new StatusResponse(appName, appVersion, "OPERATIONAL", dbCheck));
    }
}

class StatusResponse {
    private String nombre;
    private String version;
    private String status;
    private boolean db_check;

    public StatusResponse(String nombre, String version, String status, boolean db_check) {
        this.nombre = nombre;
        this.version = version;
        this.status = status;
        this.db_check = db_check;
    }

    // Getters and setters (use Lombok if available)
}
