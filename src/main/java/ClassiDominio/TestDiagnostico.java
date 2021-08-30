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
public class TestDiagnostico extends Test {
    List<Test> listaTest;
 
    
    public TestDiagnostico(String codiceSSN, String nome){
        this.codiceSSN = codiceSSN;
        this.nome = nome;
        this.listaTest = new ArrayList<>();
    }
    
    public void add(Test test){
        listaTest.add(test);
        this.getPrezzo();
    }
    
    @Override
    public double getPrezzo(){
        double prezzo = 0;
        for(Test test: listaTest){
            prezzo = prezzo + test.getPrezzo();
        }
        this.prezzo = prezzo;
        return prezzo;
    }  
    
    @Override
    public String toString() {
        String str ="Prezzo: "+this.prezzo+"€, Esami previsti: ";
        for(Test test: listaTest){
            str = str + test.getNome()+", ";
        }
        return str;
  }
    
    
}
