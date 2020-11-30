package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Ecuacion ecua = new Ecuacion();

        Lector lector = new Lector();

        ecua = lector.separarElementos("4x^2-5x^1+3");
        Ecuacion ecua2 = lector.separarElementos("5x^3-4x^2+10x^1");

        Calculadora calcu = new Calculadora();

        Ecuacion resultado = calcu.operar(ecua, ecua2, "*");
        resultado.imprimirEcuacion();
    }
}
