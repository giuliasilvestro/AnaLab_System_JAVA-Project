/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaccia;

import ClassiDominio.AnaLabSystem;
import ClassiDominio.*;
import java.util.*;


/**
 *
 * @author giuliasilvestro
 */
public class AnaLab {
    private static int menu(String s[]) {
        int i;
        for (String x : s) {
            System.out.println(x);
        }
        return i=Input.leggiIntero();
    }    

    public static void main(String[] args) {
        // Crea istanza di anaLabSystem e inizializzala con i dati di avviamento
        AnaLabSystem anaLabSystem = AnaLabSystem.getAnaLabSystem();
        Startup startup = new Startup(anaLabSystem);
        
         String MMain [] = {
            "-----------------------------",
            "Chi sei?",
            "1) Amministratore", 
            "2) Segretario", 
            "3) Tecnico del Laboratorio", 
            "4) Paziente",
            "-----------------------------",
        };
        
        String MAmministratore [] = {
            "-----------------------------",
            "1) Aggiungi Singolo Test", 
            "2) Aggiungi Test Diagnostico", 
            "3) Aggiungi Esenzione",
            "4) Torna al menu precedente",
            "----------------------"
        };
        
        String MSegretario [] = {
            "-----------------------------",
            "1) Registra Prenotazione", 
            "2) Registra Nuovo Paziente", 
            "3) Visualizza prenotazioni di una data",
            "4) Torna al menu precedente",
            "-----------------------------"
        };
        
        String MTecnico [] = {
            "-----------------------------",
            "1) Aggiorna Esito", 
            "2) Torna al menu precedente",
            "-----------------------------"
        };
                
        String MPaziente [] = {
            "-----------------------------",
            "1) Visualizza Esito", 
            "2) Torna al menu precedente",
            "-----------------------------"
        };
        
      
        int scelta;
         
        do {
            scelta = menu(MMain);
            switch (scelta){
                
                case 1: { // AMMINISTRATORE
                    do {
                        scelta = menu(MAmministratore); 
                        switch (scelta){
                            case 1: { // AMM: Aggiungi Singolo Test                        
                                    System.out.println("Inserisci codice: ");
                                    String codiceSSN = Input.leggiStringa();
                                    System.out.println("Inserisci nome: ");
                                    String nome = Input.leggiStringa();
                                    System.out.println("Inserisci prezzo: ");
                                    double prezzo = Input.leggiDouble();
                                    System.out.println("Inserisci valore massimo: ");
                                    double valMax = Input.leggiDouble();
                                    System.out.println("Inserisci valore minimo: ");
                                    double valMin = Input.leggiDouble();
                                    System.out.println("Inserisci indicatore superamento valore massimo: ");
                                    String msgValMax = Input.leggiStringa();
                                    System.out.println("Inserisci indicatore non superamento valore minimo: ");
                                    String msgValMin = Input.leggiStringa();

                                    TestSingolo test = anaLabSystem.nuovoSingoloTest(codiceSSN, nome, prezzo, valMax, valMin, msgValMax, msgValMin);

                                    System.out.println("Aggiunto test: ");
                                    test.toString();
                                    System.out.println("*****");
                                    System.out.println("CATALOGO AGGIORNATO");
                                    System.out.println("*****");
                                    anaLabSystem.getCatalogo().printCatalogoTest();

                                    break;
                            }
                            case 2: { // AMM: Aggiungi Test Diagnostico
                                
                                    System.out.println("Inserisci codice: ");
                                    String codiceSSN = Input.leggiStringa();
                                    System.out.println("Inserisci nome: ");
                                    String nome = Input.leggiStringa();      
                                    
                                    TestDiagnostico testDiagnosticoCorrente = anaLabSystem.nuovoTestDiagnostico(codiceSSN, nome);
                                    String code;
                                    do{
                                        System.out.println("Inserisci codice test da aggiungere (0 per terminare): ");
                                        code = Input.leggiStringa();
                                        if(!code.equals("0")){
                                            anaLabSystem.aggiungiTestTestDiagnostico(testDiagnosticoCorrente, code);
                                            //listaTest.add(anaLabSystem.getCatalogo().getTest(code));
                                        }     
                                    }while (!code.equals("0"));
                                    
                                    System.out.println("Riepilogo: ");
                                    System.out.println(testDiagnosticoCorrente.toString());
                                    System.out.println("Premi 0 per confermare, qualsiasi altro carattere per annullare): ");
                                    String conferma = Input.leggiStringa();
                                    if(conferma.equals("0")){
                                        anaLabSystem.confermaTestDiagnostico(testDiagnosticoCorrente); 
                                    }
                                    
                                    System.out.println("********************");
                                    System.out.println("CATALOGO AGGIORNATO");
                                    System.out.println("********************");
                                    anaLabSystem.getCatalogo().printCatalogoTest();

                                    break;
                            } 
                            case 3: { // AMM: Aggiungi Esenzione
                                    System.out.println("Inserisci codice: ");
                                    String codice = Input.leggiStringa();
                                    System.out.println("Inserisci la percentuale da detrarre (da 0 a 100): ");
                                    Double percentualeDetrarre = Input.leggiDouble();   

                                    Esenzione esenzioneCorrente = anaLabSystem.nuovaEsenzione(codice, percentualeDetrarre);
                                    //List<Test> listaTest = new ArrayList<>();
                                    String code;
                                    do{
                                        System.out.println("Inserisci codice test da aggiungere (0 per terminare): ");
                                        code = Input.leggiStringa();
                                        if(!code.equals("0")){
                                            anaLabSystem.aggiungiTestEsenzione(esenzioneCorrente, code);
                                        }     
                                    }while (!code.equals("0"));
                                    
                                  
                                    System.out.println("Riepilogo: ");
                                    System.out.println(esenzioneCorrente.toString());
                                    System.out.println("Premi 0 per confermare, qualsiasi altro carattere per annullare): ");
                                    String conferma = Input.leggiStringa();
                                    if(conferma.equals("0")){
                                        anaLabSystem.confermaEsenzione(esenzioneCorrente); 
                                    }
                                    
                                    System.out.println("********************");
                                    System.out.println("CATALOGO AGGIORNATO");
                                    System.out.println("********************");
                                    anaLabSystem.getCatalogo().printCatalogoEsenzioni();

                                    break;
                                
                            }
                        }
                    }while (scelta !=4);
                break;
                }
               
                case 2: {  // SEGRETARIO
                    do {
                        scelta = menu(MSegretario);
                        switch (scelta){
                            case 1: {// SEG: Registra Prenotazione
                                Prenotazione prenotazioneCorrente = anaLabSystem.nuovaPrenotazione();
                                int flag = 0;
                                String codiceFiscale;
                                String data;
                                Paziente paziente = new Paziente();
                                // Verifica se esiste il paziente, o registrane uno nuovo.
                                do{
                                    System.out.println("Inserisci codice fiscale del paziente. Digita 0 per registrare un nuovo paziente: ");
                                    // Trova paziente
                                    codiceFiscale = Input.leggiStringa();
                                    if(codiceFiscale.equals("0")){
                                        codiceFiscale = nuovoPaziente(anaLabSystem); //ritorna un paziente, non un codice fiscale
                                        paziente = anaLabSystem.getPaziente(codiceFiscale);
                                        break;
                                    }
                                    paziente = anaLabSystem.getPaziente(codiceFiscale);
                                    if(paziente == null){
                                        System.out.println("Il paziente inserito non è stato trovato.");
                                        flag = 0;
                                    } else {
                                            flag = 1;
                                        }
                                }while(flag!=1);
                                    
                                
                                anaLabSystem.associaPazientePrenotazione(paziente, prenotazioneCorrente);
                                
                                // Verifica se il paziente ha nuove esenzioni
                                String codEs = "0";
                                do{
                                    System.out.println("Se il paziente ha una nuova esenzione inserirne il codice, altrimenti digitare 0: ");
                                     codEs = Input.leggiStringa();
                                     if(!codEs.equals("0")){
                                        anaLabSystem.aggiungiEsenzionePaziente(paziente, codEs);
                                         
                                     }
                                }while(!codEs.equals("0"));
                                
                                
                                
                               // Verifica se la data è disponibile, scegliere una data disponibile.
                               Data d = new Data(); 
                               flag = 0;
                                do{
                                    System.out.println("Inserisci data prenotazione (dd/mm/yyyy): ");
                                    data = Input.leggiStringa();
                                    d = anaLabSystem.getData(data);
                                    if(d == null){
                                        d = anaLabSystem.addData(data);
                                        
                                        flag = 1;
                                    } else {
                                        if(anaLabSystem.verificaCapienzaData(d,30)){
                                            System.out.println("Capienza massima di "+d.getCounter()+" raggiunta per il "+anaLabSystem.getData(d.getData())+", scegliere un'altra data.");
                                            flag = 0;
                                        } else{
                                            
                                            flag = 1;
                                        }
                                        System.out.println("Counter per "+anaLabSystem.getData(d.getData())+" =  "+d.getCounter());
                                    }
                                }while(flag!=1);
                                
                                anaLabSystem.associaDataPrenotazione(d, prenotazioneCorrente);
                                String code;

                                do{
                                        System.out.println("Inserisci codice test da aggiungere (0 per terminare): ");
                                        code = Input.leggiStringa();
                                        if(!code.equals("0")){
                                            anaLabSystem.aggiungiTestPrenotazione(prenotazioneCorrente, code);
                                            
                                        }     
                                    }while (!code.equals("0"));


                                System.out.println("********************");
                                System.out.println("RIEPILOGO PRENOTAZIONE");
                                System.out.println("********************");
                                System.out.println(prenotazioneCorrente.toString());
                                System.out.println("Premi 0 per confermare, qualsiasi altro carattere per annullare la prenotazione");
                                String conferma = Input.leggiStringa();
                                if(conferma.equals("0")){
                                    anaLabSystem.confermaPrenotazione(prenotazioneCorrente);
                                    System.out.println("Prenotazione confermata! ");
                                }
                                break;
                            }
                            case 2: {  // SEG: Registra Nuovo Paziente
                                nuovoPaziente(anaLabSystem);
                       
                                break;
                            }    
                            case 3:{ // SEG: Visualizza prenotazioni di una data
                                System.out.println("Inserisci data: ");
                                String data = Input.leggiStringa();
                                System.out.println("----------------------------------------");
                                System.out.println("PRENOTAZIONI DEL "+data+": ");
                                List<Prenotazione> prenotazioni = new ArrayList<>();
                                prenotazioni = anaLabSystem.getPrenotazioniData(data);
                                for(Prenotazione p : prenotazioni) {
                                    System.out.println(p.toString());
                                    System.out.println("----------------------------------------");
                                }
                                break;
                            }
                        }
                    }while (scelta !=4);
                    break;
                }
                
                case 3: {  // TECNICO LABORATORIO
                    do {
                        scelta = menu(MTecnico);
                        switch (scelta){
                            case 1: { // TECH: Aggiorna Esito
                                System.out.println("Inserisci il codice fiscale del paziente: ");
                                String codiceFiscale = Input.leggiStringa();
                                System.out.println("Inserisci data prenotazione (dd/mm/yyyy): ");
                                String data = Input.leggiStringa();
                                Prenotazione p = new Prenotazione();
                                
                                if(anaLabSystem.getPrenotazione(codiceFiscale, data) == null){
                                    System.out.println("Prenotazione non trovata");
                                }else {
                                  p = anaLabSystem.getPrenotazione(codiceFiscale, data);
                                  System.out.println("Prenotazione trovata, digita il codice del test di cui vuoi aggiornare l'esito: ");
                                  System.out.println(p.testToString());
                                  String codiceTest = Input.leggiStringa();
                                  System.out.println("Inserisci l'esito numerico del test");
                                  Double risultato = Input.leggiDouble();
                                  anaLabSystem.modificaEsito(risultato, codiceTest, p);
                                }
                                break;
                            }
                        }
                    }while (scelta !=2);
                    break;
                }
                case 4: { // PAZIENTE
                    do {
                        scelta = menu(MPaziente);
                        switch (scelta){
                            case 1: { // PAZ: Visualizza Esito
                                System.out.println("Inserisci il tuo codice fiscale: ");
                                String codiceFiscale = Input.leggiStringa();
                                System.out.println("Inserisci data prenotazione (dd/mm/yyyy): ");
                                String data = Input.leggiStringa();
                                System.out.println("---------------------------------------------");
                                Prenotazione p = anaLabSystem.getPrenotazione(codiceFiscale, data);
                                System.out.println(p.esitoToString());
                                break;
                            }            
                        }
                    }while (scelta !=2);
                    break;
                }  
            }
        }while (scelta !=0);
    }
    
    
    private static String nuovoPaziente(AnaLabSystem anaLabSystem){
        System.out.println("Inserisci codice fiscale: ");
        String codiceFiscale = Input.leggiStringa();
        System.out.println("Inserisci nome e cognome: ");
        String nomeCognome = Input.leggiStringa();
        System.out.println("Inserisci data di nascita: ");
        String dataNascita = Input.leggiStringa();

        Paziente paziente = anaLabSystem.nuovoPaziente(codiceFiscale, nomeCognome,dataNascita);

        String code;
        do{
            System.out.println("Inserisci codice esenzione da aggiungere (0 per terminare): ");
            code = Input.leggiStringa();
            if(!code.equals("0")){
                anaLabSystem.aggiungiEsenzionePaziente(paziente,code); 

            }     
         }while (!code.equals("0"));
        
        anaLabSystem.confermaPaziente(paziente);

        System.out.println("********************");
        System.out.println("LISTA PAZIENTI AGGIORNATA");
        System.out.println("********************");
        anaLabSystem.printListaPazienti();
        return codiceFiscale;
    }
}
