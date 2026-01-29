package com.dbp.gestionAlquiler.modules.inventario.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.dbp.gestionAlquiler.modules.inventario.model.Inmueble;
import com.dbp.gestionAlquiler.modules.inventario.service.InmuebleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Controlador para la gestión de inmuebles en el módulo de inventario.
 * Proporciona endpoints para crear, leer, actualizar y eliminar inmuebles.
 */
@RestController
@RequestMapping("/api/inventario")
@Tag(name = "Inventario", description = "Operaciones relacionadas con la gestión de inmuebles")
public class InmuebleController {
    
    @Autowired
    private InmuebleService inmuebleService;
    
    /**
     * Obtiene todos los inmuebles disponibles.
     * 
     * @return Lista de todos los inmuebles
     */
    @GetMapping("/inmuebles")
    @Operation(
        summary = "Listar todos los inmuebles",
        description = "Devuelve una lista con todos los inmuebles disponibles en el sistema."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Lista de inmuebles obtenida correctamente"
        )
    })
    public List<Inmueble> getAllInmuebles() {
        return inmuebleService.getAllInmuebles();
    }
    
    /**
     * Obtiene un inmueble específico por su ID.
     * 
     * @param id El identificador único del inmueble
     * @return El inmueble encontrado o 404 si no existe
     */
    @GetMapping("/inmuebles/{id}")
    @Operation(
        summary = "Obtener inmueble por ID",
        description = "Devuelve los detalles de un inmueble específico identificado por su ID."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Inmueble obtenido correctamente"
        ),
        @ApiResponse(
            responseCode = "404", 
            description = "Inmueble no encontrado"
        )
    })
    public ResponseEntity<Inmueble> getInmuebleById(
            @Parameter(description = "ID único del inmueble", required = true)
            @PathVariable UUID id) {
        Inmueble inmueble = inmuebleService.getInmuebleById(id);
        if (inmueble != null) {
            return ResponseEntity.ok(inmueble);
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * Crea un nuevo inmueble en el sistema.
     * 
     * @param inmueble Los datos del nuevo inmueble a crear
     * @return El inmueble creado con su ID asignado
     */
    @PostMapping("/inmuebles")
    @Operation(
        summary = "Crear nuevo inmueble",
        description = "Crea un nuevo inmueble con los datos proporcionados."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Inmueble creado correctamente"
        )
    })
    public ResponseEntity<Inmueble> createInmueble(@RequestBody Inmueble inmueble) {
        Inmueble createdInmueble = inmuebleService.createInmueble(inmueble);
        return ResponseEntity.ok(createdInmueble);
    }
    
    /**
     * Actualiza los datos de un inmueble existente.
     * 
     * @param id El identificador único del inmueble a actualizar
     * @param inmuebleDetails Los nuevos datos del inmueble
     * @return El inmueble actualizado o 404 si no existe
     */
    @PutMapping("/inmuebles/{id}")
    @Operation(
        summary = "Actualizar inmueble",
        description = "Actualiza los datos de un inmueble existente identificado por su ID."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "200", 
            description = "Inmueble actualizado correctamente"
        ),
        @ApiResponse(
            responseCode = "404", 
            description = "Inmueble no encontrado"
        )
    })
    public ResponseEntity<Inmueble> updateInmueble(
            @Parameter(description = "ID único del inmueble a actualizar", required = true)
            @PathVariable UUID id, 
            @RequestBody Inmueble inmuebleDetails) {
        Inmueble updatedInmueble = inmuebleService.updateInmueble(id, inmuebleDetails);
        if (updatedInmueble != null) {
            return ResponseEntity.ok(updatedInmueble);
        }
        return ResponseEntity.notFound().build();
    }
    
    /**
     * Elimina un inmueble del sistema.
     * 
     * @param id El identificador único del inmueble a eliminar
     * @return 204 si se eliminó correctamente, 404 si no existe
     */
    @DeleteMapping("/inmuebles/{id}")
    @Operation(
        summary = "Eliminar inmueble",
        description = "Elimina un inmueble del sistema identificado por su ID."
    )
    @ApiResponses(value = {
        @ApiResponse(
            responseCode = "204", 
            description = "Inmueble eliminado correctamente"
        ),
        @ApiResponse(
            responseCode = "404", 
            description = "Inmueble no encontrado"
        )
    })
    public ResponseEntity<Void> deleteInmueble(
            @Parameter(description = "ID único del inmueble a eliminar", required = true)
            @PathVariable UUID id) {
        inmuebleService.deleteInmueble(id);
        return ResponseEntity.noContent().build();
    }
}