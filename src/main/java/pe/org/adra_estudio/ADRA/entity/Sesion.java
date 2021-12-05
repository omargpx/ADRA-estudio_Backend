package pe.org.adra_estudio.ADRA.entity;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="TBL_SESION")
public class Sesion implements Serializable{
	
	@Id
	@Column(name="ID_SESION")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_sesion;
	
	@Column(name="NO_SESION")
	private String nombre_sesion;
	
	@Column(name="DE_SESION")
	private String descripcion;
	
	@Column(name = "FE_INICIO")
	private Date fecha_inicio;
	
	@Column(name="FE_FIN")
	private Date fecha_fin;
	
	@Column(name="ID_CAPACITACION")
	private int id_capacitacion;

	public int getId_sesion() {
		return id_sesion;
	}

	public void setId_sesion(int id_sesion) {
		this.id_sesion = id_sesion;
	}

	public String getNombre_sesion() {
		return nombre_sesion;
	}

	public void setNombre_sesion(String nombre_sesion) {
		this.nombre_sesion = nombre_sesion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public int getId_capacitacion() {
		return id_capacitacion;
	}

	public void setId_capacitacion(int id_capacitacion) {
		this.id_capacitacion = id_capacitacion;
	}

	
}
