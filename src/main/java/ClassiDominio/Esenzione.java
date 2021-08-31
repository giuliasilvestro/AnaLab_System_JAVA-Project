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
public class Esenzione {
    private String codice;
    private double percentualeDetrarre;
    public List<Test> listaTest;
    
     public Esenzione(String codice, double percentualeDetrarre){
        this.codice = codice;
        this.percentualeDetrarre = percentualeDetrarre;
        this.listaTest = new ArrayList<>();
    }
     
    public void addTest(Test test){
        listaTest.add(test);
    }
    
    public String getCode(){
        return codice;
    };
    
    public double getDiscount(){
        return percentualeDetrarre;
    }
    
    @Override
    public String toString() {
        String str = "Percentuale da detrarre: "+percentualeDetrarre+"%, Esami idonei: ";
        for(Test test: listaTest){
            str = str + test.getNome()+", ";
        }
        return str;
  }
    
}
