/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.basesdedatos;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Keloc
 */
public class Main {
    public static void main(String[] args){
        String lista = "";
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        var connected = session.isConnected();
        System.out.println("Conectado: "+connected);
        
        try {
            List<Persona> personas = session.createQuery("FROM Persona", Persona.class).list();
                for (Persona person : personas){
                    lista = lista.concat(person.toString()+"\n");
                }
            System.out.println(lista);
            new Interfaz(lista).setVisible(true);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e){
            System.out.println("ERROR: "+e.getMessage());
            session.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
        
    }
}
