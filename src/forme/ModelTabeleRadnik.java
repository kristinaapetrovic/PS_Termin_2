/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package forme;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import model.Radnik;

/**
 *
 * @author Korisnik
 */
public class ModelTabeleRadnik extends AbstractTableModel {

    private List<Radnik> lista = new ArrayList<>();
    private String[] kolone = {"radna knjizica", "jmbg", "ime", "prezime", "o jedinica"};

    public List<Radnik> getLista() {
        return lista;
    }
    
    public ModelTabeleRadnik(List<Radnik> lista) {
        this.lista=lista;
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        Radnik r=lista.get(rowIndex);
        switch(columnIndex){
            case 0: return r.getRadnaKnjizica();
            case 1: return r.getJmbg();
            case 2: return r.getIme();
            case 3: return r.getPrezime();
            default: return "n/a";
        }
    
    
    }

    @Override
    public String getColumnName(int column) {
        return kolone[column];

    }

}
