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
@Table(name="TMA_DEPARTAMENTO")
public class Departament implements Serializable{
	
	@Id
	@Column(name = "ID_DEPARTAMENTO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_departamento;
	
	@Column(name="NO_DEPARTAMENTO")
	private String nombre_departament;

	public int getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}

	public String getNombre_departament() {
		return nombre_departament;
	}

	public void setNombre_departament(String nombre_departament) {
		this.nombre_departament = nombre_departament;
	}
}
