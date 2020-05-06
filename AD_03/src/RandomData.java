import java.util.Random;

/**
 * Zufällige Pivot Strategie
 * wir ziehen uns ein beliebiges Element aus dem Array, welches im weiteren unser Pivotelement darstellt.
 */
public class RandomData <T extends Comparable<T>> implements PivotStrategie <T> {

    private final int ZERO;
    /**
     * Konstruktor der Klasse Randomdata
     */
    RandomData() {
        ZERO = 0;
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
     * Sortiert die Arrays und findet für jeden weiteren Aufruf ein neues Pivotelement.
     * Ruft sich rekursiv auf
     * @param array Generisches Array, das es zu sortieren gilt.
     * @param linkeSeite Linke hälfte des Pivotelementes
     * @param rechteSeite rechte hälfte des Pivotslementes
     */
    protected void sortiere (T array [], int linkeSeite, int rechteSeite) {
        if (rechteSeite > linkeSeite){
            int i = linkeSeite;
            int j = rechteSeite - 1;
            T pivot = getPivotelement(array);
            while (true) {
                T pivotI = array[i];
                T pivotJ = array[j];
                while (pivotI.compareTo(pivot) < ZERO) {
                    i++;
                }
                while (pivotJ.compareTo(pivot) >= ZERO && j > ZERO) {
                    j--;
                }
                if (i >= j) {
                    // In der Mitte getroffen
                    break;
                }
                // Vertauschen
                swap(array, i, j);
            }
            // Pivotelement in der Mitte tauschen
            swap(array, i, j);
            sortiere(array, linkeSeite, i - 1);
            sortiere(array, i + 1, rechteSeite);
        }
    }


    /**
     * Vertauschen der Elemente
     * @param erstesElement Erstes Element
     * @param zweitesElement Zweites Element
     */
    private void swap(T array [], int erstesElement, int zweitesElement) {
        T buffer = array[erstesElement];
        array[erstesElement] = array[zweitesElement];
        array[zweitesElement] = buffer;
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
