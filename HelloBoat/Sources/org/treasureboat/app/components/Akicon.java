package org.treasureboat.app.components;

import org.treasureboat.app.eo.ToDo;
import org.treasureboat.webcore.appserver.TBSession;
import org.treasureboat.webcore.enums.ETBWLanguage;
import org.treasureboat.webcore.localization.TBWLocalizer;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

public class Akicon extends Convention {

  private static final long serialVersionUID = 1L;

  public Akicon(WOContext context) {
    super(context);
  }

  public TBWLocalizer localizer() {
    TBWLocalizer localizer = super.localizer();

    localizer = TBWLocalizer.localizerForLanguage(ETBWLanguage.English);
    //      System.err.println(localizer.localizedStringForKey("MyFirstTest"));
    //      
    //      
    //      localizer = TBWLocalizer.localizerForLanguage(ETBWLanguage.Japanese);
    TBSession.session().setLanguage(ETBWLanguage.English.name());

    return localizer;
  }


  //********************************************************************
  //  
  //********************************************************************

  public NSArray<ToDo> allTodos() {

    return null;
  }

  public NSArray<ToDo> selectionTodos() {

    return null;
  }

  public ToDo selectedTodo() {

    return null;
  }

  public ToDo oneTodo;


  public WOActionResults doSaveAction() {



    return goToMySelfAction();
  }


}