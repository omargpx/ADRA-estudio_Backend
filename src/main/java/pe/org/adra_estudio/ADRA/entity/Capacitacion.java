package pe.org.adra_estudio.ADRA.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TBL_CAPACITACION")
public class Capacitacion implements Serializable {

    @Id
    @Column(name = "ID_CAPACITACION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_capacitacion;

    @Column(name = "NO_CAPACITACION")
    private String nombre_capacitacion;

    @Column(name = "DE_CAPACITACION")
    private String descripcion;

    @Column(name = "PORTADA")
    private String portada;

    @Column(name = "FE_INICIO_CAPACITACION")
    private String fecha_inicio;

    @Column(name = "FE_FIN_CAPACITACION")
    private String fecha_fin;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "capacitacion")
    private List<Sesion> sesion;
   
    //Getters and setters
    public int getId_capacitacion() {
        return id_capacitacion;
    }

    public void setId_capacitacion(int id_capacitacion) {
        this.id_capacitacion = id_capacitacion;
    }

    public String getNombre_capacitacion() {
        return nombre_capacitacion;
    }

    public void setNombre_capacitacion(String nombre_capacitacion) {
        this.nombre_capacitacion = nombre_capacitacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
   
}
