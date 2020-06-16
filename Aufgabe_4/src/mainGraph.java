import java.util.ArrayList;

public class mainGraph {




    public static void main (String [] args) {
        /*
        Knoten newKnot = new Knoten(0);
        Adjazenzmatrix m = new Adjazenzmatrix(newKnot);
        Knoten newKnot1 = new Knoten(1);
        Knoten newKnot2 = new Knoten(2);
        Knoten newKnot3 = new Knoten(3);
        Knoten newKnot4 = new Knoten(4);
        Knoten newKnot5 = new Knoten(5);
        Knoten newKnot6 = new Knoten(6);
        Knoten newKnot7 = new Knoten(7);
        Knoten newKnot8 = new Knoten(8);
        m.knotenEinfuegen(newKnot1);
        m.knotenEinfuegen(newKnot2);
        m.knotenEinfuegen(newKnot3);
        m.knotenEinfuegen(newKnot4);
        m.knotenEinfuegen(newKnot5);
        m.knotenEinfuegen(newKnot6);
        m.knotenEinfuegen(newKnot7);
        m.knotenEinfuegen(newKnot8);
        m.kanteEinfuegen(newKnot, newKnot1, 3);
        m.kanteEinfuegen(newKnot, newKnot2, 4);
        m.kanteEinfuegen(newKnot3, newKnot7, 5);
        m.kanteEinfuegen(newKnot5, newKnot1, 6);
        m.kanteEinfuegen(newKnot1, newKnot7, 6);
        //m.allesAusgeben();
        m.traversieren(newKnot);
        System.out.println("\n");
        System.out.println(m.gewichtAuslesen(newKnot,newKnot1));
        System.out.println(m.gewichtAuslesen(newKnot3,newKnot7));
        System.out.println(m.gewichtAuslesen(newKnot1,newKnot5));
        System.out.println(m.gewichtAuslesen(newKnot7,newKnot1));
 */
        /*
        Knoten newKnot = new Knoten(0);
        Liste_V2 m = new Liste_V2(newKnot);
        Knoten newKnot1 = new Knoten(1);
        Knoten newKnot2 = new Knoten(2);
        Knoten newKnot3 = new Knoten(3);
        Knoten newKnot4 = new Knoten(4);
        Knoten newKnot5 = new Knoten(5);
        Knoten newKnot6 = new Knoten(6);
        Knoten newKnot7 = new Knoten(7);
        Knoten newKnot8 = new Knoten(8);
        m.knotenEinfuegen(newKnot1);
        m.knotenEinfuegen(newKnot2);
        m.knotenEinfuegen(newKnot3);
        m.knotenEinfuegen(newKnot4);
        m.knotenEinfuegen(newKnot5);
        m.knotenEinfuegen(newKnot6);
        m.knotenEinfuegen(newKnot7);
        m.knotenEinfuegen(newKnot8);
        m.kanteEinfuegen(newKnot, newKnot1, 3);
        m.kanteEinfuegen(newKnot, newKnot2, 4);
        m.kanteEinfuegen(newKnot3, newKnot7, 5);
        m.kanteEinfuegen(newKnot5, newKnot1, 6);
        m.kanteEinfuegen(newKnot1, newKnot7, 6);
        //m.allesAusgeben();
        m.traversieren(newKnot);
        System.out.println("\n");
        System.out.println(m.gewichtAuslesen(newKnot,newKnot1));
        System.out.println(m.gewichtAuslesen(newKnot3,newKnot7));
        System.out.println(m.gewichtAuslesen(newKnot1,newKnot5));
        System.out.println(m.gewichtAuslesen(newKnot7,newKnot1));

         */

        Graph testGraph = new Liste_V2(new Knoten(0));
        for(int i = 1; i <= 6; i++)
        {
            testGraph.knotenEinfuegen(new Knoten(i));
        }

        ArrayList<Knoten> knoten = testGraph.gibAlleKnoten();

        testGraph.kanteEinfuegen(knoten.get(0), knoten.get(1), 2);
        testGraph.kanteEinfuegen(knoten.get(1), knoten.get(2), 6);
        testGraph.kanteEinfuegen(knoten.get(1), knoten.get(3), 4);
        testGraph.kanteEinfuegen(knoten.get(2), knoten.get(3), 2);
        testGraph.kanteEinfuegen(knoten.get(2), knoten.get(4), 1);
        testGraph.kanteEinfuegen(knoten.get(0), knoten.get(2), 15);
        testGraph.kanteEinfuegen(knoten.get(0), knoten.get(5), 15);
        testGraph.kanteEinfuegen(knoten.get(3), knoten.get(4), 4);
        testGraph.kanteEinfuegen(knoten.get(4), knoten.get(5), 2);
        testGraph.kanteEinfuegen(knoten.get(6), knoten.get(5), 1);
        testGraph.kanteEinfuegen(knoten.get(6), knoten.get(2), 15);

        //testGraph.graphMalen();

        DijkstraAlgorithmus routenPlaner = new DijkstraAlgorithmus(testGraph);
    }
}
