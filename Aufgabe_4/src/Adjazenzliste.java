import java.util.*;

public class Adjazenzliste implements Graph{

    private ArrayList<Knoten_Graph> _knotenGraph;
    private int anzahlKanten;
    private int anzahlKnoten;
    private Map<Knoten_Graph, List<Kante>> _adjListe;

    /**
     * Initialisiert einen Graphen mit einer Adjazenzliste.
     *
     * @param start Der StartKnoten für den Graphen.
     */
    public Adjazenzliste(Knoten_Graph start)
    {
        pruefeNull(start);
        _knotenGraph = new ArrayList<Knoten_Graph>();
        _knotenGraph.add(0, start);
        _adjListe = new HashMap<Knoten_Graph, List<Kante>>();
        _adjListe.put(start, new LinkedList<Kante>());
        anzahlKnoten = 1;
        anzahlKanten = 0;
    }

    /**
     * Einfuegen eines neuen Knotens in den Graphen
     * @param knotenGraph Knoten der Eingefuegt wird
     * @throws IllegalArgumentException sollte der Knoten null sein
     */
    @Override
    public void knotenEinfuegen(Knoten_Graph knotenGraph) {
        pruefeNull(knotenGraph);
        knotenBereitsEingefuegt(knotenGraph);

        _knotenGraph.add(knotenGraph.getPosition(), knotenGraph);
        _adjListe.put(knotenGraph, new LinkedList<Kante>());
        ++anzahlKnoten;
    }

    /**
     * Einfuegen einer neuen Kante zwischen zwei existierenden Knoten in dem Graphen
     * @param start Quellknoten
     * @param ziel Zielknoten
     * @param gewichtung Gewichtung der Kante
     *
     * @throws IllegalArgumentException     Wenn der Quellknoten null sein sollte
     *                                      Wenn der Zielknoten null sein sollte
     *                                      Wenn die Gewichtung kleiner als Null sein sollte
     */
    @Override
    public void kanteEinfuegen(Knoten_Graph start, Knoten_Graph ziel, int gewichtung) {
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
     * Durchschreiten aller Knoten in dem gesamten Graphen.
     * Tote Knoten (Knoten ohne Kanten) werden dabei nicht traversiert, da dies nicht moeglich ist
     * @param startKnotenGraph Quellknoten von dem wir traversieren
     */
    @Override
    public void traversieren(Knoten_Graph startKnotenGraph) {
        pruefeNull(startKnotenGraph);
        if (!startKnotenGraph.getBereitsBesucht()) {
            startKnotenGraph.setBereitsBesucht(true);
            for (Kante k : _adjListe.get(startKnotenGraph))
            {
                traversieren(k.getZiel());
            }
            System.out.println(startKnotenGraph.getPosition());
        }
    }

    /**
     * Liefert die Anzahl der Kanten in dem Graphen
     * @return Anzahl der Kanten
     */
    @Override
    public int gibAnzahlKanten() {
        return anzahlKanten;
    }

    /**
     * Liefert die Anzahl der Knoten in dem Graphen
     * @return Anzahl der Knoten
     */
    @Override
    public int gibAnzahlKnoten() {
        return anzahlKnoten;
    }

    /**
     * Auslesen der Gewichtung einer kante, die zwischen zwei Knoten liegt
     * @param quelle Quellknoten
     * @param ziel Zielknoten
     * @return Gewichtung der Kante zwischen den Knoten
     */
    @Override
    public int gewichtAuslesen(Knoten_Graph quelle, Knoten_Graph ziel) {
        pruefeNull(quelle);
        pruefeNull(ziel);
        int ergebnis = -1;
      //  ergebnis = _adjListe.get(quelle)
        for (Kante k : _adjListe.get(quelle))
        {
            if (k.getZiel().equals(ziel))
            {
                return ergebnis;
            }
        }


        if(ergebnis == -1)
        {
            throw new IllegalArgumentException("Es existiert keine Kante!");
        }
        return ergebnis; //falls nicht verbunden
    }

    /**
     * Liefert den Startknoten in dem Graphen
     * @return Startknoten
     */
    @Override
    public Knoten_Graph gibStartKnoten() {
        return _knotenGraph.get(0);
    }

    /**
     * Liefert den Endknoten in dem Graphen
     * @return Endknoten
     */
    @Override
    public Knoten_Graph gibEndKnoten() {
        return _knotenGraph.get(anzahlKnoten -1);
    }

    /**
     * Ausgabe der Adiazenzmatrix/-liste auf der Konsole
     */
    @Override
    public void allesAusgeben() {
        ArrayList<Kante> kanten = new ArrayList<Kante>();
        for(Knoten_Graph k : _knotenGraph)
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

    /**
     * Liefert alle Kanten in einer ArrayList zurueck
     * @return Alle Kanten in einer ArrayList
     */
    @Override
    public ArrayList<Kante> gibAlleKanten()
    {
        ArrayList<Kante> kanten = new ArrayList<Kante>();
        for(Knoten_Graph k : _knotenGraph)
        {
            if (k.getVerbunden())
            {
                for(Kante kante : _adjListe.get(k))
                {
                    if (!kante.getGoennung()) {
                        kanten.add(kante);
                        kante.setGoennung(true);
                    }
                }
            }
        }
        return kanten;
    }

    /**
     * Liefert alle Knoten in einer ArrayList
     * @return Alle Knoten in einer ArrayList
     */
    @Override
    public ArrayList<Knoten_Graph> gibAlleKnoten()
    {
        ArrayList<Knoten_Graph> result = new ArrayList<Knoten_Graph>();
        for(Knoten_Graph k : _knotenGraph)
        {
            result.add(k);
        }
        return result;
    }

    /**
     * int ist falsch
     * @return
     */
    public ArrayList<Knoten_Graph> getNachbar (Knoten_Graph knoten) {
        ArrayList<Knoten_Graph> result = new ArrayList<Knoten_Graph>();
        for (Kante k : _adjListe.get(knoten))
        {
            result.add(k.getZiel());
        }

        return result;
    }



    /**
     * Liefert das gesamte Knotengraph Array wieder zurueck
     * @return ArrayList der Knoten
     */
    protected ArrayList<Knoten_Graph> getKnotenGraphArray () {
        return _knotenGraph;
    }

    /**
     * Fügt eine Kante von Quelle nach Ziel mit einem angegebenen Gewicht ein.
     *
     * @param quelle Quelleknoten
     * @param ziel Zielknoten
     * @param gewichtung Gewicht der Kante
     */
    private void kanteVor(Knoten_Graph quelle, Knoten_Graph ziel, int gewichtung)
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
    private void kantezurueck(Knoten_Graph ziel, Knoten_Graph quelle, int gewichtung)
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


    /**
     * Prüft den übergebenen Knoten auf Null.
     * @param knotenGraph Der übergebene Knoten
     *  @throws IllegalArgumentException, wenn Knoten null
     */
    private void pruefeNull(Knoten_Graph knotenGraph)
    {
        if (knotenGraph == null) {
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
     * @param knotenGraph
     *  @throws IllegalArgumentException, wenn Knoten bereits eingefügt.
     */
    private void knotenBereitsEingefuegt(Knoten_Graph knotenGraph)
    {
        for(Knoten_Graph k : _knotenGraph) {
            if (k.getPosition() == knotenGraph.getPosition()){
                throw new IllegalArgumentException("Knoten ist bereits eingefügt!"); //Duplikate nicht erlaubt
            }
        }
    }

}
