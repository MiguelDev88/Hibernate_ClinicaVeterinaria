package funciones;
import POJOS.*;
import hibernate_clinicaveterinaria.HibernateUtil;
import org.hibernate.Session;


public class Eliminar {
    
    public static void EliminarAnimal (int id) {
        
        
        Session sesion=HibernateUtil.getSession();
        
        C_Animal animal = (C_Animal)sesion.createQuery("FROM POJOS.C_Animal a WHERE a.id='"+id+"'").uniqueResult();

        sesion.beginTransaction();
        sesion.delete(animal);
        sesion.getTransaction().commit();
        sesion.close();
        
    }

    public static void EliminarVeterinario(int id) {
        
        Session sesion=HibernateUtil.getSession();
        
        C_Veterinario vet = (C_Veterinario)sesion.createQuery("FROM POJOS.C_Veterinario v WHERE v.id='"+id+"'").uniqueResult();

        sesion.beginTransaction();
        sesion.delete(vet);
        sesion.getTransaction().commit();
        sesion.close();
        
    }
    
    public static void EliminarCita(C_Cita cita) {
        
        Session sesion=HibernateUtil.getSession();
        
        sesion.beginTransaction();
        sesion.delete(cita);
        sesion.getTransaction().commit();
        sesion.close();
        
    }
    
}
