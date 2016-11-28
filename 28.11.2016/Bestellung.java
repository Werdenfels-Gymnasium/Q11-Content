public class Bestellung {

    Komponente erster;
    
    public void anzeigen() {
        this.erster.abHierAusgeben();
    }
    
    public void ersterSetzten(Komponente erster) {
        this.erster = erster;
    }

}