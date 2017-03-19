package POJOS;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


// @author Miguel

public class C_Factura {
    
    private int id;
    private float importe;
    private C_Familiar cliente;
    private Set productos;
    
    public C_Factura () {}
    
    public C_Factura (float importe){
        
        this.importe=importe;
        this.productos=new HashSet();
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getImporte() {
        return importe;
    }

    public void setImporte(float importe) {
        this.importe = importe;
    }

    public C_Familiar getCliente() {
        return cliente;
    }

    public void setCliente(C_Familiar cliente) {
        this.cliente = cliente;
    }

    public Set getProductos() {
        return productos;
    }

    public void setProductos(Set productos) {
        this.productos = productos;
    }
    
    
    
}
