package org.treasureboat.app.components;

import org.treasureboat.foundation.TBFString;
import org.treasureboat.webcore.annotations.TBPageAccess;
import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;

@TBPageAccess (
    navigationState = "Welcome"
    )
public class Formatierungen extends TBComponent {

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

  public String sampleText, username, usernames,passwords = "";
  //********************************************************************
  //  Actions : アクション
  //********************************************************************

  // Counter GET UND SET

  public void setcounter(int counter) {
    this.counter = counter+1;
  } 

  public int getcounter() {
    return counter;
  }

  public int counter;  

  // Counter GET UND SET END

  //Usernames GET UND SET

  public void setusernames(String username) {
    if (TBFString.stringIsNullOrEmpty(username)) {
      username = "No Name";
    }

    if (username.equalsIgnoreCase("seiya")) { 
      usernames = "OK"; 
    } else { 
      usernames = "NOK";
    }
  } 

  public String getusernames() {
    return usernames;
  }

  // Username GET UND SET END

  public WOActionResults doSubmitAction() {
    setcounter(counter);
    setusernames(username);
    System.err.println( getcounter() + getusernames() );
    System.err.println("sampleText = " + sampleText + "\n Username = " + username + "\n Password" + passwords);

    return goToMySelfAction();
  }

  public WOActionResults goBackToMainAction() {
    Main nextPage = pageWithName(Main.class);
    return nextPage;
  }

}