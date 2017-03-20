package funciones;
import POJOS.C_Animal;
import POJOS.C_Cita;
import POJOS.C_Familiar;
import POJOS.C_Medicamento;
import POJOS.C_Persona;
import POJOS.C_Veterinario;
import hibernate_clinicaveterinaria.HibernateUtil;
import java.util.Iterator;
import javax.swing.JComboBox;
import org.hibernate.Query;
import org.hibernate.Session;
import hibernate_clinicaveterinaria.MainWindow;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;


// @author Miguel

public class Consultas {
    
    public static C_Animal recuperarAnimalPorId (int id){
        
        C_Animal animal=null;
        if(MainWindow.modo==0)
        {
            Session sesion=HibernateUtil.getSession();

            animal=(C_Animal)sesion.createQuery("FROM POJOS.C_Animal a WHERE a.id='"+id+"'").uniqueResult();

            sesion.close();
        }
        else if(MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            //ICriterion criterion=Where.like("id", id);
            //Iterator jugadores=odb.getObjects(new CriteriaQuery(C_Jugador.class, criterion)).iterator();
            Objects<C_Animal> animales=odb.getObjects(new CriteriaQuery(C_Animal.class,Where.equal("id",id)));
            animal=animales.getFirst();
            odb.close();
            
        }
        
        return animal;
        
    }
    
    public static Iterator recuperarAnimalesPorIdFamiliar (int id){
        
        Iterator animales=null;
        if(MainWindow.modo==0)
        {
            Session sesion=HibernateUtil.getSession();


            animales=sesion.createQuery("FROM POJOS.C_Animal a WHERE a.familiar='"+id+"'").list().iterator();

            sesion.close();
        }
        else if(MainWindow.modo ==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            ICriterion criterion=Where.equal("id", id);
            animales=odb.getObjects(new CriteriaQuery(C_Animal.class, criterion)).iterator();
            odb.close();
        }
        
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
        
        C_Veterinario vet=null;
        
        if(MainWindow.modo==0)
        {
            Session sesion=HibernateUtil.getSession();

            vet=(C_Veterinario)sesion.createQuery("FROM POJOS.C_Veterinario v WHERE v.id='"+id+"'").uniqueResult();

            sesion.close();
        }
        else if (MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            Objects<C_Veterinario> veterinarios=odb.getObjects(new CriteriaQuery(C_Veterinario.class,Where.equal("id",id)));
            vet=veterinarios.getFirst();
            odb.close();
            
        }
        
        return vet;
        
    }
    
    public static C_Veterinario recuperarVeterinarioPorDni (String dni){
        
        C_Veterinario vet=null;
        
        if(MainWindow.modo==0)
        {
            Session sesion=HibernateUtil.getSession();

            vet=(C_Veterinario)sesion.createQuery("FROM POJOS.C_Veterinario v WHERE v.dni='"+dni+"'").uniqueResult();

            sesion.close();
        }
        else if (MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            Objects<C_Veterinario> veterinarios=odb.getObjects(new CriteriaQuery(C_Veterinario.class,Where.equal("dni",dni)));
            vet=veterinarios.getFirst();
            odb.close();
            
        }
        
        return vet;
        
    }
    
    public static C_Veterinario recuperarVeterinarioPorNombre (String nombre){
        
        C_Veterinario vet=null;
        
        if(MainWindow.modo==0)
        {
            Session sesion=HibernateUtil.getSession();

            vet=(C_Veterinario)sesion.createQuery("FROM POJOS.C_Veterinario v WHERE v.nombre='"+nombre+"'").uniqueResult();

            sesion.close();
        }
        else if (MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            Objects<C_Veterinario> veterinarios=odb.getObjects(new CriteriaQuery(C_Veterinario.class,Where.iequal("nombre",nombre)));
            vet=veterinarios.getFirst();
            odb.close();
            
        }
        
        return vet;
        
    }
    
    public static Iterator cargarCitasporVet(int idVet){
        
        Iterator citas=null;
        
        if (MainWindow.modo==0)
        {
            Session sesion=HibernateUtil.getSession();

            citas=sesion.createQuery("FROM POJOS.C_Cita c WHERE c.veterinario='"+idVet+"' ORDER BY c.fecha").list().iterator();

            sesion.close();
        }
        else if (MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            Objects<C_Veterinario> veterinarios=odb.getObjects(new CriteriaQuery(C_Veterinario.class,Where.equal("id",idVet)));
            C_Veterinario vet=veterinarios.getFirst();
            ICriterion criterion=Where.equal("veterinario.id", idVet);
            System.out.println("tengo a "+vet.getNombre());
            citas=odb.getObjects(new CriteriaQuery(C_Cita.class, criterion)).iterator();
            
            odb.close();
        }
        
        return citas;
        
    }
    
    public static Iterator cargarFamiliares () {
        
        Iterator familiares = null;
        
        if (MainWindow.modo==0)
        {
            Session sesion=HibernateUtil.getSession();
            familiares = sesion.createCriteria(C_Familiar.class).list().iterator();
            sesion.close();
        }
        else if (MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            familiares=odb.getObjects(new CriteriaQuery(C_Cita.class)).iterator();
            odb.close();
        }
        
        return familiares;
    }
    
    public static Iterator cargarMedicamentos () {
        
        Iterator medicamentos=null;
        
        if (MainWindow.modo==0)
        {
        Session sesion=HibernateUtil.getSession();
        medicamentos=sesion.createQuery("FROM POJOS.C_Medicamento m WHERE m.tipo  is not 'vacuna'").list().iterator();
        sesion.close();
        }
        else if (MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            ICriterion criterionVac=Where.equal("tipo", "vacuna");
            ICriterion criterion=Where.not(criterionVac);
            medicamentos=odb.getObjects(new CriteriaQuery(C_Medicamento.class,criterion)).iterator();
            odb.close();
        }
        return medicamentos;
    }
    
    public static Iterator cargarVeterinarios () {
        
        Iterator veterinarios = null;
        if (MainWindow.modo==0)
        {
        Session sesion=HibernateUtil.getSession();
        veterinarios = sesion.createCriteria(C_Veterinario.class).list().iterator();
        sesion.close();
        }
        else if (MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            veterinarios=odb.getObjects(new CriteriaQuery(C_Veterinario.class)).iterator();
            odb.close();
        }
        return veterinarios;
        
    }
    
    //este método devuelve un iterator con todos los animales
    public static Iterator cargarAnimales () {

        Iterator animales=null;
        if (MainWindow.modo==0)
        {
        Session sesion=HibernateUtil.getSession();
        animales = sesion.createCriteria(C_Animal.class).list().iterator();
            
        sesion.close();
        }
        else if (MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            animales=odb.getObjects(new CriteriaQuery(C_Animal.class)).iterator();
            odb.close();
        }

        return animales;
        
    }
    
    public static Iterator cargarCitas () {
        
        Iterator citas=null;
        if (MainWindow.modo==0)
        {
        Session sesion=HibernateUtil.getSession();
        citas = sesion.createCriteria(C_Cita.class).list().iterator();
        sesion.close();
        }
        else if (MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            citas=odb.getObjects(new CriteriaQuery(C_Cita.class)).iterator();
            odb.close();
        }
        return citas;
        
    }
    
    public static void cargarVetCombo (JComboBox combo) {
        
        combo.removeAllItems();
        Iterator veterinarios;
        
        if(MainWindow.modo==0)
        {
            try{
                Session sesion=HibernateUtil.getSession();
                veterinarios = sesion.createCriteria(C_Veterinario.class).list().iterator();

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
        else if (MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            veterinarios=odb.getObjects(new CriteriaQuery(C_Veterinario.class)).iterator();
            while(veterinarios.hasNext())
                {
                    C_Persona veterinario=(C_Veterinario)veterinarios.next();
                    combo.addItem(veterinario.getNombre());
                }
            odb.close();
            
        }
    }
    
    public static Iterator recuperarPersonasPordni(String dni ) {
        
        Iterator familiares=null;
        if(MainWindow.modo==0)
        {
            Session sesion=HibernateUtil.getSession();
            Query qry = sesion.createQuery("FROM POJOS.C_Persona f WHERE f.dni like ?");
            qry.setString(0, dni+"%");
            familiares =qry.list().iterator();
            sesion.close();
        }
        else if (MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            ICriterion criterion=Where.ilike("dni", dni);
            familiares=odb.getObjects(new CriteriaQuery(C_Familiar.class,criterion)).iterator();
            odb.close();
        }
        
        return familiares;
    }
    
    public static C_Persona recuperarUnaPersonaPordni (String dni) {
        
        C_Persona familiar= null;
        if(MainWindow.modo==0)
        {
        Session sesion=HibernateUtil.getSession();
        familiar = (C_Familiar)sesion.createQuery("FROM POJOS.C_Persona f WHERE f.dni='"+dni+"'").uniqueResult();
        sesion.close();
        }
        else if (MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            Objects<C_Familiar> familiares=odb.getObjects(new CriteriaQuery(C_Familiar.class,Where.iequal("dni",dni)));
            familiar=familiares.getFirst();
            odb.close();
        }
        
        return familiar;
        
        
    }
    
    public static Iterator recuperarAnimalesPorNombre (String filtro) {
        
        Iterator animales=null;
        
        if(MainWindow.modo==0)
        {
        Session sesion=HibernateUtil.getSession();
        Query qry = sesion.createQuery("FROM POJOS.C_Animal a WHERE a.nombre like ?");
        qry.setString(0, filtro+"%");
        animales =qry.list().iterator();
        }
        else if(MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            ICriterion criterion=Where.ilike("nombre", filtro);
            animales=odb.getObjects(new CriteriaQuery(C_Animal.class,criterion)).iterator();
            odb.close();
        }
        
        
        return animales;
    }
    
    public static Iterator recuperarMedicamentosPorNombre (String filtro) {
        
        Iterator medicamentos=null;
        
        if(MainWindow.modo==0)
        {
        Session sesion=HibernateUtil.getSession();
        Query qry = sesion.createQuery("FROM POJOS.C_Medicamento m WHERE m.tipo  is not 'vacuna' AND m.nombre like ?");
        qry.setString(0, filtro+"%");
        medicamentos =qry.list().iterator();
        sesion.close();
        }
        else if(MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            ICriterion criterionVac=Where.equal("tipo", "vacuna");
            ICriterion criterion=new And().add (Where.ilike("nombre", filtro))
                                          .add(Where.not(criterionVac));
            medicamentos=odb.getObjects(new CriteriaQuery(C_Medicamento.class,criterion)).iterator();
            odb.close();
        }
        
        return medicamentos;
    }
    
    public static Iterator recuperarAnimalesPorId (String filtro) {
        
        Iterator animales=null;
        
        if(MainWindow.modo==0)
        {
        Session sesion=HibernateUtil.getSession();
        Query qry = sesion.createQuery("FROM POJOS.C_Animal a WHERE a.id like ?");
        qry.setString(0, filtro+"%");
        animales =qry.list().iterator();
        }
        else if(MainWindow.modo==1)
        {
            ODB odb=ODBFactory.open("datos.db");
            ICriterion criterion=Where.ilike("id", filtro);
            animales=odb.getObjects(new CriteriaQuery(C_Animal.class,criterion)).iterator();
            odb.close();
        }
        
        return animales;
    }

}
