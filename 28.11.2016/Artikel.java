public class Artikel {

   double artikelnummer, einzelpreis;
   String bezeichnung;
   
   public Artikel(String bezeichnung, double artikelNummer, double preis) {
       this.artikelnummer = artikelNummer;
       this.einzelpreis = preis;
       this.bezeichnung = bezeichnung;
   }
   
   public double preisGeben() {
       return this.einzelpreis;
   }
   
   public void ausgeben() {
       System.out.println(bezeichnung + " (#" + artikelnummer + ") : Preis: " + einzelpreis + "€");
   }

}