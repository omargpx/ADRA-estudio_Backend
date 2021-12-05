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
@Table(name="TMA_DISTRITO")
public class Distrito implements Serializable{
	
	@Id
	@Column(name="ID_DISTRITO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_distrito;
	
	@Column(name="NO_DISTRITO")
	private String nombre_distrito;
	
	@Column(name="ID_PROVINCIA")
	private int id_provincia; //RELACION CON LA TABLA DE PROVINCIA                                 <?>

	public int getId_distrito() {
		return id_distrito;
	}

	public void setId_distrito(int id_distrito) {
		this.id_distrito = id_distrito;
	}

	public String getNombre_distrito() {
		return nombre_distrito;
	}

	public void setNombre_distrito(String nombre_distrito) {
		this.nombre_distrito = nombre_distrito;
	}

	public int getId_provincia() {
		return id_provincia;
	}

	public void setId_provincia(int id_provincia) {
		this.id_provincia = id_provincia;
	}
	
	
}
