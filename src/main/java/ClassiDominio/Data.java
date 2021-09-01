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
public class Data {
    String data;
    int counter;
    
    public Data(){}
    
    public Data(String data){
        this.data = data;
        this.counter = 1;
    }
    
    public String getData(){
        return this.data;
    }
    
    public int getCounter(){
        return this.counter;
    }
    
    public void incrCounter(){
        this.counter++;
    }
}