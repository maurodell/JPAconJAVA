/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curso.servicios;

import java.util.Scanner;

/**
 *
 * @author mdo
 */
public class Service {
            Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        
            AlumnoServicio serviceAlumno = new AlumnoServicio();
            ProfesorServicio servicioProfesor = new ProfesorServicio();
            
public void menuAlumno(){
            boolean flag = false;
            while(!flag){
            System.out.println("Que quiere hacer?\n"
                            + "1. Crear Alumno\n"
                            + "2. Editar Alumno\n"
                            + "3. Eliminar Alumno\n"
                            + "4. Mostrar Listado Completo\n"
                            + "5. Mostrar Lista por Nombre de Alumno\n"
                            + "6. SALIR");
            int option = teclado.nextInt();
            
            switch(option){
                case 1:
                    System.out.print("Ingrese el documento del Alumno: ");
                    Integer documento = teclado.nextInt();
                    System.out.print("Ingrese el nombre del Alumno: ");
                    String nombre = teclado.next();
                    System.out.print("Ingrese el apellido del Alumno: ");
                    String apellido = teclado.next();
                    System.out.print("Ingrese la edad: ");
                    Integer edad = teclado.nextInt();
                    
                    serviceAlumno.crearAlumno(documento, nombre, apellido, edad);
                    break;
                case 2:
                    System.out.print("Ingrese el documento del Alumno a buscar: ");
                    Integer doc_buscar = teclado.nextInt();
                    System.out.print("Ingrese el nombre a Modificar: ");
                    String nombre_mod = teclado.next();
                    
                    serviceAlumno.editarAlumno(doc_buscar, nombre_mod);
                    break;
                case 3:
                    System.out.print("Ingrese el documento del alumno a Eliminar: ");
                    Integer doc_eliminar = teclado.nextInt();
                    serviceAlumno.borrarAlumno(doc_eliminar);
                    break;
                case 4:
                    System.out.println("Lista completa Alumnos: ");
                    serviceAlumno.imprimirAlumnos();
                    break;
                case 5:
                    System.out.print("Ingrese el nombre del Alumno: ");
                    String nom_mostrar = teclado.next();
                    serviceAlumno.imprimirAlumosNombre(nom_mostrar);
                    break;
                case 6:
                    flag = true;
                    break;
            }
        }
    }
public void menuProfesor(){
            boolean flag = false;
            while(!flag){
            System.out.println("Que quiere hacer?\n"
                            + "1. Crear Profesor\n"
                            + "2. Editar Profesor\n"
                            + "3. Eliminar Profesor\n"
                            + "4. Mostrar Listado Completo\n"
                            + "5. SALIR");
            int option = teclado.nextInt();
            
            switch(option){
                case 1:
                    System.out.print("Ingrese el documento del Profesor: ");
                    Integer documento = teclado.nextInt();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = teclado.next();
                    System.out.print("Ingrese el apellido: ");
                    String apellido = teclado.next();
                    System.out.print("Ingrese la telefono: ");
                    Integer telefono = teclado.nextInt();
                    System.out.print("Ingrese la sueldo: ");
                    Integer sueldo = teclado.nextInt();
                    
                    servicioProfesor.crearProfesor(documento, nombre, apellido, telefono, sueldo);
                    break;
                case 2:
                    System.out.print("Ingrese el documento del Profesor a Editar: ");
                    Integer doc_buscar = teclado.nextInt();
                    System.out.print("Ingrese el nombre a Modificar: ");
                    String nombre_mod = teclado.next();
                    System.out.print("Ingrese el apellido a Modificar: ");
                    String apellido_mod = teclado.next();
                    System.out.print("Ingrese el telefono a Modificar: ");
                    Integer telefono_mod = teclado.nextInt();
                    System.out.println("Ingrese el sueldo a Modificar");
                    Integer sueldo_mod = teclado.nextInt();
                    
                    servicioProfesor.modificarProfesor(doc_buscar, nombre_mod, apellido_mod, telefono_mod, sueldo_mod);
                    break;
                case 3:
                    System.out.print("Ingrese el documento del Profesor a Eliminar: ");
                    Integer doc_eliminar = teclado.nextInt();
                    servicioProfesor.borrarProfesor(doc_eliminar);
                    break;
                case 4:
                    System.out.println("Lista completa Alumnos: ");
                    servicioProfesor.imprimirProfesores();
                    break;
                case 5:
                    flag=true;
                    break;
            }
        }
    } 
 
}
