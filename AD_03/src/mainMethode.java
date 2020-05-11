/**
 *
 */
public class mainMethode {
    final static int ELEMENTE = 5000;
    final static int ZERO = 0;


    public static void main (String [] args){
        PivotStrategie test = new ZufallPivot();
        Integer array [] = new Integer[ELEMENTE];
        for (int i = ZERO; i <= ELEMENTE - 1; i++) {
            array[i] = i + 100;
        }
        BinaereSuche suche = new BinaereSuche();
        Integer result = suche.findElement(array, 46465, ZERO, ELEMENTE - 1);
        if (result != null){
            System.out.println("Das gesuchte Element wurde gefunden.");
        } else {
            System.out.println("Das gesuchte Element wurde in der Liste nicht gefunden.");
        }

    }









}
