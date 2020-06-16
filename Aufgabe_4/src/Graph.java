public interface Graph {

    /**
     * Hinzufügen eines neuen Knoten in die Adiazanzmatrix/liste
     * @param data Daten die in dem Knoten stehen sollen.
     */
    public void knotenEinfuegen (Object data);

    /**
     * Einfügen einer Kante zwischen 2 Graphen
     * @param knoten1 Position des ersten Graphen im Array
     * @param knoten2 Position des zweiten Graphen im Array
     */
    public void kanteEinfuegen (int knoten1, int knoten2) throws IllegalAccessException;

    /**
     * Ausgabe des Inhaltes eines Knotens
     * @param knoten1 Knoten dessen Inhalt ausgegeben werden soll.
     */
    public int traversieren(int knoten1);

    /**
     * Traversiert das gesamte Array, um herauszufinden wieviele Referenzen auf andere Knoten wir haben.
     * @param knoten1 Knoten von dem die Nachbarn gesucht werden und die anzahl der Referenzen ausgegeben werden sollen.
     * @return anzahl der Nachbarn (Zeiger auf andere Knoten)
     */
    public void debugTraversieren (Knoten knoten1, Knoten knoten2);

    /**
     * Unverstndlich was hier passieren soll.
     * @param knoten1
     */
    public void gewichtTraversieren(int knoten1);

    /**
     * Ausgabe der Gewichte/Inhalte aller knoten mit Referenz auf Knoten1
     * @param knoten Knoten von dem die Nachbarn gesucht werden und die Gewichte ausgegeben werden sollen.
     */
    public void knotenAusgabe(int knoten);

    /**
     * Ausgabe der Adiazenzmatrix/liste auf der Konsole
     */
    public void allesAusgeben ();

}
