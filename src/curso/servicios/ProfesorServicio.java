/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.servicios;

import curso.entidades.Profesor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author mdo
 */
public class ProfesorServicio {
        public final EntityManager em = Persistence.createEntityManagerFactory("CursoPU").createEntityManager();
    
    public void crearProfesor(Integer pDocumento, String pNombre, String pApellido, Integer pTelefono, Integer pSueldo){
        em.getTransaction().begin();
        
        em.persist(new Profesor(pDocumento, pNombre, pApellido, pTelefono, pSueldo));
        em.getTransaction().commit();
    }
    public void borrarProfesor(Integer pDocumento){
        em.getTransaction().begin();
        
        Profesor _profesor = em.find(Profesor.class, pDocumento);
        em.remove(_profesor);
        em.getTransaction().commit();
    }
    public void modificarProfesor(Integer pDocumento, String pNombre, String pApellido, Integer pTelefono, Integer pSueldo){
        em.getTransaction().begin();
        
        Profesor _profesor = em.find(Profesor.class, pDocumento);
        _profesor.setNombre(pNombre);
        _profesor.setApellido(pApellido);
        _profesor.setTelefono(pTelefono);
        _profesor.setSueldo(pSueldo);
        
        em.merge(_profesor);
        em.getTransaction().commit();
    }
    public List<Profesor> buscarProfesor(String pNombre){
        em.getTransaction().begin();
        
        List<Profesor> _auxProfesor = em.createQuery("SELECT c FROM Profesor WHERE c.nombre LIKE :pNombre")
                .setParameter("pNombre","%"+pNombre+"%")
                .getResultList();
        
        return _auxProfesor;
    }
}
