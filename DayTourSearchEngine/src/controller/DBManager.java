/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Sigurlaug
 */
public class DBManager {
    private Connection myConn = null;
    private Statement myStmt;
    private ResultSet myRs;
    
    public void connect() {
        // TODO code application logic here
        try{                  
            Class.forName("org.sqlite.JDBC");      
            myConn = DriverManager.getConnection("jdbc:sqlite:trips.db");
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    public void doStuff(){
        try {
            connect();
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
            
            
            myConn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally {
            try {
                if(myConn != null)
                    myConn.close();
            }
            catch(SQLException e) {
                // connection close failed.
                System.err.println(e);
            }
        }
 
    }
    
    public static void main(String[] args) throws SQLException {
        DBManager man = new DBManager();
        man.doStuff();
    }
}
