import org.junit.jupiter.api.DynamicTest;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestRandom {
    final static int elemente = 5000;
    final static int ZERO = 0;

    /**
     * Testet Die Strategie ein zufälliges Element als Pivotelement auszuwählen.
     * Prüft die Reihenfolge des Arrays.
     */
    @org.junit.jupiter.api.Test
    public void testReihenfolge () {
        PivotStrategie randomStrategie = new RandomData();
        Integer zufallsElemente [] = new Integer[elemente];
        for (int i = ZERO; i <= zufallsElemente.length - 1; i++) {
            zufallsElemente[i] = zufall();
        }
        randomStrategie.sortiereQS(zufallsElemente, ZERO, elemente - 1);
        assertTrue(richtigeReihenfolge(zufallsElemente));
    }

    @org.junit.jupiter.api.Test
    public void testRandomKeineZahlen (){
    }




    /**
     * Überprüfung ob Array erfolgreich sortiert wurde.
     * @param sortedArray Sortiertes Array
     * @return True wenn es erfolgreich sortiert wurde
     */
    private boolean richtigeReihenfolge (Integer sortedArray[]) {
        boolean sorted = false;
        for (int i = ZERO; i <= elemente - 1; i++) {
            int alterWert = ZERO;
            if (i == ZERO) {
                alterWert = sortedArray[i];
            } else if (sortedArray[i] >= alterWert) {
                sorted = true;
            } else {
                break;
            }
        }
        return sorted;
    }



    /**
     * Hilfsmethode um einen zufällig gewähltes Pivotelement zu bestimmen.
     * @return Stelle in dem Array
     */
    private int zufall () {
        Random zufaelligesElement = new Random();
        int pivotelement = zufaelligesElement.nextInt(1000000);
        return pivotelement;
    }

}
