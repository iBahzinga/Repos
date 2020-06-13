import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}