public class RegistroAspirante {

    private ASPIRANTE[] listaAspirantes = new ASPIRANTE[5];

    private int cantidad = 0;

    public void agregarAspirante(ASPIRANTE aspirante) {

        if(cantidad == listaAspirantes.length){
            ASPIRANTE[] nuevoArreglo = new ASPIRANTE[listaAspirantes.length * 2];

        for (int i = 0; i < listaAspirantes.length; i++) {
            nuevoArreglo[i] = listaAspirantes[i];
            
        }
            listaAspirantes = nuevoArreglo;

    }

    listaAspirantes[cantidad] = aspirante;

    cantidad++;
    }





//Mostrar Aspirantes

public void mostrarListaAspirantes(){
    for (int i = 0; i < cantidad; i++) {
        ASPIRANTE aspirante = listaAspirantes[i];

        System.out.printf("Ficha de ingreso:", i + 1);

        System.out.println("Nombre: " +
                    aspirante.getNombre());
        System.out.println("Apellido: " + 
                    aspirante.GetApellido());
        System.out.println("Segundo apellido" +
                    aspirante.getSegApellido());
        System.out.println("Edad: " +
                    aspirante.getedad());
        System.out.println("Direccion: " +
            aspirante.GetTelefono());
        System.out.println("Direccion: " +
                    aspirante.GetDireccion());
        System.out.println("Fecha de nacimiento: " + 
                   aspirante.getfecha_nacimiento());
        System.out.println("EMAIL:" + aspirante.getEmail());
        System.out.println("Redes sociales: "+ aspirante.getr_sociales());
        System.out.println("Carrera de interes: " + aspirante.getc_Interes());
        System.out.println("Escuela de procedencia: " + aspirante.gete_procedencia());
        System.out.println("Bachillerato cursado" + aspirante.getb_cursado());

    }
                
        

                    

    }



public void buscarAspirante(int numeroFicha) {


    int posicion = numeroFicha - 1;


    

    if (posicion >= 0 && posicion < cantidad) {

       

        ASPIRANTE aspirante = listaAspirantes[posicion];


   

        System.out.println();
        System.out.printf("Ficha de ingreso: %03d%n", numeroFicha);
        System.out.println("======================");

        System.out.println("Nombre: " +
                aspirante.getNombre());

        System.out.println("Primer Apellido: " +
                aspirante.GetApellido());

        System.out.println("Segundo Apellido: " +
                aspirante.getSegApellido());

        System.out.println("Edad: " +
                aspirante.getedad() + " años");

        System.out.println("Dirección: " +
                aspirante.GetDireccion());

        System.out.println("Teléfono: " +
                aspirante.GetTelefono());

        System.out.println("Correo electrónico: " +
                aspirante.getEmail());

        System.out.println("Redes Sociales: " +
                aspirante.getr_sociales());

        System.out.println("Carrera(s) de interés: " +
                aspirante.getc_Interes());

        System.out.println("Escuela de procedencia: " +
                aspirante.gete_procedencia());

        System.out.println("Bachillerato cursado: " +
                aspirante.getb_cursado());

    } else {

        

        System.out.println("No existe un aspirante con esa ficha.");
    }
}

}

    