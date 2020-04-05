import java.lang.annotation.ElementType;
import java.util.ArrayList;

public class ArrayListe<T> implements LineareListe <T> {

    private T[] _elemente;
    private int _anzahlElemente;
    private static final int ANFANGSKAPAZITAET = 10;

    @SuppressWarnings("unchecked")
    ArrayListe(){
        _anzahlElemente = 0;
        _elemente = (T[]) new Object[ANFANGSKAPAZITAET];
    }
    @SuppressWarnings("unchecked")
    private ArrayListe(int kapazitaet){
        _anzahlElemente = 0;
        _elemente = (T[]) new Object[kapazitaet];
    }

    @Override
    public int anzahlElemente() {
        return _anzahlElemente;
    }

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

    @Override
    public void entfernen(int position) throws IllegalArgumentException {
        mussGueltigePositionSein(position);

        _elemente[position] = null;
        for (int i = (position+1); i < _elemente.length; i++)
        {
            _elemente[i] = _elemente[i-1];
        }
        _anzahlElemente--;
    }

    @Override
    public T gibElement(int position) throws IllegalArgumentException {
        return _elemente[position];
    }

    @Override
    public void leere() {
        int i;
        for (i = 0; i < _elemente.length; i++)
        {
            _elemente[i] = null;
        }
        _anzahlElemente = 0 ;
    }

    public boolean istGueltigePosition(int position) {
        return (position >= 0) && (position < anzahlElemente());
    }

    private void mussGueltigePositionSein(int position)
    {
        if (!istGueltigePosition(position))
        {
            throw new IndexOutOfBoundsException(position + " ist keine gueltige Position");
        }
    }
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
