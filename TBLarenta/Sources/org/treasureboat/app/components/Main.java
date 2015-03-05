package org.treasureboat.app.components;

import org.treasureboat.app.eo.AllergenInfoTBL;
import org.treasureboat.app.eo.SpeisekarteTBL;
import org.treasureboat.foundation.TBFString;
import org.treasureboat.webcore.annotations.TBPageAccess;
import org.treasureboat.webcore.appserver.TBSession;
import org.treasureboat.webcore.components.TBComponent;
import org.treasureboat.webcore.enums.ETBWLanguage;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXEC;

@TBPageAccess(navigationState = "Welcome")
public class Main extends TBComponent {

  private static final long serialVersionUID = 1L;

  // ********************************************************************
  // Constructor : コンストラクタ
  // ********************************************************************

  public Main(WOContext context) {
    super(context);
  }

  // ********************************************************************
  // Methods : メソッド
  // ********************************************************************

  public String beschreibung;
  public String name2;
  public String preis;
  public String sortorder;
  public boolean allergenA = false;
  public boolean allergenB = false;
  public boolean allergenC = false;
  public boolean allergenD = false;

  
  
  
  
  
  // ********************************************************************
  // Actions : アクション
  // ********************************************************************

  // WOPopUpButton
  private NSArray<Sprache> _tabs;
  public Sprache selectedPopUp;

  public NSArray<Sprache> tabes() {
    if (_tabs == null) {
      Sprache a = new Sprache("Deutsch");
      Sprache b = new Sprache("Englisch");
      _tabs = new NSArray<>(a, b);
    }
    return _tabs;
  }

  public Sprache oneSprache;

  // WOPopUpButton ENDE
  // Rückgabe von einer bestimmten Speise
  public SpeisekarteTBL meinespeisekarteTBLs(String string) {
    return SpeisekarteTBL.fetchSpeisekarteTBL(editingContext(), SpeisekarteTBL.BESCHREIBUNG.eq(string));
  }

  public String meinespeisekarte2(String string) {
    String x = meinespeisekarteTBLs(string).name() + " " + meinespeisekarteTBLs(string).beschreibung() + " " + meinespeisekarteTBLs(string).preis();
    return x;
    
  }

  // Auflistung aller Speisekarten Inhalte
  public NSArray<SpeisekarteTBL> allSpeisekartesTBLs() {
    return SpeisekarteTBL.fetchAllSpeisekarteTBLs(editingContext());
  }

  public SpeisekarteTBL einzelAuflistungSpeisekarteTBL;

  // Auflistung aller AllergeneInfo

  public NSArray<AllergenInfoTBL> allAllergenInfoTBLs() {
    return AllergenInfoTBL.fetchAllAllergenInfoTBLs(editingContext(), AllergenInfoTBL.ALLERGENINFOCODE.asc().array());
  }

  public AllergenInfoTBL einzelAllergenInfoTBL;

  public NSArray<AllergenInfoTBL> selectedAllergenInfos;
  
  
  // Einträge speichern.
  public WOActionResults doSaveEntrys() {
    log.info("{} - {} - {} - {} - {}", beschreibung, preis, sortorder, name2, selectedPopUp.sprache());
    log.info("OHHH NOEEEEES: {} <<<<<<<<", meinespeisekarteTBLs("Kurve").name());
    log.info("OHHH YEEEEEES: {} <<<<<<<<", meinespeisekarte2("Vita"));

    editingContext().saveChanges();
    return goToMySelfAction();
  }

  // Neuen eintrag erstellen
  public WOActionResults doCreateEntry() {
    
    
    

    if (TBFString.stringIsNullOrEmpty(beschreibung) || TBFString.stringIsNullOrEmpty(preis) || TBFString.stringIsNullOrEmpty(sortorder) || TBFString.stringIsNullOrEmpty(name2)) {

    }
    else {
      // Clean Editting Context
      EOEditingContext ec = ERXEC.newEditingContext();
      SpeisekarteTBL newSpeisekarteTBL = SpeisekarteTBL.createAndInsertInstance(ec);

      for (AllergenInfoTBL a : selectedAllergenInfos) {
        newSpeisekarteTBL.addToAllergenInfoTBLs(a);
      }

      
//      if(allergenA == true) { 
//        AllergenInfoTBL a = AllergenInfoTBL.fetchAllergenInfoTBL(ec, AllergenInfoTBL.ALLERGENINFOCODE.eq("A")); 
//        newSpeisekarteTBL.addToAllergenInfoTBLs(a);
//      }
//      if(allergenB == true) { 
//        AllergenInfoTBL b = AllergenInfoTBL.fetchAllergenInfoTBL(ec, AllergenInfoTBL.ALLERGENINFOCODE.eq("B")); 
//        newSpeisekarteTBL.addToAllergenInfoTBLs(b);
//      }
//
//      if(allergenC == true) { 
//        AllergenInfoTBL c = AllergenInfoTBL.fetchAllergenInfoTBL(ec, AllergenInfoTBL.ALLERGENINFOCODE.eq("C")); 
//        newSpeisekarteTBL.addToAllergenInfoTBLs(c);
//      }
//      
//      if(allergenD == true) {
//        AllergenInfoTBL d = AllergenInfoTBL.fetchAllergenInfoTBL(ec, AllergenInfoTBL.ALLERGENINFOCODE.eq("D")); 
//        newSpeisekarteTBL.addToAllergenInfoTBLs(d);
//        }
      
      newSpeisekarteTBL.setBeschreibung(beschreibung);
      newSpeisekarteTBL.setName(name2);
      double preisdb = Double.parseDouble(preis);
      newSpeisekarteTBL.setPreis(preisdb);
      int sortorderid = Integer.parseInt(sortorder);
      newSpeisekarteTBL.setSortorder(sortorderid);

      newSpeisekarteTBL.setSprache(selectedPopUp.sprache());
      
      
    //  newSpeisekarteTBL.removeFromAllergenInfoTBLs(b);
      
//      a.addToSpeisekarteTBLs(newSpeisekarteTBL);
      
      
      
      
      log.info(">>> Datenbank Eintrag angelegt <<< {}", selectedPopUp.sprache());
      ec.saveChanges();
    }
    return goToMySelfAction();
  }

  // / Sprache Class for Dropdown
  public class Sprache {

    public Sprache(String language) {
      _sprache = language;
    }

    public void setSprache(String language) {
      _sprache = language;
    }

    public String sprache() {
      return _sprache;
    }

    private String _sprache;
  }

  public WOActionResults setGerman() {
    TBSession.session().setLanguage(ETBWLanguage.German.name());
    return goToMySelfAction();
  }

}
