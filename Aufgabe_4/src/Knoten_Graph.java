/**
 * Objekt eines Knotens hat immer eine Position im Graphen.
 * Diese Position wird bei dem erstellen des Knotens gesetzt und kann abgefragt werden
 * Der Knoten weiss, ob dieser bereits von zum Beispiel des traversierens des Graphen schon einmal besucht wurde.
 * Sollte eine Kante an einem Knoten anliegen, weiss der Knoten auch dies.
 *
 * @author Daniel Dichte
 * @author Sante Rudevica
 * @author Pascal Kießler
 *
 * @version 1.1
 * @version 09.06.2020
 *
 */
public class Knoten_Graph {

    private int position;
    private boolean bereitsBesucht;
    private boolean knotenVerbunden;

    /**
     * Konstruktor der Klasse Knoten
     * @param position Position des Knotens
     */
    public Knoten_Graph(int position) {
        this.position = position;
        knotenVerbunden = false;
    }

    /**
     * Wenn der Knoten besucht wird, wird bereitsBesucht auf True gesetzt.
     * @param besucht Knoten besucht ja/nein
     */
    public void setBereitsBesucht (boolean besucht) {
        bereitsBesucht = besucht;
    }

    /**
     * Wenn der Knoten verbunden wird, wird knotenVerbunden auf True gesetzt
     * @param verbunden Knoten verbunden ja/nein
     */
    public void setKnotenVerbunden (boolean verbunden) {
        knotenVerbunden = verbunden;
    }

    /**
     * Liefert die Position dieses Knotens
     * @return Position des Knotens
     */
    public int getPosition () {
        return position;
    }

    /**
     * Liefert zurueck ob ueber den Koten bereits iteriert wurde oder nicht.
     * @return Besucht ja/nein
     */
    public boolean getBereitsBesucht() {
        return bereitsBesucht;
    }


    /**
     * Liefert zurueck ob der Knoten verbunden ist oder nicht.
     * @return Knoten schon verbunden ja/nein
     */
    public boolean getVerbunden () {
        return knotenVerbunden;
    }
}
