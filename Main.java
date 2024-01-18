import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Jugador {
    String nombre;
    String posicion;

    public Jugador(String nombre, String posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Posición: " + posicion;
    }
}

class Equipo {
    String nombreEquipo;
    String estadio;
    int cantidadTitulos;
    List<Jugador> titulares;
    List<Jugador> suplentes;

    public Equipo(String nombreEquipo, String estadio, int cantidadTitulos, List<Jugador> titulares, List<Jugador> suplentes) {
        this.nombreEquipo = nombreEquipo;
        this.estadio = estadio;
        this.cantidadTitulos = cantidadTitulos;
        this.titulares = titulares;
        this.suplentes = suplentes;
    }

    // Métodos para generar los reportes
    public void generarReporteBasico() {
        System.out.println("Reporte Básico:");
        System.out.println("Nombre del equipo: " + nombreEquipo);
        System.out.println("Títulos ganados: " + cantidadTitulos);
        System.out.println("Cantidad total de jugadores: " + (titulares.size() + suplentes.size()));
    }

    public void generarReporteDetallado() {
        System.out.println("Reporte Detallado:");
        System.out.println("Nombre del equipo: " + nombreEquipo);
        System.out.println("Titulares:");
        for (Jugador titular : titulares) {
            System.out.println(titular);
        }
        System.out.println("Suplentes:");
        for (Jugador suplente : suplentes) {
            System.out.println(suplente);
        }
    }
}

// Clase principal que contiene el programa
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese información del equipo:");
        System.out.print("Nombre del equipo: ");
        String nombreEquipo = scanner.nextLine();
        System.out.print("Estadio del equipo: ");
        String estadio = scanner.nextLine();
        System.out.print("Cantidad de títulos: ");
        int cantidadTitulos = scanner.nextInt();

        List<Jugador> titulares = ingresarJugadores("titulares");

        List<Jugador> suplentes = ingresarJugadores("suplentes");

        // Crear objeto Equipo con la información ingresada
        Equipo equipo = new Equipo(nombreEquipo, estadio, cantidadTitulos, titulares, suplentes);

        // Menú de reportes
        int opcion;
        do {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Reporte Básico");
            System.out.println("2. Reporte Detallado");
            System.out.println("0. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    equipo.generarReporteBasico();
                    break;
                case 2:
                    equipo.generarReporteDetallado();
                    break;
                case 0:
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }

    // Método para ingresar la información de los jugadores
    private static List<Jugador> ingresarJugadores(String tipoJugador) {
        Scanner scanner = new Scanner(System.in);
        List<Jugador> jugadores = new ArrayList<>();

        System.out.print("Ingrese la cantidad de " + tipoJugador + ": ");
        int cantidadJugadores = scanner.nextInt();

        for (int i = 1; i <= cantidadJugadores; i++) {
            System.out.println("Ingrese información del " + tipoJugador + " #" + i + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.next();
            System.out.print("Posición: ");
            String posicion = scanner.next();

            Jugador jugador = new Jugador(nombre, posicion);
            jugadores.add(jugador);
        }

        return jugadores;
    }

    // Clase de prueba
    static class PruebaEquipo {
        public static void main(String[] args) {
            // Datos de prueba
            List<Jugador> titulares = new ArrayList<>();
            titulares.add(new Jugador("Lionel Messi", "Delantero"));
            titulares.add(new Jugador("Sergio Ramos", "Defensa"));
            titulares.add(new Jugador("Kevin De Bruyne", "Centrocampista"));

            List<Jugador> suplentes = new ArrayList<>();
            suplentes.add(new Jugador("Mohamed Salah", "Delantero"));
            suplentes.add(new Jugador("Virgil van Dijk", "Defensa"));
            suplentes.add(new Jugador("N'Golo Kanté", "Centrocampista"));

            // Crear objeto Equipo con datos de prueba
            Equipo equipoPrueba = new Equipo("FC Barcelona", "Camp Nou", 26, titulares, suplentes);

            // Mostrar el menú de reportes y probar diferentes opciones
            equipoPrueba.generarReporteBasico();
            equipoPrueba.generarReporteDetallado();
        }
    }
}
