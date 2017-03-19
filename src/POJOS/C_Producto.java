package POJOS;
import java.io.Serializable;


// @author Miguel

public class C_Producto implements Serializable{
    
    private int id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private String precio;
    private int img;
    
    public C_Producto () {}
    
    public C_Producto (String nombre, String tipo, String descripcion, String precio, int img) {
        
        this.descripcion=descripcion;
        this.nombre=nombre;
        this.tipo=tipo;
        this.precio=precio;
        this.img=img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

}
