import java.util.Scanner;
public class CD extends Album{
    private String marca;
    private int vidaUtil;
    private double velocidad;

    public CD(String autor, String nombre, double precio, String disquera, Temas[] temas, String marca, int vidaUtil, double velocidad){
        super(autor, nombre, precio, disquera, temas);
        this.marca = marca;
        this.vidaUtil = vidaUtil;
        this.velocidad = velocidad;
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
        if(vidaUtil > 500){
            return (canciones*numeroUsuario/0.5)+2;
        }
        return (canciones*numeroUsuario/0.5)+1;
    }
}
