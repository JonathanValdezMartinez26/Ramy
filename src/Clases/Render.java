package Clases;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class Render implements TableCellRenderer{
  

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {


        DefaultTableModel model = (DefaultTableModel) table.getModel();

        JCheckBox check=new JCheckBox();
        JLabel lbl= new JLabel();


        if(model.getValueAt(row,column).getClass().equals(Boolean.class)){
          
            check.setSelected(Boolean.parseBoolean(model.getValueAt(row,column).toString()));
            return check;

        }

        if (column==5){

            lbl.setText(" "+model.getValueAt(row,column).toString());
            return lbl;

        }

        
   return lbl;


  }
    

}