package org.treasureboat.app.components;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import org.treasureboat.webcore.components.TBComponent;


public class MyHome extends TBComponent {

  private static final long serialVersionUID = 1L;

  public MyHome(WOContext context) {
        super(context);
    }
  
  //********************************************************************
  //  Methods : メソッド
  //********************************************************************
  
  public void setUsername(String username) {
    _username = "Mr. " + username;
  }
  public String username() {
    return _username;
  }
  private String _username;
  
  public String test() { 
    test = "Hallo";
    return test;
  }

public String hotelkosten, autokosten,datum, uhrzeit, telephone, test;
  //********************************************************************
  //  Actions : アクション
  //********************************************************************
  
  public WOActionResults goBackToMainAction() {
    
    System.err.println(username());
    
    return goToMySelfAction();
  }



}