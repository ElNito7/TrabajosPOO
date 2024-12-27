public class Solicitud {
    private int id;
    private double deposit;
    private String name;

    public Solicitud(int id, double deposit, String name){
        this.id = id;
        this.deposit = deposit;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public double getDeposit() {
        return deposit;
    }
    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "[Id: "+getId()+", Deposito: "+getDeposit()+", Nombre: "+getName()+"]";
    }
}
