package com.facilpago.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bloques")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bloque {

    @Id
    @Column(name = "numero_bloque", length = 20)
    private String numeroBloque;

    @Column(name = "descripcion_bloque", nullable = false, length = 100)
    private String descripcionBloque;

    @Column(name = "ubicacion", nullable = false, length = 100)
    private String ubicacion;

	public String getNumeroBloque() {
		return numeroBloque;
	}

	public void setNumeroBloque(String numeroBloque) {
		this.numeroBloque = numeroBloque;
	}

	public String getDescripcionBloque() {
		return descripcionBloque;
	}

	public void setDescripcionBloque(String descripcionBloque) {
		this.descripcionBloque = descripcionBloque;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}



}