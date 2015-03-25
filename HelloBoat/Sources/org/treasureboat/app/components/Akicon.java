package org.treasureboat.app.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.treasureboat.app.eo.ToDo;
import org.treasureboat.foundation.date.TBFTimestamp;
import org.treasureboat.webcore.appserver.TBSession;
import org.treasureboat.webcore.enums.ETBWLanguage;
import org.treasureboat.webcore.localization.TBWLocalizer;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;

import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXEC;

public class Akicon extends Convention {

  private static final long serialVersionUID = 1L;

  static final Logger log = LoggerFactory.getLogger(Akicon.class);

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
    log.info("wir versuchen alle Daten zu bekommen");
    return ToDo.fetchAllToDos(editingContext());
  }

  public NSArray<ToDo> selectionTodos() {

   // EOQualifier
    // EOSortOrdering
    // EOFetchSpecification
    
    return ToDo.fetchToDos(editingContext(), ToDo.TASK.eq("my first task7"), ToDo.TASK.asc().array());
  }

  public ToDo selectedTodo() {
    return ToDo.fetchToDo(editingContext(), ToDo.TASK.eq("my first task7"));
  }

  public ToDo oneTodo;


  public WOActionResults doSaveAction() {


    editingContext().saveChanges();

    return goToMySelfAction();
  }

  public WOActionResults doCreateAction() {
    
    EOEditingContext ec = ERXEC.newEditingContext();
    ToDo neuesToDo = ToDo.createAndInsertInstance(ec);
    
    neuesToDo.setDueDate(new TBFTimestamp());
    neuesToDo.setTask("Rene ist da.");
    
    ec.saveChanges();

    return goToMySelfAction();
  }
    
  public WOActionResults doRemoveAction() {
    
    
    oneTodo.delete();
    editingContext().saveChanges();

    
    
    
    
    return goToMySelfAction();
  }
  
  
  
  
  
  
  
  
  
}