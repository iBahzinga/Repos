import java.lang.annotation.ElementType;
import java.util.ArrayList;

/**
 * Es wird eine Arrayliste erstellt die generisch gehalten wird.
 * In der Liste können Elemente an beliebigen Stellen eingefügt- oder  gelöscht werden.
 * Es können elemente abgefragt werden und die Anzahl der Elemente kann ausgelesen werden.
 *
 * @author Santa Rudevica
 * @author Daniel Dichte
 * @author Pascal Kießler
 *
 * @version 1.0
 *
 * @param <T>
 */
public class ArrayListe<T> implements LineareListe <T> {
/* ---------- Instanzvariablen ---------- */
    private T[] _elemente;
    private int _anzahlElemente;
    private static final int ANFANGSKAPAZITAET = 10;

/* ---------- Konstruktoren ---------- */
    @SuppressWarnings("unchecked")
    public ArrayListe(){
        _anzahlElemente = 0;
        _elemente = (T[]) new Object[ANFANGSKAPAZITAET];
    }
    @SuppressWarnings("unchecked")
    public ArrayListe(int kapazitaet){
        _anzahlElemente = 0;
        _elemente = (T[]) new Object[kapazitaet];
    }

    /**
     * Liefert die aktuelle Anzahl an Elementen wieder zurück, die sich in der liste befinden.
     * @return anzahl der Elemente in der Liste
     */
    @Override
    public int anzahlElemente() {
        return _anzahlElemente;
    }

    /**
     * Einfügen eines generischen Wertes in die Liste.
     * Bei ungültiger Positionsübergabe wird eine IllegalArgumentException geworfen.
     *
     * @param position Position in der das Element eingesetzt wird
     * @param element Element das in der Liste eingesetzt wird
     * @throws IllegalArgumentException wenn eine ungültige Position eingegeben wurde.
     */
    @Override
    public void einfuegen(int position, T element) throws IllegalArgumentException {
        darfNichtNullSein(element);
        mussGueltigeEinfuegepositionSein(position);
        if (_anzahlElemente > _elemente.length / 2) {
            T[] _elementeAktualisieren = (T[]) new Object[_elemente.length * 2];
            for (int i = 0; i <= _anzahlElemente; i ++){
                _elementeAktualisieren [i] = _elemente [i];
            }
            _elemente = _elementeAktualisieren;
        }
        if (position - 1 < _anzahlElemente) {
            for (int i = _anzahlElemente -1; i >= position; i--) {
                int neuePosition = i + 1;
                _elemente[neuePosition] = _elemente[i];
            }
        }
        _elemente[position] = element;
       _anzahlElemente++;
    }

    /**
     * Entfernen eines Elementes der Liste.
     * Bei ungültiger Positionsübergabe wird eine IllegalArgumentException geworfen.
     *
     * @param position Position des Elementes das gelöscht werden soll
     * @throws IllegalArgumentException wenn eine ungültige Position eingegeben wurde.
     */
    @Override
    public void entfernen(int position) throws IllegalArgumentException {
        mussGueltigePositionSein(position);

        _elemente[position] = null;
        for (int i = (position + 1); i < _elemente.length; i++)
        {
            _elemente[i] = _elemente[i - 1];
        }
        _anzahlElemente--;
    }

    /**
     * Rückliefern eines bliebigen Elementes.
     * Bei ungültiger Positionsübergabe wird eine IllegalArgumentException geworfen.
     *
     * @param position Position des Elementes das gesucht wird.
     * @return Das Element an der übergebenen Position.
     * @throws IllegalArgumentException wenn eine ungültige Position eingegeben wurde.
     */
    @Override
    public T gibElement(int position) throws IllegalArgumentException {
        return _elemente[position];
    }

    /**
     * Leeren der gesamten Liste.
     */
    @Override
    public void leere() {
        int i;
        for (i = 0; i < _elemente.length; i++)
        {
            _elemente[i] = null;
        }
        _anzahlElemente = 0 ;
    }

    /**
     * Positionsprüfung des Arrays
     * @param position Position des Elementes
     * @return Boolischer Wert, ob Position gültig oder nicht ist.
     */
    public boolean istGueltigePosition(int position) {
        return (position >= 0) && (position < anzahlElemente());
    }

    /**
     * Positionsprüfung des Arrays
     * @param position Position des Elementes
     */
    private void mussGueltigePositionSein(int position)
    {
        if (!istGueltigePosition(position))
        {
            throw new IndexOutOfBoundsException(position + " ist keine gueltige Position");
        }
    }

    /**
     * Positionsprüfung des Arrays
     * @param position Position des Elementes
     * @return Boolischer Wert, ob Position gültig ist
     */
    public boolean istGueltigeEinfuegeposition(int position)
    {
        return (position >= 0) && (position <= anzahlElemente());
    }

    /**
     * Prüft ob die Position gültig ist.
     * @param position Position des Elementes
     */
    private void mussGueltigeEinfuegepositionSein(int position)
    {
        if (!istGueltigeEinfuegeposition(position))
        {
            throw new IndexOutOfBoundsException(
                    position + " ist keine gueltige Einfuegeposition");
        }
    }

    /**
     * Prüft den Wert des Elementes
     * @param element Element das geprüft wird.
     */
    private static void darfNichtNullSein(Object element)
    {
        if (element == null)
        {
            throw new IllegalArgumentException("Das Element darf nicht null sein");
        }
    }
}
