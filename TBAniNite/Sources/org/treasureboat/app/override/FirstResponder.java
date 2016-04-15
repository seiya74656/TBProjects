package org.treasureboat.app.override;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.treasureboat.webcore.appserver.TBApplication;
import org.treasureboat.webcore.appserver.TBSession;
import org.treasureboat.webcore.appserver.iface.ITBWActionResults;
import org.treasureboat.webcore.security.user.TBWFirstResponder;

public class FirstResponder extends TBWFirstResponder {

  /** 
   * <a href="http://wiki.wocommunity.org/display/documentation/Wonder+Logging">new org.slf4j.Logger</a> 
   */
  static final Logger log = LoggerFactory.getLogger(FirstResponder.class);

  //********************************************************************
  //  Methods : メソッド
  //********************************************************************

  @Override
  public ITBWActionResults createFirstResponseAction(String loginUri) {
    ITBWActionResults result = super.createFirstResponseAction(loginUri);
    if (result != null) {
      // we got something from TB itself
      // ...
      // return result;
    }
    return TBApplication.application().pageWithName("Main", TBSession.session().context());
  }
}
