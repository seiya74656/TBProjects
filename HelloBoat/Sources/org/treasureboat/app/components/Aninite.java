package org.treasureboat.app.components;

import org.treasureboat.webcore.components.TBComponent;
import org.treasureboat.app.components.Personen;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;


public class Aninite extends TBComponent {

  private static final long serialVersionUID = 1L;
  private NSMutableArray<Personen> persons;

  public Aninite(WOContext context) {
    super(context);



    persons = new NSMutableArray<Personen>();
    persons.add(new Personen("Lolo", "lala"));
    persons.add(new Personen("Rene", "Fuerst"));

    public NSMutableArray<Personen> persons() {
      return persons;
    }
  }    
