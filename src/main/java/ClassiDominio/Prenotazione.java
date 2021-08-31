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
    private String data;
    private Paziente paziente;
    private double prezzo;
    private List<Test> listaTest;
    private List<Esito> esiti;
 
    public Prenotazione(Paziente paziente, String data){
        this.paziente = paziente;
        this.data = data;
        this.listaTest = new ArrayList<>();
        this.esiti = new ArrayList<>();
    }
    
    public void addTest(Test test){
        listaTest.add(test);
    }
    
    public String getDate(){
        return this.data;
    }
    
    public void setPrezzo(){
        System.out.println("PREZZO");
        double prezzo = 0;
        for(Test test: this.listaTest){
            int found = 0;
            System.out.println("punto 1");
            if(this.paziente.getCodiceFiscale().equals("ciao")){
                System.out.println("almeno il paziente esiste");
            }
            if (this.paziente.listaEsenzioni !=null && !this.paziente.listaEsenzioni.isEmpty()) {
                System.out.println("non sono vuoto");
            }
            
            //System.out.println(this.paziente.listaEsenzioni.toString());
            for(Esenzione esenzione: this.paziente.listaEsenzioni){
                System.out.println("punto 2");
                System.out.println(esenzione.toString());
                for(Test esenTest: esenzione.listaTest){
                    System.out.println("punto 3");
                    System.out.println(test.getCode());
                    System.out.println(esenTest.getCode());
                    if(esenTest.getCode().equals(test.getCode())){
                        System.out.println("punto 4");
                        prezzo = prezzo + (test.getPrezzo() - (0.01*esenzione.getDiscount()*test.getPrezzo()));
                        found = 1;
                        continue;
                    }
                }
            }
            if(found == 0){ 
                prezzo = prezzo + test.getPrezzo();
            }
        }
        this.prezzo = prezzo;
    }
    
    public void addEsito(Esito esito){
        esiti.add(esito);
    }
    
    @Override
    public String toString() {
        String str ="DATA: "+this.data.toString()+"\n"+"PAZIENTE: "+this.paziente.toString()+"\n"+"PREZZO FINALE CON ESENZIONI: "+this.prezzo+"\n"+"LISTA TEST PRENOTATI: ";
        for(Test test: listaTest){
            str = str + test.getNome()+", prezzo: "+test.getPrezzo()+" | ";
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
