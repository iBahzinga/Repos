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
 * @version 1.1
 * @version 14.06.2020
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
     * Kontruktor der Klasse Adjazenzmatrix
     * @param mengeKnoten anzahl der Knoten die erstellt werden sollen
     */
    public Adjazenzmatrix(int mengeKnoten) {
        anzahlKnoten = 0;
        anzahlKanten = 0;
        ARRAYSIZE = 4;
        knotenGraphArray = new Knoten_Graph[ARRAYSIZE];
        adjazenzmatrix = new Kante [ARRAYSIZE][ARRAYSIZE];
        /*
        befuelleGraphZufaellig(anzahlKnoten);
        resetVisited();
        graphMalen();
        */
    }

    /**
     * Fuegt einen weiteren Knoten ein.
     * @param knotenGraph Weiterer Knoten der eingefuegt wird
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
     * Einfuegen einer Kante zwischen zwei Knoten
     * @param startKnotenGraph Startknoten von dem die Kante ausgehend ist
     * @param zielKnotenGraph Zielknoten zu dem die Kante geht
     * @param gewichtung Gewichtung der Kante
     */
    @Override
    public void kanteEinfuegen(Knoten_Graph startKnotenGraph, Knoten_Graph zielKnotenGraph, int gewichtung) {
        pruefeNull(startKnotenGraph);
        pruefeNull(zielKnotenGraph);
        pruefeGewichtung(gewichtung);
        if (adjazenzmatrix [startKnotenGraph.getPosition()][zielKnotenGraph.getPosition()] == null) {
            adjazenzmatrix [startKnotenGraph.getPosition()][zielKnotenGraph.getPosition()] = new Kante(startKnotenGraph, zielKnotenGraph, gewichtung);
            adjazenzmatrix [zielKnotenGraph.getPosition()][startKnotenGraph.getPosition()] = new Kante(zielKnotenGraph, startKnotenGraph, gewichtung);
            anzahlKanten += 2;
        }
    }

    /**
     * Durchlaufen jedes Knoten in dem Graphen. Jeder Knoten sollte dabei einmal durchlaufen werden.
     * @param startKnotenGraph Knoten von dem ausgegangen wird
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
     * Liefert die Anzahl der Kanten zurueck.
     * @return Anzahl der Kanten des Graphen
     */
    @Override
    public int gibAnzahlKanten() {
        return anzahlKanten;
    }

    /**
     * Liefert die anzahl der Knoten in unseren Graphen zurueck.
     * @return Anzahl der Knoten in dem Graphen.
     */
    @Override
    public int gibAnzahlKnoten() {
        return anzahlKnoten;
    }

    @Override
    public int gewichtAuslesen(Knoten_Graph startKnotenGraph, Knoten_Graph zielKnotenGraph) {
        pruefeNull(startKnotenGraph);
        pruefeNull(zielKnotenGraph);
        pruefeKanteVorhanden(startKnotenGraph, zielKnotenGraph);
        return adjazenzmatrix [startKnotenGraph.getPosition()][zielKnotenGraph.getPosition()].getGewicht();
    }

    /**
     * Liefert den Startknoten
     * @return Startknoten
     */
    @Override
    public Knoten_Graph gibStartKnoten() {
        return knotenGraphArray[0];
    }

    /**
     * Liefert den Endknoten
     * @return Endknoten
     */
    @Override
    public Knoten_Graph gibEndKnoten() {
        return knotenGraphArray[anzahlKnoten - 1];
    }

    /**
     * Gibt die Matrix auf der Konsole aus
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

    public ArrayList<Knoten_Graph> gibAlleKnoten(){
        ArrayList<Knoten_Graph> result = new ArrayList<Knoten_Graph>();
        for (int i = 0; i < anzahlKnoten - 1; i++) {
            result.add(knotenGraphArray[i]);
        }
        return result;
    }

    protected Knoten_Graph [] getKnotenGraphArray () {
        return knotenGraphArray;
    }

    protected Kante [][] getAdjazenzmatrix () {
        return adjazenzmatrix;
    }



    /**
     * Erweitert das Array individuell, sollten es zu voll sein.
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
     */
    private void pruefeGewichtung (int gewichtung) {
        if (gewichtung < 0) {
            throw new IllegalArgumentException("Die Gewichtung einer Kante kann nicht kleiner als 0 sein. \n Ueberprüfen Sie die eingegebenen Werte");
        }
    }

    /**
     * Prueft ob der aktuelle Knoten nicht null ist.
     * @param knotenGraph ueberpruefenden Knoten
     */
    private void pruefeNull (Knoten_Graph knotenGraph) {
        if (knotenGraph == null) {
            throw new IllegalArgumentException("Es muss ein Knoten uebergeben werden!");
        }
    }

    /**
     * Prueft ob der Knoten vorhanden ist.
     * @param knotenGraph knoten der ueberprueft wird.
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
     */
    private void pruefeKanteVorhanden (Knoten_Graph startKnotenGraph, Knoten_Graph zielKnotenGraph) {
        if (adjazenzmatrix[startKnotenGraph.getPosition()][zielKnotenGraph.getPosition()] == null) {
            throw new IllegalArgumentException("Es ist keine Kante zwischen den beiden Knoten vorhanden!");
        }
    }
}