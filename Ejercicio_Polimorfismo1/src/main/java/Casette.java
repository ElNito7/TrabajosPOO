import java.util.Scanner;
public class Casette extends Album{
    private char cinta;
    private String fabricante;

    public Casette(String autor, String nombre, double precio, String disquera, Temas[] temas, char cinta, String fabricante){
        super(autor, nombre, precio, disquera, temas);
        this.cinta = cinta;
        this.fabricante = fabricante;
    }

    @Override
    public double calidad() {
        Scanner scan = new Scanner(System.in);
        int canciones = temas.length;
        System.out.println("Ingresa un numero del 1 al 10");
        int numeroUsuario = scan.nextInt();
        if(numeroUsuario < 1 || numeroUsuario > 10){
            System.out.println("Número invalido");
            return -1;
        }
        return (canciones*numeroUsuario/0.5);
    }
}
