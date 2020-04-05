/**

class testklasse {

    private arrayListe <T> _elemente;
    private String testString;
    private Integer testInt;
    private Long testLong;
    private Boolean testBool;


    public testklasse () {
        _elemente = new arrayListe <T> ();
        testString = "Das ist ein Test!";
        testInt = 1_159_357;
        testLong = 5_999_999L;
        testBool = true;
    }

    @Test
    public void testeEinfuegen () {
        _elemente.einfuegen(0, testString);
        _elemente.einfuegen(0, testInt);
        assertSame(2, _anzahlElemente);
    }




}
 */