package org.treasureboat.app.components;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import org.treasureboat.webcore.components.TBComponent;


public class Login extends TBComponent {

  private static final long serialVersionUID = 1L;

  //********************************************************************
  //  Constructor : コンストラクタ
  //********************************************************************
    public Login(WOContext context) {
        super(context);
    }

    //********************************************************************
    //  Methods : メソッド
    //********************************************************************

    public String loginname,loginpass;

    //********************************************************************
    //  Action : アクション
    //********************************************************************
    public WOActionResults doSubmitAction() {

    if("seiya".equals(loginname) && "pass".equals(loginpass))
      { 
      MyHome nextPage = pageWithName(MyHome.class);
      
      
      nextPage.setUsername(loginname);
      
      
      return nextPage;
      }     else     { 
      return goToMySelfAction(); 
      }
  }
  
    public WOActionResults goBackToMainAction() {
      Main nextPage = pageWithName(Main.class);
      return nextPage;
    }
}
    
