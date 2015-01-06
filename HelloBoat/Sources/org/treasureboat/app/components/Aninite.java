package org.treasureboat.app.components;

import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
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
    }
    return persons;
  }
  private NSMutableArray<Personen> persons;
  public Personen personenloop;
  
  //TEST

  public void setTest(NSArray<Personen> test) {
    this.test = test;
  }
  public NSArray<Personen> test() {
    if (test == null) {
      test = persons();
    }
    return test;
  }
  private NSArray<Personen> test;
  
  public Personen secondPerson() {
    if (test() == null || test().count() < 2) { 
      return null;
    }
    return test().objectAtIndex(1);
  }
  
  
}    
