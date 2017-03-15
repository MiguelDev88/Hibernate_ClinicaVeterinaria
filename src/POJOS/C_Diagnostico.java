package POJOS;
import java.io.Serializable;
import java.util.List;


// @author Miguel

public class C_Diagnostico implements Serializable {
    
    private String tratamiento;
    private List<C_Medicamento> medicamento;
    private C_Veterinario veterinario;
    private String descripcion;

}
