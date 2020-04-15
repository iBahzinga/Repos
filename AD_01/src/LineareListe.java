/**
 * Interface der Linearen Liste
 * Die Linearen Listen werden generisch gehalten
 *
 * @author Pascal Kießler
 * @author Santa Rudevica
 * @author Daniel Dichte
 *
 * @version 1.0
 *
 * @param <T>
 */
public interface LineareListe<T> {
    /**
     * Liefert die aktuelle Anzahl an Elementen wieder zurück, die sich in der liste befinden.
     * @return anzahl der Elemente in der Liste
     */
    int anzahlElemente();

    /**
     * Einfügen eines generischen Wertes in die Liste.
     * Bei ungültiger Positionsübergabe wird eine IllegalArgumentException geworfen.
     *
     * @param position Position in der das Element eingesetzt wird
     * @param element Element das in der Liste eingesetzt wird
     * @throws IllegalArgumentException
     */
    void einfuegen(int position, T element) throws IllegalArgumentException;

    /**
     * Entfernen eines Elementes der Liste.
     * Bei ungültiger Positionsübergabe wird eine IllegalArgumentException geworfen.
     *
     * @param position Position des Elementes das gelöscht werden soll
     * @throws IllegalArgumentException
     */
    void entfernen(int position) throws IllegalArgumentException;

    /**
     * Rückliefern eines bliebigen Elementes.
     * Bei ungültiger Positionsübergabe wird eine IllegalArgumentException geworfen.
     *
     * @param position Position des Elementes
     * @return
     * @throws IllegalArgumentException
     */
    T gibElement(int position) throws IllegalArgumentException;

    /**
     * Leeren der gesamten Liste.
     */
    void leere();
}
