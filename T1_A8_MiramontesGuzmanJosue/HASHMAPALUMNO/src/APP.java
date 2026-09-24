import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class APP {

    private static final HashMap<Integer, ALUMNO> listaAlumnos = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void main(String[] args) {
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> llenarLista();
                case 2 -> vaciarLista();
                case 3 -> mostrarPorCarrera();
                case 4 -> calcularPromedioEdades();
                case 5 -> mostrarInscriptosDespuesDe();
                case 6 -> System.out.println("\n¡Saliendo del programa!");
                default -> System.out.println("\n❌ Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 6);
    }

    private static void mostrarMenu() {
        System.out.println("\n========================================");
        System.out.println("       GESTIÓN DE ALUMNOS (HashMap)");
        System.out.println("========================================");
        System.out.println("1) Llenar lista (5 Alumnos)");
        System.out.println("2) Vaciar lista");
        System.out.println("3) Mostrar alumnos por carrera");
        System.out.println("4) Calcular promedio de edades");
        System.out.println("5) Mostrar alumnos inscritos después de 10/08/2016");
        System.out.println("6) Salir");
    }

    // 1) Llenar lista con 5 alumnos leídos desde teclado
    private static void llenarLista() {
        if (!listaAlumnos.isEmpty()) {
            System.out.println("\n⚠️ La lista ya contiene alumnos. Vacíela primero si desea volver a llenarla.");
            return;
        }

        System.out.println("\n--- REGISTRO DE 5 ALUMNOS ---");

        for (int i = 1; i <= 5; i++) {
            System.out.println("\n--- Alumno #" + i + " ---");
            
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();

            int edad = leerEntero("Edad: ");

            // Selección de carrera
            String carrera = seleccionarCarrera();

            // Lectura y validación de fecha
            LocalDate fechaInscripcion = leerFecha("Fecha de inscripción (dd/MM/yyyy): ");

            // Crear objeto y guardar en HashMap con clave numéricas (1, 2, 3, 4, 5)
            ALUMNO alumno = new ALUMNO(nombre, edad, carrera, fechaInscripcion);
            listaAlumnos.put(i, alumno);
        }

        System.out.println("\n✅ Se registraron exitosamente los 5 alumnos.");
    }

    // 2) Vaciar lista
    private static void vaciarLista() {
        if (listaAlumnos.isEmpty()) {
            System.out.println("\n⚠️ La lista ya está vacía.");
        } else {
            listaAlumnos.clear();
            System.out.println("\n🗑️ Se ha vaciado la lista de alumnos correctamente.");
        }
    }

    // 3) Mostrar los alumnos por carrera
    private static void mostrarPorCarrera() {
        if (comprobarListaVacia()) return;

        System.out.println("\n--- SELECCIONE LA CARRERA ---");
        System.out.println("1) ISC (Ingeniería en Sistemas Computacionales)");
        System.out.println("2) IIA (Ingeniería en Industrias Alimentarias)");
        System.out.println("3) IM  (Ingeniería Mecatrónica)");
        System.out.println("4) LA  (Licenciatura en Administración)");
        System.out.println("5) CP  (Contador Público)");

        int opCarrera = leerEntero("Selección: ");
        String carreraBuscada = switch (opCarrera) {
            case 1 -> "ISC";
            case 2 -> "IIA";
            case 3 -> "IM";
            case 4 -> "LA";
            case 5 -> "CP";
            default -> null;
        };

        if (carreraBuscada == null) {
            System.out.println("❌ Opción de carrera no válida.");
            return;
        }

        System.out.println("\n--- ALUMNOS DE LA CARRERA " + carreraBuscada + " ---");
        boolean encontrado = false;

        for (ALUMNO alumno : listaAlumnos.values()) {
            if (alumno.getCarrera().equalsIgnoreCase(carreraBuscada)) {
                System.out.println(alumno);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No hay alumnos registrados en la carrera " + carreraBuscada + ".");
        }
    }

    // 4) Calcular Promedio de edades
    private static void calcularPromedioEdades() {
        if (comprobarListaVacia()) return;

        int sumaEdades = 0;
        for (ALUMNO alumno : listaAlumnos.values()) {
            sumaEdades += alumno.getEdad();
        }

        double promedio = (double) sumaEdades / listaAlumnos.size();
        System.out.printf("\n📊 El promedio de edad de los %d alumnos es: %.2f años%n", 
                listaAlumnos.size(), promedio);
    }

    // 5) Mostrar alumnos inscritos después del 10/08/2016
    private static void mostrarInscriptosDespuesDe() {
        if (comprobarListaVacia()) return;

        LocalDate fechaLimite = LocalDate.of(2016, 8, 10);
        System.out.println("\n--- ALUMNOS INSCRITOS DESPUÉS DEL 10/08/2016 ---");

        boolean encontrado = false;
        for (ALUMNO alumno : listaAlumnos.values()) {
            if (alumno.getFechaInscripcion().isAfter(fechaLimite)) {
                System.out.println(alumno);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron alumnos inscritos después del 10/08/2016.");
        }
    }

    // --- MÉTODOS AUXILIARES ---

    private static String seleccionarCarrera() {
        while (true) {
            System.out.println("Carreras disponibles: 1) ISC  2) IIA  3) IM  4) LA  5) CP");
            int opcion = leerEntero("Seleccione la carrera (1-5): ");
            switch (opcion) {
                case 1: return "ISC";
                case 2: return "IIA";
                case 3: return "IM";
                case 4: return "LA";
                case 5: return "CP";
                default: System.out.println("❌ Selección inválida. Elija entre 1 y 5.");
            }
        }
    }

    private static LocalDate leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                return LocalDate.parse(entrada, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("❌ Formato de fecha incorrecto. Intente de nuevo con el formato dd/MM/yyyy (ejemplo: 12/09/2025).");
            }
        }
    }

    private static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                int valor = Integer.parseInt(scanner.nextLine().trim());
                if (valor >= 0) return valor;
                System.out.println("❌ Ingrese un número mayor o igual a cero.");
            } catch (NumberFormatException e) {
                System.out.println("❌ Entrada inválida. Debe ingresar un número entero.");
            }
        }
    }

    private static boolean comprobarListaVacia() {
        if (listaAlumnos.isEmpty()) {
            System.out.println("\n⚠️ No hay alumnos registrados en el HashMap.");
            return true;
        }
        return false;
    }
}
