 import javax.swing.JOptionPane;
/**
 * Write a description of class Vista here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MenuPrincipal
{
   public static void menuPrincipal() {
        //Se encarga de mostrar menu principal
        boolean volveralmenu= true;
        while (volveralmenu== true){
            Object opcionmenu = JOptionPane.showInputDialog(null,"M E N U   P R I N C I P A L  ",
                    "Calculadora", JOptionPane.QUESTION_MESSAGE, null,
                    new Object[] { "Seleccione una opción","Introducir Datos","Salir"  },
                    "Seleccione");

            if (opcionmenu == "Introducir Datos"){
               Controlador.controller(); 
            }
            if (opcionmenu == "Salir"){
                JOptionPane.showMessageDialog(null,"Gracias por usarme :D" );
                volveralmenu=false;
            }
        }
    }
}
