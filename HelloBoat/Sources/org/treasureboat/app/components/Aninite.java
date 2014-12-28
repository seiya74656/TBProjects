package org.treasureboat.app.components;

import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;

public class Aninite extends TBComponent {
    /**
   * 
   */
  private static final long serialVersionUID = 1L;

    public Aninite(WOContext context) {
        super(context);
        }

    public NSTimestamp mytimestamp = new NSTimestamp();
//Test of NSArray
    public NSArray<String> monate = new NSArray<String>(new String[] { "januar", "februar", "märz", "april", "mai", "juni", "juli", "august",
        "september", "oktober", "november", "dezember" });


}