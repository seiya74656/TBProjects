package org.treasureboat.app.components;

import org.treasureboat.webcore.appserver.TBContext;
import org.treasureboat.webcore.appserver.iface.ITBWActionResults;
import org.treasureboat.webcore.components.TBComponent;


public class Login extends TBComponent {

  private static final long serialVersionUID = 1L;

  //********************************************************************
  //  Constructor : コンストラクタ
  //********************************************************************
    public Login(TBContext context) {
        super(context);
    }

    //********************************************************************
    //  Methods : メソッド
    //********************************************************************

    public String loginname,loginpass;

    //********************************************************************
    //  Action : アクション
    //********************************************************************
    public ITBWActionResults doSubmitAction() {

    if("seiya".equals(loginname) && "pass".equals(loginpass))
      { 
      MyHome nextPage = pageWithName(MyHome.class);
      
      
      nextPage.setUsername(loginname);
      
      
      return nextPage;
      }     else     { 
      return goToMySelfAction(); 
      }
  }
  
    public ITBWActionResults goBackToMainAction() {
      Main nextPage = pageWithName(Main.class);
      return nextPage;
    }
}
    
