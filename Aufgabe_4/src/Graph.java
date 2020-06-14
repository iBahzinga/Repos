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
    public void kanteEinfuegen (KnotenGraph knoten1, KnotenGraph knoten2);

    /**
     *
     * @param knoten1
     * @param knoten2
     * @return
     */
    public boolean traversieren(KnotenGraph knoten1, KnotenGraph knoten2);

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
    public KnotenGraph gibKnoten (KnotenGraph knoten);

    /**
     *
     * @param knoten1
     * @param knoten2
     */
    public void gewichtTraversieren(KnotenGraph knoten1, KnotenGraph knoten2);

    /**
     *
     */
    public void graphAusgabe();

}
