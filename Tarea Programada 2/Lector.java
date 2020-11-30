package com.company;

public class Lector {

    public String quitarEspacios(String ecua){
        String resultado = "";
        for (int i = 0; i < ecua.length(); i++) {

            if(ecua.substring(i, i+1).isBlank()){
                continue;
            }
            else {
                resultado = resultado + ecua.substring(i, i+1);
            }
        }

        return resultado;
    }

    public Ecuacion separarElementos(String ecua){

        System.out.println(ecua);

        Ecuacion ecuacion = new Ecuacion();

        String operadores[] = {"+", "-", "*", "/"};

        boolean esNegativo = false;

        int indice = 0;
        for (int i = 0; i < ecua.length(); i++) {

            //Revisando si el elemento es un operador
            for(int j = 0; j < 4; j++){
                String ele = ecua.substring(i, i+1);

                if(indice == 0 && i == 0){
                    if(ele.equals(operadores[1])){
                        esNegativo = true;
                        indice +=1;
                        break;
                    }
                }


                if(ele.equals(operadores[j])){
                    if(esNegativo){

                        Nodo nuevoNodo = this.convertirEnNodo("-"+ecua.substring(indice, i));
                        ecuacion.agregarNodo(nuevoNodo);

                        if(ele.equals(operadores[1])){
                            esNegativo = true;
                        }
                        else{
                            esNegativo = false;
                        }

                    }
                    else {
                        if(ele.equals(operadores[1])){
                            esNegativo = true;
                        }
                        Nodo nuevoNodo = this.convertirEnNodo(ecua.substring(indice, i));
                        ecuacion.agregarNodo(nuevoNodo);
                    }
                    indice = i+1;
                    break;
                }
            }
        }

        if(esNegativo){
            Nodo nuevoNodo = this.convertirEnNodo("-"+ecua.substring(indice));
            ecuacion.agregarNodo(nuevoNodo);
        }
        else{
            Nodo nuevoNodo = this.convertirEnNodo(ecua.substring(indice));
            ecuacion.agregarNodo(nuevoNodo);
        }

        return ecuacion;

    }

    private boolean esNumero(String elemento){
        String numeros[] = {"0","1","2","3","4","5","6","7","8","9"};

        for(int i = 0; i < 10; i++) {

            if(elemento.matches(numeros[i])){
                return true;
            }

        }
        return false;
    }

    public Nodo convertirEnNodo(String elemento){
        boolean esNegativo = false;
        int inicio = 0;
        if(elemento.substring(0,1).matches("-")){
            esNegativo = true;
            inicio = 1;
        }

        boolean numeroEncontrado = false;
        boolean incognitaEncontrada = false;
        boolean potenciaEncontrada = false;

        String numString = "";

        int indice = 0;

        //Recorriendo el elemento completo
        for (int i = inicio; i < elemento.length(); i++) {

            //Revisando si el elemento no es un numero
            String subele = elemento.substring(i, i + 1);
            if(!esNumero(subele)){
                numeroEncontrado = true;
                indice = i;
                break;
            }
            else{
                numString += subele;
            }
        }

        int valor = Integer.valueOf(numString);

        if(esNegativo){
            valor = -1*valor;
        }


        String incognita = "";

        for (int i = indice; i < elemento.length(); i++) {

            //Revisando si el elemento no es un numero
            String subele = elemento.substring(i, i + 1);
            if(subele.equals("^")){
                incognitaEncontrada = true;
                indice = i;
                break;
            }
            else{
                incognita += subele;
            }
        }
        int potencia;

        if(incognitaEncontrada) {
            potencia = Integer.valueOf(elemento.substring(indice + 1, elemento.length()));
        }
        else{
            potencia = 0;
        }

        if(incognita.equals(Integer.toString(valor))){
            incognita = "";
        }

        Nodo nuevoNodo = new Nodo(valor, incognita, potencia);
        return nuevoNodo;
    }


}
