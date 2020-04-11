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
     * @return
     */
    int anzahlElemente();

    /**
     * Einfügen eines generischen Wertes in die Liste.
     * Bei ungültiger Positionsübergabe wird eine IllegalArgumentException geworfen.
     *
     * @param position
     * @param element
     * @throws IllegalArgumentException
     */
    void einfuegen(int position, T element) throws IllegalArgumentException;

    /**
     * Entfernen eines Elementes der Liste.
     * Bei ungültiger Positionsübergabe wird eine IllegalArgumentException geworfen.
     *
     * @param position
     * @throws IllegalArgumentException
     */
    void entfernen(int position) throws IllegalArgumentException;

    /**
     * Rückliefern eines bliebigen Elementes.
     * Bei ungültiger Positionsübergabe wird eine IllegalArgumentException geworfen.
     *
     * @param position
     * @return
     * @throws IllegalArgumentException
     */
    T gibElement(int position) throws IllegalArgumentException;

    /**
     * Leeren der gesamten Liste.
     */
    void leere();
}
