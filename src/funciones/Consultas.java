package funciones;
import POJOS.C_Animal;
import POJOS.C_Cita;
import POJOS.C_Familiar;
import POJOS.C_Persona;
import POJOS.C_Veterinario;
import hibernate_clinicaveterinaria.HibernateUtil;
import java.util.Iterator;
import javax.swing.JComboBox;
import org.hibernate.Query;
import org.hibernate.Session;


// @author Miguel

public class Consultas {
    
    public static C_Animal recuperarAnimalPorId (int id){
        
        
        Session sesion=HibernateUtil.getSession();
            
        C_Animal animal=(C_Animal)sesion.createQuery("FROM POJOS.C_Animal a WHERE a.id='"+id+"'").uniqueResult();
        
        sesion.close();
        
        return animal;
        
    }
    
    public static Iterator recuperarAnimalesPorIdFamiliar (int id){
        
        
        Session sesion=HibernateUtil.getSession();
            
        
        Iterator animales=sesion.createQuery("FROM POJOS.C_Animal a WHERE a.familiar='"+id+"'").list().iterator();
        
        sesion.close();
        
        return animales;
        
    }
    
    public static int numFactura (){
        
        
        Session sesion=HibernateUtil.getSession();
        int max;
        
        try{
            max=Integer.parseInt(sesion.createQuery("select max(id) from POJOS.C_Factura").uniqueResult().toString());
        }catch(Exception e){
            max=0;
        }
        
        sesion.close();
        
        return max;
        
    }
    
    public static C_Veterinario recuperarVeterinarioPorId (int id){
        
        
        Session sesion=HibernateUtil.getSession();
            
        C_Veterinario vet=(C_Veterinario)sesion.createQuery("FROM POJOS.C_Veterinario v WHERE v.id='"+id+"'").uniqueResult();
        
        sesion.close();
        
        return vet;
        
    }
    
    public static C_Veterinario recuperarVeterinarioPorDni (int dni){
        
        
        Session sesion=HibernateUtil.getSession();
            
        C_Veterinario vet=(C_Veterinario)sesion.createQuery("FROM POJOS.C_Veterinario v WHERE v.dni='"+dni+"'").uniqueResult();
        
        sesion.close();
        
        return vet;
        
    }
    
    public static Iterator cargarFamiliares () {
        
        Session sesion=HibernateUtil.getSession();
        Iterator familiares = sesion.createCriteria(C_Familiar.class).list().iterator();
        sesion.close();
        return familiares;
    }
    
    public static Iterator cargarVeterinarios () {
        
        Session sesion=HibernateUtil.getSession();
        Iterator veterinarios = sesion.createCriteria(C_Veterinario.class).list().iterator();
        sesion.close();
        return veterinarios;
        
    }
    
    //este método devuelve un iterator con todos los animales
    public static Iterator cargarAnimales () {

        Session sesion=HibernateUtil.getSession();
        Iterator animales = sesion.createCriteria(C_Animal.class).list().iterator();
            
        sesion.close();

        return animales;
        
    }
    
    public static Iterator cargarCitas () {
        
        
        Session sesion=HibernateUtil.getSession();
        Iterator citasIt = sesion.createCriteria(C_Cita.class).list().iterator();
        sesion.close();
        return citasIt;
        
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
    
    public static Iterator recuperarPersonasPordni(String dni ) {
        
        Session sesion=HibernateUtil.getSession();
        Query qry = sesion.createQuery("FROM POJOS.C_Persona f WHERE f.dni like ?");
        qry.setString(0, dni+"%");
        Iterator familiares =qry.list().iterator();
        
        return familiares;
    }
    
    public static C_Persona recuperarUnaPersonaPordni (String dni) {
        
        
        Session sesion=HibernateUtil.getSession();
        C_Persona familiar = (C_Familiar)sesion.createQuery("FROM POJOS.C_Persona f WHERE f.dni='"+dni+"'").uniqueResult();
        
        return familiar;
        
        
    }
    
    public static Iterator recuperarAnimalesPorNombre (String filtro) {
        
        Session sesion=HibernateUtil.getSession();
        Query qry = sesion.createQuery("FROM POJOS.C_Animal a WHERE a.nombre like ?");
        qry.setString(0, filtro+"%");
        Iterator animales =qry.list().iterator();
        
        return animales;
    }
    
    public static Iterator recuperarAnimalesPorId (String filtro) {
        
        Session sesion=HibernateUtil.getSession();
        Query qry = sesion.createQuery("FROM POJOS.C_Animal a WHERE a.id like ?");
        qry.setString(0, filtro+"%");
        Iterator animales =qry.list().iterator();
        
        return animales;
    }

}
