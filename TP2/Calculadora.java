/**
 *  Calculadora del programa
 *
 * @Sebastián Soto y Alessandro Pani
 * @version (a version number or a date)
 */
public class Calculadora {
    //operar entre ecuaciones
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
            System.out.println("Error: Operador no soportado. Solamente se permiten sumas, restas, multiplicaciones y divisiones");
            return null;
        }
    }
    //suma 
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
    //resta
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
    //multplicacion
    private Ecuacion multiplicarEcuaciones(Ecuacion ecua1, Ecuacion ecua2){

        Ecuacion resultado = new Ecuacion();

        for (int i = 0; i < ecua1.tamano; i++) {

            for (int j = 0; j < ecua2.tamano; j++) {

                float valor = ecua1.getNodo(i).valor*ecua2.getNodo(j).valor;

                int potencia = ecua1.getNodo(i).potencia+ecua2.getNodo(j).potencia;

                Nodo nuevoNodo = new Nodo(valor,"x", potencia);
                resultado.agregarNodo(nuevoNodo);

            }

        }

        Ecuacion simplificada = resultado.simplificar();

        return simplificada;

    }
    //division
    private Ecuacion dividirEcuaciones(Ecuacion ecua1, Ecuacion ecua2){

        if(ecua1.tamano > 1 || ecua2.tamano > 1){

            System.out.println("Error en la division: Ambas ecuaciones deben ser monomios");
            return null;
        }

        else{

            Ecuacion resultado = new Ecuacion();

            float valor = ecua1.getNodo(0).valor/ecua2.getNodo(0).valor;
            int potencia = ecua1.getNodo(0).potencia-ecua2.getNodo(0).potencia;


            Nodo nuevoNodo = new Nodo(valor,"x",potencia);
            resultado.agregarNodo(nuevoNodo);

            return resultado;

        }
    }
    

}