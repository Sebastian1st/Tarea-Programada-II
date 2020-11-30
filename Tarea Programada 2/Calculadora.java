package com.company;

import javax.annotation.processing.SupportedSourceVersion;

public class Calculadora {

    public Ecuacion operar(Ecuacion ecua1, Ecuacion ecua2, String operador){

        if(operador.equals("+")){
            System.out.println("Sumando Ecuaciones");
            return this.sumarEcuaciones(ecua1, ecua2);
        }
        else if(operador.equals("-")){
            return this.restarEcuaciones(ecua1, ecua2);
        }
        else if(operador.equals("/")){
            return this.dividirEcuaciones(ecua1, ecua2);
        }
        else if(operador.equals("*")){
            return this.multiplicarEcuaciones(ecua1, ecua2);
        }
        else{
            //MANEJAR ERROR >>>> OPERADOR NO SOPORTADO
            return null;
        }
    }

    private Ecuacion sumarEcuaciones(Ecuacion ecua1, Ecuacion ecua2){

        Ecuacion resultado = new Ecuacion();
        for (int i = 0; i < ecua1.tamano; i++) {
            Nodo nodo = ecua1.getNodo(i);

            Nodo nuevoNodo = new Nodo(nodo.valor, nodo.incognita, nodo.potencia);

            resultado.agregarNodo(nuevoNodo);
        }

        for(int i = 0; i< ecua2.tamano; i++){
            Nodo nodo = ecua2.getNodo(i);
            Nodo nuevoNodo = new Nodo(nodo.valor, nodo.incognita, nodo.potencia);

            resultado.agregarNodo(nuevoNodo);
        }

        Ecuacion ecuaFinal = resultado.simplificar();

        return ecuaFinal;

    }

    private Ecuacion restarEcuaciones(Ecuacion ecua1, Ecuacion ecua2){

        Ecuacion resultado = new Ecuacion();
        for (int i = 0; i < ecua1.tamano; i++) {
            Nodo nodo = ecua1.getNodo(i);

            Nodo nuevoNodo = new Nodo(nodo.valor, nodo.incognita, nodo.potencia);

            resultado.agregarNodo(nuevoNodo);
        }

        for(int i = 0; i< ecua2.tamano; i++){
            Nodo nodo = ecua2.getNodo(i);
            Nodo nuevoNodo = new Nodo(-1*nodo.valor, nodo.incognita, nodo.potencia);

            resultado.agregarNodo(nuevoNodo);
        }

        Ecuacion ecuaFinal = resultado.simplificar();

        return ecuaFinal;

    }


    private Ecuacion multiplicarEcuaciones(Ecuacion ecua1, Ecuacion ecua2){

        Ecuacion resultado = new Ecuacion();

        for (int i = 0; i < ecua1.tamano; i++) {

            for (int j = 0; j < ecua2.tamano; j++) {

                int valor = ecua1.getNodo(i).valor*ecua2.getNodo(j).valor;

                int potencia = ecua1.getNodo(i).potencia+ecua2.getNodo(j).potencia;

                Nodo nuevoNodo = new Nodo(valor,"x", potencia);

                nuevoNodo.imprimirNodo();
                resultado.agregarNodo(nuevoNodo);

            }

        }

        Ecuacion simplificada = resultado.simplificar();

        return simplificada;

    }

    private Ecuacion dividirEcuaciones(Ecuacion ecua1, Ecuacion ecua2){
        return null;
    }


}
