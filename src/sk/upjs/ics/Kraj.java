/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sk.upjs.ics;

import java.util.*;

/**
 *
 * @author Raven
 */
public class Kraj {
    
    private String nazovKraja;
    private String predseda;
    private List<Okres> zoznamOkresov = new ArrayList<>();
    
    public String getNazovKraja() {
        return nazovKraja;
    }
    
    public void setNazovKraja(String nazovKraja) {
        this.nazovKraja = nazovKraja;
    }
    
    public String getPredseda() {
        return predseda;
    }
    
    public void setPredseda(String predseda) {
        this.predseda = predseda;
    }
    
    public List<Okres> getZoznamOkresov() {
        return zoznamOkresov;
    }
    
    public void setZoznamOkresov(List<Okres> zoznamOkresov) {
        this.zoznamOkresov = zoznamOkresov;
    }
    
    
    
    String vypis() {
        StringBuilder sb = new StringBuilder();
        sb.append("Kraj:" + getNazovKraja()+", predseda tohoto kraja je: "+getPredseda()+"\n");
        for (Okres okres : zoznamOkresov) {
            sb.append("\t\t"+okres.vypis()+"\n");
        }
        return sb.toString();
    }
    
}
