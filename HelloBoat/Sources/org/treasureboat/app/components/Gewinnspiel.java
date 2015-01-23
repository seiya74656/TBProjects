package org.treasureboat.app.components;

import org.treasureboat.webcore.appserver.TBSession;
import org.treasureboat.webcore.components.TBComponent;
import org.treasureboat.webcore.enums.ETBWLanguage;
import org.treasureboat.webcore.localization.TBWLocalizer;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;

public class Gewinnspiel extends TBComponent {

  private static final long serialVersionUID = 1L;

  public Gewinnspiel(WOContext context) {
    super(context);

  }

  public WOActionResults doEnglishAction() {
    TBSession.session().setLanguage(ETBWLanguage.English.name());     
    return goToMySelfAction();
  }
  
  public WOActionResults doGermanAction() {
    TBSession.session().setLanguage(ETBWLanguage.German.name());
    return goToMySelfAction();

  }
  
  public WOActionResults doJapaneseAction() {
    TBSession.session().setLanguage(ETBWLanguage.Japanese.name());
    return goToMySelfAction();

  }
  
  public TBWLocalizer localizer() {
    
    TBWLocalizer localizer = super.localizer();
    
    return localizer;
  }


  
}
