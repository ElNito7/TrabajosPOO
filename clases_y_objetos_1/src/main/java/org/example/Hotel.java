package org.example;

public class Hotel {
    private String nombre;
    private char genero;
    private int edad;
    private boolean vip;
    private double consumoMensual;

    //Constructor
    public Hotel(String nombre, char genero, int edad, boolean vip, double consumoMensual) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.vip = vip;
        this.consumoMensual = consumoMensual;
    }

    //Acceso
    public String getNombre() {
        return nombre;
    }
    public char getGenero() {
        return genero;
    }
    public int getEdad() {
        return edad;
    }
    public boolean getVip() {
        return vip;
    }
    public double getConsumoMensual() {
        return consumoMensual;
    }

    //Modificaciones

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setGenero(char genero) {
        this.genero = genero;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void setVip(boolean vip) {
        this.vip = vip;
    }
    public void setConsumoMensual(double consumoMensual) {
        this.consumoMensual = consumoMensual;
    }

    //info
    public static void info(Hotel huesped) {
        System.out.println("Nombre: "+huesped.nombre);
        System.out.println("Genero: "+huesped.genero);
        System.out.println("Edad: "+huesped.edad);
        System.out.println("VIP: "+huesped.vip);
        System.out.println("Consumo Mensual: "+huesped.consumoMensual);
    }
}
