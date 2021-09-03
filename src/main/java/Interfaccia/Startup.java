/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaccia;

import ClassiDominio.AnaLabSystem;
import ClassiDominio.Esenzione;
import ClassiDominio.Paziente;
import ClassiDominio.Prenotazione;
import ClassiDominio.TestDiagnostico;

/**
 *
 * @author giuliasilvestro
 */
public class Startup {
    //public AnaLabSystem anaLabSystem;
    
    public Startup(AnaLabSystem anaLabSystem){
        // Test singoli
        anaLabSystem.nuovoSingoloTest("t_01", "Globuli Rossi", 5, 100, 20, "*", "*");
        anaLabSystem.nuovoSingoloTest("t_02", "Globuli Bianchi", 5, 100, 20, "*", "*");
        anaLabSystem.nuovoSingoloTest("t_03", "Piastrine", 7, 100, 20, "*", "*");
        anaLabSystem.nuovoSingoloTest("t_04", "Ferro", 10, 100, 20, "*", "*");
        anaLabSystem.nuovoSingoloTest("t_05", "Tampone Molecolare Covid", 30, 0, 0.5, " ", "Positivo al SARS-CoV-2");
        
        // Test diagnostico
        TestDiagnostico testDiagnostico = anaLabSystem.nuovoTestDiagnostico("td_01", "Emocromo");
        anaLabSystem.aggiungiTestTestDiagnostico(testDiagnostico, "t_01");
        anaLabSystem.aggiungiTestTestDiagnostico(testDiagnostico, "t_02");
        anaLabSystem.aggiungiTestTestDiagnostico(testDiagnostico, "t_03");
        anaLabSystem.confermaTestDiagnostico(testDiagnostico);
        
        // Esenzioni
        Esenzione esenzione1 = anaLabSystem.nuovaEsenzione("e_01", 100);
        anaLabSystem.aggiungiTestEsenzione(esenzione1, "t_01");
        anaLabSystem.aggiungiTestEsenzione(esenzione1, "t_03");
        anaLabSystem.confermaEsenzione(esenzione1);
        
        Esenzione esenzione2 = anaLabSystem.nuovaEsenzione("e_02", 50);
        anaLabSystem.aggiungiTestEsenzione(esenzione2, "t_01");
        anaLabSystem.aggiungiTestEsenzione(esenzione2, "t_02");
        anaLabSystem.aggiungiTestEsenzione(esenzione2, "t_03");
        anaLabSystem.confermaEsenzione(esenzione2);
        
        Esenzione esenzione3 = anaLabSystem.nuovaEsenzione("e_03", 100);
        anaLabSystem.aggiungiTestEsenzione(esenzione3, "td_01");
        anaLabSystem.confermaEsenzione(esenzione3);
        
        // Paziente con una esenzione
        Paziente paziente1 = anaLabSystem.nuovoPaziente("PLORSS00000", "Paolo Rossi", "22/11/1990");
        anaLabSystem.aggiungiEsenzionePaziente(paziente1, "e_01");
        anaLabSystem.confermaPaziente(paziente1);
        
        // Paziente senza esenzioni
        Paziente paziente2 = anaLabSystem.nuovoPaziente("SLVGLI00000", "Giulia Silvestro", "12/01/1995");
        anaLabSystem.confermaPaziente(paziente2);
        
        // Paziente con 2 esenzioni sovrapposte
        Paziente paziente3 = anaLabSystem.nuovoPaziente("MROVRD00000", "Mario Verdi", "24/10/1980");
        anaLabSystem.aggiungiEsenzionePaziente(paziente3, "e_01");
        anaLabSystem.aggiungiEsenzionePaziente(paziente3, "e_02");
        anaLabSystem.confermaPaziente(paziente3);
        
        // Prenotazione paziente senza esenzioni
        Prenotazione prenotazione1 = anaLabSystem.nuovaPrenotazione();
        anaLabSystem.associaPazientePrenotazione(anaLabSystem.getPaziente("SLVGLI00000"), prenotazione1);
        anaLabSystem.associaDataPrenotazione(anaLabSystem.addData("12/10/2021"), prenotazione1);
        anaLabSystem.aggiungiTestPrenotazione(prenotazione1, "td_01");
        anaLabSystem.aggiungiTestPrenotazione(prenotazione1, "t_04");
        anaLabSystem.confermaPrenotazione(prenotazione1);
    }   
}
