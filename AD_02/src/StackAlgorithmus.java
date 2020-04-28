/**
 * Ein Algorithmus, der mit Hilfe eines Stacks einen algebraischen Ausdruck auswertet und ausrechnet.
 *
 * @author Santa Rudevica
 * @author Daniel Dichte
 * @author Pascal Kießler
 *
 * @version 28.04.2020
 * @version 1.0
 *
 *
 */
public class StackAlgorithmus {

    /**
     * Konstruktor des Algorithmus
     */
    private Stack<String> _stack = new Stack();
    public StackAlgorithmus () {
    }

    /**
     * Es wird eine algebraische berechnung mit dem als Parameter übergebenen String durchgefuehrt.
     * @param ausdruck Algebraischer Term der ausgerechnet werden soll.
     * @return Ergebnis des übergebenen algebraischen Terms.
     */
    protected int algebraischeBerechnung(String ausdruck) {
        pruefeNull (ausdruck);
        pruefeAnzahlKlammern (ausdruck);
        int result = 0;
        for (int i = 0; i <= ausdruck.length() - 1; i++) {
            String element = "";
            int counter = 0;
            if (istZahl(ausdruck, i)) {
                do {
                    element = element + ausdruck.charAt(i + counter);
                    counter++;
                } while (istZahl(ausdruck, i + counter));
                i = i + counter - 1;
                _stack.push(element);
                element = "";
            } else if (ausdruck.charAt(i) == ')') {
                result = berechnung();
                _stack.push(String.valueOf(result));
            } else {
                _stack.push(ausdruck.charAt(i) + "");
        }
    }
    return result;
}

    /**
     * Berechnung der Operanden des algebraischen Ausdruckes.
     * @return Ergebnis der berechnung der Operanden
     */
    private int berechnung (){
        int operand1 = Integer.valueOf(_stack.pop());
        Character operator = _stack.pop().charAt(0);
        int operand2 = Integer.valueOf(_stack.pop());
        _stack.pop();
        int result = 0;
        switch (operator) {
            case '+': result = operand1 + operand2;
                break;
            case '-': result = operand2 - operand1;
                break;
            case '*': result = operand1 * operand2;
                break;
            case '/': result = operand2 / operand1;
                break;
        }
        return result;
    }

    /**
     * ÜÜberprüfen der aktuellen Stelle im algebraischen Ausdruck
     * @param ausdruck Algebraischer Term der ausgerechnet werden soll.
     * @param nummer Stelle des algebraischen Terms
     * @return True, wenn die gefundene Stelle eine Zahl zwischen 0 und 9 darstellt.
     */
    private boolean istZahl (String ausdruck, int nummer) {
        return ausdruck.charAt(nummer) >= '0' && ausdruck.charAt(nummer) <= '9';
    }

    /**
     * Pruefe algebraischen Ausdruck auf null.
     * @param ausdruck Algebraischer Term der ausgerechnet werden soll.
     * @throws IllegalArgumentException sollte der Ausdruck null entsprechen
     */
    private void pruefeNull (String ausdruck) {
        if (ausdruck == null){
            throw new IllegalArgumentException("Der eingegebene Ausdruck darf nicht null sein!");
        }
    }

    /**
     * Pruefe ob genausoviele öffnende Klammern, wie schliessende Klammern existieren.
     * @param ausdruck Algebraischer Term der ausgerechnet werden soll.
     */
    void pruefeAnzahlKlammern (String ausdruck) {
        int anzahlOeffeneKlammern = 0;
        int anzahlSchliessendeKlammern = 0;
        for (int i = 0; i <= ausdruck.length() - 1; i++) {
            if (ausdruck.charAt(i) == '(') {
                anzahlOeffeneKlammern++;
            } else if (ausdruck.charAt(i) == ')') {
                anzahlSchliessendeKlammern++;
            }
        }
        if (anzahlOeffeneKlammern != anzahlSchliessendeKlammern){
            throw new IllegalArgumentException("Der eingegebene algebraische Ausdruck ist fehlerhaft. \n" +
                    "Klammersetzung überprüfen.");
        }
    }
}
