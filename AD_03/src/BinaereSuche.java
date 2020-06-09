/**
 *
 */
public class BinaereSuche {

    private final int NICHTGEFUNDEN;
    private final int TEILERZWEI;

    public BinaereSuche() {
        NICHTGEFUNDEN = 0;
        TEILERZWEI = 2;
    }

    /**
     * Sucht mithilfe der Binären suche, ob sie das gewünschte Element in der Liste befindet.
     *
     * @param sortedArray sortiertes Array
     * @param zuFindendesElement Zu suchendes Element in der Liste
     * @param ersteStelle Anfangsstelle ab der gesucht werden muss
     * @param letzteStelle Letzte Stelle bis zu der gesucht werden muss
     * @return Das zu suchende Element oder Mull, sollte das Element nicht existieren
     */
    public Integer findElement (Integer sortedArray [], Integer zuFindendesElement, int ersteStelle, int letzteStelle) {
        Integer ergebnis = null;
        int mitte = ((letzteStelle - ersteStelle) / TEILERZWEI) + ersteStelle;
        if (zuFindendesElement > sortedArray[letzteStelle]) {
            ergebnis = null;
        } else if (zuFindendesElement < sortedArray[ersteStelle]) {
            ergebnis = null;
        } else if (ersteStelle == letzteStelle){
            if (sortedArray[mitte].equals(zuFindendesElement)) {
                ergebnis = sortedArray[mitte];
            } else {
                ergebnis = null;
            }
        } else if (sortedArray [mitte].equals(zuFindendesElement)) {
            ergebnis = sortedArray [mitte];
        } else if (zuFindendesElement < sortedArray[mitte]) {
            ergebnis = findElement(sortedArray, zuFindendesElement, ersteStelle, mitte);
        } else if (zuFindendesElement > sortedArray[mitte]) {
            ergebnis = findElement(sortedArray, zuFindendesElement, mitte, letzteStelle);
        }
        return ergebnis;
    }
}
