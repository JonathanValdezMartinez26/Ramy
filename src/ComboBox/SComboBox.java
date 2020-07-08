package ComboBox;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;

public class SComboBox extends JComboBox{
 
    public SComboBox()
    {
        Dimension dimension = new Dimension(200,32);
        setPreferredSize(dimension);
        setSize(dimension);      
        setForeground(Color.WHITE);        
        setBorder(BorderFactory.createLineBorder(new Color(102,102,102), 2));
        setUI(CustomUI.createUI(this));                
        setVisible(true);
    }

}