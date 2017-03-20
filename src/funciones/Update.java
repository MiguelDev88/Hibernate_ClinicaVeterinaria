package funciones;
import POJOS.*;
import hibernate_clinicaveterinaria.HibernateUtil;
import hibernate_clinicaveterinaria.MainWindow;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import org.hibernate.Session;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.gui.server.Main;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;


// @author Miguel

public class Update {

    public static void updateVet(C_Veterinario newVet, int id) {
        
        C_Veterinario vet;
        
        if(MainWindow.modo==0)
        {
            Session sesion=HibernateUtil.getSession();

            vet=(C_Veterinario)sesion.createQuery("FROM POJOS.C_Veterinario v WHERE v.id='"+id+"'").uniqueResult();

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
        else if (MainWindow.modo == 1)
        {
            ODB odb=ODBFactory.open("datos.db");
            Objects<C_Veterinario> veterinarios=odb.getObjects(new CriteriaQuery(C_Veterinario.class,Where.equal("id",id)));
            vet=veterinarios.getFirst();
            
            vet.setNombre(newVet.getNombre());
            vet.setDni(newVet.getDni());
            vet.setEmail(newVet.getEmail());
            vet.setTelefono(newVet.getTelefono());
            vet.setNumLicencia(newVet.getNumLicencia());
            
            odb.store(vet);
            
            odb.close();
            
        }
    }
    
    public static void updateAnimal (C_Animal newAnimal, int id, LinkedList listaVacunas){
        
        C_Animal animal;
        Set vacunasNew=new HashSet();
        Iterator vacunas=listaVacunas.iterator();
        C_Medicamento vacuna;
        
        if(MainWindow.modo==0)
        {
            Session sesion=HibernateUtil.getSession();

            animal=(C_Animal)sesion.createQuery("FROM POJOS.C_Animal a WHERE a.id='"+id+"'").uniqueResult();

            animal.setNombre(newAnimal.getNombre());
            animal.setTipo(newAnimal.getTipo());
            animal.setRaza(newAnimal.getRaza());
            animal.setFecha_nac(newAnimal.getFecha_nac());
            animal.setPeso(newAnimal.getPeso());
            animal.setComentario(newAnimal.getComentario());

            while(vacunas.hasNext())
            {
                String v=(String) vacunas.next();
                vacuna= (C_Medicamento)sesion.createQuery("FROM POJOS.C_Medicamento v WHERE v.nombre='"+v+"'").uniqueResult();
                vacunasNew.add(vacuna);
            }

            animal.setVacunas(vacunasNew);


            sesion.beginTransaction();
            sesion.save(animal);
            sesion.getTransaction().commit();
            sesion.close();
        }
        else if (MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            Objects<C_Animal> animales=odb.getObjects(new CriteriaQuery(C_Animal.class,Where.equal("id",id)));
            animal=animales.getFirst();
            
            animal.setNombre(newAnimal.getNombre());
            animal.setTipo(newAnimal.getTipo());
            animal.setRaza(newAnimal.getRaza());
            animal.setFecha_nac(newAnimal.getFecha_nac());
            animal.setPeso(newAnimal.getPeso());
            animal.setComentario(newAnimal.getComentario());
            
            while(vacunas.hasNext())
            {
                String v=(String) vacunas.next();
                Objects<C_Medicamento> vacunas2=odb.getObjects(new CriteriaQuery(C_Medicamento.class,Where.iequal("nombre",v)));
                vacuna=vacunas2.getFirst();
                vacunasNew.add(vacuna);
            }
            
            animal.setVacunas(vacunasNew);
            
            odb.store(animal);
            
            odb.close();
        }
        
    }
    
    public static void updateCita (String nombVeterinario, String idAnimal, Date fecha, String asunto, C_Cita cita) {
        
        C_Veterinario veterinario;
        C_Animal animal;
        int id;
        
        if(MainWindow.modo==0)
        {
            Eliminar.EliminarCita(cita);

            Session sesion=HibernateUtil.getSession();

            veterinario = (C_Veterinario)sesion.createQuery("FROM POJOS.C_Persona v WHERE v.nombre='"+nombVeterinario+"'").uniqueResult();
            animal = (C_Animal)sesion.createQuery("FROM POJOS.C_Animal a WHERE a.id='"+idAnimal+"'").uniqueResult();
            cita = new C_Cita(fecha, animal, veterinario, asunto);

            sesion.beginTransaction();
            sesion.save(cita);
            sesion.getTransaction().commit();
            sesion.close();
        }
        else if (MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db"); 
            
            Eliminar.EliminarCita(cita);
            
            Objects<C_Veterinario> veterinarios=odb.getObjects(new CriteriaQuery(C_Veterinario.class,Where.iequal("nombre",nombVeterinario)));
            veterinario=veterinarios.getFirst();
            
            int idBusca=Integer.parseInt(idAnimal);
            ICriterion criterion=Where.equal("id", idBusca);
            Objects<C_Animal> animales=odb.getObjects(new CriteriaQuery(C_Animal.class,criterion));
            animal=animales.getFirst();
            
            cita = new C_Cita (fecha, animal, veterinario, asunto);
            
            ObjectValues values=odb.getValues(new ValuesCriteriaQuery(C_Cita.class).max("id")).getFirst();
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
}
