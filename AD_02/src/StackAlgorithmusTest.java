import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test der funktionalität des Stackbasierten Algorithmus
 *
 * @author Santa Rudevica
 * @author Daniel Dichte
 * @author Pascal Kießler
 *
 * @version 28.04.2020
 * @version 1.0
 */
public class StackAlgorithmusTest {

    private StackAlgorithmus testStackalgorithmus;
    public StackAlgorithmusTest () {
        testStackalgorithmus = new StackAlgorithmus();
    }

    /**
     * Testklasse um verschiedene Funktionen in dem algebraischen Aufruf zu testen
     */
    @org.junit.jupiter.api.Test
    void testMehrereFunktionen () {
        int testwert1 = testStackalgorithmus.algebraischeBerechnung("((6*(4+2))+(5-1))");
        int testwert2 = testStackalgorithmus.algebraischeBerechnung("(((2*2)+(325-248))*(2+(33-8)))");
        assertEquals (40, testwert1);
        assertEquals (2187, testwert2);
    }

    /**
     * Testklasse um die Addition in dem algebraischen Aufruf zu testen
     */
    @org.junit.jupiter.api.Test
    void testAddition () {
        int testwert1 = testStackalgorithmus.algebraischeBerechnung("((6+9)+(8+1))");
        int testwert2 = testStackalgorithmus.algebraischeBerechnung("(((600+900)+(800+100))+(300+700))");
        assertEquals (24, testwert1);
        assertEquals (3400, testwert2);
    }

    /**
     * Testklasse um die Subtraktion in dem algebraischen Aufruf zu testen
     */
    @org.junit.jupiter.api.Test
    void testSubtraktion () {
        int testwert1 = testStackalgorithmus.algebraischeBerechnung("((8-1)-(9-6))");
        int testwert2 = testStackalgorithmus.algebraischeBerechnung("(((800-100)-(900-600))-(700-300))");
        assertEquals (4, testwert1);
        assertEquals (0, testwert2);
    }

    /**
     * Testklasse um die Multiplikation in dem algebraischen Aufruf zu testen
     */
    @org.junit.jupiter.api.Test
    void testMultiplikation () {
        int testwert1 = testStackalgorithmus.algebraischeBerechnung("((2*3)*(2*1))");
        int testwert2 = testStackalgorithmus.algebraischeBerechnung("(((60*90)*(8*1))*(30*700))");
        assertEquals (12, testwert1);
        assertEquals (907200000, testwert2);
    }

    /**
     * Testklasse um die Division in dem algebraischen Aufruf zu testen
     */
    @org.junit.jupiter.api.Test
    void testDivision () {
        int testwert1 = testStackalgorithmus.algebraischeBerechnung("((6/3)/(4/2))");
        int testwert2 = testStackalgorithmus.algebraischeBerechnung("(((600/50)/(832/416))/(12/4))");
        assertEquals (1, testwert1);
        assertEquals (2, testwert2);
    }

    /**
     * Testklasse um die Division durch Null in dem algebraischen Aufruf zu testen
     */
    @org.junit.jupiter.api.Test
    void testDivisionDurchNull () {
        boolean excYesNo = false;
        try {
            int testwert1 = testStackalgorithmus.algebraischeBerechnung("(6/0)");
        }
        catch (ArithmeticException e) {
            excYesNo = true;
        }
        finally
        {
        }
        assertTrue(excYesNo);
    }

    /**
     * Testklasse um zu testen auch in den Negativen Bereich gehen zu koennen mit dem algebraischen Aufruf
     */
    @org.junit.jupiter.api.Test
    void testNegativeZahlen () {
        int testwert1 = testStackalgorithmus.algebraischeBerechnung("((6-36)+(3-73))");
        int testwert2 = testStackalgorithmus.algebraischeBerechnung("(2-4)");
        assertEquals (-100, testwert1);
        assertEquals (-2, testwert2);
    }

    /**
     * Testklasse um den algebraischen Aufruf mit einem leeren String zu testen
     */
    @org.junit.jupiter.api.Test
    void testLeererString () {
        int testwert1 = testStackalgorithmus.algebraischeBerechnung("");
        assertEquals (0, testwert1);
    }

    /**
     * Testklasse um den Übergabewert null zu testen
     */
    @org.junit.jupiter.api.Test
    void testUebergabeNull () {
        boolean excYesNo = false;
        try {
            int testwert1 = testStackalgorithmus.algebraischeBerechnung(null);
        }
        catch (IllegalArgumentException e) {
            excYesNo = true;
        }
        finally
        {
        }
        assertTrue(excYesNo);
    }

    /**
     * Testklasse um zu testen ob jede sich oeffnende Klammer auch ordnungsgemaeß schliesst.
     */
    @org.junit.jupiter.api.Test
    void testKlammersetzung () {
        boolean excYesNo = false;
        try {
            int testwert1 = testStackalgorithmus.algebraischeBerechnung("(((30+30)*30)");
        }
        catch (IllegalArgumentException e) {
            excYesNo = true;
        }
        finally
        {
        }
        assertTrue(excYesNo);
    }
}
