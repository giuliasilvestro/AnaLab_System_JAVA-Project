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
public class Catalogo {
    private Map<String,Test> catalogoTest = new HashMap<String, Test>();
    private Map<String,Esenzione> catalogoEsenzioni = new HashMap<String, Esenzione>();
    
    // Metodi riguardanti i test
    public void addTest(Test test){
        this.catalogoTest.put(test.getCode(), test);
        
    }
    
    public Test getTest(String code){
        return catalogoTest.get(code);
    }
    
    // Metodi riguardanti le esenzioni
    public void addEsenzione(Esenzione esenzione){
        this.catalogoEsenzioni.put(esenzione.getCode(), esenzione);
    }
    public Esenzione getEsenzione(String code){
        return catalogoEsenzioni.get(code);
    }
    // Metodi riguardanti il catalogo
    public void printCatalogoTest(){
        this.catalogoTest.forEach((key, value) -> System.out.println(key + ": " + value.toString()));
    }

    public void printCatalogoEsenzioni(){
        this.catalogoEsenzioni.forEach((key, value) -> System.out.println(key + ": " + value.toString()));
    }    
}
