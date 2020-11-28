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
                valor = Integer.parseInt(JOptionPane.showInputDialog("digite el valor"));
                incognita = JOptionPane.showInputDialog("digite la incognita");
                potencia = Integer.parseInt(JOptionPane.showInputDialog("A que potencia esta elevada la potencia anterior?"));
                // agregar un nodo a la lista
                operaciones.agregarAlFinal(valor,incognita,potencia);
                //consulta al usuario si desea agregar mas nodos
                Object opcionmenu = JOptionPane.showInputDialog(null,"C A L C U L A D O R A ",
                        "Desea introducir otro dato?", JOptionPane.QUESTION_MESSAGE, null,
                        new Object[] { "Sí","No",},
                        "Sí");

                if (opcionmenu == "Salir"){
                    JOptionPane.showMessageDialog(null,"Has ingresado "+contador + "ecuaciones" );
                    contador= 0;
                    volverAlMenu=false;
                }
            }

        }
        //si es ingreso por archivo
        if (vista.solicitarEntradaDeDatos() == false)
        {

        }

    }

}
