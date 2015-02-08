package org.treasureboat.app.components;

import org.treasureboat.webcore.annotations.TBPageAccess;
import org.treasureboat.webcore.appserver.TBSession;
import org.treasureboat.webcore.components.TBComponent;
import org.treasureboat.webcore.enums.ETBWLanguage;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;

@TBPageAccess (
    navigationState = "Welcome"
    )
public class Main extends TBComponent {
	/**
	 * Do I need to update serialVersionUID?
	 * See section 5.6 <cite>Type Changes Affecting Serialization</cite> on page 51 of the 
	 * <a href="http://java.sun.com/j2se/1.4/pdf/serial-spec.pdf">Java Object Serialization Spec</a>
	 */
	private static final long serialVersionUID = 1L;

	//********************************************************************
	//  Constructor : コンストラクタ
	//********************************************************************

	public Main(WOContext context) {
		super(context);
	}
	
  public WOActionResults doEnglishAction() {
    TBSession.session().setLanguage(ETBWLanguage.English.name());
    System.err.println("doEnglishAction is called.");
    return goToMySelfAction();
  }

}
