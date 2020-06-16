/**
 * Darstellung eines Graphen als Adjazenzschreibweise.
 *
 * Es sollen in die Adjazenzmatrix weitere Knoten eingefügt werden können,
 * sowie auch die Knoten mit Kanten verbunden werden.
 *
 * Es soll basierend auf einem Knoten dieser durchtraversiert werden, um die Anzahl der Kanten zu finden, ausgehend dieses Knotens.
 * Der Knoten kann zurueckgeliefert werden, um sich anschließend die Daten zu holen.
 *
 * Man kann über einen knoten traversieren und die daten aller Knoten ausgeben lassen zu denen es eine Kante gibt.
 *
 * Es lässt sich die gesamte Matrix ausgeben auf der Konsole.
 *
 * Man kann sich die gesamte anzahl an Knoten ausgeben lassen.
 *
 *
 * @author Daniel Dichte
 * @author Santa Rudevica
 * @author Pascal Kießler
 *
 * @version 1.1
 * @version 14.06.2020
 *
 */
public class Adjazenzmatrix implements Graph {

    private int anzahlKnoten;
    private int anzahlKanten;
    private final int ARRAYSIZE;
    private Knoten knotenArray [];
    private Kante [][] adjazenzmatrix;

    public Adjazenzmatrix(Knoten startKnoten) {
        pruefeNull(startKnoten);
        anzahlKnoten = 1;
        anzahlKanten = 0;
        ARRAYSIZE = 4;
        knotenArray = new Knoten [ARRAYSIZE];
        adjazenzmatrix = new Kante [ARRAYSIZE][ARRAYSIZE];
    }

    @Override
    public void knotenEinfuegen(Knoten knoten) {
        pruefeNull(knoten);
        arrayErweitern();


    }

    @Override
    public void kanteEinfuegen(Knoten startKnoten, Knoten zielKnoten, int gewichtung) {
        pruefeNull(startKnoten);
        pruefeNull(zielKnoten);
        pruefeGewichtung(gewichtung);
    }

    @Override
    public int traversieren(Knoten startKnoten) {
        pruefeNull(startKnoten);
        return 0;
    }

    @Override
    public int gibAnzahlKanten() {
        return anzahlKanten;
    }

    @Override
    public int gibAnzahlKnoten() {
        return anzahlKnoten;
    }

    @Override
    public void gewichtTraversieren(Knoten startKnoten, Knoten zielKnoten) {
        pruefeNull(startKnoten);
        pruefeNull(zielKnoten);

    }

    @Override
    public Knoten gibStartKnoten() {
        return null;
    }

    @Override
    public Knoten gibEndKnoten() {
        return null;
    }

    @Override
    public void allesAusgeben() {

    }

    /**
     * Erweitert das Array individuell, sollten es zu voll sein.
     */
    private void arrayErweitern(){
        if (knotenArray.length / 2 <= anzahlKnoten){
            Knoten neuesKnotenArray[] = new Knoten[knotenArray.length * 2];
            for (int i = 0; i <= anzahlKnoten; i++){
                neuesKnotenArray[i] = knotenArray [i];
            }
            knotenArray = neuesKnotenArray;
            Kante neueAdjazenzmatrix[][] = new Kante [knotenArray.length * 2][knotenArray.length * 2];
            for (int i = 0; i <= anzahlKnoten; i++){
                for (int j = 0; j <= anzahlKnoten; j++){
                    neueAdjazenzmatrix[i][j] = adjazenzmatrix [i][j];
                }
            }
            adjazenzmatrix = neueAdjazenzmatrix;
        }
    }

    /**
     * Prueft ob die Gewichtung in einem Positiven bereich ist.
     * @param gewichtung zu Pruefende Gewichtung.
     */
    private void pruefeGewichtung (int gewichtung) {
        if (gewichtung < 0) {
            throw new IllegalArgumentException("Die Gewichtung einer Kante kann nicht kleiner als 0 sein. \n Ueberprüfen Sie die eingegebenen Werte");
        }
    }

    /**
     * Prueft ob der aktuelle Knoten nicht null ist.
     * @param knoten ueberpruefenden Knoten
     */
    private void pruefeNull (Knoten knoten) {
        if (knoten == null) {
            throw new IllegalArgumentException("Es muss ein Knoten uebergeben werden!")
        }
    }
}