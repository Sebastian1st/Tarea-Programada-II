public class NodoOperandos
{
    

    private String operando;
    private NodoOperandos siguiente;
    public void NodoOperandos()
    {

        this.operando = "";
        this.siguiente = null;
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
