package org.treasureboat.app.components;

import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

public class Aninite extends TBComponent {
    /**
   * 
   */
  private static final long serialVersionUID = 1L;

    public Aninite(WOContext context) {
        super(context);
    }


    public NSArray<String> arraytest() {

      for (int i = '1'; i < 10; i++) {
      arraytest().add("Lala $i");
      }
      
      return arraytest();
  }

}