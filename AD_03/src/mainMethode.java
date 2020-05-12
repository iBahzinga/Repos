import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 *
 */
public class mainMethode {
    final static int ELEMENTE = 1000000;
    final static int ZERO = 0;


    public static void main (String [] args){
        PivotStrategie zufaelligesPivotelement = new ZufallPivot();
        PivotStrategie groessterKey = new GroessterKey();
        PivotStrategie kleinsterKey = new KleinsterKey();
        Integer zufallsElemente [] = new Integer[ELEMENTE];
        for (int i = ZERO; i <= zufallsElemente.length - 1; i++) {
            zufallsElemente[i] = zufall();
        }
        long zeitVorher = System.currentTimeMillis();
        zufaelligesPivotelement.sortiereQS(zufallsElemente, ZERO, ELEMENTE - 1);
        long zeitNachher = System.currentTimeMillis();
        double zeitGesamt = (double)(zeitNachher - zeitVorher) / 1000;
        System.out.printf("Die Zeit für %d Element hat insgesamt %.3f Millisekunden betragen.", ELEMENTE, zeitGesamt);
    }

    private static int zufall () {
        Random zufaelligesElement = new Random();
        int pivotelement = zufaelligesElement.nextInt(1000000);
        return pivotelement;
    }
}

