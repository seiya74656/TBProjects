package org.treasureboat.app.components;

import org.treasureboat.webcore.annotations.TBPageAccess;
import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;

@TBPageAccess (
    navigationState = "Calendar"
    )
public class MyCalendar extends TBComponent {

  private static final long serialVersionUID = 1L;

  //********************************************************************
  //  Constructor : コンストラクタ
  //********************************************************************

    public MyCalendar(WOContext context) {
        super(context);
    }
}