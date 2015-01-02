package org.treasureboat.app.components;

import com.webobjects.appserver.WOContext;
import org.treasureboat.webcore.components.TBComponent;
import com.webobjects.appserver.WOActionResults;


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
    System.err.println(myText);
    return null;
  }

   
}