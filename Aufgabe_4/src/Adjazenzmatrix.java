/**
 * Darstellung eines Graphen als Adjazenzschreibweise.
 *
 * Es sollen in die Adjazenzmatrix weitere Knoten eingefügt werden können,
 * sowie auch die Knoten mit Kanten verbunden werden.
 *
 * Es soll basierend auf einem Knoten dieser durchtraversiert werden, um die Anzahl der Kanten zu finden, ausgehend dieses Knotens.
 * Der Knoten kann zurueckgeliefert werden, um sich anschließend die Daten zu holen.
 *
 * Man kann über einen knoten traversieren und die daten aller Knoten ausgeben lassen zu denen es eine Kante gibt.
 *
 * Es lässt sich die gesamte Matrix ausgeben auf der Konsole.
 *
 * Man kann sich die gesamte anzahl an Knoten ausgeben lassen.
 *
 *
 * @author Daniel Dichte
 * @author Santa Rudevica
 * @author Pascal Kießler
 *
 * @version 1.1
 * @version 14.06.2020
 *
 * @param <T>
 */
public class Adjazenzmatrix <T> implements Graph {

    private KnotenGraph knoten;
    private boolean [][] adjazenzmatrix;
    private final int ARRAYSIZE;
    private int anzahlKnoten;
    private KnotenGraph [] knotenarray;

    /**
     * Konstruktor der Klasse Adjazenzmatrix
     */
    public Adjazenzmatrix () {
        ARRAYSIZE = 10;
        adjazenzmatrix = new boolean [ARRAYSIZE][ARRAYSIZE];
        anzahlKnoten = 0;
        knotenarray = new KnotenGraph[ARRAYSIZE];
    }


    /**
     * Hinzufügen eines neuen Knoten in die Adiazanzmatrix
     * @param data Daten die in dem Knoten stehen sollen.
     */
    @Override
    public void knotenEinfuegen(Object data) {
        if(anzahlKnoten < knotenarray.length) { //sorgt dafür, dass keine Fehlermeldung erscheint, wenn zu viele Knoten erzeugt werden
            KnotenGraph neuerKnoten = new KnotenGraph (data);
            knotenarray[anzahlKnoten] = neuerKnoten; //fügt den Knoten an das einfache Feld der Knoten an
            adjazenzmatrix[anzahlKnoten][anzahlKnoten] = false; //fügt in der Matrix -1 ein, da hier keine Kante entstehen kann
            anzahlKnoten++;
        } else {
            System.out.println("Liste muss vergroessert werden!");
        }
    }

    /**
     * Einfügen einer Kante zwischen 2 Graphen
     * @param knoten1 Position des ersten Graphen im Array
     * @param knoten2 Position des zweiten Graphen im Array
     */
    @Override
    public void kanteEinfuegen(int knoten1, int knoten2) {
        if (!knotenVorhanden(knoten1)) //kontrolliert mit der Methode KnotenNummer, ob der Startknoten der Kante vorhanden ist
        {
            System.out.println("Der Startknoten existiert nicht.");
        } else {
            if (!knotenVorhanden(knoten2)) //kontrolliert mit der Methode KnotenNummer, ob der Endknoten der Kante voranden ist
            {
                System.out.println("Der Endknoten existiert nicht.");
            } else {
                adjazenzmatrix[knoten1][knoten2] = true; //setzt in die entsprechende Zelle die Gewichtung ein
            }
        }
    }


    /**
     * Finden eines gesuchten Knotens.
     * Sollte Kein Knoten gefunden werden, wird eine IllegalArgumentException geworfen.
     * @param knoten Stelle in der Matrix an dem der Knoten geholt werden soll
     * @return Der gewünschte Knoten
     */
    @Override
    public KnotenGraph gibKnoten(int knoten) {
        if (knotenVorhanden(knoten)) {
            return (KnotenGraph) knotenarray[knoten];
        } else {
            throw new IllegalArgumentException ("Knoten existiert nicht");
        }
    }

    /**
     * Ausgabe des Inhaltes eines Knotens
     * @param knoten Knoten dessen Inhalt ausgegeben werden soll.
     */
    @Override
    public void knotenAusgabe(int knoten) {
        System.out.println(gibKnoten(knoten).getDaten());
    }


    /**
     * Traversiert das gesamte Array, um herauszufinden wieviele Referenzen auf andere Knoten wir haben.
     * @param knoten1 Knoten von dem die Nachbarn gesucht werden und die anzahl der Referenzen ausgegeben werden sollen.
     * @return anzahl der Nachbarn (Zeiger auf andere Knoten)
     */
    @Override
    public int traversieren(int knoten1) {
        int result = 0;

        for (int i = 0; i < anzahlKnoten; i++){
            if (adjazenzmatrix[knoten1][i]){
                result++;
            }
        }
        return result;
    }

    /**
     * Unverstndlich was hier passieren soll.
     * @param knoten1
     * @param knoten2
     */
    @Override
    public void debugTraversieren(KnotenGraph knoten1, KnotenGraph knoten2) {
    }


    /**
     * Ausgabe der Gewichte/Inhalte aller knoten mit Referenz auf Knoten1
     * @param knoten1 Knoten von dem die Nachbarn gesucht werden und die Gewichte ausgegeben werden sollen.
     */
    @Override
    public void gewichtTraversieren(int knoten1) {
        for (int i = 0; i < anzahlKnoten; i++){
            System.out.println( i + ". Knoten: " + adjazenzmatrix[knoten1][i]);
        }
    }

    /**
     * Ausgabe der Adiazenzmatrix auf der Konsole
     */
    public void allesAusgeben (){
        System.out.print("\t\t");
        for(int y = 0; y < anzahlKnoten; y++) //druckt die erste Zeile (alle Knoten in deren Reihenfolge)
        {
            System.out.print(gibKnoten(y).getDaten());
            System.out.print(" | \t");
        }
        for(int i = 0; i < anzahlKnoten; i++) //druckt die übrigen Zeilen untereinander
        {
            System.out.println(" ");

            System.out.print(gibKnoten(i).getDaten());
            System.out.print(" | ");
            for(int z = 0; z < anzahlKnoten; z++) //druckt die entsprechende Teile die die Gewichtungen von Knoten[i] anzeigt
            {
                if(adjazenzmatrix[i][z] != false) //kontrolliert, dass keine Kanten erzeugt werden, wo keine erzeugt werden können
                {
                    if(adjazenzmatrix[i][z] == true) //erstetzt alle Zellen in denen 0 steht durch " "
                    {
                        System.out.print(" true ");
                        System.out.print(" | ");
                    }
                    else
                    {
                        System.out.print(" ");
                        System.out.print(" " + adjazenzmatrix[i][z] + " ");
                        System.out.print(" | ");
                    }
                }
                else
                {
                    System.out.print(" " + adjazenzmatrix[i][z] + " ");

                    System.out.print("|");
                }
            }
        }
    }

    /**
     * Prueft ob der gesuchte Knoten vorhanden ist.
     * @param knoten Nummer des gewuenschten Knotens
     * @return Knoten vorhanden ->true, Knoten nicht vorhanden -> false
     */
    private boolean knotenVorhanden (int knoten) {
        return knotenarray.length >= knoten;
    }

    /**
     * Rueckgabe der anzahl der Knoten die sich in unserer Adiazenzmatrix befinden
     * @return Anzahl Knoten
     */
    private int getAnzahlKnoten () {
        return anzahlKnoten;
    }

}
