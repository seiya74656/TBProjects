package org.treasureboat.app.components;

import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class Aninite extends TBComponent {
    /**
   * 
   */
  private static final long serialVersionUID = 1L;

    public Aninite(WOContext context) {
        super(context);
        }

    public class Personen {
      private String vorName;
      private String nachName;
      
      public Personen(String vorName, String nachName){
        super();
        this.vorName = vorName;
        this.nachName = nachName;        
      }
      
      public String nachName(){
        return nachName;
      }
      
      public void setnachName(String nachName) {
        this.nachName = nachName;
      }
      
      public String vorName(){
        return vorName;
      }
      
      public void setvorName(String vorName) {
        this.vorName = vorName;
      }
      
    }
    
    private NSMutableArray<Personen> persons;

    persons = new NSMutableArray<Personen>();
    persons.add(new Personen("Rene", "Fuerst"));

    public NSMutableArray<Personen> persons() {
      return persons;
    }
}    
