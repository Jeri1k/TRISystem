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
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class addblotter extends javax.swing.JFrame {

    
    public addblotter() {
        initComponents();
    }
    Connection conn = new DBConnection().connect();
    PreparedStatement ps = null;
     ResultSet rs = null;
    Statement s = null;
int id ;
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        create = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        bbb25 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        casedesc = new javax.swing.JTextArea();
        casenametf = new javax.swing.JTextField();
        placetf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        bbb33 = new javax.swing.JLabel();
        edittime = new javax.swing.JPanel();
        edittime3 = new javax.swing.JPanel();
        timeh = new javax.swing.JComboBox<>();
        bbb12 = new javax.swing.JLabel();
        timem = new javax.swing.JComboBox<>();
        timea = new javax.swing.JComboBox<>();
        bbb30 = new javax.swing.JLabel();
        bbb34 = new javax.swing.JLabel();
        bbb37 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        bbb26 = new javax.swing.JLabel();
        cadd2 = new javax.swing.JTextField();
        complainant2 = new javax.swing.JTextField();
        bbb27 = new javax.swing.JLabel();
        bbb36 = new javax.swing.JLabel();
        casename1 = new javax.swing.JLabel();
        casename2 = new javax.swing.JLabel();
        caldate = new com.toedter.calendar.JDateChooser();
        dateinci = new JTextFieldPersonalizado.JCTextField();
        casestat = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(949, 460));
        setMinimumSize(new java.awt.Dimension(949, 460));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(949, 460));
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
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 10, 100, 29));

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
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 10, 80, 29));

        create.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-add-30.png"))); // NOI18N
        create.setText("Create");
        create.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        create.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                createMouseClicked(evt);
            }
        });
        create.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                createKeyPressed(evt);
            }
        });
        jPanel9.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 10, 80, 30));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-add-blotter30.png"))); // NOI18N
        jLabel2.setText("Add Blotter");
        jPanel9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, 50));

        jSeparator9.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 10, 20, 30));

        jSeparator12.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 10, 20, 30));

        jSeparator13.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 20, 30));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel9.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 18, 0, 40));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 50));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel5.setMinimumSize(new java.awt.Dimension(980, 507));
        jPanel5.setName(""); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(980, 507));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bbb25.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb25.setForeground(new java.awt.Color(102, 102, 102));
        bbb25.setText("Case Description:");
        bbb25.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb25PropertyChange(evt);
            }
        });
        jPanel5.add(bbb25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 130, 30));

        casedesc.setColumns(20);
        casedesc.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        casedesc.setForeground(new java.awt.Color(51, 51, 51));
        casedesc.setRows(5);
        jScrollPane10.setViewportView(casedesc);

        jPanel5.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 930, 70));
        jPanel5.add(casenametf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 290, 30));
        jPanel5.add(placetf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 290, 30));
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 1030, -1, -1));
        jPanel5.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 980, 20));
        jPanel5.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 400, 980, 10));

        bbb33.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb33.setForeground(new java.awt.Color(102, 102, 102));
        bbb33.setText("Date of Incident:");
        bbb33.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb33PropertyChange(evt);
            }
        });
        jPanel5.add(bbb33, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 130, 30));

        edittime.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        edittime.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edittime3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        edittime3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        timeh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        edittime3.add(timeh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        bbb12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb12.setForeground(new java.awt.Color(102, 102, 102));
        bbb12.setText(":");
        bbb12.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb12PropertyChange(evt);
            }
        });
        edittime3.add(bbb12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 20, 30));

        timem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "12", "13", "14", "15", "16", "17", "18", "29", "20", "21", "22", "23", "24", "25", "26", "27", "28", "39", "30", "31", "32", "33", "34", "35", "36", "37", "38", "49", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59" }));
        edittime3.add(timem, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, 30));

        timea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AM", "PM" }));
        edittime3.add(timea, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, -1, 30));

        edittime.add(edittime3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 50));

        jPanel5.add(edittime, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, 160, 50));

        bbb30.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb30.setForeground(new java.awt.Color(102, 102, 102));
        bbb30.setText("Time of Incident:");
        bbb30.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb30PropertyChange(evt);
            }
        });
        jPanel5.add(bbb30, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 130, 30));

        bbb34.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb34.setForeground(new java.awt.Color(102, 102, 102));
        bbb34.setText("Casename:");
        bbb34.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb34PropertyChange(evt);
            }
        });
        jPanel5.add(bbb34, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, 30));

        bbb37.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb37.setForeground(new java.awt.Color(102, 102, 102));
        bbb37.setText("Case Status:");
        bbb37.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb37PropertyChange(evt);
            }
        });
        jPanel5.add(bbb37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 40));
        jPanel5.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 980, 10));
        jPanel5.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 50, 990, 10));

        bbb26.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb26.setForeground(new java.awt.Color(102, 102, 102));
        bbb26.setText("Complainant Address:");
        bbb26.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb26PropertyChange(evt);
            }
        });
        jPanel5.add(bbb26, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 130, 30));
        jPanel5.add(cadd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 300, 30));
        jPanel5.add(complainant2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 300, 30));

        bbb27.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb27.setForeground(new java.awt.Color(102, 102, 102));
        bbb27.setText("Complainant:");
        bbb27.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb27PropertyChange(evt);
            }
        });
        jPanel5.add(bbb27, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 130, 30));

        bbb36.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb36.setForeground(new java.awt.Color(102, 102, 102));
        bbb36.setText("Place of Incident:");
        bbb36.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb36PropertyChange(evt);
            }
        });
        jPanel5.add(bbb36, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, 30));

        casename1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        casename1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                casename1PropertyChange(evt);
            }
        });
        jPanel5.add(casename1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 340, 30));

        casename2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        casename2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                casename2PropertyChange(evt);
            }
        });
        jPanel5.add(casename2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 340, 30));

        caldate.setDateFormatString("yyyy-MM-dd");
        caldate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                caldateMouseClicked(evt);
            }
        });
        caldate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                caldatePropertyChange(evt);
            }
        });
        jPanel5.add(caldate, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 230, 30));

        dateinci.setEditable(false);
        dateinci.setEnabled(false);
        dateinci.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        dateinci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateinciActionPerformed(evt);
            }
        });
        dateinci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dateinciKeyReleased(evt);
            }
        });
        jPanel5.add(dateinci, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 60, 230, 30));

        casestat.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        casestat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVE", "INACTIVE", " " }));
        jPanel5.add(casestat, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 170, 30));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1060, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked

        dispose();

    }//GEN-LAST:event_jLabel11MouseClicked

    private void jLabel11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel11KeyPressed

    }//GEN-LAST:event_jLabel11KeyPressed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
                    erase();
                    
                    
                    
                    
    }//GEN-LAST:event_jLabel12MouseClicked
void addBlotter(){
    
    try
            {
                String time = timeh.getSelectedItem().toString()+" : "+timem.getSelectedItem().toString()+" "+timea.getSelectedItem().toString();
              String casesta = (String) casestat.getSelectedItem();
              
                ps=conn.prepareStatement("INSERT INTO `tbl_blotter`(`case_no`, `case_name`, `case_stat`, `case_desc`, `place_of_inci`, `date_of_inci`, `time_of_inci`, `datetime_created`) VALUES (?,?,?,?,?,?,?,sysdate())");
             ps.setInt(1, id);
             ps.setString(2, casenametf.getText().toUpperCase());
             ps.setString(3,casesta);
             ps.setString(4, casedesc.getText().toUpperCase());
             ps.setString(5, placetf.getText().toUpperCase());
              ps.setString(6, ((JTextField)caldate.getDateEditor().getUiComponent()).getText());
              ps.setString(7, time);
             ps.execute();
            addComplainant();
            
             JOptionPane.showMessageDialog(null,"Succesfully Created.");
           erase();
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }   
}
void addComplainant(){
     try
            {
               
             
              
                ps=conn.prepareStatement("INSERT INTO `tbl_complainant`(`complainant_id`, `complainant_name`, `complainant_addr`) VALUES (?,?,?)");
             ps.setInt(1, id);
             ps.setString(2, complainant2.getText().toUpperCase());
             ps.setString(3,cadd2.getText().toUpperCase());
            
            
            
             ps.execute();
            
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }   
}
void erase(){
    casenametf.setText(null);
    placetf.setText(null);
    complainant2.setText(null);
    cadd2.setText(null);
    casedesc.setText(null);
    casenametf.setText(null);
    timeh.setSelectedItem("");
     timem.setSelectedItem("00");
      timea.setSelectedItem("AM");
      caldate.setDate(null);
    
    
}
    private void createMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_createMouseClicked
        if(casenametf.getText().equals("") && placetf.getText().equals("")&&complainant2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Input Required.");

         }else{ 
             int x = JOptionPane.showConfirmDialog(null,"Confirm add Blotter?","confirmation message", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
                if (x==0){
                    addBlotter();
            }
        }
    }//GEN-LAST:event_createMouseClicked

    private void createKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_createKeyPressed

    }//GEN-LAST:event_createKeyPressed

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        
    }//GEN-LAST:event_jTextField1KeyPressed

    private void bbb25PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb25PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb25PropertyChange

    private void bbb33PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb33PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb33PropertyChange

    private void bbb30PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb30PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb30PropertyChange

    private void bbb34PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb34PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb34PropertyChange

    private void bbb37PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb37PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb37PropertyChange

    private void bbb26PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb26PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb26PropertyChange

    private void bbb27PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb27PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb27PropertyChange

    private void bbb36PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb36PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb36PropertyChange

    private void casename1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_casename1PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_casename1PropertyChange

    private void casename2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_casename2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_casename2PropertyChange

    private void dateinciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateinciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dateinciActionPerformed

    private void dateinciKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dateinciKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_dateinciKeyReleased

    private void bbb12PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb12PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb12PropertyChange

    private void caldateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caldateMouseClicked

    }//GEN-LAST:event_caldateMouseClicked

    private void caldatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_caldatePropertyChange
       
      
    }//GEN-LAST:event_caldatePropertyChange

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
            java.util.logging.Logger.getLogger(addblotter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addblotter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addblotter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addblotter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addblotter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bbb12;
    private javax.swing.JLabel bbb25;
    private javax.swing.JLabel bbb26;
    private javax.swing.JLabel bbb27;
    private javax.swing.JLabel bbb30;
    private javax.swing.JLabel bbb33;
    private javax.swing.JLabel bbb34;
    private javax.swing.JLabel bbb36;
    private javax.swing.JLabel bbb37;
    private javax.swing.JTextField cadd2;
    private com.toedter.calendar.JDateChooser caldate;
    private javax.swing.JTextArea casedesc;
    private javax.swing.JLabel casename1;
    private javax.swing.JLabel casename2;
    private javax.swing.JTextField casenametf;
    private javax.swing.JComboBox<String> casestat;
    private javax.swing.JTextField complainant2;
    private javax.swing.JLabel create;
    private JTextFieldPersonalizado.JCTextField dateinci;
    private javax.swing.JPanel edittime;
    private javax.swing.JPanel edittime3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField placetf;
    private javax.swing.JComboBox<String> timea;
    private javax.swing.JComboBox<String> timeh;
    private javax.swing.JComboBox<String> timem;
    // End of variables declaration//GEN-END:variables
}
