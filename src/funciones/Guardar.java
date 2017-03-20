package funciones;
import POJOS.*;
import hibernate_clinicaveterinaria.HibernateUtil;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import org.hibernate.Session;
import hibernate_clinicaveterinaria.MainWindow;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

/**
 *
 * @author Miguel
 */
public class Guardar {
    
    public static void guardarAnimal (C_Animal animal, LinkedList listaVacunas) {
        
        if (MainWindow.modo==0)
        {
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
        }
        
        sesion.beginTransaction();
        sesion.save(animal);
        sesion.getTransaction().commit();
        sesion.close();
        }
        else if (MainWindow.modo==1)
        {
            guardarAnimal(animal);
        }
        
    }
    
    public static void guardarAnimal (C_Animal animal ){
        //maldito neodatis
        int id;
        ObjectValues values;
        ODB odb=ODBFactory.open("datos.db"); 
        
        Objects<C_Familiar> familiares=odb.getObjects(new CriteriaQuery(C_Familiar.class,Where.equal("dni",animal.getFamiliar().getDni())));

        if(familiares.isEmpty()){
            
        values=odb.getValues(new ValuesCriteriaQuery(C_Familiar.class).max("id")).getFirst();
        try{
        id=Integer.valueOf(values.getByAlias("id").toString())+1;
        }catch(Exception e)
        {
            id=1;
        }
        
        animal.getFamiliar().setId(id);
        }
        else
            animal.setFamiliar(familiares.getFirst());
        
        values=odb.getValues(new ValuesCriteriaQuery(C_Animal.class).max("id")).getFirst();
        try{
        id=Integer.valueOf(values.getByAlias("id").toString())+1;
        }catch(Exception e)
        {
            id=1;
        }
        
        animal.setId(id);
        
        odb.store(animal);
        System.out.println("animal guardado"+id);
        odb.close();
        
    }
    
    public static void guardarMedicamento (C_Medicamento medicamento ){
        //maldito neodatis
        int id;
        ObjectValues values;
        ODB odb=ODBFactory.open("datos.db"); 

        
        values=odb.getValues(new ValuesCriteriaQuery(C_Medicamento.class).max("id")).getFirst();
        try{
        id=Integer.valueOf(values.getByAlias("id").toString())+1;
        }catch(Exception e)
        {
            id=1;
        }
        
        medicamento.setId(id);
        
        odb.store(medicamento);
        System.out.println("medicamento guardado"+id);
        odb.close();
        
    }
    
    public static void guardarCita (String nombVeterinario, String idAnimal, Date fecha, String asunto) {
        
        C_Cita cita;
        C_Veterinario veterinario;
        C_Animal animal;
        ObjectValues values;
        int id;
        
        if(MainWindow.modo==0)
        {
        Session sesion=HibernateUtil.getSession();
        
        veterinario = (C_Veterinario)sesion.createQuery("FROM POJOS.C_Persona v WHERE v.nombre='"+nombVeterinario+"'").uniqueResult();
        animal = (C_Animal)sesion.createQuery("FROM POJOS.C_Animal a WHERE a.id='"+idAnimal+"'").uniqueResult();
        
        
        cita = new C_Cita (fecha, animal, veterinario, asunto);
        
        sesion.beginTransaction();
        sesion.save(cita);
        sesion.getTransaction().commit();
        sesion.close();
        }
        else if(MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db"); 
            
            Objects<C_Veterinario> veterinarios=odb.getObjects(new CriteriaQuery(C_Veterinario.class,Where.iequal("nombre",nombVeterinario)));
            veterinario=veterinarios.getFirst();
            System.out.println("tengo al vet "+veterinario.getNombre());
            String idbusca=String.valueOf(idAnimal);
            System.out.println("voy a buscar"+idbusca);
            
            int idBusca=Integer.parseInt(idAnimal);
            ICriterion criterion=Where.equal("id", idBusca);
            Objects<C_Animal> animales=odb.getObjects(new CriteriaQuery(C_Animal.class,criterion));
            animal=animales.getFirst();
            
            cita = new C_Cita (fecha, animal, veterinario, asunto);
            
            values=odb.getValues(new ValuesCriteriaQuery(C_Cita.class).max("id")).getFirst();
            try{
            id=Integer.valueOf(values.getByAlias("id").toString())+1;
            }catch(Exception e)
            {
                id=1;
            }
            
            cita.setId(id);
            odb.store(cita);
            odb.close();
        }
        
    }
    
    public static void guardarVet (C_Veterinario vet ){
        
        ObjectValues values;
        int id;
        
        if(MainWindow.modo==0)
        {
        Session sesion=HibernateUtil.getSession();
        
        sesion.beginTransaction();
        sesion.save(vet);
        sesion.getTransaction().commit();
        sesion.close();
        }
        else if(MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db"); 
            values=odb.getValues(new ValuesCriteriaQuery(C_Veterinario.class).max("id")).getFirst();
            try{
            id=Integer.valueOf(values.getByAlias("id").toString())+1;
            }catch(Exception e)
            {
                id=1;
            }
            
            vet.setId(id);
            odb.store(vet);
            odb.close();
            System.out.println("vet guardado"+id);
        }
    }
    
    public static void guardarDiagnostico (C_Diagnostico diagnostico ){
        ////////////////////////////////////FALTAAAAAAAAAAAAAAAAAAAAAA
        Session sesion=HibernateUtil.getSession();
        
        sesion.beginTransaction();
        sesion.save(diagnostico);
        sesion.getTransaction().commit();
        sesion.close();
    }
    
}
