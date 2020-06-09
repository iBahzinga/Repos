import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
public class mainMethode {
    final static int ELEMENTE = 3000;
    final static int ZERO = 0;


    public static void main (String [] args) {
        QuickSort quickSort = new QuickSort();
        PivotStrategie zufaelligesPivotelement = new ZufallPivot();
        PivotStrategie groessterKey = new GroessterKey();
        PivotStrategie kleinsterKey = new KleinsterKey();

        Integer sortierenQS[] = new Integer[ELEMENTE];

        for (int i = ZERO; i <= sortierenQS.length - 1; i++) {
            Integer einzufuegendeZahl = zufall();
            sortierenQS[i] = einzufuegendeZahl;
        }

        long zeitVorherZufall = System.currentTimeMillis();
        quickSort.sortiereQS(sortierenQS, ZERO, ELEMENTE - 1, zufaelligesPivotelement);
        long zeitNachherZufall = System.currentTimeMillis();
        double zeitGesamtZufall = (double) (zeitNachherZufall - zeitVorherZufall);
        System.out.printf("Die Zeit für %d Elemente mit der Zufallsmethode hat insgesamt %.3f Milisekunden betragen. \n", ELEMENTE, zeitGesamtZufall);

        long zeitVorherGross = System.currentTimeMillis();
        quickSort.sortiereQS(sortierenQS, ZERO, ELEMENTE - 1, groessterKey);
        long zeitNachherGross = System.currentTimeMillis();
        double zeitGesamtGross = (double) (zeitNachherGross - zeitVorherGross);
        System.out.printf("Die Zeit für %d Elemente mit GroessterKey hat insgesamt %.3f Milisekunden betragen. \n", ELEMENTE, zeitGesamtGross);

        long zeitVorherKlein = System.currentTimeMillis();
        quickSort.sortiereQS(sortierenQS, ZERO, ELEMENTE - 1, kleinsterKey);
        long zeitNachherKlein = System.currentTimeMillis();
        double zeitGesamtKlein = (double) (zeitNachherKlein - zeitVorherKlein);
        System.out.printf("Die Zeit für %d Elemente mit KleinsterKey hat insgesamt %.3f Milisekunden betragen. \n", ELEMENTE, zeitGesamtKlein);
    }
        private static int zufall() {
            Random zufaelligesElement = new Random();
            int pivotelement = zufaelligesElement.nextInt(1000000);
            return pivotelement;
        }

 /*     TimSort timSort = new TimSort();
        Integer sortierenQS[] = new Integer[ELEMENTE];
        Integer sortierenTS[] = new Integer[ELEMENTE];
        for (int i = ZERO; i <= sortierenQS.length - 1; i++) {
            Integer einzufuegendeZahl = zufall();
            sortierenQS[i] = einzufuegendeZahl;
            sortierenTS[i] = einzufuegendeZahl;  
        }
        long zeitVorher = System.currentTimeMillis();
        quickSort.sortiereQS(sortierenQS, ZERO, ELEMENTE - 1, zufaelligesPivotelement);
        long zeitNachher = System.currentTimeMillis();
        double zeitGesamt = (double) (zeitNachher - zeitVorher);
        System.out.printf("Die Zeit für %d Elemente hat insgesamt %.3f Milisekunden betragen. \n", ELEMENTE, zeitGesamt);


        zeitVorher = System.currentTimeMillis();
        timSort.timSort(sortierenTS, ELEMENTE);
        zeitNachher = System.currentTimeMillis();
        zeitGesamt = (double) (zeitNachher - zeitVorher);
        System.out.printf("Die Zeit für %d Elemente hat insgesamt %.3f Milisekunden betragen.", ELEMENTE, zeitGesamt);
    }
    private static int zufall () {
        Random zufaelligesElement = new Random();
        int pivotelement = zufaelligesElement.nextInt(1000000);
        return pivotelement;
    }*/
}

