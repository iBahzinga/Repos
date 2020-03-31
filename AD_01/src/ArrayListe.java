import java.lang.annotation.ElementType;
import java.util.ArrayList;

public class ArrayListe<T> implements LineareListe {

    private T[] _elemente;
    private int _anzahlElemente;
    private static final int ANFANGSKAPAZITAET = 10;


    private ArrayListe(){
        _anzahlElemente = 0;
        _elemente = (T[]) new Object[ANFANGSKAPAZITAET];
    }

    private ArrayListe(int kapazitaet){
        _anzahlElemente = 0;
        _elemente = (T[]) new Object[kapazitaet];
    }

    @Override
    public int anzahlElemente() {
        return _anzahlElemente;
    }

    @Override
    public void einfuegen(int position, Object element) throws IllegalArgumentException {
        darfNichtNullSein(element);
        mussGueltigeEinfuegepositionSein(position);
/*HELLO*/
        //DAs muss noch einkommentiert werden
       // _elemente[position] = T;
       // _anzahlElemente++;
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
    public Object gibElement(int position) throws IllegalArgumentException {
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
