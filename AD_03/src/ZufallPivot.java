import javax.swing.*;
import java.util.Random;

/**
 * Zufällige Pivot Strategie
 * wir ziehen uns ein beliebiges Element aus dem Array, welches im weiteren unser Pivotelement darstellt.
 */
public class ZufallPivot<T extends Comparable<T>> implements PivotStrategie <T> {

    /**
     * Bestimmen eines Zufaelligen Pivotelementes, das zurückgegeben wird.
     * @param array Array der Elemente die zu sortieren sind
     * @return Rückgabe des Pivotelememtes
     */
    @Override
    public T getPivotelement (T[] array, int anfang, int ende) {
        //zufälliges Pivotelement
        return array[zufallsPivotelement(anfang, ende)];
    }

    /**
     * Hilfsmethode um einen zufällig gewähltes Pivotelement zu bestimmen.
     * @return Stelle in dem Array
     */
    private int zufallsPivotelement(int i, int j) {
        Random zufaelligesElement = new Random();
        int range = j - i + 1;
        int pivotelement = zufaelligesElement.nextInt(range)+ i +1;
        return pivotelement;
    }


}
