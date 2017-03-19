package POJOS;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


// @author Miguel

public class C_Diagnostico implements Serializable {
    
    private int id;
    private String tratamiento;
    private Set  medicamentos;
    private C_Veterinario veterinario;
    private C_Animal animal;
    private String descripcion;
    
    public C_Diagnostico () {}
    
    public C_Diagnostico (String tratamiento, String descripcion, C_Veterinario vet, C_Animal animal ){
        
        this.tratamiento=tratamiento;
        this.veterinario=vet;
        this.descripcion=descripcion;
        this.animal=animal;
        this.medicamentos=new HashSet();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Set getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(Set medicamentos) {
        this.medicamentos = medicamentos;
    }

    public C_Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(C_Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public C_Animal getAnimal() {
        return animal;
    }

    public void setAnimal(C_Animal animal) {
        this.animal = animal;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
