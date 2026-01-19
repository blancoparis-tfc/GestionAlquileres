package com.dbp.gestionAlquiler.controller;

import com.dbp.gestionAlquiler.model.SystemLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StatusController {
    
    @Autowired
    private BuildProperties buildProperties;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @GetMapping("/status")
    public ResponseEntity<StatusResponse> getStatus() {
        // Check database connection
        boolean dbCheck = checkDatabaseConnection();
        
        StatusResponse response = new StatusResponse(
            buildProperties.getName(),
            buildProperties.getVersion(),
            "OPERATIONAL",
            dbCheck
        );
        
        return ResponseEntity.ok(response);
    }
    
    private boolean checkDatabaseConnection() {
        try {
            // Try to execute a simple query to check if DB is responsive
            jdbcTemplate.execute("SELECT 1");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    // Inner class for the response structure
    public static class StatusResponse {
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
        
        // Getters and setters
        public String getNombre() {
            return nombre;
        }
        
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        
        public String getVersion() {
            return version;
        }
        
        public void setVersion(String version) {
            this.version = version;
        }
        
        public String getStatus() {
            return status;
        }
        
        public void setStatus(String status) {
            this.status = status;
        }
        
        public boolean isDb_check() {
            return db_check;
        }
        
        public void setDb_check(boolean db_check) {
            this.db_check = db_check;
        }
    }
}
