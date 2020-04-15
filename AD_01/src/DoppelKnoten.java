/**
 *
 * Ein Doppelknoten hält jeweils ein Element.
 * Das Element ist dabei generisch gehalten.
 * Jeder Doppelknoten kennt seinen Vorgänger und seinen Nachfolger
 *
 * @author Daniel Dichte
 * @author Pascal Kießler
 * @author Santa Rudevica
 *
 * @version 1.0
 *
 * @param <T> Generisch gehaltenes Element
 */
public class DoppelKnoten<T> {
    private DoppelKnoten _vorgaenger;
    private DoppelKnoten _nachfolger;
    private T _element;

    /**
     * Konstruktor der Klasse Doppelknoten
     *
     * @param vorgaenger An dieser Stelle der vordere Wächter der Liste
     * @param nachfolger An dieser Stelle der hintere Wächter der Liste
     * @param element Element des Knotens
     */
    public DoppelKnoten(DoppelKnoten vorgaenger, DoppelKnoten nachfolger, T element){
        _vorgaenger = vorgaenger;
        _nachfolger = nachfolger;
        _element = element;
    }

    /**
     * Konstruktor der Klasse Doppelknoten
     */
    public DoppelKnoten(){
        // braucht man für Konstruktor von der Verkettung
    };

    /**
     * Setzen eines (neuen) Nachfolgers des Doppelknotens
     *
     * @param nachfolger Den Nachfolger des Knotens
     */
    public void setzeNachfolger(DoppelKnoten nachfolger){
        _nachfolger = nachfolger;
    }

    /**
     * Setzen eines (neuen) Vorgängers des Doppelknotens
     *
     * @param vorgaenger Den Vorgänger des Knotens
     */
    public void setzeVorgaenger(DoppelKnoten vorgaenger){
        _vorgaenger = vorgaenger;
    }

    /**
     * Element in den Doppelknoten setzen
     *
     * @param element Übergebenes Element
     */
    public void setzeElement(T element){
        _element = element;
    }

    /**
     * Liefert den nachfolger des aktuellen Doppelknotens zurück
     *
     * @return Den Nachfolger des Knotens
     */
    public DoppelKnoten gibNachfolger() {
        return _nachfolger;
    }

    /**
     * Liefert den Vorgänger des aktuellen Doppelknotens zurück
     *
     * @return Den Vorgänger des Knotens
     */
    public DoppelKnoten gibVorgaenger() {
        return _vorgaenger;
    }

    /**
     * Liefert das Element des aktuellen Doppelknotens zurück
     *
     * @return Das Element des Knotens
     */
    public T gibElement() {
        return _element;
    }
}
