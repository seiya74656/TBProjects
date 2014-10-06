package org.treasureboat.app.components;

import org.treasureboat.webcore.annotations.TBNonSynchronizing;
import org.treasureboat.webcore.annotations.TBPageAccess;
import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSTimestamp;

@TBPageAccess (
    navigationState = "Welcome"
    )
@TBNonSynchronizing

public class Formatierungen extends TBComponent {
  private static final long serialVersionUID = 1L;

	//********************************************************************
	//  Constructor : コンストラクタ
	//********************************************************************

	public Formatierungen(WOContext context) {
		super(context);
	}

	//********************************************************************
  //  Methods : メソッド
  //********************************************************************
public NSTimestamp timestamp(){
  return new NSTimestamp();
}


}