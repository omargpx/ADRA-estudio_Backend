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
@Table(name="TBL_PERSONA")
public class Persona implements Serializable{
	
	// ATRIBUTES
	@Id
	@Column(name="ID_PERSONA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ID_PERSONA; 
	
	@Column(name="NO_PERSONA")
	private String NombrePersona;
	
	@Column(name="AP_PATERNO")
	private String APaternoPersona;
	
	@Column(name="AP_MATERNO")
	private String APMaternoPersona;
	
	@Column(name="NU_TELEFONO")
	private int telefonoPersona;
	
	@Column(name="NU_DNI")
	private int NUDNI;
	
	@Column(name="DI_PERSONA") 
	private String direccionPersona;
	
	@Column(name="TI_SEXO")
	private char sexoPersona;
	
	@Column(name="ID_ESCIVIL")
	private int es_civil;

	
	//GETERS AND SETTERS
	public int getIdPersona() {
		return ID_PERSONA;
	}

	public void setIdPersona(int idPersona) {
		this.ID_PERSONA = idPersona;
	}

	public String getNombrePersona() {
		return NombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		NombrePersona = nombrePersona;
	}

	public String getAPaternoPersona() {
		return APaternoPersona;
	}

	public void setAPaternoPersona(String aPaternoPersona) {
		APaternoPersona = aPaternoPersona;
	}

	public String getAPMaternoPersona() {
		return APMaternoPersona;
	}

	public void setAPMaternoPersona(String aPMaternoPersona) {
		APMaternoPersona = aPMaternoPersona;
	}

	public int getTelefonoPersona() {
		return telefonoPersona;
	}

	public void setTelefonoPersona(int telefonoPersona) {
		this.telefonoPersona = telefonoPersona;
	}

	public int getDNIpersona() {
		return NUDNI;
	}

	public void setDNIpersona(int dNIpersona) {
		NUDNI = dNIpersona;
	}

	public String getDireccionPersona() {
		return direccionPersona;
	}

	public void setDireccionPersona(String direccionPersona) {
		this.direccionPersona = direccionPersona;
	}

	public char getSexoPersona() {
		return sexoPersona;
	}

	public void setSexoPersona(char sexoPersona) {
		this.sexoPersona = sexoPersona;
	}

	public int getEs_civil() {
		return es_civil;
	}

	public void setEs_civil(int es_civil) {
		this.es_civil = es_civil;
	}
	
}
