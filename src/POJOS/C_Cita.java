package POJOS;
import java.io.Serializable;
import java.util.Date;


// @author Miguel

public class C_Cita implements Serializable {
    
    private int id;
    private Date fecha;
    private C_Animal animal;
    private String asunto;
    private C_Veterinario veterinario;
    
    
    public C_Cita () {}
    
    public C_Cita (Date fecha, C_Animal animal,C_Veterinario veterinario, String asunto){
        
        this.fecha=fecha;
        this.animal=animal;
        this.veterinario=veterinario;
        this.asunto=asunto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public C_Animal getAnimal() {
        return animal;
    }

    public void setAnimal(C_Animal animal) {
        this.animal=animal;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    @Override
    public String toString () {
        
        return animal.getNombre();
    }

    public C_Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(C_Veterinario veterinario) {
        this.veterinario = veterinario;
    }
    
}
