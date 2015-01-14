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
    caesar(Randomtext, 1);

  }

  private String _randomtext;

  
  public void caesar(String str, int key) {
    for(int i = 0; i < str.length();i++) {
      str = str.toUpperCase();
      char c = (char) (str.charAt(i) + key);
 
 
      while (c > 'Z') {
        c = (char) (c - 'Z' +'A' - 1);
      }
 
      System.out.print(c);
    }
    log.info("String LAenger: {}", str.length());
  }

}