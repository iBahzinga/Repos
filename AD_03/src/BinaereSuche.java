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
