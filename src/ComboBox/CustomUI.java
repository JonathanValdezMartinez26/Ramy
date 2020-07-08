package ComboBox;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class CustomUI extends BasicComboBoxUI{
    
    private Color blue = new Color(0,144,183);
    
    public static ComboBoxUI createUI(JComponent c) {
        return new CustomUI();
    }
    
    @Override 
    protected JButton createArrowButton() {        
        BasicArrowButton basicArrowButton = new BasicArrowButton(BasicArrowButton.SOUTH, //Direccion de la flecha
                Color.WHITE,new Color(0,144,183),new Color(0,144,183),Color.WHITE);         
        basicArrowButton.setBorder(BorderFactory.createLineBorder(blue,2));
        basicArrowButton.setContentAreaFilled(false);        
        return basicArrowButton;
    }        

    @Override
    public void paintCurrentValueBackground(Graphics g,
                               Rectangle bounds,
                               boolean hasFocus)
    {
        g.setColor( blue );            
        g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
    }
    
    @Override
    protected ListCellRenderer createRenderer()
    {
        return new DefaultListCellRenderer() {      
            
        @Override
        public Component getListCellRendererComponent(JList list,Object value,int index,
          boolean isSelected,boolean cellHasFocus) {
      
        super.getListCellRendererComponent(list,value,index,isSelected,cellHasFocus);
        list.setSelectionBackground(blue);
        if (isSelected)
        {
            setBackground(blue);
            setForeground(Color.WHITE);
        }
        else
        {
            setBackground( Color.WHITE );            
            setForeground( new Color(70,70,70));
        }
       
        return this;
      }
    };
    }
}
