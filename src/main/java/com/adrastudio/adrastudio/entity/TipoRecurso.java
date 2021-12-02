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
@Table(name="TMA_TI_RECURSO")
public class TipoRecurso {
	
	@Id
	@Column(name="ID_TI_RECURSO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipo_recurso;
	
	@Column(name = "NO_TI_RECURSO")
	private String nombre_tipo_recurso;

	public int getId_tipo_recurso() {
		return id_tipo_recurso;
	}

	public void setId_tipo_recurso(int id_tipo_recurso) {
		this.id_tipo_recurso = id_tipo_recurso;
	}

	public String getNombre_tipo_recurso() {
		return nombre_tipo_recurso;
	}

	public void setNombre_tipo_recurso(String nombre_tipo_recurso) {
		this.nombre_tipo_recurso = nombre_tipo_recurso;
	}
	
	
}
