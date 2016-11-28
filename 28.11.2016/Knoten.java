public class Knoten extends Komponente {

    
    private Komponente naechster;
    private Artikel inhalt;
    
    public Knoten(Komponente naechster, Artikel inhalt) {
        this.naechster = naechster;
        this.inhalt = inhalt;
    }
    
    public void abHierAusgeben() {
        this.inhalt.ausgeben();
        this.naechster.abHierAusgeben();
    }

}