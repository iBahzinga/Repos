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
     * @throws IllegalArgumentException wenn eine ungültige Position eingegeben wurde.
     */
    void einfuegen(int position, T element) throws IllegalArgumentException;

    /**
     * Entfernen eines Elementes der Liste.
     * Bei ungültiger Positionsübergabe wird eine IllegalArgumentException geworfen.
     *
     * @param position Position des Elementes das gelöscht werden soll
     * @throws IllegalArgumentException wenn eine ungültige Position eingegeben wurde.
     */
    void entfernen(int position) throws IllegalArgumentException;

    /**
     * Rückliefern eines bliebigen Elementes.
     * Bei ungültiger Positionsübergabe wird eine IllegalArgumentException geworfen.
     *
     * @param position Position des Elementes das gesucht wird.
     * @return Das Element an der übergebenen Position.
     * @throws IllegalArgumentException wenn eine ungültige Position eingegeben wurde.
     */
    T gibElement(int position) throws IllegalArgumentException;

    /**
     * Leeren der gesamten Liste.
     */
    void leere();
}
