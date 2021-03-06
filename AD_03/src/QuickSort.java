import javax.swing.*;
import java.util.Random;

public class QuickSort<T extends Comparable<T>> {

    private final int ZERO;
    private final int MANUELLSORTIEREN;

    /**
     * Konstruktor der Klasse Randomdata
     */
    QuickSort() {
        ZERO = 0;
        MANUELLSORTIEREN = 30;
    }


    /**
     * Sortiert die Arrays und findet für jeden weiteren Aufruf ein neues Pivotelement.
     * Ruft sich rekursiv auf
     * @param a Generisches Array, das es zu sortieren gilt.
     * @param iLinks Linke hälfte des Pivotelementes
     * @param iRechts rechte hälfte des Pivotslementes
     */
    public void sortiereQS (T a [], int iLinks, int iRechts, PivotStrategie strategie) {

        if ((iRechts - iLinks) <= MANUELLSORTIEREN) {
            sortiereIS(a);
        } else if (iRechts > iLinks) {
            int i = iLinks;
            int j = iRechts;
            T pivot = (T) strategie.getPivotelement(a, i, j);
            while (true) {
                while (a[i].compareTo(pivot) < ZERO) {
                    i++;
                }
                while (a[j].compareTo(pivot) >= ZERO && j > ZERO) {
                    j--;
                }
                if (i >= j) {
                    // In der Mitte getroffen
                    break;
                }
                // Vertauschen
                swap(a, i, j);
            }
            // Pivotelement in der Mitte tauschen
            swap(a, i, iRechts);
            sortiereQS(a, iLinks, i - 1, strategie);
            sortiereQS(a, i + 1, iRechts, strategie);
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
     * Sortiert nach der Insertion Sort Variante, sobald das Array 30 oder weniger elemente hat
     * @param array Generisches Array, das es zu sortieren gilt.
     */
    private void sortiereIS (T array []) {
        for (int i = 1; i < array.length; i++){
            int j = i;
            T element = array[i];
            while (j >= 1 && array[j - 1].compareTo(element) > ZERO){
                array[j] = array[j - 1];
                j = j - 1;
            }
            array[j] = element;
        }
    }


}
