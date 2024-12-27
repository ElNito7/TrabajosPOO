public class Oficial extends Operario {
    public Oficial(String name){
        super(name);
    }
    public String isOperarioOficial() {
        return "El empleado " + getName() + " es un operario oficial";
    }
}
