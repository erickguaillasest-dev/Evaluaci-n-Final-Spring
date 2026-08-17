package com.facilpago.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CondominioRequestDTO {
	 
    private String cedulaCondomino;
    private String nombreCondomino;
    private String apellidoCondomino;
    private String celularCondomino;
    private String telefonoCondomino;
    private String numeroBloque;
    private String numeroDepartamento;
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
	public String getNumeroBloque() {
		return numeroBloque;
	}
	public void setNumeroBloque(String numeroBloque) {
		this.numeroBloque = numeroBloque;
	}
	public String getNumeroDepartamento() {
		return numeroDepartamento;
	}
	public void setNumeroDepartamento(String numeroDepartamento) {
		this.numeroDepartamento = numeroDepartamento;
	}
    
    
	
}
