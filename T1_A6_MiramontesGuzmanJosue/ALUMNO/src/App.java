import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        RegistroAspirante registro = new RegistroAspirante();

        String continuar = "s";

        while (continuar.equalsIgnoreCase("s")) {

            System.out.println();
            System.out.println("=== Registro Aspirante ===");

            System.out.print("Nombre: ");
            String nombre = teclado.nextLine();

            System.out.print("Primer apellido: ");
            String p_apellido = teclado.nextLine();

            System.out.print("Segundo apellido: ");
            String s_apellido = teclado.nextLine();

            System.out.print("Edad: ");
            int edad = Integer.parseInt(teclado.nextLine());

            System.out.print("Direccion: ");
            String direccion = teclado.nextLine();

            System.out.print("Telefono: ");
            String telefono = teclado.nextLine();

            System.out.print("Correo Electronico: ");
            String email = teclado.nextLine();

            System.out.print("Redes sociales: ");
            String r_sociales = teclado.nextLine();

            System.out.print("Carrera de interes: ");
            String c_interes = teclado.nextLine();

            System.out.print("Escuela de procedencia: ");
            String e_procedencia = teclado.nextLine();

            System.out.print("Bachillerato cursado: ");
            String b_cursado = teclado.nextLine();


            ASPIRANTE aspirante = new ASPIRANTE(
                nombre,
                p_apellido,
                s_apellido,
                edad,
                direccion,
                telefono,
                email,
                r_sociales,
                c_interes,
                e_procedencia,
                b_cursado
            );


            registro.agregarAspirante(aspirante);


            System.out.print("¿Deseas agregar otro aspirante? (s/n): ");

            continuar = teclado.nextLine();
        }


        System.out.println();
        System.out.println("FICHAS DE INGRESO:");
        System.out.println();

        registro.mostrarListaAspirantes();

        teclado.close();
    }
}
