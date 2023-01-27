package mpViviendas;

import java.util.Scanner;
import mnViviendas.*;
import java.lang.reflect.InvocationTargetException;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

/**
 *
 * @author KEREN
 */
    public class Principal extends javax.swing.JFrame{

    static Procesador p = new Procesador();
    static Scanner escribir = new Scanner(System.in);
    static Scanner escribirLinea = new Scanner(System.in);
    
    //MENU
    public static void main(String[] args)throws InterruptedException, InvocationTargetException {

        p.separarData();
        Scanner s = new Scanner(System.in);

        int op;
        // Menu de Opciones

        while (true) {
            System.out.println("**************************************");
            System.out.println("Bienvenidos a la seccion de viviendas");
            System.out.println("1.Consultar si ya su casa se encuentra registrada");
            System.out.println("2.consultar el puntaje");
            System.out.println("3.consultar grafica");
            System.out.println("4.Consultar grafica circular");
            System.out.println("5.Salir");
            System.out.println("Digite su opcion");
            op = s.nextInt();

            if (op >= 1 && op <= 5) {
                switch (op) {

                    case 1 ->
                         opcionUno();
                    case 2 ->
                        opcionDos();
                    case 3 ->
                        opcionTres();
                    case 4 ->
                        opcionCuatro();
                    case 5->
                        opcionCinco();

                }
            } else {
                System.out.println(" No seleccionaste un opción valida, intentelo nuevamente.");
            }

        }

    }

    public static void opcionUno() {
        int cedula;
        System.out.println("\nDigite su cedula");
        cedula = escribir.nextInt();

        if (p.buscarCiudadano(cedula) != true) {
            System.out.println("Usted no se encuentra registrado");
            System.out.println("Bienvenido a planificacion Urbana");
            
            System.out.println("\nDigite su nombre completo");
            String nombre = escribirLinea.nextLine();

            System.out.println("\nCuenta usted con una cisterna en su casa?");
            System.out.println("1) Si");
            System.out.println("2) No");
            int cisterna = escribir.nextInt();
            if (cisterna <1 || cisterna >2 ){
                System.out.println("\ningrese valor 1 0 2");
                 System.out.println("Cuenta usted con una cisterna en su casa?");
                System.out.println("1) Si");
                System.out.println("2) No");
                cisterna = escribir.nextInt();
            }

            System.out.println("\nUtiliza las 3 R para desechar sus residuos?");
            System.out.println("1) Si");
            System.out.println("2) No");
            int canecas = escribir.nextInt();
             if (canecas <1 || canecas>2 ){
                System.out.println("\ningrese valor 1 0 2");
                System.out.println("Utiliza las 3 R para desechar sus residuos?");
                System.out.println("1) Si");
                System.out.println("2) No");
                canecas = escribir.nextInt();
            }

            System.out.println("\nCuenta usted con una iluminacion natural?");
            System.out.println("1) Si");
            System.out.println("2) No");
            int iluminacionInteligente = escribir.nextInt();
             if (iluminacionInteligente <1 || iluminacionInteligente >2 ){
                System.out.println("\ningrese valor 1 0 2");
                System.out.println("Cuenta usted con una iluminacion natural?");
                System.out.println("1) Si");
                System.out.println("2) No");
                iluminacionInteligente = escribir.nextInt();
            }

            System.out.println("\nUsted utiliza luces ahorradoras?");
            System.out.println("1) Si");
            System.out.println("2) No");
            int lucesAhorro = escribir.nextByte();
            if (lucesAhorro <1 || lucesAhorro >2 ){
                System.out.println("\ningrese valor 1 0 2");
                System.out.println("Usted utiliza luces ahorradoras?");
                System.out.println("1) Si");
                System.out.println("2) No");
                lucesAhorro = escribir.nextByte();
            }

            System.out.println("\nCon que materiales ecologicos construyo su vivienda");
            System.out.println("1) Bambú");
            System.out.println("2) Paneles de Trigo");
            System.out.println("3) Madera");
            System.out.println("4) Pintura Ecologica");
            System.out.println("5) Todas las anteriores");
            System.out.println("6) Ninguna de las anteriores");
            int material = escribir.nextInt();
            if (material <1 || material  >10){
                System.out.println("\ningrese valor 1 hasta el 6");
                System.out.println("seleccione un material que utilizo para la construccion de su vivienda");
                System.out.println("1) Bambú");
                System.out.println("2) Paneles Solares");
                System.out.println("3) Madera");
                System.out.println("4) Pintura Ecologica");
                System.out.println("5) Todas las anteriores");
                System.out.println("6) Ninguna de las anteriores");
                material = escribir.nextInt();
            }

            Vivienda v = new Vivienda(new Ciudadano(nombre, cedula), cisterna, canecas, iluminacionInteligente, lucesAhorro, material);
            p.adicionarVivienda(v);

        } else {
            System.out.println("Su vivienda ya se encuentra registrada");

        }

    }

    public static void opcionDos() {
        int cedula;
        System.out.println("Digite su cedula para consultar el puntaje");
        cedula = escribir.nextInt();

        if (p.buscarCiudadano(cedula) == true) {
            System.out.println(p.puntajeGeneral(cedula));
            System.out.println("Estos son los porcentajes de las personas que hacen usos de recursos ecologicos en sus viviendas");
            System.out.println(p.promedioCaneca());
            System.out.println(p.promedioCisterna());
            System.out.println(p.promedioIlumintel());
            System.out.println(p.promedioLuzahorro());
        }else 
            System.out.println("registrese para poder consultar su puntaje");

    }
   
    public static void opcionTres()throws InterruptedException, InvocationTargetException {
    SwingUtilities.invokeAndWait(()->{
            Grafica ejemplo = new Grafica();
            ejemplo.setSize (800, 400);
            ejemplo.setLocationRelativeTo(null);
            ejemplo.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            ejemplo.setVisible(true);
        });
    }
    
    public static void opcionCuatro() {
        java.awt.EventQueue.invokeLater(() -> {
            new Circular().setVisible(true);
        });
    }
    
    public static void opcionCinco() {
        p.guardarDatos();
        System.exit(0);
    }
    
}
