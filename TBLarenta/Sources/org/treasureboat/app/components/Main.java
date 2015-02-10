package org.treasureboat.app.components;


import org.treasureboat.app.eo.SpeisekarteTBL;
import org.treasureboat.foundation.TBFString;
import org.treasureboat.webcore.annotations.TBPageAccess;
import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.eof.ERXEC;

@TBPageAccess (
    navigationState = "Welcome"
    )
public class Main extends TBComponent {

	private static final long serialVersionUID = 1L;

	//********************************************************************
	//  Constructor : コンストラクタ
	//********************************************************************

	public Main(WOContext context) {
		super(context);
	}


  // ********************************************************************
  // Methods : メソッド
  // ********************************************************************

	public String beschreibung;
	public String name2;
	public String preis;
	
	// ********************************************************************
  // Actions : アクション
  // ********************************************************************
  
	private NSArray<Sprache> _tabs;
  public Sprache selectedPopUp;

	public NSArray<Sprache> tabes() {
	  if(_tabs ==null) {
	  Sprache a = new Sprache("Deutsch");
	  Sprache b = new Sprache("Englisch");
	  _tabs = new NSArray<>(a,b);	 
	  }
	  return _tabs;	  
	}
	
	public Sprache oneSprache;

	public WOActionResults doMenu() {
	  System.err.println("called doMenu");
	  return goToMySelfAction();
	}
	
	public WOActionResults doCreateEntry() {
	  if (TBFString.stringIsNullOrEmpty(beschreibung) || TBFString.stringIsNullOrEmpty(preis) || TBFString.stringIsNullOrEmpty(name2)) {
	    
	  } else {
	  //Clean Editting Context
	  EOEditingContext ec = ERXEC.newEditingContext();
	  
	  SpeisekarteTBL newSpeisekarteTBL = SpeisekarteTBL.createAndInsertInstance(ec);
	  newSpeisekarteTBL.setBeschreibung(beschreibung);
	  newSpeisekarteTBL.setName(name2);
	  double preisdb = Double.parseDouble(preis);

	  newSpeisekarteTBL.setPreis(preisdb);
	  newSpeisekarteTBL.setSprache(selectedPopUp.sprache());
	  log.info(">>> Datenbank Eintrag angelegt <<< {}", selectedPopUp.sprache());
    ec.saveChanges();
		}
    return goToMySelfAction();
	}
/// Sprache Class for Dropdown
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

}
