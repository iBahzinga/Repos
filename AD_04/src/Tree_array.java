public class Tree_array<T> implements Search_ {

    private final int ROOT;
    private final int ARRAYSIZE;
    private T[] treeArray;


    public Tree_array(Object data) {
        ARRAYSIZE = 1000;
        ROOT = 1;
        treeArray = (T[]) new Object[ARRAYSIZE];
        treeArray[ROOT] = (T) data;
    }

    @Override
    public void addKnot(Object data) {
        int index = ROOT;
        if (treeArray[index] == null){
            treeArray[index] = (T) data;
        }

        if (treeArray[index].compareTo((T) data) < 0){
            //treeArray[2] = data;
            index = 2;
        } else {
            index = 3;
        }
        do {
            if (treeArray[index] == null) {
                treeArray[index] = (T) data;
                break;
            }
            if (treeArray[index].compareTo((T) data) < 0){
                //treeArray[2] = data;
                index = index * 2;
            } else {
                index = index * 2 + 1;
            }
        } while (true);





    }

    @Override
    public void output(int method) {

    }
}
