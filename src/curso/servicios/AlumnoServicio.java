/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.servicios;

import curso.entidades.Alumno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author mdo
 */
public class AlumnoServicio {
    
    public void crearAlumno(Integer pDocumento, String pNombre, String pApellido, Integer pEdad){
        //EntityManager em = Persistence.createEntityManagerFactory("ClaseJPAPU").createEntityManager();
        EntityManager em = Persistence.createEntityManagerFactory("CursoPU").createEntityManager();//el objeto 'em' nos permite acceder a las funcionalidades de JPA

        //lo primero que se hace es iniciar una transacción
        em.getTransaction().begin();//-->modifican datos en las BD, NO PARA CONSULTAS
        Alumno _alumno = new Alumno();
            _alumno.setDocumento(pDocumento);
            _alumno.setNombre(pNombre);
            _alumno.setApellido(pApellido);
            _alumno.setEdad(pEdad);
        //guardamos
        em.persist(_alumno);//con el persist hago una petision para que se guarden los datos,
                                                              //creamos los datos y guardamos, luego tenemos que confirmar esa transacció

       //confirmamos la transacción  
       em.getTransaction().commit(); 
    }
    public void editarAlumno(Integer pDocumento, String pNombre){
        EntityManager em = Persistence.createEntityManagerFactory("CursoPU").createEntityManager();
        
        em.getTransaction().begin();
        //JPA tiene un metodo Find que busca datos
        Alumno _alumno = em.find(Alumno.class, pDocumento);//Alumno.class hace referencia a la clase Alumno y luego pongo la llave primaria
        
        _alumno.setNombre(pNombre);
        
        //cuando estamos editando(modificar algo que ya existe) se usa el modificador MERGE
        em.merge(_alumno);
        em.getTransaction().commit();
    }
    public void borrarAlumno(Integer pDocumento){
        EntityManager em = Persistence.createEntityManagerFactory("CursoPU").createEntityManager();
        
        em.getTransaction().begin();
        
        Alumno _alumno = em.find(Alumno.class, pDocumento);
        
        em.remove(_alumno);
        
        em.getTransaction().commit();
    }
    //JPA reconoce solo listas
    public List<Alumno> buscarAlumnoNombre(String pNombre){
        EntityManager em = Persistence.createEntityManagerFactory("CursoPU").createEntityManager();
        
        
        List<Alumno> _alumnos = em.createQuery("SELECT c FROM Alumno c WHERE c.nombre LIKE :pNombre")//lenguaje para hacer la query es jpql - son query para mysql
                .setParameter("pNombre","%"+pNombre+"%")//-->acá le digo que el parametro nombre que le paso al query pNombre
                .getResultList();//-->devuelve el resultado de la lista
        
        return _alumnos;
    }
    public void imprimirAlumosNombre(String pNombre){
        List<Alumno> _alumno = buscarAlumnoNombre(pNombre);
        
        for (Alumno alumno : _alumno) {
            System.out.println(alumno);
        }
    }
    public void imprimirAlumnos(){
        try {
            EntityManager em = Persistence.createEntityManagerFactory("CursoPU").createEntityManager();
        
            List<Alumno> _alumno = em.createQuery("SELECT c FROM Alumno c")
                .getResultList();

        for (Alumno alumno : _alumno) {
            System.out.println(alumno);
        }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
