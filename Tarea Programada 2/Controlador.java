import javax.swing.JOptionPane;
public class Controlador
{
    public static void controller() 
    {
        // LLAMAR TODAS LAS CLASES
        Vista vista = new Vista();
        Operaciones operaciones = new Operaciones(); 
        int contador = 0;
        //si es ingreso Manual 

        if (vista.solicitarEntradaDeDatos() == true)
        {

            String incognita;
            int valor;
            int potencia;

            boolean volverAlMenu = true;
            while (volverAlMenu == true)
            {   
                //Define las variables para agregar un nodo 
                contador++;
                valor = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor"));
                incognita = JOptionPane.showInputDialog("Digite la incognita");
                potencia = Integer.parseInt(JOptionPane.showInputDialog("A que potencia esta elevada la incógnita anterior?"));
                // agregar un nodo a la lista
                operaciones.agregarAlFinal(valor,incognita,potencia);
                //consulta al usuario si desea agregar mas nodos
                Object opcionmenu = JOptionPane.showInputDialog(null,"C A L C U L A D O R A ",
                        "Desea introducir otro dato?", JOptionPane.QUESTION_MESSAGE, null,
                        new Object[] { "Sí","No",},
                        "Sí");

                if (opcionmenu == "No"){
                    JOptionPane.showMessageDialog(null,"Has ingresado "+contador + "ecuaciones" );
                    contador= 0;
                    volverAlMenu=false;
                }
            }

        }
        else
        {
            String nombre;
            nombre = JOptionPane.showInputDialog("Escriba el nombre del archivo");
            Lector lector = new Lector(nombre);

            System.out.print(lector.leerArchivo());
        }

    }

}
