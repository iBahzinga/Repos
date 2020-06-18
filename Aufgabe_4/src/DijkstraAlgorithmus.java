import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class DijkstraAlgorithmus {
    private final List<Kante> _kanten;
    private Set<Knoten_Graph> _entschiedenKnotenGraph;
    private Set<Kante> _entschiedenKanten;
    private Set<Knoten_Graph> _unentschieden;
    private Map<Knoten_Graph, Knoten_Graph> _vorgaenger;
    private Map<Knoten_Graph, Integer> _entfernung;
    private int _anzahlKnoten;

    public DijkstraAlgorithmus(Graph graph){
        _kanten = new ArrayList<>(graph.gibAlleKanten());
        _anzahlKnoten = graph.gibAnzahlKnoten();
        dijkstraAusfuehren(graph.gibStartKnoten());
    }

    public void dijkstraAusfuehren(Knoten_Graph start) {
        _entschiedenKnotenGraph = new HashSet<Knoten_Graph>();
        _entschiedenKanten = new HashSet<Kante>();
        _unentschieden = new HashSet<Knoten_Graph>();
        _entfernung = new HashMap<Knoten_Graph, Integer>();
        _vorgaenger = new HashMap<Knoten_Graph, Knoten_Graph>();
        _entfernung.put(start, 0);
        _unentschieden.add(start);

        int count = 0;

        while (_unentschieden.size() > 0) {
            //Findet den vom aktuellen Knoten kürzesten Weg zum nächsten Knoten.
            Knoten_Graph knotenGraph = minimum(_unentschieden);
            _entschiedenKnotenGraph.add(knotenGraph);

            //Zur Ausgabe der Reihenfolge auf der Konsole.
            if (count == 0) {
                System.out.println("---- Start ----");
            }
            System.out.println(knotenGraph.getPosition());
            if (_entschiedenKanten.size() == _anzahlKnoten) {
                System.out.println("---- Ende ----");
            }

            //Entferne den gerade bestimmten Knoten von den unentschiedenen Knoten.
            _unentschieden.remove(knotenGraph);
            //Findet die Minimale Distanz vom aktuellen Knoten zu seinen Nachbarknoten.
            findeMinimaleDistanz(knotenGraph);
            //Iterator für die Ausgabe auf der Konsole.
            count++;
        }
    }

    private Knoten_Graph minimum(Set<Knoten_Graph> unentschieden){
        Knoten_Graph min = null;
        for(Knoten_Graph knotenGraph : _unentschieden){
            if (min == null) {
                min = knotenGraph;
            }
            else{
                if(gibMinimaleStrecke(knotenGraph) < gibMinimaleStrecke(min))
                {
                    min = knotenGraph;
                }
            }
        }
        return min;
    }

    private void findeMinimaleDistanz(Knoten_Graph knotenGraph)
    {
        List<Knoten_Graph> benachbarteKnotenGraph = gibNachbarn(knotenGraph);
        for (Knoten_Graph ziel : benachbarteKnotenGraph)
        {
            //Wenn der Weg vom Startknoten(erster Knoten) bis zum aktuell betrachteten Knoten größer ist,
            //als die Summe von der Entfernung zum Elternknoten (vom Startknoten) + die Entfernung vom betrachteten Knoten
            //bis zum Elternknoten, dann ist der Weg über diesen Knoten kürzer (ist ein Knoten noch nicht besucht worden, dann
            //ist die Entfernung bis zu diesem unendlich(vom ersten Knoten aus gesehen))
            if (gibKuerzesteEntfernung(ziel) > gibKuerzesteEntfernung(knotenGraph) + gebeDistanz(knotenGraph, ziel))
            {
                //Vorgänger ist das Ziel <-> Nachfolger des Elternknoten ist der Knoten mit der geringsten Distanz
                _vorgaenger.put(ziel, knotenGraph);
                //Setzt die Entfernung neu zum aktuell betrachteten Knoten neu.
                _entfernung.put(ziel, gibKuerzesteEntfernung(knotenGraph) + gebeDistanz(knotenGraph, ziel));
                //nimmt den Knoten als ein Möglichkeit mit in das Set der unentschiedenen Knoten auf, denn ein Weg über einen anderen
                //Knoten könnte immer noch kürzer sein.
                _unentschieden.add(ziel);
            }
        }
    }

    private int gebeDistanz(Knoten_Graph quelle, Knoten_Graph ziel)
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
     * @param knotenGraph Vom welchem aus die Nachbarn bestimmt werden sollen.
     * @return Liste von Nachbarn eines Knoten.
     */
    private List<Knoten_Graph> gibNachbarn(Knoten_Graph knotenGraph)
    {
        List<Knoten_Graph> nachbarn = new ArrayList<Knoten_Graph>();
        for (Kante kante : _kanten)
        {
            if (kante.getQuelle().equals(knotenGraph) && !istEntschieden(kante.getZiel()))
            {
                nachbarn.add(kante.getZiel());
            }
        }
        return nachbarn;
    }


    private int gibMinimaleStrecke(Knoten_Graph ziel)
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

    private boolean istEntschieden(Knoten_Graph knotenGraph)
    {
        return _entschiedenKnotenGraph.contains(knotenGraph);
    }

    /**
     * Gibt die minimale Entfernung zu einem Knoten.
     * @param ziel der zu betrachtende Zielknoten
     * @return die Minimale Entfernung zu einem Knoten, ist noch keine Entfernung bestimmt zu diesem Knoten den MAX_VALUE,
     * d.h. Knoten wurde nach jetztigem Stand noch nicht betrachtet.
     */
    private int gibKuerzesteEntfernung(Knoten_Graph ziel)
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
