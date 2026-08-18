package com.facilpago.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class PagoRequestDTO {
    private LocalDate fechaPago;
    private String anioMesPago;
    private Double valorPagoAlicuota;
    private Double valorPagoConsumoServicios;
    private String cedulaCondomino;
    
	public LocalDate getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getAnioMesPago() {
		return anioMesPago;
	}
	public void setAnioMesPago(String anioMesPago) {
		this.anioMesPago = anioMesPago;
	}
	public Double getValorPagoAlicuota() {
		return valorPagoAlicuota;
	}
	public void setValorPagoAlicuota(Double valorPagoAlicuota) {
		this.valorPagoAlicuota = valorPagoAlicuota;
	}
	public Double getValorPagoConsumoServicios() {
		return valorPagoConsumoServicios;
	}
	public void setValorPagoConsumoServicios(Double valorPagoConsumoServicios) {
		this.valorPagoConsumoServicios = valorPagoConsumoServicios;
	}
	public String getCedulaCondomino() {
		return cedulaCondomino;
	}
	public void setCedulaCondomino(String cedulaCondomino) {
		this.cedulaCondomino = cedulaCondomino;
	}
	
    
}
