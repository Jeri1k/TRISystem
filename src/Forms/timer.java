/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte1.other;

/**
 *
 * @author christopher
 */
public class timer extends javax.swing.JFrame {

    /**
     * Creates new form timer
     */
    public timer() {
 
            initComponents();
          
   
            retry.setVisible(false);
               second();
              dialog.setVisible(true);
    }
   JDialog dialog=new JDialog(this,false);
    
  int counter = 10;
    Boolean isIt = false;
 public void second(){
        Timer timer = new Timer(); //new timer
        counter = 9; //setting the counter to 10 sec
        TimerTask task = new TimerTask() {         
            public void run() {                
                timeLeft.setText(Integer.toString(counter)); //the timer lable to counter.
                counter --;
                if (counter == -1){
                    timer.cancel();
                    retry.setVisible(true);
                    timeLeft.setVisible(false);
                } else if(isIt){
                    timer.cancel();
                    isIt = false;         
                } 
            }
        };
    timer.scheduleAtFixedRate(task, 1000, 1000);
    
   
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
        timeLeft = new javax.swing.JLabel();
        retry = new javax.swing.JButton();
        timeLeft1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0), 3), "you can retry after...", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Verdana", 3, 18))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timeLeft.setBackground(new java.awt.Color(0, 0, 0));
        timeLeft.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        timeLeft.setText("10");
        jPanel1.add(timeLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 40, 150, 50));

        retry.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        retry.setText("retry");
        retry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                retryActionPerformed(evt);
            }
        });
        jPanel1.add(retry, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, 330, 50));

        timeLeft1.setBackground(new java.awt.Color(0, 0, 0));
        timeLeft1.setFont(new java.awt.Font("Verdana", 1, 36)); // NOI18N
        timeLeft1.setText("seconds");
        jPanel1.add(timeLeft1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 180, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 410, 120));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void retryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_retryActionPerformed
        this.dispose();
        dialog.setVisible(false);
        new FormLogin().setVisible(true);
    }//GEN-LAST:event_retryActionPerformed

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
            java.util.logging.Logger.getLogger(timer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(timer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(timer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(timer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new timer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton retry;
    private javax.swing.JLabel timeLeft;
    private javax.swing.JLabel timeLeft1;
    // End of variables declaration//GEN-END:variables
}
