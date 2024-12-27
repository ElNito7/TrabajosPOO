public class Estudiante extends Persona {
    private int edad;
    public Estudiante(String name, int edad) {
        super(name);
        this.edad = edad;
    }

    public String getPersona() {
        return name;
    }
}
