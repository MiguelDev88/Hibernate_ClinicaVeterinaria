package funciones;
import hibernate_clinicaveterinaria.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;


public class Launcher extends Thread {
    
    Timer timer;
    JFrame frameClientes;
    JProgressBar pbLoading;
    MainWindow m;
    
    public Launcher(MainWindow m, JFrame frameClientes, JProgressBar pbLoading){
    
        this.frameClientes=frameClientes;
        this.pbLoading=pbLoading;
        this.m=m;
        start();
        
    }
    
    public void run()
    {
        
        timer = new Timer(50, new ActionListener() {
            int counter = 10;
            public void actionPerformed(ActionEvent ae) {
                counter++;
                pbLoading.setValue(counter);
                if (pbLoading.getValue()==100) {
                    timer.stop();
                    m.setVisible(false);
                    frameClientes.setSize(950, 750);
                    frameClientes.setLocationRelativeTo(null);
                    frameClientes.setVisible(true);
                } 
            }
        });
        timer.start();
        
    }

}
