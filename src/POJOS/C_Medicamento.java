package POJOS;


// @author Miguel

public class C_Medicamento extends C_Producto {

    private String clasificacion;
    private String principioActivo;
    private String dosis;
    
    public C_Medicamento () {}
    
    public C_Medicamento (String nombre, String tipo, String principioActivo, String dosis, String precio, String clasificacion) {
        
        super(nombre,tipo,precio);
        this.clasificacion=clasificacion;
        this.principioActivo=principioActivo;
        this.dosis=dosis;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
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
    
}
