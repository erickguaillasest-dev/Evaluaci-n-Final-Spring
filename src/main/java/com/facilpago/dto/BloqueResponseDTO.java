package com.facilpago.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloqueResponseDTO {
	private String numeroBloque;
	private String descripcionBloque;
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
