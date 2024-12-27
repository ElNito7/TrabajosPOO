public class Trabajador {
    protected String nombre;
    protected String apellidos;
    protected int years;
    protected String especialidad;

    public Trabajador(String nombre, String apellidos, int years, String especialidad){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.years = years;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

}
