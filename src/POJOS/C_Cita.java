package POJOS;
import java.sql.Time;
import java.util.Date;


// @author Miguel

public class C_Cita {
    
    private int id;
    private Date fecha;
    private Time hora;
    private C_Persona familiar;
    private String asunto;
    
    public C_Cita () {}
    
    public C_Cita (Date fecha, Time hora, C_Persona familiar, String asunto){
        
        this.fecha=fecha;
        this.hora=hora;
        this.familiar=familiar;
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

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public C_Persona getFamiliar() {
        return familiar;
    }

    public void setFamiliar(C_Persona familiar) {
        this.familiar = familiar;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    
}
