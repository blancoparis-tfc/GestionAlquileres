package com.dbp.gestionAlquiler.modules.inventario.repository;

import com.dbp.gestionAlquiler.modules.inventario.model.Inmueble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InmuebleRepository extends JpaRepository<Inmueble, UUID> {
}