package Interfaccia;

import ClassiDominio.Esito;
import ClassiDominio.*;
import java.util.*;



public class AnaLab {
    // Istanza singleton di AnaLabSystem 
    private static AnaLab singleton;	
    // Catalogo che contiene le esenzioni e i test disponibili
    public Catalogo catalogo  = new Catalogo() ;
    // Pazienti registrati
    public Map<String,Paziente> pazienti = new HashMap<String,Paziente>();
    // Date prenotazioni
    public Map<String,Data> calendario = new HashMap<String,Data>();
    // Prenotazioni
    public Map<keyPrenotazione, Prenotazione> prenotazioni = new HashMap<keyPrenotazione, Prenotazione>();
    
    
   protected AnaLab() {
        
        /* Condizioni di avviamento*/
        TestSingolo test1 = new TestSingolo("t_01", "Globuli Rossi", 5, 100, 20, "*", "*");
        this.catalogo.addTest(test1);
        TestSingolo test2 = new TestSingolo("t_02", "Globuli Bianchi", 5, 100, 20, "*", "*");
        this.catalogo.addTest(test2);
        TestSingolo test3 = new TestSingolo("t_03", "Piastrine", 7, 100, 20, "*", "*");
        this.catalogo.addTest(test3);
        TestSingolo test4 = new TestSingolo("t_04", "Ferro", 10, 100, 20, "*", "*");
        this.catalogo.addTest(test4);
       
        TestDiagnostico test5 = new TestDiagnostico("td_01", "Emocromo");
        test5.addTest(catalogo.getTest("t_01"));
        test5.addTest(catalogo.getTest("t_02"));
        this.catalogo.addTest(test5);
        
        Esenzione esenzione1 = new Esenzione("e_01", 100);
        esenzione1.addTest(catalogo.getTest("td_01"));
        this.catalogo.addEsenzione(esenzione1);
        Esenzione esenzione2 = new Esenzione("e_02", 50);
        esenzione2.addTest(catalogo.getTest("t_01"));
        this.catalogo.addEsenzione(esenzione2);
        
        Paziente paziente = new Paziente("SLVGLI95A52L042F", "Giulia Silvestro", "12/01/1995");
        paziente.addEsenzione(esenzione1);
        pazienti.put("SLVGLI95A52L042F", paziente);
        
        Data data = new Data("28/09/2021");
        calendario.put("28/09/2021", data);
        /*--------------------------*/
        
	}
    
    private static int menuMain(String s[]) {
        int i;
        for (String x : s) {
            System.out.println(x);
        }
        return i=Input.leggiIntero();
    }

    public static void main(String[] args) {
        try {
            AnaLab obj = new AnaLab();
            obj.run (args);
        }
        catch (Exception e){
            e.printStackTrace ();
         }
    }
     
    public void run (String[] args) throws Exception { // Sostituisce l'interfaccia grafica
  
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
            scelta = menuMain(MMain);
            switch (scelta){
                
                case 1: { // AMMINISTRATORE
                    do {
                        scelta = menuMain(MAmministratore); 
                        switch (scelta){
                            case 1: { // AMM: Aggiungi Singolo Test                        
                                aggiungSingoloTest();
                                break;
                            }
                            case 2: { // AMM: Aggiungi Test Diagnostico
                                aggiungiTestDiagnostico();
                                break;
                            } 
                            case 3: { // AMM: Aggiungi Esenzione
                                aggiungiEsenzione();
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
                                registraPrenotazione();
                                break;
                            }
                            case 2: {  // SEG: Registra Nuovo Paziente
                                nuovoPaziente();
                                break;
                            }    
                            case 3:{ // SEG: Visualizza prenotazioni di una data
                                visualizzaPrenotazioniData();
                                break;
                            }
                        }
                    }while (scelta !=4);
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
       
        public void aggiungSingoloTest(){
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
       }
       
        public void aggiungiTestDiagnostico(){
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
                    testDiagnostico.addTest(catalogo.getTest(code));
               }     
            }while (!code.equals("0"));

            this.catalogo.addTest(testDiagnostico);
            System.out.println("********************");
            System.out.println("CATALOGO AGGIORNATO");
            System.out.println("********************");
            this.catalogo.printCatalogoTest();
        }
        
        public void aggiungiEsenzione(){
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
            System.out.println("********************");
            System.out.println("CATALOGO ESENZIONI AGGIORNATO");
            System.out.println("********************");
            this.catalogo.printCatalogoEsenzioni();
        }
       
        public String nuovoPaziente(){
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
            System.out.println("********************");
            System.out.println("LISTA PAZIENTI AGGIORNATA");
            System.out.println("********************");
            this.printListaPazienti();
            
            return codiceFiscale;
       }
        
        public void registraPrenotazione(){
            int flag = 0;
            String codiceFiscale;
            String data;

            // Verifica se esiste il paziente, o registrane uno nuovo.
            do{
                System.out.println("Inserisci codice fiscale del paziente. Digita 0 per registrare un nuovo paziente: ");
                codiceFiscale = Input.leggiStringa();

                if(codiceFiscale.equals("0")){
                    codiceFiscale = nuovoPaziente();
                    break;
                }

                if(pazienti.get(codiceFiscale) == null){
                    System.out.println("Il paziente inserito non è stato trovato.");
                    flag = 0;
                } else {
                        flag = 1;
                    }
            }while(flag!=1);
            
            // Verifica se il paziente ha nuove esenzioni
            String codEs = "0";
            do{
                System.out.println("Se il paziente ha una nuova esenzione inserirne il codice, altrimenti digitare 0: ");
                 codEs = Input.leggiStringa();
                 if(!codEs.equals("0")){
                     pazienti.get(codiceFiscale).addEsenzione(catalogo.getEsenzione(codEs));
                 }
            }while(!codEs.equals("0"));

            // Verifica se la data è disponibile, scegliere una data disponibile.
            flag = 0;
            do{
                System.out.println("Inserisci data prenotazione (dd/mm/yyyy): ");
                data = Input.leggiStringa();

                if(calendario.get(data) == null){
                    Data d = new Data(data);
                    calendario.put(data, d);
                    flag = 1;
                } else {
                    if(calendario.get(data).getCounter()>2){
                        System.out.println("Capienza massima di "+calendario.get(data).getCounter()+" raggiunta per il "+calendario.get(data).getData()+", scegliere un'altra data.");
                        flag = 0;
                    } else{
                        calendario.get(data).incrCounter();
                        flag = 1;
                    }
                    System.out.println("Counter for "+calendario.get(data).getData()+" =  "+calendario.get(data).getCounter());
                }
            }while(flag!=1);

            // Crea oggetto prenotazione con data e paziente.
            Prenotazione prenotazioneCorrente = new Prenotazione(pazienti.get(codiceFiscale), data);

            // Aggiungo test alla prenotazione
            String code;
            do{
               System.out.println("Inserisci codice test da aggiungere (0 per terminare): ");
               code = Input.leggiStringa();
               if(!code.equals("0")){
                    prenotazioneCorrente.addTest(catalogo.getTest(code));
               }     
            }while (!code.equals("0"));

            // Determina prezzo con esenzioni
            prenotazioneCorrente.setPrezzo();

            System.out.println("********************");
            System.out.println("RIEPILOGO PRENOTAZIONE");
            System.out.println("********************");
            System.out.println(prenotazioneCorrente.toString());
            System.out.println("Premi 1 per confermare, 0 per annullare");
            int conferma = Input.leggiIntero();
            if(conferma==1){
                keyPrenotazione key = new keyPrenotazione(codiceFiscale,data);
                prenotazioni.put(key, prenotazioneCorrente);
                System.out.println("Prenotazione confermata! ");
                //System.out.println(prenotazioni.get(key));
            }
        }
        
        public void visualizzaPrenotazioniData(){
            System.out.println("Inserisci data: ");
            String data = Input.leggiStringa();
            System.out.println("PRENOTAZIONI DEL "+data+": ");
            for (Map.Entry<keyPrenotazione, Prenotazione> pair : this.prenotazioni.entrySet()) {
                if(pair.getValue().getDate().equals(data)){
                    System.out.println("----------------------------------------");
                    System.out.println(pair.getValue().toString());
                }
            }
            System.out.println("----------------------------------------");
        }
        
       
        
        
                                
}

    

