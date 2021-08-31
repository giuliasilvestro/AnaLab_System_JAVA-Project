/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassiDominio;
import java.util.*;

/**
 *
 * @author giuliasilvestro
 */
public class Paziente {
    private String codiceFiscale; //non scriviamo il costruttore perchè l'attributo è public e viene inizializzato nei costruttori delle sottoclassi
    private String nomeCognome;
    private String dataNascita;
    List<Esenzione> listaEsenzioni = new ArrayList<>();
    
    public Paziente(String codiceFiscale, String nomeCognome, String dataNascita){
       this.codiceFiscale = codiceFiscale;
       this.nomeCognome = nomeCognome;
       this.dataNascita = dataNascita;
       //this.listaEsenzioni = new ArrayList<>();
    }
    
    public String getCodiceFiscale(){
        return this.codiceFiscale;
    } 
    
    public void addEsenzione(Esenzione esenzione){
        listaEsenzioni.add(esenzione);
    }
    
    @Override
    public String toString() {
        String str = "Codice Fiscale: "+codiceFiscale+", Nome e Cognome: "+nomeCognome+", Data di nascita: "+dataNascita+", Esenzioni:";
        for(Esenzione esenzione: listaEsenzioni){
            str = str + esenzione.getCode()+", ";
        }
        return str;
  }
}
