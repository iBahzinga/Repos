public class Verkettung <T> implements LineareListe <T>{
    private DoppelKnoten _kopf;
    private DoppelKnoten _ende;
    private int _anzahlElemente;    //Kardinalitaet

    public Verkettung(){
        _anzahlElemente = 0;
        _kopf = new DoppelKnoten();
        _ende = new DoppelKnoten();
        _kopf.setzeNachfolger(_ende);
        _ende.setzeVorgaenger(_kopf);
    }

    @Override
    public int anzahlElemente() {
        return _anzahlElemente;
    }


    @Override
    public void einfuegen(int position, Object element) throws IllegalArgumentException {
        darfNichtNullSein(element);
        mussGueltigeEinfuegepositionSein(position);

        DoppelKnoten neuesKettenglied = new DoppelKnoten();
        DoppelKnoten aktuelleStelle;
        neuesKettenglied.setzeElement(element);
        if (position < _anzahlElemente / 2)
        {
            aktuelleStelle = _kopf;
            int durchlaufen = position + 1;
            for (int i = 0;i < durchlaufen; i++)
            {
                aktuelleStelle = aktuelleStelle.gibNachfolger();
            }
        }
        else
        {
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




        /*
        if((position >= 0) && (position <= _anzahlElemente))
        {
            DoppelKnoten rechts = knotenAnPosition(position);
            DoppelKnoten links = rechts.gibVorgaenger();
            DoppelKnoten neu = new DoppelKnoten(links, rechts, element);
            links.setzeNachfolger(neu);
            rechts.setzeVorgaenger(neu);
            _anzahlElemente++;
        }
        else
        {
            throw new IllegalArgumentException("Ungueltige Position");
        }
         */
    }

    @Override
    public void entfernen(int position) throws IllegalArgumentException {
        mussGueltigePositionSein(position);
        DoppelKnoten aktuelleStelle;
        if (position < _anzahlElemente / 2)     //#Bestimmt die aktuelle Stelle
        {
            aktuelleStelle = _kopf;
            int durchlaufen = position + 1;
            for (int i = 0;i < durchlaufen; i++)
            {
                aktuelleStelle = aktuelleStelle.gibNachfolger();
            }
        }
        else
        {
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

    @Override
    public void leere() {
        _ende.setzeVorgaenger(_kopf);
        _kopf.setzeNachfolger(_ende);
        _anzahlElemente = 0;
    }


    private DoppelKnoten knotenAnPosition(int position)
    {
        DoppelKnoten result;
        if (position < _anzahlElemente / 2)
        {
            result = knotenAnPositionAufsteigend(position);
        }
        else
        {
            result = knotenAnPositionAbsteigend(position);
        }
        return result;
    }

    private DoppelKnoten knotenAnPositionAufsteigend(int position)
    {
        DoppelKnoten knoten = _kopf;
        for (int i = 0; i <= position; ++i)
        {
            knoten = knoten.gibNachfolger();
        }
        return knoten;
    }

    private DoppelKnoten knotenAnPositionAbsteigend(int position)
    {
        DoppelKnoten knoten = _ende;
        for (int i = _anzahlElemente; i > position; --i)
        {
            knoten = knoten.gibVorgaenger();
        }
        return knoten;
    }

    /* -------------------------------------------------------------------------------------------------------------*/


    /**
     * Liefert true fuer alle gueltigen Positionen innerhalb der Liste.
     */
    public boolean istGueltigePosition(int position)
    {
        return (position >= 0) && (position < anzahlElemente());
    }

    /**
     * Wirft eine IndexOutOfBoundsException, falls es sich um eine ungueltige
     * Position handelt.
     */
    private void mussGueltigePositionSein(int position)
    {
        if (!istGueltigePosition(position))
        {
            throw new IndexOutOfBoundsException(position + " ist keine gueltige Position");
        }
    }

    /**
     * Liefert true fuer alle gueltigen Einfuegepositionen innerhalb der Liste.
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
     * Wirft eine IllegalArgumentException, falls die uebergebene Titel-Referenz null ist.
     */
    private static void darfNichtNullSein(Object element)
    {
        if (element == null)
        {
            throw new IllegalArgumentException("Das Element darf nicht Null sein!");
        }
    }
}
