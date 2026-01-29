package com.dbp.gestionAlquiler.modules.inventario.controller;

import com.dbp.gestionAlquiler.modules.inventario.model.Inmueble;
import com.dbp.gestionAlquiler.modules.inventario.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/inventario")
public class InmuebleController {
    
    @Autowired
    private InmuebleService inmuebleService;
    
    @GetMapping("/inmuebles")
    public List<Inmueble> getAllInmuebles() {
        return inmuebleService.getAllInmuebles();
    }
    
    @GetMapping("/inmuebles/{id}")
    public ResponseEntity<Inmueble> getInmuebleById(@PathVariable UUID id) {
        Inmueble inmueble = inmuebleService.getInmuebleById(id);
        if (inmueble != null) {
            return ResponseEntity.ok(inmueble);
        }
        return ResponseEntity.notFound().build();
    }
    
    @PostMapping("/inmuebles")
    public ResponseEntity<Inmueble> createInmueble(@RequestBody Inmueble inmueble) {
        Inmueble createdInmueble = inmuebleService.createInmueble(inmueble);
        return ResponseEntity.ok(createdInmueble);
    }
    
    @PutMapping("/inmuebles/{id}")
    public ResponseEntity<Inmueble> updateInmueble(@PathVariable UUID id, @RequestBody Inmueble inmuebleDetails) {
        Inmueble updatedInmueble = inmuebleService.updateInmueble(id, inmuebleDetails);
        if (updatedInmueble != null) {
            return ResponseEntity.ok(updatedInmueble);
        }
        return ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/inmuebles/{id}")
    public ResponseEntity<Void> deleteInmueble(@PathVariable UUID id) {
        inmuebleService.deleteInmueble(id);
        return ResponseEntity.noContent().build();
    }
}