
import TDA.ListaSE;
import java.io.Serializable;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Keloc
 */
public class Cliente{

    protected String nom;
    protected String apellidos;
    protected int idCliente;
    protected char sexo;
    protected ListaSE cuentas;
    
    public Cliente(String nom, String apellidos, int idCliente, char sexo, ListaSE cuentas) {
        this.nom = nom;
        this.apellidos = apellidos;
        this.idCliente = idCliente;
        this.sexo = sexo;
        this.cuentas = cuentas;
    }

    public ListaSE getCuentas() {
        return cuentas;
    }

    public void setCuentas(ListaSE cuentas) {
        this.cuentas = cuentas;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    
    public String getNomCom(){
        return getNom()+" "+getApellidos();
    }
    
    @Override
    public String toString() {
        return "[Nombre: "+getNom()+", Apellidos: "+getApellidos()+", Num. de Identidad: "+getIdCliente()+", Sexo: "+getSexo()+"]";
    }
}
