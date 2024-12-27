package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
       /* boolean condition = true;
        Scanner scan = new Scanner(System.in);
        int option;
        String choice;
        MediosDeRecreacion inf = null;
        MediosDeRecreacion Reciente = null;
        MediosDeRecreacion Play = new MediosDeRecreacion("PlayStation", 3, 15.46, 'B');
        MediosDeRecreacion Xbox = new MediosDeRecreacion("Xbox", 2, 13.78, 'M');
        MediosDeRecreacion Nintendo = new MediosDeRecreacion("Nintendo", 4, 13.49, 'R');

        while (condition){
            System.out.println("Elige una opcion:");
            System.out.println("1 - Crea un medio");
            System.out.println("2 - Imprime toda la información");
            System.out.println("3 - Salir");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    Reciente = create();
                    System.out.println("Tu nuevo medio ha sido añadido!");
                    break;
                case 2:
                    System.out.println("¿De que medio quieres ver la información? \n Play - Xbox - Nintendo - Reciente");
                    choice = scan.next().toUpperCase();
                    if (choice.equals("PLAY")){
                        inf = Play;
                    } else if (choice.equals("XBOX")) {
                        inf = Xbox;
                    } else if (choice.equals("NINTENDO")) {
                        inf = Nintendo;
                    } else if (choice.equals("RECIENTE")) {
                        inf = Reciente;
                    } else {
                        System.out.println("Ese medio no existe...");
                        break;
                    }
                    try {
                        System.out.println("Nombre: " + MediosDeRecreacion.getName(inf));
                        System.out.println("Inventario: " + MediosDeRecreacion.getInventario(inf));
                        System.out.println("Alquiler " + MediosDeRecreacion.getAlquiler(inf));
                        System.out.println("Estado " + MediosDeRecreacion.getEstado(inf));
                    } catch(NullPointerException err) {
                        System.out.println("Ese medio aun no está registrado...");
                }
                    break;
                case 3:
                    System.out.println("Adios :]");
                    condition = false;
                    break;
            }
        }
    }

    public static MediosDeRecreacion create() {
        Scanner scan = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);
        String name;
        int inventario;
        double alquiler;
        char estado;
        MediosDeRecreacion obj;
        System.out.println("Ingresa el Alquiler");
        alquiler = scan.nextFloat();
        System.out.println("Ingresa el Inventario");
        inventario = scan.nextInt();
        System.out.println("Ingresa el Nombre");
        name = scanner.nextLine();
        System.out.println("Ingresa el Estado");
        estado = scan.next(".").charAt(0);
        obj = new MediosDeRecreacion(name, inventario, alquiler, estado);
        return obj; */


        //Hotel
        Scanner scan = new Scanner(System.in);
        int option, dias, huesped;
        Hotel cliente = null;
        Hotel huesped1 = new Hotel("Francisco Franciscano", 'H', 27, false, 47605.68);
        Hotel huesped2 = new Hotel("Maria Magdalena", 'M', 34, true, 258605.87);
        boolean running = true;
        double promedio, nuevoConsumo;
        while (running) {
            System.out.println("Bienvendio, escoga una opcion \n 1- Ver informacion 2- Huesped del mes 3- VIP 4- Consumo promedio diario 5- Actualizar consumo 6- Salir");
            option = scan.nextInt();
            switch (option) {
                case 1:
                    System.out.println("¿Que huesped quieres ver? \n 1 o 2");
                    huesped = scan.nextInt();
                    if (huesped == 1) {
                        cliente = huesped1;
                    } else if (huesped == 2) {
                        cliente = huesped2;
                    } else {
                        System.out.println("Ingresa un número valido");
                    }
                    Hotel.info(cliente);
                    break;
                case 2:
                    System.out.println("¿Que huesped quieres ver? \n 1 o 2");
                    huesped = scan.nextInt();
                    if (huesped == 1) {
                        cliente = huesped1;
                    } else if (huesped == 2) {
                        cliente = huesped2;
                    } else {
                        System.out.println("Ingresa un número valido");
                        break;
                    }

                    if (cliente.getVip()) {
                        if (cliente.getConsumoMensual() > 250000) {
                            System.out.println("El huesped es candidato a huesped del mes");
                        } else {
                            System.out.println("El huesped NO es candidato a huesped del mes");
                        }
                    } else {
                        if (cliente.getConsumoMensual() > 50000) {
                            System.out.println("El huesped es candidato a huesped del mes");
                        } else {
                            System.out.println("El huesped NO es candidato a huesped del mes");
                        }
                    }
                    break;
                case 3:
                    System.out.println("¿Que huesped quieres ver? \n 1 o 2");
                    huesped = scan.nextInt();
                    if (huesped == 1) {
                        cliente = huesped1;
                    } else if (huesped == 2) {
                        cliente = huesped2;
                    } else {
                        System.out.println("Ingresa un número valido");
                        break;
                    }

                    if (cliente.getConsumoMensual() > 350000) {
                        cliente.setVip(true);
                        System.out.println("El huesped ha sido elevado a VIP");
                    } else if (!cliente.getVip() && cliente.getConsumoMensual() <= 350000) {
                        System.out.println("El huesped no puede ser elevado a VIP");
                    } else {
                        System.out.println("El huesped ya es VIP");
                    }
                    break;
                case 4:
                    System.out.println("¿Que huesped quieres ver? \n 1 o 2");
                    huesped = scan.nextInt();
                    if (huesped == 1) {
                        cliente = huesped1;
                    } else if (huesped == 2) {
                        cliente = huesped2;
                    } else {
                        System.out.println("Ingresa un número valido");
                        break;
                    }

                    System.out.println("¿Cuantos días faltan para que termine el mes?");
                    dias = scan.nextInt();
                    dias = 30 - dias;
                    promedio = cliente.getConsumoMensual()/dias;
                    System.out.println("En promedio, el huesped ha consumido $"+promedio+" diariamente");
                    break;
                case 5:
                    System.out.println("¿Que huesped quieres ver? \n 1 o 2");
                    huesped = scan.nextInt();
                    if (huesped == 1) {
                        cliente = huesped1;
                    } else if (huesped == 2) {
                        cliente = huesped2;
                    } else {
                        System.out.println("Ingresa un número valido");
                        break;
                    }

                    System.out.println("¿A que desea cambiar el consumo?");
                    nuevoConsumo = scan.nextDouble();
                    cliente.setConsumoMensual(nuevoConsumo);
                    System.out.println("¡El consumo mensual se ha actualizado correctamente!");
                    break;
                case 6:
                    System.out.println("Cerrando...");
                    running = false;
                    break;
            }
        }
    }
}

