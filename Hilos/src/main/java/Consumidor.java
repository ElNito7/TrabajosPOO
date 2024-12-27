import java.util.List;

public class Consumidor implements Runnable{
    private List lista;
    public Consumidor(List lista){
        this.lista = lista;
    }
    @Override
    public void run() {
        try {
            wait();
            String producto = (String) lista.get(0);
            lista.remove(0);
            System.out.println("Consumidor Adquirio Producto: "+producto);
            notifyAll();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
