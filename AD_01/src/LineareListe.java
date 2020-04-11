/**
 * Interface der Linearen Listen
 *
 * @author Pascal Kießler
 * @author Santa Rudevica
 * @author Daniel Dichte
 * @param <T>
 */
public interface LineareListe<T> {

    int anzahlElemente();
    void einfuegen(int position, T element) throws IllegalArgumentException;
    void entfernen(int position) throws IllegalArgumentException;
    T gibElement(int position) throws IllegalArgumentException;
    void leere();
}
