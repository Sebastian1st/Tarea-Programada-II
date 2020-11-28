import javax.swing.JOptionPane;
/**
 * Write a description of class Vista here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vista
{
    public boolean solicitarEntradaDeDatos()
    {

        Object opcionmenu = JOptionPane.showInputDialog(null,"C A L C U L A D O R A ",
                "De que manera desea ingresar los datos a la calculadora?", JOptionPane.QUESTION_MESSAGE, null,
                new Object[] {"Introducir datos manualmente","Ingresar datos a través de .txt"},
                "Seleccione");

        if (opcionmenu == "Introducir datos manualmente"){
            return true;
        }
        if (opcionmenu == "Ingresar datos a través de .txt"){
            return false;
        }
        else{solicitarEntradaDeDatos();}
        return solicitarEntradaDeDatos();
    }
    
}

