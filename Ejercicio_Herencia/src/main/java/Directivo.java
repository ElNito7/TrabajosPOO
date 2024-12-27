public class Directivo extends Empleado {
    public Directivo(String name) {
        super(name);
    }
    public String isDirectivo() {
        return "El empleado " + getName() + " es un directivo";
    }
}
