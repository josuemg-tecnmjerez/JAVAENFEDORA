

public class ASPIRANTE {

    private String folio;
    private String nombre;
    private String p_apellido;
    private String s_apellido;
    private int edad;
    private String direccion;
    private String telefono;
    private String fecha_nacimiento;
    private String email;
    private String r_sociales;
    private String c_interes;
    private String e_procedencia;
    private String b_cursado;

    public ASPIRANTE(
            String folio,
            String nombre,
            String p_apellido,
            String s_apellido,
            int edad,
            String direccion,
            String telefono,
            String fecha_nacimiento,
            String email,
            String r_sociales,
            String c_interes,
            String e_procedencia,
            String b_cursado) {

        this.folio = folio;
        this.nombre = nombre;
        this.p_apellido = p_apellido;
        this.s_apellido = s_apellido;
        this.edad = edad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fecha_nacimiento = fecha_nacimiento;
        this.email = email;
        this.r_sociales = r_sociales;
        this.c_interes = c_interes;
        this.e_procedencia = e_procedencia;
        this.b_cursado = b_cursado;
    }

    public String getFolio() {
        return folio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return p_apellido;
    }

    public String getSegundoApellido() {
        return s_apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getFechaNacimiento() {
        return fecha_nacimiento;
    }

    public String getEmail() {
        return email;
    }

    public String getRedesSociales() {
        return r_sociales;
    }

    public String getCarreraInteres() {
        return c_interes;
    }

    public String getEscuelaProcedencia() {
        return e_procedencia;
    }

    public String getBachilleratoCursado() {
        return b_cursado;
    }
}

