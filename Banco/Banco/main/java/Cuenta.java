public class Cuenta {
    private int id;
    private double saldo;
    private int pos;
    private Cliente cliente;

    public Cuenta(int id, double saldo, int pos, Cliente cliente){
        this.id = id;
        this.saldo = saldo;
        this.pos = pos;
        this.cliente = cliente;
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
    
    public Cliente getCliente(){
        return cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "[Id: "+getId()+", Saldo: "+getSaldo()+", Posición: "+getPos()+", Titular: "+getCliente().getNomCom()+"]";
    }
}
