/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package sk.upjs.ics;

import java.io.*;
import java.util.Scanner;
import javax.xml.stream.*;

/**
 *
 * @author Raven
 */
public class StAXCitac {
    
    private String odstranMedzeru (String s) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(s);
        while (sc.hasNext()) {
            sb.append(sc.next());
        }
        return sb.toString();
    }
    
    private Okres citajOkres(XMLStreamReader xmlReader) throws XMLStreamException{
        xmlReader.require(XMLStreamConstants.START_ELEMENT, null, "okres");
        Okres okres = new Okres();
        okres.setNazovOkresu(xmlReader.getAttributeValue(null, "nazov"));
        while (xmlReader.next() != XMLStreamConstants.END_ELEMENT) {
            if (xmlReader.isStartElement()) {
                if("kod".equals(xmlReader.getLocalName())) {                   
                    String cislo = odstranMedzeru(xmlReader.getElementText());
                    okres.setKod(Short.parseShort(cislo));
                    continue;
                }
                if("obyvatelstvo".equals(xmlReader.getLocalName())) {
                    String cislo = odstranMedzeru(xmlReader.getElementText());
                    okres.setObyvatelstvo(Integer.parseInt(cislo));
                    continue;
                }
                if ("rozloha".equals(xmlReader.getLocalName())) {                    
                    String cislo = odstranMedzeru(xmlReader.getElementText());
                    okres.setRozloha(Double.parseDouble(cislo));
                    continue;
                }
            }
        }
        
        return okres;
    }
    
    private Kraj citajKraj(XMLStreamReader xmlReader) throws XMLStreamException {
        xmlReader.require(XMLStreamConstants.START_ELEMENT, null,"kraj");
        Kraj kraj = new Kraj();
        xmlReader.require(XMLStreamConstants.START_ELEMENT, null,"kraj");
        kraj.setNazovKraja(xmlReader.getAttributeValue(null, "nazov"));
        kraj.setPredseda(xmlReader.getAttributeValue(null, "predseda"));
        while (xmlReader.next() != XMLStreamReader.END_ELEMENT) {
            if (xmlReader.isStartElement()) {
                kraj.getZoznamOkresov().add(citajOkres(xmlReader));
            }
        }
        return kraj;
    }
    
    private Stat citajStat (XMLStreamReader xmlReader) throws XMLStreamException {
        xmlReader.require(XMLStreamConstants.START_ELEMENT, null,"stat");
        Stat stat = new Stat(xmlReader.getAttributeValue(null, "nazov"));
        while (xmlReader.next() != XMLStreamReader.END_ELEMENT) {
            if (xmlReader.isStartElement()) {
                stat.getZoznamKrajov().add(citajKraj(xmlReader));
            }
        }
        return stat;
    }
    
    public Stat citajZXml(File xmlSubor) {
        XMLInputFactory xif = XMLInputFactory.newInstance();
        try (Reader fileReader = new FileReader(xmlSubor)) {
            XMLStreamReader xmlReader = xif.createXMLStreamReader(fileReader);
            while (xmlReader.hasNext()) {
                xmlReader.next();
                if (xmlReader.getEventType() == XMLStreamConstants.START_ELEMENT) {
                    return citajStat(xmlReader);
                }
            }
            return null;
        } catch (Exception e) {
            throw new RuntimeException("Nekorektny XML subor!",e);
        }
    }
    
    public static void main(String[] args) {
        StAXCitac citac = new StAXCitac();
        Stat stat = citac.citajZXml(new File("Slovensko.xml"));
        stat.vypis();
    }
    
}

