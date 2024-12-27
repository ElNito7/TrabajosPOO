
import java.util.List;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 
/**
 *
 * @author Keloc
 */
public class Main {
    public static void main(String[] args){
        Persona persona = new Persona("Angel", 18);
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        var connected = session.isConnected();
        System.out.println("Conectado: "+connected);
        
        try {
            session.save(persona);
            
            List<Persona> personas = session.createQuery("from personaRogers").list();
            for (Persona person : personas){
                System.out.println(person.toString());
            }
            session.getTransaction().commit();
            session.close();
            System.out.println("persona agregada");
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
