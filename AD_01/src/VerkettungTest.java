import org.junit.jupiter.api.Test;
/**
 * @author Santa Rudevica
 * @author Daniel Dichte
 * @author Pascal Kießler
 */
import static org.junit.jupiter.api.Assertions.*;
import java.util.Random;

class VerkettungTest {
    /* ---------- Instanzvariablen ---------- */
    private DoppelKnoten _elemente;
    private Integer testArray [];
    private final int anzahlStellenArray;

    /* ---------- Konstruktor ---------- */
    public VerkettungTest () {
        anzahlStellenArray = 100;
        _elemente = new DoppelKnoten();
        testArray = new Integer [anzahlStellenArray];
    }

    /**
     * Testet die aktuelle Anzahl der Elemente die sich in dem Array befinden.
     */
    @org.junit.jupiter.api.Test
    void testAnzahlElemente() {
        fuelleTestArray();
        LineareListe liste = erzeugeListe();

        for (int i = 0; i <= anzahlStellenArray - 1; i++){
            liste.einfuegen(0, testArray[i]);
        }
        assertEquals(100, liste.anzahlElemente());
    }


    /**
     * Testet das einfügen von Elementen in die Arrayliste.
     * Alle Elemente werden an die erste Stelle im Array geschrieben.
     */
    @org.junit.jupiter.api.Test
    void testEinfuegenErsteStelle() {
        fuelleTestArray();
        LineareListe liste = erzeugeListe();

        for (int i = 0; i <= anzahlStellenArray - 1; i++){
            liste.einfuegen(0, testArray[i]);
        }
        assertEquals(100, liste.anzahlElemente());
        assertEquals(42, liste.gibElement((anzahlStellenArray / 2)));
    }


    /**
     * Testet ob man irgendwo in der liste einfügen kann
     */
    @org.junit.jupiter.api.Test
    void testEinfuegenMitte() {
        fuelleTestArray();
        LineareListe liste = erzeugeListe();
        int letzteStelle = 0;
        Integer letzterWert = 0;
        for (int i = 0; i <= anzahlStellenArray - 1; i++){
            letzteStelle = randomWertFuerStelle(i);
            liste.einfuegen(letzteStelle, testArray[i]);
            letzterWert = testArray [i];
        }
        assertEquals(100, liste.anzahlElemente());
        assertEquals(letzterWert, liste.gibElement(letzteStelle));
    }


    /**
     * Testet ob man weiterhin immer am ende in der Liste einfügen kann.
     */
    @org.junit.jupiter.api.Test
    void testEinfuegenLetzteStelle() {
        fuelleTestArray();
        LineareListe liste = erzeugeListe();
        for (int i = 0; i <= anzahlStellenArray - 1; i++){
            liste.einfuegen(i, testArray[i]);
        }
        assertEquals(100, liste.anzahlElemente());
        assertEquals(42, liste.gibElement((anzahlStellenArray / 2) - 1));
    }


    /**
     * Testet das entfernen an der ersten Stelle des Arrays
     */
    @org.junit.jupiter.api.Test
    void testEntfernenAnfang() {
        LineareListe liste = erzeugeListe();
        fuelleTestArray();
        for (int i = 0; i <= anzahlStellenArray - 1; i++){  //zum erstellen der Liste
            liste.einfuegen(0, testArray[i]);
        }
        for (int i = 0; i <= 9; i++) {  // zum löschen von 10 elementen
            liste.entfernen(0);
        }
        assertEquals(90, liste.anzahlElemente());
        assertEquals(42, liste.gibElement(40));
    }

    /**
     * Testet das entfernen eines Elementes am Ende der Schleife.
     */
    @org.junit.jupiter.api.Test
    void testEntfernenEnde() {
        LineareListe liste = erzeugeListe();
        fuelleTestArray();
        for (int i = 0; i <= anzahlStellenArray - 1; i++){ // zum erstellen der Liste
            liste.einfuegen(0, testArray[i]);
        }
        for (int i = 99; i >= 90; i--) {  //zum löschen von 10 elementen
            liste.entfernen(i);
        }
        assertEquals(90, liste.anzahlElemente());
        assertEquals(42, liste.gibElement(50));
    }


    /**
     * Testet das Rückgabeelement von der übergebenen Position
     */
    @org.junit.jupiter.api.Test
    void testGibElement() {
        LineareListe liste = erzeugeListe();
        for (int i = 0; i <= anzahlStellenArray - 1; i++){ // zum erstellen der Liste
            liste.einfuegen(i, i);
        }
        assertEquals(0, liste.gibElement(0));
        assertEquals(1, liste.gibElement(1));
        assertEquals(98, liste.gibElement(98));
        assertEquals(99, liste.gibElement(99));
    }


    /**
     * Testet das leeren des gesamten Arrays
     */
    @org.junit.jupiter.api.Test
    void testLeere() {
        fuelleTestArray();
        LineareListe liste = erzeugeListe();
        for (int i = 0; i <= anzahlStellenArray - 1; i++){  //zum erstellen der Liste
            liste.einfuegen(0, testArray[i]);
        }
        liste.leere();
        assertEquals(0, liste.anzahlElemente());
    }


    /**
     * Hilfsmethode um einen zufällig generierten Integer Wert zu erzeugen
     * @return
     */
    Integer randomWertFuerArray() {
        int bisStelle = 2147483647;
        Random intWert = new Random();
        int rueckgabeInteger = intWert.nextInt(bisStelle);
        return rueckgabeInteger;
    }

    /**
     * Hilfsmethode um einen Zufallswert für
     * @param stelle
     * @return
     */
    Integer randomWertFuerStelle (int stelle) {
        Random intWert = new Random();
        int rueckgabeInteger = intWert.nextInt(1 + stelle);
        return rueckgabeInteger;
    }

    /**
     * Hilfsmethode um das Testarray zu füllen
     */
    public void fuelleTestArray () {
        Integer testInteger;
        for (int i = 0; i <= anzahlStellenArray - 1; i++){
            if (i == anzahlStellenArray / 2 - 1) {
                testArray [i] = 42;
            } else {
                testArray [i] = randomWertFuerArray();
            }
        }
    }

    /**
     * Methode um ein Objekt zu erzeugen der Liste.
     * @return
     */
    public LineareListe erzeugeListe() {
        return new Verkettung();
    }


}
