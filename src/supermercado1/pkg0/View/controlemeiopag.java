/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermercado1.pkg0.View;

import supermercado1.pkg0.Controller.Message;
import supermercado1.pkg0.Controller.getImageBack;

/**
 *
 * @author gildo
 */
public class controlemeiopag extends javax.swing.JFrame {

    /**
     * Creates new form meiopagamento
     */
    public controlemeiopag() {
        initComponents();
        setIconImage(new getImageBack().getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        rSButton6 = new rojeru_san.RSButton();
        rSButton7 = new rojeru_san.RSButton();
        rSButton5 = new rojeru_san.RSButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        rSMTextFull1 = new rojeru_san.RSMTextFull();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        rSButton6.setBackground(new java.awt.Color(255, 255, 255));
        rSButton6.setBorder(null);
        rSButton6.setForeground(new java.awt.Color(0, 0, 0));
        rSButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/add_48px.png"))); // NOI18N
        rSButton6.setText("Adicionar ");
        rSButton6.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton6.setColorText(new java.awt.Color(0, 0, 0));
        rSButton6.setColorTextHover(new java.awt.Color(255, 255, 250));
        rSButton6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton6ActionPerformed(evt);
            }
        });

        rSButton7.setBackground(new java.awt.Color(255, 255, 255));
        rSButton7.setBorder(null);
        rSButton7.setForeground(new java.awt.Color(0, 0, 0));
        rSButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/edit_property_48px.png"))); // NOI18N
        rSButton7.setText("Editar");
        rSButton7.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton7.setColorText(new java.awt.Color(0, 0, 0));
        rSButton7.setColorTextHover(new java.awt.Color(255, 255, 250));
        rSButton7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton7ActionPerformed(evt);
            }
        });

        rSButton5.setBackground(new java.awt.Color(255, 255, 255));
        rSButton5.setBorder(null);
        rSButton5.setForeground(new java.awt.Color(0, 0, 0));
        rSButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/delete.png"))); // NOI18N
        rSButton5.setText("Apagar ");
        rSButton5.setColorHover(new java.awt.Color(204, 204, 204));
        rSButton5.setColorText(new java.awt.Color(0, 0, 0));
        rSButton5.setColorTextHover(new java.awt.Color(255, 255, 250));
        rSButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        rSButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(rSButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rSButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(85, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rSButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(rSButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(rSButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        table.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table.setRowHeight(40);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setMinWidth(100);
            table.getColumnModel().getColumn(1).setMinWidth(300);
        }

        rSMTextFull1.setBorder(new org.jdesktop.swingx.border.DropShadowBorder());
        rSMTextFull1.setForeground(new java.awt.Color(0, 0, 0));
        rSMTextFull1.setToolTipText("pesquisar produtos...");
        rSMTextFull1.setBordeColorFocus(new java.awt.Color(204, 204, 204));
        rSMTextFull1.setBordeColorNoFocus(new java.awt.Color(204, 204, 0));
        rSMTextFull1.setBotonColor(new java.awt.Color(255, 0, 0));
        rSMTextFull1.setFont(new java.awt.Font("Roboto Bold", 0, 18)); // NOI18N
        rSMTextFull1.setPlaceholder("pesquisar produto pelo código ou descrição...");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG/search_48px.png"))); // NOI18N
        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rSMTextFull1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rSMTextFull1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rSButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton6ActionPerformed
        // TODO add your handling code here:
        new novacategoria().setVisible(true);
    }//GEN-LAST:event_rSButton6ActionPerformed

    private void rSButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton7ActionPerformed
        if(table.isRowSelected(table.getSelectedRow()))
        {

        }else
        {
            new Message().messageAlerta("Selecione a linha que deseja editar");
        }
    }//GEN-LAST:event_rSButton7ActionPerformed

    private void rSButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton5ActionPerformed
        if(table.isRowSelected(table.getSelectedRow()))
        {

        }else
        {
            new Message().messageAlerta("Selecione a linha que deseja apagar");
        }
    }//GEN-LAST:event_rSButton5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(controlemeiopag.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(controlemeiopag.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(controlemeiopag.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(controlemeiopag.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new controlemeiopag().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private rojeru_san.RSButton rSButton5;
    private rojeru_san.RSButton rSButton6;
    private rojeru_san.RSButton rSButton7;
    private rojeru_san.RSMTextFull rSMTextFull1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
