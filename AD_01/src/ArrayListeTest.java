import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

class ArrayListeTest {

    private ArrayListe _elemente;

    public ArrayListeTest () {
        //ArrayListe<Integer>
        _elemente = new ArrayListe<Integer>();
    }


    @org.junit.jupiter.api.Test
    void testAnzahlElemente() {
    }


    /**
     * Testet das einfügen von Elementen in die Arrayliste.
     * Alle Elemente werden an die erste Stelle im Array geschrieben.
      */
    @org.junit.jupiter.api.Test
    void testEinfuegen() {
        Integer test1 = randomWert();
        Integer test2 = randomWert();
        Integer test3 = 42;
        Integer test4 = randomWert();
        Integer test5 = randomWert();
        _elemente.einfuegen(0, test1);
        _elemente.einfuegen(0, test2);
        _elemente.einfuegen(0, test3);
        _elemente.einfuegen(0, test4);
        _elemente.einfuegen(0, test5);
        assertSame(5, _elemente.anzahlElemente());
    }


    /**
     * Testet das entfernen an der ersten Stelle des Arrays
     */
    @org.junit.jupiter.api.Test
    void testEntfernenPosNull() {
        testEinfuegen();
        _elemente.entfernen(0);
        _elemente.entfernen(0);
        assertSame (3, _elemente.anzahlElemente());
    }


    /**
     * Testet das entfernen an der letzten Stelle des Arrays
     */
    @org.junit.jupiter.api.Test
    void testEntfernenPosEnd() {
        testEinfuegen();
        _elemente.entfernen(4);
        _elemente.entfernen(3);
        assertSame (3, _elemente.anzahlElemente());
    }


    /**
     * Testet das entfernen an einer ungültigen Position im Array
     * Es sollte eine OutOfBoundsEcxeption geworfen werden
     * @throws IndexOutOfBoundsException
     */
    @org.junit.jupiter.api.Test
    void testEntfernenungueltigePos() throws IndexOutOfBoundsException {
        testEinfuegen();
        boolean excYesNo = false;

        try {
            _elemente.entfernen(5);
        }
        catch (IndexOutOfBoundsException e) {
            excYesNo = true;
        }
        finally
        {
            assertTrue(excYesNo);
        }
        assertTrue(excYesNo);
    }


    /**
     * Testet das Rückgabeelement von der übergebenen Position
     */
    @org.junit.jupiter.api.Test
    void testGibElement() {
        testEinfuegen();
        Integer test = (Integer) _elemente.gibElement(2);
        assertEquals (42, _elemente.gibElement(2));

    }


    /**
     * Testet das leeren des gesamten Arrays
     */
    @org.junit.jupiter.api.Test
    void testLeere() {
        boolean leer = false;
        testEinfuegen();
        _elemente.leere();

        if (_elemente.gibElement(0) == null) {
            leer = true;
        }
        assertTrue(leer);
        assertSame(0, _elemente.anzahlElemente());
    }


    /**
     * Hilfsmethode um einen zufällig generierten Integer Wert zu erzeugen
     * @return
     */
    int randomWert () {
        int bisStelle = 2147483647;
        Random intWert = new Random();
        int rueckgabeInteger = intWert.nextInt(bisStelle);
        return rueckgabeInteger;
    }

}