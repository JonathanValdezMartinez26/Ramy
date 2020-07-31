package Clases;
import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellEditor;

public class MyTableCellEditorCotiRentaPeriodo extends AbstractCellEditor implements TableCellEditor{

    private database db;
    private String OldValue=""; //Valor antiguo de la celda
    private String ConvertValue="S"; //Valor antiguo de la celda
    
    private String NewValue=""; //valor nuevo de la celda
    private String NameColum="";//nombre de la columna
    private String ID="";// Llave del registro
    private String origen="";//nombre de la columna
    private String destino="";// Llave del registro
    private String transporte="";// Llave del registro
    private String precio="";// Llave del registro
    
    
    private JComponent component = new JTextField();

    public MyTableCellEditorCotiRentaPeriodo(database db, String NameColumn)
    {
            this.db = db;
            this.NameColum = NameColumn;
    }

    public Object getCellEditorValue() {
        return ((JTextField)component).getText();
    }

    public Component getTableCellEditorComponent(JTable tableR, Object value, boolean isSelected, int row, int column) {
        try
        {
            OldValue = value.toString();//Toma valor de celda antes de cualquier modificación
            ID = tableR.getValueAt(row,0).toString();//obtiene el ID unico del registro
            //origen = table.getValueAt(row,1).toString();//obtiene el ID unico del registro
            //destino = table.getValueAt(row,2).toString();//obtiene el ID unico del registro
            //transporte = table.getValueAt(row,3).toString();//obtiene el ID unico del registro
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
        
        NewValue = (String)getCellEditorValue();//Captura nuevo valor de la celda
        if (NewValue.equals("Semanal") || NewValue.equals("Quincenal") || NewValue.equals("Mensual") || NewValue.equals("Anual")
                || NewValue.equals("semanal") || NewValue.equals("quincenal") || NewValue.equals("mensual") || NewValue.equals("anual"))
    {    
        if(NewValue.equals("Semanal") || NewValue.equals("semanal")){
            ConvertValue="1";     

            if (!NewValue.equals(OldValue)) {   //Realiza la actualizacion
                if (!db.updateCotizacionRentaPeriodo(ConvertValue, ID)) {   //Si existe algun error al actualizar, escribe viejo valor en la celda
                    Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                    AC.msj1.setText("¡Error al modificar!");
                    AC.msj2.setText("Ingrese Periodos validos");
                    AC.msj3.setText("Semanal-Quincenal-Mensual-Anual");
                    AC.setVisible(true);

                    ((JTextField) component).setText(OldValue);
                } ///////////////////////////Si no exixste ninguna excepcion se realiza el registro en la bitacora
                else {
//                    Alerts.AlertBasic.Success AC = new Alerts.AlertBasic.Success(null, true);
//                    AC.msj1.setText("¡Datos del Concepto!");
//                    AC.msj2.setText("Guardados correctamente");
//                    //AC.msj3.setText("Concepto de $" + OldValue + " a $" + NewValue);
//                    AC.setVisible(true);
                }
            }

            
        }else {
            if(NewValue.equals("Quincenal") || NewValue.equals("quincenal")){
                ConvertValue="2";

                if (!NewValue.equals(OldValue)) {   //Realiza la actualizacion
                    if (!db.updateCotizacionRentaPeriodo(ConvertValue, ID)) {   //Si existe algun error al actualizar, escribe viejo valor en la celda
                        //JOptionPane.showMessageDialog(null,"Error: No se puede actualizar");
                        Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Error al modificar!");
                        AC.msj2.setText("Ingrese Periodos validos");
                        AC.msj3.setText("Semanal-Quincenal-Mensual-Anual");
                        AC.setVisible(true);

                        ((JTextField) component).setText(OldValue);
                    } ///////////////////////////Si no exixste ninguna excepcion se realiza el registro en la bitacora
                    else {
//                        Alerts.AlertBasic.Success AC = new Alerts.AlertBasic.Success(null, true);
//                        AC.msj1.setText("¡Datos del Concepto!");
//                        AC.msj2.setText("Guardados correctamente");
//                        //AC.msj3.setText("Concepto de $" + OldValue + " a $" + NewValue);
//                        AC.setVisible(true);
                }
            }
                            
                            
            }else{
                if(NewValue.equals("Mensual") || NewValue.equals("mensual")){
                    ConvertValue="3";
                        if (!NewValue.equals(OldValue)) {   //Realiza la actualizacion
                    if (!db.updateCotizacionRentaPeriodo(ConvertValue, ID)) {   //Si existe algun error al actualizar, escribe viejo valor en la celda
                        //JOptionPane.showMessageDialog(null,"Error: No se puede actualizar");
                        Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Error al modificar!");
                        AC.msj2.setText("Ingrese Periodos validos");
                        AC.msj3.setText("Semanal-Quincenal-Mensual-Anual");
                        AC.setVisible(true);

                        ((JTextField) component).setText(OldValue);
                    } ///////////////////////////Si no exixste ninguna excepcion se realiza el registro en la bitacora
                    else {
//                        Alerts.AlertBasic.Success AC = new Alerts.AlertBasic.Success(null, true);
//                        AC.msj1.setText("¡Datos del Concepto!");
//                        AC.msj2.setText("Guardados correctamente");
//                        //AC.msj3.setText("Concepto de $" + OldValue + " a $" + NewValue);
//                        AC.setVisible(true);
                }
            }
                }else{
                    if(NewValue.equals("Anual") || NewValue.equals("anual")){
                        ConvertValue="4";
                        if (!NewValue.equals(OldValue)) {   //Realiza la actualizacion
                    if (!db.updateCotizacionRentaPeriodo(ConvertValue, ID)) {   //Si existe algun error al actualizar, escribe viejo valor en la celda
                        //JOptionPane.showMessageDialog(null,"Error: No se puede actualizar");
                        Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                        AC.msj1.setText("¡Error al modificar!");
                        AC.msj2.setText("Ingrese Periodos validos");
                        AC.msj3.setText("Semanal-Quincenal-Mensual-Anual");
                        AC.setVisible(true);

                        ((JTextField) component).setText(OldValue);
                    } ///////////////////////////Si no exixste ninguna excepcion se realiza el registro en la bitacora
                    else {
//                        Alerts.AlertBasic.Success AC = new Alerts.AlertBasic.Success(null, true);
//                        AC.msj1.setText("¡Datos del Concepto!");
//                        AC.msj2.setText("Guardados correctamente");
//                        //AC.msj3.setText("Concepto de $" + OldValue + " a $" + NewValue);
//                        AC.setVisible(true);
                }
            }
                    }
                }
            }
                
        }
    }else{  
        ((JTextField) component).setText(OldValue);
                 Alerts.AlertBasic.Error AC = new Alerts.AlertBasic.Error(null, true);
                    AC.msj1.setText("¡Error al modificar!");
            AC.msj2.setText("Ingrese Periodos validos");
            AC.msj3.setText("Semanal-Quincenal-Mensual-Anual");
                    AC.setVisible(true);

    }
        
        //Compara valores, si no son iguales, debe actualizar registro

//        if( !NewValue.equals(ConvertValue))
//        {   //Realiza la actualizacion
//            if( !db.updateCotizacionRentaConcepto(NewValue, ID ) )
//            {   //Si existe algun error al actualizar, escribe viejo valor en la celda
//                //JOptionPane.showMessageDialog(null,"Error: No se puede actualizar");
//                            Alerts.AlertBasic.Error AC = new  Alerts.AlertBasic.Error(null, true);
//                            AC.msj1.setText("¡Error al modificar Concepto!");
//                            AC.msj2.setText("Ingrese caracteres validos");
//                            AC.setVisible(true);
//                
//                ((JTextField)component).setText(ConvertValue);
//            }
//            ///////////////////////////Si no exixste ninguna excepcion se realiza el registro en la bitacora
//            else{
////                JOptionPane.showMessageDialog(null,NameColum+"=="+NewValue+"   "+ID );
//            
//                Alerts.AlertBasic.Success AC = new  Alerts.AlertBasic.Success(null, true);
//                AC.msj1.setText("¡Datos del Concepto!");
//                AC.msj2.setText("Guardados correctamente");
//                AC.msj3.setText("Concepto de $"+ConvertValue+" a $"+NewValue);
//                AC.setVisible(true);
//            }
//        }

        return super.stopCellEditing();
    }
}
