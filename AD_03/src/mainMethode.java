import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
public class mainMethode {
    final static int ELEMENTE = 50000;
    final static int ZERO = 0;


    public static void main (String [] args) {
        PivotStrategie zufaelligesPivotelement = new ZufallPivot();
        PivotStrategie groessterKey = new GroessterKey();
        PivotStrategie kleinsterKey = new KleinsterKey();
        TimSort timSort = new TimSort();
        Integer sortierenQS[] = new Integer[ELEMENTE];
        Integer sortierenTS[] = new Integer[ELEMENTE];
        for (int i = ZERO; i <= sortierenQS.length - 1; i++) {
            Integer einzufuegendeZahl = zufall();
            sortierenQS[i] = einzufuegendeZahl;
            sortierenTS[i] = einzufuegendeZahl;  
        }
        long zeitVorher = System.currentTimeMillis();
        zufaelligesPivotelement.sortiereQS(sortierenQS, ZERO, ELEMENTE - 1);
        long zeitNachher = System.currentTimeMillis();
        double zeitGesamt = (double) (zeitNachher - zeitVorher) / 1000;
        System.out.printf("Die Zeit für %d Element hat insgesamt %.3f Sekunden betragen. \n", ELEMENTE, zeitGesamt);


        zeitVorher = System.currentTimeMillis();
        timSort.timSort(sortierenTS, ELEMENTE);
        zeitNachher = System.currentTimeMillis();
        zeitGesamt = (double) (zeitNachher - zeitVorher) / 1000;
        System.out.printf("Die Zeit für %d Element hat insgesamt %.3f Sekunden betragen.", ELEMENTE, zeitGesamt);
    }
    private static int zufall () {
        Random zufaelligesElement = new Random();
        int pivotelement = zufaelligesElement.nextInt(1000000);
        return pivotelement;
    }
}

