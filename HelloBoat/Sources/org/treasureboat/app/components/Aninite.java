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
      persons.add(new Personen("William", "Hartnell"));
      persons.add(new Personen("Patrick", "Troughton"));
      persons.add(new Personen("John", "Pertwee"));
      persons.add(new Personen("Tom", "Baker"));
      persons.add(new Personen("Peter", "Davison"));
      persons.add(new Personen("Colin", "Baker"));
      persons.add(new Personen("Sylvester", "McCoy"));
      persons.add(new Personen("Paul", "McGann"));
      persons.add(new Personen("John", "Hurt"));
      persons.add(new Personen("Christopher", "Eccleston"));
      persons.add(new Personen("David", "Tennant"));
      persons.add(new Personen("Matt", "Smith"));
      persons.add(new Personen("Peter", "Capaldi"));
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
  
  public int nummer() {
    return persons().indexOf(personenloop) + 1;
  }
  

}    
