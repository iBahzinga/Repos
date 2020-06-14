public class maingraphen {


    public static void main (String args[]) {
        Adjazenzmatrix matrix = new Adjazenzmatrix();
        matrix = einfuegen(matrix);
        matrix = kanteEinfuegen(matrix);
        int trav0 = matrix.traversieren(0);
        int trav1 = matrix.traversieren(1);
        int trav2 = matrix.traversieren(2);
        int trav3 = matrix.traversieren(3);
        matrix.knotenAusgabe(0);
        matrix.knotenAusgabe(1);
        matrix.knotenAusgabe(2);
        matrix.knotenAusgabe(3);
        matrix.knotenAusgabe(4);
        matrix.gewichtTraversieren(0);
        matrix.allesAusgeben();
    }




    static Adjazenzmatrix einfuegen (Adjazenzmatrix m) {
        m.knotenEinfuegen(5);
        m.knotenEinfuegen(1);
        m.knotenEinfuegen(4);
        m.knotenEinfuegen(2);
        m.knotenEinfuegen(3);
        return m;
    }


    static Adjazenzmatrix kanteEinfuegen (Adjazenzmatrix m) {
        m.kanteEinfuegen(0,2);
        m.kanteEinfuegen(0,3);
        m.kanteEinfuegen(1,4);
        m.kanteEinfuegen(3,3);

        return m;
    }

}
