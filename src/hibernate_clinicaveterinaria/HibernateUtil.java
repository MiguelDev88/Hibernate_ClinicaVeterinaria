package hibernate_clinicaveterinaria;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;


// @author Miguel
 
public class HibernateUtil {

    private static SessionFactory sessionFactory;//=new AnnotationConfiguration().configure().buildSessionFactory();
    
    static AnnotationConfiguration conf = new AnnotationConfiguration().configure();
    static String url="jdbc:mysql://localhost:3307/clinica_veterinaria";
    static String usuario="root";
    static String password="usbw";
    
    public static void buildSessionFactory () {
        
      conf.setProperty("connection.url", url);
      conf.setProperty("connection.username", usuario);
      conf.setProperty("connection.password", password);
      sessionFactory = conf.buildSessionFactory();
        System.out.println("ya cree el sesion factory");
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session getSession(){
        return sessionFactory.openSession();
    }
}
