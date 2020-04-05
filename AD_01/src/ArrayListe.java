import java.lang.annotation.ElementType;
import java.util.ArrayList;

/**
 * Lineare liste
 * Es wird eine generische Arrayliste erstellt.
 * In der Liste können Elemente eingefügt- oder  gelöscht werden. Es können elemente abgefragt werden oder
 * die Anzahl der Elemente kann ausgelesen werden.
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
     * Ausgabe zum zurückliefern aller Elemente in der Arrayliste.
     * @return
     */
    @Override
    public int anzahlElemente() {
        return _anzahlElemente;
    }

    /**
     * Es wird ein generischer Wert in das Array gespeichert.
     * Wenn die Position ungültig sein sollte, wird eine Ecxeption geworfen.
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
     * Es wird ein Beliebiger Wert in der Arrayliste entfernt.
     * Die Zeichen nach entfernen des Elementes werden wieder richtig angeordnet.
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
     * Methode um einen beliebigen Wert an der übergebenen Position zurückliefern.
     * @param position
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public T gibElement(int position) throws IllegalArgumentException {
        return _elemente[position];
    }

    /**
     * Methode zum Leeren des kompletten Arrays.
     * Alle Stellen werden auf Null gesetzt.
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
