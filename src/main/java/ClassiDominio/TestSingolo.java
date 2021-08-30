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
public class TestSingolo extends Test {
    
    private double valMax;
    private double valMin;
    private String msgValMax;
    private String msgValMin;
    
    public TestSingolo(String codiceSSN, String nome, double prezzo, double valMax, double valMin, String msgValMax, String msgValMin){
     this.codiceSSN = codiceSSN;
     this.nome = nome;
     this.prezzo = prezzo;
     this.valMax = valMax;
     this.valMin = valMin;
     this.msgValMax = msgValMax;
     this.msgValMin = msgValMin;
    }
    @Override
    public double getPrezzo(){
        return prezzo;
    } 
    
    @Override
    public String toString() {
        String str = "Nome: "+nome+" | Prezzo: "+prezzo+"€, ValMax: "+valMax+", ValMin: "+valMin;
    return str;
    }
    

}
