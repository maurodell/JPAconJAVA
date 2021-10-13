/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.entidades;

import java.security.Identity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 *
 * @author mdo
 */
@Entity
public class Alumno {
    @Id
    //@GeneratedValue(strategy = Identity)//genedator automatico
    private Integer documento;
    private String nombre;
    private String apellido;
    private Integer edad;

    public Alumno() {
    }

    public Alumno(Integer documento, String nombre, String apellido, Integer edad) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
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

    @Override
    public String toString() {
        return "Alumno{" + "documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + '}';
    }
    
}
