/**
 * Interface der Pivot Strategie
 */
public interface PivotStrategie <T> {

    /**
     * Bestimmen eines Zufaelligen Pivotelementes, das zurückgegeben wird.
     * @param array Array der Elemente die zu sortieren sind
     * @return Rückgabe des Pivotelememtes
     */
    T getPivotelement (T array []);

    /**
     * Sortiert die Arrays und findet für jeden weiteren Aufruf ein neues Pivotelement.
     * Ruft sich rekursiv auf
     * @param array Generisches Array, das es zu sortieren gilt.
     * @param linkeSeite Linke hälfte des Pivotelementes
     * @param rechteSeite rechte hälfte des Pivotslementes
     */
    void sortiereQS (T array [], int linkeSeite, int rechteSeite);
}