import java.util.Random;

public class main_class {



    public static void main (String [] args) {
        LineareListe liste = new Verkettung();
        //LineareListe liste = new ArrayListe(50000);
        final int anzahlObjekteEinfügen = 10000;
        final int anzahlObjekteEntfernen = 1000;
        final int anzahlDurchlaeufe = 10;
        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlDurchlaeufe; i++) {
            elementeEinfügenAnfang(liste, anzahlObjekteEinfügen);
            elementeEinfügenEnde(liste, anzahlObjekteEinfügen);
            elementeEinfügenZufall(liste, anzahlObjekteEinfügen);
            liste.leere();
            elementeEinfügen(liste, anzahlObjekteEinfügen);
            elementeEntfernenAnfang(liste, anzahlObjekteEntfernen);
            elementeEntfernenEnde(liste, anzahlObjekteEntfernen);
            elementeEntfernenZufall(liste, anzahlObjekteEntfernen);
            liste.leere();
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println("Die insgesamt benoetigte Zeit beträgt: " + zeit);
    }



    /**
     * Hilfsmethode um einen zufällig generierten Integer Wert zu erzeugen
     * @return
     */
    private static Integer zufallszahlElement() {
        int bisStelle = 2147483647;
        Random intWert = new Random();
        int rueckgabeInteger = intWert.nextInt(bisStelle);
        return rueckgabeInteger;
    }

    /**
     * Hilfsmethode um einen zufällig generierten Integer Wert zu erzeugen
     * @return
     */
    private static Integer zufallsPosition(int bisStelle) {
        Random intWert = new Random();
        int rueckgabeInteger = intWert.nextInt(bisStelle);
        return rueckgabeInteger;
    }

    /**
     * --------------------------------Einfügen--------------------------------------------------
     */

    /**
     * Einfügen
     * @param list
     * @param anzahlObjekte
     */
    private static void elementeEinfügenAnfang (LineareListe list, int anzahlObjekte) {

        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.einfuegen(0, zufallszahlElement());
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println("Zeit Anfang insgesamt: " + zeit);
    }

    private static void elementeEinfügenEnde (LineareListe list, int anzahlObjekte) {
        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.einfuegen(list.anzahlElemente(), zufallszahlElement());
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println("Zeit Ende insgesamt: " + zeit);
    }

    private static void elementeEinfügenZufall(LineareListe list, int anzahlObjekte) {

        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.einfuegen(zufallsPosition(list.anzahlElemente()), zufallszahlElement());
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println("Zeit Zufall insgesamt: " + zeit);
    }

    private static void elementeEinfügen (LineareListe list, int anzahlObjekte) {
        for (int i = 0; i < anzahlObjekte; i++) {
            list.einfuegen(0, zufallszahlElement());
        }
    }

    /**
     * ----------------------------------------------Entfernen--------------------------------------------------
     */

    private static void elementeEntfernenAnfang (LineareListe list, int anzahlObjekte) {

        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.entfernen(0);
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println("Zeit entfernen Anfang: " + zeit);
    }

    private static void elementeEntfernenEnde (LineareListe list, int anzahlObjekte) {

        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.entfernen(list.anzahlElemente()-1);
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println("Zeit entfernen Ende: " + zeit);
    }

    private static void elementeEntfernenZufall (LineareListe list, int anzahlObjekte) {

        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.entfernen(zufallsPosition(list.anzahlElemente()));
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println("Zeit entfernen Zufall: " + zeit);
    }
}
