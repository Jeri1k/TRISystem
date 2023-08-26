/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {
     private java.sql.Connection DBConnection;
    public java.sql.Connection connect()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Class Driver Connection Success");
        }
        catch(ClassNotFoundException cnfe)
        {
            System.out.println("Connection Failed" + cnfe);
            System.exit(0);
        }
        String url="jdbc:mysql://localhost:3306/db_resinfosystem";
        try
        {
            DBConnection = (java.sql.Connection) DriverManager.getConnection(url,"root","");
            System.out.println("Database Connection Success");
        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Cant Connect to Database.");
            System.out.println("Connection Failed"+e);
            System.exit(0);
        }
        return DBConnection;
    }
}
