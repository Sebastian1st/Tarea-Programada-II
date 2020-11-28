
public class Operaciones
{
    private Nodo inicio;
    private NodoOperandos inicioOperandos;
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
    
    public void agregarDatos(int valor, String incognita,int potencia)
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
    
    public void imprimirLista()
    {
        Operandos operandos = new Operandos();
        int contador= 0;
        if(!esVacia())
        {
            Nodo auxiliar = inicio;
            NodoOperandos auxiliarOperandos = inicioOperandos;
            int posicion = 0;
            
            while(auxiliar.getSiguiente() != null)
            {
                
                if (contador != 0 && auxiliarOperandos.getSiguiente() != null)
                {
                    //operandos.imprimirOperandoSolicitado(contador);
                    auxiliarOperandos= auxiliarOperandos.getSiguiente();
                    contador++;
                }
                else
                {
                    //no imprime operando
                    System.out.print(auxiliar.getValor()+auxiliar.getIncognita()+"^"+ auxiliar.getPotencia()+" ");
                }
                
                
                auxiliar = auxiliar.getSiguiente();
                
                
            }
            //LLamar un metodo que imprime el operando
            //operandos.imprimirOperandoSolicitado(contador);
            
            System.out.print(auxiliar.getValor()+auxiliar.getIncognita()+"^"+ auxiliar.getPotencia()+" ");
        }
    }
    
}
