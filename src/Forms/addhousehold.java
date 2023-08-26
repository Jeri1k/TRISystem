/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Class.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class addhousehold extends javax.swing.JFrame {

   
    public addhousehold() {
        initComponents();
        this.requestFocus(true);
    }
 Connection conn = new DBConnection().connect();
    PreparedStatement ps = null;
     ResultSet rs = null;
    Statement s = null;
    int id ;
   void addhousehold(){
        try
            {
              String owner = (String) ownership.getSelectedItem();
                ps=conn.prepareStatement("INSERT INTO `tbl_household`(`family_id`, `family_headname`, `family_spousename`, `ownership`, `family_fulladd`, `date_reg`) VALUES  (?,?,?,?,?,sysdate());");
             ps.setInt(1, id);
             ps.setString(2, familyhead.getText().toUpperCase());
             ps.setString(3, spousename.getText().toUpperCase());
             ps.setString(4, owner);
             ps.setString(5, fulladd.getText().toUpperCase());
            
            
             ps.execute();
             JOptionPane.showMessageDialog(null,"Succesfully Registered");
           clear();
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }
   }
   void clear(){
       familyhead.setText("");
       spousename.setText("");
       fulladd.setText("");
       
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        fulladd = new JTextFieldPersonalizado.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        familyhead = new JTextFieldPersonalizado.JCTextField();
        jLabel26 = new javax.swing.JLabel();
        spousename = new JTextFieldPersonalizado.JCTextField();
        jLabel27 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        ownership = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(625, 520));
        setMinimumSize(new java.awt.Dimension(625, 520));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(625, 520));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(59, 89, 152));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-go-back-30.png"))); // NOI18N
        jLabel11.setText("Go back");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });
        jLabel11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel11KeyPressed(evt);
            }
        });
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 100, 29));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-exterior-30.png"))); // NOI18N
        jLabel2.setText("Add Household");
        jPanel9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 50));

        jSeparator12.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, 20, 30));

        jSeparator13.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, 20, 30));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel9.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 18, 0, 40));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/clear.png"))); // NOI18N
        jLabel12.setText("Clear");
        jLabel12.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 10, 80, 29));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-add-30.png"))); // NOI18N
        jLabel20.setText("Register");
        jLabel20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel20MouseClicked(evt);
            }
        });
        jLabel20.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabel20KeyPressed(evt);
            }
        });
        jPanel9.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 90, 30));

        jSeparator14.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator14.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 20, 30));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 50));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(new java.awt.Color(51, 102, 255));
        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 102, 255));
        jLabel7.setText("Family Details");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));
        jPanel7.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 450, 20));

        fulladd.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        fulladd.setPlaceholder("Permanent Address");
        fulladd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fulladdActionPerformed(evt);
            }
        });
        fulladd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fulladdKeyReleased(evt);
            }
        });
        jPanel7.add(fulladd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 340, 30));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Family Full Address:");
        jPanel7.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 130, 40));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Family Head Name:");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, 30));

        familyhead.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        familyhead.setPlaceholder("Family Head Full Name");
        familyhead.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                familyheadActionPerformed(evt);
            }
        });
        familyhead.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                familyheadKeyReleased(evt);
            }
        });
        jPanel7.add(familyhead, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 230, 30));

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Spouse Full Name:");
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 30));

        spousename.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        spousename.setPlaceholder("Spouse Full Name");
        spousename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spousenameActionPerformed(evt);
            }
        });
        spousename.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                spousenameKeyReleased(evt);
            }
        });
        jPanel7.add(spousename, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 230, 30));

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Ownership:");
        jPanel7.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 110, 30));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 0, 0));
        jLabel40.setText("*");
        jPanel7.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 0, 0));
        jLabel41.setText("*");
        jPanel7.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, -1, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 0, 0));
        jLabel42.setText("*");
        jPanel7.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 10, -1));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 0, 0));
        jLabel43.setText("*");
        jPanel7.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 200, 10, -1));

        ownership.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        ownership.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PERMANENT", "TEMPORARY" }));
        jPanel7.add(ownership, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, 230, 30));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 450, 390));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked

        dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel11KeyPressed

    }//GEN-LAST:event_jLabel11KeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed

    }//GEN-LAST:event_jTextField1KeyPressed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        
        int x = JOptionPane.showConfirmDialog(null,"Confirm add new resident?","confirmation message", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x==0){
        
        if(familyhead.getText().equals("")){
     
             familyhead.setBackground(new java.awt.Color(255, 0, 0));
             JOptionPane.showMessageDialog(null,"Please Input Family Head Name");
              familyhead.setBackground(new java.awt.Color(255, 255, 255));
    
    }if(fulladd.getText().equals("")){
             fulladd.setBackground(new java.awt.Color(255, 0, 0));
              JOptionPane.showMessageDialog(null,"Please Input Family Full Address");
               fulladd.setBackground(new java.awt.Color(255, 255, 255));
    }
    else{
        addhousehold();
            }}
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel20KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel20KeyPressed

    }//GEN-LAST:event_jLabel20KeyPressed

    private void fulladdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fulladdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fulladdActionPerformed

    private void fulladdKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fulladdKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fulladdKeyReleased

    private void familyheadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_familyheadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_familyheadActionPerformed

    private void familyheadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_familyheadKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_familyheadKeyReleased

    private void spousenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spousenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spousenameActionPerformed

    private void spousenameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spousenameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_spousenameKeyReleased

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        clear();
    }//GEN-LAST:event_jLabel12MouseClicked

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
            java.util.logging.Logger.getLogger(addhousehold.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addhousehold.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addhousehold.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addhousehold.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addhousehold().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JTextFieldPersonalizado.JCTextField familyhead;
    private JTextFieldPersonalizado.JCTextField fulladd;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JComboBox<String> ownership;
    private JTextFieldPersonalizado.JCTextField spousename;
    // End of variables declaration//GEN-END:variables
}
