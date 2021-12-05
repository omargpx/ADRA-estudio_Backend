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
@Table(name="TBL_BANCO_COMUNAL")
public class BancoComunal {
	
	@Id
	@Column(name="ID_BANCO_COMUNAL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_banquito;
	
	@Column(name="NO_BANCO_COMUNAL")
	private String nombre_banquito;
	
	@Column(name="ID_DISTRITO")
	private int id_distrito;  //relacion con la tabla distrito                              <?>

	public int getId_banquito() {
		return id_banquito;
	}

	public void setId_banquito(int id_banquito) {
		this.id_banquito = id_banquito;
	}

	public String getNombre_banquito() {
		return nombre_banquito;
	}

	public void setNombre_banquito(String nombre_banquito) {
		this.nombre_banquito = nombre_banquito;
	}

	public int getId_distrito() {
		return id_distrito;
	}

	public void setId_distrito(int id_distrito) {
		this.id_distrito = id_distrito;
	}
	
	

}
