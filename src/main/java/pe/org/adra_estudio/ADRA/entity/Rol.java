/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.org.adra_estudio.ADRA.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import lombok.Data;

/**
 *
 * @author lober
 */
@Entity
@Table(name = "TMA_ROL")
public class Rol implements Serializable {

    @Id
    @Column(name = "id_rol")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_rol;

    @Column(name = "no_rol")
    private String no_rol;

    @Column(name = "img_icon")
    private String img;

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNo_rol() {
        return no_rol;
    }

    public void setNo_rol(String no_rol) {
        this.no_rol = no_rol;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {

    }
}
