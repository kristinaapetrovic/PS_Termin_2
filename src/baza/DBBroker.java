/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baza;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.OrganizacionaJedinica;
import model.Radnik;
/**
 *
 * @author Korisnik
 */
public class DBBroker {
    
    private Konekcija conn=Konekcija.getInstance();

    public List<OrganizacionaJedinica> vratiOJed() {
        try {
            List<OrganizacionaJedinica> lista=new ArrayList<>();
            
            String upit="SELECT * FROM organizaciona_jedinica";
            Statement st=conn.getConncetion().createStatement();
            ResultSet rs=st.executeQuery(upit);
            
            while(rs.next()){
                
                int id=rs.getInt("id");
                String naziv=rs.getString("naziv");
                OrganizacionaJedinica oj=new OrganizacionaJedinica(id, naziv);
                lista.add(oj);
                
            }
            
            rs.close();
            st.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public int ubaciRadnika(Radnik r) {
       
        
        try {
            String upit="INSERT INTO radnik (radna_knjizica, jmbg, ime, prezime, ojed) VALUES (?,?,?,?,?)";
            
            int id=-1;
            
            PreparedStatement ps=conn.getConncetion().prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, r.getRadnaKnjizica());
            ps.setString(2, r.getJmbg());
            ps.setString(3, r.getIme());
            ps.setString(4, r.getPrezime());
            ps.setInt(5, r.getOj().getId());
            
            int red=ps.executeUpdate();
            ResultSet rs;
            if(red>0){
                rs=ps.getGeneratedKeys();
                if(rs.next())
                    id=rs.getInt(1);
            }
            conn.getConncetion().commit();
            ps.close();
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    
    }

    public List<Radnik> vratiRadnike() {
        try {
            List<Radnik> lista=new ArrayList<>();
            String upit="SELECT * FROM radnik r JOIN organizaciona_jedinica o on r.ojed=o.id ORDER BY r.prezime DESC";
            Statement st=conn.getConncetion().createStatement();
            ResultSet rs=st.executeQuery(upit);
            
            
            while(rs.next()){
                int idOJ=rs.getInt("o.id");
                String nazviOJ=rs.getString("o.naziv");
                
                OrganizacionaJedinica oj=new OrganizacionaJedinica(idOJ, nazviOJ);
                
                
                int id=rs.getInt("r.id");
                String rk=rs.getString("r.radna_knjizica");
                String ime=rs.getString("ime");
                String prezime=rs.getString("prezime");
                String jmbg=rs.getString("jmbg");
                
                Radnik r=new Radnik(id, rk, jmbg, ime, prezime, oj);
                lista.add(r);
            }
            
            st.close();
            rs.close();
            return lista;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public boolean izmeniRadnika(Radnik novi) {
        try {
            String upit="UPDATE radnik SET radna_knjizica=?, jmbg=?, ime=?, prezime=?, ojed=? WHERE id=?";
            
            PreparedStatement ps=conn.getConncetion().prepareStatement(upit);
            ps.setString(1, novi.getRadnaKnjizica());
            ps.setString(2, novi.getJmbg());
            ps.setString(3, novi.getIme());
            ps.setString(4, novi.getPrezime());
            ps.setInt(5, novi.getOj().getId());
            ps.setInt(6, novi.getId());
            
            int redovi=ps.executeUpdate();
            conn.getConncetion().commit();
            ps.close();
            
            return redovi>0;
        } catch (SQLException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    
    
    
    
}
