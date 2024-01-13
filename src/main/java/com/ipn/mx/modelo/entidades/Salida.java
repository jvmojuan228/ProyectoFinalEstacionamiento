package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

public class Salida implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idSalida;

	@NotNull(message = "Fecha requerida")
	@Temporal(TemporalType.DATE)
	@Column(name = "fechahora", length = 10, nullable = false)
	private Date fechahora;

	@ManyToOne
	@JoinColumn(name = "idSistemaControl")
	private SistemaControl idSistemaControl;

	@ManyToOne
	@JoinColumn(name = "idMoto")
	private Moto idMoto;

	public void setIdSistemaControl(SistemaControl idSistemaControl) {
		this.idSistemaControl = idSistemaControl;
	}

	public void setIdMoto(Moto idMoto) {
		this.idMoto = idMoto;
	}
}
