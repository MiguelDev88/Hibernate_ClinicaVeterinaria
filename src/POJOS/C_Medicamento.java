package POJOS;

import java.io.Serializable;


// @author Miguel

public class C_Medicamento implements Serializable {
    
    private int id;
    private String nombre;
    private String tipo;
    private String principioActivo;
    private String dosis;
    private String precio;
    
    public C_Medicamento () {}
    
    public C_Medicamento (String nombre, String tipo, String principioActivo, String dosis, String precio) {
        
        this.nombre=nombre;
        this.tipo=tipo;
        this.principioActivo=principioActivo;
        this.dosis=dosis;
        this.precio=precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrincipioActivo() {
        return principioActivo;
    }

    public void setPrincipioActivo(String principioActivo) {
        this.principioActivo = principioActivo;
    }

    public String getDosis() {
        return dosis;
    }

    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
    
}
