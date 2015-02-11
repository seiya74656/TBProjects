package org.treasureboat.app.components;

import org.treasureboat.app.eo.AllergenInfoTBL;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;

public class Speisekarte extends Main {

  private static final long serialVersionUID = 1L;

  public Speisekarte(WOContext context) {
    super(context);
    // TODO Auto-generated constructor stub
  }

  // Auflistung aller AllergeneInfo
  
  public NSArray<AllergenInfoTBL> allAllergenInfoTBLs() {
    return AllergenInfoTBL.fetchAllAllergenInfoTBLs(editingContext(), AllergenInfoTBL.ALLERGENINFOCODE.ascs());
  }
  
  public AllergenInfoTBL einzelAllergenInfoTBL;

}
