package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Ecuacion ecua = new Ecuacion();

        Lector lector = new Lector();

        ecua = lector.separarElementos("1x^2-3x^2-4x^1-5x^1-4");

        Ecuacion simplificada = ecua.simplificar();

        simplificada.imprimirEcuacion();
    }
}
