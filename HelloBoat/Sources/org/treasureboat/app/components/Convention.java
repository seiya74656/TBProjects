package org.treasureboat.app.components;

import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;

public class Convention extends TBComponent {

  private static final long serialVersionUID = 1L;

    public Convention(WOContext context) {
        super(context);
    }
 
    public String getConvention() {
      return _convention;
    }

    public void setConvention(String convention) {
      _convention = convention;
    }

    private String _convention;

    public String getRandomtext() {
      return _randomtext;
    }

    public void setRandomtext(String Randomtext) {
      _randomtext = Randomtext;
    }

    private String _randomtext;
    
    
}