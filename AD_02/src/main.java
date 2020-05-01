/**
 * Start des Stackbasierten Algorithmus um algebraische Ausfrücke auszuwerten
 *
 * @author Santa Rudevica
 * @author Daniel Dichte
 * @author Pascal Kießler
 *
 * @version 28.04.2020
 * @version 1.0
 */
public class main {

    /**
     * Main Methode
     * @param args Agrumente
     */
    public static void main (String [] args) {
        StackAlgorithmus algebraischerAlgorithmus = new StackAlgorithmus();
        System.out.println(algebraischerAlgorithmus.algebraischeBerechnung("(10-(5-10))"));
    }
}
