import java.awt.*;
import java.util.Queue;

public class Main {
    public static void main(String[] args){
        List lista = new List();
        MessagePrinter m1 = new MessagePrinter("Producto", 5000, lista);
        MessagePrinter m2 = new MessagePrinter("Consumo", 5500, lista);
        Productor p1 = new Productor("Ropa", (java.util.List) lista);
        Consumidor consumidor = new Consumidor((java.util.List) lista);
        Thread t1 = new Thread(m1);
        Thread t2 = new Thread(m2);

        for (int i = 1; i <= 10; i++){

        }
    }


}
