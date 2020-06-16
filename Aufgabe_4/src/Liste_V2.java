import java.util.*;

public class Liste_V2 implements Graph{

    private ArrayList<Knoten> _knoten;
    private int anzahlKanten;
    private int anzahlKnoten;
    private Map<Knoten, List<Kante>> _adjListe;

    /**
     * Initialisiert einen Graphen mit einer Adjazenzliste mit einer vorgegebenen Anzahl an Knoten.
     *
     * @param anzahl Die Anzahl der Knoten.
     */
    public Liste_V2(int anzahl)
    {
        anzahlKnoten = 0;
        anzahlKanten = 0;
        _adjListe = new HashMap<Knoten, List<Kante>>();
        _knoten = new ArrayList<Knoten>();
        //befuelleGraphZufaellig(anzahl);
        resetVisited();
        //graphMalen();
    }
    /**
     * Initialisiert einen Graphen mit einer Adjazenzliste.
     *
     * @param start Der StartKnoten für den Graphen.
     */
    public Liste_V2(Knoten start)
    {
        pruefeNull(start);
        _knoten = new ArrayList<Knoten>();
        _knoten.add(0, start);
        _adjListe = new HashMap<Knoten, List<Kante>>();
        _adjListe.put(start, new LinkedList<Kante>());
        anzahlKnoten = 1;
        anzahlKanten = 0;
    }

    @Override
    public void knotenEinfuegen(Knoten knoten) {
        pruefeNull(knoten);
        knotenBereitsEingefuegt(knoten);

        _knoten.add(knoten.getPosition(),knoten);
        _adjListe.put(knoten, new LinkedList<Kante>());
        ++anzahlKnoten;
    }

    @Override
    public void kanteEinfuegen(Knoten start, Knoten ziel, int gewichtung) {
        pruefeNull(start);
        pruefeNull(ziel);
        pruefeAufGueltigkeit(gewichtung);

        kanteVor(start, ziel, gewichtung);
        kantezurueck(ziel, start, gewichtung);

        start.setKnotenVerbunden(true);
        ziel.setKnotenVerbunden(true);
        anzahlKanten = anzahlKanten + 2;
    }

    /**
     * Fügt eine Kante von Quelle nach Ziel mit einem angegebenen Gewicht ein.
     *
     * @param quelle Quelleknoten
     * @param ziel Zielknoten
     * @param gewichtung Gewicht der Kante
     */
    private void kanteVor(Knoten quelle, Knoten ziel, int gewichtung)
    {
        Kante neueKante = new Kante(quelle, ziel, gewichtung);
        List<Kante> kantenListe = _adjListe.get(quelle);
        Iterator<Kante> iterator = kantenListe.iterator();

        while(iterator.hasNext())
        {
            Kante k = iterator.next();
            if(k.getZiel().equals(ziel))
            {
                iterator.remove();
                anzahlKanten = anzahlKanten - 1;
            }
        }
        kantenListe.add(neueKante);
    }

    /**
     * Fügt eine Kante von Ziel nach Quelle mit einem angegebenen Gewicht ein.
     *
     * @param quelle Quelleknoten
     * @param ziel Zielknoten
     * @param gewichtung Gewicht der Kante
     */
    private void kantezurueck(Knoten ziel, Knoten quelle, int gewichtung)
    {
        Kante neueKante = new Kante(ziel, quelle, gewichtung);
        List<Kante> kantenListe = _adjListe.get(ziel);
        Iterator<Kante> iterator = kantenListe.iterator();

        while(iterator.hasNext())
        {
            Kante k = iterator.next();
            if(k.getZiel().equals(quelle))
            {
                iterator.remove();
                anzahlKanten = anzahlKanten - 1;
            }
        }
        kantenListe.add(neueKante);
    }

    @Override
    public int gewichtAuslesen(Knoten quelle, Knoten ziel) {
        pruefeNull(quelle);
        pruefeNull(ziel);

        for (Kante k : _adjListe.get(quelle))
        {
            if (k.getZiel().equals(ziel))
            {
                return k.getGewicht();
            }
        }
        return 0; //falls nicht verbunden
    }

    @Override
    public void traversieren(Knoten startKnoten) {
        pruefeNull(startKnoten);
        if (!startKnoten.getBereitsBesucht()) {
            startKnoten.setBereitsBesucht(true);
            for (Kante k : _adjListe.get(startKnoten))
            {
                traversieren(k.getZiel());
            }
            System.out.println(startKnoten.getPosition());
        }
    }

    @Override
    public int gibAnzahlKanten() {
        return anzahlKanten;
    }

    @Override
    public int gibAnzahlKnoten() {
        return anzahlKnoten;
    }

    @Override
    public Knoten gibStartKnoten() {
        return _knoten.get(0);
    }

    @Override
    public Knoten gibEndKnoten() {
        return _knoten.get(anzahlKnoten -1);
    }

    @Override
    public void allesAusgeben() {
        ArrayList<Kante> kanten = new ArrayList<Kante>();
        for(Knoten k : _knoten)
        {
            System.out.println("Knoten -> " + k.getPosition());
            if (k.getVerbunden())
            {
                for(Kante kante : _adjListe.get(k))
                {
                    System.out.println("\tKanten -> " + kante.getGewicht());
                }
            }
        }
    }

    public ArrayList<Knoten> gibAlleKnoten()
    {
        ArrayList<Knoten> result = new ArrayList<Knoten>();
        for(Knoten k : _knoten)
        {
            result.add(k);
        }
        return result;
    }


    /**
     * Prüft den übergebenen Knoten auf Null.
     * @param knoten Der übergebene Knoten
     *  @throws IllegalArgumentException, wenn Knoten null
     */
    private void pruefeNull(Knoten knoten)
    {
        if (knoten == null) {
            throw new IllegalArgumentException("Gültigen Knoten übergeben!");
        }
    }

    /**
     * Prüft, ob eine Gewichtung zulässig ist, nur Gewichtungen größer 0 sind zulässig.
     * @param gewichtung zu überprüfende Gewichtung
     * @throws IllegalArgumentException, wenn Gewichtung nicht zulässig
     */
    private void pruefeAufGueltigkeit(int gewichtung)
    {
        if (gewichtung < 0) {
            throw new IllegalArgumentException("Gewicht muss > 0 sein!");
        }
    }

    /**
     * Überprüft, ob ein Knoten bereits eingefügt wurde.
     * @param knoten
     *  @throws IllegalArgumentException, wenn Knoten bereits eingefügt.
     */
    private void knotenBereitsEingefuegt(Knoten knoten)
    {
        for (Knoten k : _knoten)
        {
            if (knoten.equals(k))
            {
                throw new IllegalArgumentException("Knoten ist bereits eingefügt!"); //Duplikate nicht erlaubt
            }
        }
    }

    /**
     * Setzt alle besuchten Knoten wieder als unbesucht.
     */
    private void resetVisited()
    {
        for(Knoten k : _knoten)
        {
            if(k != null)
            {
                k.setBereitsBesucht(false);
            }
        }
    }

    @Override
    public ArrayList<Kante> gibAlleKanten()
    {
        ArrayList<Kante> kanten = new ArrayList<Kante>();
        for(Knoten k : _knoten)
        {
            if (k.getVerbunden())
            {
                for(Kante kante : _adjListe.get(k))
                {
                    kanten.add(kante);
                }
            }
        }
        return kanten;
    }

}
