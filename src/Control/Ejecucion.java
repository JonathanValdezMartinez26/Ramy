package Control;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UnsupportedLookAndFeelException;
 
public class Ejecucion {

    public static void main(String[] args) {
        String s = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

        try 
        {
            javax.swing.UIManager.setLookAndFeel(s);
        } 
        catch (Exception ex) 
        { 
 
        }
 
        if (new Control().comprobar()) {

            if (Ventanas.Modulo_Usuario.Opciones.verificarUsuarios() == 0) {
                new configInicio.SplashScreen().setVisible(true);
            } else {
                new splash.SplashScreen().setVisible(true);
            }
        } else {
            
        }
    }
}
