package com.ipn.mx.modelo.entidades;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name="SistemaControl")
public class SistemaControl implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long idSistemaControl;
	
	@NotBlank(message="El nombre del acceso es un campo obligatorio")
	@Size(min=4, max=50, message="El nombre debe de estar entre 4 y 50 caracteres.")
	@Column(name="acceso", length=45, nullable = false)
	private String acceso;
	
	@JsonIgnoreProperties(
			value={"idSistemaControl", 
					"hibernateLazyInitializer", 
					"handler"},
			allowSetters=true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idSistemaControl", cascade = CascadeType.ALL)
	private Set<Entrada> entradas = new HashSet<>();
	
	@JsonIgnoreProperties(
			value={"idSistemaControl", 
					"hibernateLazyInitializer", 
					"handler"},
			allowSetters=true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idSistemaControl", cascade = CascadeType.ALL)
	private Set<Salida> salidas = new HashSet<>();

	
	
	public void setIdSistemaControl(long idSistemaControl) {
		this.idSistemaControl = idSistemaControl;
	}

	public void setAcceso(String acceso) {
		this.acceso = acceso;
	}

	public void setEntradas(Set<Entrada> entradas) {
		this.entradas = entradas;
		for(Entrada entrada: entradas) {
			entrada.setIdSistemaControl(this);
		}
	}

	public void setSalidas(Set<Salida> salidas) {
		this.salidas = salidas;
		for(Salida salida: salidas) {
			salida.setIdSistemaControl(this);
		}
	}
	
	
}