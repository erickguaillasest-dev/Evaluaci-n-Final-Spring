package com.facilpago.model;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "pago")
@NoArgsConstructor
@AllArgsConstructor
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_pago", nullable = false)
    private LocalDate fechaPago;

    @Column(name = "anio_mes_pago", nullable = false, length = 7)
    private String anioMesPago;

    @Column(name = "valor_pago_alicuota", nullable = false)
    private Double valorPagoAlicuota;

    @Column(name = "valor_pago_consumo_servicios", nullable = false)
    private Double valorPagoConsumoServicios;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cedula_condomino", nullable = false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "pagos"})
    private Condominio condomino;

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

    public Condominio getCondomino() {
        return condomino;
    }

    public void setCondomino(Condominio condomino) {
        this.condomino = condomino;
    }
}