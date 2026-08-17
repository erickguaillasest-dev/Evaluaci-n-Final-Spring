package com.facilpago.dto;

import java.time.LocalDate;

public class PagoResponseDTO {
	private Long id;
    private LocalDate fechaPago;
    private String anioMesPago;
    private Double valorPagoAlicuota;
    private Double valorPagoConsumoServicios;
    private String cedulaCondomino;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
