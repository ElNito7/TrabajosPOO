import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Pieza> lista = new ArrayList<>();
        Pieza pieza1 = new Pieza("pieza 1", 1001, "MEXICO", 57, 56.89);
        Pieza pieza2 = new Pieza("pieza 2", 1002, "CHINA", 43, 36.69);
        lista.add(pieza1);
        lista.add(pieza2);
        boolean running = true;
        int option;
        Scanner scan = new Scanner(System.in);

        System.out.println("Bienvenido al programa");
        while (running){
            System.out.println("¿Que deseas realizar?\n" +
                    "1 - Lista ordenada de las piezas \n" +
                    "2 - Nombre de la pieza con mayor precio unitario \n" +
                    "3 - Valor total de las piezas procesadas\n" +
                    "4 - Lista de piezas de un país determinado \n" +
                    "5 - Obtener datos de una pieza por código \n" +
                    "6 - Salir");
            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1:
                    System.out.println("La lista de piezas ordenada es la siguiente:");
                    Collections.sort(lista);
                    for (Pieza i : lista) {
                        System.out.println(i.toString());
                    }
                    break;
                case 2:
                    String name = null;
                    double mayorPrecio = 0;
                    for (Pieza i : lista) {
                        if (i.getPrecio() > mayorPrecio) {
                            mayorPrecio = i.getPrecio();
                            name = i.getNombre();
                        }
                    }
                    System.out.println("La pieza con mayor precio unitario es la " + name);
                    break;
                case 3:
                    double total = 0;
                    for (Pieza i : lista){
                        total += i.getPrecio()*i.getCantidad();
                    }
                    System.out.println("El valor total de las piezas procesadas es de: "+total);
                    break;
                case 4:
                    String pais;
                    int counter = 0;
                    System.out.println("¿De que país quieres buscar las piezas?");
                    pais = scan.nextLine().toUpperCase();
                    System.out.println("Las piezas procedentes de ese país son: ");
                    for (Pieza i : lista){
                        if (pais.equals(i.getPais())){
                            System.out.println(i);
                            counter++;
                        }
                    }
                    if (counter == 0){
                        System.out.println("No hay piezas procedentes de ese país :(");
                    }
                    break;
                case 5:
                    int codigo;
                    System.out.println("Ingresa el código de la pieza.");
                    codigo = scan.nextInt();
                    for (Pieza i : lista){
                        if (codigo == i.getCodigo()){
                            System.out.println(i);
                        }
                        else{
                            System.out.println("No existe una pieza con ese código...");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Cerrando...");
                    running = false;
                    break;
                default:
                    System.out.println("Esa no era una opción...");
                    break;

            }
        }
    }
}