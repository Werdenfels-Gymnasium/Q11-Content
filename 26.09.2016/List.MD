####1.2 Einfach verkettete Listen

> Objektdiagramm:

![Nicht verfügbar](Objektdiagramm.png)

> Klassendiagramm:

![Nicht verfügbar](Klassendiagramm.png)

--> Buch Seite 16/17 und 217/218 (UML)

#####BAHNWAGON.java
```java
public class BAHNWAGON {
  String wagonArt;
  
  public BAHNWAGON(String wagonArt) {
    this.wagonArt = wagonArt;
  }
}
```
#####KNOTEN.java
```java
public class KNOTEN {
  private KNOTEN naechster;
  private BAHNWAGON inhalt;
  
  public void naechsterSetzen(KNOTEN naechster) {
    this.naechster = naechster;
  }
  
  public void inhaltSetzen(BAHNWAGON inhalt) {
    this.inhalt = inhalt;
  }
  
  public KNOTEN naechsterGeben() {
    return this.naechster;
  }
  
  public BAHNWAGON inhaltGeben() {
    return this.inhalt;
  }
}
```
#####LOKOMOTIVE.java

```java
public class LOKOMOTIVE {
  private KNOTEN erster;
  private int laenge;
  
  public LOKOMOTIVE(KNOTEN erster, int laenge) {
    this.erster = erster;
    this.laenge = laenge;
  }
  
  public int wagenanzahlGeben() {
    return this.laenge;
  }
}
```
