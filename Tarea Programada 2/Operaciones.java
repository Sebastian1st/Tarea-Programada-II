
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
}
