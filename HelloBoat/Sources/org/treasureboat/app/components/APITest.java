package org.treasureboat.app.components;

import org.treasureboat.webcore.appserver.TBContext;

public class APITest extends Sample {

  private static final long serialVersionUID = 1L;

  public APITest(TBContext context) {
    super(context);
    // TODO Auto-generated constructor stub
  }


  public String message() {
    return _message;
  }

  public void setMessage(String message) {
    _message = message;
  }

  public String messaged() {
    return _messaged;
  }

  public void setMessaged(String messaged) {
    _messaged = messaged;
  }
  
  private String _message;
  private String _messaged;

}
