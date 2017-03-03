/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package POJOS;


// @author Miguel

public class C_Veterinario extends C_Persona{
    
    private String NumLicencia;
    
    public C_Veterinario () {}
    
    public C_Veterinario (String dni, String nombre, String telefono, String email, String NumLicencia) {
        
        super(dni, nombre, telefono, email);
        this.NumLicencia=NumLicencia;
    }
    
    

}
