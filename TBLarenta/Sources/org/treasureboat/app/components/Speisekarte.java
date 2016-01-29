package org.treasureboat.app.components;

import org.treasureboat.app.eo.AllergenInfoTBL;
import org.treasureboat.app.eo.SpeisekarteTBL;
import org.treasureboat.webcore.appserver.TBContext;

import com.webobjects.foundation.NSArray;

public class Speisekarte extends Main {

  private static final long serialVersionUID = 1L;

  public Speisekarte(TBContext context) {
    super(context);
  }

  // Auflistung aller AllergeneInfo
  
  public NSArray<AllergenInfoTBL> allAllergenInfoTBLs() {
    return AllergenInfoTBL.fetchAllAllergenInfoTBLs(editingContext(), AllergenInfoTBL.ALLERGENINFOCODE.ascs());
  }
  
  public AllergenInfoTBL einzelAllergenInfoTBL;

  public NSArray<SpeisekarteTBL> allSpeisekarteTBLs() {
    return SpeisekarteTBL.fetchAllSpeisekarteTBLs(editingContext(), SpeisekarteTBL.NAME.ascs());
  }
  
  public SpeisekarteTBL einzelSpeisekarteTBL;

}
