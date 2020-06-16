public class Knoten {

    private int distanz;
    private int position;      //position des Knotens
    private boolean bereitsBesucht;
    private boolean knotenVerbunden;

    /**
     * Konstruktor der Klasse Knoten
     * @param position Position des Knotens
     */
    public Knoten(int position) {
        this.position = position;
        knotenVerbunden = false;
        distanz = (Integer.MAX_VALUE);
    }

    /**
     * Setzt die neue Distanz in diesem Knoten
     * @param distanz Distanz des Knotens
     */
    public void setDistanz (int distanz) {
        this.distanz = distanz;
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
     * Liefert Distanz zurueck
     * @return Distanz
     */
    public int getDistanz () {
    return distanz;
    }

    /**
     * Liefert zurueck ob der Knoten verbunden ist oder nicht.
     * @return Knoten schon verbunden ja/nein
     */
    public boolean getVerbunden () {
        return knotenVerbunden;
    }
}
