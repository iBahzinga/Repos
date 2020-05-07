import java.util.Random;

/**
 *
 */
public class mainMethode {
    final static int elemente = 50;
    final static int ZERO = 0;


    public static void main (String [] args){
        PivotStrategie test = new RandomData();
        Integer array [] = new Integer[elemente];
        for (int i = elemente, x = 0; i > ZERO; i--, x++) {
            Integer j = zufall();
            array[x] = j;
        }
        test.sortiereQS(array, 0, 49);
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.println(array[i]);
        }
    }



    /**
     * Hilfsmethode um einen zufällig gewähltes Pivotelement zu bestimmen.
     * @return Stelle in dem Array
     */
    private static int zufall () {
        Random zufaelligesElement = new Random();
        int pivotelement = zufaelligesElement.nextInt(1000);
        return pivotelement;
    }






}
