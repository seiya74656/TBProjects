package org.treasureboat.app;

import org.treasureboat.app.components.Main;
import org.treasureboat.webcore.appserver.TBDirectAction;
import org.treasureboat.webcore.appserver.TBRequest;

import com.webobjects.appserver.WOActionResults;

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
	public WOActionResults s634Action() {
		Main nextPage = pageWithName(Main.class);
		return nextPage;
	}
}
