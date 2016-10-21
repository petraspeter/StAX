/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sk.upjs.ics;

/**
 *
 * @author Raven
 */
public class Okres {
    
    private String nazovOkresu;
    private short kod;
    private int obyvatelstvo;
    private double rozloha;
    
    public String getNazovOkresu() {
        return nazovOkresu;
    }
    
    public void setNazovOkresu(String nazovOkresu) {
        this.nazovOkresu = nazovOkresu;
    }
    
    public short getKod() {
        return kod;
    }
    
    public void setKod(short kod) {
        this.kod = kod;
    }
    
    public int getObyvatelstvo() {
        return obyvatelstvo;
    }
    
    public void setObyvatelstvo(int obyvatelstvo) {
        this.obyvatelstvo = obyvatelstvo;
    }
    
    public double getRozloha() {
        return rozloha;
    }
    
    public void setRozloha(double rozloha) {
        this.rozloha = rozloha;
    }
    
    
    
    public String vypis() {
        return "Okres: "+getNazovOkresu()+", kod: "+getKod()+", pocet obyvatelov: "+getObyvatelstvo()+", rozloha: "+getRozloha()+"km^2";
    }
}
