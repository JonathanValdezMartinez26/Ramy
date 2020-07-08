/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A_tabla;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author jona
 */
public class EstiloTablaRenderer1 extends DefaultTableCellRenderer {

    private Component componenete;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        componenete = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.       
        this.setHorizontalAlignment(0);
        this.setBorder(null);
        this.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 0, 0, 0, new java.awt.Color(198, 202, 193)));
        
        if (row % 2 == 0) {
            componenete.setForeground(new Color(128, 128, 131));
            componenete.setBackground(new Color(251, 251, 251));
        } else {
            componenete.setForeground(new Color(128, 128, 131));
            componenete.setBackground(new Color(255, 255, 255));
        }
        if (isSelected) {
            componenete.setForeground(new Color(128, 128, 131));
            componenete.setBackground(new Color(239, 238, 244));
            componenete.setFont(new Font("Tahoma", Font.PLAIN, 14));
        }

        return componenete;

    }

}
