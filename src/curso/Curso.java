package curso;

import curso.servicios.Service;
import java.util.Scanner;

/**
 *
 * @author mdo
 */
public class Curso {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in).useDelimiter("\n");
        Service menu = new Service();
        while(true){
            System.out.println("***SELECCIÓN SOBRE QUIEN VA A OPERAR***\n"
                            + "1. ALUMNO\n"
                            + "2. PROFESOR\n"
                            + "3. CURSOS\n"
                            + "4. SALIR");
            byte option = teclado.nextByte();
            switch(option){
                case 1:
                    menu.menuAlumno();
                    break;
                case 2:
                    menu.menuProfesor();
                    break;
                case 3:
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Dato ingresado no valido");
                    break;
            }
        }
    }
    
}
