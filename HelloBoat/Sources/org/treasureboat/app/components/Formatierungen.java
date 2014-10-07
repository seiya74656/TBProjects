package org.treasureboat.app.components;

import org.treasureboat.webcore.annotations.TBPageAccess;
import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSTimestamp;

@TBPageAccess (
    navigationState = "Welcome"
    )
public class Formatierungen extends TBComponent {
  /**
   * Do I need to update serialVersionUID?
   * See section 5.6 <cite>Type Changes Affecting Serialization</cite> on page 51 of the 
   * <a href="http://java.sun.com/j2se/1.4/pdf/serial-spec.pdf">Java Object Serialization Spec</a>
   */
  private static final long serialVersionUID = 1L;

  //********************************************************************
  //  Constructor : コンストラクタ
  //********************************************************************

  public Formatierungen(WOContext context) {
    super(context);
  }

  //********************************************************************
  //  Methods : メソッド
  //********************************************************************
  public NSTimestamp timestamp(){
    return new NSTimestamp();
  }

}