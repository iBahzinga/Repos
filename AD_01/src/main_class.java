import java.util.Random;

/**
 *Mainklasse zum starten der Testdurchläufe und festhalten der Zeiten
 *
 * @author Santa Rudevica
 * @author Daniel Dichte
 * @author Pascal Kießler
 */
public class main_class {


    /**
     * Main Methode
     * @param args
     */
    public static void main (String [] args) {
        LineareListe liste = new Verkettung();          // Doppelknoten
        //LineareListe liste = new ArrayListe(50000);   // Arrayliste
        final int anzahlObjekteEinfügen = 10_000;       // Konstante um Elemente einzufügen
        final int anzahlObjekteEntfernen = 1_000;       // Konstante für das Entfernen von Elementen
        final int anzahlDurchlaeufe = 10;               // Anzahl der Durchläufe
        long zeitGesamt = 0;                            // Festhalten der Gesamtzeit
        for (int i = 0; i < anzahlDurchlaeufe; i++) {
            long zeitVorher = System.currentTimeMillis();
            elementeEinfügenAnfang(liste, anzahlObjekteEinfügen, i + 1);
            elementeEinfügenEnde(liste, anzahlObjekteEinfügen, i + 1);
            elementeEinfügenZufall(liste, anzahlObjekteEinfügen, i + 1);
            liste.leere();
            elementeEinfügen(liste, anzahlObjekteEinfügen);
            elementeEntfernenAnfang(liste, anzahlObjekteEntfernen, i + 1);
            elementeEntfernenEnde(liste, anzahlObjekteEntfernen, i + 1);
            elementeEntfernenZufall(liste, anzahlObjekteEntfernen, i + 1);
            liste.leere();
            long zeitNachher = System.currentTimeMillis();
            zeitGesamt = zeitGesamt + zeitNachher - zeitVorher;
        }
        System.out.println("Insgesamt- und Durchschnittszeiten");
        System.out.println("Die insgesamt benoetigte Zeit für die " + welcheListe(liste) + " beträgt: \t " + zeitGesamt);
        System.out.println("Die durchschnittliche Zeit für die " + welcheListe(liste) + " beträgt: \t " + (float) zeitGesamt / 10);
    }

    /**
     * Einfügen von 10_000 Elementen am anfang der Liste
     * @param list
     * @param anzahlObjekte
     * @param anzahlDurchlauf
     */
    private static void elementeEinfügenAnfang (LineareListe list, int anzahlObjekte, int anzahlDurchlauf) {
        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.einfuegen(0, zufallszahlElement());
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println(anzahlDurchlauf + ". Durchlauf Einfügen");
        System.out.println("Die Durchlaufszeit für das Einfügen am Anfang bei dem " + anzahlDurchlauf + ". Durchlauf betrug: \t\t\t\t\t\t" + zeit);
    }

    /**
     * Einfügen von 10_000 Elementen am Ende der Liste
     * @param list
     * @param anzahlObjekte
     * @param anzahlDurchlauf
     */
    private static void elementeEinfügenEnde (LineareListe list, int anzahlObjekte, int anzahlDurchlauf) {
        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.einfuegen(list.anzahlElemente(), zufallszahlElement());
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println("Die Durchlaufszeit für das Einfügen am Ende bei dem " + anzahlDurchlauf + ". Durchlauf betrug: \t\t\t\t\t\t" + zeit);
    }

    /**
     * Einfügen an einer beliebigen Stelle in der Liste
     * @param list
     * @param anzahlObjekte
     * @param anzahlDurchlauf
     */
    private static void elementeEinfügenZufall(LineareListe list, int anzahlObjekte, int anzahlDurchlauf) {
        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.einfuegen(zufallsPosition(list.anzahlElemente()), zufallszahlElement());
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println("Die Durchlaufszeit für das Einfügen an einer beliebigen Stelle bei dem " + anzahlDurchlauf + ". Durchlauf betrug: \t" + zeit);
        System.out.println();
    }

    /**
     * Entfernen von 1000 Elementen am Anfang der Liste.
     * @param list
     * @param anzahlObjekte
     * @param anzahlDurchlauf
     */
    private static void elementeEntfernenAnfang (LineareListe list, int anzahlObjekte, int anzahlDurchlauf) {
        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.entfernen(0);
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println(anzahlDurchlauf + ". Durchlauf Entfernen");
        System.out.println("Die Durchlaufszeit für das Entfernen am Anfang bei dem " + anzahlDurchlauf + ". Durchlauf betrug: \t\t\t\t\t" + zeit);
    }

    /**
     * Entfernen von 1000 Elementen am Ende der Liste.
     * @param list
     * @param anzahlObjekte
     * @param anzahlDurchlauf
     */
    private static void elementeEntfernenEnde (LineareListe list, int anzahlObjekte, int anzahlDurchlauf) {
        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.entfernen(list.anzahlElemente()-1);
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println("Die Durchlaufszeit für das Entfernen am Ende bei dem " + anzahlDurchlauf + ". Durchlauf betrug: \t\t\t\t\t\t" + zeit);
    }

    /**
     * Entfernen von 1000 Elementen an beliebigen Stellen.
     * @param list
     * @param anzahlObjekte
     * @param anzahlDurchlauf
     */
    private static void elementeEntfernenZufall (LineareListe list, int anzahlObjekte, int anzahlDurchlauf) {

        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.entfernen(zufallsPosition(list.anzahlElemente()));
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println("Die Durchlaufszeit für das Entfernen an einer beliebigen Stelle bei dem " + anzahlDurchlauf + ". Durchlauf betrug: \t" + zeit);
        System.out.println();
        System.out.println();
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
     * @param bisStelle
     * @return
     */
    private static Integer zufallsPosition(int bisStelle) {
        Random intWert = new Random();
        int rueckgabeInteger = intWert.nextInt(bisStelle);
        return rueckgabeInteger;
    }

    /**
     * Hinzufügen von 10_000 Elementen, ohne die Zeit festzuhalten.
     * Wird ausgeführt bevor die Elemente gelöscht werden sollen.
     * @param list
     * @param anzahlObjekte
     */
    private static void elementeEinfügen (LineareListe list, int anzahlObjekte) {
        for (int i = 0; i < anzahlObjekte; i++) {
            list.einfuegen(0, zufallszahlElement());
        }
    }

    /**
     * Anfrage zu welchem Typ die Liste gehört.
     * Relevant für die Ausgabe der Insgesamt- und der Durchschnittszeit.
     * @param list
     * @return
     */
    private static String welcheListe (LineareListe list){
        String istListe = "";
        if (list instanceof Verkettung) {
            istListe = "Doppeltverkettete Liste";
        } else {
            istListe = "Arrayliste";
        }
        return istListe;
    }
}
