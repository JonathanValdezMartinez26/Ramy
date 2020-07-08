/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_tabla;

import static Ventanas.Modulo_Cita.pnlCitasMedico.tabla;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author jona
 */
public class EstiloTablaRendererCitasMedico extends DefaultTableCellRenderer {

    private Component componenete;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componenete = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.       
        this.setHorizontalAlignment(0);
        this.setBorder(null);
        this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(198, 202, 193)));
        
        if(tabla.getValueAt(row, 6).toString().equals("Cancelada"))
        {
            componenete.setBackground(new Color(255,51,51));
            componenete.setForeground(new Color(255, 255, 255));
        } 
        else 
        {
            if(tabla.getValueAt(row, 6).toString().equals("Pendiente"))
            {
                componenete.setBackground(new Color(255,153,51));
                componenete.setForeground(new Color(255, 255, 255));
            } 
            else
            {
                if(tabla.getValueAt(row, 6).toString().equals("Atendida"))
                {
                    componenete.setBackground(new Color(27, 94, 32));
                    componenete.setForeground(new Color(255, 255, 255));
                } 
            }
        }
        
        if (column == 0) 
        {
            componenete.setBackground( new Color(251,251,251) );
            componenete.setForeground(Color.BLACK);
        }
        if (isSelected) 
        {
            if(tabla.getValueAt(row, 6).toString().equals("Cancelada"))
            {
                componenete.setBackground(new Color(255,51,51));
                componenete.setForeground(new Color(255, 255, 255));
                componenete.setFont(new Font("Tahoma", Font.PLAIN, 14));
                
                if (column == 0) 
                {
                    componenete.setBackground(new Color(251,251,251));
                    componenete.setForeground(Color.BLACK);
                    componenete.setFont(new Font("Tahoma", Font.PLAIN, 14));
                }
            }
            else
            {
                if(tabla.getValueAt(row, 6).toString().equals("Pendiente"))
                {
                    componenete.setBackground(new Color(255,153,51));
                    componenete.setForeground(new Color(255, 255, 255));
                    componenete.setFont(new Font("Tahoma", Font.PLAIN, 14));

                    if (column == 0) 
                    {
                        componenete.setBackground(new Color(251,251,251));
                        componenete.setForeground(Color.BLACK);
                        componenete.setFont(new Font("Tahoma", Font.PLAIN, 14));
                    }
                }
                else
                {
                   if(tabla.getValueAt(row, 6).toString().equals("Atendida"))
                    {
                        componenete.setBackground(new Color(27, 94, 32));
                        componenete.setForeground(new Color(255, 255, 255));
                        componenete.setFont(new Font("Tahoma", Font.PLAIN, 14));

                        if (column == 0) 
                        {
                            componenete.setBackground(new Color(251,251,251));
                            componenete.setForeground(Color.BLACK);
                            componenete.setFont(new Font("Tahoma", Font.PLAIN, 14));
                        }
                    } 
                }
            }
            
          
            
        }

        return componenete;

    }
    
}
