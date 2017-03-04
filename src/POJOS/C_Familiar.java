package POJOS;
import java.util.List;


// @author Miguel

public class C_Familiar extends C_Persona {
    
    private List mascotas;
    private String direccion;
    
    public C_Familiar () {}
    
    public C_Familiar (String dni, String nombre, String telefono, String email, String direccion){
        
        super(dni, nombre, telefono, email);
        this.direccion=direccion;
        
    }

    public List getMascotas() {
        return mascotas;
    }

    public void setMascotas(List mascotas) {
        this.mascotas = mascotas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
