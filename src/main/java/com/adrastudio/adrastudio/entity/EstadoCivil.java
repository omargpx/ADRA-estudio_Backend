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
@Table(name="TMA_ES_CIVIL")
public class EstadoCivil {
	
	@Id
	@Column(name="ID_ESCIVIL")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_escivil;
	
	@Column(name="NO_ES_CIVIL")
	private String no_estadocivil;

	public int getId_escivil() {
		return id_escivil;
	}

	public void setId_escivil(int id_escivil) {
		this.id_escivil = id_escivil;
	}

	public String getNo_estadocivil() {
		return no_estadocivil;
	}

	public void setNo_estadocivil(String no_estadocivil) {
		this.no_estadocivil = no_estadocivil;
	}

}
