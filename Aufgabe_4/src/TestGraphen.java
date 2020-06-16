import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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


    private Adjazenzmatrix adjazenzmatrixErstellen () {
        Knoten_Graph neuerKnotenMatrix = new Knoten_Graph(0);
        return new Adjazenzmatrix(neuerKnotenMatrix);
    }

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

}
