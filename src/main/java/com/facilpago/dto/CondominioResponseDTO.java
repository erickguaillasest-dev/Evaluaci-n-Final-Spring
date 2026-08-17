package com.facilpago.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CondominioResponseDTO {
	
	private String cedulaCondomino;
    private String nombreCondomino;
    private String apellidoCondominio;
    private String celularCondomino;
    private String telefonoCondominio;
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
	public String getApellidoCondominio() {
		return apellidoCondominio;
	}
	public void setApellidoCondominio(String apellidoCondominio) {
		this.apellidoCondominio = apellidoCondominio;
	}
	public String getCelularCondomino() {
		return celularCondomino;
	}
	public void setCelularCondomino(String celularCondomino) {
		this.celularCondomino = celularCondomino;
	}
	public String getTelefonoCondominio() {
		return telefonoCondominio;
	}
	public void setTelefonoCondominio(String telefonoCondominio) {
		this.telefonoCondominio = telefonoCondominio;
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
