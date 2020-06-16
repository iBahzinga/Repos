import java.util.ArrayList;

public interface Graph {

    /**
     *
     * @param knotenGraph
     */
    public void knotenEinfuegen(Knoten_Graph knotenGraph);

    /**
     *
     * @param quelle
     * @param ziel
     * @param gewichtung
     */
    public void kanteEinfuegen(Knoten_Graph quelle, Knoten_Graph ziel, int gewichtung);

    /**
     *
     * @param startKnotenGraph
     * @return
     */
    public void traversieren (Knoten_Graph startKnotenGraph);

    /**
     *
     * @return
     */
    public int gibAnzahlKanten();

    /**
     *
     * @return
     */
    public int gibAnzahlKnoten();

    /**
     *
     * @param quelle
     * @param ziel
     */
    public int gewichtAuslesen(Knoten_Graph quelle, Knoten_Graph ziel);

    /**
     *
     * @return
     */
    public Knoten_Graph gibStartKnoten();


    /**
     *
     * @return
     */
    public Knoten_Graph gibEndKnoten();


    /**
     * Ausgabe der Adiazenzmatrix/liste auf der Konsole
     */
    public void allesAusgeben ();

    /**
     *
     * @return
     */
    public ArrayList<Kante> gibAlleKanten();

    public ArrayList<Knoten_Graph> gibAlleKnoten();
}
