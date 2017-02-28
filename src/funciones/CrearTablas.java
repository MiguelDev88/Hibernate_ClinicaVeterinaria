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
            
            sentencia.execute("CREATE TABLE IF NOT EXISTS animales ( "
                    + "id INT(5) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT, "
                    + "id_chip CHAR(9) NULL, "
                    + "nombre VARCHAR(30) NOT NULL, "
                    + "tipo VARCHAR(30) NOT NULL, "
                    + "raza VARCHAR(30) NOT NULL, "
                    + "sexo CHAR NOT NULL, "
                    + "fecha_nac DATE NULL, "
                    + "peso VARCHAR(30) NOT NULL, "
                    + "familiar INT(5) UNSIGNED ZEROFILL NOT NULL, "
                    + "PRIMARY KEY (id), "
                    + "CONSTRAINT fk_familiar "
                    + " FOREIGN KEY(familiar) REFERENCES familiares(id) "
                    + "  ON DELETE CASCADE "
                    + "  ON UPDATE CASCADE)"
                    + "ENGINE INNODB;");
            
            
            
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
                    + "id_chip CHAR(9) NULL, "
                    + "nombre VARCHAR(30) NOT NULL, "
                    + "tipo VARCHAR(30) NOT NULL, "
                    + "raza VARCHAR(30) NOT NULL, "
                    + "sexo CHAR NOT NULL, "
                    + "fecha_nac DATE NULL, "
                    + "peso VARCHAR(30) NOT NULL, "
                    + "familiar VARCHAR(30) NOT NULL, "
                    + "PRIMARY KEY (id))"
                    + "ENGINE INNODB;");
            
            System.out.println("\n - BASE DE DATOS LISTA - \n");
                    

            conexion.close();
            
            
        }catch(Exception e) {
            System.out.println("\n - ERROR DE CONEXION CON LA BASE DE DATOS - \n");
            System.exit(0);
        }
    }

}
