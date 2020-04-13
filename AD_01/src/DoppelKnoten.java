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
 * @param <T>
 */
public class DoppelKnoten<T> {
    private DoppelKnoten _vorgaenger;
    private DoppelKnoten _nachfolger;
    private T _element;

    /**
     * Konstruktor der Klasse Doppelknoten
     *
     * @param vorgaenger
     * @param nachfolger
     * @param element
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
     * @param nachfolger
     */
    public void setzeNachfolger(DoppelKnoten nachfolger){
        _nachfolger = nachfolger;
    }

    /**
     * Setzen eines (neuen) Vorgängers des Doppelknotens
     *
     * @param vorgaenger
     */
    public void setzeVorgaenger(DoppelKnoten vorgaenger){
        _vorgaenger = vorgaenger;
    }

    /**
     * Element in den Doppelknoten setzen
     *
     * @param element
     */
    public void setzeElement(T element){
        _element = element;
    }

    /**
     * Liefert den nachfolger des aktuellen Doppelknotens zurück
     *
     * @return
     */
    public DoppelKnoten gibNachfolger() {
        return _nachfolger;
    }

    /**
     * Liefert den Vorgänger des aktuellen Doppelknotens zurück
     *
     * @return
     */
    public DoppelKnoten gibVorgaenger() {
        return _vorgaenger;
    }

    /**
     * Liefert das Element des aktuellen Doppelknotens zurück
     *
     * @return
     */
    public T gibElement() {
        return _element;
    }
}
