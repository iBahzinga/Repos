import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestQuicksort {
    final static int elemente = 2500;
    final static int ZERO = 0;

    /**
     * Testet Die Strategie ein zufälliges Element als Pivotelement auszuwählen.
     * Prüft die Reihenfolge des Arrays.
     */
/*@org.junit.jupiter.api.Test
    public void testReihenfolge () {
        PivotStrategie zufaelligesPivotelement = new ZufallPivot();
        PivotStrategie groessterKey = new GroessterKey();
        PivotStrategie kleinsterKey = new KleinsterKey();
        Integer zufallsElemente [] = new Integer[elemente];
        for (int i = ZERO; i <= zufallsElemente.length - 1; i++) {
            zufallsElemente[i] = zufall();
        }
        Integer zufallsElemente2 [] = zufallsElemente;
        Integer zufallsElemente3 [] = zufallsElemente;
        zufaelligesPivotelement.sortiereQS(zufallsElemente, ZERO, elemente - 1);
        groessterKey.sortiereQS(zufallsElemente2, ZERO, elemente - 1);
        kleinsterKey.sortiereQS(zufallsElemente3, ZERO, elemente - 1);
        assertTrue(richtigeReihenfolge(zufallsElemente));
        assertTrue(richtigeReihenfolge(zufallsElemente2));
        assertTrue(richtigeReihenfolge(zufallsElemente3));
    }

    @org.junit.jupiter.api.Test
    public void testBinarySearch () {
        Integer zuFindendesElement = 62;
        PivotStrategie zufaelligesPivotelement = new ZufallPivot();
        BinaereSuche findeElement = new BinaereSuche();
        Integer Elemente[] = new Integer[1000];
        for (int i = 1000, j = 0; i != 0; i--, j++) {
            Elemente[j] = i;
        }
        zufaelligesPivotelement.sortiereQS(Elemente, ZERO, 999);

        Integer result = findeElement.findElement(Elemente, zuFindendesElement, 0, 999);
        assertEquals(result, zuFindendesElement);
    }

*/




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
