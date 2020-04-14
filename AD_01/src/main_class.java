import java.util.Random;

/**
 * Es werden in eine doppeltverkettete Liste oder in eine Arrayliste jeweils Objekte an zufälligen Stellen,
 * Anfang oder Ende 10_000 Elemente hinzugefügt
 * und aus einer Liste mit 10_000 Elementen 1000 Elemente an zufälligen Stellen, Annfang und Ende entfernt.
 * Bei allen Vorgängen wird die Zeit jeweils ermittelt und ausgegeben.
 * Am Ende wird die gesamte und die durchschnittliche Zeit angegeben.
 *
 * @author Santa Rudevica
 * @author Daniel Dichte
 * @author Pascal Kießler
 *
 * @version 1.0
 */
public class main_class {
    private static double zeitEinfuegenAnfangGesamt;
    private static double zeitEinfuegenEndeGesamt;
    private static double zeitEinfuegenZufallGesamt;
    private static double zeitEntfernenAnfangGesamt;
    private static double zeitEntfernenEndeGesamt;
    private static double zeitEntfernenZufallGesamt;
    private static double zeitEinfuegenGesamt;
    private final static int anzahlObjekteEinfügen = 10_000;       // Konstante um Elemente einzufügen
    private final static int anzahlObjekteEntfernen = 1_000;       // Konstante für das Entfernen von Elementen
    private final static int anzahlDurchlaeufe = 10;               // Anzahl der Durchläufe

    /**
     * Main Methode
     * @param args
     */
    public static void main (String [] args) {
        //LineareListe liste = new Verkettung();          // Doppelknoten
        LineareListe liste = new ArrayListe();   // Arrayliste
        initialisiereZeiten ();

        for (int i = 0; i < anzahlDurchlaeufe; i++) {
            long zeitVorherEinfügen = System.currentTimeMillis();
            long zeitEinfuegenAnfang = elementeEinfügenAnfang(liste, anzahlObjekteEinfügen, i + 1);
            long zeitEinfuegenEnde =  elementeEinfügenEnde(liste, anzahlObjekteEinfügen, i + 1);
            long zeitEinfuegenZufall = elementeEinfügenZufall(liste, anzahlObjekteEinfügen, i + 1);
            liste.leere();
            elementeEinfügen(liste, anzahlObjekteEinfügen);
            long zeitEntfernenAnfang = elementeEntfernenAnfang(liste, anzahlObjekteEntfernen, i + 1);
            long zeitEntfernenEnde = elementeEntfernenEnde(liste, anzahlObjekteEntfernen, i + 1);
            long zeitEntfernenZufall = elementeEntfernenZufall(liste, anzahlObjekteEntfernen, i + 1);
            liste.leere();
            long zeitNachher = System.currentTimeMillis();
            ausrechnenZeit(zeitEinfuegenAnfang, zeitEinfuegenEnde, zeitEinfuegenZufall, zeitEntfernenAnfang,
                    zeitEntfernenEnde, zeitEntfernenZufall);

        }
        ausgabeZeit(liste);
    }

    /**
     * Einfügen von 10_000 Elementen am anfang der Liste
     * @param list
     * @param anzahlObjekte
     * @param anzahlDurchlauf
     */
    private static long elementeEinfügenAnfang (LineareListe list, int anzahlObjekte, int anzahlDurchlauf) {
        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.einfuegen(0, zufallszahlElement());
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println(anzahlDurchlauf + ". Durchlauf Einfügen");
        System.out.println("Die Durchlaufszeit für das Einfügen am Anfang bei dem " + anzahlDurchlauf + ". Durchlauf betrug: \t\t\t\t\t\t" + zeit);
        return zeit;
    }

    /**
     * Einfügen von 10_000 Elementen am Ende der Liste
     * @param list
     * @param anzahlObjekte
     * @param anzahlDurchlauf
     */
    private static long elementeEinfügenEnde (LineareListe list, int anzahlObjekte, int anzahlDurchlauf) {
        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.einfuegen(list.anzahlElemente(), zufallszahlElement());
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println("Die Durchlaufszeit für das Einfügen am Ende bei dem " + anzahlDurchlauf + ". Durchlauf betrug: \t\t\t\t\t\t" + zeit);
        return zeit;
    }

    /**
     * Einfügen an einer beliebigen Stelle in der Liste
     * @param list
     * @param anzahlObjekte
     * @param anzahlDurchlauf
     */
    private static long elementeEinfügenZufall(LineareListe list, int anzahlObjekte, int anzahlDurchlauf) {
        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.einfuegen(zufallsPosition(list.anzahlElemente()), zufallszahlElement());
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println("Die Durchlaufszeit für das Einfügen an einer beliebigen Stelle bei dem " + anzahlDurchlauf + ". Durchlauf betrug: \t" + zeit);
        System.out.println();
        return zeit;
    }

    /**
     * Entfernen von 1000 Elementen am Anfang der Liste.
     * @param list
     * @param anzahlObjekte
     * @param anzahlDurchlauf
     */
    private static long elementeEntfernenAnfang (LineareListe list, int anzahlObjekte, int anzahlDurchlauf) {
        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.entfernen(0);
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println(anzahlDurchlauf + ". Durchlauf Entfernen");
        System.out.println("Die Durchlaufszeit für das Entfernen am Anfang bei dem " + anzahlDurchlauf + ". Durchlauf betrug: \t\t\t\t\t" + zeit);
        return zeit;
    }

    /**
     * Entfernen von 1000 Elementen am Ende der Liste.
     * @param list
     * @param anzahlObjekte
     * @param anzahlDurchlauf
     */
    private static long elementeEntfernenEnde (LineareListe list, int anzahlObjekte, int anzahlDurchlauf) {
        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.entfernen(list.anzahlElemente()-1);
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println("Die Durchlaufszeit für das Entfernen am Ende bei dem " + anzahlDurchlauf + ". Durchlauf betrug: \t\t\t\t\t\t" + zeit);
        return zeit;
    }

    /**
     * Entfernen von 1000 Elementen an beliebigen Stellen.
     * @param list
     * @param anzahlObjekte
     * @param anzahlDurchlauf
     */
    private static long elementeEntfernenZufall (LineareListe list, int anzahlObjekte, int anzahlDurchlauf) {

        long zeitVorher = System.currentTimeMillis();
        for (int i = 0; i < anzahlObjekte; i++) {
            list.entfernen(zufallsPosition(list.anzahlElemente()));
        }
        long zeitNachher = System.currentTimeMillis();
        long zeit = zeitNachher - zeitVorher;
        System.out.println("Die Durchlaufszeit für das Entfernen an einer beliebigen Stelle bei dem " + anzahlDurchlauf + ". Durchlauf betrug: \t" + zeit);
        System.out.println();
        System.out.println();
        return zeit;
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
     * Initialisierung aller der Zeitvariablen auf 0.
     */
    private static void initialisiereZeiten() {
        zeitEinfuegenAnfangGesamt = 0;
        zeitEinfuegenEndeGesamt = 0;
        zeitEinfuegenZufallGesamt = 0;
        zeitEntfernenAnfangGesamt = 0;
        zeitEntfernenEndeGesamt = 0;
        zeitEntfernenZufallGesamt = 0;
        zeitEinfuegenGesamt = 0;
    }

    /**
     * Ausgabe der jeweiligen durchschnittszeiten für einfügen und entfernen.
     * @param liste
     */
    private static void ausgabeZeit(LineareListe liste) {
        System.out.printf("Die im durchschnitt benötigte Zeit für das Einfügen an erster Stelle der %s benötigt \t\t\t\t %.2f  \n", welcheListe(liste), zeitEinfuegenAnfangGesamt / 10);
        System.out.printf("Die im durchschnitt benötigte Zeit für das Einfügen an letzter Stelle der %s benötigt \t\t\t\t %.2f \n", welcheListe(liste), zeitEinfuegenEndeGesamt / 10);
        System.out.printf("Die im durchschnitt benötigte Zeit für das Einfügen an einer Zufälligen Stelle der %s benötigt \t %.2f \n", welcheListe(liste), zeitEinfuegenZufallGesamt / 10);
        System.out.printf("Die im durchschnitt benötigte Zeit für das Einfügen an erster Stelle der %s benötigt \t\t\t\t %.2f \n", welcheListe(liste), zeitEntfernenAnfangGesamt / 10);
        System.out.printf("Die im durchschnitt benötigte Zeit für das Einfügen an letzter Stelle der %s benötigt \t\t\t\t %.2f \n", welcheListe(liste), zeitEntfernenEndeGesamt / 10);
        System.out.printf("Die im durchschnitt benötigte Zeit für das Einfügen an einer Zufälligen Stelle der %s benötigt \t %.2f \n", welcheListe(liste), zeitEntfernenZufallGesamt / 10);
    }

    /**
     * Ausrechnen der Gesamtzeiten für einfügen und entfernen.
     * @param einfA Einfügezeit am Anfang der Liste.
     * @param einfE Einfügezeit am Ende der Liste.
     * @param einfZ Einfügezeit an einer zufälligen Stelle der Liste.
     * @param entfA Entfernungszeit am Anfang der Liste.
     * @param EntfE Entfernungszeit am Ende der Liste.
     * @param entfZ Entfernungszeit an einer zufälligen Stelle der Liste.
     */
    private static void ausrechnenZeit (long einfA, long einfE, long einfZ, long entfA, long EntfE, long entfZ) {
        zeitEinfuegenAnfangGesamt = zeitEinfuegenAnfangGesamt + einfA;
        zeitEinfuegenEndeGesamt = zeitEinfuegenEndeGesamt + einfE;
        zeitEinfuegenZufallGesamt = zeitEinfuegenZufallGesamt + einfZ;
        zeitEntfernenAnfangGesamt = zeitEntfernenAnfangGesamt + entfA;
        zeitEntfernenEndeGesamt = zeitEntfernenEndeGesamt + EntfE;
        zeitEntfernenZufallGesamt = zeitEntfernenZufallGesamt + entfZ;
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
