/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_tabla;

import static Ventanas.Modulo_Cotizaciones.pnlCotizaciones.tabla;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author jona
 */
public class EstiloTablaRendererCitas extends DefaultTableCellRenderer {

    private Component componenete;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componenete = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.       
        this.setHorizontalAlignment(0);
        this.setBorder(null);
        this.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 1, 1, 1, new java.awt.Color(198, 202, 193)));
        
        if(tabla.getValueAt(row, 4).toString().equals("Cancelada"))
        {
            componenete.setBackground(new Color(223,76,100));
            componenete.setForeground(new Color(255, 255, 255));
        } 
        else 
        {
            if(tabla.getValueAt(row, 4).toString().equals("Pendiente"))
            {
                componenete.setBackground(new Color(232,113,47));
                componenete.setForeground(new Color(255, 255, 255));
            } 
            else
            {
                if(tabla.getValueAt(row, 4).toString().equals("Finalizada"))
                {
                    componenete.setBackground(new Color(124, 198, 35));
                    componenete.setForeground(new Color(255, 255, 255));
                } 
            }
        }
        
        if (isSelected) {
            
            if(tabla.getValueAt(row, 4).toString().equals("Cancelada"))
            {
                componenete.setBackground(new Color(223,76,100));
                componenete.setForeground(new Color(255, 255, 255));
                componenete.setFont(new Font("Tahoma", Font.BOLD, 14));
            } 
            else 
            {
                if(tabla.getValueAt(row, 4).toString().equals("Pendiente"))
                {
                    componenete.setBackground(new Color(232,113,47));
                    componenete.setForeground(new Color(255, 255, 255));
                    componenete.setFont(new Font("Tahoma", Font.BOLD, 14));
                } 
                else
                {
                    if(tabla.getValueAt(row, 4).toString().equals("Finalizada"))
                    {
                        componenete.setBackground(new Color(124, 198, 35));
                        componenete.setForeground(new Color(255, 255, 255));
                        componenete.setFont(new Font("Tahoma", Font.BOLD, 14));
                    } 
                }
            }
        }

        return componenete;

    }
    
}
