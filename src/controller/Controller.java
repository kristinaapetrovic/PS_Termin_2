/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import baza.DBBroker;
import java.util.List;
import model.OrganizacionaJedinica;
import model.Radnik;

/**
 *
 * @author Korisnik
 */
public class Controller {

    private static Controller instance;
    private DBBroker dbb = new DBBroker();

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public List<OrganizacionaJedinica> vratiOJed() {
        return dbb.vratiOJed();
    }

    public int ubaciRadnika(Radnik r) {
        return dbb.ubaciRadnika(r);
    }

    public List<Radnik> vratiRadnike() {
        return dbb.vratiRadnike(); 
    }

    public boolean izmeniRadnika(Radnik novi) {
        return dbb.izmeniRadnika(novi);
    }

}
