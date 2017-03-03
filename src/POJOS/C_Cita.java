/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package POJOS;

import java.sql.Time;
import java.util.Date;


// @author Migu

public class C_Cita {
    
    private int id;
    private Date fecha;
    private Time hora;
    private C_Persona familiar;
    
    public C_Cita () {}
    
    public C_Cita (Date fecha, Time hora, C_Persona familiar){
        
        this.fecha=fecha;
        this.hora=hora;
        this.familiar=familiar;
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
    
    

}
