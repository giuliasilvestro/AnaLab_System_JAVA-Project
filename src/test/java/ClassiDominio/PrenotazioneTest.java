/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassiDominio;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author giuliasilvestro
 */
public class PrenotazioneTest {
    
 
    
    @BeforeEach
    public AnaLabSystem setUp() {
        AnaLabSystem anaLabSystem = new AnaLabSystem();
        
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
        
        return anaLabSystem;

    }
    
   

    
    /**
     * Test of setPrezzo method, of class Prenotazione.
     */
    @Test
    public void testSetPrezzo() {
        AnaLabSystem anaLabSystem = setUp();
        
        // Paziente senza esenzioni
        System.out.println("setPrezzo Paziente senza esenzioni");
        Prenotazione instance1 = new Prenotazione();
        anaLabSystem.associaPazientePrenotazione(anaLabSystem.getPaziente("SLVGLI00000"), instance1);
        anaLabSystem.associaDataPrenotazione(anaLabSystem.addData("12/10/2021"), instance1);
        anaLabSystem.aggiungiTestPrenotazione(instance1, "td_01");
        anaLabSystem.aggiungiTestPrenotazione(instance1, "t_04");
        anaLabSystem.confermaPrenotazione(instance1);
        instance1.setPrezzo();
        double expResult1 = 27.0;
        double result1 = instance1.getPrezzo();
        assertEquals(expResult1, result1);
        
        // Paziente con una esenzione
        System.out.println("setPrezzo Paziente con una esenzione");
        Prenotazione instance2 = new Prenotazione();
        anaLabSystem.associaPazientePrenotazione(anaLabSystem.getPaziente("PLORSS00000"), instance2);
        anaLabSystem.associaDataPrenotazione(anaLabSystem.addData("11/10/2021"), instance2);
        anaLabSystem.aggiungiTestPrenotazione(instance2, "t_01");
        anaLabSystem.aggiungiTestPrenotazione(instance2, "t_02");
        anaLabSystem.aggiungiTestPrenotazione(instance2, "t_03");
        anaLabSystem.confermaPrenotazione(instance2);
        instance2.setPrezzo();
        double expResult2 = 5.0;
        double result2 = instance2.getPrezzo();
        assertEquals(expResult2, result2);
        
        // Paziente con una esenzione
        System.out.println("setPrezzo Paziente con due esenzioni sovrapposte");
        Prenotazione instance3 = new Prenotazione();
        anaLabSystem.associaPazientePrenotazione(anaLabSystem.getPaziente("MROVRD00000"), instance3);
        anaLabSystem.associaDataPrenotazione(anaLabSystem.addData("10/10/2021"), instance3);
        anaLabSystem.aggiungiTestPrenotazione(instance3, "t_01");
        anaLabSystem.aggiungiTestPrenotazione(instance3, "t_02");
        anaLabSystem.aggiungiTestPrenotazione(instance3, "t_03");
        anaLabSystem.aggiungiTestPrenotazione(instance3, "t_05");
        anaLabSystem.confermaPrenotazione(instance3);
        instance2.setPrezzo();
        double expResult3 = 32.5;
        double result3 = instance3.getPrezzo();
        assertEquals(expResult3, result3);
        
    }
    
}
