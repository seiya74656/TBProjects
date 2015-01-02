package org.treasureboat.app.components;

import org.treasureboat.webcore.annotations.TBPageAccess;
import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSMutableArray;

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
    public NSMutableArray<Adventkalendar> adventkalendar() {
      adventkalendar = new NSMutableArray<Adventkalendar>();
      adventkalendar.add(new Adventkalendar("1", "Lala", "MMM"));
      adventkalendar.add(new Adventkalendar("2", "Papa", "ddd"));
      adventkalendar.add(new Adventkalendar("3", "Mama", "fff"));
      adventkalendar.add(new Adventkalendar("4", "DaDa", "ggg"));
      adventkalendar.add(new Adventkalendar("5", "KaKa", "eee"));
      adventkalendar.add(new Adventkalendar("6", "HaHa", "Lolo"));
      adventkalendar.add(new Adventkalendar("7", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("8", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("9", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("11", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("12", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("13", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("14", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("15", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("16", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("17", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("18", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("19", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("20", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("21", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("22", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("23", "Lala", "Lolo"));
      adventkalendar.add(new Adventkalendar("24", "Lala", "Lolo"));
      return adventkalendar;
    }
    
    private NSMutableArray<Adventkalendar> adventkalendar;
    public Adventkalendar adventkalendarloop;
}