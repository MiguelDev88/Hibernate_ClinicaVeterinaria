package POJOS;


// @author Miguel

public class C_Familiar extends C_Persona {
    
    private String direccion;
    
    public C_Familiar () {}
    
    public C_Familiar (String dni, String nombre, String telefono, String email, String direccion){
        
        super(dni, nombre, telefono, email);
        this.direccion=direccion;
        
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
}
