package A_tabla;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class EstiloRenderCheckBox implements TableCellRenderer{
  

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {


        DefaultTableModel model = (DefaultTableModel) table.getModel();

        JCheckBox check=new JCheckBox();

        if(model.getValueAt(row,column).getClass().equals(Boolean.class)){
          
            check.setSelected(Boolean.parseBoolean(model.getValueAt(row,column).toString()));
            return check;

        }

   return check;
  }
}