public class main {

    private static final int TESTWERTE = 100;


    public static void main (String [] args){

        Knot root = new Knot (50, null);

        Tree_v2 tree = new Tree_v2(root);

        for (int i = 0, x = 100, y = 0; i < TESTWERTE; i++) {
            Integer testwerte;

            if (i % 2 == 0) {
                testwerte = x;
                x--;
            } else {
                testwerte = y;
                y++;
            }
            tree.addKnot(testwerte);
        }
    }

}
