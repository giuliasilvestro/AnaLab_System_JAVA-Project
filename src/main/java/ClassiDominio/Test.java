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
public abstract class Test {
    public String codiceSSN; //non scriviamo il costruttore perchè l'attributo è public e viene inizializzato nei costruttori delle sottoclassi
    public String nome;
    public double prezzo;
    
    abstract double calcPrezzo();
    public String getCode(){
        return codiceSSN;
    };
    public String getNome(){
    return this.nome;
    
  }
}
