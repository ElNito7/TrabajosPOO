import java.util.List;

public class Productor implements Runnable{
    private String producto;
    private List lista;
    public Productor(String producto, List lista){
        this.producto = producto;
        this.lista = lista;
    }
    @Override
    public void run() {
        try {
            lista.add(producto);
            notifyAll();
            System.out.println(producto);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
