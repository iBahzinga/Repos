import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class DijkstraTest {

    /**
     * Test Dijksta Algorithmus analog zur Vorlesungsskript Seite 109 mit einer Adjazenzliste
     */
    @Test
    public void testGraphSkriptListe()
    {
        Graph testGraphSkriptListe = new Adjazenzliste(new Knoten_Graph(0));
        for(int i = 1; i <= 6; i++)
        {
            testGraphSkriptListe.knotenEinfuegen(new Knoten_Graph(i));
        }
        //A = 0; B = 1; C = 2; D = 3; E = 4; F = 5; G = 6
        ArrayList<Knoten_Graph> knoten = testGraphSkriptListe.gibAlleKnoten();

        testGraphSkriptListe.kanteEinfuegen(knoten.get(0), knoten.get(1), 4);
        testGraphSkriptListe.kanteEinfuegen(knoten.get(0), knoten.get(6), 5);
        testGraphSkriptListe.kanteEinfuegen(knoten.get(0), knoten.get(5), 10);
        testGraphSkriptListe.kanteEinfuegen(knoten.get(1), knoten.get(2), 7);
        testGraphSkriptListe.kanteEinfuegen(knoten.get(1), knoten.get(6), 2);
        testGraphSkriptListe.kanteEinfuegen(knoten.get(2), knoten.get(3), 12);
        testGraphSkriptListe.kanteEinfuegen(knoten.get(2), knoten.get(6), 1);
        testGraphSkriptListe.kanteEinfuegen(knoten.get(3), knoten.get(4), 4);
        testGraphSkriptListe.kanteEinfuegen(knoten.get(4), knoten.get(5), 3);
        testGraphSkriptListe.kanteEinfuegen(knoten.get(4), knoten.get(6), 8);
        testGraphSkriptListe.kanteEinfuegen(knoten.get(5), knoten.get(6), 4);
        //testGraph.graphMalen();

        new DijkstraAlgorithmus(testGraphSkriptListe);
    }
    /**
     * Test Dijksta Algorithmus analog zur Vorlesungsskript Seite 109 mit einer Adjazenzmatrix
     */
    @Test
    public void testGraphSkriptMatrix()
    {
        Graph testGraphSkriptMatrix = new Adjazenzmatrix(new Knoten_Graph(0));
        for(int i = 1; i <= 6; i++)
        {
            testGraphSkriptMatrix.knotenEinfuegen(new Knoten_Graph(i));
        }
        //A = 0; B = 1; C = 2; D = 3; E = 4; F = 5; G = 6
        Knoten_Graph [] knoten = ((Adjazenzmatrix) testGraphSkriptMatrix).getKnotenGraphArray();
        testGraphSkriptMatrix.kanteEinfuegen(knoten[0], knoten[1], 4);
        testGraphSkriptMatrix.kanteEinfuegen(knoten[0], knoten[6], 5);
        testGraphSkriptMatrix.kanteEinfuegen(knoten[0], knoten[5], 10);
        testGraphSkriptMatrix.kanteEinfuegen(knoten[1], knoten[2], 7);
        testGraphSkriptMatrix.kanteEinfuegen(knoten[1], knoten[6], 2);
        testGraphSkriptMatrix.kanteEinfuegen(knoten[2], knoten[3], 12);
        testGraphSkriptMatrix.kanteEinfuegen(knoten[2], knoten[6], 1);
        testGraphSkriptMatrix.kanteEinfuegen(knoten[3], knoten[4], 4);
        testGraphSkriptMatrix.kanteEinfuegen(knoten[4], knoten[5], 3);
        testGraphSkriptMatrix.kanteEinfuegen(knoten[4], knoten[6], 8);
        testGraphSkriptMatrix.kanteEinfuegen(knoten[5], knoten[6], 4);
        //testGraph.graphMalen();

        new DijkstraAlgorithmus(testGraphSkriptMatrix);
    }

}
