public class Operario extends Empleado {
    public Operario(String name) {
        super(name);
    }
    public String isOperario() {
        return "El empleado " + getName() + " es un operario";
    }
}
