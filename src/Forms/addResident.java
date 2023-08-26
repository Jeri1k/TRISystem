/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;
/**
 *
 * @author christopher
 */

import Class.DBConnection;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class addResident extends javax.swing.JFrame {

    /**
     * Creates new form blotterForm
     */
    public addResident() {
     //   this.setAlwaysOnTop(true);
        initComponents();
       
        noneradio.setSelected(true);
        uneradio.setSelected(false);
        empradio.setSelected(false);
        maleradio.setSelected(false);
        femaleradio.setSelected(false);
        selradio.setSelected(false);
        
    }
   
   Connection conn = new DBConnection().connect();
    PreparedStatement ps = null;
     ResultSet rs = null;
    Statement s = null;
  
  

 int auto_id;
        Connection chosencon;

        String namesuf="";
  


            
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        h = new JTextFieldPersonalizado.JCTextField();
        bbb2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        spouse = new JTextFieldPersonalizado.JCTextField();
        contact = new JTextFieldPersonalizado.JCTextField();
        w = new JTextFieldPersonalizado.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        moth = new JTextFieldPersonalizado.JCTextField();
        fath = new JTextFieldPersonalizado.JCTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        noofchild = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        caldor = new com.toedter.calendar.JDateChooser();
        headlabel2 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        permanentadd = new JTextFieldPersonalizado.JCTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        houseno = new JTextFieldPersonalizado.JCTextField();
        jLabel24 = new javax.swing.JLabel();
        purok = new JTextFieldPersonalizado.JCTextField();
        jLabel25 = new javax.swing.JLabel();
        brgy = new JTextFieldPersonalizado.JCTextField();
        jLabel26 = new javax.swing.JLabel();
        muni = new JTextFieldPersonalizado.JCTextField();
        jLabel27 = new javax.swing.JLabel();
        prov = new JTextFieldPersonalizado.JCTextField();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        selradio = new javax.swing.JRadioButton();
        empradio = new javax.swing.JRadioButton();
        uneradio = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator13 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lastname = new JTextFieldPersonalizado.JCTextField();
        firstname = new JTextFieldPersonalizado.JCTextField();
        middlename = new JTextFieldPersonalizado.JCTextField();
        bbb4 = new javax.swing.JLabel();
        bbb5 = new javax.swing.JLabel();
        bbb6 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        suffix = new javax.swing.JComboBox<>();
        headlabel4 = new javax.swing.JLabel();
        headlabel5 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        noneradio = new javax.swing.JRadioButton();
        elemradio = new javax.swing.JRadioButton();
        hsradio = new javax.swing.JRadioButton();
        curadio = new javax.swing.JRadioButton();
        cgradio = new javax.swing.JRadioButton();
        headlabel6 = new javax.swing.JLabel();
        headlabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        tfpob = new JTextFieldPersonalizado.JCTextField();
        calbday = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        combocivilstatus = new javax.swing.JComboBox<>();
        nationality = new JTextFieldPersonalizado.JCTextField();
        religion = new JTextFieldPersonalizado.JCTextField();
        jLabel17 = new javax.swing.JLabel();
        maleradio = new javax.swing.JRadioButton();
        femaleradio = new javax.swing.JRadioButton();
        age = new javax.swing.JLabel();
        bbb3 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator14 = new javax.swing.JSeparator();
        jSeparator15 = new javax.swing.JSeparator();
        jSeparator16 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator18 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        resstat = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        headlabel7 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 168));
        setMaximumSize(new java.awt.Dimension(1055, 604));
        setMinimumSize(new java.awt.Dimension(1055, 604));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1055, 604));
        setResizable(false);
        setSize(new java.awt.Dimension(1055, 604));
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 255), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Height");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        h.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        h.setPlaceholder("Height");
        h.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hActionPerformed(evt);
            }
        });
        h.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                hKeyReleased(evt);
            }
        });
        jPanel3.add(h, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 170, 30));

        bbb2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb2.setForeground(new java.awt.Color(102, 102, 102));
        bbb2.setText("Weight");
        bbb2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb2PropertyChange(evt);
            }
        });
        jPanel3.add(bbb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 56, 40));

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Contact No.");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, 40));

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Spouse Name: ");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 110, 50));

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("No. Of Child:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 70, 50));
        jPanel3.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 260, 40));
        jPanel3.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 250, 10));
        jPanel3.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 250, 20));
        jPanel3.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 250, 20));
        jPanel3.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 250, 20));

        spouse.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        spouse.setPlaceholder("Spouse Name");
        spouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spouseActionPerformed(evt);
            }
        });
        spouse.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                spouseKeyReleased(evt);
            }
        });
        jPanel3.add(spouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 160, 30));

        contact.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        contact.setPlaceholder("Contact No.");
        contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactActionPerformed(evt);
            }
        });
        contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                contactKeyReleased(evt);
            }
        });
        jPanel3.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 170, 30));

        w.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        w.setPlaceholder("Weight");
        w.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wActionPerformed(evt);
            }
        });
        w.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                wKeyReleased(evt);
            }
        });
        jPanel3.add(w, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 170, 30));

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 102, 102));
        jLabel13.setText("Mother Name:");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 80, 50));

        moth.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        moth.setPlaceholder("Mother name");
        moth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mothActionPerformed(evt);
            }
        });
        moth.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                mothKeyReleased(evt);
            }
        });
        jPanel3.add(moth, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 160, 30));

        fath.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        fath.setPlaceholder("Father Name");
        fath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fathActionPerformed(evt);
            }
        });
        fath.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fathKeyReleased(evt);
            }
        });
        jPanel3.add(fath, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 160, 30));

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 102, 102));
        jLabel15.setText("Father Name: ");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 80, 50));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 0, 0));
        jLabel34.setText("*");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, -1, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 0, 0));
        jLabel42.setText("*");
        jPanel3.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, -1, -1));

        noofchild.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        noofchild.setForeground(new java.awt.Color(102, 102, 102));
        noofchild.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        noofchild.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noofchildActionPerformed(evt);
            }
        });
        jPanel3.add(noofchild, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 70, 32));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 260, 290));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Date of Residency:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 30));

        caldor.setDateFormatString("yyyy-MM-dd");
        caldor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                caldorMouseClicked(evt);
            }
        });
        caldor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                caldorPropertyChange(evt);
            }
        });
        jPanel6.add(caldor, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 190, 30));

        headlabel2.setFont(new java.awt.Font("Verdana", 1, 8)); // NOI18N
        headlabel2.setForeground(new java.awt.Color(102, 102, 102));
        headlabel2.setText("since birth?");
        headlabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                headlabel2MouseClicked(evt);
            }
        });
        jPanel6.add(headlabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 10, 70, 30));
        jPanel6.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 430, 20));

        permanentadd.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        permanentadd.setPlaceholder("Permanent Address");
        permanentadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                permanentaddActionPerformed(evt);
            }
        });
        permanentadd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                permanentaddKeyReleased(evt);
            }
        });
        jPanel6.add(permanentadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 340, 30));

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Permanent Address:");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 130, 40));

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 102, 102));
        jLabel14.setText("House No.:");
        jPanel6.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 110, 30));

        houseno.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        houseno.setPlaceholder("House No.");
        houseno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                housenoActionPerformed(evt);
            }
        });
        houseno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                housenoKeyReleased(evt);
            }
        });
        jPanel6.add(houseno, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 230, 30));

        jLabel24.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(102, 102, 102));
        jLabel24.setText("Purok / District:");
        jPanel6.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 110, 30));

        purok.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        purok.setPlaceholder("Purok");
        purok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                purokActionPerformed(evt);
            }
        });
        purok.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                purokKeyReleased(evt);
            }
        });
        jPanel6.add(purok, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 230, 30));

        jLabel25.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(102, 102, 102));
        jLabel25.setText("Barangay:");
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 110, 30));

        brgy.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        brgy.setPlaceholder("Barangay");
        brgy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brgyActionPerformed(evt);
            }
        });
        brgy.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                brgyKeyReleased(evt);
            }
        });
        jPanel6.add(brgy, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 230, 30));

        jLabel26.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(102, 102, 102));
        jLabel26.setText("Municipality:");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 110, 30));

        muni.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        muni.setPlaceholder("Municipality");
        muni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                muniActionPerformed(evt);
            }
        });
        muni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                muniKeyReleased(evt);
            }
        });
        jPanel6.add(muni, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 230, 30));

        jLabel27.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(102, 102, 102));
        jLabel27.setText("Province:");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 110, 30));

        prov.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        prov.setPlaceholder("Province");
        prov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provActionPerformed(evt);
            }
        });
        prov.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                provKeyReleased(evt);
            }
        });
        jPanel6.add(prov, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 230, 30));

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 0, 0));
        jLabel36.setText("*");
        jPanel6.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, -1, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 0, 0));
        jLabel37.setText("*");
        jPanel6.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, -1, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 0, 0));
        jLabel38.setText("*");
        jPanel6.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 110, 10, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 0, 0));
        jLabel39.setText("*");
        jPanel6.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 0, 0));
        jLabel40.setText("*");
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 0, 0));
        jLabel41.setText("*");
        jPanel6.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, -1, -1));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 0, 0));
        jLabel45.setText("*");
        jPanel6.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 310, -1, -1));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 430, 420));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup2.add(selradio);
        selradio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        selradio.setText("Self Employed");
        selradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selradioActionPerformed(evt);
            }
        });
        jPanel11.add(selradio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 110, -1));

        buttonGroup2.add(empradio);
        empradio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        empradio.setText("Employed");
        empradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empradioActionPerformed(evt);
            }
        });
        jPanel11.add(empradio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        buttonGroup2.add(uneradio);
        uneradio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        uneradio.setText("Unemployed");
        uneradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uneradioActionPerformed(evt);
            }
        });
        jPanel11.add(uneradio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(102, 102, 102));
        jLabel16.setText("Employment Status:");
        jPanel11.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 30));

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 510, 310, 80));

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
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 100, 29));

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
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 10, 80, 29));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/addnewres 30px.png"))); // NOI18N
        jLabel20.setText("Create");
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
        jPanel9.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 10, 80, 30));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-resident-30.png"))); // NOI18N
        jLabel2.setText("Add Residents");
        jPanel9.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, -1, 50));

        jSeparator9.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 10, 20, 30));

        jSeparator12.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator12.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 10, 20, 30));

        jSeparator13.setForeground(new java.awt.Color(102, 102, 102));
        jSeparator13.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel9.add(jSeparator13, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 20, 30));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 1)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });
        jPanel9.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 18, 0, 40));

        jPanel1.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lastname.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        lastname.setPlaceholder("Surname");
        lastname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                lastnameFocusLost(evt);
            }
        });
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        lastname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lastnameKeyReleased(evt);
            }
        });
        jPanel2.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 140, -1));

        firstname.setToolTipText("");
        firstname.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        firstname.setPlaceholder("First Name");
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        firstname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                firstnameKeyReleased(evt);
            }
        });
        jPanel2.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 210, -1));

        middlename.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        middlename.setPlaceholder("Middlename");
        middlename.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                middlenameActionPerformed(evt);
            }
        });
        middlename.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                middlenameKeyReleased(evt);
            }
        });
        jPanel2.add(middlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 210, -1));

        bbb4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb4.setForeground(new java.awt.Color(102, 102, 102));
        bbb4.setText("Last Name");
        bbb4.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb4PropertyChange(evt);
            }
        });
        jPanel2.add(bbb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 70, 40));

        bbb5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb5.setForeground(new java.awt.Color(102, 102, 102));
        bbb5.setText("Firstname");
        bbb5.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb5PropertyChange(evt);
            }
        });
        jPanel2.add(bbb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 70, 40));

        bbb6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb6.setForeground(new java.awt.Color(102, 102, 102));
        bbb6.setText("Middle Name");
        bbb6.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb6PropertyChange(evt);
            }
        });
        jPanel2.add(bbb6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 80, 40));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setText("*");
        jPanel2.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, -1, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 0, 0));
        jLabel30.setText("*");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 50, -1, -1));

        suffix.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        suffix.setForeground(new java.awt.Color(102, 102, 102));
        suffix.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Suffix", "JR", "SR", "II", "III", "IV" }));
        suffix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suffixActionPerformed(evt);
            }
        });
        jPanel2.add(suffix, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 70, 32));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 690, -1));

        headlabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        headlabel4.setForeground(new java.awt.Color(0, 0, 102));
        headlabel4.setText("BASIC INFO");
        jPanel1.add(headlabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 120, 40));

        headlabel5.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        headlabel5.setForeground(new java.awt.Color(0, 0, 102));
        headlabel5.setText("Other Details");
        jPanel1.add(headlabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, 130, 30));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));

        buttonGroup1.add(noneradio);
        noneradio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        noneradio.setForeground(new java.awt.Color(51, 51, 51));
        noneradio.setText("None");
        noneradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                noneradioActionPerformed(evt);
            }
        });
        noneradio.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                noneradioPropertyChange(evt);
            }
        });

        buttonGroup1.add(elemradio);
        elemradio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        elemradio.setForeground(new java.awt.Color(51, 51, 51));
        elemradio.setText("Elementary");
        elemradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elemradioActionPerformed(evt);
            }
        });

        buttonGroup1.add(hsradio);
        hsradio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        hsradio.setForeground(new java.awt.Color(51, 51, 51));
        hsradio.setText("High school");
        hsradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hsradioActionPerformed(evt);
            }
        });

        buttonGroup1.add(curadio);
        curadio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        curadio.setForeground(new java.awt.Color(51, 51, 51));
        curadio.setText("College Undergraduate");
        curadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curadioActionPerformed(evt);
            }
        });

        buttonGroup1.add(cgradio);
        cgradio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        cgradio.setForeground(new java.awt.Color(51, 51, 51));
        cgradio.setText("College Graduate");
        cgradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cgradioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(noneradio)
                        .addGap(29, 29, 29)
                        .addComponent(elemradio)
                        .addGap(18, 18, 18)
                        .addComponent(hsradio))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(cgradio)
                        .addGap(18, 18, 18)
                        .addComponent(curadio)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hsradio)
                    .addComponent(elemradio)
                    .addComponent(noneradio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cgradio)
                    .addComponent(curadio))
                .addContainerGap())
        );

        jPanel1.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 410, 310, 80));

        headlabel6.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        headlabel6.setForeground(new java.awt.Color(0, 0, 102));
        headlabel6.setText("ADDRESS:");
        jPanel1.add(headlabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 120, 30));

        headlabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        headlabel9.setForeground(new java.awt.Color(0, 0, 102));
        headlabel9.setText("Occupation");
        jPanel1.add(headlabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 480, 130, 30));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfpob.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        tfpob.setPlaceholder("Place of Birth");
        tfpob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfpobActionPerformed(evt);
            }
        });
        tfpob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfpobKeyReleased(evt);
            }
        });
        jPanel4.add(tfpob, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 230, 30));

        calbday.setDateFormatString("yyyy-MM-dd");
        calbday.setMaxSelectableDate(null);
        calbday.setMinSelectableDate(null);
        calbday.addHierarchyListener(new java.awt.event.HierarchyListener() {
            public void hierarchyChanged(java.awt.event.HierarchyEvent evt) {
                calbdayHierarchyChanged(evt);
            }
        });
        calbday.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                calbdayFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                calbdayFocusLost(evt);
            }
        });
        calbday.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calbdayMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                calbdayMouseEntered(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                calbdayMouseReleased(evt);
            }
        });
        calbday.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                calbdayInputMethodTextChanged(evt);
            }
        });
        calbday.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                calbdayPropertyChange(evt);
            }
        });
        calbday.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calbdayKeyReleased(evt);
            }
        });
        jPanel4.add(calbday, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 140, -1));

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Sex:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        combocivilstatus.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        combocivilstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SINGLE", "MARRIED", "ANNULED", "SEPARATED", "LEGALLY SEPARATED", "WIDOWED", " " }));
        jPanel4.add(combocivilstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 150, 20));

        nationality.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        nationality.setPlaceholder("Nationality");
        nationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nationalityActionPerformed(evt);
            }
        });
        nationality.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nationalityKeyReleased(evt);
            }
        });
        jPanel4.add(nationality, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 150, 30));

        religion.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        religion.setPlaceholder("Religion");
        religion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                religionActionPerformed(evt);
            }
        });
        religion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                religionKeyReleased(evt);
            }
        });
        jPanel4.add(religion, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 150, 30));

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(102, 102, 102));
        jLabel17.setText("Place of Birth:");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 110, 40));

        buttonGroup5.add(maleradio);
        maleradio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        maleradio.setForeground(new java.awt.Color(51, 51, 51));
        maleradio.setText("male");
        maleradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleradioActionPerformed(evt);
            }
        });
        jPanel4.add(maleradio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        buttonGroup5.add(femaleradio);
        femaleradio.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        femaleradio.setForeground(new java.awt.Color(51, 51, 51));
        femaleradio.setText("female");
        femaleradio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleradioActionPerformed(evt);
            }
        });
        jPanel4.add(femaleradio, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        age.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        age.setForeground(new java.awt.Color(102, 102, 102));
        age.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ageFocusGained(evt);
            }
        });
        jPanel4.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 110, 40));

        bbb3.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb3.setForeground(new java.awt.Color(102, 102, 102));
        bbb3.setText("Birthday:");
        bbb3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb3PropertyChange(evt);
            }
        });
        jPanel4.add(bbb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 56, 40));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 10, 370));

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(102, 102, 102));
        jLabel18.setText("Age:");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, 40));

        jLabel19.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(102, 102, 102));
        jLabel19.setText("Nationality");
        jPanel4.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 70, 50));

        jLabel21.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(102, 102, 102));
        jLabel21.setText("Religion:");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 70, 50));
        jPanel4.add(jSeparator14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 250, 40));
        jPanel4.add(jSeparator15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 250, 10));
        jPanel4.add(jSeparator16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 250, 20));

        jLabel22.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(102, 102, 102));
        jLabel22.setText("Civil Status:");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 70, 40));
        jPanel4.add(jSeparator17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 250, 20));
        jPanel4.add(jSeparator18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 250, 20));
        jPanel4.add(jSeparator19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 250, 20));

        jLabel23.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(102, 102, 102));
        jLabel23.setText("Resident Status:");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 110, 40));

        resstat.setFont(new java.awt.Font("Verdana", 1, 10)); // NOI18N
        resstat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PERMANENT", "TEMPORARY" }));
        jPanel4.add(resstat, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 120, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 0));
        jLabel9.setText("*");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, -1, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 0));
        jLabel28.setText("*");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, -1, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 0, 0));
        jLabel31.setText("*");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 0, 0));
        jLabel32.setText("*");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 270, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 0, 0));
        jLabel33.setText("*");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 350, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 0, 0));
        jLabel35.setText("*");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, -1, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 250, 420));

        headlabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        headlabel7.setForeground(new java.awt.Color(0, 0, 102));
        headlabel7.setText("EDUCATION");
        jPanel1.add(headlabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 380, 130, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 0, 0));
        jLabel43.setText("*");
        jPanel1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 390, -1, -1));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 0, 0));
        jLabel44.setText("*");
        jPanel1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 490, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1160, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bbb3PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb3PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb3PropertyChange

    private void ageFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ageFocusGained
        // TODO add your handling code here:    
        getage();
    }//GEN-LAST:event_ageFocusGained

    private void femaleradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleradioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_femaleradioActionPerformed

    private void maleradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleradioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maleradioActionPerformed

    private void religionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_religionKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_religionKeyReleased

    private void religionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_religionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_religionActionPerformed

    private void nationalityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nationalityKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_nationalityKeyReleased

    private void nationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nationalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nationalityActionPerformed

    private void calbdayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_calbdayPropertyChange
 if (calbday.getDate()!=null){
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            Date ff=new Date();
            long realtime= ff.getTime();
            
            Date e = calbday.getDate();
            long bday = e.getTime();
            if (bday>realtime){
                JOptionPane.showMessageDialog(null, "Invalid Date!");
                calbday.setDate(null);
            }else{
                        getage();
 }
        }     
    }//GEN-LAST:event_calbdayPropertyChange

    private void calbdayMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calbdayMouseReleased
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_calbdayMouseReleased

    private void calbdayMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calbdayMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_calbdayMouseClicked

    private void calbdayFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_calbdayFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_calbdayFocusLost

    private void calbdayFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_calbdayFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_calbdayFocusGained

    private void tfpobKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfpobKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tfpobKeyReleased

    private void tfpobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfpobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfpobActionPerformed

    private void cgradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cgradioActionPerformed

      
    }//GEN-LAST:event_cgradioActionPerformed

    private void curadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curadioActionPerformed
       
    }//GEN-LAST:event_curadioActionPerformed

    private void hsradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hsradioActionPerformed
    
    }//GEN-LAST:event_hsradioActionPerformed

    private void elemradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elemradioActionPerformed
       
    }//GEN-LAST:event_elemradioActionPerformed

    private void noneradioPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_noneradioPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_noneradioPropertyChange

    private void noneradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noneradioActionPerformed
        
       

    }//GEN-LAST:event_noneradioActionPerformed

    private void bbb6PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb6PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb6PropertyChange

    private void bbb5PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb5PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb5PropertyChange

    private void bbb4PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb4PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb4PropertyChange

    private void middlenameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_middlenameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_middlenameKeyReleased

    private void middlenameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_middlenameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_middlenameActionPerformed

    private void firstnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_firstnameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameKeyReleased

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void noofchildActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_noofchildActionPerformed

    }//GEN-LAST:event_noofchildActionPerformed

    private void lastnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lastnameKeyReleased

    }//GEN-LAST:event_lastnameKeyReleased

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lastnameActionPerformed

    private void lastnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lastnameFocusLost
        firstname.nextFocus();
    }//GEN-LAST:event_lastnameFocusLost

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        if (evt.getKeyCode()==KeyEvent.VK_ESCAPE){
            this.dispose();
        }else if (evt.getKeyCode()==KeyEvent.VK_DELETE){
            nullifier();
            
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jLabel20KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel20KeyPressed

    }//GEN-LAST:event_jLabel20KeyPressed

    private void jLabel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel20MouseClicked
        if(firstname.getText()==""){
             firstname.setBackground(new java.awt.Color(255, 0, 0));
        }if(lastname.getText()==""){
             lastname.setBackground(new java.awt.Color(255, 0, 0));
        }if(moth.getText()==""){
             moth.setBackground(new java.awt.Color(255, 0, 0));
        }if(fath.getText()==""){
             fath.setBackground(new java.awt.Color(255, 0, 0));
        }if(nationality.getText()==""){
             nationality.setBackground(new java.awt.Color(255, 0, 0));
        }if(religion.getText()==""){
             religion.setBackground(new java.awt.Color(255, 0, 0));
        }if(tfpob.getText()==""){
             tfpob.setBackground(new java.awt.Color(255, 0, 0));
        }else{
        
        addresident();
        }
       
    }//GEN-LAST:event_jLabel20MouseClicked

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        nullifier();

       age.setText(null);
    }//GEN-LAST:event_jLabel12MouseClicked

    private void jLabel11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabel11KeyPressed

    }//GEN-LAST:event_jLabel11KeyPressed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
       
        
        
        dispose();
        

    }//GEN-LAST:event_jLabel11MouseClicked

    private void uneradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uneradioActionPerformed
        

    }//GEN-LAST:event_uneradioActionPerformed



    private void empradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empradioActionPerformed
        
    }//GEN-LAST:event_empradioActionPerformed

    private void selradioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selradioActionPerformed
       
    }//GEN-LAST:event_selradioActionPerformed

    private void headlabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_headlabel2MouseClicked
        caldor.setDate(calbday.getDate());        // TODO add your handling code here:
    }//GEN-LAST:event_headlabel2MouseClicked

    private void caldorPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_caldorPropertyChange

        if (caldor.getDate()!=null){
            SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
            Date ff=new Date();
            long realtime= ff.getTime();
            Date d = caldor.getDate();
            long dor = d.getTime();
            Date e = calbday.getDate();
            long bday = e.getTime();
            if (dor==bday){
            }else
            if (dor<bday||dor>realtime){
                JOptionPane.showMessageDialog(null, "Invalid Date!");
                caldor.setDate(null);
            }
        }
    }//GEN-LAST:event_caldorPropertyChange

    private void caldorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_caldorMouseClicked

    }//GEN-LAST:event_caldorMouseClicked

    private void bbb2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb2PropertyChange

    private void hKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_hKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_hKeyReleased

    private void hActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hActionPerformed

    private void permanentaddKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_permanentaddKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentaddKeyReleased

    private void permanentaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_permanentaddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_permanentaddActionPerformed

    private void spouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spouseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_spouseActionPerformed

    private void spouseKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_spouseKeyReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_spouseKeyReleased

    private void contactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactActionPerformed

    private void contactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_contactKeyReleased

    private void wActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wActionPerformed

    private void wKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_wKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_wKeyReleased

    private void housenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_housenoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_housenoActionPerformed

    private void housenoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_housenoKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_housenoKeyReleased

    private void purokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_purokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_purokActionPerformed

    private void purokKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_purokKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_purokKeyReleased

    private void brgyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brgyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_brgyActionPerformed

    private void brgyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_brgyKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_brgyKeyReleased

    private void muniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_muniActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_muniActionPerformed

    private void muniKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_muniKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_muniKeyReleased

    private void provActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_provActionPerformed

    private void provKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_provKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_provKeyReleased

    private void mothActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mothActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mothActionPerformed

    private void mothKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_mothKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_mothKeyReleased

    private void fathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fathActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fathActionPerformed

    private void fathKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fathKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_fathKeyReleased

    private void calbdayInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_calbdayInputMethodTextChanged

    }//GEN-LAST:event_calbdayInputMethodTextChanged

    private void calbdayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_calbdayKeyReleased
     // TODO add your handling code here:
    }//GEN-LAST:event_calbdayKeyReleased

    private void calbdayHierarchyChanged(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_calbdayHierarchyChanged
  // TODO add your handling code here:
    }//GEN-LAST:event_calbdayHierarchyChanged

    private void calbdayMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calbdayMouseEntered
        // TODO add your handling code here:
     
    }//GEN-LAST:event_calbdayMouseEntered

    private void suffixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suffixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_suffixActionPerformed

    



public void nullifier(){
    lastname.setText("");
    firstname.setText("");
    middlename.setText("");
    suffix.setSelectedItem("Suffix");
   calbday.setDate(null);
   caldor.setDate(null);
    maleradio.setSelected(false);
    femaleradio.setSelected(false);
    h.setText("");
     w.setText("");
    permanentadd.setText("");
    combocivilstatus.setSelectedItem("SINGLE");
   contact.setText("");
    spouse.setText("");
      moth.setText("");
       fath.setText("");
    noofchild.setSelectedIndex(0);
   nationality.setText("");
   religion.setText("");
     purok.setText("");
   tfpob.setText("");
   
    
    noneradio.setSelected(true);
    empradio.setSelected(false);
    selradio.setSelected(false);
    uneradio.setSelected(false);
    houseno.setText("");
    brgy.setText("");
     muni.setText("");
      prov.setText("");
      
       lastname.setBackground(new java.awt.Color(255, 255, 255));
        firstname.setBackground(new java.awt.Color(255, 255, 255));
       calbday.setBackground(new java.awt.Color(240, 240, 240));
         caldor.setBackground(new java.awt.Color(240, 240, 240));
      

 
           
}





  
   PreparedStatement pst;
   public void addresident(){
    
       
        
    String suffx=suffix.getSelectedItem().toString().toUpperCase();   
String sufx="";
if (suffix.getSelectedIndex()!=0){
    sufx=" "+suffx;
}
        lastname.setBackground(new java.awt.Color(255, 255, 255));
        firstname.setBackground(new java.awt.Color(255, 255, 255));
        calbday.setBackground(new java.awt.Color(240, 240, 240));
         caldor.setBackground(new java.awt.Color(240, 240, 240));
        
  boolean execution= true;
  boolean process= false;
  
 
        String sex="MALE";
       
      
        if (maleradio.isSelected()==true&&femaleradio.isSelected()==false){
        sex="MALE";
    }else if (maleradio.isSelected()==false&&femaleradio.isSelected()==true){
        sex="FEMALE";
    }
       //
 String highest="None";
           
            
            if (elemradio.isSelected()==true){
                highest="ELEMENTARY";
            }else if (hsradio.isSelected()==true){
                highest="HIGH SCHOOL";
         
            }else if (cgradio.isSelected()==true){
                highest="COLLEGE GRADUATE";
            }else if (noneradio.isSelected()==true){
                highest="NONE";
            }else if (curadio.isSelected()==true){
                highest="COLLEGE UNDERGRADUATE";
            }
            
  String occupation="None";
           
            
            if (empradio.isSelected()==true){
                occupation="EMPLOYED";
            }else if (uneradio.isSelected()==true){
                occupation="UNEMPLOYED";
         
            }else if (selradio.isSelected()==true){
                occupation="SELF EMPLOYED";
            }
       
       // 
       
       
   
         
             
    
    
      if (lastname.getText().equals("")){
          lastname.setBackground(new java.awt.Color(255, 0, 0));
          execution=false;}
      if (firstname.getText().equals("")){
          firstname.setBackground(new java.awt.Color(255, 0, 0));
          execution=false;}
      if(age.getText().equals("")){
           age.setBackground(new java.awt.Color(255, 0, 0));
           execution=false;
      }
        if (calbday.getDate()==null){
          calbday.setBackground(new java.awt.Color(255, 0, 0));
          execution=false;}
 
          if (caldor.getDate()==null){
          caldor.setBackground(new java.awt.Color(255, 0, 0));
          execution=false;}
     
          
          
          
          
          
          int currentage = Integer.parseInt(age.getText());
         
         
          
          
          
      if (execution==true){
          
          
          
          
          
            int x = JOptionPane.showConfirmDialog(null,"Confirm add new resident?","confirmation message", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x==0){
             try{   
                 
                 
                 int child =Integer.parseInt((String) noofchild.getSelectedItem());
                 
                     String last = lastname.getText().toUpperCase();
             String lastn = last + sufx;
          String res = (String)resstat.getSelectedItem();
          String civil = (String) combocivilstatus.getSelectedItem();
                    
          String sql = "INSERT INTO `tbl_resident`(`resident_id`, `last_name`, `first_name`, `middle_name`, `age`, `sex`, `date_of_birth`, `place_of_birth`, `height`, `weight`, `contact_no`, `permanent_add`, `resident_stat`, `highest_educ_attain`, `occupation`, `civil_status`, `spouse_name`, `no_of_child`, `religion`, `nationality`, `mother_name`, `father_name`, `date_residency`, `date_reg`) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate())";

           pst = conn.prepareStatement(sql);
            pst.setInt(1, auto_id);
            pst.setString(2, lastn);
            pst.setString(3, firstname.getText().toUpperCase());
            pst.setString(4, middlename.getText().toUpperCase());
            pst.setInt(5, currentage);
            pst.setString(6, sex);
            pst.setString(7, ((JTextField)calbday.getDateEditor().getUiComponent()).getText());
            pst.setString(8, tfpob.getText().toUpperCase());
            pst.setString(9, h.getText().toUpperCase());
            pst.setString(10, w.getText().toUpperCase());
            pst.setString(11, contact.getText().toUpperCase());
           pst.setString(12,permanentadd.getText().toUpperCase());
            pst.setString(13,res );
             pst.setString(14, highest);
              pst.setString(15, occupation);
               pst.setString(16, civil);
                pst.setString(17, spouse.getText().toUpperCase());
                 pst.setInt(18, child);
                  pst.setString(19, religion.getText().toUpperCase());
                   pst.setString(20,  nationality.getText().toUpperCase());
                    pst.setString(21, moth.getText().toUpperCase());
                     pst.setString(22, fath.getText().toUpperCase());
                      pst.setString(23, ((JTextField)caldor.getDateEditor().getUiComponent()).getText());
                         addresadd();
                         
                      pst.execute();
                     process=true;
                        if (process==true){
                        JOptionPane.showMessageDialog(null,"Resident Sucessfully Added!!!");
                      
            
         }      
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
            e.printStackTrace();
            
        }
                
                 //server write
   
           
               
       nullifier();
       new Dashboard().resident_table();
       lastname.setBackground(new java.awt.Color(255, 255, 255));
        firstname.setBackground(new java.awt.Color(255, 255, 255));
        calbday.setBackground(new java.awt.Color(240, 240, 240));
         caldor.setBackground(new java.awt.Color(240, 240, 240));
        
      }else
          JOptionPane.showMessageDialog(null, "Please Review Your Inputs!");     
      age.setText(null);
   
      }

}

  void addresadd(){
         try
            {
             
                ps=conn.prepareStatement("Insert into tbl_residentaddress (addr_id  ,house_no, purok, barangay , municipality , province)"
                      + "Values (?,?,?,?,?,?)");
             ps.setInt(1, auto_id);
             ps.setString(2, houseno.getText().toUpperCase());
             ps.setString(3, purok.getText().toUpperCase());
             ps.setString(4, brgy.getText().toUpperCase());
             ps.setString(5, muni.getText().toUpperCase());
             ps.setString(6, prov.getText().toUpperCase());
            
             ps.execute();
           
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }
  }
void getage(){
     String birthdate = ((JTextField)calbday.getDateEditor().getUiComponent()).getText();
     String dob[] = birthdate.split("-");
     
     System.out.print(dob[0]);
   
        int year = Integer.parseInt(dob[0]);
   int month = Integer.parseInt(dob[1]);
    int day = Integer.parseInt(dob[2]);
    LocalDate selectedDate = LocalDate.of(year, month,day);
    LocalDate currentDate = LocalDate.now();
  
    int resultYear = Period.between(selectedDate,currentDate).getYears();
 String currentage = Integer.toString(resultYear);
   age.setText(currentage);
}




 
 
  
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
            java.util.logging.Logger.getLogger(addResident.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addResident.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addResident.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addResident.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addResident().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel age;
    private javax.swing.JLabel bbb2;
    private javax.swing.JLabel bbb3;
    private javax.swing.JLabel bbb4;
    private javax.swing.JLabel bbb5;
    private javax.swing.JLabel bbb6;
    private JTextFieldPersonalizado.JCTextField brgy;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private com.toedter.calendar.JDateChooser calbday;
    private com.toedter.calendar.JDateChooser caldor;
    private javax.swing.JRadioButton cgradio;
    private javax.swing.JComboBox<String> combocivilstatus;
    private JTextFieldPersonalizado.JCTextField contact;
    private javax.swing.JRadioButton curadio;
    private javax.swing.JRadioButton elemradio;
    private javax.swing.JRadioButton empradio;
    private JTextFieldPersonalizado.JCTextField fath;
    private javax.swing.JRadioButton femaleradio;
    private JTextFieldPersonalizado.JCTextField firstname;
    private JTextFieldPersonalizado.JCTextField h;
    private javax.swing.JLabel headlabel2;
    private javax.swing.JLabel headlabel4;
    private javax.swing.JLabel headlabel5;
    private javax.swing.JLabel headlabel6;
    private javax.swing.JLabel headlabel7;
    private javax.swing.JLabel headlabel9;
    private JTextFieldPersonalizado.JCTextField houseno;
    private javax.swing.JRadioButton hsradio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator14;
    private javax.swing.JSeparator jSeparator15;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator18;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTextField jTextField1;
    private JTextFieldPersonalizado.JCTextField lastname;
    private javax.swing.JRadioButton maleradio;
    private JTextFieldPersonalizado.JCTextField middlename;
    private JTextFieldPersonalizado.JCTextField moth;
    private JTextFieldPersonalizado.JCTextField muni;
    private JTextFieldPersonalizado.JCTextField nationality;
    private javax.swing.JRadioButton noneradio;
    private javax.swing.JComboBox<String> noofchild;
    private JTextFieldPersonalizado.JCTextField permanentadd;
    private JTextFieldPersonalizado.JCTextField prov;
    private JTextFieldPersonalizado.JCTextField purok;
    private JTextFieldPersonalizado.JCTextField religion;
    private javax.swing.JComboBox<String> resstat;
    private javax.swing.JRadioButton selradio;
    private JTextFieldPersonalizado.JCTextField spouse;
    private javax.swing.JComboBox<String> suffix;
    private JTextFieldPersonalizado.JCTextField tfpob;
    private javax.swing.JRadioButton uneradio;
    private JTextFieldPersonalizado.JCTextField w;
    // End of variables declaration//GEN-END:variables
}
