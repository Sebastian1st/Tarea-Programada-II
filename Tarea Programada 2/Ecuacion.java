package com.company;

public class Ecuacion{
    Nodo root;
    int tamano = 0;

    public Nodo getNodo(int ind){
        Nodo actual = root;
        int cont = 0;
        while(cont != ind){
            actual = actual.next;
            cont +=1;
        }

        return actual;
    }

    public int getMaxExponente(){

        int max = 0;

        for (int i = 0; i < this.tamano; i++) {
            if(max < this.getNodo(i).potencia){
                max = this.getNodo(i).potencia;
            }
        }

        return max;
    }

    public void agregarNodo(int valor, String variable, int potencia){
        Nodo nuevoNodo = new Nodo(valor, variable, potencia);

        if(root == null){
            this.root = nuevoNodo;
            this.tamano +=1;
        }
        else{
            Nodo actual = root;
            while(actual.next != null){
                actual = actual.next;
            }
            actual.next = nuevoNodo;
            this.tamano +=1;

        }
    }

    public void agregarNodo(Nodo nuevoNodo){

        if(root == null){
            this.root = nuevoNodo;
            this.tamano +=1;

        }
        else{
            Nodo actual = root;
            while(actual.next != null){
                actual = actual.next;
            }
            actual.next = nuevoNodo;
            this.tamano +=1;

        }
    }

    public void imprimirEcuacion(){

        Nodo current = this.root;
        int ind = 0;
        while(current != null){

            if(current.incognita.equals("")){

                if(current.valor < 0){
                    System.out.println(Integer.toString(current.valor));
                }
                else{
                    System.out.println("+"+Integer.toString(current.valor));
                }

            }
            else {

                if (current.valor < 0) {
                    System.out.println(Integer.toString(current.valor) + current.incognita + "^" + Integer.toString(current.potencia));
                } else {
                    if(ind == 0){
                        System.out.println(Integer.toString(current.valor) + current.incognita + "^" + Integer.toString(current.potencia));
                        ind +=1;
                    }
                    else {
                        System.out.println("+" + Integer.toString(current.valor) + current.incognita + "^" + Integer.toString(current.potencia));
                    }
                }

            }
            current = current.next;

        }

    }

    public void simplificar(){

        Ecuacion resultado = new Ecuacion();

        int exponente = 0;



    }

}