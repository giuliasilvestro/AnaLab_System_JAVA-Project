package ClassiDominio;

import ClassiDominio.Esito;
import ClassiDominio.*;

import java.util.*;



public class AnaLabSystem {
    // Istanza singleton di AnaLabSystem 
    private static AnaLabSystem anaLabSystem;	
    // Catalogo che contiene le esenzioni e i test disponibili
    private Catalogo catalogo  = new Catalogo() ;
    // Pazienti registrati
    private Map<String,Paziente> pazienti = new HashMap<String,Paziente>();
    // Date prenotazioni
    private Map<String,Data> calendario = new HashMap<String,Data>();
    // Prenotazioni
    private Map<keyPrenotazione, Prenotazione> prenotazioni = new HashMap<keyPrenotazione, Prenotazione>();
    
    
   public AnaLabSystem() {}

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
            return data.getCounter()>capienza;
        }
        
        public Prenotazione nuovaPrenotazione(){
            Prenotazione prenotazione = new Prenotazione();
            return prenotazione;
        }
        
        public void associaPazientePrenotazione(Paziente p, Prenotazione prenotazione){
             prenotazione.addPaziente(p);
        }
        
        public void associaDataPrenotazione(Data d,  Prenotazione prenotazione){
            prenotazione.addData(d);
            
        }
        
        public void aggiungiTestPrenotazione(Prenotazione prenotazione, String code){
            prenotazione.addTest(this.catalogo.getTest(code));
        }
        
        public void confermaPrenotazione(Prenotazione prenotazione){
            keyPrenotazione key = new keyPrenotazione(prenotazione.getPaziente().getCodiceFiscale(),prenotazione.getDate().getData());
            prenotazioni.put(key, prenotazione);
            calendario.get(prenotazione.getDate().getData()).incrCounter();
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
        
        // UC8: Visualizza esito
        public List<Esito> getEsito(String codiceFiscale, Data data){
            return this.getPrenotazione(codiceFiscale, codiceFiscale).getEsiti();
            
        }
        
    
        // Metodi funzionali
        
        public Catalogo getCatalogo(){
            return this.catalogo;
        }
        
        public Map<String,Paziente>  getPazienti(){
            return this.pazienti;
        }
        
        public  Map<keyPrenotazione, Prenotazione> getPrenotazioni(){
            return this.prenotazioni;
        }
        
        public Map<String,Data>  getCalendario(){
            return this.calendario;
        }
        
        public static AnaLabSystem getAnaLabSystem(){
            if (anaLabSystem==null){
                anaLabSystem = new AnaLabSystem();
            }
            return anaLabSystem;
        }
        
        public void printListaPazienti(){
            this.pazienti.forEach((key, value) -> System.out.println(key + ": " + value.toString()));
         }  
      
}

    

