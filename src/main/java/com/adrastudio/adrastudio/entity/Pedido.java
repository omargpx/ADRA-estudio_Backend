package com.adrastudio.adrastudio.entity;

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
@Table(name = "TBL_PEDIDO")
public class Pedido {
	
	@Id
	@Column(name = "ID_PEDIDO")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pedido;
	
	@Column(name = "DE_PEDIDO")
	private String descripcion;
	
	@Column(name = "ES_PEDIDO")
	private int estado;
	
	@Column(name = "FECHA_INICIO")
	private Date fecha_inicio;
	
	@Column(name = "FECHA_FIN")
	private Date fecha_fin;

	@Column(name = "ID_PERSONA")
	private int id_persona;

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
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

	public int getId_persona() {
		return id_persona;
	}

	public void setId_persona(int id_persona) {
		this.id_persona = id_persona;
	}
	
}
