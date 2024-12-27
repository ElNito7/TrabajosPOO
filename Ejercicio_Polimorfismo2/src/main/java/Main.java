import java.util.Objects;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int option;
        boolean running = true;
        Estudiante[] lista = new Estudiante[20];
        Nacional e1 = new Nacional("JUAN HERNANDEZ", 1001, 2024, "DERECHO", 9.6, 9, 9.1, "CALLE 2, COLONIA");
        Extranjero e2 = new Extranjero("JOHN DOE", 1002, 2024, "MEDICINA", "INGLATERRA", 8.7, 8.9, 9.1, 123456789, "EMBAJADA", 2021);
        Estudiante student;
        lista[0] = e1;
        lista[1] = e2;
        int counter = 2;
        String buscadorPais;
        int buscarYear;

        while(running){
            System.out.println("""
                    Bienvenido al Sistema\s
                     ¿Qué deseas realizar?\s
                     1 - Añadir Estudiante\s
                     2 - Conocer cuántos becados mexicanos obtuvieron evaluación de Bien
                     3 - Obtener cuantos estudiantes proceden de un país especificado
                     4 - Obtener cuántos estudiantes Extranjeros pertenecen a un año dado
                     5 - Salir""");
            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1:
                    student = add();
                    lista[counter] = student;
                    counter += 1;
                    break;
                case 2:
                    int bien = 0;
                    for (Estudiante estudiante : lista) {
                        if (estudiante instanceof Nacional && estudiante.evaluacion() >= 9) {
                            bien += 1;
                        }
                    }
                    System.out.println("Hay "+bien+" estudiantes con evaluación de BIEN.");
                    break;
                case 3:
                    int contador = 0;
                    System.out.println("¿De que país quieres buscar a los estudiantes?");
                    buscadorPais = scan.nextLine().toUpperCase();
                    if (buscadorPais.equals("MEXICO")){
                        for(Estudiante i : lista){
                            if(i instanceof Nacional){
                                contador++;
                            }
                        }
                    } else {
                        for(Estudiante i : lista){
                            if(i instanceof Extranjero && Objects.equals(((Extranjero) i).getPais(), buscadorPais)){
                                contador++;
                            }
                        }
                    }
                    System.out.println("Hay "+contador+" Estudiantes provenientes de "+buscadorPais+".");
                    break;
                case 4:
                    int cuantosDelYear = 0;
                    System.out.println("Ingrese el año del que desea buscar.");
                    buscarYear = scan.nextInt();
                    scan.reset();
                    for (Estudiante i : lista){
                        if(i instanceof Extranjero && i.getYear() == buscarYear){
                            cuantosDelYear++;
                        }
                    }
                    System.out.println("Hay "+cuantosDelYear+" estudiantes del año "+buscarYear+".");
                    break;
                case 5:
                    System.out.println("Cerrando...");
                    running = false;
                    break;
                default:
                    System.out.println("Esa no es una opcion...");
                    break;
            }
        }
    }

    //Añadir Estudiante
    public static Estudiante add(){
        Scanner scanner = new Scanner(System.in);
        String name;
        int id;
        int year;
        int option;
        String carrera;
        double residencia;
        double edificio;
        double auxiliar;
        System.out.println("¿Que nacionalidad tiene el estudiante? \n 1 - Mexicano \n 2 - Extranjero");
        option = scanner.nextInt();
        scanner.nextLine();
        if (option < 1 || option > 2){
            System.out.println("Esa no era una opción...");
            return null;
        }
        System.out.println("Ingresa su nombre:");
        name = scanner.nextLine().toUpperCase();
        System.out.println("Ingresa su ID:");
        id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingresa el año:");
        year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingresa su carrera:");
        carrera = scanner.nextLine().toUpperCase();
        scanner.reset();
        System.out.println("Ingresa la evaluación de residencia:");
        residencia = scanner.nextDouble();
        scanner.reset();
        System.out.println("Ingresa la evaluación de edificio:");
        edificio = scanner.nextDouble();
        scanner.reset();
        System.out.println("Ingresa la evaluación de auxiliar:");
        auxiliar = scanner.nextDouble();
        scanner.nextLine();
        if (option == 1){
            String direccion;
            System.out.println("Ingresa su direccion:");
            direccion = scanner.nextLine().toUpperCase();
            return new Nacional(name, id, year, carrera, residencia, edificio, auxiliar, direccion);
        } else {
            String pais;
            int pasaporte;
            String embajada;
            int yearOfEntry;
            System.out.println("Ingresa su país:");
            pais = scanner.nextLine();
            scanner.reset();
            System.out.println("Ingresa su número de pasaporte:");
            pasaporte = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Ingresa su embajada:");
            embajada = scanner.nextLine();
            System.out.println("Ingresa su año de entrada al pais:");
            yearOfEntry = scanner.nextInt();
            return new Extranjero(name, id, year, carrera, pais, residencia, edificio, auxiliar, pasaporte, embajada, yearOfEntry);
        }
    }
}
