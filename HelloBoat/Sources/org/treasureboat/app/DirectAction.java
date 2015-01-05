package org.treasureboat.app;

import org.treasureboat.app.components.Main;
import org.treasureboat.webcore.appserver.TBWDirectAction;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WORequest;


public class DirectAction extends TBWDirectAction {

	//********************************************************************
	//  Constructor : コンストラクタ
	//********************************************************************

	public DirectAction(WORequest request) {
		super(request);
	}

	//********************************************************************
	//  Login Starter ログイン入り口
	//********************************************************************

	/**
	 * Main Page
	 */
	public WOActionResults s634Action() {
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}
}
