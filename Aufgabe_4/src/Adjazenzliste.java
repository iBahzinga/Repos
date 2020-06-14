import java.util.ArrayList;
import java.util.LinkedList;

public class Adjazenzliste <T> implements Graph {

    private KnotenGraph knoten;
    private int anzahlKnoten;
    private LinkedList<Integer> adjazenzlist[];

    public Adjazenzliste () {
        adjazenzlist = new LinkedList[10];
        anzahlKnoten = 0;
    }

    @Override
    public void knotenEinfuegen(Object data) {
        adjazenzlist[anzahlKnoten] = new LinkedList<Integer>();
        anzahlKnoten++;
    }

    @Override
    public void kanteEinfuegen(int knoten1, int knoten2) {
        adjazenzlist[knoten1].add(knoten2);
    }

    @Override
    public int traversieren(int knoten1) {
        return adjazenzlist[knoten1].size();
    }

    @Override
    public void debugTraversieren(KnotenGraph knoten1, KnotenGraph knoten2) {

    }

    @Override
    public void gewichtTraversieren(int knoten1) {
        System.out.print("Knoten: " +knoten1+ " ist verbunden mit: ");
        for (int j = 0; j < adjazenzlist[knoten1].size(); j++){
            System.out.print(adjazenzlist[knoten1].get(j) +" ");
        }
        System.out.println("");
    }

    @Override
    public void knotenAusgabe(int knoten) {
        System.out.println("Knoten: " + adjazenzlist[knoten]);
    }

    public void allesAusgeben (){
        for (int i = 0; i< anzahlKnoten; i++){
            if(adjazenzlist[i].size()>0){
                gewichtTraversieren(i);
            }
        }
    }

    protected int getAnzahlKnoten(){
        return anzahlKnoten;
    }
}
