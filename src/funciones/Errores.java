package funciones;
import javax.swing.JOptionPane;


public class Errores extends Thread {
    
    String error;
    public Errores(String error){
    
        this.error=error;
        start();
        
    }
    @Override
    public void run()
    {
        JOptionPane.showMessageDialog(null, error);
    }

}
