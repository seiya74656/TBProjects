package org.treasureboat.app.components;

import org.treasureboat.app.eo.GewinnspielTBL;
import org.treasureboat.webcore.appserver.TBContext;
import org.treasureboat.webcore.appserver.iface.ITBWActionResults;

import com.webobjects.foundation.NSArray;

public class GewinnspielAdmin extends Gewinnspiel {

  private static final long serialVersionUID = 1L;

  public GewinnspielAdmin(TBContext context) {
    super(context);
  }

  
  public NSArray<GewinnspielTBL> gewinnspielList() {

    return GewinnspielTBL.fetchAllGewinnspielTBLs(editingContext());
  }
  
  public GewinnspielTBL oneGewinnspiel;

  public ITBWActionResults doSaveAction() {
    editingContext().saveChanges();
    return goToMySelfAction();
  }
  
}
