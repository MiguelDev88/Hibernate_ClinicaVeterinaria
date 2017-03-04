/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package POJOS;


// @author Miguel

public class C_Factura {
    
    private int id;
    private float importe;
    private C_Familiar cliente;
    
    public C_Factura () {}
    
    public C_Factura (float importe){
        
        this.importe=importe;
        
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
    
}
