package funciones;
import java.util.TimerTask;
import javax.swing.JProgressBar;


// @author Migu

public class TimerTick extends TimerTask {
    
    private JProgressBar pbLoading;
    
    public TimerTick (JProgressBar pbLoading) {
        this.pbLoading=pbLoading;
    }
    @Override
    public void run() {
            System.out.println("hola");
        }

}
