/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import POJOS.C_Animal;
import POJOS.C_Familiar;
import POJOS.C_Persona;
import hibernate_clinicaveterinaria.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author a15carlosmpf
 */
public class Eliminar {
    
    public static void EliminarAnimal (int id) {
        
        
        Session sesion=HibernateUtil.getSession();
        
        C_Animal animal = (C_Animal)sesion.createQuery("FROM POJOS.C_Animal a WHERE a.id='"+id+"'").uniqueResult();

        sesion.beginTransaction();
        sesion.delete(animal);
        sesion.getTransaction().commit();
        sesion.close();
        
    }
    
}
