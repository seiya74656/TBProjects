package org.treasureboat.app.components;

import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

public class Aninite extends TBComponent {

  private static final long serialVersionUID = 1L;

  public Aninite(WOContext context) {
    super(context);
  }

  public NSMutableArray<Personen> persons() {
    if (persons == null) {
      persons = new NSMutableArray<Personen>();
      persons.add(new Personen("Ken", "Ishimoto"));
      persons.add(new Personen("Renate", "Fürst"));
      persons.add(new Personen("Rene", "Fürst"));
      persons.add(new Personen("Bettina", "Lebiu"));
      persons.add(new Personen("Jenny", "Lebiu"));
      persons.add(new Personen("Pietro", "Lebiu"));
    }
    return persons;
  }
  private NSMutableArray<Personen> persons;
  public Personen personenloop;

  public Personen secondPerson() {
    if (persons() == null || persons().count() < 2) { 
      return null;
    }
    int zufallszahl = (int)(Math.random()*persons().count());
    System.err.println(zufallszahl);
    return persons().objectAtIndex(zufallszahl);
  }


}    
