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
        test.calcPrezzo();
        this.catalogoTest.put(test.getCode(), test);
    }
    
    public Test getTest(String code){
        return catalogoTest.get(code);
    }
    
    public TestSingolo creaTestSingolo(String codiceSSN, String nome, double prezzo, double valMax, double valMin, String msgValMax, String msgValMin){
        TestSingolo test = new TestSingolo(codiceSSN, nome, prezzo, valMax, valMin, msgValMax, msgValMin);
        addTest(test);
        return test;
    }
    
    public TestDiagnostico creaTestDiagnostico(String codiceSSN, String nome){
            TestDiagnostico testDiagnostico = new TestDiagnostico(codiceSSN, nome);
            //addTest(testDiagnostico);
            return testDiagnostico;
    }
    
    public void aggiungiTestTestDiagnostico(TestDiagnostico testDiagnostico, String code){
        testDiagnostico.listaTest.add(this.catalogoTest.get(code));
        testDiagnostico.calcPrezzo();
    }
    
    // Metodi riguardanti le esenzioni
    
    public Esenzione creaEsenzione(String codice, double percentualeDetrarre){
        Esenzione esenzione = new Esenzione(codice, percentualeDetrarre);
        return esenzione;
    }
    
    public void aggiungiTestEsenzione(Esenzione esenzione, String code){
        esenzione.listaTest.add(this.catalogoTest.get(code));
    }
    
    public void addEsenzione(Esenzione esenzione){
        this.catalogoEsenzioni.put(esenzione.getCode(), esenzione);
    }
    public Esenzione getEsenzione(String code){
        return catalogoEsenzioni.get(code);
    }
    
    // Metodi riguardanti i cataloghi
    
    public void printCatalogoTest(){
        this.catalogoTest.forEach((key, value) -> System.out.println(key + ": " + value.toString()));
    }

    public void printCatalogoEsenzioni(){
        this.catalogoEsenzioni.forEach((key, value) -> System.out.println(key + ": " + value.toString()));
    }    
}
