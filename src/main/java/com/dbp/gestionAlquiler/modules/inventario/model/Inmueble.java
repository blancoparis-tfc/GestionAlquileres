package com.dbp.gestionAlquiler.modules.inventario.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "inmueble")
public class Inmueble {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "referencia_catastral", length = 20)
    private String referenciaCatastral;

    @Column(name = "superficie_util")
    private BigDecimal superficieUtil;

    @Column(name = "superficie_construida")
    private BigDecimal superficieConstruida;

    @Column(name = "num_habitaciones_dobles")
    private Integer numHabitacionesDobles;

    @Column(name = "num_habitaciones_indiv")
    private Integer numHabitacionesIndiv;

    @Column(name = "num_baños")
    private Integer numBaños;

    @Column(name = "num_aseos")
    private Integer numAseos;

    @Column(name = "año_construccion")
    private Integer añoConstruccion;

    @Column(name = "ultima_reforma")
    private Integer ultimaReforma;

    @Column(name = "tiene_terraza")
    private Boolean tieneTerraza;

    @Column(name = "tiene_jardin")
    private Boolean tieneJardin;

    @Column(name = "tiene_trastero")
    private Boolean tieneTrastero;

    @Column(name = "tiene_garaje")
    private Boolean tieneGaraje;

    // Constructor por defecto
    public Inmueble() {
    }

    // Constructor con parámetros
    public Inmueble(UUID id) {
        this.id = id;
    }

    // Getters y setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getReferenciaCatastral() {
        return referenciaCatastral;
    }

    public void setReferenciaCatastral(String referenciaCatastral) {
        this.referenciaCatastral = referenciaCatastral;
    }

    public BigDecimal getSuperficieUtil() {
        return superficieUtil;
    }

    public void setSuperficieUtil(BigDecimal superficieUtil) {
        this.superficieUtil = superficieUtil;
    }

    public BigDecimal getSuperficieConstruida() {
        return superficieConstruida;
    }

    public void setSuperficieConstruida(BigDecimal superficieConstruida) {
        this.superficieConstruida = superficieConstruida;
    }

    public Integer getNumHabitacionesDobles() {
        return numHabitacionesDobles;
    }

    public void setNumHabitacionesDobles(Integer numHabitacionesDobles) {
        this.numHabitacionesDobles = numHabitacionesDobles;
    }

    public Integer getNumHabitacionesIndiv() {
        return numHabitacionesIndiv;
    }

    public void setNumHabitacionesIndiv(Integer numHabitacionesIndiv) {
        this.numHabitacionesIndiv = numHabitacionesIndiv;
    }

    public Integer getNumBaños() {
        return numBaños;
    }

    public void setNumBaños(Integer numBaños) {
        this.numBaños = numBaños;
    }

    public Integer getNumAseos() {
        return numAseos;
    }

    public void setNumAseos(Integer numAseos) {
        this.numAseos = numAseos;
    }

    public Integer getAñoConstruccion() {
        return añoConstruccion;
    }

    public void setAñoConstruccion(Integer añoConstruccion) {
        this.añoConstruccion = añoConstruccion;
    }

    public Integer getUltimaReforma() {
        return ultimaReforma;
    }

    public void setUltimaReforma(Integer ultimaReforma) {
        this.ultimaReforma = ultimaReforma;
    }

    public Boolean getTieneTerraza() {
        return tieneTerraza;
    }

    public void setTieneTerraza(Boolean tieneTerraza) {
        this.tieneTerraza = tieneTerraza;
    }

    public Boolean getTieneJardin() {
        return tieneJardin;
    }

    public void setTieneJardin(Boolean tieneJardin) {
        this.tieneJardin = tieneJardin;
    }

    public Boolean getTieneTrastero() {
        return tieneTrastero;
    }

    public void setTieneTrastero(Boolean tieneTrastero) {
        this.tieneTrastero = tieneTrastero;
    }

    public Boolean getTieneGaraje() {
        return tieneGaraje;
    }

    public void setTieneGaraje(Boolean tieneGaraje) {
        this.tieneGaraje = tieneGaraje;
    }
}