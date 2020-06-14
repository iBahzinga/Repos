public class KnotenGraph <T> {
    private T daten;
    public KnotenGraph (Object data) {
        this.daten = (T) data;
    }
    public T getDaten () {
        return daten;
    }
}