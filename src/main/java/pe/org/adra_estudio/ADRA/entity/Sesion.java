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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TBL_SESION")
public class Sesion implements Serializable {

    @Id
    @Column(name = "ID_SESION")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sesion;

    @Column(name = "NO_SESION")
    private String nombre_sesion;

    @Column(name = "DE_SESION")
    private String descripcion;

    @Column(name = "FE_INICIO")
    private String fecha_inicio;

    @Column(name = "FE_FIN")
    private String fecha_fin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_capacitacion")
    private Capacitacion capacitacion;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "sesion")
    private List<Recurso> recursos;

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

    public Capacitacion getCapacitacion() {
        return capacitacion;
    }

    public void setCapacitacion(Capacitacion capacitacion) {
        this.capacitacion = capacitacion;
    }

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos = recursos;
    }

}
