import java.util.ArrayList;

public class mainGraph {




    public static void main (String [] args) {

        Knoten_Graph neuerKnotenMatrix = new Knoten_Graph(0);
        Adjazenzmatrix adjazenzmatrix = new Adjazenzmatrix(neuerKnotenMatrix);
        Knoten_Graph neuerKnotenMatrix1 = new Knoten_Graph(1);
        Knoten_Graph neuerKnotenMatrix2 = new Knoten_Graph(2);
        Knoten_Graph neuerKnotenMatrix3 = new Knoten_Graph(3);
        Knoten_Graph neuerKnotenMatrix4 = new Knoten_Graph(4);
        Knoten_Graph neuerKnotenMatrix5 = new Knoten_Graph(5);
        Knoten_Graph neuerKnotenMatrix6 = new Knoten_Graph(6);
        Knoten_Graph neuerKnotenMatrix7 = new Knoten_Graph(7);
        Knoten_Graph neuerKnotenMatrix8 = new Knoten_Graph(8);
        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix1);
        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix2);
        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix3);
        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix4);
        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix5);
        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix6);
        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix7);
        adjazenzmatrix.knotenEinfuegen(neuerKnotenMatrix8);
        adjazenzmatrix.kanteEinfuegen(neuerKnotenMatrix, neuerKnotenMatrix1, 3);
        adjazenzmatrix.kanteEinfuegen(neuerKnotenMatrix, neuerKnotenMatrix2, 4);
        adjazenzmatrix.kanteEinfuegen(neuerKnotenMatrix3, neuerKnotenMatrix7, 5);
        adjazenzmatrix.kanteEinfuegen(neuerKnotenMatrix5, neuerKnotenMatrix1, 6);
        adjazenzmatrix.kanteEinfuegen(neuerKnotenMatrix1, neuerKnotenMatrix7, 6);
        //m.allesAusgeben();
        adjazenzmatrix.traversieren(neuerKnotenMatrix);
        System.out.println("");
        System.out.println(adjazenzmatrix.gewichtAuslesen(neuerKnotenMatrix,neuerKnotenMatrix1));
        System.out.println(adjazenzmatrix.gewichtAuslesen(neuerKnotenMatrix3,neuerKnotenMatrix7));
        System.out.println(adjazenzmatrix.gewichtAuslesen(neuerKnotenMatrix1,neuerKnotenMatrix5));
        System.out.println(adjazenzmatrix.gewichtAuslesen(neuerKnotenMatrix7,neuerKnotenMatrix1));
        System.out.println("\n\n\n");


        Knoten_Graph neuerKnotenListe = new Knoten_Graph(0);
        Adjazenzliste adjazenzliste = new Adjazenzliste(neuerKnotenListe);
        Knoten_Graph neuerKnotenListe1 = new Knoten_Graph(1);
        Knoten_Graph neuerKnotenListe2 = new Knoten_Graph(2);
        Knoten_Graph neuerKnotenListe3 = new Knoten_Graph(3);
        Knoten_Graph neuerKnotenListe4 = new Knoten_Graph(4);
        Knoten_Graph neuerKnotenListe5 = new Knoten_Graph(5);
        Knoten_Graph neuerKnotenListe6 = new Knoten_Graph(6);
        Knoten_Graph neuerKnotenListe7 = new Knoten_Graph(7);
        Knoten_Graph neuerKnotenListe8 = new Knoten_Graph(8);
        adjazenzliste.knotenEinfuegen(neuerKnotenListe1);
        adjazenzliste.knotenEinfuegen(neuerKnotenListe2);
        adjazenzliste.knotenEinfuegen(neuerKnotenListe3);
        adjazenzliste.knotenEinfuegen(neuerKnotenListe4);
        adjazenzliste.knotenEinfuegen(neuerKnotenListe5);
        adjazenzliste.knotenEinfuegen(neuerKnotenListe6);
        adjazenzliste.knotenEinfuegen(neuerKnotenListe7);
        adjazenzliste.knotenEinfuegen(neuerKnotenListe8);
        adjazenzliste.kanteEinfuegen(neuerKnotenListe, neuerKnotenListe1, 3);
        adjazenzliste.kanteEinfuegen(neuerKnotenListe, neuerKnotenListe2, 4);
        adjazenzliste.kanteEinfuegen(neuerKnotenListe3, neuerKnotenListe7, 5);
        adjazenzliste.kanteEinfuegen(neuerKnotenListe5, neuerKnotenListe1, 6);
        adjazenzliste.kanteEinfuegen(neuerKnotenListe1, neuerKnotenListe7, 6);
        //m.allesAusgeben();
        adjazenzliste.traversieren(neuerKnotenListe);
        System.out.println("\n");
        System.out.println(adjazenzliste.gewichtAuslesen(neuerKnotenListe,neuerKnotenListe1));
        System.out.println(adjazenzliste.gewichtAuslesen(neuerKnotenListe3,neuerKnotenListe7));
        System.out.println(adjazenzliste.gewichtAuslesen(neuerKnotenListe1,neuerKnotenListe5));
        System.out.println(adjazenzliste.gewichtAuslesen(neuerKnotenListe7,neuerKnotenListe1));


        Graph testGraph = new Adjazenzliste(new Knoten_Graph(0));
        for(int i = 1; i <= 6; i++)
        {
            testGraph.knotenEinfuegen(new Knoten_Graph(i));
        }

        ArrayList<Knoten_Graph> knotenGraph = testGraph.gibAlleKnoten();

        testGraph.kanteEinfuegen(knotenGraph.get(0), knotenGraph.get(1), 2);
        testGraph.kanteEinfuegen(knotenGraph.get(1), knotenGraph.get(2), 6);
        testGraph.kanteEinfuegen(knotenGraph.get(1), knotenGraph.get(3), 4);
        testGraph.kanteEinfuegen(knotenGraph.get(2), knotenGraph.get(3), 2);
        testGraph.kanteEinfuegen(knotenGraph.get(2), knotenGraph.get(4), 1);
        testGraph.kanteEinfuegen(knotenGraph.get(0), knotenGraph.get(2), 15);
        testGraph.kanteEinfuegen(knotenGraph.get(0), knotenGraph.get(5), 15);
        testGraph.kanteEinfuegen(knotenGraph.get(3), knotenGraph.get(4), 4);
        testGraph.kanteEinfuegen(knotenGraph.get(4), knotenGraph.get(5), 2);
        testGraph.kanteEinfuegen(knotenGraph.get(6), knotenGraph.get(5), 1);
        testGraph.kanteEinfuegen(knotenGraph.get(6), knotenGraph.get(2), 15);

        //testGraph.graphMalen();

        DijkstraAlgorithmus routenPlaner = new DijkstraAlgorithmus(testGraph);
    }
}
