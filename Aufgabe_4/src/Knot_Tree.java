/**
 * Darstellung eines Knotens
 * Ein Knoten kennt seine Kinder und seinen Parent
 *
 * Einzige Ausnahme ist die Wurzel. Die Wurzel kennt keinen Parent.
 *
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
public class Knot_Tree<T extends Comparable<T>> {

    private T data;
    private Knot_Tree childLeft;
    private Knot_Tree childRight;
    private Knot_Tree parent;

    /**
     * Konstruktor der Klasse Knot
     * @param data Vergleichbarer Wert der in den Knoten eingefügt wird.  Der Knoten wiederrum wird in den Baum eingefügt.
     * @param parent Vater-/Mutterknoten des aktuellen Knotens
     */
    public Knot_Tree(T data, Knot_Tree parent) {
        this.data = data;
        this.parent = parent;
    }

    /**
     * Es werden die vergleichbaren Daten die sich in dem Knoten befinden geholt.
     *
     * @return Rueckgabe der Daten in dem Knoten
     */
    public T getData () {
        return data;
    }

    /**
     * Der linke Kindknoten wird zurueckgegeben
     * @return Rueckgabe des linken Kindknotens
     */
    public Knot_Tree getChildLeft () {
        return childLeft;
    }

    /**
     * Der rechte Kindknoten wird zurueckgegeben
     * @return Rueckgabe des rechten Kindknotens
     */
    public Knot_Tree getChildRight () {
        return childRight;
    }

    /**
     * Der Vater-/Mutterknoten wird zurueckgegeben
     * @return Rueckgabe des Vater-/Mutterknotens
     */
    public Knot_Tree getParent () {
        return parent;
    }

    /**
     * Setzen oder veraendern des linken Kindknotens.
     * @param childLeft Setzen des linken Kindknotens
     */
    public void setChildLeft(Knot_Tree childLeft) {
        this.childLeft = childLeft;
    }

    /**
     * Setzen oder veraendern des rechten Kindknotens
     * @param childRight Setzen des rechten Kindknotens
     */
    public void setChildRight(Knot_Tree childRight) {
        this.childRight = childRight;
    }

    /**
     * Setzen des Vater-/Mutterknotens
     * @param parent Setzen des Vater-Mutterknotens
     */
    public void setParent(Knot_Tree parent) {
        this.parent = parent;
    }
}
