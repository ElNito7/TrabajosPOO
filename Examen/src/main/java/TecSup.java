public class TecSup extends Trabajador {
    private int yearsAsTec;

    public TecSup(String nombre, String apellidos, int years, String especialidad, int yearsAsTec) {
        super(nombre, apellidos, years, especialidad);
        this.yearsAsTec = yearsAsTec;
    }
}
