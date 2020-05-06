/**
 *
 */
public class mainMethode {
    final static int elemente = 50;


    public static void main (String [] args){
        PivotStrategie test = new RandomData();
        Integer array [] = new Integer[elemente];
        for (int i = 0; i < elemente; i++) {
            Integer j = i;
            array[i] = j;
        }
        test.sortiereQS(array, 0, 49);
    }






}
