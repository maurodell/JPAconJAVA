/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mdo
 */
@Entity
public class Curso {
    @Id
    private Integer Id;
    private String nombre;
    
    @Temporal(TemporalType.DATE)//con la anotacion temporaltype.DATE informamos el tipo de dato en la BD
    private Date fechaFin;
    
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    private Integer costo;
    
    @OneToOne //cuando establecemos las relaciones estamos mapeando, como en este ejemplo
    private Profesor profedor;
    
    @OneToMany
    private List<Alumno> alumno;

    public Curso() {
    }

    public Curso(Integer Id, String nombre, Date fechaFin, Date fechaInicio, Integer costo, Profesor profedor, List<Alumno> alumno) {
        this.Id = Id;
        this.nombre = nombre;
        this.fechaFin = fechaFin;
        this.fechaInicio = fechaInicio;
        this.costo = costo;
        this.profedor = profedor;
        this.alumno = alumno;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Profesor getProfedor() {
        return profedor;
    }

    public void setProfedor(Profesor profedor) {
        this.profedor = profedor;
    }

    public List<Alumno> getAlumno() {
        return alumno;
    }

    public void setAlumno(List<Alumno> alumno) {
        this.alumno = alumno;
    }
    
}
