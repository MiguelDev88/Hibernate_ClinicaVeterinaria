/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package funciones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


// @author Miguel

public class CrearTablas {
    
    public static void crearTablas(){
        
        try{
            Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost:3307/?user=root&password=usbw");
            Statement sentencia=conexion.createStatement();
            
            sentencia.execute("CREATE DATABASE IF NOT EXISTS CLINICA_VETERINARIA");
            sentencia.execute("USE CLINICA_VETERINARIA");
            
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS personas ( "
                    + "id INT(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "dni CHAR(9) NOT NULL, "
                    + "nombre VARCHAR(30) NOT NULL, "
                    + "telefono VARCHAR(30) NOT NULL, "
                    + "email VARCHAR(30) NULL, "
                    + "PRIMARY KEY (id))"
                    + "ENGINE INNODB;");
            
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS familiares ( "
                    + "id INT(5) UNSIGNED ZEROFILL NOT NULL, "
                    + "direccion VARCHAR(30) NOT NULL, "
                    + "CONSTRAINT fk1_familiar "
                    + " FOREIGN KEY(id) REFERENCES personas(id) "
                    + "  ON DELETE CASCADE "
                    + "  ON UPDATE CASCADE, "
                    + "PRIMARY KEY (id))"
                    + "ENGINE INNODB;");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS veterinarios ( "
                    + "id INT(5) UNSIGNED ZEROFILL NOT NULL, "
                    + "numLicencia VARCHAR(20) NOT NULL, "
                    + "CONSTRAINT fk7_veterinario "
                    + " FOREIGN KEY(id) REFERENCES personas(id) "
                    + "  ON DELETE CASCADE "
                    + "  ON UPDATE CASCADE, "
                    + "PRIMARY KEY (id))"
                    + "ENGINE INNODB;");
            
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS animales ( "
                    + "id INT(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "id_chip CHAR(9) NULL, "
                    + "nombre VARCHAR(30) NOT NULL, "
                    + "tipo VARCHAR(30) NOT NULL, "
                    + "raza VARCHAR(30) NOT NULL, "
                    + "sexo CHAR NOT NULL, "
                    + "fecha_nac DATE NULL, "
                    + "peso VARCHAR(30) NOT NULL, "
                    + "comentario TEXT NULL, "
                    + "familiar INT(5) UNSIGNED ZEROFILL NOT NULL, "
                    + "PRIMARY KEY (id), "
                    + "CONSTRAINT fk2_familiar "
                    + " FOREIGN KEY(familiar) REFERENCES familiares(id) "
                    + "  ON DELETE CASCADE "
                    + "  ON UPDATE CASCADE)"
                    + "ENGINE INNODB;");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS productos ( "
                    + "id INT(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "nombre VARCHAR(30) NOT NULL, "
                    + "tipo VARCHAR(30) NOT NULL, "
                    + "descripcion TEXT NOT NULL, "
                    + "precio FLOAT NOT NULL, "
                    + "PRIMARY KEY (id))"
                    + "ENGINE INNODB;");
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS medicamentos ( "
                    + "id INT(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "clasificacion VARCHAR(30) NOT NULL, "
                    + "principioActivo VARCHAR(30) NULL, "
                    + "dosis VARCHAR(30) NULL, "
                    + "CONSTRAINT fk8_medicamento "
                    + " FOREIGN KEY(id) REFERENCES productos(id) "
                    + "  ON DELETE CASCADE "
                    + "  ON UPDATE CASCADE, "
                    + "PRIMARY KEY (id))"
                    + "ENGINE INNODB;");
            
            
            sentencia.execute ("CREATE TABLE IF NOT EXISTS vacunas ( "
                    + "id INT(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "id_medicamento INT(5) UNSIGNED ZEROFILL NOT NULL, "
                    + "id_animal INT(5) UNSIGNED ZEROFILL NOT NULL, "
                    + "PRIMARY KEY (id), "
                    + "CONSTRAINT fk3_animal "
                    + " FOREIGN KEY(id_animal) REFERENCES animales(id) "
                    + "  ON DELETE CASCADE "
                    + "  ON UPDATE CASCADE, "
                    + "CONSTRAINT fk4_medicamento "
                    + " FOREIGN KEY(id_medicamento) REFERENCES medicamentos(id) "
                    + "  ON DELETE CASCADE "
                    + "  ON UPDATE CASCADE)"
                    + "ENGINE INNODB;");
            
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS citas ( "
                    + "familiar INT(5) UNSIGNED ZEROFILL NOT NULL, "
                    + "fecha DATETIME NOT NULL, "
                    + "asunto TEXT NULL, "
                    + "veterinario INT(5) UNSIGNED ZEROFILL NULL, "
                    + "PRIMARY KEY(familiar,fecha), "
                    + "CONSTRAINT fk5_familiar "
                    + " FOREIGN KEY(familiar) REFERENCES familiares(id) "
                    + "  ON DELETE CASCADE "
                    + "  ON UPDATE CASCADE,"
                    + "CONSTRAINT fk6_veterinario "
                    + " FOREIGN KEY(veterinario) REFERENCES veterinarios(id) "
                    + "  ON DELETE CASCADE "
                    + "  ON UPDATE CASCADE)"
                    + "ENGINE INNODB;");

            
            System.out.println("\n - BASE DE DATOS LISTA - \n");
                    

            conexion.close();
            
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
            System.out.println("\n - ERROR DE CONEXION CON LA BASE DE DATOS - \n");
            System.exit(0);
        }
    }

}
