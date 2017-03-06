package POJOS;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


// @author Miguel

public class C_Diagnostico implements Serializable {
    
    private String tratamiento;
    private List<C_Medicamento> medicamentos;
    private C_Veterinario veterinario;
    private String comentario;
    
    public C_Diagnostico () {}
    
    public C_Diagnostico (String tratamiento,C_Veterinario veterinario,String comentario){
        this.tratamiento = tratamiento;
        this.medicamentos = new LinkedList<>();
        this.veterinario = veterinario;
        this.comentario = comentario;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public List<C_Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<C_Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public C_Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(C_Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
}
