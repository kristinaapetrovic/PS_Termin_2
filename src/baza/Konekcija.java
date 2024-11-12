/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Korisnik
 */
public class Konekcija {
    
    private static Konekcija instance;
    private Connection conncetion;
    private Konekcija() {
        try {
            String url="jdbc:mysql://localhost:3306/termin_2";
            conncetion=DriverManager.getConnection(url, "root", "admin");
            conncetion.setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Konekcija.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static Konekcija getInstance(){
        if(instance == null) instance=new Konekcija();
        return instance;
    }

    public Connection getConncetion() {
        return conncetion;
    }

   
    
    
    
    
}
