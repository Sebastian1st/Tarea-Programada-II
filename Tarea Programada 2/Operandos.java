
/**
 * Write a description of class Operandos here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Operandos
{
    // instance variables - replace the example below with your own
    private NodoOperandos inicioOperandos;
    private int tamanio;

    public void Lista()
    {
        inicioOperandos = null;
        tamanio = 0;
    }

    public boolean esVacia()
    {
        return inicioOperandos == null;
    }
    
    public int getTamanio()
    {
        return tamanio;
    }
    
    public void imprimirLista()
    {
        if(!esVacia())
        {
            NodoOperandos auxiliarOperandos = inicioOperandos;
            int posicion = 0;
            
            while(auxiliarOperandos.getSiguiente() != null)
            {
                System.out.println("Posicion: " + posicion + " Valor: " + auxiliarOperandos.getOperando());
                auxiliarOperandos = auxiliarOperandos.getSiguiente();
                posicion++;
            }
            
            System.out.println("Posicion: " + posicion + " Valor: " + auxiliarOperandos.getOperando());
        }
    }
    public void imprimirOperandoSolicitado(int posicion)
    {   
            NodoOperandos auxiliarOperandos = inicioOperandos;
            if (posicion >= 0 && posicion <= tamanio) 
            {
                for (int i = 0; i<posicion ;i++)
                {
                    auxiliarOperandos  = auxiliarOperandos.getSiguiente();
                }
                System.out.println(auxiliarOperandos.getOperando());
            }
            
        
        
    
    }
    public void agregarOperando(String operando)
    {
        NodoOperandos nuevoNodo = new NodoOperandos();
        nuevoNodo.setOperando(operando);
        
        if(esVacia())
        {
            inicioOperandos = nuevoNodo;
        }
        else
        {
            NodoOperandos auxiliarOperandos = inicioOperandos;
            
            while(auxiliarOperandos.getSiguiente() != null)
            {
                auxiliarOperandos = auxiliarOperandos.getSiguiente();
            }
            
            auxiliarOperandos.setSiguiente(nuevoNodo);
        }
        
        tamanio++;
    }
}
