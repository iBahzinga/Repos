/**
 * Eine Klasse, die Kanten eines Graphen modelliert.
 *
 * @author Daniel Dichte
 * @author Santa Rudevica
 * @author Pascal Kießler
 *
 * @version 1.1
 * @version 16.06.2020
 *
 */

public class Kante
{
    //Ursprung der Kante.
    private Knoten_Graph startKnotenGraph;
    //Ziel der Kante.
    private Knoten_Graph zielKnotenGraph;
    //Gewichtung der Kante
    private int gewicht;

    /**
     * Initialisiert eine neue Kante und bindet sie zwischen zwei Knoten
     * @param startKnotenGraph Ursprung der Kante
     * @param zielKnotenGraph Ziel der Kante
     * @param gewicht Gewichtung der Kante
     */
    public Kante(Knoten_Graph startKnotenGraph, Knoten_Graph zielKnotenGraph, int gewicht) {
        this.startKnotenGraph = startKnotenGraph;
        this.zielKnotenGraph = zielKnotenGraph;
        this.gewicht = gewicht;
    }

    /**
     * Gibt das Ziel der Kante wieder.
     * @return Ziel der Kante.
     */
    public Knoten_Graph getZiel() {
        return zielKnotenGraph;
    }

    /**
     * Gibt die Quelle der Kante wieder.
     * @return Quelle der Kante
     */
    public Knoten_Graph getQuelle() {
        return startKnotenGraph;
    }

    /**
     * Gibt die Gewichtung der Kante wieder.
     * @return
     */
    public int getGewicht() {
        return gewicht;
    }
}