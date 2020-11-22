
public class Nodo
{
    private int valor;
    private int incognita;
    private int potencia;

    public void Nodo()
    {
        this.valor = 0;
        this.incognita = 0;
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

    public int getIncognita()
    {
        return incognita;
    }

    public void setIncognita(int incognita)
    {
        this.incognita = incognita;
    }
    
    public int getPotencia()
    {
        return potencia;
    }

    public void setPotencia(int potencia)
    {
        this.potencia = potencia;
    }
}
