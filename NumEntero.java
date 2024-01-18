import java.util.Scanner;

public class NumEntero {

    public static void main(String[] args) {
        ProcesoNumerico();
    }

    public static void ProcesoNumerico() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Ingrese un número positivo (o escriba 'stop' para detener el programa):");

            // Verificar si el usuario quiere detener el programa
            String input = scanner.next();
            if (input.equalsIgnoreCase("stop")) {
                System.out.println("¡Programa detenido!");
                break;  // Salir del bucle
            }

            procesarNumero(input);

        } while (true);

        scanner.close();
    }

    public static void procesarNumero(String input) {
        if (input.equalsIgnoreCase("stop")) {
            System.out.println("¡Programa detenido!");
        } else {
            try {
                int n = Integer.parseInt(input);
                if (n >= 1 && n <= 100) {
                    if (n % 2 != 0) {
                        System.out.println("Quipux");
                    } else {
                        if (n >= 2 && n <= 5) {
                            System.out.println("No Quipux");
                        } else if (n >= 6 && n <= 20) {
                            System.out.println("Quipux");
                        } else if (n > 20 && n % 2 == 0) {
                            System.out.println("No Quipux");
                        }
                    }
                } else {
                    System.out.println("Número fuera de rango.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        }
    }

    public static class TestNumEntero {

        public static void main(String[] args) {
            // Crear una instancia de la clase NumEntero para probar
            NumEntero numEntero = new NumEntero();

            // Probar con datos preestablecidos
            int[] casosDePrueba = { 7, 4, 12, 24, 105 };

            for (int i = 0; i < casosDePrueba.length; i++) {
                int numero = casosDePrueba[i];
                System.out.println("Número de prueba: " + numero);

                // Llamar al método ProcesoNumerico con el número de prueba
                numEntero.procesarNumero(Integer.toString(numero));
                System.out.println("------------------------");
            }

            // Probar con "stop" para detener el programa
            System.out.println("Ingresando 'stop' para detener el programa:");
            numEntero.procesarNumero("stop");
        }
    }
}
