public interface Graph {

    /**
     *
     * @param data
     * @return
     */
    public void knotenEinfuegen (Object data);

    /**
     *
     * @param knoten1
     * @param knoten2
     * @return
     */
    public void kanteEinfuegen (int knoten1, int knoten2);

    /**
     *
     * @param knoten1
     * @return
     */
    public int traversieren(int knoten1);

    /**
     *
     * @param knoten1
     * @param knoten2
     */
    public void debugTraversieren (KnotenGraph knoten1, KnotenGraph knoten2);

    /**
     *
     * @param knoten
     * @return
     */
    public KnotenGraph gibKnoten (int knoten);

    /**
     *
     * @param knoten1
     * @param knoten2
     */
    public void gewichtTraversieren(KnotenGraph knoten1, KnotenGraph knoten2);

    /**
     *
     */
    public void knotenAusgabe(int knoten);


    public void allesAusgeben ();

}
