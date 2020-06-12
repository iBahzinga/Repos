public class Tree_array<T extends  Comparable <T>> implements Search_ {

    private final int ROOT;
    private final int ARRAYSIZE;
    private T[] treeArray;
    private final int INORDER;
    private final int POSTORDER;
    private final int PREORDER;
    private int outputNumber;

    /**
     * Konstruktor der Klasse Tree_array
     * @param data Generisch vergleichbarer Wert der als Wurzel eingebettet wird an die erste Stelle im Array.
     */
    public Tree_array(Object data) {
        ARRAYSIZE = 1000;
        ROOT = 1;
        treeArray = (T[]) new Comparable[ARRAYSIZE];
        treeArray[ROOT] = (T) data;
        INORDER = 3;
        POSTORDER = 2;
        PREORDER = 1;
        outputNumber = 0;
    }

    public Tree_array() {
        ARRAYSIZE = 1000;
        ROOT = 1;
        treeArray = (T[]) new Comparable[ARRAYSIZE];
        INORDER = 3;
        POSTORDER = 2;
        PREORDER = 1;
        outputNumber = 0;
    }


    /**
     * Hinzufügen eines weiteren Knotens.
     * Ein weiterer Knoten wird automatisch an der richtigen Stelle hinzugefügt. (Es wird erkannt wo er eingefügt werden muss)
     * @param data Vergleichbarer Wert der in den Knoten eingefügt wird.  Der Knoten wiederrum wird in den Baum oder Array eingefügt.
     */
    @Override
    public void addKnot(Object data) {
        int index = ROOT;                                   //Index wird an die Wurzel gelegt.
        if (treeArray[index] == null) {                      //Sollte Faelschlicherweise noch keine Wurzel erstellt worden sein, wird eine neue erstellt.
            treeArray[index] = (T) data;
        } else {
            if (treeArray[index].compareTo((T) data) > 0) {      //Sollten die bekommenen Daten kleiner sein als der Wert der Wurzel Index = 2, sonst Index = 3
                index = 2;
            } else {
                index = 3;
            }
            do {                                                //eternal loop bis wir an gültiger und richtiger einfuegeposition sind.
                if (treeArray[index] == null) {                 //Wenn aktuelle Stelle im Array null = Wert einbetten an diese Stelle.
                    treeArray[index] = (T) data;
                    break;                                      //Abbrechen des eternal loop
                }
                if (treeArray[index].compareTo((T) data) > 0) {  //Wenn Daten kleiner als der Wert der aktuellen Stelle im Array = index * 2, ansonsten (index * 2) + 1
                    index = index * 2;
                } else {
                    index = index * 2 + 1;
                }
            } while (true);
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
            outputNumber = 0;
            preorder (ROOT, 1);
        } else if (method == POSTORDER) { // Nebenreihenfolge ausgeben
            outputNumber = 0;
            postorder (ROOT, 2);
        } else if (method == INORDER) {   // Symmetrie
            outputNumber = 0;
            inorder(ROOT, 1);
        }
    }

    /**
     * Ausgabe der Preorder Methode nach rekursivem Verfahren
     * @param root Wurzel des aktuellen aufrufes
     * @param order Methode die angewendet wurde
     */
    private void preorder (int root, int order) {
        String method = setOrder(order);
        System.out.printf("Die %d Stelle der %s hat den Wert: %d\n", outputNumber, method, treeArray[root]);
        outputNumber++;
        if (treeArray[root * 2] != null) {
            preorder(root * 2, order);
        }
        if (treeArray[root * 2 + 1] != null) {
            preorder(root * 2 + 1, order);
        }
    }




    /**
     * Ausgabe der Postorder Methode nach rekursivem Verfahren
     * @param root Wurzel des aktuellen aufrufes
     * @param order Methode die angewendet wurde
     */
    private void postorder (int root, int order) {
        String method = setOrder(order);
        if (treeArray[root * 2] != null) {
            postorder(root * 2, order);
        }
        if (treeArray[root * 2 + 1] != null) {
            postorder(root * 2 + 1, order);
        }
        System.out.printf("Die %d Stelle der %s hat den Wert: %d\n", outputNumber, method, treeArray[root]);
        outputNumber++;
    }




    /**
     * Ausgabe der Inorder Methode nach rekursivem Verfahren
     * @param root Wurzel des aktuellen aufrufes
     * @param order Methode die angewendet wurde
     */
    private void inorder(int root, int order) {
        String method = setOrder(order);
        //Wurzel
        if (treeArray[root * 2] != null) {
            inorder(root * 2, order);
        }
        System.out.printf("Die %d Stelle der %s hat den Wert: %d\n", outputNumber, method, treeArray[root]);
        outputNumber++;

        if (treeArray[root * 2 + 1] != null){
            inorder(root * 2 + 1, order);
        }
    }

    /**
     * Ermittelt die aktuelle Ausgabemethode
     * @param order Methode die angewendet wird
     * @return Aktuelle Methode als String für die Ausgabe auf der Konsole
     */
    private String setOrder (int order) {
        String result = "";
        switch (order){
            case 3: result = "symmetrischen Methode";
                break;
            case 1: result = "Hauptreihenfolge";
                break;
            case 2: result = "Nebenreihenfolge";
                break;
        }
        return result;
    }
}
