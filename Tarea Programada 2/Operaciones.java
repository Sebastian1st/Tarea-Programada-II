
public class Operaciones
{
    private Nodo inicio;

    private int tamanio;
    int contadorUsosMetodoPrint= 0;
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

    public int obtenerValorDePosicion(int posicion)
    {
        Nodo auxiliar = inicio;
        for (int i = 0; i<posicion; i++)
        {
            auxiliar = auxiliar.getSiguiente();
        }
        return auxiliar.getValor();
    }

    public int obtenerPotenciaDePosicion(int posicion)
    {
        Nodo auxiliar = inicio;
        for (int i = 0; i<posicion; i++)
        {
            auxiliar = auxiliar.getSiguiente();
        }
        return auxiliar.getPotencia();
    }

    public void imprimirDatoDeLista(int posicion)
    {

        if(!esVacia())
        {
            Nodo auxiliar = inicio;
            for (int i = 0; i<posicion; i++)
            {
                auxiliar = auxiliar.getSiguiente();
            }

            System.out.print(auxiliar.getValor()+auxiliar.getIncognita()+"^"+ auxiliar.getPotencia()+" ");

        }
    }

}
