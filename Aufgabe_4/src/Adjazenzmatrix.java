
/*
public class Adjazenzmatrix <T> implements Graph {

    private KnotenGraph knoten;
    private boolean [][] adjazenzmatrix;
    private final int ARRAYSIZE;
    private int anzahlKnoten;
    private T [] knotenarray;

    public Adjazenzmatrix () {
        ARRAYSIZE = 10;
        adjazenzmatrix = new boolean [ARRAYSIZE][ARRAYSIZE];
        anzahlKnoten = 0;
          knotenarray = (T[]) new Comparable[ARRAYSIZE];
    }




    @Override
    public void knotenEinfuegen(Object data) {
        {
            if(anzahlKnoten < knotenarray.length) //sorgt dafür, dass keine Fehlermeldung erscheint, wenn zu viele Knoten erzeugt werden
            {
                knotenarray[anzahlKnoten]= new KnotenGraph (data); //fügt den Knoten an das einfache Feld der Knoten an
                adjazenzmatrix[anzahlKnoten][anzahlKnoten] = false; //fügt in der Matrix -1 ein, da hier keine Kante entstehen kann
            }
            else
            {
                System.out.println("Liste muss vergroessert werden!");
            }
        }

    }

    @Override
    public void kanteEinfuegen(KnotenGraph knoten1, KnotenGraph knoten2) {


    }

    @Override
    public boolean traversieren(KnotenGraph knoten1, KnotenGraph knoten2) {
        return false;
    }

    @Override
    public void debugTraversieren(KnotenGraph knoten1, KnotenGraph knoten2) {

    }

    @Override
    public KnotenGraph gibKnoten(KnotenGraph knoten) {
        return null;
    }

    @Override
    public void gewichtTraversieren(KnotenGraph knoten1, KnotenGraph knoten2) {

    }

    @Override
    public void graphAusgabe() {

    }
}
*/