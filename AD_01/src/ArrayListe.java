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
     *
     * @return
     */
    @Override
    public int anzahlElemente() {
        return _anzahlElemente;
    }

    /**
     * Einfügen eines generischen Wertes in die Liste.
     * Bei ungültiger Positionsübergabe wird eine IllegalArgumentException geworfen.
     *
     * @param position
     * @param element
     * @throws IllegalArgumentException
     */
    @Override
    public void einfuegen(int position, T element) throws IllegalArgumentException {
        darfNichtNullSein(element);
        mussGueltigeEinfuegepositionSein(position);
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
     * @param position
     * @throws IllegalArgumentException
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
     * @param position
     * @return
     * @throws IllegalArgumentException
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
     * @param position
     * @return
     */
    public boolean istGueltigePosition(int position) {
        return (position >= 0) && (position < anzahlElemente());
    }

    /**
     * Positionsprüfung des Arrays
     * @param position
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
     * @param position
     * @return
     */
    public boolean istGueltigeEinfuegeposition(int position)
    {
        return (position >= 0) && (position <= anzahlElemente());
    }

    /**
     * Wirft eine IndexOutOfBoundsException, falls es sich um eine ungueltige
     * Einfuegeposition handelt.
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
     * Wirft eine IllegalArgumentException, falls null übergeben wird
     */
    private static void darfNichtNullSein(Object element)
    {
        if (element == null)
        {
            throw new IllegalArgumentException("Das Element darf nicht null sein");
        }
    }
}
