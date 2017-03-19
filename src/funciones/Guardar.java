package funciones;
import POJOS.*;
import hibernate_clinicaveterinaria.HibernateUtil;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import org.hibernate.Session;

/**
 *
 * @author Miguel
 */
public class Guardar {
    
    public static void guardarAnimal (C_Animal animal, LinkedList listaVacunas) {
        
        
        Session sesion=HibernateUtil.getSession();
        
        C_Familiar familiar = (C_Familiar)sesion.createQuery("FROM POJOS.C_Persona f WHERE f.dni='"+animal.getFamiliar().getDni()+"'").uniqueResult();

        if(familiar != null)
            animal.setFamiliar(familiar);
        
        Iterator vacunas=listaVacunas.iterator();
        
        while(vacunas.hasNext())
        {
            String v=(String) vacunas.next();
            C_Medicamento vacuna= (C_Medicamento)sesion.createQuery("FROM POJOS.C_Medicamento v WHERE v.nombre='"+v+"'").uniqueResult();
            animal.getVacunas().add(vacuna);
            System.out.println("puse una vacuna");
        }
        
        sesion.beginTransaction();
        sesion.save(animal);
        sesion.getTransaction().commit();
        sesion.close();
        
    }
    
    public static void guardarCita (String nombVeterinario, String idAnimal, Date fecha, String asunto) {
        
        Session sesion=HibernateUtil.getSession();
        
        C_Veterinario veterinario = (C_Veterinario)sesion.createQuery("FROM POJOS.C_Persona v WHERE v.nombre='"+nombVeterinario+"'").uniqueResult();
        C_Animal animal = (C_Animal)sesion.createQuery("FROM POJOS.C_Animal a WHERE a.id='"+idAnimal+"'").uniqueResult();
        
        
        C_Cita cita = new C_Cita (fecha, animal, veterinario, asunto);
        
        sesion.beginTransaction();
        sesion.save(cita);
        sesion.getTransaction().commit();
        sesion.close();
        
    }
    
    public static void guardarVet (C_Veterinario vet ){
        
        Session sesion=HibernateUtil.getSession();
        
        sesion.beginTransaction();
        sesion.save(vet);
        sesion.getTransaction().commit();
        sesion.close();
    }
    
}
