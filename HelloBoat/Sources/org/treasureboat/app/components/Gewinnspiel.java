package org.treasureboat.app.components;

import org.treasureboat.foundation.TBFString;
import org.treasureboat.webcore.appserver.TBSession;
import org.treasureboat.webcore.components.TBComponent;
import org.treasureboat.webcore.enums.ETBWLanguage;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;

public class Gewinnspiel extends TBComponent {

  private static final long serialVersionUID = 1L;

  //********************************************************************
  //  Constructor : コンストラクタ
  //********************************************************************
  public Gewinnspiel(WOContext context) {
    super(context);

  }
  //********************************************************************
  //  Methods : メソッド
  //********************************************************************

  public String email = "";
  public String deinname = "";
  public boolean agb = false;


  //********************************************************************
  //  Actions : アクション
  //********************************************************************
  public boolean isValidEmailAddress(String emailadress) {
    String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
    java.util.regex.Matcher m = p.matcher(emailadress);
    return m.matches();
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

  public WOActionResults doMitmachenAction() {
    if (!agb || TBFString.stringIsNullOrEmpty(deinname) || TBFString.stringIsNullOrEmpty(email) || !isValidEmailAddress(email)) {
      log.info("Mitmachen fehlgeschlagen!!! AGB: {}, Name: {}, Email: {}", agb, deinname, email);
    } else {
      log.info("Mitmachen wurde aufgerufen. AGB: {}, Name: {}, Email: {}", agb, deinname, email);
    }
    return goToMySelfAction();
  }


}
