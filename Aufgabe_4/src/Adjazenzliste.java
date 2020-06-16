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
 * @version 1.1
 * @version 14.06.2020
 *
 */

// hi Pascal

import java.util.LinkedList;

public class Adjazenzliste<T> implements Graph {
    private KnotenGraph knoten;
    private int anzahlKnoten = 0;
    private LinkedList<Integer>[] adjazenzlist = new LinkedList[10];

    public Adjazenzliste() {
    }

    public void knotenEinfuegen(Object data) {
        this.adjazenzlist[this.anzahlKnoten] = new LinkedList();
        ++this.anzahlKnoten;
    }

    public void kanteEinfuegen(int knoten1, int knoten2) {
        this.adjazenzlist[knoten1].add(knoten2);
    }

    public int traversieren(int knoten1) {
        return this.adjazenzlist[knoten1].size();
    }

    public void debugTraversieren(KnotenGraph knoten1, KnotenGraph knoten2) {
    }

    public void gewichtTraversieren(int knoten1) {
        System.out.print("Knoten: " + knoten1 + " ist verbunden mit: ");

        for(int j = 0; j < this.adjazenzlist[knoten1].size(); ++j) {
            LinkedList var10001 = this.adjazenzlist[knoten1];
            System.out.print(var10001.get(j) + " ");
        }

        System.out.println("");
    }

    public void knotenAusgabe(int knoten) {
        LinkedList var10001 = this.adjazenzlist[knoten];
        System.out.println("Knoten: " + var10001);
    }

    public void allesAusgeben() {
        for(int i = 0; i < this.anzahlKnoten; ++i) {
            if (this.adjazenzlist[i].size() > 0) {
                this.gewichtTraversieren(i);
            }
        }

    }

    protected int getAnzahlKnoten() {
        return this.anzahlKnoten;
    }
}
