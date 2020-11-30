package com.company;

public class Nodo{

    int valor;
    String incognita;
    int potencia;
    Nodo next;

    Nodo(int valor, String variable, int potencia){
        this.valor = valor;
        this.incognita = variable;
        this.potencia = potencia;
        this.next = null;
    }

    public void imprimirNodo(){

        System.out.println(Integer.toString(this.valor)+this.incognita+"^"+Integer.toString(this.potencia));

    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getIncognita() {
        return incognita;
    }

    public void setIncognita(String incognita) {
        this.incognita = incognita;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

}