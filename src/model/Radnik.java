/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Korisnik
 */
public class Radnik {
    private int id;
    private String radnaKnjizica;
    private String jmbg;
    private String ime;
    private String prezime;
    private OrganizacionaJedinica oj;

    public Radnik() {
    }

    public Radnik(int id, String radnaKnjizica, String jmbg, String ime, String prezime, OrganizacionaJedinica oj) {
        this.id = id;
        this.radnaKnjizica = radnaKnjizica;
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.oj = oj;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRadnaKnjizica() {
        return radnaKnjizica;
    }

    public void setRadnaKnjizica(String radnaKnjizica) {
        this.radnaKnjizica = radnaKnjizica;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public OrganizacionaJedinica getOj() {
        return oj;
    }

    public void setOj(OrganizacionaJedinica oj) {
        this.oj = oj;
    }

    @Override
    public String toString() {
        return ime+" "+prezime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Radnik other = (Radnik) obj;
        return this.id == other.id;
    }
    
    
}
