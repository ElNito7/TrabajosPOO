public class Ingeniero extends Trabajador{
    private boolean cedula;

    public Ingeniero(String nombre, String apellidos, int years, String especialidad, boolean cedula) {
        super(nombre, apellidos, years, especialidad);
        this.cedula = cedula;
    }
}
