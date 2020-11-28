import javax.swing.JOptionPane;
public class MainArchivos
{
    public static void main (String [] args)
    {
        //Escritor escritor = new Escritor("Ecuacion.txt");
        
        //escritor.escribir("(2x^2+4)+(3x-7)\r\n");
       
        
        //escritor.cerrar();
        
        String nombre;
        nombre = JOptionPane.showInputDialog("Escriba el nombre del archivo");
        Lector lector = new Lector(nombre);
        
        System.out.print(lector.leerArchivo());
    }
}
