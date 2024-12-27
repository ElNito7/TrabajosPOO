import java.awt.*;
import java.util.Queue;

public class MessagePrinter implements Runnable {
    private String m;
    private long l;
    private List lista;
    public MessagePrinter(String m, long l, List lista){
        this.m = m;
        this.l = l;
        this.lista = lista;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(l);
            System.out.println(m);
            System.out.println("Tiempo de espera: "+l);
        } catch (Exception e){
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
        }
    }
}
