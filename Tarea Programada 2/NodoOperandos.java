public class NodoOperandos
{
    private NodoOperandos siguiente;
    
    private String operando;
    

    public void Nodo()
    {
        
        this.operando = "";
        
    }

    public String getOperando()
    {
        return operando;
    }

    public void setOperando(String operando)
    {
        this.operando = operando;
    }

    public NodoOperandos getSiguiente()
    {
        return siguiente;
    }
    
    public void setSiguiente(NodoOperandos siguiente)
    {
        this.siguiente = siguiente;
    }

    
    }
