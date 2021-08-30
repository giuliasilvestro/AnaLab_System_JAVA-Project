package Interfaccia;

import ClassiDominio.*;
import java.util.*;


public class AnaLab {
     // Istanza singleton di AnaLabSystem 
    private static AnaLab singleton;	
    // Catalogo che contiene le esenzioni e i test disponibili
    public Catalogo catalogo  = new Catalogo() ;
    // Pazienti registrati
    public Map<String,Paziente> pazienti = new HashMap<String,Paziente>();
    
   protected AnaLab() {
       TestSingolo test1 = new TestSingolo("t_01", "Globuli Rossi", 5, 100, 20, "*", "*");
       this.catalogo.addTest(test1);
       TestSingolo test2 = new TestSingolo("t_02", "Globuli Bianchi", 5, 100, 20, "*", "*");
       this.catalogo.addTest(test2);
       
	}
    
    private static int menuMain(String s[]) {
        int i;
        for (String x : s) {
            System.out.println(x);
        }
        return i=Input.leggiIntero();
    }
    
    private static int menuAmministratore(String s[]) {
        int i;
        for (String x : s) {
            System.out.println(x);
        }
        return i=Input.leggiIntero();
    }  

    public static void main(String[] args) {
        try
    {
        AnaLab obj = new AnaLab ();
        obj.run (args);
    }
    catch (Exception e)
    {
        e.printStackTrace ();
    }
        
    }
     
    public void run (String[] args) throws Exception
{
  
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
            "3) Torna al menu precedente",
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
            scelta = menuMain(MMain);
            switch (scelta){
                
                case 1: { // AMMINISTRATORE
                    do {
                        scelta = menuMain(MAmministratore); 
                        switch (scelta){
                            case 1: { // AMM: Aggiungi Singolo Test                        
                                //Catalogo catalogo = new Catalogo();
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
                                
                                TestSingolo test = new TestSingolo(codiceSSN, nome, prezzo, valMax, valMin, msgValMax, msgValMin);
                                this.catalogo.addTest(test);
                                
                                System.out.println("Aggiunto test: ");
                                test.toString();
                                System.out.println("*****");
                                System.out.println("CATALOGO AGGIORNATO");
                                 System.out.println("*****");
                                this.catalogo.printCatalogoTest();
                                break;
                            }
                            
                            case 2: { // AMM: Aggiungi Test Diagnostico
                                
                                System.out.println("Inserisci codice: ");
                                String codiceSSN = Input.leggiStringa();
                                System.out.println("Inserisci nome: ");
                                String nome = Input.leggiStringa();
                                
                                TestDiagnostico testDiagnostico = new TestDiagnostico(codiceSSN, nome);
                                String code;
                                
                                do{
                                   System.out.println("Inserisci codice test da aggiungere (0 per terminare): ");
                                   code = Input.leggiStringa();
                                   if(!code.equals("0")){
                                        testDiagnostico.add(catalogo.getTest(code));
                                   }     
                                }while (!code.equals("0"));
                                
                                this.catalogo.addTest(testDiagnostico);
                                System.out.println("*****");
                                System.out.println("CATALOGO AGGIORNATO");
                                System.out.println("*****");
                                this.catalogo.printCatalogoTest();
                                
                                
                                break;
                            } 
                            
                            
                            case 3: { // AMM: Aggiungi Esenzione
                                System.out.println("Inserisci codice: ");
                                String codice = Input.leggiStringa();
                                System.out.println("Inserisci la percentuale da detrarre (da 0 a 100): ");
                                Double percentualeDetrarre = Input.leggiDouble();
                                Esenzione esenzione = new Esenzione(codice, percentualeDetrarre);
                                String code;
                                
                                do{
                                   System.out.println("Inserisci codice test da aggiungere (0 per terminare): ");
                                   code = Input.leggiStringa();
                                   if(!code.equals("0")){
                                        esenzione.addTest(catalogo.getTest(code));
                                   }     
                                }while (!code.equals("0"));
                                
                                this.catalogo.addEsenzione(esenzione);
                                System.out.println("*****");
                                System.out.println("CATALOGO ESENZIONI AGGIORNATO");
                                System.out.println("*****");
                                this.catalogo.printCatalogoEsenzioni();
                                
                                break;
                            }
                         }
                        }while (scelta !=4);
                     break;
                }
                
               
                case 2: {  // SEGRETARIO
                    do {
                        scelta = menuMain(MSegretario);
                        switch (scelta){
                            
                            case 1: {// SEG: Registra Prenotazione
                                break;
                            }
                            
                            case 2: {  // SEG: Registra Nuovo Paziente
                                System.out.println("Inserisci codice fiscale: ");
                                String codiceFiscale = Input.leggiStringa();
                                System.out.println("Inserisci nome e cognome: ");
                                String nomeCognome = Input.leggiStringa();
                                System.out.println("Inserisci data di nascita: ");
                                String dataNascita = Input.leggiStringa();
                                
                                Paziente paziente = new Paziente(codiceFiscale, nomeCognome, dataNascita);
                                
                                String code;
                                do{
                                   System.out.println("Inserisci codice esenzione da aggiungere (0 per terminare): ");
                                   code = Input.leggiStringa();
                                   if(!code.equals("0")){
                                        paziente.addEsenzione(catalogo.getEsenzione(code));
                                   }     
                                }while (!code.equals("0"));
                                
                                this.pazienti.put(codiceFiscale, paziente);
                                System.out.println("*****");
                                System.out.println("LISTA PAZIENTI AGGIORNATA");
                                System.out.println("*****");
                                this.printListaPazienti();
                            }    
                        }
                    }while (scelta !=3);
                    break;
                }
                
                case 3: {  // TECNICO LABORATORIO
                    do {
                        scelta = menuMain(MTecnico);
                        switch (scelta){
                            case 1: { // TECH: Aggiorna Esito
                                break;
                            }
                        }
                    }while (scelta !=2);
                    break;
                }
                case 4: { // PAZIENTE
                    do {
                        scelta = menuMain(MPaziente);
                        switch (scelta){
                            case 1: { // PAZ: Visualizza Esito
                                break;
                            }            
                        }
                    }while (scelta !=2);
                    break;
                }  
            }
        }while (scelta !=0);
    }
    
       public void printListaPazienti(){
        this.pazienti.forEach((key, value) -> System.out.println(key + ": " + value.toString()));
    }   
}
    

