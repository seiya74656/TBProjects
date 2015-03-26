package org.treasureboat.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.treasureboat.app.navigation.NavigationController;
import org.treasureboat.foundation.constants.TBFKnownLookNames;
import org.treasureboat.webcore.appserver.TBSession;

public class Session extends TBSession {
  /**
   * Do I need to update serialVersionUID?
   * See section 5.6 <cite>Type Changes Affecting Serialization</cite> on page 51 of the 
   * <a href="http://java.sun.com/j2se/1.4/pdf/serial-spec.pdf">Java Object Serialization Spec</a>
   */
  private static final long serialVersionUID = 1L;

  /** 
   * <a href="http://wiki.wocommunity.org/display/documentation/Wonder+Logging">new org.slf4j.Logger</a> 
   */
  static final Logger log = LoggerFactory.getLogger(Session.class);

  //********************************************************************
  //  Constructor : コンストラクター
  //********************************************************************

  public Session() {
    super();

    // Set the Navigation Controller
    if(navController() == null) {
      setNavController(new NavigationController(this));
    }

    // set the default Look
    setCurrentD2WLook(TBFKnownLookNames.GUMBY);
  }
}
