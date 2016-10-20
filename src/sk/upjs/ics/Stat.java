package sk.upjs.ics;

import java.util.*;

public class Stat {
    
    private String nazovStatu;
    private List<Kraj> zoznamKrajov = new ArrayList<>();
    
    public String getNazovStatu() {
        return nazovStatu;
    }
    
    public void setNazovStatu(String nazovStatu) {
        this.nazovStatu = nazovStatu;
    }
    
    public List<Kraj> getZoznamKrajov() {
        return zoznamKrajov;
    }
    
    public void setZoznamKrajov(List<Kraj> zoznamKrajov) {
        this.zoznamKrajov = zoznamKrajov;
    }
    
    public Stat(String nazovStatu) {
        this.nazovStatu = nazovStatu;
    }
    
    public void vypis(){
        StringBuilder sb = new StringBuilder();
        sb.append("Stat: "+getNazovStatu()+"\n");
        for (Kraj kraj : zoznamKrajov) {
            sb.append("\t"+kraj.vypis());
        }
        System.out.println(sb.toString());
    }
    
}
