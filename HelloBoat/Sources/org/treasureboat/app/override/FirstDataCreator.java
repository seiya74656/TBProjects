package org.treasureboat.app.override;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.treasureboat.webcore.override.TBWInitializerOfFirstDataCreator;
import org.treasureboat.webcore.security.grant.TBWGrantAccess;

public class FirstDataCreator extends TBWInitializerOfFirstDataCreator { 

	/** 
	 * <a href="http://wiki.wocommunity.org/display/documentation/Wonder+Logging">new org.slf4j.Logger</a> 
	 */
	static final Logger log = LoggerFactory.getLogger(FirstDataCreator.class);

	//********************************************************************
	//  Methods : メソッド
	//********************************************************************

	@Override
	public void createFirstDataset() {
		super.createFirstDataset();

		// ... 

		TBWGrantAccess.setGrantAsRestrict();
	}
}
