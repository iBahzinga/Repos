/**
 * Interface für die Baeume.
 *
 * @author Daniel Dichte
 * @author Santa Rudevica
 * @author Pascal Kießler
 *
 * @version 1.1
 * @version 09.06.2020
 *
 * @param <T>
 */
public interface Search_ <T> {

    /**
     * Hinzufügen eines weiteren Knotens.
     * Ein weiterer Knoten wird automatisch an der richtigen Stelle hinzugefügt. (Es wird erkannt wo er eingefügt werden muss)
     * @param data Vergleichbarer Wert der in den Knoten eingefügt wird.  Der Knoten wiederrum wird in den Baum eingefügt.
     */
    public void addKnot(T data);

    /**
     * Ausgabe der gewöhlten Methode.
     * Man kann zwischen der Hauptreihenfolge, der Nebenreihenfolge sowie der Symmetrischen Reihenfolge auswählen.
     *
     * @param method Methode die erkennt in welcher Methode der Baum ausgegeben werden soll.
     *               1 -> Hauptreihenfolge
     *               2 -> Nebenreihenfolge
     *               3 -> Symmetrisch
     */
    public void output(int method);
}
