import java.util.Scanner;

public class TiempoEnTexto {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("¿Desea ingresar la hora manualmente? (Si/No): ");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("Si")) {
            // Solicitar entrada del usuario al ejecutar el programa
            System.out.print("Ingrese la hora (1-11): ");
            int horas = scanner.nextInt();

            System.out.print("Ingrese los minutos (0-59): ");
            int minutos = scanner.nextInt();

            imprimirTiempoEnPalabras(horas, minutos, false);
        } else if (respuesta.equalsIgnoreCase("No")) {
            ejecutarPruebas();
        } else {
            System.out.println("Respuesta no válida. Ingrese 'Si' o 'No'.");
        }
        scanner.close();
    }

    public static void imprimirTiempoEnPalabras(int horas, int minutos, boolean esEjecucionDePruebas) {
        String[] unidades = new String[]{"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis",
                "siete", "ocho", "nueve"};

        String[] especiales = new String[]{"diez", "once", "doce", "trece", "catorce", "quince", "dieciseis",
                "diecisiete", "dieciocho", "diecinueve"};

        String[] decenas = new String[]{"", "", "veinte", "treinta", "cuarenta", "cincuenta"};

        if (horas < 1 || horas > 11 || minutos < 0 || minutos > 59) {
            System.out.println("Hora no válida.");
            System.out.println("------------------------");
            return;
        }

        System.out.print(convertirNumeroATexto(horas));

        if (minutos == 0) {
            System.out.println(" en punto");
        } else if (minutos == 15) {
            System.out.println(" y cuarto");
        } else if (minutos == 30) {
            System.out.println(" y media");
        } else if (minutos == 45) {
            System.out.println(" menos cuarto");
        } else {
            if (minutos < 10) {
                System.out.println(" y " + convertirNumeroATexto(minutos) + " minutos");
            } else if (minutos < 20) {
                System.out.println(" y " + especiales[minutos - 10] + " minutos");
            } else {
                int dIndex = minutos / 10;
                int uIndex = minutos % 10;
                String unidadesTexto = (uIndex > 0) ? " y " + unidades[uIndex] : "";
                System.out.println(" y " + decenas[dIndex] + unidadesTexto + " minutos");
            }
        }

        if (esEjecucionDePruebas) {
            System.out.println("------------------------");
        }
    }

    public static String convertirNumeroATexto(int numero) {
        String unidades[] = new String[]{"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis",
                "siete", "ocho", "nueve"};

        if (numero < 10) {
            return unidades[numero];
        }
        //el número no es valido
        return null;
    }

    public static void ejecutarPruebas() {
        imprimirTiempoEnPalabras(0, 0, true);
        imprimirTiempoEnPalabras(7, 10, true);
        imprimirTiempoEnPalabras(2, 20, true);
        imprimirTiempoEnPalabras(8, 30, true);
        imprimirTiempoEnPalabras(4, 40, true);
        imprimirTiempoEnPalabras(5, 50, true);
        imprimirTiempoEnPalabras(12, 59, true);
        imprimirTiempoEnPalabras(3, 0, true);
        imprimirTiempoEnPalabras(9, 60, true);
    }
}
