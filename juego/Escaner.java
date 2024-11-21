package juego;

import java.util.Scanner;

import juego.cartas.Carta;
import juego.tablero.Movimiento;
import juego.tablero.estructuras.Lista;

public class Escaner {
    
    // ATRIBUTOS DE CLASE -------------------------------------------------------------------------
    private static Scanner scanner = new Scanner(System.in);

    // ATRIBUTOS -----------------------------------------------------------------------------------
    // CONSTRUCTORES -------------------------------------------------------------------------------
    public Escaner() {
    }

    // METODOS DE CLASE ----------------------------------------------------------------------------
    
    /**
     * Método de clase para preguntar por un número entero.
     * @param mensaje Mensaje que se muestra al usuario.
     * @return Número entero ingresado por el usuario.
     */
    public static int preguntarEntero(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextInt();
    }

    /**
     * Método de clase para preguntar por un número decimal.
     * @param mensaje Mensaje que se muestra al usuario.
     * @return Número decimal ingresado por el usuario.
     */
    public static double preguntarDecimal(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextDouble();
    }

    /**
     * Método de clase para preguntar por una cadena de texto.
     * @param mensaje Mensaje que se muestra al usuario.
     * @return Cadena de texto ingresada por el usuario.
     */
    public static String preguntarTexto(String mensaje) {
        System.out.println(mensaje);
        scanner.nextLine(); // Limpiar el buffer.
        return scanner.nextLine();
    }

    /**
     * Método de clase para preguntar por un booleano.
     * @param mensaje Mensaje que se muestra al usuario.
     * @return Valor booleano ingresado por el usuario.
     */
    public static boolean preguntarBooleano(String mensaje) {
        System.out.println(mensaje + " (true/false): ");
        return scanner.nextBoolean();
    }

    /**
     * Método de clase para preguntar por un movimiento basado en el enum Movimiento.
     * @return Movimiento seleccionado por el usuario.
     */
    public static Movimiento preguntarMovimiento() {
        System.out.println("Elige un movimiento escribiendo su nombre:");
        for (Movimiento movimiento : Movimiento.values()) {
            System.out.println("- " + movimiento);
        }
        
        Movimiento seleccionado = null;
        boolean valido = false;

        do {
            String entrada = scanner.nextLine().toUpperCase();
            try {
                seleccionado = Movimiento.valueOf(entrada);
                valido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada no válida. Por favor, escribe un movimiento válido.");
            }
        } while (!valido);

        return seleccionado;
    }
    
    /**
     * Método de clase para preguntar qué carta desea usar el usuario.
     * @param cartas Lista de cartas disponibles.
     * @return La carta seleccionada o null si el usuario decide no usar ninguna.
     * @throws Exception 
     */
    public static Carta preguntarCarta(Lista<Carta> cartas) throws Exception {
        System.out.println("¿Qué carta quieres usar? (Escribe el número correspondiente o '0' para no usar ninguna):");
        for (int i = 1; i < cartas.getLongitud(); i++) {
            System.out.println((i) + ". " + cartas.obtener(i).getTitulo());
        }
        System.out.println("0. No usar ninguna carta");

        Carta seleccionada = null;
        boolean valido = false;

        do {
            int opcion = preguntarEntero("Selecciona una opción:");
            if (opcion == 0) {
                valido = true; // El usuario no quiere usar ninguna carta.
            } else if (opcion > 0 && opcion <= cartas.getLongitud()) {
                seleccionada = cartas.obtener(opcion - 1);
                valido = true;
            } else {
                System.out.println("Opción inválida. Por favor, selecciona un número válido.");
            }
        } while (!valido);

        return seleccionada;
    }
    
    /**
     * Método de clase para preguntar por un número de tipo Long.
     * @param mensaje Mensaje que se muestra al usuario.
     * @return Número Long ingresado por el usuario.
     */
    public static Long preguntarLong(String mensaje) {
        System.out.println(mensaje);
        while (!scanner.hasNextLong()) {
            System.out.println("Entrada no válida. Por favor, introduce un número de tipo Long:");
            scanner.next(); // Limpiar la entrada inválida.
        }
        return scanner.nextLong();
    }
    
    // METODOS GENERALES ---------------------------------------------------------------------------
    // METODOS DE COMPORTAMIENTO -------------------------------------------------------------------
    // GETTERS SIMPLES -----------------------------------------------------------------------------
    // SETTERS SIMPLES -----------------------------------------------------------------------------
}
