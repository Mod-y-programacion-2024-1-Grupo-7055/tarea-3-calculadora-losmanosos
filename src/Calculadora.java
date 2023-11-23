import java.util.Scanner;
import java.util.StringTokenizer;

import javax.swing.SwingUtilities;



/**
 *
 * @author Alejandro Hernández Mora <alejandrohmora@ciencias.unam.mx>
 */
public class Calculadora {
    static Compilador comp;

   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ErrorDeSintaxisException {
        boolean run = true;
        comp = new Compilador();
        
        while(run){
        Scanner sc1=new Scanner(System.in);
        System.out.println("Ingresa tu operacion: \nrecuerda que los operadores son +,-,*,/,s,t,c,r" );
        try{
            String cadena=sc1.nextLine();
            StringTokenizer lexemas = comp.analisisLexico(cadena);
            CompositeEA nodo = comp.arbolDeAnalisisSintactico(lexemas);
            System.out.println(nodo);
            System.out.println(nodo.evalua());
        } catch(ErrorDeSintaxisException ese){
            System.out.println("No tiene sentido we");
            run = true;
        }

        boolean manoso =true;
        while(manoso){
        System.out.println("Quieres realizar otra operacion? \n-y\n-n");
        String respuesta=sc1.nextLine();
            switch (respuesta) {
                case "y":
                    run=true;
                    manoso=false;
                    break;
                case "n":
                    run=false;
                    manoso=false;
                    break;
                default:
                    System.out.println("Por favor ingresa yes o no ");
                    manoso=true;
            }
        }
        
    }
    
}
private static double evaluarExpresion(CompositeEA expresion) {
    return expresion.evalua();
}
}