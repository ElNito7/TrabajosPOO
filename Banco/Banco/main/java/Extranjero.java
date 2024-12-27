/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Keloc
 */
public class Extranjero extends Cliente {

    private String nacionalidad;
    private String direccion;
    
    public Extranjero(String nom, String apellidos, int idCliente, char sexo, String nacionalidad, String direccion){
        super(nom, apellidos, idCliente, sexo);
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
