public class Tecnico extends Operario{
    public Tecnico(String name) {
        super(name);
    }
    public String isOperarioTecnnico() {
        return "El empleado " + getName() + " es un operario técnico";
    }
}
