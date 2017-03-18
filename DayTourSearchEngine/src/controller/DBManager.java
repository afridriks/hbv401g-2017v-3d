/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.*;
/**
 *
 * @author Sigurlaug
 */
public class DBManager {
    private Connection myConn;
    private Statement myStmt;
    private ResultSet myRs;
    
    public void connect() throws SQLException {
        // TODO code application logic here
            try{                  
                Class.forName("org.sqlite.JDBC");      
                myConn = DriverManager.getConnection("jdbc:sqlite:trips.db");
            }
            catch (Exception ex){
                ex.printStackTrace();
            }
        }
    
    public void doStuff() throws SQLException{
            myStmt = myConn.createStatement();
            
            myStmt.executeUpdate("Create Table users ( name varchar(30), phone int)");
            myStmt.executeUpdate("Insert into users values ( 'Sigurlaug', 6983135)");
            myStmt.executeUpdate("Insert into users values ( 'Einar', 8695581)");
            myStmt.executeUpdate("Insert into users values ( 'Andrea', 8694303)");
            myStmt.executeUpdate("Insert into users values ( 'Mamma', 8991869)");
			
            System.out.println("Insert successful!\n");
            
            myRs = myStmt.executeQuery("select * from users");
			
            while(myRs.next()) {
              	System.out.println(myRs.getString("name") + ", " + myRs.getInt("phone"));
            }
    }
}
