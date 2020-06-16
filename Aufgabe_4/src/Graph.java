public interface Graph {

    /**
     *
     * @param knoten
     */
    public void knotenEinfuegen(Knoten knoten);

    /**
     *
     * @param quelle
     * @param ziel
     * @param gewichtung
     */
    public void kanteEinfuegen(Knoten quelle, Knoten ziel, int gewichtung);

    /**
     *
     * @param startKnoten
     * @return
     */
    public int traversieren(Knoten startKnoten);

    /**
     *
     * @return
     */
    public int gibAnzahlKanten();

    /**
     *
     * @return
     */
    public int gibAnzahlKnoten();

    /**
     *
     * @param quelle
     * @param ziel
     */
    public void gewichtTraversieren(Knoten quelle, Knoten ziel);

    /**
     *
     * @return
     */
    public Knoten gibStartKnoten();


    /**
     *
     * @return
     */
    public Knoten gibEndKnoten();


    /**
     * Ausgabe der Adiazenzmatrix/liste auf der Konsole
     */
    public void allesAusgeben ();

}
