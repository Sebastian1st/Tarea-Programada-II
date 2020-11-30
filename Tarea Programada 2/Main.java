package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        boolean corriendo = true;
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream
        Lector lector = new Lector();
        Calculadora calcu = new Calculadora();
        Escritor escritor = new Escritor();

        while(corriendo){

            System.out.println("1. Ingresar ecuaciones manualmente");
            System.out.println("2. Ingresar ecuaciones desde un archivo");
            System.out.println("3. Instrucciones de uso");
            System.out.println("4. Salir");
            System.out.println();
            System.out.print("Ingrese el número de la opcion: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Las ecuaciones deben tener la forma Ax^b+Bx^c. Se asume que la variable siempre sera X. Si el exponente es 1, se debe indicar como Ax^1.");
                    System.out.println("Ingrese la primera ecuacion: ");
                    sc.nextLine();
                    String ecuaString1 = sc.nextLine();

                    System.out.println("Ingrese el operador (Opciones: +, -, *, /): ");
                    String operador = sc.nextLine();

                    System.out.println("Ingrese la segunda ecuacion: ");
                    String ecuaString2 = sc.nextLine();

                    Ecuacion ecua1 = lector.separarElementos(ecuaString1);
                    Ecuacion ecua2 = lector.separarElementos(ecuaString2);


                    try{
                        Ecuacion resultado = calcu.operar(ecua1, ecua2, operador);
                        System.out.println("Resultado:");
                        resultado.imprimirEcuacion();
                        System.out.println();
                        System.out.println("-------------------------------------");
                        System.out.println("Ingrese el nombre del archivo para almacenar el resultado: ");
                        String nombre = sc.nextLine();

                        escritor.escribir(nombre, ecua1, ecua2, operador, resultado);
                        System.out.println("El archivo se creara al terminar la ejecucion");
                    }
                    catch (Exception e){
                            System.err.println("Se ha producido un error. Revise sus entradas e intentelo de nuevo");
                        }
                    break;
                case 2:
                    System.out.println("Las ecuaciones deben ser de la forma ECUACION|OPERADOR|ECUACION");
                    System.out.println("Ingrese el nombre del archivo donde se encuentra la ecuacion. Se debe encontrar en la carpeta de Archivos: ");
                    String nombre = sc.nextLine();
                    nombre = sc.nextLine();
                    try {
                        Ecuacion resultado = lector.leerDeArchivo(nombre);
                        System.out.println("-------------------------------------");

                    }
                    catch (Exception e){
                        System.err.println("Se ha producido un error. Revise sus entradas e intentelo de nuevo");
                    }
                    break;
                case 3:
                    System.out.println("Instrucciones");
                    break;
                case 4:
                    corriendo = false;
                    break;
            }
            System.out.println();
        }

        if(false) {
            System.out.println("Hello World!");

            Ecuacion ecua = new Ecuacion();


            ecua = lector.separarElementos("4x^2");
            Ecuacion ecua2 = lector.separarElementos("5x^3");


            Ecuacion resultado = calcu.operar(ecua, ecua2, "/");


            try {
                System.out.println(resultado.aString());
            } catch (Exception e) {
                System.err.println(e);
            }

            escritor.escribir("nombre", ecua, ecua2, "/", resultado);
        }

    }
}
