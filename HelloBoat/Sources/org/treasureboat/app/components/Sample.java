package org.treasureboat.app.components;

import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;

public class Sample extends TBComponent {

  private static final long serialVersionUID = 1L;

  public Sample(WOContext context) {
    super(context);
  }

//  public String message() {
//    return stringValueForBinding("message");
//  }

  
  public void setMessage(String message) {
    _message = message;
  } 
  public String message() {
    return _message;
  }
  private String _message;


}
