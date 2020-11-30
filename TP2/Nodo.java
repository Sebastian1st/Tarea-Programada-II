/**
 *Nodos de la lista
 *
 * @Sebastián Soto y Alessandro Pani
 * @version (a version number or a date)
 */
public class Nodo{
    //atributos
    float valor;
    String incognita;
    int potencia;
    Nodo next;
    //constructor sobre cargado
    Nodo(float valor, String variable, int potencia){
        this.valor = valor;
        this.incognita = variable;
        this.potencia = potencia;
        this.next = null;
    }
    
    //tostring
    public void imprimirNodo(){

        System.out.println(Float.toString(this.valor)+this.incognita+"^"+Integer.toString(this.potencia));

    }

    
    
    //get y setters
    
    //valor
    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    //incognita
    public String getIncognita() {
        return incognita;
    }

    public void setIncognita(String incognita) {
        this.incognita = incognita;
    }
    //potencia
    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }
    //siguiente
    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }

}