package org.example;

public class Album {
    private String author;
    private String name;
    private float price;
    private String disquera;

    //Metodo de construcción
    public Album(String author, String name, float price, String disquera) {
        this.author = author;
        this.name = name;
        this.price = price;
        this.disquera = disquera;
    }

    //Metodos de acceso
    public String getAuthor() {
        return author;
    }
    public String getName() {
        return name;
    }
    public String getDisquera() {
        return disquera;
    }
    public float getPrice() {
        return price;
    }

    //Metodos de modificación
    public void setAuthor(String mod) {
        this.author = mod;
    }
    public void setName(String mod) {
        this.name = mod;
    }
    public void setDisquera(String mod) {
        this.disquera = mod;
    }
    public void setPrice(float mod) {
        this.price = mod;
    }

    //Imprime todo
    public void accessAll() {
        System.out.println(getAuthor());
        System.out.println(getName());
        System.out.println(getPrice());
        System.out.println(getDisquera());
    }
}
