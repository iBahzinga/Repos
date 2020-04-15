/**
 * Es wird eine verkettete Liste über Knoten erstellt.
 * Jeder Knoten hält seinen Vorgänger, seinen Nachfolger und das jeweilige Element, das generisch gehalten wird.
 *
 * @author Daniel Dichte
 * @author Pascal Kießler
 * @author Santa Rudevica
 *
 * @version 2.0
 */
public class Verkettung <T> implements LineareListe <T>{
    private DoppelKnoten _kopf;     //Wächter für den Listenanfang
    private DoppelKnoten _ende;     //Wächter für das Listenende
    private int _anzahlElemente;    //Kardinalitaet der Liste

    /**
     * Konstruktor der Klasse Verkettung
     */
    public Verkettung(){
        _anzahlElemente = 0;
        _kopf = new DoppelKnoten();
        _ende = new DoppelKnoten();
        _kopf.setzeNachfolger(_ende);
        _ende.setzeVorgaenger(_kopf);
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
    public void einfuegen(int position, Object element) throws IllegalArgumentException {
        darfNichtNullSein(element);
        mussGueltigeEinfuegepositionSein(position);

        DoppelKnoten neuesKettenglied = new DoppelKnoten();
        DoppelKnoten aktuelleStelle;
        neuesKettenglied.setzeElement(element);
        if (position < _anzahlElemente / 2)
        {
            /*
             * Wenn das Element in der ersten Hälfte der Liste eingefügt werden soll,
             * wird die Liste von dem Anfang durchgegangen.
             */
            aktuelleStelle = _kopf;
            int durchlaufen = position + 1;
            for (int i = 0;i < durchlaufen; i++)
            {
                aktuelleStelle = aktuelleStelle.gibNachfolger();
            }
        }
        else
        {
            /*
             * Wenn das Element weiter hinten in der Liste eingefügt werden soll,
             * wird vom Ende aus durchgegangen, um Rechenleistung zu sparen.
             */
            aktuelleStelle = _ende;
            int durchlaufen = _anzahlElemente - position;
            for (int i = 0; i < durchlaufen; i++)
            {
                aktuelleStelle = aktuelleStelle.gibVorgaenger();
            }
        }
        DoppelKnoten vorgaenger = aktuelleStelle.gibVorgaenger();
        vorgaenger.setzeNachfolger (neuesKettenglied);
        neuesKettenglied.setzeVorgaenger(vorgaenger);
        neuesKettenglied.setzeNachfolger(aktuelleStelle);
        aktuelleStelle.setzeVorgaenger(neuesKettenglied);
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
        DoppelKnoten aktuelleStelle;
        if (position < _anzahlElemente / 2)     //#Bestimmt die aktuelle Stelle
        {
            /*
             * Wenn ein Element in der ersten hälfte gelöscht werden soll, dann geht die Liste
             * von Anfang an alles durch um Rechenleistung zu sparen
             */
            aktuelleStelle = _kopf;
            int durchlaufen = position + 1;
            for (int i = 0;i < durchlaufen; i++)
            {
                aktuelleStelle = aktuelleStelle.gibNachfolger();
            }
        }
        else
        {
            /*
             * Wenn ein Element in der zweiten hälfte gelöscht werden soll, dann geht die Liste
             * vom Ende an alles rückwärts durch, um Rechenleistung zu sparen.
             */
            aktuelleStelle = _ende;
            int durchlaufen = _anzahlElemente - position;
            for (int i = 0; i < durchlaufen; i++)
            {
                aktuelleStelle = aktuelleStelle.gibVorgaenger();
            }
        }
        DoppelKnoten vorgaenger = aktuelleStelle.gibVorgaenger();
        DoppelKnoten nachfolger = aktuelleStelle.gibNachfolger();
        vorgaenger.setzeNachfolger(nachfolger);
        nachfolger.setzeVorgaenger(vorgaenger);
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
        mussGueltigePositionSein(position);
        DoppelKnoten knoten = _kopf;
        for (int i = 0; i <= position; ++i)
        {
            knoten = knoten.gibNachfolger();
        }
        return (T) knoten.gibElement();
    }

    /**
     * Leeren der gesamten Liste.
     */
    @Override
    public void leere() {
        _ende.setzeVorgaenger(_kopf);
        _kopf.setzeNachfolger(_ende);
        _anzahlElemente = 0;
    }

    /* -------------------------------------------------------------------------------------------------------------*/


    /**
     * Liefert true fuer alle gueltigen Positionen innerhalb der Liste.
     * @param position Position des Elementes
     * @return Position gültig oder ungültig
     */
    private boolean istGueltigePosition(int position)
    {
        return (position >= 0) && (position < anzahlElemente());
    }

    /**
     * Prüft ob die Position gültig ist.
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
     * Gibt zurück ob die Einfügeposition in Ordnung ist oder nicht.
     * @param position Position des Elementes
     * @return gültige oder ungültige Einfügeposition
     */
    private boolean istGueltigeEinfuegeposition(int position)
    {
        return (position >= 0) && (position <= anzahlElemente());
    }

    /**
     * Prüft die Einfügeposition
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
            throw new IllegalArgumentException("Das Element darf nicht Null sein!");
        }
    }
}
