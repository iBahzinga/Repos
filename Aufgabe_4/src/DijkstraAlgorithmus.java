import java.util.*;
import java.util.concurrent.BrokenBarrierException;


/**
 * Klasse des Dijkstra Algorithmus.
 * Es wird der kürzeste weg zum Besuchen aller knoten bestimmt
 *
 * @author Daniel Dichte
 * @author Santa Rudevica
 * @author Pascal Kießler
 *
 * @version 1.1
 * @version 18.06.2020
 *
 */
public class DijkstraAlgorithmus {
    private final List<Kante> _kanten;
    private Set<Knoten_Graph> _entschiedenKnotenGraph;
    private Set<Kante> _entschiedenKanten;
    private Set<Knoten_Graph> _unentschieden;
    private Map<Knoten_Graph, Knoten_Graph> _vorgaenger;
    private Map<Knoten_Graph, Integer> _entfernung;
    private int _anzahlKnoten;
    private Graph g;

    /**
     * Konstruktor der Klasse DijkstraAlgorithmus
     * @param graph Graph mit Knoten
     */
    public DijkstraAlgorithmus(Graph graph){
        this.g = graph;
        _kanten = new ArrayList<>(graph.gibAlleKanten());
        _anzahlKnoten = graph.gibAnzahlKnoten();
        dijkstraAusfuehren(graph.gibStartKnoten());
    }

    /**
     * Fuehrt den Dijkstra Algorithmus aus.
     * @param start Quellknoten des Graphen.
     */
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
            Knoten_Graph knotenGraph = minimum(_unentschieden); //Sucht kuerzesten weg zum naechsten Knoten.
            _entschiedenKnotenGraph.add(knotenGraph);
            if (count == 0) {                                   // Reihenfolge auf der Konsole
                System.out.println("---- Start ----");
            }
            System.out.println(knotenGraph.getPosition());
            if (_entschiedenKanten.size() == _anzahlKnoten) {
                System.out.println("---- Ende ----");
            }
            _unentschieden.remove(knotenGraph);     //Entferne den gerade bestimmten Knoten von den unentschiedenen Knoten.
            findeMinimaleDistanz(knotenGraph);      //Findet die Minimale Distanz vom aktuellen Knoten zu seinen Nachbarknoten.
            count++;                                //Iterator für die Ausgabe auf der Konsole.
        }
    }

    /**
     * Es wird die Kante mit dem geringsten Gewicht gesucht und der Knoten der an der Kante anliegt zurueckgeliefert.
     * @param unentschieden unentschiedene Knoten
     * @return Der Knoten, in dem die Kante die kleinste gewichtung hatte
     */
    private Knoten_Graph minimum(Set<Knoten_Graph> unentschieden){
        Knoten_Graph min = null;
        for(Knoten_Graph knotenGraph : unentschieden){
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

    /**
     * Es wird die kleinste Distanz gefunden
     * @param knotenGraph Knoten im Graphen
     */
    private void findeMinimaleDistanz(Knoten_Graph knotenGraph)
    {
        List<Knoten_Graph> benachbarteKnotenGraph = gibNachbarn(knotenGraph);
        for (Knoten_Graph ziel : benachbarteKnotenGraph)
        {

            /*
             * Sollte der Weg des (Startknotens) ersten Knotens zum aktuellen groesser sein als die Summe von der Entfernung
             * des Parents vom ersten knoten (Startknotens) und die Entfernung vom betrachteten Knoten bis zum Parent,
             * dann ist der Weg ueber diesen Knoten kürzer
             */
            if (gibKuerzesteEntfernung(ziel) > gibKuerzesteEntfernung(knotenGraph) + gebeDistanz(knotenGraph, ziel))
            {
                _vorgaenger.put(ziel, knotenGraph); // Vorgaenger ist das Ziel, der Nachfolger des Parents ider der Knoten mit der kleinsten Distanz
                _entfernung.put(ziel, gibKuerzesteEntfernung(knotenGraph) + gebeDistanz(knotenGraph, ziel)); //Setzt Entfernung zum aktuellen Knoten neu
                _unentschieden.add(ziel); // Nimmt Knoten in Set der unterschiedlichen auf, da ein Weg ueber einen anderen Knoten kuerzer sein kann
            }
        }
    }

    /**
     * Liefert die Gewichtung der Kante zurueck
     * @param quelle Quellknoten
     * @param ziel Zielknoten
     * @return Gewichtung der Kante
     */
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
        //ArrayList<Knoten_Graph> test;
        return g.getNachbar(knotenGraph);
        /*List<Knoten_Graph> nachbarn = new ArrayList<Knoten_Graph>();
        for (Kante kante : _kanten)
        {
            if (kante.getQuelle().equals(knotenGraph) && !istEntschieden(kante.getZiel()))
            {
                nachbarn.add(kante.getZiel());
            }
        }
        return nachbarn;

         */
    }

    /**
     * Liefert die minimalste Strecke zurueck
     * @param ziel Zielknoten
     * @return kleinste strecke
     */
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

    /**
     * True wenn dies der gesuchte Endknoten ist
     * @param knotenGraph Knoten im Graphen
     * @return True, wenn dies der gesuchte Endknoten ist
     */
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
