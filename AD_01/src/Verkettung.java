public class Verkettung<T> implements LineareListe {
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
    }

    @Override
    public void entfernen(int position) throws IllegalArgumentException {
        if((position >= 0) && (position <= _anzahlElemente))
        {
            DoppelKnoten links = knotenAnPosition(position).gibVorgaenger();
            DoppelKnoten rechts = knotenAnPosition(position).gibNachfolger();
            links.setzeNachfolger(rechts);
            rechts.setzeVorgaenger(links);
            _anzahlElemente--;
        }
        else
        {
            throw new IllegalArgumentException("Ungueltige Position");
        }

    }

    @Override
    public Object gibElement(int position) throws IllegalArgumentException {
        if((position >= 0) && (position <= _anzahlElemente))
        {
            return knotenAnPosition(position).gibElement();
        }
        else
        {
            throw new IllegalArgumentException("Ungueltige Position");
        }
    }

    @Override
    public void leere() {
        _ende.setzeVorgaenger(_kopf);
        _kopf.setzeNachfolger(_ende);
        _anzahlElemente = 0;
    }

    // Ueberpruefen
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
}
