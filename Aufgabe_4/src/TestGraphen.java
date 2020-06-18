import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGraphen {

    /**-------------------------------------------MATRIX------------------------------------------------*/


    /**
     * Testet das erstellen eines Knotens
     */
    @org.junit.jupiter.api.Test
    public void testeKnotenerstellen () {
        Adjazenzmatrix adjazenzmatrix = adjazenzmatrixErstellen();
        adjazenzmatrix = fuegeKnotenEinInMatrix(adjazenzmatrix);
        assertEquals(9, adjazenzmatrix.gibAnzahlKnoten());
    }

    /**
     * Testet das erstellen einer Kante
     */
    @org.junit.jupiter.api.Test
    public void testeKantenErstellen() {
        Adjazenzmatrix adjazenzmatrix = adjazenzmatrixErstellen();
        adjazenzmatrix = fuegeKnotenEinInMatrix(adjazenzmatrix);
        adjazenzmatrix = fuegeKanteEinInMatrix(adjazenzmatrix);
        Kante matrix [][] = adjazenzmatrix.getAdjazenzmatrix();
        pruefeMatrix(matrix);
    }

    /**
     * Testtet und printet das auslesen der Matrix
     */
    @org.junit.jupiter.api.Test
    public void testeMatrixAuslesen () {
        Adjazenzmatrix adjazenzmatrix = adjazenzmatrixErstellen();
        adjazenzmatrix = fuegeKnotenEinInMatrix(adjazenzmatrix);
        adjazenzmatrix = fuegeKanteEinInMatrix(adjazenzmatrix);
        adjazenzmatrix.allesAusgeben();
    }

    /**
     * Testet eine IllegalArgumentException wenn es keine Kante gibt
     */
    @org.junit.jupiter.api.Test
    public void negativtestKeineKante () {
        Adjazenzmatrix adjazenzmatrix = adjazenzmatrixErstellen();
        adjazenzmatrix = fuegeKnotenEinInMatrix(adjazenzmatrix);
        adjazenzmatrix = fuegeKanteEinInMatrix(adjazenzmatrix);
        boolean exc = false;
        try {
            adjazenzmatrix.gewichtAuslesen(adjazenzmatrix.getKnotenGraphArray()[8], adjazenzmatrix.getKnotenGraphArray()[3]);
        } catch (IllegalArgumentException e) {
            exc = true;
        }
        assertEquals(true, exc);
    }

    /**
     * Testet eine IllegalArgumentException wenn es den Knoten schon gibt
     */
    @org.junit.jupiter.api.Test
    public void negativtestDoppelterKnoten () {
        Knoten_Graph neuerKnotenMatrix = new Knoten_Graph(1);
        Adjazenzmatrix adjazenzmatrix = adjazenzmatrixErstellen();
        adjazenzmatrix = fuegeKnotenEinInMatrix(adjazenzmatrix);
        boolean exc = false;
        try {
            adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix);
        } catch (IllegalArgumentException e) {
            exc = true;
        }
        assertEquals(true, exc);
    }


    /**
     * Testet eine IllegalArgumentException wenn der Knoten null ist.
     */
    @org.junit.jupiter.api.Test
    public void negativtestNullKnoten () {
        Knoten_Graph neuerKnotenMatrix = null;
        Adjazenzmatrix adjazenzmatrix = adjazenzmatrixErstellen();
        adjazenzmatrix = fuegeKnotenEinInMatrix(adjazenzmatrix);
        boolean exc = false;
        try {
            adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix);
        } catch (IllegalArgumentException e) {
            exc = true;
        }
        assertEquals(true, exc);
    }

    /**
     * Erstellung einer Adjazenzmatrix
     * @return erstellte Adjazenzmatrix
     */
    private Adjazenzmatrix adjazenzmatrixErstellen () {
        Knoten_Graph neuerKnotenMatrix = new Knoten_Graph(0);
        return new Adjazenzmatrix(neuerKnotenMatrix);
    }

    /**
     * Einfuegen von Knoten in die Adhazenzmatrix
     * @param adjazenzmatrix Adjazenzmatrix in die Knoten eingefuegt werden sollen
     * @return adjazenzmatrix
     */
    private Adjazenzmatrix fuegeKnotenEinInMatrix(Adjazenzmatrix adjazenzmatrix) {
        Knoten_Graph neuerKnotenMatrix1 = new Knoten_Graph(1);
        Knoten_Graph neuerKnotenMatrix2 = new Knoten_Graph(2);
        Knoten_Graph neuerKnotenMatrix3 = new Knoten_Graph(3);
        Knoten_Graph neuerKnotenMatrix4 = new Knoten_Graph(4);
        Knoten_Graph neuerKnotenMatrix5 = new Knoten_Graph(5);
        Knoten_Graph neuerKnotenMatrix6 = new Knoten_Graph(6);
        Knoten_Graph neuerKnotenMatrix7 = new Knoten_Graph(7);
        Knoten_Graph neuerKnotenMatrix8 = new Knoten_Graph(8);

        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix1);
        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix2);
        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix3);
        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix4);
        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix5);
        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix6);
        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix7);
        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix8);
        return adjazenzmatrix;
    }

    /**
     * Einfuegen von Kanten in die Adjazenzmatrix
     * @param adjazenzmatrix Adjazenzmatrix in der die Kanten eingefuegt werden sollen
     * @return Adjazenzmatrix in die die Kanten eingefuegt wurden
     */
    private Adjazenzmatrix fuegeKanteEinInMatrix (Adjazenzmatrix adjazenzmatrix) {
        Knoten_Graph [] knoten = adjazenzmatrix.getKnotenGraphArray();
        adjazenzmatrix.kanteEinfuegen(adjazenzmatrix.gibStartKnoten(), adjazenzmatrix.gibEndKnoten(), 3);
        adjazenzmatrix.kanteEinfuegen(adjazenzmatrix.gibStartKnoten(), adjazenzmatrix.gibStartKnoten(), 4);
        adjazenzmatrix.kanteEinfuegen(adjazenzmatrix.gibStartKnoten(), knoten[2], 3);
        adjazenzmatrix.kanteEinfuegen(adjazenzmatrix.gibStartKnoten(), knoten[5], 4);
        adjazenzmatrix.kanteEinfuegen(adjazenzmatrix.gibStartKnoten(), knoten[7], 3);
        adjazenzmatrix.kanteEinfuegen(adjazenzmatrix.gibStartKnoten(), knoten[8], 4);
        adjazenzmatrix.kanteEinfuegen(knoten[1], knoten[2], 5);
        adjazenzmatrix.kanteEinfuegen(knoten[1], knoten[4], 6);
        adjazenzmatrix.kanteEinfuegen(knoten[1], knoten[5], 6);
        adjazenzmatrix.kanteEinfuegen(knoten[1], knoten[7], 5);
        adjazenzmatrix.kanteEinfuegen(knoten[1], knoten[8], 6);
        adjazenzmatrix.kanteEinfuegen(knoten[2], knoten[3], 6);
        adjazenzmatrix.kanteEinfuegen(knoten[2], knoten[5], 5);
        adjazenzmatrix.kanteEinfuegen(knoten[2], knoten[6], 6);
        adjazenzmatrix.kanteEinfuegen(knoten[2], knoten[7], 6);
        adjazenzmatrix.kanteEinfuegen(knoten[2], knoten[8], 5);
        adjazenzmatrix.kanteEinfuegen(knoten[3], knoten[4], 6);
        adjazenzmatrix.kanteEinfuegen(knoten[4], knoten[5], 6);
        adjazenzmatrix.kanteEinfuegen(knoten[4], knoten[6], 5);
        adjazenzmatrix.kanteEinfuegen(knoten[4], knoten[8], 6);
        adjazenzmatrix.kanteEinfuegen(knoten[5], knoten[5], 6);
        adjazenzmatrix.kanteEinfuegen(knoten[5], knoten[8], 5);
        adjazenzmatrix.kanteEinfuegen(knoten[6], knoten[6], 6);
        adjazenzmatrix.kanteEinfuegen(knoten[6], knoten[8], 6);
        adjazenzmatrix.kanteEinfuegen(knoten[7], knoten[8], 5);
        adjazenzmatrix.kanteEinfuegen(knoten[8], knoten[8], 6);
        //adjazenzmatrix.allesAusgeben();
        return adjazenzmatrix;
    }

    /**
     * Matrix nach einfuegen von Kanten pruefen.
     * @param matrix Adjazenzmatrix in die die Kanten eingefuegt wurden.
     */
    private void pruefeMatrix (Kante [][] matrix) {
        assertEquals(true, matrix [0][8] != null);
        assertEquals(true, matrix [0][0] != null);
        assertEquals(true, matrix [0][2] != null);
        assertEquals(true, matrix [0][5] != null);
        assertEquals(true, matrix [0][7] != null);
        assertEquals(true, matrix [0][8] != null);
        assertEquals(true, matrix [1][2] != null);
        assertEquals(true, matrix [1][4] != null);
        assertEquals(true, matrix [1][5] != null);
        assertEquals(true, matrix [1][7] != null);
        assertEquals(true, matrix [1][8] != null);
        assertEquals(true, matrix [2][3] != null);
        assertEquals(true, matrix [2][5] != null);
        assertEquals(true, matrix [2][6] != null);
        assertEquals(true, matrix [2][7] != null);
        assertEquals(true, matrix [2][8] != null);
        assertEquals(true, matrix [3][4] != null);
        assertEquals(true, matrix [4][5] != null);
        assertEquals(true, matrix [4][6] != null);
        assertEquals(true, matrix [4][8] != null);
        assertEquals(true, matrix [5][5] != null);
        assertEquals(true, matrix [5][8] != null);
        assertEquals(true, matrix [6][6] != null);
        assertEquals(true, matrix [6][8] != null);
        assertEquals(true, matrix [7][8] != null);
        assertEquals(true, matrix [8][8] != null);
    }
    /**-------------------------------------------LISTE------------------------------------------------*/


    /**
     * Testet das Erstellen der Knoten in einer Adjazenzliste
     */
    @org.junit.jupiter.api.Test
    public void testeKnotenerstellenListe() {
        Adjazenzliste liste = adjazenzListeErstellen();
        liste = fuegeKnotenEinInListe(liste);
        assertEquals(9, liste.gibAnzahlKnoten());
    }

    /**
     * Testet das Erstellen der Kanten in einer Adjazenzliste
     */
    @org.junit.jupiter.api.Test
    public void testeKantenErstellenListe() {
        Adjazenzliste liste = adjazenzListeErstellen();
        liste = fuegeKnotenEinInListe(liste);
        liste = fuegeKanteEinInListe(liste);
        //Kante matrix [][] = liste.getAdjazenzmatrix();
        pruefeListe(liste);
    }

    /**
     * Testet und printet das Auslesen der Liste
     */
    @org.junit.jupiter.api.Test
    public void testeListeAuslesen() {
        Adjazenzliste adjazenzliste = adjazenzListeErstellen();
        adjazenzliste = fuegeKnotenEinInListe(adjazenzliste);
        adjazenzliste = fuegeKanteEinInListe(adjazenzliste);
        adjazenzliste.allesAusgeben();
    }

    /**
     * Testet eine IllegalArgumentException wenn es keine Kante gibt bei einer Adjazenzliste
     */
    @org.junit.jupiter.api.Test
    public void negativtestKeineKanteListe() {
        Adjazenzliste adjazenzliste = adjazenzListeErstellen();
        adjazenzliste = fuegeKnotenEinInListe(adjazenzliste);
        adjazenzliste = fuegeKanteEinInListe(adjazenzliste);
        ArrayList<Knoten_Graph> knoten = adjazenzliste.getKnotenGraphArray();
        boolean exc = false;
        try {
            adjazenzliste.gewichtAuslesen(knoten.get(1), knoten.get(3));
        } catch (IllegalArgumentException e) {
            exc = true;
        }
        assertEquals(true, exc);
    }

    /**
     * Testet eine IllegalArgumentException wenn es den Knoten schon gibt
     */
    @org.junit.jupiter.api.Test
    public void negativtestDoppelterKnotenListe() {
        Knoten_Graph neuerKnotenListe = new Knoten_Graph(3);
        Adjazenzliste adjazenzliste = adjazenzListeErstellen();
        adjazenzliste = fuegeKnotenEinInListe(adjazenzliste);
        boolean exc = false;
        try {
            adjazenzliste.knotenEinfuegen(neuerKnotenListe);
        } catch (IllegalArgumentException e) {
            exc = true;
        }
        assertEquals(true, exc);
    }


    /**
     * Testet eine IllegalArgumentException wenn der Knoten null ist.
     */
    @org.junit.jupiter.api.Test
    public void negativtestNullKnotenListe() {
        Knoten_Graph neuerKnotenListe = null;
        Adjazenzliste adjazenzliste = adjazenzListeErstellen();
        adjazenzliste = fuegeKnotenEinInListe(adjazenzliste);
        boolean exc = false;
        try {
            adjazenzliste.knotenEinfuegen(neuerKnotenListe);
        } catch (IllegalArgumentException e) {
            exc = true;
        }
        assertEquals(true, exc);
    }

    /**------------------------------------------- Hilfsmethoden ------------------------------------------------*/


    /**
     * Erstellung einer Adjazenzliste
     * @return erstellte Adjazenzliste
     */
    private Adjazenzliste adjazenzListeErstellen() {
        Knoten_Graph neuerKnotenListe = new Knoten_Graph(0);
        return new Adjazenzliste(neuerKnotenListe);
    }

    /**
     * Einfuegen von Knoten in die Adhazenzliste
     * @param adjazenzliste Adjazenzliste in die Knoten eingefuegt werden sollen
     * @return adjazenzliste
     */
    private Adjazenzliste fuegeKnotenEinInListe(Adjazenzliste adjazenzliste) {
        Knoten_Graph neuerKnotenListe1 = new Knoten_Graph(1);
        Knoten_Graph neuerKnotenListe2 = new Knoten_Graph(2);
        Knoten_Graph neuerKnotenListe3 = new Knoten_Graph(3);
        Knoten_Graph neuerKnotenListe4 = new Knoten_Graph(4);
        Knoten_Graph neuerKnotenListe5 = new Knoten_Graph(5);
        Knoten_Graph neuerKnotenListe6 = new Knoten_Graph(6);
        Knoten_Graph neuerKnotenListe7 = new Knoten_Graph(7);
        Knoten_Graph neuerKnotenListe8 = new Knoten_Graph(8);

        adjazenzliste.knotenEinfuegen(neuerKnotenListe1);
        adjazenzliste.knotenEinfuegen(neuerKnotenListe2);
        adjazenzliste.knotenEinfuegen(neuerKnotenListe3);
        adjazenzliste.knotenEinfuegen(neuerKnotenListe4);
        adjazenzliste.knotenEinfuegen(neuerKnotenListe5);
        adjazenzliste.knotenEinfuegen(neuerKnotenListe6);
        adjazenzliste.knotenEinfuegen(neuerKnotenListe7);
        adjazenzliste.knotenEinfuegen(neuerKnotenListe8);
        return adjazenzliste;
    }

    /**
     * Einfuegen von Kanten in die Adjazenzliste
     * @param adjazenzliste Adjazenzliste in der die Kanten eingefuegt werden sollen
     * @return Adjazenzliste in die die Kanten eingefuegt wurden
     */
    private Adjazenzliste fuegeKanteEinInListe(Adjazenzliste adjazenzliste) {
        ArrayList<Knoten_Graph> knoten = adjazenzliste.getKnotenGraphArray();
        adjazenzliste.kanteEinfuegen(adjazenzliste.gibStartKnoten(), adjazenzliste.gibEndKnoten(), 3);
        adjazenzliste.kanteEinfuegen(adjazenzliste.gibStartKnoten(), adjazenzliste.gibStartKnoten(), 4);
        adjazenzliste.kanteEinfuegen(adjazenzliste.gibStartKnoten(), knoten.get(2), 3);
        adjazenzliste.kanteEinfuegen(adjazenzliste.gibStartKnoten(), knoten.get(5), 4);
        adjazenzliste.kanteEinfuegen(adjazenzliste.gibStartKnoten(), knoten.get(7), 3);
        adjazenzliste.kanteEinfuegen(adjazenzliste.gibStartKnoten(), knoten.get(8), 4);
        adjazenzliste.kanteEinfuegen(knoten.get(1), knoten.get(2), 5);
        adjazenzliste.kanteEinfuegen(knoten.get(1), knoten.get(4), 6);
        adjazenzliste.kanteEinfuegen(knoten.get(1), knoten.get(5), 6);
        adjazenzliste.kanteEinfuegen(knoten.get(1), knoten.get(7), 5);
        adjazenzliste.kanteEinfuegen(knoten.get(1), knoten.get(8), 6);
        adjazenzliste.kanteEinfuegen(knoten.get(2), knoten.get(3), 6);
        adjazenzliste.kanteEinfuegen(knoten.get(2), knoten.get(5), 5);
        adjazenzliste.kanteEinfuegen(knoten.get(2), knoten.get(6), 6);
        adjazenzliste.kanteEinfuegen(knoten.get(2), knoten.get(7), 6);
        adjazenzliste.kanteEinfuegen(knoten.get(2), knoten.get(8), 5);
        adjazenzliste.kanteEinfuegen(knoten.get(3), knoten.get(4), 6);
        adjazenzliste.kanteEinfuegen(knoten.get(4), knoten.get(5), 6);
        adjazenzliste.kanteEinfuegen(knoten.get(4), knoten.get(6), 5);
        adjazenzliste.kanteEinfuegen(knoten.get(4), knoten.get(8), 6);
        adjazenzliste.kanteEinfuegen(knoten.get(5), knoten.get(5), 6);
        adjazenzliste.kanteEinfuegen(knoten.get(5), knoten.get(8), 5);
        adjazenzliste.kanteEinfuegen(knoten.get(6), knoten.get(6), 6);
        adjazenzliste.kanteEinfuegen(knoten.get(6), knoten.get(8), 6);
        adjazenzliste.kanteEinfuegen(knoten.get(7), knoten.get(8), 5);
        adjazenzliste.kanteEinfuegen(knoten.get(8), knoten.get(8), 6);
        //adjazenzliste.allesAusgeben();
        return adjazenzliste;
    }

    /**
     * Adjazenzliste nach einfuegen von Kanten pruefen.
     * @param adjazenzliste Adjazenzliste in die die Kanten eingefuegt wurden.
     */
    private void pruefeListe(Adjazenzliste adjazenzliste) {
        ArrayList<Knoten_Graph> knoten = adjazenzliste.getKnotenGraphArray();
        assertEquals(true, knoten.get(0).getVerbunden() && knoten.get(8).getVerbunden());
        assertEquals(true, knoten.get(0).getVerbunden() && knoten.get(0).getVerbunden());
        assertEquals(true, knoten.get(0).getVerbunden() && knoten.get(2).getVerbunden());
        assertEquals(true, knoten.get(0).getVerbunden() && knoten.get(5).getVerbunden());
        assertEquals(true, knoten.get(0).getVerbunden() && knoten.get(7).getVerbunden());
        assertEquals(true, knoten.get(0).getVerbunden() && knoten.get(8).getVerbunden());
        assertEquals(true, knoten.get(1).getVerbunden() && knoten.get(2).getVerbunden());
        assertEquals(true, knoten.get(1).getVerbunden() && knoten.get(4).getVerbunden());
        assertEquals(true, knoten.get(1).getVerbunden() && knoten.get(5).getVerbunden());
        assertEquals(true, knoten.get(1).getVerbunden() && knoten.get(7).getVerbunden());
        assertEquals(true, knoten.get(1).getVerbunden() && knoten.get(8).getVerbunden());
        assertEquals(true, knoten.get(2).getVerbunden() && knoten.get(3).getVerbunden());
        assertEquals(true, knoten.get(2).getVerbunden() && knoten.get(5).getVerbunden());
        assertEquals(true, knoten.get(2).getVerbunden() && knoten.get(6).getVerbunden());
        assertEquals(true, knoten.get(2).getVerbunden() && knoten.get(7).getVerbunden());
        assertEquals(true, knoten.get(2).getVerbunden() && knoten.get(8).getVerbunden());
        assertEquals(true, knoten.get(3).getVerbunden() && knoten.get(4).getVerbunden());
        assertEquals(true, knoten.get(4).getVerbunden() && knoten.get(5).getVerbunden());
        assertEquals(true, knoten.get(4).getVerbunden() && knoten.get(6).getVerbunden());
        assertEquals(true, knoten.get(4).getVerbunden() && knoten.get(8).getVerbunden());
        assertEquals(true, knoten.get(5).getVerbunden() && knoten.get(5).getVerbunden());
        assertEquals(true, knoten.get(5).getVerbunden() && knoten.get(8).getVerbunden());
        assertEquals(true, knoten.get(6).getVerbunden() && knoten.get(6).getVerbunden());
        assertEquals(true, knoten.get(6).getVerbunden() && knoten.get(8).getVerbunden());
        assertEquals(true, knoten.get(7).getVerbunden() && knoten.get(8).getVerbunden());
        assertEquals(true, knoten.get(8).getVerbunden() && knoten.get(8).getVerbunden());
    }

}
