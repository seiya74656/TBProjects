package org.treasureboat.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.treasureboat.app.override.CoreDelegater;
import org.treasureboat.app.override.CoreQualifier;
import org.treasureboat.app.override.FirstDataCreator;
import org.treasureboat.app.override.FirstResponder;
import org.treasureboat.app.override.LoginCheck;
import org.treasureboat.app.override.RestInitializer;
import org.treasureboat.webcore.override.TBWInitializerOfFirstDataCreator;
import org.treasureboat.webcore.override.TBWInitializerOfRest;
import org.treasureboat.webcore.override.core.TBWCoreDelegaterBase;
import org.treasureboat.webcore.override.core.TBWCoreQualifierBase;
import org.treasureboat.webcore.security.password.TBWLoginBaseCheck;
import org.treasureboat.webcore.security.user.TBWFirstResponder;

import er.extensions.appserver.TBApplication;

public class Application extends TBApplication {

	/** 
	 * <a href="http://wiki.wocommunity.org/display/documentation/Wonder+Logging">new org.slf4j.Logger</a> 
	 */
	static final Logger log = LoggerFactory.getLogger(Application.class);

	//********************************************************************
	//  BOOT : アプリケーション起動開始
	//********************************************************************

	public static void main(String[] argv) {
		TBApplication.main(argv, Application.class);
	}

	//********************************************************************
	//  Constructor : コンストラクタ
	//********************************************************************

	public Application() {
		log.info("=================================================");
		log.info("Welcome to " + name() + " !");
		log.info("=================================================");
	}

	//********************************************************************
	//  Setup : セットアップ
	//********************************************************************

	@Override
	public TBWCoreDelegaterBase coreDelegater() {
		return new CoreDelegater(); /* TreasureBoat Pro Base Model */
	}

	@Override
	public TBWCoreQualifierBase coreQualifier() {
		return new CoreQualifier(); /* TreasureBoat Pro Base Model */
	}

	@Override
	public TBWInitializerOfFirstDataCreator firstDataCreator() {
		return new FirstDataCreator(); /* TreasureBoat Pro Base Model */
	}

	@Override
	public TBWLoginBaseCheck loginChecker() {
		return new LoginCheck(); /* TreasureBoat Pro Base Model */
	}

	@Override
	public TBWFirstResponder firstResponder() {
		return new FirstResponder();
	}

	@Override
	public TBWInitializerOfRest restInitializer() {
		return new RestInitializer();
	}
}
