package MyTableCellEditor;
import Clases.database;
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class EditarTrailerAdicional extends AbstractCellEditor implements TableCellEditor{

    private database db;
    private String OldValue=""; //Valor antiguo de la celda
    private String NewValue=""; //valor nuevo de la celda
    private String NameColum="";//nombre de la columna
    private String ID="";// Llave del registro
    private String origen="";//nombre de la columna
    private String destino="";// Llave del registro
    private String transporte="";// Llave del registro
    private String precio="";// Llave del registro
    private String nombreServicio="";// Llave del registro
    
    
    
    private JComponent component = new JTextField();

    public EditarTrailerAdicional(database db, String NameColumn)
    {
            this.db = db;
            this.NameColum = NameColumn;
    }

    public Object getCellEditorValue() {
        return ((JTextField)component).getText();
    }

    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        try
        {
            OldValue = value.toString();//Toma valor de celda antes de cualquier modificación
            ID = table.getValueAt(row,0).toString();//obtiene el ID unico del registro
            nombreServicio = table.getValueAt(row,1).toString();//obtiene el ID unico del registro
            destino = table.getValueAt(row,2).toString();//obtiene el ID unico del registro
            transporte = table.getValueAt(row,3).toString();//obtiene el ID unico del registro
             //precio = table.getValueAt(row,4).toString();//obtiene el ID unico del registro
            
            ((JTextField)component).setText(value.toString());//coloca valor de la celda al JTextField
        }
        catch(Exception ex)
        {
            
        }
        return component;
    }

    @Override
    public boolean stopCellEditing() {
        String vacio="";
        NewValue = (String)getCellEditorValue();//Captura nuevo valor de la celda
//       if(!NewValue.equals(vacio)){ 
        //Compara valores, si no son iguales, debe actualizar registro
        if( !NewValue.equals(OldValue))
        {   //Realiza la actualizacion
            if( !db.updateTrailer(NewValue, ID ) )
            {   //Si existe algun error al actualizar, escribe viejo valor en la celda
                //JOptionPane.showMessageDialog(null,"Error: No se puede actualizar");
                            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
                            AC.msj1.setText("¡Error al modificar Nombre!");
                            AC.msj2.setText("Ingrese caracteres validos");
                            AC.setVisible(true);
                
                ((JTextField)component).setText(OldValue);
            }
//            Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
//            AC.msj1.setText("¡Nombre del Servicio!");
//            AC.msj2.setText("Asignado");
//            AC.msj3.setText("Porfavor asigne un Precio");
//            AC.setVisible(true);
            
        }
        
       //}
        return super.stopCellEditing();
    }
}
