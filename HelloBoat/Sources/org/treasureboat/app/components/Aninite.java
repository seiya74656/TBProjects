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


    public NSArray<String> monate = new NSArray<>(new String[] { "januar", "februar", "märz", "april", "mai", "juni", "juli", "august",
        "september", "oktober", "november", "dezember" });




}