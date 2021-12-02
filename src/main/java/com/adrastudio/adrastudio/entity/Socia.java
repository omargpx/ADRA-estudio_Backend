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
@Table(name="TBL_SOCIA")
public class Socia {
	
	@Id
	@Column(name = "ID_PERSONA")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_socia;
	
	@Column(name="ID_BANCOCOMUNAL")
	private int id_banco_comunal;

	public int getId_socia() {
		return id_socia;
	}

	public void setId_socia(int id_socia) {
		this.id_socia = id_socia;
	}

	public int getId_banco_comunal() {
		return id_banco_comunal;
	}

	public void setId_banco_comunal(int id_banco_comunal) {
		this.id_banco_comunal = id_banco_comunal;
	}
	
	

}
