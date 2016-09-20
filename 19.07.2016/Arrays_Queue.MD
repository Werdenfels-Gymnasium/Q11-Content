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
}
```
