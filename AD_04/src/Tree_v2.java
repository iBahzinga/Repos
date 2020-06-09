public class Tree_v2 <T extends Comparable<T>> implements Search_ {
    private Knot root;
    private Knot knot;
    private final int ZERO;

    public Tree_v2 (Knot  root) {
        this.root = root;
        ZERO = 0;
        // man kann hier auch nur die Daten eingeben und dann kann man den rest der Wurzel erzeugen, anstatt direkt die ganze Wurzel zu übergeben.
    }





    @Override
    public Knot addKnot(Object data) {
        Knot newKnot;
        if (root.getData().compareTo(data) < ZERO ) {           //linke Seite der Wurzel
            if (root.getChildLeft() == null){                   //wenn noch kein Kind auf der linken seite vorhanden ist neuen Knoten einfügen
                newKnot = new Knot ((Comparable) data, root);                //Verbindungen des Knotens setzen
                root.setChildLeft(newKnot);                     //Verbindung der Wurzel setzen
            } else {
                knot = root.getChildLeft();                 //linken Knoten geben
                while (true){
                    if (knot.getData().compareTo(data) < ZERO) {//sollten die Daten kleiner sein als die des aktuellen Knotens -> links einfügen
                        if (knot.getChildLeft() == null) {      //sollte noch klein Knoten da sein, hier einen neuen einfügen
                            newKnot = new Knot((Comparable) data, knot);     //Verbindingen des Knotens setzen
                            knot.setChildLeft(newKnot);         //Verbindungen des alten Knotens setzen
                            break;  //ggf. muss hier ein return hin
                        } else {                                //wenn hier schon ein Knoten ist, hole mir den neuen knoten und gehe erneut durch die Schleife.
                            knot = knot.getChildLeft();
                        }
                    } else { //evtl. hier else if (knot.getData().compareTo(data) >= ZERO)      //Wenn das Kind auf die Rechte seite muss, geh hier rein
                        if (knot.getChildRight() == null) {     //Wenn auf der rechten Seite des Knotens noch kein weiterer Knoten ist, fuege ihn hier ein
                            newKnot = new Knot((Comparable) data, knot);     //Verbindung des keien Knotens setzen
                            knot.setChildRight(newKnot);        //Verbindungen des alten Knotens setzen
                            break; //ggf. sollte hier noch ein return hin.
                        } else {                                //wenn auf der rechten Steite schon ein Knoten ist, dann hole den neuen Knoten und gehe erneut durch die schleife
                            knot = knot.getChildRight();
                        }
                    }
                }
            }
        }
        if (root.getData().compareTo(data) >= ZERO ) {          //rechte Seite der Wurzel
            if (root.getChildRight() == null){                  //wenn noch kein Kind auf der rechten seite vorhanden ist neuen Knoten einfügen
                newKnot = new Knot ((Comparable) data, root);                //Verbindungen des Knotens setzen
                root.setChildRight(newKnot);                    //Verbindung der Wurzel setzen
            } else {
                knot = root.getChildRight();                //rechten Knoten geben
                while (true){
                    if (knot.getData().compareTo(data) < ZERO) {//sollten die Daten kleiner sein als die des aktuellen Knotens -> links einfügen
                        if (knot.getChildLeft() == null) {      //sollte noch kein Knoten da sein, hier einen neuen einfügen
                            newKnot = new Knot((Comparable) data, knot);     //Verbindung des keien Knotens setzen
                            knot.setChildLeft(newKnot);         //Verbindungen des alten Knotens setzen
                            break;  //ggf. muss hier ein return hin
                        } else {                                //wenn hier schon ein Knoten ist, hole mir den neuen knoten und gehe erneut durch die Schleife.
                            knot = knot.getChildLeft();
                        }
                    } else { //evtl. hier else if (knot.getData().compareTo(data) >= ZERO)          //Wenn das Kind auf die Rechte seite muss, geh hier rein
                        if (knot.getChildRight() == null) {     //Wenn auf der rechten Seite des Knotens noch kein weiterer Knoten ist, fuege ihn hier ein
                            newKnot = new Knot((Comparable) data, knot);     //Verbindung des keien Knotens setzen
                            knot.setChildRight(newKnot);        //Verbindungen des alten Knotens setzen
                            break;
                        } else {                                //wenn hier schon ein Knoten ist, hole mir den neuen knoten und gehe erneut durch die Schleife.
                            knot = knot.getChildRight();
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public void printKnot() {

    }
}