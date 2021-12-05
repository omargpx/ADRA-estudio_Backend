package pe.org.adra_estudio.ADRA.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TMA_PROVINCIA")
public class Provincia implements Serializable{
	
	@Id
	@Column(name = "ID_PROVINCIA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_provincia;
	
	@Column(name="NO_PROVINCIA")
	private String nombre_provincia;
	
	@Column(name="ID_DEPARTAMENTO")
	private int id_departamento;

	public int getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(int id_provincia) {
		this.id_provincia = id_provincia;
	}

	public String getNombre_provincia() {
		return nombre_provincia;
	}

	public void setNombre_provincia(String nombre_provincia) {
		this.nombre_provincia = nombre_provincia;
	}

	public int getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}
	
	
}
