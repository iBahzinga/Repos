public class hanoi_main {

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

        public static void main(String args[])
        {
            int count = 0;
            int n = 3;              //Anzahl von verwendeten Scheiben auf unseren Spielfeld

            count = hanoi(n, 'A', 'C', 'B', count);
            System.out.println("Benötigte schritte zum Ziel: " + count);
        }
    }