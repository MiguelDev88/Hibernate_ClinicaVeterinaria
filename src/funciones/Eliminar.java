package funciones;
import POJOS.*;
import hibernate_clinicaveterinaria.HibernateUtil;
import hibernate_clinicaveterinaria.MainWindow;
import org.hibernate.Session;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;


public class Eliminar {
    
    public static void EliminarAnimal (int id) {
        
        C_Animal animal;
        
        if(MainWindow.modo==0)
        {
        Session sesion=HibernateUtil.getSession();
        
        animal = (C_Animal)sesion.createQuery("FROM POJOS.C_Animal a WHERE a.id='"+id+"'").uniqueResult();

        sesion.beginTransaction();
        sesion.delete(animal);
        sesion.getTransaction().commit();
        sesion.close();
        }
        else if (MainWindow.modo==1){
            
            ODB odb=ODBFactory.open("datos.db");
            ICriterion criterion=Where.equal("id", id);
            Objects<C_Animal> animales=odb.getObjects(new CriteriaQuery(C_Animal.class,criterion));
            animal=animales.getFirst();
            odb.delete(animal);
            odb.close();
        }
        
    }

    public static void EliminarVeterinario(int id) {
        
        C_Veterinario vet;
        
        if(MainWindow.modo==0)
        {
        Session sesion=HibernateUtil.getSession();
        
        vet = (C_Veterinario)sesion.createQuery("FROM POJOS.C_Veterinario v WHERE v.id='"+id+"'").uniqueResult();

        sesion.beginTransaction();
        sesion.delete(vet);
        sesion.getTransaction().commit();
        sesion.close();
        }
        else if (MainWindow.modo==1){
            
            ODB odb=ODBFactory.open("datos.db");
            ICriterion criterion=Where.equal("id", id);
            Objects<C_Veterinario> veterinarios=odb.getObjects(new CriteriaQuery(C_Veterinario.class,criterion));
            vet=veterinarios.getFirst();
            odb.delete(vet);
            odb.close();
        }
        
    }
    
    public static void EliminarCita(C_Cita cita) {
        
        if(MainWindow.modo==0)
        {
        Session sesion=HibernateUtil.getSession();
        
        sesion.beginTransaction();
        sesion.delete(cita);
        sesion.getTransaction().commit();
        sesion.close();
        }
        else if (MainWindow.modo==1){
            
            ODB odb=ODBFactory.open("datos.db");
            odb.delete(cita);
            odb.close();
        }
        
    }
    
}
