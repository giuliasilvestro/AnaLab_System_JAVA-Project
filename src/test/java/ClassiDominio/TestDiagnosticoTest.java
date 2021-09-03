/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassiDominio;

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
public class TestDiagnosticoTest {
    AnaLabSystem anaLabSystem;


    @BeforeEach
    public AnaLabSystem setUp() {
        AnaLabSystem anaLabSystem = new AnaLabSystem();
        anaLabSystem.nuovoSingoloTest("t_01", "Globuli Rossi", 5, 100, 20, "*", "*");
        anaLabSystem.nuovoSingoloTest("t_02", "Globuli Bianchi", 5, 100, 20, "*", "*");
        anaLabSystem.nuovoSingoloTest("t_03", "Piastrine", 7, 100, 20, "*", "*");
        
        return anaLabSystem;
    }
    
    
    /**
     * Test of calcPrezzo method, of class TestDiagnostico.
     */
    @Test
    public void testCalcPrezzo() {
        AnaLabSystem anaLabSystem = setUp();
        // Mi aspetto che il prezzo di instance sia uguale al costo dei suoi test: 5+5+7
        System.out.println("calcPrezzo");
        TestDiagnostico instance = anaLabSystem.nuovoTestDiagnostico("td_01", "Emocromo");
        anaLabSystem.aggiungiTestTestDiagnostico(instance, "t_01");
        anaLabSystem.aggiungiTestTestDiagnostico(instance, "t_02");
        anaLabSystem.aggiungiTestTestDiagnostico(instance, "t_03");
        double expResult = 17.0;
        double result = instance.calcPrezzo();
        assertEquals(expResult, result);

    }

    
    
}
