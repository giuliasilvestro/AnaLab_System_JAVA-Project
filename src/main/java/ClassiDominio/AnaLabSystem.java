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
public class AnaLabSystem {
    // Istanza singleton di AnaLabSystem 
    private static AnaLabSystem singleton;	
    // Catalogo che contiene le esenzioni e i test disponibili
    private Catalogo catalogo;
    // Pazienti registrati
    private Map<String,Paziente> pazienti;
    
    
}
