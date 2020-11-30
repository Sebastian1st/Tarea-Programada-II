package com.company;

public class Ecuacion{
    Nodo root;
    int tamano = 0;

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

            if(current.incognita.equals("") || current.potencia == 0){

                if(current.valor < 0){
                    System.out.print(Integer.toString(current.valor));
                }
                else{
                    System.out.print("+"+Integer.toString(current.valor));
                }

            }
            else {

                if (current.valor < 0) {
                    System.out.print(Integer.toString(current.valor) + current.incognita + "^" + Integer.toString(current.potencia));
                    if(ind == 0){
                        ind+=1;
                    }
                } else {
                    if(ind == 0){
                        System.out.print(Integer.toString(current.valor) + current.incognita + "^" + Integer.toString(current.potencia));
                        ind +=1;
                    }
                    else {
                        System.out.print("+" + Integer.toString(current.valor) + current.incognita + "^" + Integer.toString(current.potencia));
                    }
                }

            }
            current = current.next;

        }

    }

    public Ecuacion simplificar(){

        Ecuacion resultado = new Ecuacion();

        int exponente = getMaxExponente();



        while(exponente != -1){
            //Operar los nodos
            Nodo nodoRes = new Nodo(0,"x", exponente);

            for (int i = 0; i < this.tamano; i++) {

                Nodo actual = this.getNodo(i);
                if(actual.potencia == exponente){

                    nodoRes.valor += actual.valor;

                }
            }

            if(nodoRes.valor != 0) {
                resultado.agregarNodo(nodoRes);
            }

            exponente-=1;

        }

        return resultado;

    }


    public Nodo getNodo(int ind){
        Nodo actual = root;
        int cont = 0;
        while(cont != ind){
            actual = actual.next;
            cont +=1;
        }

        return actual;
    }

    private int getMaxExponente(){

        int max = 0;

        for (int i = 0; i < this.tamano; i++) {
            if(max < this.getNodo(i).potencia){
                max = this.getNodo(i).potencia;
            }
        }

        return max;
    }


}