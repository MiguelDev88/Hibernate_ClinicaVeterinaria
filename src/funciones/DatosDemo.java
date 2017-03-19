/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import POJOS.C_Animal;
import POJOS.C_Familiar;
import POJOS.C_Medicamento;
import hibernate_clinicaveterinaria.HibernateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.hibernate.Session;

/**
 *
 * @author Saul
 */
public class DatosDemo {
    public static boolean cargarTodos() throws ParseException{


        Session sesion = HibernateUtil.getSession();
        cargarMedicamentos(sesion);
        cargarFamiliaresyAnimales(sesion);
               
        return true;
    }
    
    private static boolean cargarFamiliaresyAnimales(Session sesion) throws ParseException{
        
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        C_Familiar familiar;
        C_Animal animal;
        sesion.beginTransaction();
        familiar = new C_Familiar("00000000T", "Steve Robinson", "662735370", "stever@gmail.com", "9079 Andover Dr.Ormond Beach, FL 32174");
        animal = new C_Animal("Rebel", "Gato", "Siamés", 'H', parser.parse("2000-01-01"), 4, "", familiar);
        sesion.save(animal);
        animal = new C_Animal("Cash", "Perro", "Akita", 'M', parser.parse("2000-01-01"), 10, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("11111111H", "Ernest Gray", "766438410", "earnestg@gmail.com", "211 Blackburn Ave.Euless, TX 76039");
        animal = new C_Animal("Blizzard", "Perro", "Beagle", 'H', parser.parse("2000-01-01"), 8, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("22222222J", "Anna Cox", "649224987", "annac@gmail.com", "503 N. Lake Forest St.Council Bluffs, IA 51501");
        animal = new C_Animal("Jester", "Gato", "Bengala", 'M', parser.parse("2000-01-01"), 3, "", familiar);
        sesion.save(animal);
        animal = new C_Animal("Nibbles", "Gato", "Siamés", 'H', parser.parse("2000-01-01"), 5, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("33333333P", "Jimmy Mitchell", "698333709", "jimmym@gmail.com", "11 Wrangler Street West Palm Beach, FL 33404");
        animal = new C_Animal("Plague", "Pájaro", "Periquito", 'M', parser.parse("2000-01-01"), 0.4f, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("44444444A", "Sandra Wood", "823110551", "sandraw@gmail.com", "88 Manchester Dr.Acworth, GA 30101");
        animal = new C_Animal("Menace", "Roedor", "Cobaya", 'H', parser.parse("2000-01-01"), 0.7f, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("55555555K", "Keith Kelly", "847906919", "keithk@gmail.com", "302 Fremont Road La Porte, IN 46350");
        animal = new C_Animal("Clooney", "Gato", "", 'M', parser.parse("2000-01-01"), 3.5f, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("66666666Q", "Elizabeth Simmons", "654934356", "elizabeths@gmail.com", "170 Jockey Hollow Street Loganville, GA 30052");
        animal = new C_Animal("Gordon", "Perro", "Carlino", 'H', parser.parse("2000-01-01"), 8, "", familiar);
        sesion.save(animal);
        animal = new C_Animal("Dewey", "Pez", "Arcoíris", 'M', parser.parse("2000-01-01"), 0, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("77777777B", "Ralph Gonzalez", "758901466", "ralphg@gmail.com", "35 Temple St.York, PA 17402");
        animal = new C_Animal("Lucas", "Roedor", "Hámster", 'M', parser.parse("2000-01-01"), 0.2f, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("88888888Y", "Sharon Green", "669293927", "sharong@gmail.com", "478 Olive Street Encino, CA 91316");
        animal = new C_Animal("Loony", "Gato", "Persa", 'H', parser.parse("2000-01-01"), 4, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("99999999R", "Annie Campbell", "699193566", "anniec@gmail.com", "36 Arch Court Elkhart, IN 46514");
        animal = new C_Animal("Scamp", "Gato", "Persa", 'M', parser.parse("2000-01-01"), 6, "", familiar);
        sesion.save(animal);
        animal = new C_Animal("Plush", "Perro", "Carlino", 'H', parser.parse("2000-01-01"), 4, "", familiar);
        sesion.save(animal);
        animal = new C_Animal("Paco", "Perro", "Akita", 'H', parser.parse("2000-01-01"), 7, "", familiar);
        sesion.save(animal);
        sesion.getTransaction().commit();
        return true;
    }

    private static boolean cargarMedicamentos(Session sesion) {
        C_Medicamento medicamento;
        sesion.beginTransaction();
        medicamento = new C_Medicamento("Parvo", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Moquillo", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Parainfluenza", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Rabia", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Tri_Vírica", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Panleucopenia", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Rinotraqueitis", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Calcivirosis", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Leucemia felina", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Clamidias", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Viruela", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Profilaxis", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Bronipra", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Coripravac", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Intra-peritoneal", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Anemia", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Viremia", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Septicemia", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Mixomatosis", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Hemorragia vírica", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Nobivac", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Rabia", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Fiebre aftosa", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Rabia", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Edema maligno", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Virus-T", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Pasyeurela", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Salmonela", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Actinobacillus", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Écoli", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Influenza", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Tétanos", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Rinoneumonitis", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Papera equina", "vacuna", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Oftalmolosa cusí", "medicamento", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Azydrop", "medicamento", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Oftalmowell", "medicamento", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Broadline", "medicamento", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Seresto", "medicamento", 0, "activina", "5", "10", "peligroso");
        sesion.save(medicamento);
        return true;
       
    }
    
}
