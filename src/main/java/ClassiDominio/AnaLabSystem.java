package ClassiDominio;

import ClassiDominio.Esito;
import ClassiDominio.*;

import java.util.*;



public class AnaLabSystem {
    // Istanza singleton di AnaLabSystem 
    private static AnaLabSystem singleton;	
    // Catalogo che contiene le esenzioni e i test disponibili
    public Catalogo catalogo  = new Catalogo() ;
    // Pazienti registrati
    public Map<String,Paziente> pazienti = new HashMap<String,Paziente>();
    // Date prenotazioni
    public Map<String,Data> calendario = new HashMap<String,Data>();
    // Prenotazioni
    public Map<keyPrenotazione, Prenotazione> prenotazioni = new HashMap<keyPrenotazione, Prenotazione>();
    
    
   public AnaLabSystem() {
        
        /* Condizioni di avviamento*/
        TestSingolo test1 = new TestSingolo("t_01", "Globuli Rossi", 5, 100, 20, "*", "*");
        this.catalogo.addTest(test1);
        TestSingolo test2 = new TestSingolo("t_02", "Globuli Bianchi", 5, 100, 20, "*", "*");
        this.catalogo.addTest(test2);
        TestSingolo test3 = new TestSingolo("t_03", "Piastrine", 7, 100, 20, "*", "*");
        this.catalogo.addTest(test3);
        TestSingolo test4 = new TestSingolo("t_04", "Ferro", 10, 100, 20, "*", "*");
        this.catalogo.addTest(test4);
       
        /*TestDiagnostico test5 = new TestDiagnostico("td_01", "Emocromo");
        test5.addTest(catalogo.getTest("t_01"));
        test5.addTest(catalogo.getTest("t_02"));
        this.catalogo.addTest(test5);
        
        Esenzione esenzione1 = new Esenzione("e_01", 100);
        esenzione1.addTest(catalogo.getTest("td_01"));
        this.catalogo.addEsenzione(esenzione1);
        Esenzione esenzione2 = new Esenzione("e_02", 50);
        esenzione2.addTest(catalogo.getTest("t_01"));
        this.catalogo.addEsenzione(esenzione2);
        */
        Paziente paziente1 = new Paziente("SLVGLI95A52L042F", "Giulia Silvestro", "12/01/1995");
        //paziente.addEsenzione(esenzione1);
        pazienti.put("SLVGLI95A52L042F", paziente1);
        Paziente paziente2 = new Paziente("CFEPDG95A52L042F", "Paolo Rossi", "22/11/1990");
        //paziente.addEsenzione(esenzione1);
        pazienti.put("CFEPDG95A52L042F", paziente2);
        
        
        Data data = new Data("28/09/2021");
        calendario.put("28/09/2021", data);
        /*--------------------------*/
        
	}
    
   /*
    private static int menuMain(String s[]) {
        int i;
        for (String x : s) {
            System.out.println(x);
        }
        return i=Input.leggiIntero();
    }

    public static void main(String[] args) {
        try {
            AnaLabSystem obj = new AnaLabSystem();
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
                                aggiornaEsito();
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
                                visualizzaEsito();
                                break;
                            }            
                        }
                    }while (scelta !=2);
                    break;
                }  
            }
        }while (scelta !=0);
    }
    
*/    

        // UC5 Inserisci nuovo test singolo
        public TestSingolo nuovoSingoloTest(String codiceSSN, String nome, double prezzo, double valMax, double valMin, String msgValMax, String msgValMin){
            TestSingolo testSingolo = this.catalogo.creaTestSingolo(codiceSSN, nome, prezzo, valMax, valMin, msgValMax, msgValMin);
            return testSingolo;
        }
       
        // UC4 Inserisci nuovo test diagnostico
        public TestDiagnostico nuovoTestDiagnostico(String codiceSSN, String nome){
            TestDiagnostico testDiagnostico = this.catalogo.creaTestDiagnostico(codiceSSN, nome);
            return testDiagnostico;
        }
        
        public void aggiungiTestTestDiagnostico(TestDiagnostico testDiagnostico, String code){
            this.catalogo.aggiungiTestTestDiagnostico(testDiagnostico,code);
        }
        
        public void confermaTestDiagnostico(TestDiagnostico testDiagnostico){
            this.catalogo.addTest(testDiagnostico);
        }
        
        // UC2 Inserisci nuova esenzione
        public Esenzione nuovaEsenzione(String codice, double percentualeDetrarre){
            Esenzione esenzione = this.catalogo.creaEsenzione(codice, percentualeDetrarre);
            return esenzione;
        }
        
        public void aggiungiTestEsenzione(Esenzione esenzione, String code){
            this.catalogo.aggiungiTestEsenzione(esenzione,code);
        }
        
        public void confermaEsenzione(Esenzione esenzione){
            this.catalogo.addEsenzione(esenzione);
        }
        
       
        // UC6: Inserisci nuovo paziente
        public Paziente nuovoPaziente(String codiceFiscale, String nomeCognome, String dataNascita){
            Paziente paziente = new Paziente(codiceFiscale, nomeCognome, dataNascita);
            return paziente;
       }
        
        public void aggiungiEsenzionePaziente(Paziente paziente, String code){
            paziente.addEsenzione(this.catalogo.getEsenzione(code));
        }
        
        public void confermaPaziente(Paziente paziente){
            this.pazienti.put(paziente.getCodiceFiscale(), paziente);
        }
        
        //UC1: Registra prenotazione
        public Paziente getPaziente(String codiceFiscale){
            return pazienti.get(codiceFiscale);
        }
        
        public Data getData(String data){
            return calendario.get(data);
        }
        
        public Data addData(String data){
            Data d = new Data(data);
            calendario.put(data, d);
            return d;
        }
        
        public boolean verificaCapienzaData(Data data, int capienza){
            return calendario.get(data.getData()).getCounter()>capienza;
        }

        public void incrementaCounterData(Data data){
            calendario.get(data.getData()).incrCounter();
        }        
        
        public Prenotazione nuovaPrenotazione(Paziente paziente, Data data){
            Prenotazione prenotazione = new Prenotazione(paziente, data);
            return prenotazione;
        }
        
        public void aggiungiTestPrenotazione(Prenotazione prenotazione, String code){
            prenotazione.addTest(this.catalogo.getTest(code));
        }
        
        public void confermaPrenotazione(Prenotazione prenotazione){
            keyPrenotazione key = new keyPrenotazione(prenotazione.getPaziente().getCodiceFiscale(),prenotazione.getDate().getData());
            prenotazioni.put(key, prenotazione);
        }
        
        // UC8: Visualizza prenotazioni di una data
        public List<Prenotazione> getPrenotazioniData(String data){
            List<Prenotazione> listaPrenotazioni = new ArrayList<>();
            for (Map.Entry<keyPrenotazione, Prenotazione> pair : this.prenotazioni.entrySet()) {
                if(pair.getValue().getDate().getData().equals(data)){
                    listaPrenotazioni.add(pair.getValue());
                }
            }
            return listaPrenotazioni;
        }
        
        // UC3: Aggiorna esito test
        
        public Prenotazione getPrenotazione(String codiceFiscale, String data){
            keyPrenotazione key = new keyPrenotazione(codiceFiscale, data);
            return prenotazioni.get(key);
        }
        
        public void modificaEsito(double risultato, String codiceTest, Prenotazione prenotazione){
            Esito esito = new Esito((TestSingolo)catalogo.getTest(codiceTest), risultato);
            prenotazione.addEsito(esito); 
        }
        
   /*     
      
        


        
        public void visualizzaEsito(){
            System.out.println("Inserisci il tuo codice fiscale: ");
            String codiceFiscale = Input.leggiStringa();
            System.out.println("Inserisci data prenotazione (dd/mm/yyyy): ");
            String data = Input.leggiStringa();
            keyPrenotazione key = new keyPrenotazione(codiceFiscale, data);
            System.out.println("---------------------------------------------");
            System.out.println(prenotazioni.get(key).esitoToString());
        }
      */
        public void printListaPazienti(){
        this.pazienti.forEach((key, value) -> System.out.println(key + ": " + value.toString()));
    }   
        public Catalogo getCatalogo(){
            return this.catalogo;
        }
        
}

    

