package POJOS;
import java.util.Date;
import java.util.List;


// @author Miguel

public class C_Animal {
    
    private String id;
    private String nombre;
    private String tipo;
    private String raza;
    private String id_chip;
    private char sexo;
    private Date fecha_nac;
    private float peso;
    private C_Familiar familiar;
    private List historial;
    private boolean[] vacunas;
    
    
    public C_Animal () {}
    
    public C_Animal (String nombre, String tipo, String raza, char sexo, Date fecha_nac, float peso, C_Familiar familiar, boolean[] vacunas) {
        
        this.nombre=nombre;
        this.tipo=tipo;
        this.raza=raza;
        this.sexo=sexo;
        this.fecha_nac=fecha_nac;
        this.peso=peso;
        this.familiar=familiar;
        this.vacunas=vacunas;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getId_chip() {
        return id_chip;
    }

    public void setId_chip(String id_chip) {
        this.id_chip = id_chip;
    }
    
    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public C_Familiar getFamiliar() {
        return familiar;
    }

    public void setFamiliar(C_Familiar familiar) {
        this.familiar = familiar;
    }

    public List getHistorial() {
        return historial;
    }

    public void setHistorial(List historial) {
        this.historial = historial;
    }

    public boolean[] getVacunas() {
        return vacunas;
    }

    public void setVacunas(boolean[] vacunas) {
        this.vacunas = vacunas;
    }
    
    

}
