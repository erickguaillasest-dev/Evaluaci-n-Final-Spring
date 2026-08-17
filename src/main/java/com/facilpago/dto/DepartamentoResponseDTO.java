package com.facilpago.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoResponseDTO {
	private String numeroDepartamento;
	private String descripcionDepartamento;
	public String getNumeroDepartamento() {
		return numeroDepartamento;
	}
	public void setNumeroDepartamento(String numeroDepartamento) {
		this.numeroDepartamento = numeroDepartamento;
	}
	public String getDescripcionDepartamento() {
		return descripcionDepartamento;
	}
	public void setDescripcionDepartamento(String descripcionDepartamento) {
		this.descripcionDepartamento = descripcionDepartamento;
	}

}
