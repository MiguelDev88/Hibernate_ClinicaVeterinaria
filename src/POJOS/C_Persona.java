package POJOS;

import java.io.Serializable;


// @author Miguel

public abstract class C_Persona implements Serializable {
    
    private int id;
    private String dni;
    private String nombre;
    private String telefono;
    private String email;
    
    
    public C_Persona (){}
    
    public C_Persona (String dni, String nombre, String telefono, String email) {
        
        this.dni=dni;
        this.nombre=nombre;
        this.telefono=telefono;
        this.email=email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
