public class Empleado {
    protected String name;
    //Constructor
    public Empleado(String name) {
        this.name = name;
    }
    //Setter
    public void setName(String name) {
        this.name = name;
    }
    //Getter
    public String getName() {
        return name;
    }

    //String toString
    public String strToString() {
        return "Este empleado se llama: " + getName();
    }
}
