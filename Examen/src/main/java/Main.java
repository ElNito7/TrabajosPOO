import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int option;
        int servCount = 0;
        int clientCount = 0;
        boolean running = true;
        Servicio[] servicios = new Servicio[20];
        Cliente[] clientes = new Cliente[20];
        Trabajador[] trabajadores = new Trabajador[20];
        String nombre;
        String apellido;
        int count = 0;

        System.out.println("Bienvenido al Sistema");
        while (running) {
            System.out.println("¿Qué deseas realizar?" +
                    "1- Añadir un nuevo servicio a la colección de servicios en proceso.\n" +
                    "2- Añadir clientes a la colección de clientes.\n" +
                    "3- Reemplazar un trabajador de un servicio en proceso.\n" +
                    "4- Listar los servicios en proceso y los trabajadores involucrados.\n" +
                    "5- Listar los servicios finalizados y los trabajadores que estuvieron involucrados.\n" +
                    "6- Salir");
            option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                case 1:
                    int idOrden;
                    int horas;
                    String desc;
                    boolean concluido = false;
                    int check;
                    boolean run = true;
                    Trabajador[] enServicio = new Trabajador[20];
                    System.out.println("¿Cuál es su número de orden?");
                    idOrden = scan.nextInt();
                    scan.nextLine();
                    System.out.println("¿Cuál es el número de horas requeridas?");
                    horas = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Ingresa una descripción del servicio:");
                    desc = scan.nextLine();
                    System.out.println("¿Esta concluido? \n 1- Si 2- No");
                    check = scan.nextInt();
                    scan.nextLine();
                    if (check == 1) {
                        concluido = true;
                    } else if (check == 2) {
                        concluido = false;
                    } else {
                        System.out.println("No es una ocpion...");
                    }
                    while (run) {
                        System.out.println("Ingresa el nombre del trabajador involucrado:");
                        nombre = scan.nextLine();
                        System.out.println("Ahora el apellido:");
                        apellido = scan.nextLine();
                        for (Trabajador i : trabajadores) {
                            if (nombre.equals(i.getNombre()) && apellido.equals(i.getApellidos())) {
                                enServicio[count] = i;
                                count++;
                            }
                        }
                        System.out.println("¿Hay más trabajadores involucrados? \n 1- Si 2- No");
                        check = scan.nextInt();
                        if (check == 2) {
                            run = false;
                        }
                    }
                    Servicio servicio = new Servicio(idOrden, horas, desc, concluido, enServicio);
                    servicios[servCount] = servicio;
                    servCount++;
                    System.out.println("¡Servicio añadido Correctamente!");
                    break;
                case 2:
                    int cual;
                    int id;
                    String empresa;
                    System.out.println("¿Cuál es su nombre?");
                    nombre = scan.nextLine();
                    System.out.println("¿Cuales son sus apellidos?");
                    apellido = scan.nextLine();
                    System.out.println("¿Es natural o judicial? \n 1- Natural 2- Judicial");
                    cual = scan.nextInt();
                    scan.nextLine();
                    if (cual == 1) {
                        System.out.println("¿Cual es su número de identidad?");
                        id = scan.nextInt();
                        scan.nextLine();
                        Natural clienteNatural = new Natural(nombre, apellido, id);
                        clientes[clientCount] = clienteNatural;
                    } else if (cual == 2) {
                        System.out.println("¿Cual es el nombre de la empresa?");
                        empresa = scan.nextLine();
                        Juridico clienteJuridico = new Juridico(nombre, apellido, empresa);
                        clientes[clientCount] = clienteJuridico;
                    } else {
                        System.out.println("No era una opción...");
                        break;
                    }
                    clientCount++;
                    break;
                case 3:
                    int num;
                    System.out.println("De que servicio quiere cambiar al trabajador? (num de orden)");
                    num = scan.nextInt();
                    scan.nextLine();
                    for (Servicio i : servicios) {
                        if (num == i.idOrden) {
                            System.out.println("Ingresa el nombre del trabajador que deseas cambiar:");
                            nombre = scan.nextLine();
                            System.out.println("Ahora el apellido:");
                            apellido = scan.nextLine();
                            for (Trabajador j : trabajadores) {
                                if (nombre.equals(j.getNombre()) && apellido.equals(j.getApellidos())) {
                                    i.getTrabajadores(); //NO ESTA TERMINADO
                                    count++;
                                }
                            }
                        }
                    }
                        break;
                case 4:
                    System.out.println("Los servicios en proceso son los siguientes");
                    for (Servicio i : servicios) {
                        if (!i.isConcluido()) {
                            System.out.println(i.mostrar());
                        }
                    }
                    break;
                case 5:
                    System.out.println("La lista de servicios finalizados es la siguiente: ");
                    for (Servicio i : servicios) {
                        if (i.isConcluido()) {
                            System.out.println(i.mostrar());
                        }
                    }
                    break;
                case 6:
                    System.out.println("Cerrando...");
                    running = false;
                    break;
                default:
                    System.out.println("No es una opción...");
                    break;
                }
            }
        }
    }
