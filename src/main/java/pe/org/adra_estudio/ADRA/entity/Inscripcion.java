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
@Table(name="TBL_INSCRIPCION")
public class Inscripcion implements Serializable{
	
	@Id
	@Column(name = "ID_INSCRIPCION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_inscripcion;
	
	@Column(name="IN_VALORACION")
	private int valoracion;
	
	@Column(name = "IN_AVANCE")
	private int avance;
	
	@Column(name = "ID_CAPACITACION")
	private int id_capacitacion;
	
	@Column(name = "ID_SOCIA")
	private int id_socia;

	public int getId_inscripcion() {
		return id_inscripcion;
	}

	public void setId_inscripcion(int id_inscripcion) {
		this.id_inscripcion = id_inscripcion;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public int getAvance() {
		return avance;
	}

	public void setAvance(int avance) {
		this.avance = avance;
	}

	public int getId_capacitacion() {
		return id_capacitacion;
	}

	public void setId_capacitacion(int id_capacitacion) {
		this.id_capacitacion = id_capacitacion;
	}

	public int getId_socia() {
		return id_socia;
	}

	public void setId_socia(int id_socia) {
		this.id_socia = id_socia;
	}
	
	
}
