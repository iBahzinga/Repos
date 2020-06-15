/**
 * Darstellung eines Graphen als Adjazenzschreibweise.
 *
 * Es sollen in die Adjazenzliste weitere Knoten eingefügt werden können,
 * sowie auch die Knoten mit Kanten verbunden werden.
 *
 * Es soll basierend auf einem Knoten dieser durchtraversiert werden, um die Anzahl der Kanten zu finden, ausgehend dieses Knotens.
 * Der Knoten kann zurueckgeliefert werden, um sich anschließend die Daten zu holen.
 *
 * Man kann über einen knoten traversieren und die daten aller Knoten ausgeben lassen zu denen es eine Kante gibt.
 *
 * Es lässt sich die gesamte Liste ausgeben auf der Konsole.
 *
 * Man kann sich die gesamte anzahl an Knoten ausgeben lassen.
 *
 *
 * @author Santa Rudevica
 * @author Pascal Kießler
 * @author Daniel Dichte
 *
 * @version 1.4
 * @version 14.06.2020
 *
 * @param <T>
 */

import java.util.LinkedList;

public class Adjazenzliste <T> implements Graph {

    private int anzahlKnoten;
    private LinkedList<Integer> adjazenzlist[];
    private KnotenGraph[] knoten_G;

    /**
     * Konstruktor der Klasse Adjazenzliste
     */
    public Adjazenzliste () {
        knoten_G = new KnotenGraph[10];
        adjazenzlist = new LinkedList[10];
        anzahlKnoten = 0;
    }

    /**
     * Hinzufügen eines neuen Knoten in die Adiazanzliste
     * @param data Daten die in dem Knoten stehen sollen.
     */
    @Override
    public void knotenEinfuegen(Object data) {
        arrayErweitern();
        knoten_G[anzahlKnoten] = new KnotenGraph(data);
        adjazenzlist[anzahlKnoten] = new LinkedList<Integer>();
        anzahlKnoten++;
    }

    /**
     * Einfügen einer Kante zwischen 2 Graphen
     * @param knoten1 Position des ersten Graphen im Array
     * @param knoten2 Position des zweiten Graphen im Array
     */
    @Override
    public void kanteEinfuegen(int knoten1, int knoten2) {
        if (knotenVorhanden(knoten1)) {
            if (knotenVorhanden(knoten2)) {
                adjazenzlist[knoten1].add(knoten2);
            }
            else {
                throw new IllegalArgumentException ("Knoten2 existiert nicht");
            }
        }
        else {
            throw new IllegalArgumentException ("Knoten1 existiert nicht");
        }
    }

    /**
     * Ausgabe des Inhaltes eines Knotens
     * @param knoten1 Knoten dessen Inhalt ausgegeben werden soll.
     */
    @Override
    public int traversieren(int knoten1) {
        return adjazenzlist[knoten1].size();
    }

    /**
     * Traversiert das gesamte Array, um herauszufinden wieviele Referenzen auf andere Knoten wir haben.
     * @param knoten1 Knoten von dem die Nachbarn gesucht werden und die anzahl der Referenzen ausgegeben werden sollen.
     * @return anzahl der Nachbarn (Zeiger auf andere Knoten)
     */
    @Override
    public void debugTraversieren(KnotenGraph knoten1, KnotenGraph knoten2) {

    }

    /**
     * Unverstndlich was hier passieren soll.
     * @param knoten1
     */
    @Override
    public void gewichtTraversieren(int knoten1) {
        System.out.print("Knoten: " +gibKnoten(knoten1).getDaten()+ " ist verbunden mit: ");
        for (int j = 0; j < adjazenzlist[knoten1].size(); j++){
            System.out.print(adjazenzlist[knoten1].get(j) +" ");
        }
        System.out.println("");
    }

    /**
     * Ausgabe der Gewichte/Inhalte aller knoten mit Referenz auf Knoten1
     * @param knoten Knoten von dem die Nachbarn gesucht werden und die Gewichte ausgegeben werden sollen.
     */
    @Override
    public void knotenAusgabe(int knoten) {
        System.out.println("Knoten: " + gibKnoten(knoten).getDaten());
    }

    /**
     * Ausgabe der Adiazenzliste auf der Konsole
     */
    public void allesAusgeben(){
        for (int i = 0; i< anzahlKnoten; i++){
            gewichtTraversieren(i);
        }
    }

    /**
     * Gibt die Anzahl der Knoten in der Liste zurück.
     */
    protected int getAnzahlKnoten(){
        return anzahlKnoten;
    };

    /**
     * Gibt den angefragten Knoten aus der Liste zurück.
     * @param knoten
     */
    protected KnotenGraph gibKnoten(int knoten){
        if (knotenVorhanden(knoten)) {
            return knoten_G[knoten];
        }
        else {
            throw new IllegalArgumentException ("Knoten existiert nicht");
        }
    }

    /**
     * Prueft ob der gesuchte Knoten vorhanden ist.
     * @param knoten Nummer des gewuenschten Knotens
     * @return Knoten vorhanden ->true, Knoten nicht vorhanden -> false
     */
    private boolean knotenVorhanden (int knoten) {
        return anzahlKnoten >= knoten;
    }

    private void arrayErweitern() {
        if (knoten_G.length / 2 <= anzahlKnoten) {
            KnotenGraph neuesKnotenArray[] = new KnotenGraph[knoten_G.length * 2];
            for (int i = 0; i <= anzahlKnoten; i++) {
                neuesKnotenArray[i] = knoten_G[i];
            }
            knoten_G = neuesKnotenArray;
            LinkedList neuesKnotenList[] = new LinkedList[adjazenzlist.length * 2];
            for (int i = 0; i <= anzahlKnoten; i++) {
                neuesKnotenList[i] = adjazenzlist[i];
            }
            adjazenzlist = neuesKnotenList;
        }
    }
}
