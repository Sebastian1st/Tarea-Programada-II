
public class Operaciones
{
    private Nodo inicio;
    private int tamanio;

    public Operaciones()
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
    
    public void agregarAlFinal(int valor, String incognita,int potencia)
    {
        Nodo nuevoNodo = new Nodo();
        nuevoNodo.setValor(valor);
        nuevoNodo.setIncognita(incognita);
        nuevoNodo.setPotencia(potencia);
        
        
        
        if(esVacia())
        {
            inicio = nuevoNodo;
        }
        else
        {
            Nodo auxiliar = inicio;
            
            while(auxiliar.getSiguiente() != null)
            {
                auxiliar = auxiliar.getSiguiente();
            }
            
            auxiliar.setSiguiente(nuevoNodo);
        }
        
        tamanio++;
    }
}
