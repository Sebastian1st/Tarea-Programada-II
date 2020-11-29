
/**
 * Write a description of class Calculadora here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Calculadora
{
    public void Calcular()
    {
        Operaciones operaciones = new Operaciones();
        Operandos operandos = new Operandos();
        int tamanioOperaciones = operaciones.getTamanio();
        int tamanioOperandos = operandos.getTamanio();   

        int valor1;
        int valor2;
        int Potencia1;
        int Potencia2;
        int resultadoValor;
        //entra el primero de la lista 
        
        valor1 = obtenerValorDePosicion(1);
            /**
            for (int i=0; i<=tamanioOperaciones; i++){

            switch (operator) {
            case '+':
            result = first + second;
            break;

            case '-':
            result = first - second;
            break;

            case '*':
            result = first * second;
            break;

            case '/':
            result = first / second;
            break;

            // operator doesn't match any case constant (+, -, *, /)
            default:
            System.out.printf("Error! operator is not correct");
        return;
        }

        System.out.println(first + " " + operator + " " + second + " = " + result);
         **/
    }
}

