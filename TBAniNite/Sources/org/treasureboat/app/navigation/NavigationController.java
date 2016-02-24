package org.treasureboat.app.navigation;

import org.treasureboat.app.Session;
import org.treasureboat.app.components.Main;
import org.treasureboat.webcore.appserver.iface.ITBWActionResults;
import org.treasureboat.webcore.appserver.navbar.TBWNavigationBaseController;

public class NavigationController extends TBWNavigationBaseController {

	//********************************************************************
	//  Constructor : コンストラクタ
	//********************************************************************

	public NavigationController(Session s) {
		super(s);
	}

	//********************************************************************
	//  Shared Actions : 共通アクション
	//********************************************************************

	@Override
  public ITBWActionResults defaultAction() {
		return pageWithName(Main.class);
	}

	//********************************************************************
	//  Actions : アクション
	//********************************************************************

	// ...
	
}
