import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ALUMNO {
    private String nombre;
    private int edad;
    private String carrera;
    private LocalDate fechaInscripcion;

    public ALUMNO(String nombre, int edad, String carrera, LocalDate fechaInscripcion) {
        this.nombre = nombre;
        this.edad = edad;
        this.carrera = carrera;
        this.fechaInscripcion = fechaInscripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public LocalDate getFechaInscripcion() {
        return fechaInscripcion;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Nombre: " + nombre +
               " | Edad: " + edad +
               " | Carrera: " + carrera +
               " | Fecha Inscripción: " + fechaInscripcion.format(formatter);
    }
}