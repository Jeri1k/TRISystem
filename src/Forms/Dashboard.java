
package Forms;

import Class.DBConnection;
import java.awt.BorderLayout;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Admin
 */
public class Dashboard extends javax.swing.JFrame {

     Color DefaultColor , ClickedColor,Hover;
    public Dashboard() {
        initComponents();
                 dt();
                 chart();
                 viewofficial_table();
        time();  
        official_table();
        household_table();
        resident_table();
        blotter_table();
        clear();
        totalresident();
        totalhousehold();
        totalofficial();
        clear();
       householdmember.setVisible(false);
       btnaddmem.setVisible(false);
        
        editres.setVisible(false);
        
         addwitness.setVisible(false);
          Addculpritpnl.setVisible(false);
        witnessaddbtn.setVisible(false);
        addculpritbtn.setVisible(false);
        resdelete.setVisible(false);
        /*GUI Color when clicked*/
        
        DefaultColor = new Color(240,240,240);
        ClickedColor = new Color(240,151,57);
         
        Hover = new Color(153,153,153);
      
        
    }
 Connection conn = new DBConnection().connect();
    PreparedStatement ps;
     ResultSet rs;
 
     
    void chart(){
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("MALE", new Integer(10));
        dataset.setValue("FEMALE", new Integer(20));
        JFreeChart chart = ChartFactory.createPieChart("Pie Chart", dataset,true,true,true );
       ChartPanel panel = new ChartPanel(chart);
        
       
        pieChart1.add(panel, BorderLayout.CENTER);
         pieChart1.setLayout(new java.awt.BorderLayout());
         pieChart1.validate();
         pieChart1.setVisible(true);
    }
     
    void dt(){
       Date d = new Date();
       SimpleDateFormat sdf = new SimpleDateFormat("E M/d/y");
       String dd = sdf.format(d);
       date.setText(dd);
       
   }
   
    Timer t; 
    SimpleDateFormat sd;
     void time(){
     
       
       
       t = new Timer(0, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
              
              Date dt = new Date();
              sd = new SimpleDateFormat("hh:mm:ss a");
              String tt = sd.format(dt);
              time.setText(tt);
              
          }
       });
       
       t.start();
              
   }
     
  void totalresident(){
       try
        {
            ps=conn.prepareStatement("SELECT COUNT(*) FROM tbl_resident");
            rs=ps.executeQuery();
           
            while(rs.next()){
                 String total = rs.getString("COUNT(*)");
                    
                
                     totalres.setText(total);
                
            }
             
           
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
  }   
     
    void totalhousehold(){
         try
        {
            ps=conn.prepareStatement("SELECT COUNT(*) FROM tbl_household");
            rs=ps.executeQuery();
           
            while(rs.next()){
                String total = rs.getString("COUNT(*)");
                    
                
                     totalhousehold.setText(total);
                
            }
             
           
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
        
    }  
      void totalofficial(){
           try
        {
            ps=conn.prepareStatement("SELECT COUNT(*) FROM tbl_user");
            rs=ps.executeQuery();
           
            while(rs.next()){
                 String total = rs.getString("COUNT(*)");
                    
               
                     totalofficial.setText(total);
                
            }
             
           
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
      }
     
  void viewofficial_table()
    {
        try
        {
            ps=conn.prepareStatement("Select user_id , username, fullname, usertype from tbl_user ");
            rs=ps.executeQuery();
            official1.setModel(DbUtils.resultSetToTableModel(rs));
            
            
            headerofficial();
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }    
  void official_table()
    {
        try
        {
            ps=conn.prepareStatement("Select user_id , username, fullname, usertype from tbl_user ");
            rs=ps.executeQuery();
            official.setModel(DbUtils.resultSetToTableModel(rs));
            
            headerofficial();
            
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
  void household_table()
    {
        try
        {
            ps=conn.prepareStatement("Select family_id, family_headname, ownership, family_fulladd, date_reg,date_update from tbl_household ");
            rs=ps.executeQuery();
            household.setModel(DbUtils.resultSetToTableModel(rs));
             editres.setVisible(false);
             headerfamily();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
  void resident_table()
    {
        try
        {
            ps=conn.prepareStatement("SELECT resident_id, concat(last_name,' ', first_name,' ', middle_name) as fullname , resident_stat, date_reg, date_edited from tbl_resident;");
            rs=ps.executeQuery();
            resident.setModel(DbUtils.resultSetToTableModel(rs));
            headerresident();
             editres.setVisible(false);
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
  void blotter_table()
    {
        try
        {
             String casestatus =(String) blotstatus.getSelectedItem();
            ps=conn.prepareStatement("Select case_no, case_name, case_stat , date_of_inci, time_of_inci, datetime_created from tbl_blotter where case_stat = '"+casestatus+"'");
            rs=ps.executeQuery();
            blotter.setModel(DbUtils.resultSetToTableModel(rs));
             editblot.setVisible(false);
             headerblotter();
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
  
   void showinforesident(){
        try{ 
              
         String id = resid.getText();
           
            
            String query= "Select * from tbl_resident where resident_id ='"+id+"'" ; 
               
           ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
           
           while (rs.next())
           {
               String rid = rs.getString("resident_id");
               
                String lastname = rs.getString("last_name");
                 String firstname = rs.getString("first_name");
                  String middlename = rs.getString("middle_name");
                   int a = rs.getInt("age");
                    String s = rs.getString("Sex");
                    String birth = rs.getString("date_of_birth");
                     String birthplace = rs.getString("place_of_birth");
                      String height= rs.getString("height");
                       String weight = rs.getString("weight");
                        String con = rs.getString("contact_no");
                        
                          
                           String perm = rs.getString("permanent_add");
                           String stat = rs.getString("resident_stat");
                            
                              String educatt = rs.getString("highest_educ_attain");
                               String occu = rs.getString("occupation");
                                 String civil = rs.getString("civil_status");
                                  String sname = rs.getString("spouse_name");
                                   String child = rs.getString("no_of_child");
                                    String reli = rs.getString("religion");
                                     String nation = rs.getString("nationality");
                                      String moth = rs.getString("mother_name");
                                       String fath = rs.getString("father_name");
                                        String ag =String.valueOf(a);
                                       
                                            resid.setText(rid);                                                                                                             
                                        lname.setText(lastname);
                                        fname.setText(firstname);
                                        mname.setText(middlename);
                                          age.setText(ag);
                                          sex.setText(s);
                                          dob.setText(birth);
                                          pob.setText(birthplace);
                                          h.setText(height);
                                           w.setText(weight);
                                           contact.setText(con);
                                           permanentaddr.setText(perm);
                                          
                                           occupation.setText(occu);
                                           religion.setText(reli);
                                           civilstatus.setText(civil);
                                           status.setText(stat);
                                           
                                           nationality.setText(nation);
                                           mother.setText(moth);
                                           father.setText(fath);}
                 }catch (Exception e){
                       
                        JOptionPane.showMessageDialog(this, e);
                 }
    }
  
  
  
  void clear(){
                            // resident area
                            usernameedit.setText("");
                                    passedit.setText("");
                                    positionedit.setText("");
                            offid.setText("");
                            offnameedit.setText("");
                            addofficialpnl.setVisible(false);
                            deleteofficial.setVisible(false);
                            updateblot.setVisible(false);
                                closecase.setVisible(false);
                                       deleteblot.setVisible(false);
                                            
                            witnessaddbtn.setVisible(false);
                             addculpritbtn.setVisible(false);
                                            updatehouse.setVisible(false);
                                                editblot.setVisible(false);
                                             deletehouse.setVisible(false);
                                            editres.setVisible(false);
                                            resdelete.setVisible(false);
                                             editofficial.setVisible(false);
                                              edithouse.setVisible(false);
                                               deleteblot.setVisible(false);
                                          resid.setText(null);                                                                                                             
                                        lname.setText(null);
                                        fname.setText(null);
                                        mname.setText(null);
                                          age.setText(null);
                                          sex.setText(null);
                                          dob.setText(null);
                                          pob.setText(null);
                                          h.setText(null);
                                           w.setText(null);
                                           contact.setText(null);
                                           permanentaddr.setText(null);
                                          
                                           occupation.setText(null);
                                           religion.setText(null);
                                           civilstatus.setText(null);
                                           status.setText(null);
                                           status.setText(null);
                                           nationality.setText(null);
                                           mother.setText(null);
                                           father.setText(null);
                                           searchresident.setText(null);
                                      //household area
                                  fid.setText(null);
                                  headname.setText(null);
                                  spousename.setText(null);
                                  ownership.setText(null);
                                  famadd.setText(null);
                                  btnaddmem.setVisible(false);
                                  householdmember.setVisible(false);
                                           
  }
static public class HeaderColor extends DefaultTableCellRenderer 
    {
        public HeaderColor() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            setBackground(new Color(10, 15, 83));
            setForeground(Color.WHITE);
            setPreferredSize(new Dimension(0, 25));
              
            setFont(new Font("Century Gothic", Font.BOLD, 12));
            setHorizontalAlignment(JLabel.LEADING);
            return this;
        }
    }
  void headerfamily(){
      household.getTableHeader().setDefaultRenderer(new HeaderColor());
        //Table Header
        household.getColumnModel().getColumn(0).setHeaderValue("ID");
        household.getColumnModel().getColumn(1).setHeaderValue("FAMILY HEAD");
       
 
         household.getColumnModel().getColumn(2).setHeaderValue("OWNERSHIP");
            household.getColumnModel().getColumn(3).setHeaderValue(" FAMILY FULL ADDRESS"); 
            
            household.getColumnModel().getColumn(4).setHeaderValue(" DATE REGISTED"); 
           household.getColumnModel().getColumn(5).setHeaderValue(" DATE EDITED");
        
        
        //Table Width
        household.getColumnModel().getColumn(0).setPreferredWidth(80);
        household.getColumnModel().getColumn(1).setPreferredWidth(200);
        household.getColumnModel().getColumn(2).setPreferredWidth(200);
        household.getColumnModel().getColumn(3).setPreferredWidth(200);
        household.getColumnModel().getColumn(4).setPreferredWidth(200);
        household.getColumnModel().getColumn(5).setPreferredWidth(200);
  }
   void headerofficial()
    {
        official.getTableHeader().setDefaultRenderer(new HeaderColor());
        //Table Header
        official.getColumnModel().getColumn(0).setHeaderValue("USER ID");
        official.getColumnModel().getColumn(1).setHeaderValue("USERNAME");
        official.getColumnModel().getColumn(2).setHeaderValue("FULL NAME");
        official.getColumnModel().getColumn(3).setHeaderValue("USER TYPE");  
      
        official1.getTableHeader().setDefaultRenderer(new HeaderColor());
        //Table Header
        official1.getColumnModel().getColumn(0).setHeaderValue("USER ID");
        official1.getColumnModel().getColumn(1).setHeaderValue("USERNAME");
        official1.getColumnModel().getColumn(2).setHeaderValue("FULL NAME");
        official1.getColumnModel().getColumn(3).setHeaderValue("USER TYPE");  
        //Table Width
        official.getColumnModel().getColumn(0).setPreferredWidth(80);
        official.getColumnModel().getColumn(1).setPreferredWidth(150);
        official.getColumnModel().getColumn(2).setPreferredWidth(150);
        official.getColumnModel().getColumn(3).setPreferredWidth(150);
        official1.getColumnModel().getColumn(0).setPreferredWidth(80);
        official1.getColumnModel().getColumn(1).setPreferredWidth(150);
        official1.getColumnModel().getColumn(2).setPreferredWidth(150);
        official1.getColumnModel().getColumn(3).setPreferredWidth(150);
        
    }
 void headerresident()
    {
        resident.getTableHeader().setDefaultRenderer(new HeaderColor());
        //Table Header
        resident.getColumnModel().getColumn(0).setHeaderValue("ID");
        resident.getColumnModel().getColumn(1).setHeaderValue("FULL NAME");
       
 
         resident.getColumnModel().getColumn(2).setHeaderValue(" RESIDENT STATUS");
            resident.getColumnModel().getColumn(3).setHeaderValue(" DATE REGISTERED"); 
            resident.getColumnModel().getColumn(4).setHeaderValue(" DATE EDITED"); 
           
        
        
        //Table Width
        resident.getColumnModel().getColumn(0).setPreferredWidth(80);
        resident.getColumnModel().getColumn(1).setPreferredWidth(200);
        resident.getColumnModel().getColumn(2).setPreferredWidth(200);
        resident.getColumnModel().getColumn(3).setPreferredWidth(200);
        resident.getColumnModel().getColumn(4).setPreferredWidth(200);
       
        
        
        
    }
 void headerblotter(){
     blotter.getTableHeader().setDefaultRenderer(new HeaderColor());
        //Table Header
        blotter.getColumnModel().getColumn(0).setHeaderValue("CASE NO.");
        blotter.getColumnModel().getColumn(1).setHeaderValue("CASE NAME");
       
 
         blotter.getColumnModel().getColumn(2).setHeaderValue(" CASE STATUS");
            blotter.getColumnModel().getColumn(3).setHeaderValue(" DATE INCIDENT"); 
            blotter.getColumnModel().getColumn(4).setHeaderValue(" TIME INCIDENT"); 
            blotter.getColumnModel().getColumn(5).setHeaderValue(" DATETIME CREATED"); 
        
        
        //Table Width
        blotter.getColumnModel().getColumn(0).setPreferredWidth(80);
        blotter.getColumnModel().getColumn(1).setPreferredWidth(100);
        blotter.getColumnModel().getColumn(2).setPreferredWidth(100);
        blotter.getColumnModel().getColumn(3).setPreferredWidth(100);
        blotter.getColumnModel().getColumn(4).setPreferredWidth(100);
         blotter.getColumnModel().getColumn(5).setPreferredWidth(100);
 }
 void searchresident(String str){
    DefaultTableModel model =(DefaultTableModel) resident.getModel(); 
    TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
    resident.setRowSorter(trs);
    trs.setRowFilter(RowFilter.regexFilter(str));
 }  
 void searchblotter(String str){
    DefaultTableModel model =(DefaultTableModel) blotter.getModel(); 
    TableRowSorter<DefaultTableModel> trs = new TableRowSorter<>(model);
    blotter.setRowSorter(trs);
    trs.setRowFilter(RowFilter.regexFilter(str));
 }  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel45 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnresident = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        btnblotter = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        btnofficials = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        btnreports = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        btnsetting = new javax.swing.JLabel();
        btnsetting1 = new javax.swing.JLabel();
        btnhousehold = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        dashboard = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTabbedPane = new javax.swing.JTabbedPane();
        DASHBOARD = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        totalhousehold = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        totalres = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        totalofficial = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        official = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        pieChart1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        RESIDENT = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        sex = new javax.swing.JTextField();
        dob = new javax.swing.JTextField();
        pob = new javax.swing.JTextField();
        h = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        w = new javax.swing.JTextField();
        jLabel47 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        age = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        permanentaddr = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        jTextField31 = new javax.swing.JTextField();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jTextField34 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        lname = new javax.swing.JTextField();
        resid = new javax.swing.JTextField();
        fname = new javax.swing.JTextField();
        mname = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        searchresident = new javax.swing.JTextField();
        resdelete = new javax.swing.JButton();
        addres = new javax.swing.JButton();
        editres = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        father = new javax.swing.JTextField();
        mother = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        nationality = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        civilstatus = new javax.swing.JTextField();
        occupation = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        religion = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        residentpanel = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        resident = new javax.swing.JTable();
        btnrefreshresi = new javax.swing.JButton();
        BLOTTER = new javax.swing.JPanel();
        Addculpritpnl = new javax.swing.JPanel();
        pnlAddmember1 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        headlabel8 = new javax.swing.JLabel();
        culpname = new JTextFieldPersonalizado.JCTextField();
        bbb8 = new javax.swing.JLabel();
        btnaddculprit = new javax.swing.JButton();
        bbb10 = new javax.swing.JLabel();
        culaddress = new JTextFieldPersonalizado.JCTextField();
        bbb11 = new javax.swing.JLabel();
        culpritdesc = new JTextFieldPersonalizado.JCTextField();
        addwitness = new javax.swing.JPanel();
        pnlAddmember2 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        headlabel9 = new javax.swing.JLabel();
        witname = new JTextFieldPersonalizado.JCTextField();
        bbb12 = new javax.swing.JLabel();
        btnaddwitness = new javax.swing.JButton();
        bbb13 = new javax.swing.JLabel();
        witaddr = new JTextFieldPersonalizado.JCTextField();
        blooterbody = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        casenotf = new javax.swing.JLabel();
        bbb20 = new javax.swing.JLabel();
        bbb25 = new javax.swing.JLabel();
        datecreate = new javax.swing.JLabel();
        bbb28 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        casedesc = new javax.swing.JTextArea();
        casenametf = new javax.swing.JTextField();
        placetf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        bbb33 = new javax.swing.JLabel();
        bbb30 = new javax.swing.JLabel();
        casestat = new javax.swing.JLabel();
        bbb34 = new javax.swing.JLabel();
        bbb37 = new javax.swing.JLabel();
        bbb39 = new javax.swing.JLabel();
        witnesssp = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        witnesstable = new javax.swing.JTable();
        culsp = new javax.swing.JScrollPane();
        jScrollPane11 = new javax.swing.JScrollPane();
        culprittable = new javax.swing.JTable();
        bbb40 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        bbb26 = new javax.swing.JLabel();
        cadd2 = new javax.swing.JTextField();
        complainant2 = new javax.swing.JTextField();
        bbb27 = new javax.swing.JLabel();
        witnessaddbtn = new javax.swing.JButton();
        addculpritbtn = new javax.swing.JButton();
        bbb36 = new javax.swing.JLabel();
        casename1 = new javax.swing.JLabel();
        casename2 = new javax.swing.JLabel();
        dateinci = new JTextFieldPersonalizado.JCTextField();
        timeinci = new JTextFieldPersonalizado.JCTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        blotstatus = new javax.swing.JComboBox<>();
        jPanel18 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        searchblot = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        addbtnblot = new javax.swing.JButton();
        deleteblot = new javax.swing.JButton();
        jLabel40 = new javax.swing.JLabel();
        editblot = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        blotter = new javax.swing.JTable();
        closecase = new javax.swing.JLabel();
        updateblot = new javax.swing.JButton();
        HOUSEHOLD = new javax.swing.JPanel();
        householdmember = new javax.swing.JPanel();
        pnlAddmember = new javax.swing.JPanel();
        jLabel57 = new javax.swing.JLabel();
        headlabel7 = new javax.swing.JLabel();
        housemem = new JTextFieldPersonalizado.JCTextField();
        bbb7 = new javax.swing.JLabel();
        btnaddfamilymember = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        fid = new javax.swing.JTextField();
        spousename = new javax.swing.JTextField();
        famadd = new javax.swing.JTextField();
        headname = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        householdmem = new javax.swing.JTable();
        jLabel39 = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        searchhousehold = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        deletehouse = new javax.swing.JButton();
        ownership = new javax.swing.JTextField();
        edithouse = new javax.swing.JButton();
        jLabel44 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        householdpanel = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        household = new javax.swing.JTable();
        btnaddmem = new javax.swing.JButton();
        updatehouse = new javax.swing.JButton();
        btnrefreshresi1 = new javax.swing.JButton();
        REPORTS = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        OFFICIAL = new javax.swing.JPanel();
        addofficialpnl = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel73 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        pass = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        offname = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        addoffbtn = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        position = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        addofficial = new javax.swing.JButton();
        deleteofficial = new javax.swing.JButton();
        editofficial = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        official1 = new javax.swing.JTable();
        jPanel17 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        offid = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        positionedit = new javax.swing.JTextField();
        offnameedit = new javax.swing.JTextField();
        usernameedit = new javax.swing.JTextField();
        passedit = new javax.swing.JTextField();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();

        jLabel45.setText("jLabel45");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1343, 755));
        setMinimumSize(new java.awt.Dimension(1343, 755));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1343, 755));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 153, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(51, 153, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        time.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jPanel10.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 20, 180, 30));

        date.setFont(new java.awt.Font("Bookman Old Style", 1, 18)); // NOI18N
        jPanel10.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 0, 210, 30));

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 1050, 60));

        jPanel4.setBackground(new java.awt.Color(51, 102, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnresident.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnresident.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnresidentMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnresidentMousePressed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-resident-50.png"))); // NOI18N
        jLabel25.setText("Residents");

        javax.swing.GroupLayout btnresidentLayout = new javax.swing.GroupLayout(btnresident);
        btnresident.setLayout(btnresidentLayout);
        btnresidentLayout.setHorizontalGroup(
            btnresidentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnresidentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(46, 46, 46))
        );
        btnresidentLayout.setVerticalGroup(
            btnresidentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnresidentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addContainerGap())
        );

        btnblotter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnblotter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnblotterMousePressed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons Census-50.png"))); // NOI18N
        jLabel26.setText("Blotter");
        jLabel26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout btnblotterLayout = new javax.swing.GroupLayout(btnblotter);
        btnblotter.setLayout(btnblotterLayout);
        btnblotterLayout.setHorizontalGroup(
            btnblotterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnblotterLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        btnblotterLayout.setVerticalGroup(
            btnblotterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo.png"))); // NOI18N

        btnofficials.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnofficials.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnofficialsMousePressed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-admin-settings-male-50.png"))); // NOI18N
        jLabel30.setText("Officials");

        javax.swing.GroupLayout btnofficialsLayout = new javax.swing.GroupLayout(btnofficials);
        btnofficials.setLayout(btnofficialsLayout);
        btnofficialsLayout.setHorizontalGroup(
            btnofficialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnofficialsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(63, 63, 63))
        );
        btnofficialsLayout.setVerticalGroup(
            btnofficialsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );

        btnreports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnreports.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnreportsMousePressed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-report-50.png"))); // NOI18N
        jLabel31.setText("Reports");

        javax.swing.GroupLayout btnreportsLayout = new javax.swing.GroupLayout(btnreports);
        btnreports.setLayout(btnreportsLayout);
        btnreportsLayout.setHorizontalGroup(
            btnreportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnreportsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addGap(63, 63, 63))
        );
        btnreportsLayout.setVerticalGroup(
            btnreportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );

        btnsetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-log-out-50.png"))); // NOI18N
        btnsetting.setToolTipText("Log Out");
        btnsetting.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsetting.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnsettingMouseClicked(evt);
            }
        });

        btnsetting1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-info-60.png"))); // NOI18N
        btnsetting1.setText("ad");
        btnsetting1.setToolTipText("DEVELOPED BY  NUEST-MGT BSIT-4F STUDENTS JERIMIE CABAHEL - DAN JERICHO CASTILLO - EDWARD DELA CRUZ");
        btnsetting1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnsetting1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        btnhousehold.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnhousehold.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnhouseholdMousePressed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-house-50.png"))); // NOI18N
        jLabel28.setText("Households");

        javax.swing.GroupLayout btnhouseholdLayout = new javax.swing.GroupLayout(btnhousehold);
        btnhousehold.setLayout(btnhouseholdLayout);
        btnhouseholdLayout.setHorizontalGroup(
            btnhouseholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnhouseholdLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(34, 34, 34))
        );
        btnhouseholdLayout.setVerticalGroup(
            btnhouseholdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
        );

        dashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                dashboardMousePressed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-dashboard-50.png"))); // NOI18N
        jLabel29.setText("Dashboard");

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(24, 24, 24))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnblotter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnresident, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnofficials, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnreports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnsetting)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsetting1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))
                    .addComponent(btnhousehold, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dashboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(btnresident, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnhousehold, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnblotter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnofficials, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(btnreports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnsetting1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnsetting, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(21, 21, 21))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 2, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setOpaque(false);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/tallogo100px.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setText("Barangay Tabacao Talavera Nueva Ecija");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logo100px.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Resident Information System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(287, 287, 287)))
                .addComponent(jLabel7))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 1050, -1));

        jTabbedPane.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPane.setEnabled(false);
        jTabbedPane.setInheritsPopupMenu(true);

        DASHBOARD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel2.setText("Dashboard");
        DASHBOARD.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 40));

        jPanel12.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel12.setToolTipText("Total Number of Households");

        jLabel11.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-exterior-30.png"))); // NOI18N
        jLabel11.setText("Households");
        jLabel11.setToolTipText("Total Number of Households");

        totalhousehold.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalhousehold, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalhousehold, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addContainerGap())
        );

        DASHBOARD.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 160, 90));

        jPanel13.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel13.setToolTipText("Total Number of Residents");

        jLabel12.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-resident-30.png"))); // NOI18N
        jLabel12.setText("Residents");
        jLabel12.setToolTipText("Total Number of Residents");

        totalres.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(totalres, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalres, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addContainerGap())
        );

        DASHBOARD.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, -1, -1));

        jPanel14.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel14.setToolTipText("Total Number of Brgy. Officials");

        jLabel13.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-resident-30.png"))); // NOI18N
        jLabel13.setText("Officials");
        jLabel13.setToolTipText("Total Number of Brgy. Officials");

        totalofficial.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(totalofficial, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(totalofficial, javax.swing.GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        DASHBOARD.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, -1, -1));

        jPanel15.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        official.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        official.setEnabled(false);
        official.getTableHeader().setResizingAllowed(false);
        official.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(official);

        jPanel15.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 570, 160));

        jLabel14.setFont(new java.awt.Font("Georgia", 1, 14)); // NOI18N
        jLabel14.setText("List of Officials");
        jPanel15.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 30));

        DASHBOARD.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 590, 280));

        pieChart1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pieChart1.setMaximumSize(new java.awt.Dimension(350, 310));
        pieChart1.setMinimumSize(new java.awt.Dimension(350, 310));
        pieChart1.setPreferredSize(new java.awt.Dimension(350, 310));

        javax.swing.GroupLayout pieChart1Layout = new javax.swing.GroupLayout(pieChart1);
        pieChart1.setLayout(pieChart1Layout);
        pieChart1Layout.setHorizontalGroup(
            pieChart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pieChart1Layout.setVerticalGroup(
            pieChart1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        DASHBOARD.add(pieChart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel15.setText("__________________________________");
        DASHBOARD.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 1100, 120));

        jTabbedPane.addTab("", DASHBOARD);

        RESIDENT.setMaximumSize(new java.awt.Dimension(1100, 520));
        RESIDENT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel10.setText("Residents");
        RESIDENT.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 40));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel16.setText("__________________________________");
        RESIDENT.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -50, 1100, 120));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel59.setText("Personal Information");

        jLabel56.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel56.setText("Resident ID:");

        sex.setEditable(false);
        sex.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        dob.setEditable(false);
        dob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pob.setEditable(false);
        pob.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        h.setEditable(false);
        h.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        contact.setEditable(false);
        contact.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel46.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel46.setText("Last Name:");

        w.setEditable(false);
        w.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel47.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel47.setText("First Name:");

        jLabel63.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel63.setText("Age:");

        jLabel48.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel48.setText("Middle Name:");

        age.setEditable(false);
        age.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel49.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel49.setText("Sex:");

        permanentaddr.setEditable(false);
        permanentaddr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel50.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel50.setText("Date of Birth:");

        jLabel51.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel51.setText("Place of Birth:");

        jLabel52.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel52.setText("Height (FT):");

        jLabel53.setText("Weight (KG):");

        jLabel64.setText("Occupation:");

        jLabel54.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel54.setText("Contact No.:");

        jLabel55.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel55.setText("Permanent Address:");

        jLabel58.setText("Resident Status:");

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel67.setText("Personal Information");

        lname.setEditable(false);
        lname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        resid.setEditable(false);
        resid.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        resid.setBorder(null);

        fname.setEditable(false);
        fname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        mname.setEditable(false);
        mname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel43.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel43.setText("TBC-000");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel59))
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel67)
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(mname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(pob, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(h, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(w, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel54, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel55))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(permanentaddr)
                                    .addComponent(contact, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)))
                            .addGroup(jPanel20Layout.createSequentialGroup()
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel20Layout.createSequentialGroup()
                                        .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel43)))
                                .addGap(2, 2, 2)
                                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(resid, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel43)
                    .addComponent(resid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel47))
                    .addComponent(fname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel48))
                    .addComponent(mname, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel49))
                    .addComponent(sex, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel50))
                    .addComponent(dob, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel63))
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel51))
                    .addComponent(pob, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel52))
                    .addComponent(h, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel53))
                    .addComponent(w, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel54))
                    .addComponent(contact, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel55))
                    .addComponent(permanentaddr, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel58))
                    .addComponent(jTextField31, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel20Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel64))
                    .addComponent(jTextField34, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel59)
                .addGap(427, 427, 427))
        );

        RESIDENT.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 350, 480));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel37.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-search-30.png"))); // NOI18N
        jPanel2.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        searchresident.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchresidentActionPerformed(evt);
            }
        });
        searchresident.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchresidentKeyReleased(evt);
            }
        });
        jPanel2.add(searchresident, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 330, 30));

        RESIDENT.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 390, 50));

        resdelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-remove-30.png"))); // NOI18N
        resdelete.setText("Delete");
        resdelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resdeleteActionPerformed(evt);
            }
        });
        RESIDENT.add(resdelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 450, 100, 50));

        addres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/addnewres 30px.png"))); // NOI18N
        addres.setText("Add");
        addres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addresActionPerformed(evt);
            }
        });
        RESIDENT.add(addres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 100, 50));

        editres.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-edit-30.png"))); // NOI18N
        editres.setText("Edit");
        editres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editresActionPerformed(evt);
            }
        });
        RESIDENT.add(editres, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 450, 90, 50));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Parents Name");

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel6.setText("Mothers Name:");

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel8.setText("Fathers Name:");

        father.setEditable(false);
        father.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        mother.setEditable(false);
        mother.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel60.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel60.setText("Nationality:");

        nationality.setEditable(false);
        nationality.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        nationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nationalityActionPerformed(evt);
            }
        });

        jLabel66.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel66.setText("Resident Status:");

        status.setEditable(false);
        status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        civilstatus.setEditable(false);
        civilstatus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        occupation.setEditable(false);
        occupation.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel61.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel61.setText("Civil Status:");

        jLabel62.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel62.setText("Occupation:");

        jLabel65.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        jLabel65.setText("Religion:");

        religion.setEditable(false);
        religion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(father))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel19Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mother, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel66, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nationality)
                                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel61)
                                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(civilstatus, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(occupation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(religion, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addComponent(jLabel41)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel65)
                            .addComponent(religion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61)
                            .addComponent(civilstatus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(occupation, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel62))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel66)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(nationality, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mother, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(father, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel41))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        RESIDENT.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(767, 40, 280, 480));

        residentpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        resident.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        resident.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                residentMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(resident);

        residentpanel.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 630, 370));

        jScrollPane2.setViewportView(residentpanel);

        RESIDENT.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 390, 310));

        btnrefreshresi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-refresh-20.png"))); // NOI18N
        btnrefreshresi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnrefreshresi.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        btnrefreshresi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshresiActionPerformed(evt);
            }
        });
        RESIDENT.add(btnrefreshresi, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, 30, 30));

        jTabbedPane.addTab("", RESIDENT);

        BLOTTER.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Addculpritpnl.setBackground(new java.awt.Color(255, 255, 255));
        Addculpritpnl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Addculpritpnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAddmember1.setBackground(new java.awt.Color(59, 89, 152));
        pnlAddmember1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlAddmember1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-close-window-30.png"))); // NOI18N
        jLabel68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel68MouseClicked(evt);
            }
        });
        pnlAddmember1.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 30, 30));

        headlabel8.setBackground(new java.awt.Color(255, 255, 255));
        headlabel8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        headlabel8.setForeground(new java.awt.Color(255, 255, 255));
        headlabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-culprit20.png"))); // NOI18N
        headlabel8.setText("Add Culprit");
        pnlAddmember1.add(headlabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

        Addculpritpnl.add(pnlAddmember1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 30));

        culpname.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        culpname.setPlaceholder("Culprit Name");
        culpname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                culpnameFocusLost(evt);
            }
        });
        culpname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                culpnameActionPerformed(evt);
            }
        });
        culpname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                culpnameKeyReleased(evt);
            }
        });
        Addculpritpnl.add(culpname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 170, -1));

        bbb8.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb8.setForeground(new java.awt.Color(102, 102, 102));
        bbb8.setText("Cullprit Name:");
        bbb8.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb8PropertyChange(evt);
            }
        });
        Addculpritpnl.add(bbb8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, 30));

        btnaddculprit.setText("Add");
        btnaddculprit.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnaddculprit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddculpritActionPerformed(evt);
            }
        });
        Addculpritpnl.add(btnaddculprit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 90, 40));

        bbb10.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb10.setForeground(new java.awt.Color(102, 102, 102));
        bbb10.setText("Cullprit Address:");
        bbb10.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb10PropertyChange(evt);
            }
        });
        Addculpritpnl.add(bbb10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 110, 30));

        culaddress.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        culaddress.setPlaceholder("Culprit Address");
        culaddress.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                culaddressFocusLost(evt);
            }
        });
        culaddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                culaddressActionPerformed(evt);
            }
        });
        culaddress.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                culaddressKeyReleased(evt);
            }
        });
        Addculpritpnl.add(culaddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 170, -1));

        bbb11.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb11.setForeground(new java.awt.Color(102, 102, 102));
        bbb11.setText("Cullprit Description:");
        bbb11.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb11PropertyChange(evt);
            }
        });
        Addculpritpnl.add(bbb11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 140, 30));

        culpritdesc.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        culpritdesc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                culpritdescFocusLost(evt);
            }
        });
        culpritdesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                culpritdescActionPerformed(evt);
            }
        });
        culpritdesc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                culpritdescKeyReleased(evt);
            }
        });
        Addculpritpnl.add(culpritdesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 400, 70));

        BLOTTER.add(Addculpritpnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 120, -1, 260));

        addwitness.setBackground(new java.awt.Color(255, 255, 255));
        addwitness.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addwitness.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAddmember2.setBackground(new java.awt.Color(59, 89, 152));
        pnlAddmember2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlAddmember2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-close-window-30.png"))); // NOI18N
        jLabel69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel69MouseClicked(evt);
            }
        });
        pnlAddmember2.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 30, 30));

        headlabel9.setBackground(new java.awt.Color(255, 255, 255));
        headlabel9.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        headlabel9.setForeground(new java.awt.Color(255, 255, 255));
        headlabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-witness-20.png"))); // NOI18N
        headlabel9.setText("Add Witness");
        pnlAddmember2.add(headlabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 160, 30));

        addwitness.add(pnlAddmember2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 30));

        witname.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        witname.setPlaceholder("Witness Name");
        witname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                witnameFocusLost(evt);
            }
        });
        witname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                witnameActionPerformed(evt);
            }
        });
        witname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                witnameKeyReleased(evt);
            }
        });
        addwitness.add(witname, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 170, -1));

        bbb12.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb12.setForeground(new java.awt.Color(102, 102, 102));
        bbb12.setText("Witness Name:");
        bbb12.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb12PropertyChange(evt);
            }
        });
        addwitness.add(bbb12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 110, 30));

        btnaddwitness.setText("Add");
        btnaddwitness.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnaddwitness.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddwitnessActionPerformed(evt);
            }
        });
        addwitness.add(btnaddwitness, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 90, 40));

        bbb13.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb13.setForeground(new java.awt.Color(102, 102, 102));
        bbb13.setText("Witness Address:");
        bbb13.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb13PropertyChange(evt);
            }
        });
        addwitness.add(bbb13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 110, 30));

        witaddr.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        witaddr.setPlaceholder("Witness Address");
        witaddr.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                witaddrFocusLost(evt);
            }
        });
        witaddr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                witaddrActionPerformed(evt);
            }
        });
        witaddr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                witaddrKeyReleased(evt);
            }
        });
        addwitness.add(witaddr, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 170, -1));

        BLOTTER.add(addwitness, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, 180));

        blooterbody.setPreferredSize(new java.awt.Dimension(982, 1000));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 255)));
        jPanel5.setMinimumSize(new java.awt.Dimension(980, 507));
        jPanel5.setName(""); // NOI18N
        jPanel5.setPreferredSize(new java.awt.Dimension(980, 507));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        casenotf.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        casenotf.setForeground(new java.awt.Color(102, 0, 0));
        casenotf.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                casenotfPropertyChange(evt);
            }
        });
        jPanel5.add(casenotf, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 80, 40));

        bbb20.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb20.setForeground(new java.awt.Color(102, 102, 102));
        bbb20.setText("Witness:");
        bbb20.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb20PropertyChange(evt);
            }
        });
        jPanel5.add(bbb20, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 210, 130, 30));

        bbb25.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb25.setForeground(new java.awt.Color(102, 102, 102));
        bbb25.setText("Case Description:");
        bbb25.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb25PropertyChange(evt);
            }
        });
        jPanel5.add(bbb25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 130, 30));

        datecreate.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        datecreate.setForeground(new java.awt.Color(102, 102, 102));
        datecreate.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                datecreatePropertyChange(evt);
            }
        });
        jPanel5.add(datecreate, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 360, 30));

        bbb28.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb28.setForeground(new java.awt.Color(102, 102, 102));
        bbb28.setText("Culprit:");
        bbb28.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb28PropertyChange(evt);
            }
        });
        jPanel5.add(bbb28, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 130, 30));

        casedesc.setEditable(false);
        casedesc.setColumns(20);
        casedesc.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        casedesc.setForeground(new java.awt.Color(51, 51, 51));
        casedesc.setRows(5);
        jScrollPane10.setViewportView(casedesc);

        jPanel5.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 930, 80));

        casenametf.setEditable(false);
        jPanel5.add(casenametf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 290, 30));

        placetf.setEditable(false);
        jPanel5.add(placetf, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 290, 30));
        jPanel5.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 1030, -1, -1));
        jPanel5.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 980, 20));
        jPanel5.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 360, 980, 10));

        bbb33.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb33.setForeground(new java.awt.Color(102, 102, 102));
        bbb33.setText("Date of Incident:");
        bbb33.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb33PropertyChange(evt);
            }
        });
        jPanel5.add(bbb33, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 60, 130, 30));

        bbb30.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb30.setForeground(new java.awt.Color(102, 102, 102));
        bbb30.setText("Time of Incident:");
        bbb30.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb30PropertyChange(evt);
            }
        });
        jPanel5.add(bbb30, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 110, 130, 30));

        casestat.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        casestat.setForeground(new java.awt.Color(102, 102, 102));
        casestat.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                casestatPropertyChange(evt);
            }
        });
        jPanel5.add(casestat, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 200, 40));

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
        jPanel5.add(bbb37, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 80, 40));

        bbb39.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb39.setForeground(new java.awt.Color(102, 102, 102));
        bbb39.setText("Caseno:");
        bbb39.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb39PropertyChange(evt);
            }
        });
        jPanel5.add(bbb39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 40));

        witnesstable.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        witnesstable.setForeground(new java.awt.Color(51, 51, 51));
        witnesstable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Witness", "Address"
            }
        ));
        witnesstable.setEnabled(false);
        witnesstable.setSelectionBackground(new java.awt.Color(255, 255, 204));
        witnesstable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        witnesstable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                witnesstableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(witnesstable);

        witnesssp.setViewportView(jScrollPane5);

        jPanel5.add(witnesssp, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 240, 320, 100));

        culprittable.setFont(new java.awt.Font("Verdana", 0, 11)); // NOI18N
        culprittable.setForeground(new java.awt.Color(51, 51, 51));
        culprittable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Culprit", "Address"
            }
        ));
        culprittable.setEnabled(false);
        culprittable.setSelectionBackground(new java.awt.Color(255, 255, 204));
        culprittable.setSelectionForeground(new java.awt.Color(0, 0, 0));
        culprittable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                culprittableMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(culprittable);

        culsp.setViewportView(jScrollPane11);

        jPanel5.add(culsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 240, 320, 100));

        bbb40.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb40.setForeground(new java.awt.Color(102, 102, 102));
        bbb40.setText("Date Created:");
        bbb40.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb40PropertyChange(evt);
            }
        });
        jPanel5.add(bbb40, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 160, 130, 30));
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
        jPanel5.add(bbb26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 130, 30));

        cadd2.setEditable(false);
        jPanel5.add(cadd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 300, 30));

        complainant2.setEditable(false);
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

        witnessaddbtn.setText("Add Witness");
        witnessaddbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                witnessaddbtnActionPerformed(evt);
            }
        });
        jPanel5.add(witnessaddbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 210, -1, -1));

        addculpritbtn.setText("Add Culprit");
        addculpritbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addculpritbtnActionPerformed(evt);
            }
        });
        jPanel5.add(addculpritbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 210, -1, -1));

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

        dateinci.setEditable(false);
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
        jPanel5.add(dateinci, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 70, 230, 30));

        timeinci.setEditable(false);
        timeinci.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        timeinci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeinciActionPerformed(evt);
            }
        });
        timeinci.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                timeinciKeyReleased(evt);
            }
        });
        jPanel5.add(timeinci, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 110, 230, 30));

        blooterbody.setViewportView(jPanel5);

        BLOTTER.add(blooterbody, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 630, 460));

        jLabel17.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel17.setText("Blotter");
        BLOTTER.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 40));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel18.setText("__________________________________");
        BLOTTER.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1090, 120));

        blotstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ACTIVE", "INACTIVE" }));
        blotstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blotstatusActionPerformed(evt);
            }
        });
        blotstatus.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                blotstatusPropertyChange(evt);
            }
        });
        BLOTTER.add(blotstatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 90, 30));

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-search-30.png"))); // NOI18N
        jPanel18.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        searchblot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchblotActionPerformed(evt);
            }
        });
        searchblot.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchblotKeyReleased(evt);
            }
        });
        jPanel18.add(searchblot, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 170, 30));

        jLabel70.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jLabel70.setText("STATUS:");
        jPanel18.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 50, 30));

        BLOTTER.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 400, 50));

        addbtnblot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/addnewres 30px.png"))); // NOI18N
        addbtnblot.setText("Add");
        addbtnblot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnblotActionPerformed(evt);
            }
        });
        BLOTTER.add(addbtnblot, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 100, 50));

        deleteblot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-remove-30.png"))); // NOI18N
        deleteblot.setText("Delete");
        BLOTTER.add(deleteblot, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 100, 50));

        jLabel40.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel40.setText("Case List");
        BLOTTER.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 170, 30));

        editblot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-edit-30.png"))); // NOI18N
        editblot.setText("Edit");
        editblot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editblotActionPerformed(evt);
            }
        });
        BLOTTER.add(editblot, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 100, 50));

        blotter.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Caseno", "Case Name", "Complainant", "Date&Time filed"
            }
        ));
        blotter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                blotterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                blotterMouseEntered(evt);
            }
        });
        jScrollPane7.setViewportView(blotter);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 603, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jScrollPane9.setViewportView(jPanel6);

        BLOTTER.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 169, 380, 290));

        closecase.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        closecase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-update-file-20.png"))); // NOI18N
        closecase.setText("Close Case");
        closecase.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        closecase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closecaseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                closecaseMouseEntered(evt);
            }
        });
        BLOTTER.add(closecase, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 110, 30));

        updateblot.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-save-30.png"))); // NOI18N
        updateblot.setText("Update");
        updateblot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateblotActionPerformed(evt);
            }
        });
        BLOTTER.add(updateblot, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 100, 50));

        jTabbedPane.addTab("", BLOTTER);

        HOUSEHOLD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        householdmember.setBackground(new java.awt.Color(255, 255, 255));
        householdmember.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        householdmember.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlAddmember.setBackground(new java.awt.Color(59, 89, 152));
        pnlAddmember.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlAddmember.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel57.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-close-window-30.png"))); // NOI18N
        jLabel57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel57MouseClicked(evt);
            }
        });
        pnlAddmember.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 30, 30));

        headlabel7.setBackground(new java.awt.Color(255, 255, 255));
        headlabel7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        headlabel7.setForeground(new java.awt.Color(255, 255, 255));
        headlabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/addnewres 30px.png"))); // NOI18N
        headlabel7.setText("Add Family Member");
        pnlAddmember.add(headlabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 30));

        householdmember.add(pnlAddmember, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 30));

        housemem.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        housemem.setPlaceholder("Family Member Name");
        housemem.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                housememFocusLost(evt);
            }
        });
        housemem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                housememActionPerformed(evt);
            }
        });
        housemem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                housememKeyReleased(evt);
            }
        });
        householdmember.add(housemem, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 170, -1));

        bbb7.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        bbb7.setForeground(new java.awt.Color(102, 102, 102));
        bbb7.setText("Family Member:");
        bbb7.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                bbb7PropertyChange(evt);
            }
        });
        householdmember.add(bbb7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 90, 30));

        btnaddfamilymember.setText("Add");
        btnaddfamilymember.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnaddfamilymember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddfamilymemberActionPerformed(evt);
            }
        });
        householdmember.add(btnaddfamilymember, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 80, 30));

        HOUSEHOLD.add(householdmember, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        jLabel19.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel19.setText("Household");
        HOUSEHOLD.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 40));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel20.setText("__________________________________");
        HOUSEHOLD.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1090, 100));

        jLabel32.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel32.setText("Family Spouse Name:");
        HOUSEHOLD.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, -1, 28));

        jLabel33.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel33.setText("TBCH-00");
        HOUSEHOLD.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, -1, 28));

        jLabel34.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel34.setText("Ownership:");
        HOUSEHOLD.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 100, 28));

        jLabel35.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel35.setText("Family Head Name:");
        HOUSEHOLD.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, 28));

        jLabel36.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel36.setText("Family Member List");
        HOUSEHOLD.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 330, -1, -1));

        fid.setEditable(false);
        fid.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        fid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fidActionPerformed(evt);
            }
        });
        HOUSEHOLD.add(fid, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 80, 180, 28));

        spousename.setEditable(false);
        spousename.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        spousename.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        HOUSEHOLD.add(spousename, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 180, 180, 28));

        famadd.setEditable(false);
        famadd.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        famadd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        famadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                famaddActionPerformed(evt);
            }
        });
        HOUSEHOLD.add(famadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, 180, 28));

        headname.setEditable(false);
        headname.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        headname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        headname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                headnameActionPerformed(evt);
            }
        });
        HOUSEHOLD.add(headname, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 130, 180, 28));

        householdmem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        householdmem.setEnabled(false);
        jScrollPane4.setViewportView(householdmem);

        HOUSEHOLD.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 480, 130));

        jLabel39.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel39.setText("Family Full Address:");
        HOUSEHOLD.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 280, -1, 28));

        jPanel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-search-30.png"))); // NOI18N
        jPanel22.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        searchhousehold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchhouseholdActionPerformed(evt);
            }
        });
        jPanel22.add(searchhousehold, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 400, 30));

        HOUSEHOLD.add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 470, 50));

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/addnewres 30px.png"))); // NOI18N
        jButton10.setText("Add");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        HOUSEHOLD.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 100, 50));

        deletehouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-remove-30.png"))); // NOI18N
        deletehouse.setText("Delete");
        deletehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletehouseActionPerformed(evt);
            }
        });
        HOUSEHOLD.add(deletehouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 460, 100, 50));

        ownership.setEditable(false);
        ownership.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ownership.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ownership.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ownershipActionPerformed(evt);
            }
        });
        HOUSEHOLD.add(ownership, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 230, 180, 28));

        edithouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-edit-30.png"))); // NOI18N
        edithouse.setText("Edit");
        edithouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edithouseActionPerformed(evt);
            }
        });
        HOUSEHOLD.add(edithouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 460, 90, 50));

        jLabel44.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel44.setText("Family ID:");
        HOUSEHOLD.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, 28));

        householdpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        household.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        household.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                householdMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                householdMouseReleased(evt);
            }
        });
        jScrollPane13.setViewportView(household);

        householdpanel.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -4, 630, 370));

        jScrollPane12.setViewportView(householdpanel);

        HOUSEHOLD.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 470, 290));

        btnaddmem.setBackground(new java.awt.Color(255, 255, 255));
        btnaddmem.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        btnaddmem.setText("Add  Member");
        btnaddmem.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnaddmem.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        btnaddmem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddmemActionPerformed(evt);
            }
        });
        HOUSEHOLD.add(btnaddmem, new org.netbeans.lib.awtextra.AbsoluteConstraints(911, 320, 100, 30));

        updatehouse.setBackground(new java.awt.Color(204, 204, 204));
        updatehouse.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-save-30.png"))); // NOI18N
        updatehouse.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        updatehouse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatehouseActionPerformed(evt);
            }
        });
        HOUSEHOLD.add(updatehouse, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 100, 40, 40));

        btnrefreshresi1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-refresh-20.png"))); // NOI18N
        btnrefreshresi1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnrefreshresi1.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        btnrefreshresi1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrefreshresi1ActionPerformed(evt);
            }
        });
        HOUSEHOLD.add(btnrefreshresi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 110, 30, 30));

        jTabbedPane.addTab("", HOUSEHOLD);

        REPORTS.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel23.setText("Reports / Documents");
        REPORTS.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, 40));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel24.setText("__________________________________");
        REPORTS.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1090, 120));

        jTabbedPane.addTab("", REPORTS);

        OFFICIAL.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addofficialpnl.setBackground(new java.awt.Color(204, 204, 255));
        addofficialpnl.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        addofficialpnl.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel73.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel73.setText("Username:");
        jPanel7.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 50));

        username.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel7.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 250, 30));

        addofficialpnl.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 390, 50));

        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel74.setText("Password:");
        jPanel8.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 50));

        pass.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel8.add(pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 250, 30));

        addofficialpnl.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 390, 50));

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel75.setText("Official Name:");
        jPanel9.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 110, 50));

        offname.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel9.add(offname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 250, 30));

        addofficialpnl.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 390, 50));

        jPanel11.setBackground(new java.awt.Color(51, 102, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel71.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel71.setText("Add Official");

        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-close-window-30.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(close)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel71, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        addofficialpnl.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 50));

        addoffbtn.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        addoffbtn.setText("Add new Official");
        addoffbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addoffbtnActionPerformed(evt);
            }
        });
        addofficialpnl.add(addoffbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 270, 40));

        jPanel16.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel72.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel72.setText("Position:");
        jPanel16.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 110, 50));

        position.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        position.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CAPTAIN", "SECRETARY", "SK", "COUNCILOR" }));
        jPanel16.add(position, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 250, 30));

        addofficialpnl.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 390, 50));

        OFFICIAL.add(addofficialpnl, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 80, -1, 420));

        jLabel21.setFont(new java.awt.Font("Georgia", 1, 24)); // NOI18N
        jLabel21.setText("Officials");
        OFFICIAL.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 40));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel22.setText("__________________________________");
        OFFICIAL.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 1090, 120));

        addofficial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/addnewres 30px.png"))); // NOI18N
        addofficial.setText("Add");
        addofficial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addofficialActionPerformed(evt);
            }
        });
        OFFICIAL.add(addofficial, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 100, 50));

        deleteofficial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-remove-30.png"))); // NOI18N
        deleteofficial.setText("Delete");
        OFFICIAL.add(deleteofficial, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 470, 100, 50));

        editofficial.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/icons8-edit-30.png"))); // NOI18N
        editofficial.setText("Edit");
        editofficial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editofficialActionPerformed(evt);
            }
        });
        OFFICIAL.add(editofficial, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 470, 90, 50));

        official1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        official1.setFocusable(false);
        official1.setRequestFocusEnabled(false);
        official1.getTableHeader().setResizingAllowed(false);
        official1.getTableHeader().setReorderingAllowed(false);
        official1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                official1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(official1);

        OFFICIAL.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 400, 370));

        jPanel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel76.setText("Username:");
        jPanel17.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 90, 40));

        jLabel77.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel77.setText("Password:");
        jPanel17.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 90, 40));

        offid.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jPanel17.add(offid, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 110, 40));

        jLabel79.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel79.setText("Position:");
        jPanel17.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 110, 50));

        positionedit.setEditable(false);
        positionedit.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel17.add(positionedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 250, 40));

        offnameedit.setEditable(false);
        offnameedit.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        offnameedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offnameeditActionPerformed(evt);
            }
        });
        jPanel17.add(offnameedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 250, 40));

        usernameedit.setEditable(false);
        usernameedit.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel17.add(usernameedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 250, 40));

        passedit.setEditable(false);
        passedit.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel17.add(passedit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 250, 40));

        jLabel80.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel80.setText("Official Name:");
        jPanel17.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 40));

        jLabel81.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel81.setText("User ID:");
        jPanel17.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 90, 40));

        OFFICIAL.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 410, 370));

        jTabbedPane.addTab("", OFFICIAL);

        jPanel3.add(jTabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(268, 174, 1050, 554));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1350, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnresidentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresidentMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnresidentMouseClicked

    private void btnresidentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnresidentMousePressed
        // TODO add your handling code here:
        resident();

    }//GEN-LAST:event_btnresidentMousePressed

    private void btnblotterMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnblotterMousePressed
        // TODO add your handling code here:
        blotter();

    }//GEN-LAST:event_btnblotterMousePressed

    private void btnofficialsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnofficialsMousePressed
        // TODO add your handling code here:
        official();

    }//GEN-LAST:event_btnofficialsMousePressed

    private void btnreportsMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnreportsMousePressed
        // TODO add your handling code here:
        reports();

    }//GEN-LAST:event_btnreportsMousePressed

    private void btnsettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnsettingMouseClicked
        // TODO add your handling code here:
        int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to Logout?","Log Out",JOptionPane.YES_NO_OPTION);
        if(confirmed == JOptionPane.YES_OPTION)
        {
            t.stop();
            new FormLogin().setVisible(true);
            dispose();

        }

    }//GEN-LAST:event_btnsettingMouseClicked
public void dashboard(){
     btnresident.setBackground(DefaultColor);
        btnblotter.setBackground(DefaultColor); 
        btnhousehold.setBackground(DefaultColor);
         
          btnofficials.setBackground(DefaultColor);
           btnreports.setBackground(DefaultColor);
           dashboard.setBackground(ClickedColor);
           jTabbedPane.setSelectedIndex(0);
}
 public void household(){
     dashboard.setBackground(DefaultColor);
        btnresident.setBackground(DefaultColor);
        btnblotter.setBackground(DefaultColor); 
        btnhousehold.setBackground(ClickedColor);
          btnofficials.setBackground(DefaultColor);
           btnreports.setBackground(DefaultColor);
           jTabbedPane.setSelectedIndex(3);
           official_table();
        household_table();
        resident_table();
        blotter_table();
        clear();
 }
 public void resident(){
     
        btnresident.setBackground(ClickedColor);
        btnblotter.setBackground(DefaultColor); 
        btnhousehold.setBackground(DefaultColor);
          dashboard.setBackground(DefaultColor);
          btnofficials.setBackground(DefaultColor);
           btnreports.setBackground(DefaultColor);
           jTabbedPane.setSelectedIndex(1);
        official_table();
        household_table();
        resident_table();
        blotter_table();
        clear();
         totalresident();
        totalhousehold();
        totalofficial();
 }
 public void blotter(){
      btnresident.setBackground(DefaultColor);
        btnblotter.setBackground(ClickedColor); 
        btnhousehold.setBackground(DefaultColor);
        dashboard.setBackground(DefaultColor);
          btnofficials.setBackground(DefaultColor);
           btnreports.setBackground(DefaultColor);
           jTabbedPane.setSelectedIndex(2);
           official_table();
        household_table();
        resident_table();
        blotter_table();
        clear();
 }
 public void reports(){
     dashboard.setBackground(DefaultColor);
        btnresident.setBackground(DefaultColor);
        btnblotter.setBackground(DefaultColor); 
        btnhousehold.setBackground(DefaultColor);
          btnofficials.setBackground(DefaultColor);
           btnreports.setBackground(ClickedColor);
           jTabbedPane.setSelectedIndex(4);
            official_table();
        household_table();
        resident_table();
        blotter_table();
        clear();
 }
 public void official(){
       dashboard.setBackground(DefaultColor);
        btnresident.setBackground(DefaultColor);
        btnblotter.setBackground(DefaultColor); 
        btnhousehold.setBackground(DefaultColor);
          btnofficials.setBackground(ClickedColor);
           btnreports.setBackground(DefaultColor);
           jTabbedPane.setSelectedIndex(5);
           official_table();
        household_table();
        resident_table();
        blotter_table();
        clear();
 }
    private void btnhouseholdMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhouseholdMousePressed
        // TODO add your handling code here:
        household();

    }//GEN-LAST:event_btnhouseholdMousePressed

    private void dashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMouseClicked
        dashboard();
        chart();
    }//GEN-LAST:event_dashboardMouseClicked

    private void dashboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardMousePressed
        dashboard();
       
    }//GEN-LAST:event_dashboardMousePressed

    private void searchresidentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchresidentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchresidentActionPerformed

    private void searchresidentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchresidentKeyReleased

        String searchString = searchresident.getText().toUpperCase();
        searchresident(searchString);
    }//GEN-LAST:event_searchresidentKeyReleased

    private void addresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addresActionPerformed
        // TODO add your handling code here:
       

        this.requestFocus(false);
        new addResident().setVisible(true);

    }//GEN-LAST:event_addresActionPerformed

    private void editresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editresActionPerformed
      
        String value = resid.getText();

        new Editresident(value).setVisible(true);
        this.requestFocus(false);

    }//GEN-LAST:event_editresActionPerformed

    private void nationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nationalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nationalityActionPerformed

    private void residentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_residentMouseClicked
        resid.setText(String.valueOf(resident.getValueAt(resident.getSelectedRow(),0)));
        editres.setVisible(true);
        resdelete.setVisible(true);
        showinforesident();
    }//GEN-LAST:event_residentMouseClicked

    private void searchblotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchblotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchblotActionPerformed

    private void addbtnblotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnblotActionPerformed
        // TODO add your handling code here:
        new addblotter().setVisible(true);
        
        
        
       
    }//GEN-LAST:event_addbtnblotActionPerformed
void showinfoblot(){
     String caseno = casenotf.getText();
        try{
     String query= "Select * from  tbl_blotter join tbl_complainant where case_no ='"+caseno+"'" ; 
               
           ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
           
           while (rs.next())
           {
               String casenum = rs.getString("case_no");
               
                String cname = rs.getString("case_name");
                 String cstat = rs.getString("case_stat");
                  String placeincid = rs.getString("place_of_inci");
                        String dateincid = rs.getString("date_of_inci");
                    String timeincid = rs.getString("time_of_inci");
                      String created = rs.getString("datetime_created");
                      String cdesc = rs.getString("case_desc");
                      String complname = rs.getString("complainant_name");
                      String compadr = rs.getString("complainant_addr");
                    
                         casenotf.setText(casenum);
                         casenametf.setText(cname);
                          placetf.setText(placeincid);
                         casestat.setText(cstat);
                         dateinci.setText(dateincid);
                             timeinci.setText(timeincid);
                                 datecreate.setText(created);    
                               casedesc.setText(cdesc);    
                                 complainant2.setText(complname);
                                 cadd2.setText(compadr);
                          
                         
           }
              }catch (Exception e){
                       
                        JOptionPane.showMessageDialog(this, e);
 }

     
     
}
    private void casenotfPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_casenotfPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_casenotfPropertyChange

    private void bbb20PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb20PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb20PropertyChange

    private void bbb25PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb25PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb25PropertyChange

    private void datecreatePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_datecreatePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_datecreatePropertyChange

    private void bbb28PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb28PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb28PropertyChange

    private void bbb33PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb33PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb33PropertyChange

    private void bbb30PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb30PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb30PropertyChange

    private void casestatPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_casestatPropertyChange
       
    }//GEN-LAST:event_casestatPropertyChange

    private void bbb34PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb34PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb34PropertyChange

    private void bbb37PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb37PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb37PropertyChange

    private void bbb39PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb39PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb39PropertyChange

    private void witnesstableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_witnesstableMouseClicked
       
    }//GEN-LAST:event_witnesstableMouseClicked

    private void culprittableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_culprittableMouseClicked
        

       
    }//GEN-LAST:event_culprittableMouseClicked

    private void bbb40PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb40PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb40PropertyChange

    private void bbb26PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb26PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb26PropertyChange

    private void bbb27PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb27PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb27PropertyChange

    private void fidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fidActionPerformed

    private void famaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_famaddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_famaddActionPerformed

    private void headnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_headnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_headnameActionPerformed

    private void searchhouseholdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchhouseholdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchhouseholdActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        new addhousehold().setVisible(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void ownershipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ownershipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ownershipActionPerformed

 void showinfohousehold(){
     try{ 
              
         String idhousehold = fid.getText();
           
            
            String query= "Select * from tbl_household where family_id ='"+idhousehold+"'" ; 
               
           ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
           
           while (rs.next())
           {
               String famid = rs.getString("family_id");
               
                String fhname = rs.getString("family_headname");
                 String fspouse = rs.getString("family_spousename");
                  String own = rs.getString("ownership");
                   
                    String fadd = rs.getString("family_fulladd");
                    
                         fid.setText(famid);
                         headname.setText(fhname);
                          spousename.setText(fspouse);
                         ownership.setText(own);
                         famadd.setText(fadd);
                          
                         
            
      
        
                          
       
              }}catch (Exception e){
                       
                        JOptionPane.showMessageDialog(this, e);
                 }
     
 }   
    private void householdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_householdMouseClicked
        
        fid.setText(String.valueOf(household.getValueAt(household.getSelectedRow(),0)));
        edithouse.setVisible(true);
        deletehouse.setVisible(true);
        showinfohousehold();
         showtblfammember();
        
         
        
        
        
    }//GEN-LAST:event_householdMouseClicked

    private void housememFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_housememFocusLost

    }//GEN-LAST:event_housememFocusLost

    private void housememActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_housememActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_housememActionPerformed

    private void housememKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_housememKeyReleased

    }//GEN-LAST:event_housememKeyReleased

    private void bbb7PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb7PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb7PropertyChange

    private void btnaddmemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddmemActionPerformed
        // TODO add your handling code here:
        
        householdmember.setVisible(true);
      
        
    }//GEN-LAST:event_btnaddmemActionPerformed

    private void jLabel57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel57MouseClicked
        // TODO add your handling code here:
         householdmember.setVisible(false);       
    }//GEN-LAST:event_jLabel57MouseClicked
    
    int memid;
    void addfammember(){
      
             try
            { 
                
             int famid = Integer.parseInt(fid.getText());
                ps=conn.prepareStatement("INSERT INTO `tbl_familymember`(`family_memberid`, `family_id`, `family_memfullname`) VALUES (?,?,?)");
             ps.setInt(1, memid);
             ps.setInt(2, famid);
             ps.setString(3, housemem.getText().toUpperCase());
             
            
            
             ps.execute();
             JOptionPane.showMessageDialog(null,"Succesfully Registered");
             housemem.setText("");
             showtblfammember();
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }
}
    
    void showtblfammember(){
        try{
        
                int famid = Integer.parseInt(fid.getText());
             String query= "Select  family_memfullname from tbl_familymember where family_id ='"+famid+"'" ; 
               
           ps=conn.prepareStatement(query);
            try {
                rs=ps.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(Dashboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            householdmem.setModel(DbUtils.resultSetToTableModel(rs));
           
            btnaddmem.setVisible(true);
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }    
        
    
    private void btnaddfamilymemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddfamilymemberActionPerformed
        // TODO add your handling code here:
        if(housemem.getText().equals("")){
             housemem.setBackground(new java.awt.Color(255, 0, 0));
            JOptionPane.showMessageDialog(this, "Please Input House Member Full Name First.");
         housemem.setBackground(new java.awt.Color(255, 255, 255));
        
    }else{
            addfammember();
            showtblfammember();   
        }
        
    }//GEN-LAST:event_btnaddfamilymemberActionPerformed

    private void householdMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_householdMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_householdMouseReleased

    private void jLabel68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel68MouseClicked
        // TODO add your handling code here:
        Addculpritpnl.setVisible(false);
        addculpritbtn.setVisible(true);
        witnessaddbtn.setVisible(true);
        
    }//GEN-LAST:event_jLabel68MouseClicked

    private void culpnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_culpnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_culpnameFocusLost

    private void culpnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_culpnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_culpnameActionPerformed

    private void culpnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_culpnameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_culpnameKeyReleased

    private void bbb8PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb8PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb8PropertyChange
void showculprit(){
    try
        {
                String caseno = casenotf.getText();
            ps=conn.prepareStatement("SELECT `culprit_name` , `culprit_addr`, `culprit_descr` FROM `tbl_culprit` where case_no = '"+caseno+"'");
            rs=ps.executeQuery();
            culprittable.setModel(DbUtils.resultSetToTableModel(rs));
            
           
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
}

    int id ;
    void addculprit(){
      try
            { 
               
             int casenumber = Integer.parseInt(casenotf.getText());
                ps=conn.prepareStatement("INSERT INTO `tbl_culprit`(`culprit_id`, `case_no`, `culprit_name`, `culprit_addr`, `culprit_descr`) VALUES (?,?,?,?,?);");
                
             ps.setInt(1, id);
             ps.setInt(2, casenumber);
             ps.setString(3, culpname.getText().toUpperCase());
              ps.setString(4, culaddress.getText().toUpperCase()); 
              ps.setString(5, culpritdesc.getText().toUpperCase());
              
             ps.execute();
            
            JOptionPane.showMessageDialog(null,"Succesfully Added");
              showculprit();
               culpname.setText("");
             culaddress.setText("");
              culpritdesc.setText("");
             
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }
}
    void showwitness(){
        try
        {
                String caseno = casenotf.getText();
            ps=conn.prepareStatement("SELECT `witness_name`, `witness_addr` FROM `tbl_witness` where case_no = '"+caseno+"'");
            rs=ps.executeQuery();
            witnesstable.setModel(DbUtils.resultSetToTableModel(rs));
            
           
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,e);
        }
    }
void addwitness(){
     try
            { 
               
             int casenumber = Integer.parseInt(casenotf.getText());
                ps=conn.prepareStatement("INSERT INTO `tbl_witness`(`witness_id`, `case_no`, `witness_name`, `witness_addr`) VALUES (?,?,?,?)");
                
             ps.setInt(1, id);
             ps.setInt(2, casenumber);
             ps.setString(3, witname.getText().toUpperCase());
              ps.setString(4, witaddr.getText().toUpperCase()); 
             

             ps.execute();
             JOptionPane.showMessageDialog(null,"Succesfully Added");
           
              
              showwitness();
               witname.setText("");
             witaddr.setText("");
             
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }
}
    private void btnaddculpritActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddculpritActionPerformed
        // TODO add your handling code here:
        addculprit();
        
        
        
        
        
    }//GEN-LAST:event_btnaddculpritActionPerformed

    private void bbb10PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb10PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb10PropertyChange

    private void culaddressFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_culaddressFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_culaddressFocusLost

    private void culaddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_culaddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_culaddressActionPerformed

    private void culaddressKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_culaddressKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_culaddressKeyReleased

    private void bbb11PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb11PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb11PropertyChange

    private void culpritdescFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_culpritdescFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_culpritdescFocusLost

    private void culpritdescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_culpritdescActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_culpritdescActionPerformed

    private void culpritdescKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_culpritdescKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_culpritdescKeyReleased

    private void jLabel69MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel69MouseClicked
        // TODO add your handling code here:
        addwitness.setVisible(false);
        witnessaddbtn.setVisible(true);
        addculpritbtn.setVisible(true);
        
    }//GEN-LAST:event_jLabel69MouseClicked

    private void witnameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_witnameFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_witnameFocusLost

    private void witnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_witnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_witnameActionPerformed

    private void witnameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_witnameKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_witnameKeyReleased

    private void bbb12PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb12PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb12PropertyChange

    private void btnaddwitnessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddwitnessActionPerformed
        // TODO add your handling code here:
        addwitness();
    }//GEN-LAST:event_btnaddwitnessActionPerformed

    private void bbb13PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_bbb13PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_bbb13PropertyChange

    private void witaddrFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_witaddrFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_witaddrFocusLost

    private void witaddrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_witaddrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_witaddrActionPerformed

    private void witaddrKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_witaddrKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_witaddrKeyReleased

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
void deleteresident(){
     try{
        
                int res = Integer.parseInt(resid.getText());
             String query= "DELETE FROM `tbl_resident` WHERE resident_id = "+res+"" ; 
               
                 ps=conn.prepareStatement(query);
            
                 ps.execute();
                     resident.clearSelection(); 
                     resident_table();
                     clear();
            JOptionPane.showMessageDialog(null,"Resident Deleted.");
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
}
void deletehousehold(){
     try{
        
                int houseno = Integer.parseInt(fid.getText());
             String query1= "DELETE FROM `tbl_household` WHERE family_id = "+houseno+"" ; 
                String query2= "DELETE FROM `tbl_familymember` WHERE family_id = "+houseno+"" ; 
                 ps=conn.prepareStatement(query1);
                 ps.execute();
                 ps=conn.prepareStatement(query2);
                    ps.execute();
              
                  
                     household.clearSelection();
                     
                     showtblfammember();  
                     household_table();
                     clear();
            JOptionPane.showMessageDialog(null,"Household Deleted.");
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
}
    private void resdeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resdeleteActionPerformed
        
        
            int x = JOptionPane.showConfirmDialog(null,"Are you sure you want to Delete? Note: this record cant be recovered.","confirmation message", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x==0){
            deleteresident();
        
        }
        
    }//GEN-LAST:event_resdeleteActionPerformed

    private void deletehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletehouseActionPerformed
        // TODO add your handling code here:
        
            int x = JOptionPane.showConfirmDialog(null,"Are you sure you want to Delete? Note: this record cant be recovered.","confirmation message", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x==0){
         deletehousehold();
                 }
    }//GEN-LAST:event_deletehouseActionPerformed

    private void edithouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edithouseActionPerformed
        // TODO add your handling code here:
        
        edithouse.setVisible(false);
        updatehouse.setVisible(true);
        headname.setEditable(true);
        headname.requestFocus(true);
        spousename.setEditable(true);
         ownership.setEditable(true);
         famadd.setEditable(true);
    }//GEN-LAST:event_edithouseActionPerformed
void updatehousehold(){
    try{
       String houseid =  fid.getText();
       String head = headname.getText().toUpperCase();
       String spouse = spousename.getText().toUpperCase();
       String own = ownership.getText().toUpperCase();
       String fulladd = famadd.getText().toUpperCase();
  
    String update = "UPDATE `tbl_household` SET `family_headname`='"+head+"',`family_spousename`='"+spouse+"',`ownership`='"+own+"',`family_fulladd`='"+fulladd+"',`date_update`= sysdate() WHERE family_id = "+houseid+"";
     ps = conn.prepareStatement(update);
    ps.executeUpdate();
    
    
    household.clearSelection();
    clear();
    household_table();
    JOptionPane.showMessageDialog(this, "Update Success!!"); 
    
   
   }
            catch (Exception e){
               JOptionPane.showMessageDialog(this, e); 
     }

}
    private void updatehouseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatehouseActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null,"Are you sure you want to Update Current Information?","confirmation message", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x==0){
        edithouse.setVisible(true);
        updatehouse.setVisible(false);
         spousename.setEditable(false);
         ownership.setEditable(false);
         famadd.setEditable(false);
          headname.setEditable(false);
          updatehousehold();
        }
    }//GEN-LAST:event_updatehouseActionPerformed

    private void editblotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editblotActionPerformed
        // TODO add your handling code here:
        witnessaddbtn.setVisible(true);
        addculpritbtn.setVisible(true);
        timeinci.setEditable(true);
        casenametf.setEditable(true);
        placetf.setEditable(true);
         complainant2.setEditable(true);
         cadd2.setEditable(true);
         casedesc.setEditable(true);
         dateinci.setEditable(true);
        editblot.setVisible(false);
        updateblot.setVisible(true);
        
    }//GEN-LAST:event_editblotActionPerformed

    private void btnrefreshresiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshresiActionPerformed
        // TODO add your handling code here:
            resident_table();
            clear();
    }//GEN-LAST:event_btnrefreshresiActionPerformed

    private void closecaseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closecaseMouseEntered
        // TODO add your handling code here:
        
          closecase.setBackground(Hover);
        
    }//GEN-LAST:event_closecaseMouseEntered

    private void blotstatusPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_blotstatusPropertyChange
        // TODO add your handling code here:
        
      
    }//GEN-LAST:event_blotstatusPropertyChange

    private void blotstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blotstatusActionPerformed
        // TODO add your handling code here:
        blotter_table();
    }//GEN-LAST:event_blotstatusActionPerformed

    private void timeinciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeinciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeinciActionPerformed

    private void timeinciKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_timeinciKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_timeinciKeyReleased

    private void searchblotKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchblotKeyReleased
        // TODO add your handling code here:
        String searchString = searchblot.getText().toUpperCase();
        searchblotter(searchString);
    }//GEN-LAST:event_searchblotKeyReleased
void blotsetActive(){
    try {
        int caseid = Integer.parseInt(casenotf.getText());
    
             String query1= "UPDATE tbl_blotter SET case_stat = 'ACTIVE'   where case_no = '"+caseid+"'" ; 
               
                 ps=conn.prepareStatement(query1);
                 ps.execute();
                  JOptionPane.showMessageDialog(null, "Success.");
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Failed.");
    }
}
void blotsetInactive(){
    try {
        int caseid = Integer.parseInt(casenotf.getText());
    
             String query1= "UPDATE tbl_blotter SET case_stat = 'INACTIVE'  where case_no = '"+caseid+"'" ; 
               
                 ps=conn.prepareStatement(query1);
                 ps.execute();
                  JOptionPane.showMessageDialog(null, "Success.");
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, "Failed.");
    }
}
    private void closecaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closecaseMouseClicked
        // TODO add your handling code here:
        
         int x = JOptionPane.showConfirmDialog(null,"Are you sure you want to Update Current Case?","confirmation message", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x==0){
            
       String blotterStatus = (String) blotstatus.getSelectedItem();
        if(blotterStatus.equals("ACTIVE")){
           blotsetInactive();
            blotter_table();
        }  if(blotterStatus.equals("INACTIVE")){
            blotsetActive();
            blotter_table();
             
        }
        
        }
        
    }//GEN-LAST:event_closecaseMouseClicked

    private void witnessaddbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_witnessaddbtnActionPerformed
        // TODO add your handling code here:
        addwitness.setVisible(true);
        witnessaddbtn.setVisible(false);
         addculpritbtn.setVisible(false);
    }//GEN-LAST:event_witnessaddbtnActionPerformed

    private void addculpritbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addculpritbtnActionPerformed
        // TODO add your handling code here:
         Addculpritpnl.setVisible(true);
        addculpritbtn.setVisible(false);
        witnessaddbtn.setVisible(false);
    }//GEN-LAST:event_addculpritbtnActionPerformed
void updatecomplainant(){
    try{
        String caseno = casenotf.getText();
       String compname =  complainant2.getText().toUpperCase();
       String compadd = cadd2.getText().toUpperCase();
       
  
    String update = "UPDATE `tbl_complainant` SET `complainant_name`='"+compname+"',`complainant_addr`='"+compadd+"' WHERE complainant_id = '"+caseno+"'";
     ps = conn.prepareStatement(update);
    ps.executeUpdate();
    
    
    
    clear();
 
   blotter_table();
    
   
   }
            catch (Exception e){
               JOptionPane.showMessageDialog(this, e); 
     }
    
    
}
    void updateBlot(){
    
    try{
        String caseno = casenotf.getText();
       String casename =  casenametf.getText().toUpperCase();
       String placeinci = placetf.getText().toUpperCase();
       String datein = dateinci.getText().toUpperCase();
       String timeinc = timeinci.getText().toUpperCase();
       String casede = casedesc.getText().toUpperCase();
  
    String update = "UPDATE `tbl_blotter` SET `case_name`='"+casename+"',`case_desc`='"+casede+"',`place_of_inci`='"+placeinci+"',`date_of_inci`='"+datein+"',`time_of_inci`='"+timeinc+"' WHERE case_no = '"+caseno+"';";
     ps = conn.prepareStatement(update);
    ps.executeUpdate();
    
    updatecomplainant();

    clear();
    JOptionPane.showMessageDialog(this, "Update Success!!"); 
    blotter_table();
    
    
   
   }
            catch (Exception e){
               JOptionPane.showMessageDialog(this, e); 
     }
    
}
    private void updateblotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateblotActionPerformed
        // TODO add your handling code here:
        int x = JOptionPane.showConfirmDialog(null,"Are you sure you want to Update Current Blotter Information?","confirmation message", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x==0){
            editblot.setVisible(true);
            updateblot.setVisible(false);
        
        updateBlot();
        
        
        }
        
        
    }//GEN-LAST:event_updateblotActionPerformed

    private void btnrefreshresi1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrefreshresi1ActionPerformed
        // TODO add your handling code here:
        household_table();
    }//GEN-LAST:event_btnrefreshresi1ActionPerformed

    private void addofficialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addofficialActionPerformed
        // TODO add your handling code here:
        addofficialpnl.setVisible(true);
        addofficial.setVisible(false);
    }//GEN-LAST:event_addofficialActionPerformed

    private void blotterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blotterMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_blotterMouseEntered

    private void blotterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_blotterMouseClicked
        casenotf.setText(String.valueOf(blotter.getValueAt(blotter.getSelectedRow(),0)));
        showinfoblot();
        showwitness();
        showculprit();
        editblot.setVisible(true);
        deleteblot.setVisible(true);
        closecase.setVisible(true);

    }//GEN-LAST:event_blotterMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        addofficial.setVisible(true);
        addofficialpnl.setVisible(false);
    }//GEN-LAST:event_closeMouseClicked

    private void offnameeditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offnameeditActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_offnameeditActionPerformed
void addofficial(){
     try
            { 
               
            String position1 = (String)position.getSelectedItem();
                ps=conn.prepareStatement("INSERT INTO `tbl_user`(`user_id`, `username`, `password`, `fullname`, `usertype`) VALUES (?,?,?,?,?)");
                
             ps.setInt(1, id);
             ps.setString(2, username.getText().toUpperCase());
             ps.setString(3, pass.getText().toUpperCase());
              ps.setString(4, offname.getText().toUpperCase()); 
              ps.setString(5, position1);
              
             ps.execute();
             addofficial.setVisible(true);
        addofficialpnl.setVisible(false);
            JOptionPane.showMessageDialog(null,"Succesfully Added");
           viewofficial_table();
          clear();
                            
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null,ex);
            }
}
    private void addoffbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addoffbtnActionPerformed
        // TODO add your handling code here:
      if (username.getText().equals("") || pass.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Please Check your Input.");
           
                }else{
                     int x = JOptionPane.showConfirmDialog(null,"Are you sure you want to Update Current Blotter Information?","confirmation message", JOptionPane.YES_OPTION, JOptionPane.WARNING_MESSAGE);
        if (x==0){
                addofficial();
                
        }
                }

        
    }//GEN-LAST:event_addoffbtnActionPerformed
void showofficial(){
     String userid = offid.getText();
        try{
     String query= "Select * from  tbl_user  where user_id ='"+userid+"'" ; 
               
           ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
           
           while (rs.next())
           {
               String iduser = rs.getString("user_id");
               
                String uname = rs.getString("username");
                 String pname = rs.getString("password");
                  String full = rs.getString("fullname");
                   String type = rs.getString("usertype");
                       
                    offnameedit.setText(full);
                     usernameedit.setText(uname);
                     passedit.setText(pname);
                        positionedit.setText(type);
                         
           }
              }catch (Exception e){
                       
                        JOptionPane.showMessageDialog(this, e);
 }

}
    private void official1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_official1MouseClicked
        // TODO add your handling code here:
         offid.setText(String.valueOf(official1.getValueAt(official1.getSelectedRow(),0)));
        editofficial.setVisible(true);
        deleteofficial.setVisible(true);
         showofficial();
    }//GEN-LAST:event_official1MouseClicked

    private void editofficialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editofficialActionPerformed
        // TODO add your handling code here:
        
        offnameedit.setEditable(true);
                usernameedit.setEditable(true);
                passedit.setEditable(true);
                        positionedit.setEditable(true);
                        
    }//GEN-LAST:event_editofficialActionPerformed

   
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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Addculpritpnl;
    private javax.swing.JPanel BLOTTER;
    private javax.swing.JPanel DASHBOARD;
    private javax.swing.JPanel HOUSEHOLD;
    private javax.swing.JPanel OFFICIAL;
    private javax.swing.JPanel REPORTS;
    private javax.swing.JPanel RESIDENT;
    private javax.swing.JButton addbtnblot;
    private javax.swing.JButton addculpritbtn;
    private javax.swing.JButton addoffbtn;
    private javax.swing.JButton addofficial;
    private javax.swing.JPanel addofficialpnl;
    private javax.swing.JButton addres;
    private javax.swing.JPanel addwitness;
    private javax.swing.JTextField age;
    private javax.swing.JLabel bbb10;
    private javax.swing.JLabel bbb11;
    private javax.swing.JLabel bbb12;
    private javax.swing.JLabel bbb13;
    private javax.swing.JLabel bbb20;
    private javax.swing.JLabel bbb25;
    private javax.swing.JLabel bbb26;
    private javax.swing.JLabel bbb27;
    private javax.swing.JLabel bbb28;
    private javax.swing.JLabel bbb30;
    private javax.swing.JLabel bbb33;
    private javax.swing.JLabel bbb34;
    private javax.swing.JLabel bbb36;
    private javax.swing.JLabel bbb37;
    private javax.swing.JLabel bbb39;
    private javax.swing.JLabel bbb40;
    private javax.swing.JLabel bbb7;
    private javax.swing.JLabel bbb8;
    private javax.swing.JScrollPane blooterbody;
    private javax.swing.JComboBox<String> blotstatus;
    private javax.swing.JTable blotter;
    private javax.swing.JButton btnaddculprit;
    private javax.swing.JButton btnaddfamilymember;
    private javax.swing.JButton btnaddmem;
    private javax.swing.JButton btnaddwitness;
    private javax.swing.JPanel btnblotter;
    private javax.swing.JPanel btnhousehold;
    private javax.swing.JPanel btnofficials;
    private javax.swing.JButton btnrefreshresi;
    private javax.swing.JButton btnrefreshresi1;
    private javax.swing.JPanel btnreports;
    private javax.swing.JPanel btnresident;
    private javax.swing.JLabel btnsetting;
    private javax.swing.JLabel btnsetting1;
    private javax.swing.JTextField cadd2;
    private javax.swing.JTextArea casedesc;
    private javax.swing.JLabel casename1;
    private javax.swing.JLabel casename2;
    private javax.swing.JTextField casenametf;
    private javax.swing.JLabel casenotf;
    private javax.swing.JLabel casestat;
    private javax.swing.JTextField civilstatus;
    private javax.swing.JLabel close;
    private javax.swing.JLabel closecase;
    private javax.swing.JTextField complainant2;
    private javax.swing.JTextField contact;
    private JTextFieldPersonalizado.JCTextField culaddress;
    private JTextFieldPersonalizado.JCTextField culpname;
    private JTextFieldPersonalizado.JCTextField culpritdesc;
    private javax.swing.JTable culprittable;
    private javax.swing.JScrollPane culsp;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel date;
    private javax.swing.JLabel datecreate;
    private JTextFieldPersonalizado.JCTextField dateinci;
    private javax.swing.JButton deleteblot;
    private javax.swing.JButton deletehouse;
    private javax.swing.JButton deleteofficial;
    private javax.swing.JTextField dob;
    private javax.swing.JButton editblot;
    private javax.swing.JButton edithouse;
    private javax.swing.JButton editofficial;
    private javax.swing.JButton editres;
    private javax.swing.JTextField famadd;
    private javax.swing.JTextField father;
    private javax.swing.JTextField fid;
    private javax.swing.JTextField fname;
    private javax.swing.JTextField h;
    private javax.swing.JLabel headlabel7;
    private javax.swing.JLabel headlabel8;
    private javax.swing.JLabel headlabel9;
    private javax.swing.JTextField headname;
    private javax.swing.JTable household;
    private javax.swing.JTable householdmem;
    private javax.swing.JPanel householdmember;
    private javax.swing.JPanel householdpanel;
    private JTextFieldPersonalizado.JCTextField housemem;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JTextField jTextField31;
    private javax.swing.JTextField jTextField34;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField mname;
    private javax.swing.JTextField mother;
    private javax.swing.JTextField nationality;
    private javax.swing.JTextField occupation;
    private javax.swing.JTable official;
    private javax.swing.JTable official1;
    private javax.swing.JLabel offid;
    private javax.swing.JTextField offname;
    private javax.swing.JTextField offnameedit;
    private javax.swing.JTextField ownership;
    private javax.swing.JTextField pass;
    private javax.swing.JTextField passedit;
    private javax.swing.JTextField permanentaddr;
    private javax.swing.JPanel pieChart1;
    private javax.swing.JTextField placetf;
    private javax.swing.JPanel pnlAddmember;
    private javax.swing.JPanel pnlAddmember1;
    private javax.swing.JPanel pnlAddmember2;
    private javax.swing.JTextField pob;
    private javax.swing.JComboBox<String> position;
    private javax.swing.JTextField positionedit;
    private javax.swing.JTextField religion;
    private javax.swing.JButton resdelete;
    private javax.swing.JTextField resid;
    private javax.swing.JTable resident;
    private javax.swing.JPanel residentpanel;
    private javax.swing.JTextField searchblot;
    private javax.swing.JTextField searchhousehold;
    private javax.swing.JTextField searchresident;
    private javax.swing.JTextField sex;
    private javax.swing.JTextField spousename;
    private javax.swing.JTextField status;
    private javax.swing.JLabel time;
    private JTextFieldPersonalizado.JCTextField timeinci;
    private javax.swing.JLabel totalhousehold;
    private javax.swing.JLabel totalofficial;
    private javax.swing.JLabel totalres;
    private javax.swing.JButton updateblot;
    private javax.swing.JButton updatehouse;
    private javax.swing.JTextField username;
    private javax.swing.JTextField usernameedit;
    private javax.swing.JTextField w;
    private JTextFieldPersonalizado.JCTextField witaddr;
    private JTextFieldPersonalizado.JCTextField witname;
    private javax.swing.JButton witnessaddbtn;
    private javax.swing.JScrollPane witnesssp;
    private javax.swing.JTable witnesstable;
    // End of variables declaration//GEN-END:variables
}
