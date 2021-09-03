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
public class AnaLabSystemTest {

    
    @BeforeEach
    private AnaLabSystem setUp() {
        AnaLabSystem anaLabSystem = new AnaLabSystem();
        
        // Test singoli
        anaLabSystem.nuovoSingoloTest("t_01", "Globuli Rossi", 5, 100, 20, "*", "*");
        anaLabSystem.nuovoSingoloTest("t_02", "Globuli Bianchi", 5, 100, 20, "*", "*");
        anaLabSystem.nuovoSingoloTest("t_03", "Piastrine", 7, 100, 20, "*", "*");
        anaLabSystem.nuovoSingoloTest("t_04", "Ferro", 10, 100, 20, "*", "*");

        // Test diagnostico
        TestDiagnostico testDiagnostico = anaLabSystem.nuovoTestDiagnostico("td_01", "Emocromo");
        anaLabSystem.aggiungiTestTestDiagnostico(testDiagnostico, "t_01");
        anaLabSystem.aggiungiTestTestDiagnostico(testDiagnostico, "t_02");
        anaLabSystem.aggiungiTestTestDiagnostico(testDiagnostico, "t_03");
        anaLabSystem.confermaTestDiagnostico(testDiagnostico);
        
        
        // Paziente senza esenzioni
        Paziente paziente2 = anaLabSystem.nuovoPaziente("SLVGLI00000", "Giulia Silvestro", "12/01/1995");
        anaLabSystem.confermaPaziente(paziente2);
        
        // Prenotazione paziente
        Prenotazione instance1 = anaLabSystem.nuovaPrenotazione();
        anaLabSystem.associaPazientePrenotazione(anaLabSystem.getPaziente("SLVGLI00000"), instance1);
        anaLabSystem.associaDataPrenotazione(anaLabSystem.addData("12/10/2021"), instance1);
        anaLabSystem.aggiungiTestPrenotazione(instance1, "td_01");
        anaLabSystem.aggiungiTestPrenotazione(instance1, "t_04");
        anaLabSystem.confermaPrenotazione(instance1);
        
        return anaLabSystem;
    }
    

    @Test
    public void testModificaEsito() {
        AnaLabSystem anaLabSystem = setUp();
        
        System.out.println("modificaEsito");
        double risultato = 10.0;
        String codiceTest = "t_01";
        
        anaLabSystem.modificaEsito(risultato, codiceTest, anaLabSystem.getPrenotazione("SLVGLI00000", "12/10/2021"));
        
        assertEquals(anaLabSystem.getPrenotazione("SLVGLI00000", "12/10/2021").getEsiti().get(0).getEsito(), risultato);
        assertEquals(anaLabSystem.getPrenotazione("SLVGLI00000", "12/10/2021").getEsiti().get(0).getTest(), anaLabSystem.getCatalogo().getTest(codiceTest));
   
    
    }

    
}
