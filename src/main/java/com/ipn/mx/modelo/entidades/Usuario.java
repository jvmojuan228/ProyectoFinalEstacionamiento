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
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
//import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name="Usuarios", schema = "public")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idUsuario", nullable = false)
	private long idUsuario;
	
	@NotEmpty(message="El nombre del usuario es obligatorio")
	@Size(min=4, max=50, message="El nombre de estar entre 4 y 50 caracteres.")
	@Column(name="nombreUsuario", length=50, nullable = false)
	private String nombreUsuario;
	
	@NotEmpty(message="El ap paterno del usuario es obligatorio")
	@Size(min=4, max=50, message="El nombre de estar entre 4 y 50 caracteres.")
	@Column(name="paternoUsuario", length=50, nullable = false)
	private String paternoUsuario;
	
	@NotEmpty(message="El ap materno del usuario es obligatorio")
	@Size(min=4, max=50, message="El nombre de estar entre 4 y 50 caracteres.")
	@Column(name="maternoUsuario", length=50, nullable = false)
	private String maternoUsuario;
	
	@JsonIgnoreProperties(
			value={"idUsuario", 
					"hibernateLazyInitializer", 
					"handler"},
			allowSetters=true)
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "idUsuario", cascade = CascadeType.ALL)
	private Set<Moto> motos = new HashSet<>();
	
	

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public void setPaternoUsuario(String paternoUsuario) {
		this.paternoUsuario = paternoUsuario;
	}

	public void setMaternoUsuario(String maternoUsuario) {
		this.maternoUsuario = maternoUsuario;
	}

	public void setMotos(Set<Moto> motos) {
		this.motos = motos;
		for(Moto moto: motos) {
			moto.setIdUsuario(this);
		}
	}

}
