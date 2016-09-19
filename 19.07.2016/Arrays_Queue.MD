## 1. Listen
#### 1.1 Warteschlange

```java
public class Warteschlange {
  
  String[] teilnehmer = new String[15];
  int laenge = 0;
  
  public void verlassen(int index) {
    for (int i = index + 1; i < laenge) {
      teilnehmer[i] = teilnehmer[i - 1];
    }
    laenge--;
  }
  
  public void beitreten(String neuerTeilnehmer) {
    teilnehmer[laenge] = neuerTeilnehmer;
    laenge++;
  }
}
```
