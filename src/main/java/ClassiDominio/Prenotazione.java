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
public class Prenotazione {
    private Data data;
    private Paziente paziente;
    private double prezzo;
    private List<Test> listaTest;
    private List<Esito> esiti;
 
    public Prenotazione(){
            this.listaTest = new ArrayList<>();
            this.esiti = new ArrayList<>();
    }
    public Prenotazione(Paziente paziente, Data data){
        this.paziente = paziente;
        this.data = data;
        this.listaTest = new ArrayList<>();
        this.esiti = new ArrayList<>();
    }
    
    public void addPaziente(Paziente p){
        this.paziente = p;
    }
    
    public void addData(Data d){
        this.data = d;
    }
    
    public void addTest(Test test){
        listaTest.add(test);
        setPrezzo();
    }
    
    public Data getDate(){
        return this.data;
    }
    
    public Paziente getPaziente(){
        return paziente;
    }
    
    public void setPrezzo(){
        double prezzo = 0;
        for(Test test: this.listaTest){
            int found = 0;
            for(Esenzione esenzione: this.paziente.listaEsenzioni){
                for(Test esenTest: esenzione.listaTest){
                    if(esenTest.getCode().equals(test.getCode())){
                        prezzo = prezzo + (test.calcPrezzo() - (0.01*esenzione.getDiscount()*test.calcPrezzo()));
                        found = 1;
                        continue;
                    }
                }
            }
            if(found == 0){ 
                prezzo = prezzo + test.calcPrezzo();
            }
        }
        this.prezzo = prezzo;
    }
    
    public void addEsito(Esito esito){
        esiti.add(esito);
    }
    
    @Override
    public String toString() {
        String str ="DATA: "+this.data.getData()+"\n"+"PAZIENTE: "+this.paziente.toString()+"\n"+"PREZZO FINALE CON ESENZIONI: "+this.prezzo+"\n"+"LISTA TEST PRENOTATI: ";
        for(Test test: listaTest){
            str = str + test.getNome()+", prezzo: "+test.calcPrezzo()+" | ";
        }
        return str;
    }
    
    
    public String testToString() {
        String str = "Lista Test Prenotati: "+"\n";
        for(Test test: listaTest){
            if(test instanceof TestSingolo){
            str = str + "|| "+test.getCode() +" :"+test.getNome()+"\n";
            } else if (test instanceof TestDiagnostico){
                for(Test t: ((TestDiagnostico) test).listaTest){
                str = str + "|||| "+ t.getCode() +" :"+t.getNome()+"\n";
                }
            }
        }
        return str;
  }
    
    public String esitoToString() {
        String str ="PRENOTAZIONE: "+this.toString()+"\n"+"\n"+"ESITI DISPONIBILI: "+"\n";
        for(Esito esito: esiti){
            
            String stringa = " ";
            if(esito.getEsito()> esito.getTest().getValMax()){
                stringa = esito.getTest().getMsgValMax();
            } else if(esito.getEsito() < esito.getTest().getValMin()){
                stringa = esito.getTest().getMsgValMin();
            }
            
            str = str + "Test: "+esito.getTest().getNome()+" | valore: "+esito.getEsito()+" |  Valori di riferimento: "+esito.getTest().getValMin()+" - "+esito.getTest().getValMax()+" | "+stringa+"\n";
        }
        return str;
    }
    
}
