import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Temas tema1 = new Temas("ex1", 204);
        Temas tema2 = new Temas("ex2", 198);
        Temas[] arrTemas = new Temas[2];
        arrTemas[0] = tema1;
        arrTemas[1] = tema2;

        CD disk1 = new CD("autor", "nombre", 139.99, "disquera", arrTemas, "marca", 678, 5.43);
        Casette cas1 = new Casette("autor", "nombre", 139.99, "disquera", arrTemas, 'C', "fabricante");
        
    }
}
