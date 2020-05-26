/**
 * Sortierverfahren um ein Array bestehend aus Zahlen zu sortieren.
 *
 * @author Santa Rudevica
 * @author Daniel Dichte
 * @author Pascal Kießler
 *
 * @version 1.0
 * @version 19.05.2020
 */
public class KleinsterKey<T extends Comparable<T>> implements PivotStrategie<T>{

    /**
     * Bestimmen eines Zufaelligen Pivotelementes, das zurückgegeben wird.
     * @param array Array der Elemente die zu sortieren sind
     * @return Rückgabe des Pivotelememtes
     */
    @Override
    public T getPivotelement (T[] array, int anfang, int ende) {
        //der kleinste Indexwert des Arrays wird bestimmt
        return array[anfang];
    }

}

