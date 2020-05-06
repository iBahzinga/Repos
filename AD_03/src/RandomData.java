import java.util.Random;

/**
 * Zufällige Pivot Strategie
 * wir ziehen uns ein beliebiges Element aus dem Array, welches im weiteren unser Pivotelement darstellt.
 */
public class RandomData <T> implements PivotStrategie <T> {

    /**
     * Konstruktor der Klasse Randomdata
     */
    RandomData() {

    }

    /**
     * Bestimmen eines Zufaelligen Pivotelementes, das zurückgegeben wird.
     * @param array Array der Elemente die zu sortieren sind
     * @return Rückgabe des Pivotelememtes
     */
    @Override
    public T getPivotelement (T array []) {
    return array[zufallsPivotelement(array)];
}









    /**
     * Hilfsmethode um einen zufällig gewähltes Pivotelement zu bestimmen.
     * @return Stelle in dem Array
     */
    private int zufallsPivotelement(T array []) {
        Random zufaelligesElement = new Random();
        int pivotelement = zufaelligesElement.nextInt(array.length - 1);
        return pivotelement;
    }
}
