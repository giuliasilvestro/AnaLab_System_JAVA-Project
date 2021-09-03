/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassiDominio;
import ClassiDominio.*;
import java.util.*;


/**
 *
 * @author giuliasilvestro
 */
public class Esito {
    private double esito;
    private TestSingolo test;

    public Esito(TestSingolo test, double esito){
        this.esito = esito;
        this.test = test;        
    }
    
    public double getEsito(){
        return esito;
    } 
    
    public TestSingolo getTest(){
        return test;
    } 
    
}

