public class main_adjlist {
    public static void main(String[] args){
        Adjazenzliste liste = new Adjazenzliste();
        liste.knotenEinfuegen(5);
        liste.knotenEinfuegen(1);
        liste.knotenEinfuegen(4);
        liste.knotenEinfuegen(2);
        liste.knotenEinfuegen(3);
        liste.kanteEinfuegen(4,3);
        liste.kanteEinfuegen(4,2);
        liste.kanteEinfuegen(0,0);
        liste.kanteEinfuegen(1,2);
        int a = liste.traversieren(4);
        liste.gewichtTraversieren( 4);
        liste.knotenAusgabe(4);
        liste.allesAusgeben();
    }
}
