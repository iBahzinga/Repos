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
    private Knoten startKnoten;
    //Ziel der Kante.
    private Knoten zielKnoten;
    //Gewichtung der Kante
    private int gewicht;

    /**
     * Initialisiert eine neue Kante und bindet sie zwischen zwei Knoten
     * @param startKnoten Ursprung der Kante
     * @param zielKnoten Ziel der Kante
     * @param gewicht Gewichtung der Kante
     */
    public Kante(Knoten startKnoten, Knoten zielKnoten, int gewicht) {
        this.startKnoten = startKnoten;
        this.zielKnoten = zielKnoten;
        this.gewicht = gewicht;
    }

    /**
     * Gibt das Ziel der Kante wieder.
     * @return Ziel der Kante.
     */
    public Knoten gibZiel() {
        return zielKnoten;
    }

    /**
     * Gibt die Quelle der Kante wieder.
     * @return Quelle der Kante
     */
    public Knoten gibQuelle() {
        return startKnoten;
    }

    /**
     * Gibt die Gewichtung der Kante wieder.
     * @return
     */
    public int gibGewicht() {
        return gewicht;
    }
}