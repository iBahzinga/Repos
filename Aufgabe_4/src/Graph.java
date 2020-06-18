import java.util.ArrayList;

/**
 * Interface des Graphen
 *
 * Es ist eine schnittstelle fuer einen ungerichteten Graphen.
 * Die Knoten sind durchnummeriert bis anzahlknoten-1.
 * Es können immer weitere Knoten in den Graphen hinzugefuegt werden, allerdings lassen sich
 * keine Knoten aus diesem Graphen loeschen.
 * Kanten verbinden jeweils zwei knoten. Es wird eine Exception geworfen, wenn eine Kante zwischen zwei Knoten hinzugefuegt werden soll,
 * zwischen denen schon eine Kante besteht.
 * Die Kanten haben eine Gewichtung, die im Ganzzahlenbereich liegt. Die Gewichtung einer Kante kann nicht Negativ sein.
 * Die Kanten werden direkt ungerichtet eingefuegt, heißt es werden direkt beide Knoten miteinander verbunden.
 *
 * @author Daniel Dichte
 * @author Santa Rudevica
 * @author Pascal Kießler
 *
 * @version 2.1
 * @version 18.06.2020
 *
 */
public interface Graph {

    /**
     * Einfuegen eines neuen Knotens in den Graphen
     * @param knotenGraph Knoten der Eingefuegt wird
     * @throws IllegalArgumentException sollte der Knoten null sein
     */
    public void knotenEinfuegen(Knoten_Graph knotenGraph);

    /**
     * Einfuegen einer neuen Kante zwischen zwei existierenden Knoten in dem Graphen
     * @param quelle Quellknoten
     * @param ziel Zielknoten
     * @param gewichtung Gewichtung der Kante
     *
     * @throws IllegalArgumentException     Wenn der Quellknoten null sein sollte
     *                                      Wenn der Zielknoten null sein sollte
     *                                      Wenn die Gewichtung kleiner als Null sein sollte
     */
    public void kanteEinfuegen(Knoten_Graph quelle, Knoten_Graph ziel, int gewichtung);

    /**
     * Durchschreiten aller Knoten in dem gesamten Graphen.
     * Tote Knoten (Knoten ohne Kanten) werden dabei nicht traversiert, da dies nicht moeglich ist
     * @param startKnotenGraph Quellknoten von dem wir traversieren
     */
    public void traversieren (Knoten_Graph startKnotenGraph);

    /**
     * Liefert die Anzahl der Kanten in dem Graphen
     * @return Anzahl der Kanten
     */
    public int gibAnzahlKanten();

    /**
     * Liefert die Anzahl der Knoten in dem Graphen
     * @return Anzahl der Knoten
     */
    public int gibAnzahlKnoten();

    /**
     * Auslesen der Gewichtung einer kante, die zwischen zwei Knoten liegt
     * @param quelle Quellknoten
     * @param ziel Zielknoten
     * @return Gewichtung der Kante zwischen den Knoten
     */
    public int gewichtAuslesen(Knoten_Graph quelle, Knoten_Graph ziel);

    /**
     * Liefert den Startknoten in dem Graphen
     * @return Startknoten
     */
    public Knoten_Graph gibStartKnoten();


    /**
     * Liefert den Endknoten in dem Graphen
     * @return Endknoten
     */
    public Knoten_Graph gibEndKnoten();


    /**
     * Ausgabe der Adiazenzmatrix/-liste auf der Konsole
     */
    public void allesAusgeben ();

    /**
     * Liefert alle Kanten in einer ArrayList zurueck
     * @return Alle Kanten in einer ArrayList
     */
    public ArrayList<Kante> gibAlleKanten();

    /**
     * Liefert alle Knoten in einer ArrayList
     * @return Alle Knoten in einer ArrayList
     */
    public ArrayList<Knoten_Graph> gibAlleKnoten();
}
