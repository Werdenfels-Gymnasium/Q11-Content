####1.2 Einfach verkettete Listen

> Objektdiagramm:

![Nicht verfügbar](Objektdiagramm.png)

> Klassendiagramm:

![Nicht verfügbar](Klassendiagramm.png)

--> Buch Seite 16/17 und 217/218 (UML)

#####BAHNWAGON.java
```java
public class BAHNWAGON {
  private String wagonArt;
  
  public BAHNWAGON(String wagonArt) {
    this.wagonArt = wagonArt;
  }
  
  public String wagonArtGeben() {
    return this.wagonArt;
  }
  
  public void wagonArtSetzen(String wagonArt) {
    this.wagonArt = wagonArt;
  }
}
```
#####KNOTEN.java
```java
public class KNOTEN {

  private KNOTEN naechster;
  private BAHNWAGON inhalt;
  
  public KNOTEN(KNOTEN naechster, BAHNWAGON inhalt) {
    if (!this.equals(naechster)) this.naechster = naechster;
    this.inhalt = inhalt;
  }
  
  public void naechsterSetzen(KNOTEN naechster) {
    if (!this.equals(naechster)) this.naechster = naechster;
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
  private int laenge = 1;
  
  public LOKOMOTIVE(String lokArt) {
    this.erster = new KNOTEN(null, new BAHNWAGON(lokArt));
  }
  
  public int wagenanzahlGeben() {
    return this.laenge;
  }
  
  public boolean wagonAnhaengen(BAHNWAGON wagon) {
    KNOTEN currentKnoten = erster; 
          
    while (currentKnoten.naechsterGeben() != null) {
      currentKnoten = currentKnoten.naechsterGeben();
    }
    currentKnoten.naechsterSetzen(new KNOTEN(null, wagon));
    laenge++;
    return true;
  }
  
  public int enthaeltWagon(BAHNWAGON wagon) {
    KNOTEN currentKnoten = erster;
    int index = 0;
    
    while (!currentKnoten.inhaltGeben().equals(wagon)) {
      if (currentKnoten.naechsterGeben() == null) {
        return -1;
      }
      currentKnoten = currentKnoten.naechsterGeben();
      index++;
    }
    return index;
  }
  
  public boolean wagonAbkuppeln(BAHNWAGON wagon) {        
    int index = enthaeltWagon(wagon);
      
    if (index == -1) return false;
    
    KNOTEN currentKnoten = erster;
    
    while (currentKnoten.naechsterGeben() != null) {
      if (!currentKnoten.naechsterGeben().inhaltGeben().equals(wagon)) {
        currentKnoten = currentKnoten.naechsterGeben();  
        continue;
      }
      laenge--;
      if (knotenGeben(index).naechsterGeben() != null) {
        currentKnoten.naechsterSetzen(knotenGeben(index).naechsterGeben());
        return true;
      }
      System.out.println(currentKnoten);
      currentKnoten.naechsterSetzen(null);
      return true;
    }
    return false;
  }
  
  private KNOTEN knotenGeben(int index) {
    KNOTEN currentKnoten = erster;
    
    if (index < 0 && index >= laenge) {
      return null;
    }
    for (int i = 0; i < index; i++) {
      if (currentKnoten.naechsterGeben() == null) return null;
      currentKnoten = currentKnoten.naechsterGeben();
    }
    return currentKnoten;
  }
  
  public BAHNWAGON bahnwagonGeben(int index) {
    return knotenGeben(index).inhaltGeben();
  }
}
```

#####TEST.java

```java
public class TEST {

  
  
  public static void main(String[] args) {
    BAHNWAGON wagon1 = new BAHNWAGON("Passagierwagon");
    BAHNWAGON wagon2 = new BAHNWAGON("Lastwagon");
    KNOTEN knoten1 = new KNOTEN(null, wagon1);
    LOKOMOTIVE lok = new LOKOMOTIVE("E-Lok");
    
    System.out.println("Der Wagen " + wagon2.wagonArtGeben() + " wurde angehängt: " + lok.wagonAnhaengen(wagon2));
    System.out.println("Der Wagen " + wagon2.wagonArtGeben() + " ist im Zug enthalten: " + lok.enthaeltWagon(wagon2));
    System.out.println("Der Wagen " + wagon2.wagonArtGeben() + " wurde abgekuppelt: " + lok.wagonAbkuppeln(wagon2));
    System.out.println("Der Wagen an 0. Stelle ist: " + lok.bahnwagonGeben(0).wagonArtGeben();
  }
}
```
