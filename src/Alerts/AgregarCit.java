/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alerts;

import Alerts.AWTUtilities;
import static java.awt.SystemColor.control;
import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;


public class AgregarCit extends javax.swing.JDialog {

    Timer timer = null;
    TimerTask task;
    int i = 32;

    /**
     * Creates new form AlertSuccess
     */
    public AgregarCit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        AWTUtilities.setOpaque(this, false);
        Ubicar(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        msj2 = new javax.swing.JLabel();
        log2 = new JButtonEspecial.JButtonEspecial();
        msj3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(246, 247, 248));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 0), 5));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/warn.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 70));

        msj2.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        msj2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj2.setText("¡Fallo al procesar la petición!");
        jPanel2.add(msj2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 230, 80));

        log2.setBackground(new java.awt.Color(204, 204, 204));
        log2.setForeground(new java.awt.Color(128, 128, 131));
        log2.setText("Aceptar");
        log2.setColorBorde(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        log2.setColorHover(new java.awt.Color(204, 204, 204));
        log2.setColorNormal(new java.awt.Color(204, 204, 204));
        log2.setColorPressed(new java.awt.Color(153, 153, 153));
        log2.setColorTextHover(new java.awt.Color(128, 128, 131));
        log2.setColorTextNormal(new java.awt.Color(128, 128, 131));
        log2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                log2ActionPerformed(evt);
            }
        });
        jPanel2.add(log2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 290, 30));

        msj3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        msj3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(msj3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 55, 230, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        task = new TimerTask() {
            @Override
            public void run() {
                if (i == 352) {
                    timer.cancel();
                } else {
                    Ubicar(i);
                    i += 32;
                    Trasparencia((float) i / 352);
                }
            }
        };
        timer = new java.util.Timer();
        timer.schedule(task, 0, 2);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        setVisible(false);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelarActionPerformed
        task = new TimerTask() {
            @Override
            public void run() {
                if (i == 0) {
                    Cerrar();
                } else {
                    Ubicar(i);
                    i -= 32;
                    Trasparencia((float) i / 352);
                }
            }
        };
        timer = new Timer();
        timer.schedule(task, 0, 2);
    }//GEN-LAST:event_CancelarActionPerformed

    private void AceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AceptarActionPerformed
        new Control.Control().cerrarApp();
        System.exit(0);
    }//GEN-LAST:event_AceptarActionPerformed

    private void AceptarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_AceptarKeyTyped
        if ((evt.getKeyChar() == KeyEvent.VK_ENTER)) {
            task = new TimerTask() {
                @Override
                public void run() {
                    if (i == 0) {
                        Cerrar();
                    } else {
                        Ubicar(i);
                        i -= 32;
                        Trasparencia((float) i / 352);
                    }
                }
            };
            timer = new Timer();
            timer.schedule(task, 0, 2);
        }
    }//GEN-LAST:event_AceptarKeyTyped

    private void log2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_log2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_log2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AgregarCit dialog = new AgregarCit(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private JButtonEspecial.JButtonEspecial log2;
    public static javax.swing.JLabel msj2;
    public static javax.swing.JLabel msj3;
    // End of variables declaration//GEN-END:variables

    private void Cerrar() {
        this.dispose();
        timer = null;
        task = null;
    }

    private void Trasparencia(float trasp) {
        AWTUtilities.setOpacity(this, trasp);
    }

    private void Ubicar(int y) {
        this.setLocation(550, y - 0);
    }
}
