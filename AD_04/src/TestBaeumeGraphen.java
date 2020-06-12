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
public class TestBaeumeGraphen {
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


    @org.junit.jupiter.api.Test
    public void testReihenfolge() {
        Knot root = new Knot(ROOTVALUE, null);
        Tree_v2 tree = new Tree_v2(root);
        tree = setTree(tree);
    }

    @org.junit.jupiter.api.Test
    public void testePreorder () {
        Integer test = ROOTVALUE;
        Tree_v2 tree = new Tree_v2(test);
        tree = setTree(tree);
        tree.output(1);
    }


    @org.junit.jupiter.api.Test
    public void testePostorder () {
        Integer test = ROOTVALUE;
        Tree_v2 tree = new Tree_v2(test);
        tree = setTree(tree);
        tree.output(2);
    }

    @org.junit.jupiter.api.Test
    public void testeSymmetrisch () {
        Integer test = ROOTVALUE;
        Tree_v2 tree = new Tree_v2(test);
        tree = setTree(tree);
        tree.output(3);
    }



    @org.junit.jupiter.api.Test
    public void testArr () {
        Tree_array arr = new Tree_array();
        arr = setArray(arr);
    }

    @org.junit.jupiter.api.Test
    public void testeInorderArr () {
        Tree_array arr = new Tree_array();
        arr = setArray(arr);
        arr.output(3);
    }


    @org.junit.jupiter.api.Test
    public void testePostorderArr () {
        Tree_array arr = new Tree_array();
        arr = setArray(arr);
        arr.output(2);
    }


    @org.junit.jupiter.api.Test
    public void testePreorderArr () {
        Tree_array arr = new Tree_array();
        arr = setArray(arr);
        arr.output(1);
    }




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
}