/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author mdo
 */
@Entity
public class Profesor {
    @Id
    private Integer documento;
    private String nombre;
    private String apellido;
    private Integer telefono;
    private Integer sueldo;

    public Profesor() {
    }

    public Profesor(Integer documento, String nombre, String apellido, Integer telefono, Integer sueldo) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.sueldo = sueldo;
    }

    public Integer getSueldo() {
        return sueldo;
    }

    public void setSueldo(Integer sueldo) {
        this.sueldo = sueldo;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Profesor{" + "documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", sueldo=" + sueldo + '}';
    }
    
    
}
