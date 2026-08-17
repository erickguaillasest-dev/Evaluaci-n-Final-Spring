package com.facilpago.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departamento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Departamento {
	
	@Id
    @Column(name = "numero_departamento")
    private String numeroDepartamento;
	
	@Column(name = "descripcion_departamento")
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
