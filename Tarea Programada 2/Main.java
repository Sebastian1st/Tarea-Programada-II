package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Ecuacion ecua = new Ecuacion();

        Lector lector = new Lector();

        ecua = lector.separarElementos("4x^2");
        Ecuacion ecua2 = lector.separarElementos("5x^3");

        Calculadora calcu = new Calculadora();

        Ecuacion resultado = calcu.operar(ecua, ecua2, "/");




        try{
            System.out.println(resultado.aString());
        }
        catch (Exception e){
            System.err.println(e);
        }

        Escritor escritor = new Escritor();
        escritor.escribir("nombre", ecua, ecua2, "/", resultado);

    }
}
