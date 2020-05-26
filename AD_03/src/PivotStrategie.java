/**
 * Interface der Pivot Strategie
 */
public interface PivotStrategie<T>{

    /**
     * Bestimmen eines Zufaelligen Pivotelementes, das zurückgegeben wird.
     *
     * @param array Array der Elemente die zu sortieren sind
     * @return Rückgabe des Pivotelememtes
     */
    T getPivotelement(T array[], int anfang, int ende);
}