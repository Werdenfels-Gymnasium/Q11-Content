## 1. Listen
#### 1.1 Warteschlange

```java
public class Warteschlange {
  
  private String[] teilnehmer;
  private int laenge = 0;
  
  public Warteschlange(int maxLaenge) {
    teilnehmer = new String[maxLaenge];
  }
  
  public void vorneVerlassen() {
    verlassen(0);
  }
  
  public void verlassen(int index) {
    for (int i = index; i < laenge; i++) {
      teilnehmer[i] = teilnehmer[i + 1];
    }
    teilnehmer[laenge - 1] = null;
    laenge--;
  }
  
  public void beitreten(String neuerTeilnehmer) {
    teilnehmer[laenge] = neuerTeilnehmer;
    laenge++;
  }
  
  public void vordraengeln(int index, int amount) {
    if (amount <= index && index <= laenge - 1) {
    String previous = teilnehmer[index];

    for (int i = index; i > index - amount ; i--) {
      teilnehmer[i] = teilnehmer[i - 1];
    }

    teilnehmer[index - amount] = previous;
   }
   else if (index > laenge - 1) {
    System.out.println ("Hier steht niemand mehr an!");
   }
   else {
    System.out.println (teilnehmer[index] + " kann sich nicht um " + amount + " nach vorne drängeln!");
   }
  }
}
```
> Probleme der Implementierung einer Warteschlange durch ein Feld:
- Es wird zu viel oder zu wenig Speicherplatz reserviert
- viele unnötige Iterationen

> Verarbeitungsprinzipien:
- **FIFO**: first in first out -> Kioskwarteschlange; Verkehrskontrolle
- **LIFO**: last in first out -> Fähre mit einem Eingang; Skigondel; Pfannkuchenbacken
