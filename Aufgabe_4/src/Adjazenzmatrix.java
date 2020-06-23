import java.util.*;

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
 * @version 2.1
 * @version 18.06.2020
 *
 */
public class Adjazenzmatrix implements Graph {

    private int anzahlKnoten;
    private int anzahlKanten;
    private final int ARRAYSIZE;
    private Knoten_Graph knotenGraphArray[];
    private Kante [][] adjazenzmatrix;

    /**
     * Kontruktor der Klasse Adjazenzmatrix
     * @param startKnotenGraph Erster Knoten
     */
    public Adjazenzmatrix(Knoten_Graph startKnotenGraph) {
        pruefeNull(startKnotenGraph);
        anzahlKnoten = 1;
        anzahlKanten = 0;
        ARRAYSIZE = 4;
        knotenGraphArray = new Knoten_Graph[ARRAYSIZE];
        adjazenzmatrix = new Kante [ARRAYSIZE][ARRAYSIZE];
        knotenGraphArray[0] = startKnotenGraph;
    }

    /**
     * Einfuegen eines neuen Knotens in den Graphen
     * @param knotenGraph Knoten der Eingefuegt wird
     * @throws IllegalArgumentException sollte der Knoten null sein
     */
    @Override
    public void knotenEinfuegen(Knoten_Graph knotenGraph) {
        pruefeNull(knotenGraph);
        pruefeKnotenVorhanden(knotenGraph);
        arrayErweitern();
        knotenGraphArray[anzahlKnoten] = knotenGraph;
        anzahlKnoten++;
    }

    /**
     * Einfuegen einer neuen Kante zwischen zwei existierenden Knoten in dem Graphen
     * @param startKnotenGraph Quellknoten
     * @param zielKnotenGraph Zielknoten
     * @param gewichtung Gewichtung der Kante
     *
     * @throws IllegalArgumentException     Wenn der Quellknoten null sein sollte
     *                                      Wenn der Zielknoten null sein sollte
     *                                      Wenn die Gewichtung kleiner als Null sein sollte
     */
    @Override
    public void kanteEinfuegen(Knoten_Graph startKnotenGraph, Knoten_Graph zielKnotenGraph, int gewichtung) {
        pruefeNull(startKnotenGraph);
        pruefeNull(zielKnotenGraph);
        pruefeGewichtung(gewichtung);
        if (adjazenzmatrix [startKnotenGraph.getPosition()][zielKnotenGraph.getPosition()] == null) {
            adjazenzmatrix [startKnotenGraph.getPosition()][zielKnotenGraph.getPosition()] = new Kante(startKnotenGraph, zielKnotenGraph, gewichtung);
            adjazenzmatrix [zielKnotenGraph.getPosition()][startKnotenGraph.getPosition()] = new Kante(zielKnotenGraph, startKnotenGraph, gewichtung);
            startKnotenGraph.setKnotenVerbunden(true);
            zielKnotenGraph.setKnotenVerbunden(true);
            anzahlKanten += 2;
        }
    }

    /**
     * Durchschreiten aller Knoten in dem gesamten Graphen.
     * Tote Knoten (Knoten ohne Kanten) werden dabei nicht traversiert, da dies nicht moeglich ist
     * @param startKnotenGraph Quellknoten von dem wir traversieren
     */
    public void traversieren(Knoten_Graph startKnotenGraph) {
        pruefeNull(startKnotenGraph);
        if (!startKnotenGraph.getBereitsBesucht()) {
            startKnotenGraph.setBereitsBesucht(true);
            for (int i = 0; i < anzahlKnoten; i++){
                if (adjazenzmatrix[startKnotenGraph.getPosition()][i] != null) {

                    traversieren(adjazenzmatrix[startKnotenGraph.getPosition()][i].getZiel());
                }
            }
            System.out.println(startKnotenGraph.getPosition());
        }
    }

    /**
     * Liefert die Anzahl der Kanten in dem Graphen
     * @return Anzahl der Kanten
     */
    @Override
    public int gibAnzahlKanten() {
        return anzahlKanten;
    }

    /**
     * Liefert die Anzahl der Knoten in dem Graphen
     * @return Anzahl der Knoten
     */
    @Override
    public int gibAnzahlKnoten() {
        return anzahlKnoten;
    }

    /**
     * Auslesen der Gewichtung einer kante, die zwischen zwei Knoten liegt
     * @param startKnotenGraph Quellknoten
     * @param zielKnotenGraph Zielknoten
     * @return Gewichtung der Kante zwischen den Knoten
     */
    @Override
    public int gewichtAuslesen(Knoten_Graph startKnotenGraph, Knoten_Graph zielKnotenGraph) {
        pruefeNull(startKnotenGraph);
        pruefeNull(zielKnotenGraph);
        pruefeKanteVorhanden(startKnotenGraph, zielKnotenGraph);
        return adjazenzmatrix [startKnotenGraph.getPosition()][zielKnotenGraph.getPosition()].getGewicht();
    }

    /**
     * Liefert den Startknoten in dem Graphen
     * @return Startknoten
     */
    @Override
    public Knoten_Graph gibStartKnoten() {
        return knotenGraphArray[0];
    }

    /**
     * Liefert den Endknoten in dem Graphen
     * @return Endknoten
     */
    @Override
    public Knoten_Graph gibEndKnoten() {
        return knotenGraphArray[anzahlKnoten - 1];
    }

    /**
     * Ausgabe der Adiazenzmatrix/-liste auf der Konsole
     */
    @Override
    public void allesAusgeben() {
        System.out.print("\t");
        for(int y = 0; y < anzahlKnoten; y++) //druckt die erste Zeile (alle Knoten in deren Reihenfolge)
        {
            System.out.print(knotenGraphArray[y].getPosition());
            System.out.print(" | ");
        }
        for(int i = 0; i < anzahlKnoten; i++) //druckt die übrigen Zeilen untereinander
        {
            System.out.println(" ");

            System.out.print(knotenGraphArray[i].getPosition());
            System.out.print(" |");
            for(int z = 0; z < anzahlKnoten; z++) //druckt die entsprechende Teile die die Gewichtungen von Knoten[i] anzeigt
            {
                if(adjazenzmatrix[i][z] != null) //kontrolliert, dass keine Kanten erzeugt werden, wo keine erzeugt werden können
                {
                    if(adjazenzmatrix[i][z] == null) //erstetzt alle Zellen in denen 0 steht durch " "
                    {
                        System.out.print(" false ");
                        System.out.print(" | ");
                    }
                    else
                    {
                        System.out.print(" 1 |");
                    }
                }
                else
                {
                    System.out.print(" 0 |");
                }
            }
        }
    }

    /**
     * Liefert alle Kanten in einer ArrayList zurueck
     * @return Alle Kanten in einer ArrayList
     */
    @Override
    public ArrayList<Kante> gibAlleKanten(){
        ArrayList<Kante> result = new ArrayList<Kante>();
        for (int i = 0; i < anzahlKnoten; i++){
            for (int y = 0; y < anzahlKnoten; y++) {
                if (adjazenzmatrix[i][y] != null) {
                    result.add(adjazenzmatrix[i][y]);
                }
            }
        }
        return result;
    }

    /**
     * Liefert alle Knoten in einer ArrayList
     * @return Alle Knoten in einer ArrayList
     */
    @Override
    public ArrayList<Knoten_Graph> gibAlleKnoten(){
        ArrayList<Knoten_Graph> result = new ArrayList<Knoten_Graph>();
        for (int i = 0; i < anzahlKnoten - 1; i++) {
            result.add(knotenGraphArray[i]);
        }
        return result;
    }

    public ArrayList<Knoten_Graph> getNachbar (Knoten_Graph knoten) {
        ArrayList<Knoten_Graph> result = new ArrayList<Knoten_Graph>();
        for (int i = 0; i <= anzahlKnoten; i++) {
            if (adjazenzmatrix[knoten.getPosition()][i] != null) {
                result.add(adjazenzmatrix[knoten.getPosition()][i].getZiel());
            }
        }
        return result;
    }

    /**
     * Liefert das komplette Array mit allen gespeicherten Knotenzurueck
     * Es befinden sich auch Knoten die durch das traversieren nicht erreichen lassen,
     * da hier auch Knoten abgespeichert werden die keine Kanten haben
     * @return Knoten_Graph [] Array
     */
    protected Knoten_Graph [] getKnotenGraphArray () {
        return knotenGraphArray;
    }

    /**
     * Liefert die gesamte Matrix mit allen Kanten zurueck
     * @return Gesamte Matrix der Kanten
     */
    protected Kante [][] getAdjazenzmatrix () {
        return adjazenzmatrix;
    }


    /**
     * Erweitert das Array individuell, sollten es zu voll sein
     */
    private void arrayErweitern(){
        if (knotenGraphArray.length / 2 <= anzahlKnoten){
            Knoten_Graph neuesKnotenGraphArray[] = new Knoten_Graph[knotenGraphArray.length * 2];
            for (int i = 0; i <= anzahlKnoten; i++){
                neuesKnotenGraphArray[i] = knotenGraphArray[i];
            }
            knotenGraphArray = neuesKnotenGraphArray;
            Kante neueAdjazenzmatrix[][] = new Kante [knotenGraphArray.length * 2][knotenGraphArray.length * 2];
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
     * @throws IllegalArgumentException Sollte die Gewichtung kleiner als Null sein
     */
    private void pruefeGewichtung (int gewichtung) {
        if (gewichtung < 0) {
            throw new IllegalArgumentException("Die Gewichtung einer Kante kann nicht kleiner als 0 sein. \n Ueberprüfen Sie die eingegebenen Werte");
        }
    }

    /**
     * Prueft ob der aktuelle Knoten nicht null ist.
     * @param knotenGraph ueberpruefenden Knoten
     * @throws IllegalArgumentException Sollte kein Knoten übergeben worden sein bzw. er null ist
     */
    private void pruefeNull (Knoten_Graph knotenGraph) {
        if (knotenGraph == null) {
            throw new IllegalArgumentException("Es muss ein Knoten uebergeben werden!");
        }
    }

    /**
     * Prueft ob der Knoten vorhanden ist.
     * @param knotenGraph knoten der ueberprueft wird.
     * @throws IllegalArgumentException Wenn dieser Knoten schon eingefuegt ist
     */
    private void pruefeKnotenVorhanden (Knoten_Graph knotenGraph) {
        for (int i = 0; i <= anzahlKnoten - 1; i++) {
            if (knotenGraph.getPosition() ==  knotenGraphArray[i].getPosition()) {
                throw new IllegalArgumentException("Der Knoten wurde bereits eingefuegt und doppelte Knoten sind verboten!");
            }
        }
    }

    /**
     * Prüft ob zwischen zwei Knoten eine Kante vorhanden ist.
     * @param startKnotenGraph Startknoten
     * @param zielKnotenGraph Zielknoten
     * @throws IllegalArgumentException Wenn keine Kante zwischen zwei Knoten vorhanden ist
     */
    private void pruefeKanteVorhanden (Knoten_Graph startKnotenGraph, Knoten_Graph zielKnotenGraph) {
        if (adjazenzmatrix[startKnotenGraph.getPosition()][zielKnotenGraph.getPosition()] == null) {
            throw new IllegalArgumentException("Es ist keine Kante zwischen den beiden Knoten vorhanden!");
        }
    }
}
