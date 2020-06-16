import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testklasse fuer die Baeume und die Graphen
 *
 * @author Daniel Dichte
 * @author Sante Rudevica
 * @author Pascal Kießler
 *
 * @version 1.1
 * @version 09.06.2020
 *
 */
public class TestBaeumeGraphen <T> {
    private final int ROOTVALUE = 100;
    private final int TESTWERT1 = 50;
    private final int TESTWERT2 = 200;
    private final int TESTWERT3 = 25;
    private final int TESTWERT4 = 75;
    private final int TESTWERT5 = 150;
    private final int TESTWERT6 = 500;
    private final int TESTWERT7 = 10;
    private final int TESTWERT8 = 30;
    private final int TESTWERT9 = 60;
    private final int TESTWERT10 = 90;
    private final int TESTWERT11 = 125;
    private final int TESTWERT12 = 175;
    private final int TESTWERT13 = 400;
    private final int TESTWERT14 = 1000;

    /** -------------------------------------------------------Baum------------------------------------------------------------ */

    /**
     * Testet die Funktionalitaet der Preorder Reihenfolge (Baum)
     */
    @org.junit.jupiter.api.Test
    public void testePreorder () {
        Integer test = ROOTVALUE;
        Tree_v2 tree = new Tree_v2(test);
        tree = setTree(tree);
        tree.output(1);
        Integer result [] = new Integer[100];
        result = setArrayForTest(result, 1);
        for (int i = 0; i < tree.getArray().length; i++){
            T [] testArray = (T[]) tree.getArray();
            Assertions.assertEquals(result[i], testArray[i]);
        }
    }

    /**
     * Testet die Funktionalitaet der Postorder Reihenfolge (Baum)
     */
    @org.junit.jupiter.api.Test
    public void testePostorder () {
        Integer test = ROOTVALUE;
        Tree_v2 tree = new Tree_v2(test);
        tree = setTree(tree);
        tree.output(2);
        Integer result [] = new Integer[100];
        result = setArrayForTest(result, 2);
        for (int i = 0; i < tree.getArray().length; i++){
            T [] testArray = (T[]) tree.getArray();
            Assertions.assertEquals(result[i], testArray[i]);
        }
    }

    /**
     * Testet die Funktionalitaet der Inorder Reihenfolge (Baum)
     */
    @org.junit.jupiter.api.Test
    public void testeInorder() {
        Integer test = ROOTVALUE;
        Tree_v2 tree = new Tree_v2(test);
        tree = setTree(tree);
        tree.output(3);
        Integer result [] = new Integer[100];
        result = setArrayForTest(result, 3);
        for (int i = 0; i < tree.getArray().length; i++){
            T [] testArray = (T[]) tree.getArray();
            Assertions.assertEquals(result[i], testArray[i]);
        }
    }

    /** -------------------------------------------------------Array----------------------------------------------------------- */

    /**
     * Testet die Funktionalitaet der Preorder Reihenfolge (Array)
     */
    @org.junit.jupiter.api.Test
    public void testePreorderArr () {
        Tree_array arr = new Tree_array();
        arr = setArray(arr);
        arr.output(1);
        Integer result [] = new Integer[1000];
        result = setArrayForTest(result, 1);
        for (int i = 0; i < arr.getArray().length; i++){
            T [] testArray = (T[]) arr.getArray();
            Assertions.assertEquals(result[i], testArray[i]);
        }
    }

    /**
     * Testet die Funktionalitaet der Postorder Reihenfolge (Array)
     */
    @org.junit.jupiter.api.Test
    public void testePostorderArr () {
        Tree_array arr = new Tree_array();
        arr = setArray(arr);
        arr.output(2);
        Integer result [] = new Integer[1000];
        result = setArrayForTest(result, 2);
        for (int i = 0; i < arr.getArray().length; i++){
            T [] testArray = (T[]) arr.getArray();
            Assertions.assertEquals(result[i], testArray[i]);
        }
    }

    /**
     * Testet die Funktionalitaet der Inorder Reihenfolge (Array)
     */
    @org.junit.jupiter.api.Test
    public void testeInorderArr () {
        Tree_array arr = new Tree_array();
        arr = setArray(arr);
        arr.output(3);
        Integer result [] = new Integer[1000];
        result = setArrayForTest(result, 3);
        for (int i = 0; i < arr.getArray().length; i++){
            T [] testArray = (T[]) arr.getArray();
            Assertions.assertEquals(result[i], testArray[i]);
        }
    }


    /** ------------------------------------------------------ Adjazenzmatrix --------------------------------------------------- */

    /**
     * Testet das einfuegen von Knoten in die Matrix
     */
    /*
    @org.junit.jupiter.api.Test
    public void testeEinfuegenMatrix () {
        Adjazenzmatrix matrix = new Adjazenzmatrix();
        knotenEinfuegenMatrix(matrix);
        Assertions.assertEquals(matrix.getAnzahlKnoten(), 20);
    }

     */

    /**
     * Teste einfuegen der Kanten in die Matrix
     */
    /*
    @org.junit.jupiter.api.Test
    public void testeKantenMatrix () {
        Adjazenzmatrix matrix = new Adjazenzmatrix();
        knotenEinfuegenMatrix(matrix);
        Assertions.assertEquals(matrix.getAnzahlKnoten(), 20);
        kanteEinfuegenMatrix(matrix);
        Assertions.assertEquals( matrix.traversieren(0), 3);
        Assertions.assertEquals( matrix.traversieren(1), 1);
        Assertions.assertEquals( matrix.traversieren(2), 1);
        Assertions.assertEquals( matrix.traversieren(3), 1);
        Assertions.assertEquals( matrix.traversieren(4), 0);
        Assertions.assertEquals( matrix.traversieren(5), 1);
        Assertions.assertEquals( matrix.traversieren(6), 0);
        Assertions.assertEquals( matrix.traversieren(7), 0);
        Assertions.assertEquals( matrix.traversieren(8), 0);
        Assertions.assertEquals( matrix.traversieren(9), 5);
    }

     */

    /**
     * printet die Matrix auf die Console für optische Pruefung
     */
    /*
    @org.junit.jupiter.api.Test
    public void printMatrix(){
        Adjazenzmatrix matrix = new Adjazenzmatrix();
        knotenEinfuegenMatrix(matrix);
        kanteEinfuegenMatrix(matrix);
        matrix.gewichtAuslesen(9);
        matrix.knotenAusgabe(4);
        matrix.allesAusgeben();
    }

     */

    /**
     * Testet ob eine Exception geworfen wird wenn der Knoten nicht erreichbar ist  oder nicht existiert.
     */
    /*
    @org.junit.jupiter.api.Test
    public void negativtestMatrixKnotenerreichbarkeit(){
        Adjazenzmatrix matrix = new Adjazenzmatrix();
        knotenEinfuegenMatrix(matrix);
        boolean excYesNo = false;
        try {
            matrix.gibKnoten(21);
        }
        catch (IllegalArgumentException e) {
            excYesNo = true;
        }
        finally
        {
        }
        assertTrue(excYesNo);
    }

     */

    /**
     * Testet ob eine Exception geworfen wird wenn der erste Knoten nicht erreichbar ist oder nicht existiert.
     */
    /*
    @Test
    public void negativtestMatrixKantenerreichbarkeit1(){
        Adjazenzmatrix matrix = new Adjazenzmatrix();
        knotenEinfuegenMatrix(matrix);
        boolean excYesNo = false;
        try {
            matrix.kanteEinfuegen( 21, 0);
        }
        catch (IllegalArgumentException e) {
            excYesNo = true;
        }
        finally
        {
        }
        assertTrue(excYesNo);
    }

     */

    /**
     * Testet ob eine Exception geworfen wird wenn der zweite Knoten nicht erreichbar ist oder nicht existiert.
     */
    /*
    @Test
    public void negativtestMatrixKantenerreichbarkeit2(){
        Adjazenzmatrix matrix = new Adjazenzmatrix();
        knotenEinfuegenMatrix(matrix);
        boolean excYesNo = false;
        try {
            matrix.kanteEinfuegen( 0, 21);
        }
        catch (IllegalArgumentException e) {
            excYesNo = true;
        }
        finally
        {
        }
        assertTrue(excYesNo);
    }

     */

    /** ------------------------------------------------------ Adjazenzliste --------------------------------------------------- */


    /**
     * Testet das einfuegen von Knoten in die Liste
     */
    /*
    @org.junit.jupiter.api.Test
    public void testEinfuegenListe(){
         Adjazenzliste liste = new Adjazenzliste();
         knotenEinfuegenListe(liste);
         Assertions.assertEquals(liste.getAnzahlKnoten(), 20);
    }

     */


    /**
     * Testet das einfuegen von Kanten in die Liste
     */
    /*
    @org.junit.jupiter.api.Test
    public void testKantenListe() {
          Adjazenzliste liste = new Adjazenzliste();
          knotenEinfuegenListe(liste);
          kanteEinfuegenListe(liste);
          Assertions.assertEquals( liste.traversieren(0), 3);
          Assertions.assertEquals( liste.traversieren(1), 1);
          Assertions.assertEquals( liste.traversieren(2), 1);
          Assertions.assertEquals( liste.traversieren(3), 1);
          Assertions.assertEquals( liste.traversieren(4), 0);
          Assertions.assertEquals( liste.traversieren(5), 1);
          Assertions.assertEquals( liste.traversieren(6), 0);
          Assertions.assertEquals( liste.traversieren(7), 0);
          Assertions.assertEquals( liste.traversieren(8), 0);
          Assertions.assertEquals( liste.traversieren(9), 5);
    }

     */


    /**
     * Printet alles aus zur optischen Pruefung
     */
    /*
    @org.junit.jupiter.api.Test
    public void printListe() {
        Adjazenzliste liste = new Adjazenzliste();
        knotenEinfuegenListe(liste);
        kanteEinfuegenListe(liste);
        liste.gewichtTraversieren(9);
        liste.knotenAusgabe(4);
        liste.allesAusgeben();
    }

     */

    /**
     * Testet ob eine Exception geworfen wird wenn der Knoten nicht erreichbar ist  oder nicht existiert.
     */
    /*
    @org.junit.jupiter.api.Test
    public void negativtestListeKnotenerreichbarkeit(){
        Adjazenzliste liste = new Adjazenzliste();
        knotenEinfuegenListe(liste);
        boolean excYesNo = false;
        try {
            liste.gibKnoten(21);
        }
        catch (IllegalArgumentException e) {
            excYesNo = true;
        }
        finally
        {
        }
        assertTrue(excYesNo);
    }

     */

    /**
     * Testet ob eine Exception geworfen wird wenn der erste Knoten nicht erreichbar ist  oder nicht existiert.
     */
    /*
    @org.junit.jupiter.api.Test
    public void negativtestListKantenerreichbarkeit1(){
        Adjazenzliste liste = new Adjazenzliste();
        knotenEinfuegenListe(liste);
        boolean excYesNo = false;
        try {
            liste.kanteEinfuegen( 21, 0);
        }
        catch (IllegalArgumentException e) {
            excYesNo = true;
        }
        finally
        {
        }
        assertTrue(excYesNo);
    }

     */

    /**
     * Testet ob eine Exception geworfen wird wenn der zweite Knoten nicht erreichbar ist  oder nicht existiert.
     */
    /*
    @org.junit.jupiter.api.Test
    public void negativtestListKantenerreichbarkeit2(){
        Adjazenzliste liste = new Adjazenzliste();
        knotenEinfuegenListe(liste);
        boolean excYesNo = false;
        try {
            liste.kanteEinfuegen( 0, 21);
        }
        catch (IllegalArgumentException e) {
            excYesNo = true;
        }
        finally
        {
        }
        assertTrue(excYesNo);
    }

     */



    /** ------------------------------------------------------ Hilfsmethoden --------------------------------------------------- */

    /**
     * Legt das Array mit Werten an
     * @param arr gefuelltes Array mit Knotenvalues
     * @return gefuelltes Array
     */
    private Tree_array setArray(Tree_array arr) {
        arr.addKnot(ROOTVALUE);
        arr.addKnot(TESTWERT1);
        arr.addKnot(TESTWERT2);
        arr.addKnot(TESTWERT3);
        arr.addKnot(TESTWERT4);
        arr.addKnot(TESTWERT5);
        arr.addKnot(TESTWERT6);
        arr.addKnot(TESTWERT7);
        arr.addKnot(TESTWERT8);
        arr.addKnot(TESTWERT9);
        arr.addKnot(TESTWERT10);
        arr.addKnot(TESTWERT11);
        arr.addKnot(TESTWERT12);
        arr.addKnot(TESTWERT13);
        arr.addKnot(TESTWERT14);
        return arr;
    }

    /**
     * Legt den Binaeren Baum an
     * @param tree Binaerer Baum
     * @return Binaerer Baum
     */
    private Tree_v2 setTree(Tree_v2 tree) {
        tree.addKnot(TESTWERT1);
        tree.addKnot(TESTWERT2);
        tree.addKnot(TESTWERT3);
        tree.addKnot(TESTWERT4);
        tree.addKnot(TESTWERT5);
        tree.addKnot(TESTWERT6);
        tree.addKnot(TESTWERT7);
        tree.addKnot(TESTWERT8);
        tree.addKnot(TESTWERT9);
        tree.addKnot(TESTWERT10);
        tree.addKnot(TESTWERT11);
        tree.addKnot(TESTWERT12);
        tree.addKnot(TESTWERT13);
        tree.addKnot(TESTWERT14);
        return tree;
    }

    /**
     * Legt ein Testarray an, mit dem Verglichen werden kann ob die Ausgabe werte in Ordnung sind.
     * @param arr Leeres Array das gefuellt werden muss
     * @param method Festlegungswert der Inorder, Preorder oder Postorder Reihenfolge
     * @return Mit Testwerden gefuelltes Array in Richtiger Reihenfolge
     */
    private Integer [] setArrayForTest (Integer [] arr, int method) {
        switch (method) {
            case 1:                 //Spiegelt Preorder Reihenfolge wieder
                arr[0] = ROOTVALUE;
                arr[1] = TESTWERT1;
                arr[2] = TESTWERT3;
                arr[3] = TESTWERT7;
                arr[4] = TESTWERT8;
                arr[5] = TESTWERT4;
                arr[6] = TESTWERT9;
                arr[7] = TESTWERT10;
                arr[8] = TESTWERT2;
                arr[9] = TESTWERT5;
                arr[10] = TESTWERT11;
                arr[11] = TESTWERT12;
                arr[12] = TESTWERT6;
                arr[13] = TESTWERT13;
                arr[14] = TESTWERT14;
                break;
            case 2:                 //Spiegelt Postorder Reihenfolge wieder
                arr[0] = TESTWERT7;
                arr[1] = TESTWERT8;
                arr[2] = TESTWERT3;
                arr[3] = TESTWERT9;
                arr[4] = TESTWERT10;
                arr[5] = TESTWERT4;
                arr[6] = TESTWERT1;
                arr[7] = TESTWERT11;
                arr[8] = TESTWERT12;
                arr[9] = TESTWERT5;
                arr[10] = TESTWERT13;
                arr[11] = TESTWERT14;
                arr[12] = TESTWERT6;
                arr[13] = TESTWERT2;
                arr[14] = ROOTVALUE;
                break;
            case 3:                 //Spiegelt Inorder Reigenfolge wieder
                arr[0] = TESTWERT7;
                arr[1] = TESTWERT3;
                arr[2] = TESTWERT8;
                arr[3] = TESTWERT1;
                arr[4] = TESTWERT9;
                arr[5] = TESTWERT4;
                arr[6] = TESTWERT10;
                arr[7] = ROOTVALUE;
                arr[8] = TESTWERT11;
                arr[9] = TESTWERT5;
                arr[10] = TESTWERT12;
                arr[11] = TESTWERT2;
                arr[12] = TESTWERT13;
                arr[13] = TESTWERT6;
                arr[14] = TESTWERT14;
                break;
        }
        return arr;
    }


    /**
     *
     * Einfuegen von Knoten in die Adjazenzmatrix.
     * @param adjazenzmatrix Adjazenzmatrix in die die Knoten eingefuegt werden sollen
     * @return Adjazenxmatrix mit eingefuegten Knoten
     */
    /*
    private Adjazenzmatrix knotenEinfuegenMatrix (Adjazenzmatrix adjazenzmatrix) {
        adjazenzmatrix.knotenEinfuegen(5);
        adjazenzmatrix.knotenEinfuegen(1);
        adjazenzmatrix.knotenEinfuegen(4);
        adjazenzmatrix.knotenEinfuegen(2);
        adjazenzmatrix.knotenEinfuegen(3);
        adjazenzmatrix.knotenEinfuegen(10);
        adjazenzmatrix.knotenEinfuegen(7);
        adjazenzmatrix.knotenEinfuegen(6);
        adjazenzmatrix.knotenEinfuegen(8);
        adjazenzmatrix.knotenEinfuegen(9);
        adjazenzmatrix.knotenEinfuegen(11);
        adjazenzmatrix.knotenEinfuegen(12);
        adjazenzmatrix.knotenEinfuegen(600);
        adjazenzmatrix.knotenEinfuegen(42);
        adjazenzmatrix.knotenEinfuegen(27);
        adjazenzmatrix.knotenEinfuegen(666);
        adjazenzmatrix.knotenEinfuegen(1991);
        adjazenzmatrix.knotenEinfuegen(182763);
        adjazenzmatrix.knotenEinfuegen(20);
        adjazenzmatrix.knotenEinfuegen(40);
        return adjazenzmatrix;
    }

     */


    /**
     * Fuegt Kanten ein in die Adjazenzmatrix
     * @param adjazenzmatrix Adjazenzmatrix in die die Kanten eingefuegt werden sollen
     * @return
     */
    /*
    private Adjazenzmatrix kanteEinfuegenMatrix (Adjazenzmatrix adjazenzmatrix) {
        adjazenzmatrix.kanteEinfuegen(0,2);
        adjazenzmatrix.kanteEinfuegen(0,3);
        adjazenzmatrix.kanteEinfuegen(1,4);
        adjazenzmatrix.kanteEinfuegen(3,3);
        adjazenzmatrix.kanteEinfuegen(9,9);
        adjazenzmatrix.kanteEinfuegen(9,8);
        adjazenzmatrix.kanteEinfuegen(9,7);
        adjazenzmatrix.kanteEinfuegen(9,6);
        adjazenzmatrix.kanteEinfuegen(0,0);
        adjazenzmatrix.kanteEinfuegen(5,4);
        adjazenzmatrix.kanteEinfuegen(9,2);
        adjazenzmatrix.kanteEinfuegen(2,9);
        return adjazenzmatrix;
    }

     */

    /**
     * Einfuegen von Knoten in der Adjyzenzliste
     * @param adjazenzliste adjazenzliste in die die Knoten eingefuegt werden sollen
     * @return die Adjazenzliste in der die Knoten eingefuegt wurden.
     */
    /*
    private Adjazenzliste knotenEinfuegenListe (Adjazenzliste adjazenzliste) {
        adjazenzliste.knotenEinfuegen(5);
        adjazenzliste.knotenEinfuegen(1);
        adjazenzliste.knotenEinfuegen(4);
        adjazenzliste.knotenEinfuegen(2);
        adjazenzliste.knotenEinfuegen(3);
        adjazenzliste.knotenEinfuegen(10);
        adjazenzliste.knotenEinfuegen(7);
        adjazenzliste.knotenEinfuegen(6);
        adjazenzliste.knotenEinfuegen(8);
        adjazenzliste.knotenEinfuegen(9);
        adjazenzliste.knotenEinfuegen(11);
        adjazenzliste.knotenEinfuegen(12);
        adjazenzliste.knotenEinfuegen(600);
        adjazenzliste.knotenEinfuegen(42);
        adjazenzliste.knotenEinfuegen(27);
        adjazenzliste.knotenEinfuegen(666);
        adjazenzliste.knotenEinfuegen(1991);
        adjazenzliste.knotenEinfuegen(182763);
        adjazenzliste.knotenEinfuegen(20);
        adjazenzliste.knotenEinfuegen(40);
        return adjazenzliste;
    }
*/
    /**
     * Fuegt Kanten zwischen den Knoten ein in der Adjazenzliste.
     * @param adjazenzliste Adjazenzliste in der die Kanten eingefuegt wurden.
     * @return Adjazenzliste in der die Kanten eingefuegt wurden
     */
    /*
    private Adjazenzliste kanteEinfuegenListe(Adjazenzliste adjazenzliste) {
        adjazenzliste.kanteEinfuegen(0,2);
        adjazenzliste.kanteEinfuegen(0,3);
        adjazenzliste.kanteEinfuegen(1,4);
        adjazenzliste.kanteEinfuegen(3,3);
        adjazenzliste.kanteEinfuegen(9,9);
        adjazenzliste.kanteEinfuegen(9,8);
        adjazenzliste.kanteEinfuegen(9,7);
        adjazenzliste.kanteEinfuegen(9,6);
        adjazenzliste.kanteEinfuegen(0,0);
        adjazenzliste.kanteEinfuegen(5,4);
        adjazenzliste.kanteEinfuegen(9,2);
        adjazenzliste.kanteEinfuegen(2,9);
        return adjazenzliste;
    }
     */

}
