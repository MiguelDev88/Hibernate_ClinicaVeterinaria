package funciones;
import POJOS.C_Animal;
import POJOS.C_Familiar;
import POJOS.C_Persona;
import POJOS.C_Veterinario;
import hibernate_clinicaveterinaria.HibernateUtil;
import java.util.Iterator;
import javax.swing.JComboBox;
import org.hibernate.Session;


// @author Miguel

public class Consultas {
    
    public static C_Animal recuperarAnimalPorId (int id){
        
        
        Session sesion=HibernateUtil.getSession();
            
        C_Animal animal=(C_Animal)sesion.createQuery("FROM POJOS.C_Animal a WHERE a.id='"+id+"'").uniqueResult();
        
        sesion.close();
        
        return animal;
        
    }
    
    public static void cargarVetCombo (JComboBox combo) {
        
        combo.removeAllItems();
        //combo.addItem("");
        
        try{
            Session sesion=HibernateUtil.getSession();
            Iterator veterinarios = sesion.createCriteria(C_Veterinario.class).list().iterator();
            
            while(veterinarios.hasNext())
            {
                C_Persona veterinario=(C_Veterinario)veterinarios.next();
                combo.addItem(veterinario.getNombre());
            }
            sesion.close();
         
        }catch (Exception e) {
            
            System.out.println(e.getMessage());
        }  
    }

}
