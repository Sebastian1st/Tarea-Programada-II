package com.company;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        Ecuacion ecua = new Ecuacion();

        Lector lector = new Lector();

        ecua = lector.separarElementos("1x^2-3x^5-4x^1-5x^3-4");

        System.out.println(ecua.getNodo(4).potencia);

    }
}
