package org.treasureboat.app;

import org.treasureboat.app.components.Main;
import org.treasureboat.webcore.appserver.TBDirectAction;
import org.treasureboat.webcore.appserver.TBRequest;
import org.treasureboat.webcore.appserver.iface.ITBWActionResults;


public class DirectAction extends TBDirectAction {

	//********************************************************************
	//  Constructor : コンストラクタ
	//********************************************************************

	public DirectAction(TBRequest request) {
		super(request);
	}

	//********************************************************************
	//  Login Starter ログイン入り口
	//********************************************************************

	/**
	 * Main Page
	 */
	public ITBWActionResults s634Action() {
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}
}
