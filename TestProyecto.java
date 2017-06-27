package Proyecto;
import java.util.Scanner;
/**
 *
 * @author Jeiel
 */
public class TestProyecto {
    
    public static void main(String[] args) {
        Scanner leer= new Scanner(System.in);
        
        System.out.println("En un banco existen 10 cajas para la atencion al cliente, (puedes seleccionar el numero de cajas)\n"
                + "Se utilizara la distribucion exponencial para hacer la linea de espera. \n\n");
        
        System.out.println("¿Cuantos cajeros deseas abrir?");
        Cajero c=new Cajero(leer.nextInt());
        c.antenderC();
        
        
        }
        
        
    }
    

