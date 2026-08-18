package com.facilpago.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "condominio")
@NoArgsConstructor
@AllArgsConstructor
public class Condominio {

    @Id
    @Column(name = "cedula_condomino", length = 10)
    private String cedulaCondomino;

    @Column(name = "nombre_condomino", nullable = false, length = 50)
    private String nombreCondomino;

    @Column(name = "apellido_condomino", nullable = false, length = 50)
    private String apellidoCondomino;

    @Column(name = "celular_condomino", length = 15)
    private String celularCondomino;

    @Column(name = "telefono_condomino", length = 15)
    private String telefonoCondomino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_bloque", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Bloque bloque;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "numero_departamento", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Departamento departamento;

    public String getCedulaCondomino() {
        return cedulaCondomino;
    }

    public void setCedulaCondomino(String cedulaCondomino) {
        this.cedulaCondomino = cedulaCondomino;
    }

    public String getNombreCondomino() {
        return nombreCondomino;
    }

    public void setNombreCondomino(String nombreCondomino) {
        this.nombreCondomino = nombreCondomino;
    }

    public String getApellidoCondomino() {
        return apellidoCondomino;
    }

    public void setApellidoCondomino(String apellidoCondomino) {
        this.apellidoCondomino = apellidoCondomino;
    }

    public String getCelularCondomino() {
        return celularCondomino;
    }

    public void setCelularCondomino(String celularCondomino) {
        this.celularCondomino = celularCondomino;
    }

    public String getTelefonoCondomino() {
        return telefonoCondomino;
    }

    public void setTelefonoCondomino(String telefonoCondomino) {
        this.telefonoCondomino = telefonoCondomino;
    }

    public Bloque getBloque() {
        return bloque;
    }

    public void setBloque(Bloque bloque) {
        this.bloque = bloque;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}