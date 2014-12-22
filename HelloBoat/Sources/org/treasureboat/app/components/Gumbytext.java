package org.treasureboat.app.components;

import com.webobjects.appserver.WOContext;
import org.treasureboat.webcore.components.TBComponent;


public class Gumbytext extends TBComponent {
  /**
   * Do I need to update serialVersionUID?
   * See section 5.6 <cite>Type Changes Affecting Serialization</cite> on page 51 of the 
   * <a href="http://java.sun.com/j2se/1.4/pdf/serial-spec.pdf">Java Object Serialization Spec</a>
   */

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

   
}