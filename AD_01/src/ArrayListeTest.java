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

    @org.junit.jupiter.api.Test
    void testEinfuegen() {
        Integer test1 = randomWert();
        _elemente.einfuegen(0, test1);
        test1 = randomWert();
        _elemente.einfuegen(0, test1);
        test1 = 42;
        _elemente.einfuegen(0, test1);
        test1 = randomWert();
        _elemente.einfuegen(0, test1);
        test1 = randomWert();
        _elemente.einfuegen(0, test1);
        assertSame(5, _elemente.anzahlElemente());
    }

    @org.junit.jupiter.api.Test
    void testEntfernen() {
        testEinfuegen();
        _elemente.entfernen(0);
        _elemente.entfernen(0);
        assertSame (3, _elemente.anzahlElemente());
    }

    @org.junit.jupiter.api.Test
    void testGibElement() {
        testEinfuegen();
        assertSame(42, _elemente.gibElement(2));

    }

    @org.junit.jupiter.api.Test
    void testLeere() {
    }

    int randomWert () {
        int bisStelle = 2147483647;
        Random intWert = new Random();
        int rueckgabeInteger = intWert.nextInt(bisStelle);
        return rueckgabeInteger;
    }

}