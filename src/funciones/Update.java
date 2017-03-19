package funciones;
import POJOS.*;
import hibernate_clinicaveterinaria.HibernateUtil;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.hibernate.Session;


// @author Miguel

public class Update {

    public static void updateVet(C_Veterinario newVet, int id) {
        
        Session sesion=HibernateUtil.getSession();
            
        C_Veterinario vet=(C_Veterinario)sesion.createQuery("FROM POJOS.C_Veterinario v WHERE v.id='"+id+"'").uniqueResult();
        
        vet.setNombre(newVet.getNombre());
        vet.setDni(newVet.getDni());
        vet.setEmail(newVet.getEmail());
        vet.setTelefono(newVet.getTelefono());
        vet.setNumLicencia(newVet.getNumLicencia());
        
        sesion.beginTransaction();
        sesion.save(vet);
        sesion.getTransaction().commit();
        sesion.close();
    }
    
    public static void updateAnimal (C_Animal newAnimal, int id, LinkedList listaVacunas){
        
        Session sesion=HibernateUtil.getSession();
            
        C_Animal animal=(C_Animal)sesion.createQuery("FROM POJOS.C_Animal a WHERE a.id='"+id+"'").uniqueResult();
        
        animal.setNombre(newAnimal.getNombre());
        animal.setTipo(newAnimal.getTipo());
        animal.setRaza(newAnimal.getRaza());
        animal.setFecha_nac(newAnimal.getFecha_nac());
        animal.setPeso(newAnimal.getPeso());
        animal.setComentario(newAnimal.getComentario());
        
        Iterator vacunas=listaVacunas.iterator();
        Set vacunasNew=new HashSet();
        while(vacunas.hasNext())
        {
            String v=(String) vacunas.next();
            C_Medicamento vacuna= (C_Medicamento)sesion.createQuery("FROM POJOS.C_Medicamento v WHERE v.nombre='"+v+"'").uniqueResult();
            vacunasNew.add(vacuna);
            System.out.println("puse una vacuna en update");
        }
        
        animal.setVacunas(vacunasNew);
        
        
        sesion.beginTransaction();
        sesion.save(animal);
        sesion.getTransaction().commit();
        sesion.close();
        
    }
    
    public static void updateCita (String nombVeterinario, String idAnimal, Date fecha, String asunto, int id) {
        
        Session sesion=HibernateUtil.getSession();
        
        
        C_Cita cita = (C_Cita) sesion.createQuery("FROM POJOS.C_Cita c WHERE c.id='"+id+"'").uniqueResult();
        C_Veterinario veterinario = (C_Veterinario)sesion.createQuery("FROM POJOS.C_Persona v WHERE v.nombre='"+nombVeterinario+"'").uniqueResult();
        C_Animal animal = (C_Animal)sesion.createQuery("FROM POJOS.C_Animal a WHERE a.id='"+idAnimal+"'").uniqueResult();
        
        cita.setVeterinario(veterinario);
        cita.setFecha(fecha);
        cita.setAsunto(asunto);
        cita.setAnimal(animal);
        
        sesion.beginTransaction();
        sesion.save(cita);
        sesion.getTransaction().commit();
        sesion.close();
        
    }
}
