
public class Controlador
{
   public static void controller() 
   {
       // LLAMAR TODAS LAS CLASES
       Vista vista = new Vista();
       
       //si es ingreso Manual 
       if (vista.solicitarEntradaDeDatos() == false)
       {
        
        }
       //si es ingreso por archivo
       if (vista.solicitarEntradaDeDatos() == true)
       {
        
        }
      
    }
}
