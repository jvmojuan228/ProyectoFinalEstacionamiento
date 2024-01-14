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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Moto", schema = "public")
public class Moto implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idMoto", nullable = false)
	private long idMoto;
	
	@NotBlank(message="La marca es un campo obligatorio")
	@Size(min=4, max=45, message="La marca de estar entre 4 y 45 caracteres.")
	@Column(name="marcaMoto", length=45, nullable = false)
	private String marcaMoto;
	
	
	@NotBlank(message="El modelo es un campo obligatorio")
	@Size(min=4, max=45, message="El modelo de estar entre 4 y 45 caracteres.")
	@Column(name="modeloMoto", length=45, nullable = false)
	private String modeloMoto;
	
	@NotBlank(message="La serie es un campo obligatorio")
	@Size(min=4, max=45, message="La serie de estar entre 4 y 45 caracteres.")
	@Column(name="serieMoto", length=45, nullable = false)
	private String serieMoto;
	
	@NotBlank(message="La marca es un campo obligatorio")
	@Size(min=6, max=10, message="La marca de estar entre 6 y 10 caracteres.")
	@Column(name="placas", length=45, nullable = false)
	private String placasMoto;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario idUsuario;
	
	public void setIdUsuario(Usuario usuario) {
		this.idUsuario = usuario;
	}
	
	@JsonIgnoreProperties(
			value={"idMoto", 
					"hibernateLazyInitializer", 
					"handler"},
			allowSetters=true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idMoto", cascade = CascadeType.ALL)
	private Set<Entrada> entradas = new HashSet<>();
	
	@JsonIgnoreProperties(
			value={"idMoto", 
					"hibernateLazyInitializer", 
					"handler"},
			allowSetters=true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idMoto", cascade = CascadeType.ALL)
	private Set<Salida> salidas = new HashSet<>();


	public void setEntradas(Set<Entrada> entradas) {
		this.entradas = entradas;
		for(Entrada entrada: entradas) {
			entrada.setIdMoto(this);
		}
	}

	public void setSalidas(Set<Salida> salidas) {
		this.salidas = salidas;
		for(Salida salida: salidas) {
			salida.setIdMoto(this);
		}
	}
	
	
	
}
