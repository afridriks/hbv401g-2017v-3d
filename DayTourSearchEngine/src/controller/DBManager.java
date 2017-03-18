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
}
