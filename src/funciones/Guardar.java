package funciones;
import POJOS.*;
import hibernate_clinicaveterinaria.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Miguel
 */
public class Guardar {
    
    public static void guardarAnimal (C_Animal animal) {
        
        
        Session sesion=HibernateUtil.getSession();
        
        C_Familiar familiar = (C_Familiar)sesion.createQuery("FROM POJOS.C_Persona f WHERE f.dni='"+animal.getFamiliar().getDni()+"'").uniqueResult();

        if(familiar != null)
            animal.setFamiliar(familiar);
        
        System.out.println("voy a guardar");
        System.out.println("save");
        sesion.beginTransaction();
        sesion.save(animal);
        sesion.getTransaction().commit();
        sesion.close();
        
    }
    
}
