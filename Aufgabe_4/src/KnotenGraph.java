public class KnotenGraph <T> {

    private T daten;
    private final int ARRAYSIZE;
    KnotenGraph [] nachbarn;

    public KnotenGraph () {
        ARRAYSIZE = 10;

    }

    public void setDaten () {

    }

    public void setNachbar () {

    }

    public T getDatan () {
        return daten;
    }

    public KnotenGraph [] getNachbar () {
        return nachbarn;
    }
}

