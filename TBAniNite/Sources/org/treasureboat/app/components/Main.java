package org.treasureboat.app.components;

import org.treasureboat.webcore.annotations.TBPageAccess;
import org.treasureboat.webcore.appserver.TBContext;
import org.treasureboat.webcore.appserver.TBSession;
import org.treasureboat.webcore.appserver.iface.ITBWActionResults;
import org.treasureboat.webcore.components.TBComponent;
import org.treasureboat.webcore.enums.ETBWLanguage;

@TBPageAccess (
    navigationState = "Welcome"
    )
public class Main extends TBComponent {

	private static final long serialVersionUID = 1L;

	//********************************************************************
	//  Constructor : コンストラクタ
	//********************************************************************

	public Main(TBContext context) {
		super(context);
	}
	
  public ITBWActionResults doEnglishAction() {
    TBSession.session().setLanguage(ETBWLanguage.English.name());
    System.err.println("doEnglishAction is called.");
    return goToMySelfAction();
  }

}
