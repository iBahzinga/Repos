//import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.NotNull;
//import org.jetbrains.annotations.NotNull;

/**
 * Darstellung eines Baumes.
 * Der Baum besitzt eine Wurzel und es können weitere Wurzeln eingefügt werden.
 * Sollte eine Wurzel eingefügt werden, wird automatisch erkannt an welcher Position diese eingefügt werden muss.
 *
 * Desweiteren erlaubt diese Funktion das ausgeben des Baumes.
 * Man kann den Baum Symmetrisch, in Hauptreihenfolge sowie in der Nebenreihenfolge ausgeben.
 *
 *
 * @author Daniel Dichte
 * @author Santa Rudevica
 * @author Pascal Kießler
 *
 * @version 1.1
 * @version 09.06.2020
 *
 * @param <T>
 */
public class Tree<T> implements Search_ {
    private Knot_Tree root;
    private Knot_Tree knotTree;
    private final int ZERO;
    private final int ARRAYSIZE;
    private final int INORDER;
    private final int POSTORDER;
    private final int PREORDER;
    private final T[] arr;
    private int counterSym;


    /**
     * Konstruktor der Klasse Tree_v2
     * @param data Daten die die Wurzel hat
     */
    public Tree(Object data) {
        Knot_Tree root = new Knot_Tree((Comparable) data, null);
        this.root = root;
        ZERO = 0;
        ARRAYSIZE = 100;
        arr = (T[]) new Object[ARRAYSIZE];
        counterSym = 0;
        INORDER = 3;
        POSTORDER = 2;
        PREORDER = 1;

        // man kann hier auch nur die Daten eingeben und dann kann man den rest der Wurzel erzeugen, anstatt direkt die ganze Wurzel zu übergeben.
    }


    /**
     * Hinzufügen eines weiteren Knotens.
     * Ein weiterer Knoten wird automatisch an der richtigen Stelle hinzugefügt. (Es wird erkannt wo er eingefügt werden muss)
     * @param data Vergleichbarer Wert der in den Knoten eingefügt wird.  Der Knoten wiederrum wird in den Baum eingefügt.
     */
    @Override
    public void addKnot(Object data) {
        Knot_Tree newKnotTree;
        int test = root.getData().compareTo(data);
        if (root.getData().compareTo(data) > ZERO ) {           //linke Seite der Wurzel
            if (root.getChildLeft() == null){                   //wenn noch kein Kind auf der linken seite vorhanden ist neuen Knoten einfügen
                newKnotTree = new Knot_Tree((Comparable) data, root);                //Verbindungen des Knotens setzen
                root.setChildLeft(newKnotTree);                     //Verbindung der Wurzel setzen
            } else {
                knotTree = root.getChildLeft();                     //linken Knoten geben
                add (data);                                     //Einfuegeposition wird bestimmt
            }
        }
        if (root.getData().compareTo(data) <= ZERO ) {          //rechte Seite der Wurzel
            if (root.getChildRight() == null){                  //wenn noch kein Kind auf der rechten seite vorhanden ist neuen Knoten einfügen
                newKnotTree = new Knot_Tree((Comparable) data, root);                //Verbindungen des Knotens setzen
                root.setChildRight(newKnotTree);                    //Verbindung der Wurzel setzen
            } else {
                knotTree = root.getChildRight();                    //rechten Knoten geben
                add (data);                                     //Einfuegeposition wird bestimmt
            }
        }
    }

    /**
     * Ausgabe der gewöhlten Methode.
     * Man kann zwischen der Hauptreihenfolge, der Nebenreihenfolge sowie der Symmetrischen Reihenfolge auswählen.
     *
     * @param method Methode die erkennt in welcher Methode der Baum ausgegeben werden soll.
     *               1 -> Hauptreihenfolge
     *               2 -> Nebenreihenfolge
     *               3 -> Symmetrisch
     */
    @Override
    public void output(int method) {
        if (method == PREORDER) {       //Hauptreihenfolge ausgeben
            clearArray();
            counterSym = 0;
            preorder(root);
            arrayOutput(PREORDER);
        } else if (method == POSTORDER) { // Nebenreihenfolge ausgeben
            clearArray();
            counterSym = 0;
            postorder(root);
            arrayOutput(POSTORDER);
        } else if (method == INORDER) {                   // Symmetrie
            clearArray();
            counterSym = ZERO;
            inorder(root);
            arrayOutput(INORDER);
        }
    }

    /**
     * Schreiben der Symmetrischen Reihenfolge in ein Array.
     * @param knoten Knoten den wir uns anschauen
     */
    private void inorder(@NotNull Knot_Tree knoten) {
        if (knoten.getChildLeft() == null) {            //wenn keine linke Seite, hole daten hier raus.
            arr[counterSym] = (T) knoten.getData();     //get wert
            counterSym++;
        } else {                                        //wenn es eine linke Seite gibt, gehe hier rein. am ende auch hier die Datan auslesen.
            inorder(knoten.getChildLeft());
            arr[counterSym] = (T) knoten.getData();
            counterSym++;
        }
        if (knoten.getChildRight() != null) {
            inorder(knoten.getChildRight());
        }
    }


    /**
     * Schreiben der Preorder Reihenfolge (Hauptreihenfolge) in ein Array.
     * @param knoten Knoten den wir uns anschauen
     */
    private void preorder (@NotNull Knot_Tree knoten) {
        arr[counterSym] = (T) knoten.getData();
        counterSym++;
        if (knoten.getChildLeft() != null) {
            preorder(knoten.getChildLeft());
        }
        if (knoten.getChildRight() != null){
            preorder(knoten.getChildRight());
        }
    }


    /**
     * Schreiben der Postorder Reihenfolge (Nebenreihenfolge) in ein Array.
     * @param knoten Knoten den wir uns anschauen
     */
    private void postorder (@NotNull Knot_Tree knoten) {
        if (knoten.getChildLeft() != null) {
            postorder(knoten.getChildLeft());
        }
        if (knoten.getChildRight() != null){
            postorder(knoten.getChildRight());
        }
        arr[counterSym] = (T) knoten.getData();
        counterSym++;
    }


    /**
     * Ausgabe der im Array befindlichen Daten auf dem Bildschirm
     * @param order Methode die ausgegeben wird. (Preorder, Postoder, symmetrisch)
     */
    private void arrayOutput(int order) {
        String method = "";
        switch (order){
            case 3:   method = "symmetrischen Methode";
            break;
            case 1:  method = "Hauptreihenfolge";
            break;
            case 2:method = "Nebenreihenfolge";
            break;
        }
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] != null) {
                System.out.printf("Die %d Stelle der %s hat den Wert %d.\n", i, method, arr[i]);
            } else {
                break;
            }
        }
    }

    /**
     * löscht alle vorhandenen Daten aus dem Array
     */
    private void clearArray () {
        for (int i = 0; i < arr.length - 1; i++){
            arr[i] = null;
        }
    }

    /**
     * Hinzufuegen eines weiteren Knotens mit Daten in dem Baum.
     * @param data Daten die in einen Knoten sollen in dem Baum.
     */
    private void add (Object data) {
        Knot_Tree newKnotTree;
        while (true){
            if (knotTree.getData().compareTo(data) > ZERO) {//sollten die Daten kleiner sein als die des aktuellen Knotens -> links einfügen
                if (knotTree.getChildLeft() == null) {      //sollte noch kein Knoten da sein, hier einen neuen einfügen
                    newKnotTree = new Knot_Tree((Comparable) data, knotTree);     //Verbindung des keien Knotens setzen
                    knotTree.setChildLeft(newKnotTree);         //Verbindungen des alten Knotens setzen
                    break;  //ggf. muss hier ein return hin
                } else {                                //wenn hier schon ein Knoten ist, hole mir den neuen knoten und gehe erneut durch die Schleife.
                    knotTree = knotTree.getChildLeft();
                }
            } else { //evtl. hier else if (knot.getData().compareTo(data) >= ZERO)          //Wenn das Kind auf die Rechte seite muss, geh hier rein
                if (knotTree.getChildRight() == null) {     //Wenn auf der rechten Seite des Knotens noch kein weiterer Knoten ist, fuege ihn hier ein
                    newKnotTree = new Knot_Tree((Comparable) data, knotTree);     //Verbindung des keien Knotens setzen
                    knotTree.setChildRight(newKnotTree);        //Verbindungen des alten Knotens setzen
                    break;
                } else {                                //wenn hier schon ein Knoten ist, hole mir den neuen knoten und gehe erneut durch die Schleife.
                    knotTree = knotTree.getChildRight();
                }
            }
        }
    }

    /**
     * Rueckgabe des Arrays zum auswerten der Daten
     * @return Array der Methode
     */
    protected T[] getArray () {
        return arr;
    }
}
