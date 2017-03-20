/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import POJOS.C_Animal;
import POJOS.C_Familiar;
import POJOS.C_Medicamento;
import POJOS.C_Veterinario;
import hibernate_clinicaveterinaria.HibernateUtil;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.hibernate.Session;
import hibernate_clinicaveterinaria.MainWindow;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

/**
 *
 * @author Saul
 */
public class DatosDemo {
    public static boolean cargarTodos() throws ParseException{


        if(MainWindow.modo==0)
        {
            System.out.println("hibernate!");
            Session sesion = HibernateUtil.getSession();
            cargarMedicamentosHib(sesion);
            cargarFamiliaresyAnimalesHib(sesion);
            cargarVeterinariosHib(sesion);
            sesion.close();
        }
        else if (MainWindow.modo==1)
        {
            System.out.println("neodatis!");
            cargarMedicamentosNeo();
            cargarFamiliaresyAnimalesNeo();
            cargarVeterinariosNeo();

            
        }
        
        return true;
    }
    
    private static boolean cargarFamiliaresyAnimalesHib(Session sesion) throws ParseException{
        
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        C_Familiar familiar;
        C_Animal animal;
        
        sesion.beginTransaction();
        familiar = new C_Familiar("00000000T", "Steve Robinson", "662735370", "stever@gmail.com", "9079 Andover Dr.Ormond Beach, FL 32174");
        animal = new C_Animal("Rebel", "Gato", "Siames", 'H', parser.parse("2000-01-01"), 4, "", familiar);
        sesion.save(animal);
        animal = new C_Animal("Cash", "Perro", "Akita", 'M', parser.parse("2000-01-01"), 10, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("11111111H", "Ernest Gray", "766438410", "earnestg@gmail.com", "211 Blackburn Ave.Euless, TX 76039");
        animal = new C_Animal("Blizzard", "Perro", "Beagle", 'H', parser.parse("2000-01-01"), 8, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("22222222J", "Anna Cox", "649224987", "annac@gmail.com", "503 N. Lake Forest St.Council Bluffs, IA 51501");
        animal = new C_Animal("Jester", "Gato", "Bengala", 'M', parser.parse("2000-01-01"), 3, "", familiar);
        sesion.save(animal);
        animal = new C_Animal("Nibbles", "Gato", "Siames", 'H', parser.parse("2000-01-01"), 5, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("33333333P", "Jimmy Mitchell", "698333709", "jimmym@gmail.com", "11 Wrangler Street West Palm Beach, FL 33404");
        animal = new C_Animal("Plague", "Pajaro", "Periquito", 'M', parser.parse("2000-01-01"), 0.4f, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("44444444A", "Sandra Wood", "823110551", "sandraw@gmail.com", "88 Manchester Dr.Acworth, GA 30101");
        animal = new C_Animal("Menace", "Roedor", "Cobaya", 'H', parser.parse("2000-01-01"), 0.7f, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("55555555K", "Keith Kelly", "847906919", "keithk@gmail.com", "302 Fremont Road La Porte, IN 46350");
        animal = new C_Animal("Clooney", "Gato", "Persa", 'M', parser.parse("2000-01-01"), 3.5f, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("66666666Q", "Elizabeth Simmons", "654934356", "elizabeths@gmail.com", "170 Jockey Hollow Street Loganville, GA 30052");
        animal = new C_Animal("Gordon", "Perro", "Carlino", 'H', parser.parse("2000-01-01"), 8, "", familiar);
        sesion.save(animal);
        animal = new C_Animal("Dewey", "Pez", "Arcoiris", 'M', parser.parse("2000-01-01"), 0, "", familiar);
        sesion.save(animal);
        familiar = new C_Familiar("77777777B", "Ralph Gonzalez", "758901466", "ralphg@gmail.com", "35 Temple St.York, PA 17402");
        animal = new C_Animal("Lucas", "Roedor", "Hamster", 'M', parser.parse("2000-01-01"), 0.2f, "", familiar);
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
    
    private static boolean cargarFamiliaresyAnimalesNeo() throws ParseException{
        
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        C_Familiar familiar;
        C_Animal animal;
        
        System.out.println("datos de muestra");
        familiar = new C_Familiar("00000000T", "Steve Robinson", "662735370", "stever@gmail.com", "9079 Andover Dr.Ormond Beach, FL 32174");
        animal = new C_Animal("Rebel", "Gato", "Siames", 'H', parser.parse("2000-01-01"), 4, "", familiar);
        System.out.println("a guardar");
        Guardar.guardarAnimal(animal);
        animal = new C_Animal("Cash", "Perro", "Akita", 'M', parser.parse("2000-01-01"), 10, "", familiar);
        Guardar.guardarAnimal(animal);
        familiar = new C_Familiar("11111111H", "Ernest Gray", "766438410", "earnestg@gmail.com", "211 Blackburn Ave.Euless, TX 76039");
        animal = new C_Animal("Blizzard", "Perro", "Beagle", 'H', parser.parse("2000-01-01"), 8, "", familiar);
        Guardar.guardarAnimal(animal);
        familiar = new C_Familiar("22222222J", "Anna Cox", "649224987", "annac@gmail.com", "503 N. Lake Forest St.Council Bluffs, IA 51501");
        animal = new C_Animal("Jester", "Gato", "Bengala", 'M', parser.parse("2000-01-01"), 3, "", familiar);
        Guardar.guardarAnimal(animal);
        animal = new C_Animal("Nibbles", "Gato", "Siames", 'H', parser.parse("2000-01-01"), 5, "", familiar);
        Guardar.guardarAnimal(animal);
        familiar = new C_Familiar("33333333P", "Jimmy Mitchell", "698333709", "jimmym@gmail.com", "11 Wrangler Street West Palm Beach, FL 33404");
        animal = new C_Animal("Plague", "Pajaro", "Periquito", 'M', parser.parse("2000-01-01"), 0.4f, "", familiar);
        Guardar.guardarAnimal(animal);
        familiar = new C_Familiar("44444444A", "Sandra Wood", "823110551", "sandraw@gmail.com", "88 Manchester Dr.Acworth, GA 30101");
        animal = new C_Animal("Menace", "Roedor", "Cobaya", 'H', parser.parse("2000-01-01"), 0.7f, "", familiar);
        Guardar.guardarAnimal(animal);
        familiar = new C_Familiar("55555555K", "Keith Kelly", "847906919", "keithk@gmail.com", "302 Fremont Road La Porte, IN 46350");
        animal = new C_Animal("Clooney", "Gato", "Persa", 'M', parser.parse("2000-01-01"), 3.5f, "", familiar);
        Guardar.guardarAnimal(animal);
        familiar = new C_Familiar("66666666Q", "Elizabeth Simmons", "654934356", "elizabeths@gmail.com", "170 Jockey Hollow Street Loganville, GA 30052");
        animal = new C_Animal("Gordon", "Perro", "Carlino", 'H', parser.parse("2000-01-01"), 8, "", familiar);
        Guardar.guardarAnimal(animal);
        animal = new C_Animal("Dewey", "Pez", "Arcoiris", 'M', parser.parse("2000-01-01"), 0, "", familiar);
        Guardar.guardarAnimal(animal);
        familiar = new C_Familiar("77777777B", "Ralph Gonzalez", "758901466", "ralphg@gmail.com", "35 Temple St.York, PA 17402");
        animal = new C_Animal("Lucas", "Roedor", "Hamster", 'M', parser.parse("2000-01-01"), 0.2f, "", familiar);
        Guardar.guardarAnimal(animal);
        familiar = new C_Familiar("88888888Y", "Sharon Green", "669293927", "sharong@gmail.com", "478 Olive Street Encino, CA 91316");
        animal = new C_Animal("Loony", "Gato", "Persa", 'H', parser.parse("2000-01-01"), 4, "", familiar);
        Guardar.guardarAnimal(animal);
        familiar = new C_Familiar("99999999R", "Annie Campbell", "699193566", "anniec@gmail.com", "36 Arch Court Elkhart, IN 46514");
        animal = new C_Animal("Scamp", "Gato", "Persa", 'M', parser.parse("2000-01-01"), 6, "", familiar);
        Guardar.guardarAnimal(animal);
        animal = new C_Animal("Plush", "Perro", "Carlino", 'H', parser.parse("2000-01-01"), 4, "", familiar);
        Guardar.guardarAnimal(animal);
        animal = new C_Animal("Paco", "Perro", "Akita", 'H', parser.parse("2000-01-01"), 7, "", familiar);
        Guardar.guardarAnimal(animal);
        return true;
    }

    private static boolean cargarMedicamentosHib(Session sesion) {
        C_Medicamento medicamento;
        
        sesion.beginTransaction();
        medicamento = new C_Medicamento("Parvo", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Moquillo", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Parainfluenza", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Rabia", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Tri_Vírica", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Panleucopenia", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Rinotraqueitis", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Calcivirosis", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Leucemia felina", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Clamidias", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Viruela", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Profilaxis", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Bronipra", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Coripravac", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Intra-peritoneal", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Anemia", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Viremia", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Septicemia", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Mixomatosis", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Hemorragia vírica", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Nobivac", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Rabia", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Fiebre aftosa", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Rabia", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Edema maligno", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Virus-T", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Pasyeurela", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Salmonela", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Actinobacillus", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Écoli", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Influenza", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Tétanos", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Rinoneumonitis", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Papera equina", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Oftalmolosa cusí", "medicamento", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Azydrop", "medicamento", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Oftalmowell", "medicamento", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Broadline", "medicamento", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        medicamento = new C_Medicamento("Seresto", "medicamento", 0, "activina", "5", "10", "peligroso","producto1");
        sesion.save(medicamento);
        sesion.getTransaction().commit();
        return true;
       
    }
    
    private static boolean cargarMedicamentosNeo() {
        C_Medicamento medicamento;
        
        medicamento = new C_Medicamento("Parvo", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Moquillo", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Parainfluenza", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Rabia", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Tri_Vírica", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Panleucopenia", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Rinotraqueitis", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Calcivirosis", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Leucemia felina", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Clamidias", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Viruela", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Profilaxis", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Bronipra", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Coripravac", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Intra-peritoneal", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Anemia", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Viremia", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Septicemia", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Mixomatosis", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Hemorragia vírica", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Nobivac", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Rabia", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Fiebre aftosa", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Rabia", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Edema maligno", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Virus-T", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Pasyeurela", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Salmonela", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Actinobacillus", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Écoli", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Influenza", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Tétanos", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Rinoneumonitis", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Papera equina", "vacuna", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Oftalmolosa cusí", "medicamento", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Azydrop", "medicamento", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Oftalmowell", "medicamento", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Broadline", "medicamento", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        medicamento = new C_Medicamento("Seresto", "medicamento", 0, "activina", "5", "10", "peligroso","producto1");
        Guardar.guardarMedicamento(medicamento);
        return true;
       
    }
    
    private static boolean cargarVeterinariosHib(Session sesion){
        
        C_Veterinario veterinario;

        sesion.beginTransaction();
        veterinario = new C_Veterinario("12121212M","Ashley Man","687141252","ashleym@gmail.com","900");
        sesion.save(veterinario);
        veterinario = new C_Veterinario("23232323T","Kirstin Rupp","687141252","kirstinr@gmail.com","742");
        sesion.save(veterinario);
        veterinario = new C_Veterinario("34343434H","Nobuko Wyatt","687141252","nobukow@gmail.com","345");
        sesion.save(veterinario);
        veterinario = new C_Veterinario("45454545J","Willian Giordano","687141252","williang@gmail.com","867");
        sesion.save(veterinario);
        veterinario = new C_Veterinario("56565656P","Ann Hall","687141252","annh@gmail.com","988");
        sesion.save(veterinario);
        sesion.getTransaction().commit();
        
        return true;
    }
    
    private static boolean cargarVeterinariosNeo(){
        
        C_Veterinario veterinario;

        veterinario = new C_Veterinario("12121212M","Ashley Man","687141252","ashleym@gmail.com","900");
        Guardar.guardarVet(veterinario);
        veterinario = new C_Veterinario("23232323T","Kirstin Rupp","687141252","kirstinr@gmail.com","742");
        Guardar.guardarVet(veterinario);
        veterinario = new C_Veterinario("34343434H","Nobuko Wyatt","687141252","nobukow@gmail.com","345");
        Guardar.guardarVet(veterinario);
        veterinario = new C_Veterinario("45454545J","Willian Giordano","687141252","williang@gmail.com","867");
        Guardar.guardarVet(veterinario);
        veterinario = new C_Veterinario("56565656P","Ann Hall","687141252","annh@gmail.com","988");
        Guardar.guardarVet(veterinario);

        return true;
    }
    
}
