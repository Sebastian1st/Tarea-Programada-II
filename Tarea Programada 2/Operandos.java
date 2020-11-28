
/**
 * Write a description of class Operandos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Operandos
{
    // instance variables - replace the example below with your own
    private NodoOperandos inicio;
    private int tamanio;

    public void Lista()
    {
        inicio = null;
        tamanio = 0;
    }

    public boolean esVacia()
    {
        return inicio == null;
    }
    
    public int getTamanio()
    {
        return tamanio;
    }
    public void agregarAlFinal(String operando)
    {
        NodoOperandos nuevoNodo = new NodoOperandos();
        nuevoNodo.setOperando(operando);
        
        if(esVacia())
        {
            inicio = nuevoNodo;
        }
        else
        {
            NodoOperandos auxiliar = inicio;
            
            while(auxiliar.getSiguiente() != null)
            {
                auxiliar = auxiliar.getSiguiente();
            }
            
            auxiliar.setSiguiente(nuevoNodo);
        }
        
        tamanio++;
    }
}
