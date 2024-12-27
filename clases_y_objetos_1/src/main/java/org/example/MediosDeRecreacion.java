package org.example;

public class MediosDeRecreacion {

    private String name;
    private int inventario;
    private double alquiler;
    private char estado;

    //Constructor
    public MediosDeRecreacion(String name, int inventario, double alquiler, char estado){
        this.name = name;
        this.inventario = inventario;
        this.alquiler = alquiler;
        this.estado = estado;
    }

    //Nombre
    public static String getName(MediosDeRecreacion obj) {
        return obj.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Inventario
    public static int getInventario(MediosDeRecreacion obj) {
        return obj.inventario;
    }

    public void setInventario(int inventario) {
        this.inventario = inventario;
    }

    //Alquiler
    public static double getAlquiler(MediosDeRecreacion obj) {
        return obj.alquiler;
    }

    public void setAlquiler(double alquiler) {
        this.alquiler = alquiler;
    }

    //Estado
    public static char getEstado(MediosDeRecreacion obj) {
        return obj.estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }
}
