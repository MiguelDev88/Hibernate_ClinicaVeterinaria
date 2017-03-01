package hibernate_clinicaveterinaria;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;


// @author Miguel
 
public class HibernateUtil {

    private static final SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session getSession(){
        return sessionFactory.openSession();
    }
}
