package pe.org.adra_estudio.ADRA.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TBL_RECURSO")
public class Recurso implements Serializable {

    @Id
    @Column(name = "ID_RECURSO")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_recurso;

    @Column(name = "NO_RECURSO")
    private int nombre_recurso;

    @Column(name = "DE_RECURSO")
    private String descripcion;

    @Column(name = "URL")
    private String url;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_capacitacion")
    private Sesion sesion;

    @Column(name = "ID_TIRECURSO")
    private int id_tipoRecurso;

    

    public int getId_recurso() {
        return id_recurso;
    }

    public void setId_recurso(int id_recurso) {
        this.id_recurso = id_recurso;
    }

    public int getNombre_recurso() {
        return nombre_recurso;
    }

    public void setNombre_recurso(int nombre_recurso) {
        this.nombre_recurso = nombre_recurso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Sesion getSesion() {
        return sesion;
    }

    public void setSesion(Sesion sesion) {
        this.sesion = sesion;
    }

    public int getId_tipoRecurso() {
        return id_tipoRecurso;
    }

    public void setId_tipoRecurso(int id_tipoRecurso) {
        this.id_tipoRecurso = id_tipoRecurso;
    }

}
