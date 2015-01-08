package org.treasureboat.app.components;

import com.webobjects.appserver.WOContext;

import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.foundation.NSArray;

public class Gumbytext extends TBComponent {

  private static final long serialVersionUID = 1L;

  //********************************************************************
  //  Constructor : コンストラクタ
  //********************************************************************
  public Gumbytext(WOContext context) {
    super(context);
  }

  //********************************************************************
  //  Methods : メソッド
  //********************************************************************
  private String _day;
  private NSArray<Convention> _tabs;

  public Convention selectedPopUp;
  public Convention selectedTab;

  /* TAB */
  public NSArray<Convention> tabes() {
    if (_tabs == null) {
      Convention a = new Convention("AniNite", 14590);
      Convention b = new Convention("AkiCon", 3850);
      Convention c = new Convention("MangaWorld", 8200);
      _tabs = new NSArray<>(a, b, c);
    }
    return _tabs;
  }
  public Convention oneConvention; // für Repetition's
  
  //********************************************************************
  //  Actions : アクション
  //********************************************************************

  public String Day() {
    return _day;
  }

  public void setDay(String day) {
    _day = day;
  }

  public String myText;

  public WOActionResults doSendAction() {
    String s = selectedPopUp == null ? "[null]" : selectedPopUp.convention();
    System.err.println("// MyText: " + myText +" // Auflistung: "+ s + "//");
    return goToMySelfAction();
  }

  public WOActionResults doSampleAction() {
    return goToMySelfAction();
  }

  public WOActionResults doTabAction() {
    log.info("doTabAction wurde aufgerufen.");
    return goToMySelfAction();
  }

  //********************************************************************
  //  Convention Class
  //********************************************************************

  public class Convention {

    public Convention(String convention, int besucherzahlen) {
      _convention = convention;
      _besucherzahlen = besucherzahlen;
    }

    public void setConvention(String convention) {
      _convention = convention;
    }

    public String convention() {
      return _convention;
    }

    private String _convention;

    public void setBesucherzahlen(int besucherzahlen) {
      _besucherzahlen = besucherzahlen;
    }

    public int besucherzahlen() {
      return _besucherzahlen;
    }

    private int _besucherzahlen;

  }


}