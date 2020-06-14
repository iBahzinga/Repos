
public class Adjazenzmatrix <T> implements Graph {

    private KnotenGraph knoten;
    private boolean [][] adjazenzmatrix;
    private final int ARRAYSIZE;
    private int anzahlKnoten;
    private KnotenGraph [] knotenarray;

    public Adjazenzmatrix () {
        ARRAYSIZE = 10;
        adjazenzmatrix = new boolean [ARRAYSIZE][ARRAYSIZE];
        anzahlKnoten = 0;
          knotenarray = new KnotenGraph[ARRAYSIZE];
    }




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



    @Override
    public KnotenGraph gibKnoten(int knoten) {
        if (knotenVorhanden(knoten)) {
            return (KnotenGraph) knotenarray[knoten];
        } else {
            throw new IllegalArgumentException ("Knoten existiert nicht");
        }
    }

    @Override
    public void knotenAusgabe(int knoten) {
        System.out.println(gibKnoten(knoten).getDaten());
    }




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

    @Override
    public void debugTraversieren(KnotenGraph knoten1, KnotenGraph knoten2) {
        /**
         * Hier verstehe ich nicht ganz was das machen soll.
         */
    }



    @Override
    public void gewichtTraversieren(KnotenGraph knoten1, KnotenGraph knoten2) {
        /**
         * DAs könnte schon das sein was die Methode allesAusgeben macht.
         */
    }


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


    private boolean knotenVorhanden (int knoten) {
        return knotenarray.length >= knoten;
    }



}
