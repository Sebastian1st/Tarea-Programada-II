import javax.swing.JOptionPane;
public class Controlador
{
    public static void controller() 
    {
        // LLAMAR TODAS LAS CLASES
        Vista vista = new Vista();
        Operaciones operaciones = new Operaciones(); 
        Operandos operandos = new Operandos();
        int contador = 0;
        //si es ingreso Manual 

        if (vista.solicitarEntradaDeDatos() == true)
        {
            contador = 0;
            String incognita;
            int valor;
            int potencia;
            String operando;
            boolean volverAlMenu = true;
            while (volverAlMenu == true)
            {   
                //Define las variables para agregar un nodo 
                if (contador == 0)
                {
                    valor = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor"));
                    incognita = JOptionPane.showInputDialog("Digite la incognita");
                    potencia = Integer.parseInt(JOptionPane.showInputDialog("A que potencia esta elevada la incógnita anterior?"));
                    // agregar un nodo a la lista
                    operaciones.agregarDatos(valor,incognita,potencia);
                    //consulta al usuario si desea agregar mas nodos
                    contador++;
                    
                    Object opcionmenu = JOptionPane.showInputDialog(null,"C A L C U L A D O R A ",
                            "Desea introducir otro dato?", JOptionPane.QUESTION_MESSAGE, null,
                            new Object[] { "Sí","No",},
                            "Sí");

                    if (opcionmenu == "No"){
                        JOptionPane.showMessageDialog(null,"Has ingresado "+contador + " ecuaciones." );
                        contador= 0;
                        volverAlMenu=false;
                    }
                }
                else{    
                    //pedir el operando
                    
                    Object opcionOperando = JOptionPane.showInputDialog(null,"seleccione un operando?",
                            "C A L C U L A D O R A", JOptionPane.QUESTION_MESSAGE, null,
                            new Object[] { "+","-","*","/"},
                            "+");
                    if (opcionOperando == "+"){
                        operando= "+";
                        operandos.agregarOperando(operando);
                    }
                    if (opcionOperando == "-"){
                        operando= "-";
                        operandos.agregarOperando(operando);
                    }
                    if (opcionOperando == "*"){
                        operando= "*";
                        operandos.agregarOperando(operando);
                    }
                    if (opcionOperando == "/"){
                        operando= "/";
                        operandos.agregarOperando(operando);
                    }
                    
                    valor = Integer.parseInt(JOptionPane.showInputDialog("Digite el valor"));
                    incognita = JOptionPane.showInputDialog("Digite la incognita");
                    potencia = Integer.parseInt(JOptionPane.showInputDialog("A que potencia esta elevada la incógnita anterior?"));
                    // agregar un nodo a la lista
                    operaciones.agregarDatos(valor,incognita,potencia);
                    //consulta al usuario si desea agregar mas nodos
                    contador++;
                    Object opcionmenu = JOptionPane.showInputDialog(null,"C A L C U L A D O R A ",
                            "Desea introducir otro dato?", JOptionPane.QUESTION_MESSAGE, null,
                            new Object[] { "Sí","No",},
                            "Sí");

                    if (opcionmenu == "No"){
                        JOptionPane.showMessageDialog(null,"Has ingresado "+contador + " ecuaciones." );   
                        volverAlMenu=false;
                    }
                    
                    
                }
            }   
            //PARA ESTA PARTE YA SE CREO LA ECUACION
            
            
            //MOSTRAR ORDENADA LA ECUACION 
            for (int i=0;i<contador;i++)
            {
                if (i==0)
                {
                    operaciones.imprimirDatoDeLista(i);
                }
                else{
                    operandos.imprimirDatoDeLista(i-1);
                    operaciones.imprimirDatoDeLista(i);
                }
            }
            
            //CALCULO
            
            
            
        }
        else
        {
            String nombre;
            nombre = JOptionPane.showInputDialog("Escriba el nombre del archivo");
            Lector lector = new Lector("C:/Users/sebas/OneDrive/Desktop/Tarea-Programada-II/Tarea Programada 2/Archivos/"+ nombre);

            System.out.print(lector.leerArchivo());
        }

    }

}
