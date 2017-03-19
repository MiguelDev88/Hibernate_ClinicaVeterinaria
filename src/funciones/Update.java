package funciones;
import POJOS.*;
import hibernate_clinicaveterinaria.HibernateUtil;
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
    
    public static void updateAnimal (C_Animal newAnimal, int id){
        
        Session sesion=HibernateUtil.getSession();
            
        C_Animal animal=(C_Animal)sesion.createQuery("FROM POJOS.C_Animal a WHERE a.id='"+id+"'").uniqueResult();
        
        animal.setNombre(newAnimal.getNombre());
        animal.setTipo(newAnimal.getTipo());
        animal.setRaza(newAnimal.getRaza());
        animal.setFecha_nac(newAnimal.getFecha_nac());
        animal.setPeso(newAnimal.getPeso());
        animal.setComentario(newAnimal.getComentario());
        
        sesion.beginTransaction();
        sesion.save(animal);
        sesion.getTransaction().commit();
        sesion.close();
        
    }
    
    

}
