import java.util.*;

public class DijkstraAlgorithmus {
    private final List<Kante> _kanten;
    private Set<Knoten> _entschiedenKnoten;
    private Set<Kante> _entschiedenKanten;
    private Set<Knoten> _unentschieden;
    private Map<Knoten, Knoten> _vorgaenger;
    private Map<Knoten, Integer> _entfernung;
    private int _anzahlKnoten;

    public DijkstraAlgorithmus(Graph graph){
        _kanten = new ArrayList<>(graph.gibAlleKanten());
        _anzahlKnoten = graph.gibAnzahlKnoten();
    }

    public void DijkstraAusfuehren(Knoten start) {
        _entschiedenKnoten = new HashSet<Knoten>();
        _entschiedenKanten = new HashSet<Kante>();
        _unentschieden = new HashSet<Knoten>();
        _entfernung = new HashMap<Knoten, Integer>();
        _vorgaenger = new HashMap<Knoten, Knoten>();
        _entfernung.put(start, 0);
        _unentschieden.add(start);

        int count = 0;

        while (_unentschieden.size() > 0) {
            //Findet den vom aktuellen Knoten kürzesten Weg zum nächsten Knoten.
            Knoten knoten = minimum(_unentschieden);
            _entschiedenKnoten.add(knoten);

            //Zur Ausgabe der Reihenfolge auf der Konsole.
            if (count == 0) {
                System.out.println("---- Start ----");
            }
            System.out.println(knoten.getPosition());
            if (_entschiedenKanten.size() == _anzahlKnoten) {
                System.out.println("---- Ende ----");
            }

            //Entferne den gerade bestimmten Knoten von den unentschiedenen Knoten.
            _unentschieden.remove(knoten);
            //Findet die Minimale Distanz vom aktuellen Knoten zu seinen Nachbarknoten.
            findeMinimaleDistanz(knoten);
            //Iterator für die Ausgabe auf der Konsole.
            count++;
        }
    }

    private Knoten minimum(Set<Knoten> unentschieden){
        Knoten min = null;
        for(Knoten knoten : _unentschieden){
            if (min == null) {
                min = knoten;
            }
            else{
                if(gibMinimaleStrecke(knoten) < gibMinimaleStrecke(min))
                {
                    min = knoten;
                }
            }
        }
        return min;
    }

    private void findeMinimaleDistanz(Knoten knoten)
    {
        List<Knoten> benachbarteKnoten = gibNachbarn(knoten);
        for (Knoten ziel : benachbarteKnoten)
        {
            //Wenn der Weg vom Startknoten(erster Knoten) bis zum aktuell betrachteten Knoten größer ist,
            //als die Summe von der Entfernung zum Elternknoten (vom Startknoten) + die Entfernung vom betrachteten Knoten
            //bis zum Elternknoten, dann ist der Weg über diesen Knoten kürzer (ist ein Knoten noch nicht besucht worden, dann
            //ist die Entfernung bis zu diesem unendlich(vom ersten Knoten aus gesehen))
            if (gibKuerzesteEntfernung(ziel) > gibKuerzesteEntfernung(knoten) + gebeDistanz(knoten, ziel))
            {
                //Vorgänger ist das Ziel <-> Nachfolger des Elternknoten ist der Knoten mit der geringsten Distanz
                _vorgaenger.put(ziel, knoten);
                //Setzt die Entfernung neu zum aktuell betrachteten Knoten neu.
                _entfernung.put(ziel, gibKuerzesteEntfernung(knoten) + gebeDistanz(knoten, ziel));
                //nimmt den Knoten als ein Möglichkeit mit in das Set der unentschiedenen Knoten auf, denn ein Weg über einen anderen
                //Knoten könnte immer noch kürzer sein.
                _unentschieden.add(ziel);
            }
        }
    }

    private int gebeDistanz(Knoten quelle, Knoten ziel)
    {
        int distanz = 0;
        for (Kante kante : _kanten)
        {
            if (kante.getQuelle().equals(quelle) && kante.getZiel().equals(ziel))
            {
                distanz = kante.getGewicht();
            }
        }
        return distanz;
    }

    /**
     * Bestimmt die Nachbarn eines Knotens.
     * @param knoten Vom welchem aus die Nachbarn bestimmt werden sollen.
     * @return Liste von Nachbarn eines Knoten.
     */
    private List<Knoten> gibNachbarn(Knoten knoten)
    {
        List<Knoten> nachbarn = new ArrayList<Knoten>();
        for (Kante kante : _kanten)
        {
            if (kante.getQuelle().equals(knoten) && !istEntschieden(kante.getZiel()))
            {
                nachbarn.add(kante.getZiel());
            }
        }
        return nachbarn;
    }


    private int gibMinimaleStrecke(Knoten ziel)
    {
        Integer d = _entfernung.get(ziel);
        if (d == null)
        {
            return Integer.MAX_VALUE;
        }
        else
        {
            return d;
        }
    }

    private boolean istEntschieden(Knoten knoten)
    {
        return _entschiedenKnoten.contains(knoten);
    }

    /**
     * Gibt die minimale Entfernung zu einem Knoten.
     * @param ziel der zu betrachtende Zielknoten
     * @return die Minimale Entfernung zu einem Knoten, ist noch keine Entfernung bestimmt zu diesem Knoten den MAX_VALUE,
     * d.h. Knoten wurde nach jetztigem Stand noch nicht betrachtet.
     */
    private int gibKuerzesteEntfernung(Knoten ziel)
    {
        Integer d = _entfernung.get(ziel);
        if (d == null)
        {
            return Integer.MAX_VALUE;
        }
        else
        {
            return d;
        }
    }
}
