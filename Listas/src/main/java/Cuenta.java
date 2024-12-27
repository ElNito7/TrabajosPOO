public class Cuenta {
    private int id;
    private double saldo;
    private int pos;
    private Cliente cliente;

    public Cuenta(int id, double saldo, int pos){
        this.id = id;
        this.saldo = saldo;
        this.pos = pos;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getPos() {
        return pos;
    }
    public void setPos(int pos) {
        this.pos = pos;
    }
    

    @Override
    public String toString() {
        return "[Id: "+getId()+", Saldo: "+getSaldo()+", Posición: "+getPos()+"]";
    }
}
