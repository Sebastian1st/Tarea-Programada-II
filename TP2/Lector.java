import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *Lector
 *
 * @Sebastián Soto y Alessandro Pani
 * @version (a version number or a date)
 */
public class Lector {
    //quita los espacios
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

    public Ecuacion leerDeArchivo(String nombre){
        //lee archivos try catch para evitar errores
        try {
            File myObj = new File("Archivos/"+nombre);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String datos = myReader.nextLine();
                return this.ecuacionDeArchivo(datos);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontro el archivo indicado");
            return null;
        }
        return null;
    }

    private Ecuacion ecuacionDeArchivo(String datos){
        Escritor escritor = new Escritor();
        Scanner sc= new Scanner(System.in);   
        String elementos[] = datos.split("\\|");
        Ecuacion ecua1 = this.separarElementos(elementos[0]);
        String operador = elementos[1];
        Ecuacion ecua2 = this.separarElementos(elementos[2]);


        Calculadora calcu = new Calculadora();

        Ecuacion resultado = calcu.operar(ecua1, ecua2, operador);

        System.out.println("Resultado:");
        resultado.imprimirEcuacion();

        System.out.println("Ingrese el nombre del archivo para almacenar el resultado: ");
        String nombre = sc.nextLine();

        escritor.escribir(nombre, ecua1, ecua2, operador, resultado);
        System.out.println("El archivo se creara al terminar la ejecucion");

        return resultado;
    }

    public Ecuacion separarElementos(String ecua){

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

        float valor = Float.valueOf(numString);
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

        if(incognita.equals(Float.toString(valor))){
            incognita = "";
        }

        Nodo nuevoNodo = new Nodo(valor, incognita, potencia);
        return nuevoNodo;
    }


}
