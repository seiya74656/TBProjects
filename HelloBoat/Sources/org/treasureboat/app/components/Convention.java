package org.treasureboat.app.components;

import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;

public class Convention extends TBComponent {

  private static final long serialVersionUID = 1L;

  //********************************************************************
  //  Constructor : コンストラクタ
  //********************************************************************


  public Convention(WOContext context) {
    super(context);
  }

  //********************************************************************
  //  Actions : アクション
  //********************************************************************
  
  
  public String getConvention() {
    return _convention;
  }

  public void setConvention(String convention) {
    _convention = convention;
  }
 
  public void setConvention(String convention, String beschreibung) {
    _convention = "<h2>Convention: <b>" + convention + " </h2> " + beschreibung + "</b><br/>";
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