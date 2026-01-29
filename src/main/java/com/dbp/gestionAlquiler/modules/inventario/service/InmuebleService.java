package com.dbp.gestionAlquiler.modules.inventario.service;

import com.dbp.gestionAlquiler.modules.inventario.model.Inmueble;
import com.dbp.gestionAlquiler.modules.inventario.repository.InmuebleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class InmuebleService {
    
    @Autowired
    private InmuebleRepository inmuebleRepository;
    
    public List<Inmueble> getAllInmuebles() {
        return inmuebleRepository.findAll();
    }
    
    public Inmueble getInmuebleById(UUID id) {
        return inmuebleRepository.findById(id).orElse(null);
    }
    
    public Inmueble createInmueble(Inmueble inmueble) {
        return inmuebleRepository.save(inmueble);
    }
    
    public Inmueble updateInmueble(UUID id, Inmueble inmuebleDetails) {
        Inmueble inmueble = getInmuebleById(id);
        if (inmueble != null) {
            // Actualizar campos
            inmueble.setReferenciaCatastral(inmuebleDetails.getReferenciaCatastral());
            inmueble.setSuperficieUtil(inmuebleDetails.getSuperficieUtil());
            inmueble.setSuperficieConstruida(inmuebleDetails.getSuperficieConstruida());
            inmueble.setNumHabitacionesDobles(inmuebleDetails.getNumHabitacionesDobles());
            inmueble.setNumHabitacionesIndiv(inmuebleDetails.getNumHabitacionesIndiv());
            inmueble.setNumBaños(inmuebleDetails.getNumBaños());
            inmueble.setNumAseos(inmuebleDetails.getNumAseos());
            inmueble.setAñoConstruccion(inmuebleDetails.getAñoConstruccion());
            inmueble.setUltimaReforma(inmuebleDetails.getUltimaReforma());
            inmueble.setTieneTerraza(inmuebleDetails.getTieneTerraza());
            inmueble.setTieneJardin(inmuebleDetails.getTieneJardin());
            inmueble.setTieneTrastero(inmuebleDetails.getTieneTrastero());
            inmueble.setTieneGaraje(inmuebleDetails.getTieneGaraje());
            
            return inmuebleRepository.save(inmueble);
        }
        return null;
    }
    
    public void deleteInmueble(UUID id) {
        inmuebleRepository.deleteById(id);
    }
}