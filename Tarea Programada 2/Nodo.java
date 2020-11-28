
public class Nodo
{
    private Nodo siguiente;
    private int valor;
    private String incognita;
    private int potencia;

    public void Nodo()
    {
        this.valor = 0;
        this.incognita = "";
        this.potencia = 0;
    }

    public int getValor()
    {
        return valor;
    }

    public void setValor(int valor)
    {
        this.valor = valor;
    }

    public String getIncognita()
    {
        return incognita;
    }

    public void setIncognita(String incognita)
    {
        this.incognita = incognita;
    }
    
    public void setPotencia(int potencia)
    {
        this.potencia = potencia;
    }
    public int getPotencia()
    {
        return potencia;
    }
    
    public Nodo getSiguiente()
    {
        return siguiente;
    }
    
    public void setSiguiente(Nodo siguiente)
    {
        this.siguiente = siguiente;
    }

    
}
