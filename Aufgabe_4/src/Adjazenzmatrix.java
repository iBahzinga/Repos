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

    /**
     * Kontruktor der Klasse Adjazenzmatrix
     * @param startKnoten Erster Knoten
     */
    public Adjazenzmatrix(Knoten startKnoten) {
        pruefeNull(startKnoten);
        anzahlKnoten = 1;
        anzahlKanten = 0;
        ARRAYSIZE = 4;
        knotenArray = new Knoten [ARRAYSIZE];
        adjazenzmatrix = new Kante [ARRAYSIZE][ARRAYSIZE];
        knotenArray[0] = startKnoten;
    }

    /**
     * Fuegt einen weiteren Knoten ein.
     * @param knoten Weiterer Knoten der eingefuegt wird
     */
    @Override
    public void knotenEinfuegen(Knoten knoten) {
        pruefeNull(knoten);
        pruefeKnotenVorhanden(knoten);
        arrayErweitern();
        knotenArray[anzahlKnoten] = knoten;
    }

    /**
     * Einfuegen einer Kante zwischen zwei Knoten
     * @param startKnoten Startknoten von dem die Kante ausgehend ist
     * @param zielKnoten Zielknoten zu dem die Kante geht
     * @param gewichtung Gewichtung der Kante
     */
    @Override
    public void kanteEinfuegen(Knoten startKnoten, Knoten zielKnoten, int gewichtung) {
        pruefeNull(startKnoten);
        pruefeNull(zielKnoten);
        pruefeGewichtung(gewichtung);
        if (adjazenzmatrix [startKnoten.getPosition()][zielKnoten.getPosition()] == null) {
            adjazenzmatrix [startKnoten.getPosition()][zielKnoten.getPosition()] = new Kante(startKnoten, zielKnoten, gewichtung);
            adjazenzmatrix [zielKnoten.getPosition()][startKnoten.getPosition()] = new Kante(zielKnoten, startKnoten, gewichtung);
            anzahlKanten += 2;
        }
    }

    /**
     * Durchlaufen jedes Knoten in dem Graphen. Jeder Knoten sollte dabei einmal durchlaufen werden.
     * @param startKnoten Knoten von dem ausgegangen wird
     */
    public void traversieren(Knoten startKnoten) {
        pruefeNull(startKnoten);
        if (startKnoten.getBereitsBesucht()) {
            return;
        }
        startKnoten.setBereitsBesucht(true);
        for (int i = 0; i < anzahlKnoten; i++){
            if (adjazenzmatrix[startKnoten.getPosition()][i] != null) {
                traversieren(adjazenzmatrix[startKnoten.getPosition()][i].getZiel());
            }
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
    public int gewichtAuslesen(Knoten startKnoten, Knoten zielKnoten) {
        pruefeNull(startKnoten);
        pruefeNull(zielKnoten);
        pruefeKanteVorhanden(startKnoten, zielKnoten);
        return adjazenzmatrix [startKnoten.getPosition()][zielKnoten.getPosition()].getGewicht();
    }

    /**
     * Liefert den Startknoten
     * @return Startknoten
     */
    @Override
    public Knoten gibStartKnoten() {
        return knotenArray[0];
    }

    /**
     * Liefert den Endknoten
     * @return Endknoten
     */
    @Override
    public Knoten gibEndKnoten() {
        return knotenArray[anzahlKnoten - 1];
    }

    /**
     * Gibt die Matrix auf der Konsole aus
     */
    @Override
    public void allesAusgeben() {
        System.out.print("\t\t");
        for(int y = 0; y < anzahlKnoten; y++) //druckt die erste Zeile (alle Knoten in deren Reihenfolge)
        {
            System.out.print(knotenArray[y].getPosition());
            System.out.print(" | \t");
        }
        for(int i = 0; i < anzahlKnoten; i++) //druckt die übrigen Zeilen untereinander
        {
            System.out.println(" ");

            System.out.print(knotenArray[i].getPosition());
            System.out.print(" | ");
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
                        System.out.print(" ");
                        System.out.print(" " + adjazenzmatrix[i][z] + " ");
                        System.out.print(" | ");
                    }
                }
                else
                {
                    System.out.print(" " + adjazenzmatrix[i][z] + " ");

                    System.out.print("|");
                }
            }
        }





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
            throw new IllegalArgumentException("Es muss ein Knoten uebergeben werden!");
        }
    }

    /**
     * Prueft ob der Knoten vorhanden ist.
     * @param knoten knoten der ueberprueft wird.
     */
    private void pruefeKnotenVorhanden (Knoten knoten) {
        for (int i = 0; i <= anzahlKnoten; i++) {
            if (knoten.equals(knotenArray[i])) {
                throw new IllegalArgumentException("Der Knoten wurde bereits eingefuegt und doppelte Knoten sind verboten!");
            }
        }
    }

    /**
     * Prüft ob zwischen zwei Knoten eine Kante vorhanden ist.
     * @param startKnoten Startknoten
     * @param zielKnoten Zielknoten
     */
    private void pruefeKanteVorhanden (Knoten startKnoten, Knoten zielKnoten) {
        if (adjazenzmatrix[startKnoten.getPosition()][zielKnoten.getPosition()] == null) {
            throw new IllegalArgumentException("Es ist keine Kante zwischen den beiden Knoten vorhanden!");
        }
    }
}