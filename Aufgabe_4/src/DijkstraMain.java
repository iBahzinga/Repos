import java.util.ArrayList;

public class DijkstraMain {
    public static void main(String[] args){

        //Komplexitätsuntersuchung
        //double k = 1; //k kann sein 1,2,3,4... Verändert exponentiell die Anzahl der Knoten
        int komplex = 10000;
        /*Graph adjazenzGraph = new Adjazenzliste(new Knoten_Graph(0));

        for (int i = 1; i <= komplex; i++) {
            adjazenzGraph.knotenEinfuegen(new Knoten_Graph(i));
        }
        ArrayList<Knoten_Graph> knoten = adjazenzGraph.gibAlleKnoten();

        for(int j = 0; j <= komplex*3; j++) {
            try {
                int knoten1 = (int) (Math.random() * (komplex));
                int knoten2 = (int) (Math.random() * (komplex));
                int gewichtung = (int)(Math.random()*100);
                adjazenzGraph.kanteEinfuegen(knoten.get(knoten1), knoten.get(knoten2), gewichtung);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
        long zeitVorher = System.currentTimeMillis();
        new DijkstraAlgorithmus(adjazenzGraph);
        long zeitNachher = System.currentTimeMillis();
        double zeitGesamt = (double) (zeitNachher - zeitVorher);
        System.out.printf("Die Zeit für %d Knoten hat insgesamt %.1f Milisekunden betragen. \n",komplex, zeitGesamt);
        */

        Graph adjazenzGraph = new Adjazenzmatrix(new Knoten_Graph(0));

        for (int i = 1; i <= komplex; i++) {
            adjazenzGraph.knotenEinfuegen(new Knoten_Graph(i));
        }
        Knoten_Graph [] knoten = ((Adjazenzmatrix) adjazenzGraph).getKnotenGraphArray();

        for(int j = 0; j <= komplex*3; j++) {
            try {
                int knoten1 = (int) (Math.random() * (komplex));
                int knoten2 = (int) (Math.random() * (komplex));
                int gewichtung = (int)(Math.random()*100);
                adjazenzGraph.kanteEinfuegen(knoten[knoten1],knoten[knoten2], gewichtung);
            } catch (IllegalArgumentException e) {
                continue;
            }
        }
        long zeitVorher = System.currentTimeMillis();
        new DijkstraAlgorithmus(adjazenzGraph);
        long zeitNachher = System.currentTimeMillis();
        double zeitGesamt = (double) (zeitNachher - zeitVorher);
        System.out.printf("Die Zeit für %d Knoten hat insgesamt %.1f Milisekunden betragen. \n",komplex, zeitGesamt);

    }

}
