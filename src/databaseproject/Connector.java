/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author George
 */
public class Connector {
    
   
     private static Connection conn;
     public static Connection start() {
        String url="jdbc:mysql://www.db4free.net:3306/barkaniza?useSSL=false";
        String user="root";
        String pass="root";
       
       
       
        try {
             Class.forName("com.mysql.jdbc.Driver");
             conn=DriverManager.getConnection(url,user,pass);
                      
            
            
        } catch (Exception ex) {
           System.out.println(ex);
        }
        
       return conn; 
    }
}
