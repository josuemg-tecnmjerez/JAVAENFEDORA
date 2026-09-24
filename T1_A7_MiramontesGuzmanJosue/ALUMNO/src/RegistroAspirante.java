
public class RegistroAspirante {

    // Arreglo donde se guardan los aspirantes
    private ASPIRANTE[] listaAspirantes = new ASPIRANTE[5];

    // Cantidad de aspirantes registrados
    private int cantidad = 0;

    public RegistroAspirante() {
    }

    // Agregar un aspirante
    public void agregarAspirante(ASPIRANTE aspirante) {

        // Si el arreglo está lleno, aumentar su tamaño
        if (cantidad == listaAspirantes.length) {

            ASPIRANTE[] nuevoArreglo =
                    new ASPIRANTE[listaAspirantes.length * 2];

            // Copiar los datos al nuevo arreglo
            for (int i = 0; i < listaAspirantes.length; i++) {
                nuevoArreglo[i] = listaAspirantes[i];
            }

            // Cambiar al nuevo arreglo
            listaAspirantes = nuevoArreglo;
        }

        // Guardar aspirante
        listaAspirantes[cantidad] = aspirante;

        // Aumentar cantidad
        cantidad++;
    }

    // Obtener cantidad de aspirantes
    public int getCantidad() {
        return cantidad;
    }

    // Mostrar todos los aspirantes
    public void mostrarListaAspirantes() {

        if (cantidad == 0) {
            System.out.println("\nNo hay aspirantes registrados.");
            return;
        }

        System.out.println("\n========================================");
        System.out.println("        ASPIRANTES REGISTRADOS");
        System.out.println("========================================");

        for (int i = 0; i < cantidad; i++) {

            ASPIRANTE aspirante = listaAspirantes[i];

            System.out.println();
            System.out.printf("Ficha de ingreso: %03d%n", i + 1);
            System.out.println("Folio: " + aspirante.getFolio());
            System.out.println("----------------------------------------");

            System.out.println("Nombre: "
                    + aspirante.getNombre());

            System.out.println("Primer apellido: "
                    + aspirante.getPrimerApellido());

            System.out.println("Segundo apellido: "
                    + aspirante.getSegundoApellido());

            System.out.println("Edad: "
                    + aspirante.getEdad());

            System.out.println("Dirección: "
                    + aspirante.getDireccion());

            System.out.println("Teléfono: "
                    + aspirante.getTelefono());

            System.out.println("Fecha de nacimiento: "
                    + aspirante.getFechaNacimiento());

            System.out.println("Correo electrónico: "
                    + aspirante.getEmail());

            System.out.println("Redes sociales: "
                    + aspirante.getRedesSociales());

            System.out.println("Carrera de interés: "
                    + aspirante.getCarreraInteres());

            System.out.println("Escuela de procedencia: "
                    + aspirante.getEscuelaProcedencia());

            System.out.println("Bachillerato cursado: "
                    + aspirante.getBachilleratoCursado());
        }
    }

    // Buscar por número de ficha
    public void buscarAspirante(int numeroFicha) {

        int posicion = numeroFicha - 1;

        if (posicion >= 0 && posicion < cantidad) {

            mostrarFicha(listaAspirantes[posicion], numeroFicha);

        } else {

            System.out.println("\nNo existe un aspirante con esa ficha.");
        }
    }

    // Buscar por folio
    public void buscarPorFolio(String folio) {

        for (int i = 0; i < cantidad; i++) {

            if (listaAspirantes[i].getFolio().equalsIgnoreCase(folio)) {

                mostrarFicha(listaAspirantes[i], i + 1);
                return;
            }
        }

        System.out.println("\nNo existe un aspirante con ese folio.");
    }

    // Mostrar los datos de un aspirante
    private void mostrarFicha(ASPIRANTE aspirante, int numeroFicha) {

        System.out.println();
        System.out.printf("Ficha de ingreso: %03d%n", numeroFicha);
        System.out.println("========================================");

        System.out.println("Folio: "
                + aspirante.getFolio());

        System.out.println("Nombre: "
                + aspirante.getNombre());

        System.out.println("Primer apellido: "
                + aspirante.getPrimerApellido());

        System.out.println("Segundo apellido: "
                + aspirante.getSegundoApellido());

        System.out.println("Edad: "
                + aspirante.getEdad() + " años");

        System.out.println("Dirección: "
                + aspirante.getDireccion());

        System.out.println("Teléfono: "
                + aspirante.getTelefono());

        System.out.println("Fecha de nacimiento: "
                + aspirante.getFechaNacimiento());

        System.out.println("Correo electrónico: "
                + aspirante.getEmail());

        System.out.println("Redes sociales: "
                + aspirante.getRedesSociales());

        System.out.println("Carrera de interés: "
                + aspirante.getCarreraInteres());

        System.out.println("Escuela de procedencia: "
                + aspirante.getEscuelaProcedencia());

        System.out.println("Bachillerato cursado: "
                + aspirante.getBachilleratoCursado());
    }
}

