
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        // Objeto que administra los aspirantes
        RegistroAspirante registro = new RegistroAspirante();

        int opcion = 0;

        // El programa continúa hasta elegir la opción 4
        while (opcion != 4) {

            System.out.println();
            System.out.println("================================");
            System.out.println("      REGISTRO DE ASPIRANTES");
            System.out.println("================================");
            System.out.println("1. Agregar aspirante");
            System.out.println("2. Buscar aspirante");
            System.out.println("3. Mostrar aspirantes");
            System.out.println("4. Salir");
            System.out.println("================================");
            System.out.print("Seleccione una opción: ");

            try {

                opcion = Integer.parseInt(teclado.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("\nDebe ingresar un número.");
                continue;
            }

            switch (opcion) {

                // =========================================
                // OPCIÓN 1: AGREGAR ASPIRANTE
                // =========================================
                case 1:

                    System.out.println();
                    System.out.println("================================");
                    System.out.println("       NUEVO ASPIRANTE");
                    System.out.println("================================");

                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine().trim();

                    System.out.print("Primer apellido: ");
                    String p_apellido = teclado.nextLine().trim();

                    System.out.print("Segundo apellido: ");
                    String s_apellido = teclado.nextLine().trim();

                    System.out.print("Edad: ");
                    int edad;

                    try {

                        edad = Integer.parseInt(teclado.nextLine());

                    } catch (NumberFormatException e) {

                        System.out.println(
                                "La edad debe ser un número."
                        );

                        break;
                    }

                    System.out.print("Dirección: ");
                    String direccion = teclado.nextLine().trim();

                    System.out.print("Teléfono: ");
                    String telefono = teclado.nextLine().trim();

                    System.out.print("Fecha de nacimiento: ");
                    String fecha_nacimiento =
                            teclado.nextLine().trim();

                    System.out.print("Correo electrónico: ");
                    String email = teclado.nextLine().trim();

                    System.out.print("Redes sociales: ");
                    String r_sociales =
                            teclado.nextLine().trim();

                    System.out.print("Carrera de interés: ");
                    String c_interes =
                            teclado.nextLine().trim();

                    System.out.print("Escuela de procedencia: ");
                    String e_procedencia =
                            teclado.nextLine().trim();

                    System.out.print("Bachillerato cursado: ");
                    String b_cursado =
                            teclado.nextLine().trim();

                    // Verificar datos mínimos para generar folio
                    if (nombre.length() < 2
                            || p_apellido.length() < 2
                            || telefono.length() < 6) {

                        System.out.println();
                        System.out.println(
                                "No se puede generar el folio."
                        );

                        System.out.println(
                                "El nombre debe tener al menos 2 caracteres,"
                        );

                        System.out.println(
                                "el apellido al menos 2 y el teléfono 6."
                        );

                        break;
                    }

                    // Generar folio
                    String folio =
                            nombre.substring(0, 2).toUpperCase()
                            + p_apellido.substring(0, 2).toUpperCase()
                            + telefono.substring(0, 6)
                            + String.format(
                                    "%03d",
                                    registro.getCantidad() + 1
                            );

                    // Mostrar folio generado
                    System.out.println();
                    System.out.println("Folio generado: " + folio);

                    // Crear aspirante
                    ASPIRANTE aspirante = new ASPIRANTE(
                            folio,
                            nombre,
                            p_apellido,
                            s_apellido,
                            edad,
                            direccion,
                            telefono,
                            fecha_nacimiento,
                            email,
                            r_sociales,
                            c_interes,
                            e_procedencia,
                            b_cursado
                    );

                    // Guardar aspirante
                    registro.agregarAspirante(aspirante);

                    System.out.println();
                    System.out.println(
                            "Aspirante registrado correctamente."
                    );

                    break;

                // =========================================
                // OPCIÓN 2: BUSCAR ASPIRANTE
                // =========================================
                case 2:

                    if (registro.getCantidad() == 0) {

                        System.out.println();
                        System.out.println(
                                "No hay aspirantes registrados."
                        );

                        break;
                    }

                    System.out.println();
                    System.out.println("================================");
                    System.out.println("      BUSCAR ASPIRANTE");
                    System.out.println("================================");
                    System.out.println("1. Buscar por ficha");
                    System.out.println("2. Buscar por folio");
                    System.out.print("Seleccione una opción: ");

                    int tipoBusqueda;

                    try {

                        tipoBusqueda =
                                Integer.parseInt(teclado.nextLine());

                    } catch (NumberFormatException e) {

                        System.out.println(
                                "Debe ingresar un número."
                        );

                        break;
                    }

                    if (tipoBusqueda == 1) {

                        System.out.print(
                                "Ingrese el número de ficha: "
                        );

                        try {

                            int numeroFicha =
                                    Integer.parseInt(
                                            teclado.nextLine()
                                    );

                            registro.buscarAspirante(numeroFicha);

                        } catch (NumberFormatException e) {

                            System.out.println(
                                    "La ficha debe ser un número."
                            );
                        }

                    } else if (tipoBusqueda == 2) {

                        System.out.print(
                                "Ingrese el folio: "
                        );

                        String folioBuscar =
                                teclado.nextLine().trim();

                        registro.buscarPorFolio(folioBuscar);

                    } else {

                        System.out.println(
                                "Opción de búsqueda no válida."
                        );
                    }

                    break;

                // =========================================
                // OPCIÓN 3: MOSTRAR TODOS
                // =========================================
                case 3:

                    registro.mostrarListaAspirantes();

                    break;

                // =========================================
                // OPCIÓN 4: SALIR
                // =========================================
                case 4:

                    System.out.println();
                    System.out.println(
                            "Programa terminado."
                    );

                    break;

                // =========================================
                // OPCIÓN NO VÁLIDA
                // =========================================
                default:

                    System.out.println();
                    System.out.println(
                            "Opción no válida."
                    );
            }
        }

        teclado.close();
    }
}
