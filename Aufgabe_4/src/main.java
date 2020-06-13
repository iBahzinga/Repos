public class main {

    private static final int TESTWERTE = 100;


    public static void main (String [] args){

        Knot root = new Knot (50, null);

        Tree_v2 tree = new Tree_v2(root);
        int b = 0;
        int c = 0;
        for (int i = 0, x = 100, y = 0, z = 49, a = 51; i < TESTWERTE; i++) {


            Integer validateAdd = null;

            if (i % 2 == 0) {
                if (b % 2 == 0) {
                    validateAdd = x;
                    x++;
                } else {
                    validateAdd = a;
                    a++;
                }
                b++;
            } else {
                if (c % 2 == 0) {
                    validateAdd = y;
                    y++;
                } else {
                    validateAdd = z;
                    z--;
                }
                c++;
            }
            tree.addKnot(validateAdd);
        }
    }

}
