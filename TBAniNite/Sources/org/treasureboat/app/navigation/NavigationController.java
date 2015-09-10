package org.treasureboat.app.navigation;

import org.treasureboat.app.Session;
import org.treasureboat.app.components.Main;
import org.treasureboat.webcore.appserver.navbar.TBWNavigationBaseController;

import com.webobjects.appserver.WOActionResults;

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
  public WOActionResults defaultAction() {
		return pageWithName(Main.class);
	}

	//********************************************************************
	//  Actions : アクション
	//********************************************************************

	// ...
	
}
