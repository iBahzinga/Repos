/**
 * Rekursiver Ansatz um die Türme von Hanoi zu lösen.
 *
 * @author Santa Rudevica
 * @author Daniel Dichte
 * @author Pascal Kießler
 *
 * @version 30.04.2020
 * @version 1.0
 */
public class hanoi_main {

    /**
     * Die Türme von Hanoi im rekursiven Ansatz.
     * @param n Anzahl der Scheiben
     * @param start Der erste Turm (A)
     * @param ziel Der dritte Turm (C)
     * @param ablage Der zweite Turm (B)
     * @param count Der zähler der Schritte
     * @return Zurückgabe des zählers
     */
        static int hanoi(int n, char start, char ziel, char ablage, int count)
        {
            if (n == 1) {
                count++;
                System.out.println("Schritt: " + count + " Scheibe: 1" + " von Turm: " + start + " zu Turm: " + ziel);
                return count;
            }
            else {
                count = hanoi(n - 1, start, ablage, ziel , count);
                count++;
                System.out.println("Schritt: " + count + " Scheibe: " + n + " von Turm: " + start + " zu Turm: " + ziel);
                count =  hanoi(n - 1, ablage, ziel, start, count);
                return count;
            }
        }

    /**
     * Main Methode um die Türmen von Hanoi zu starten.
     * @param args Argumente
     */
        public static void main(String args[])
        {
            int count = 0;
            int n = 20;              //Anzahl von verwendeten Scheiben auf unseren Spielfeld

            count = hanoi(n, 'A', 'C', 'B', count);
            System.out.println("Benötigte schritte zum Ziel: " + count);
        }
    }
