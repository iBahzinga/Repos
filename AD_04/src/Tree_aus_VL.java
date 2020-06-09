/*
public class Tree_aus_VL<T> implements Search_ {
    Knot root;
    private final int ZERO;

    public Tree_aus_VL() {
        ZERO = 0;
    }


    @Override
    public Knot addKnot(Object data) {              //  WARUM IST DAS HIER IMMER NOCH OBJEKT UND WIRD FALSCH WENN ICH DAS ZU T ÄNDERE

        if (this.data.equals(data)){
            return this;
        } else {
            if (daten.compareTo(this.data) < ZERO){
                if (left == null) {
                    left = new Knot<T>(data);
                    return left;
                } else {
                    return left.addKnot(data);
                }
            } else {
                if (right == null){
                    right = new Knot <T>(data);
                    return right;
                } else {
                    return right.addKnot(data);
                }
            }
        }

        return null;
    }

    @Override
    public void printKnot() {

    }

    boolean find (T data) {
        if (this.data.equals(data)){
            return true;
        } else {
            if (data.comnpareTo(this.data) < ZERO){
                if (left == null) {
                    return false;
                }
                else {
                    return left.find(data);
                }
            } else if (right == null) {
                return false;
            } else {
                return right.find(data);
            }
        }
    }
}
*/