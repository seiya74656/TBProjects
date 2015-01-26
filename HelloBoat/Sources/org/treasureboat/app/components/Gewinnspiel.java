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
    if (!agb || TBFString.stringIsNullOrEmpty(deinname) || TBFString.stringIsNullOrEmpty(email)) {
      log.info("Mitmachen fehlgeschlagen!!! AGB: {}, Name: {}, Email: {}", agb, deinname, email);
    } else {
      log.info("Mitmachen wurde aufgerufen. AGB: {}, Name: {}, Email: {}", agb, deinname, email);
    }
    return goToMySelfAction();
  }



}
