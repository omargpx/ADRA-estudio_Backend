package com.adrastudio.adrastudio.entity;

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
public class Persona {
	
	// ATRIBUTES
	@Id
	@Column(name="ID_PERSONA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPersona; 
	
	@Column(name="NO_PERSONA")
	private String NombrePersona;
	
	@Column(name="AP_PATERNO")
	private String APaternoPersona;
	
	@Column(name="AP_MATERNO")
	private String APMaternoPersona;
	
	@Column(name="NU_TELEFONO")
	private int telefonoPersona;
	
	@Column(name="NU_DNI")
	private int DNIpersona;
	
	@Column(name="DI_PERSONA") 
	private String direccionPersona;
	
	@Column(name="TI_SEXO")
	private char sexoPersona;
	
	@Column(name="ID_CIVIL")
	private int es_civil;

	
	//GETERS AND SETTERS
	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
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
		return DNIpersona;
	}

	public void setDNIpersona(int dNIpersona) {
		DNIpersona = dNIpersona;
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
