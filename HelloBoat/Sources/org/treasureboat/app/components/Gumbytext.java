package org.treasureboat.app.components;

import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.foundation.NSArray;

public class Gumbytext extends TBComponent {

  private static final long serialVersionUID = 1L;

  //********************************************************************
  //  Constructor : コンストラクタ
  //********************************************************************
  public Gumbytext(WOContext context) {
    super(context);
  }

  //********************************************************************
  //  Methods : メソッド
  //********************************************************************
  private NSArray<Convention> _tabs;

  public Convention selectedPopUp;
  public Convention selectedTab;

  /* TAB */
  public NSArray<Convention> tabes() {
    if (_tabs == null) {
      Convention a = new Convention("AniNite", 14590);
      Convention b = new Convention("AkiCon", 3850);
      Convention c = new Convention("MangaWorld", 8200);
      _tabs = new NSArray<>(a, b, c);
    }
    return _tabs;
  }
  public Convention oneConvention; // für Repetition's

  // BEGIN Schaltjahrberechnung - Schaltjahr.java
  public String schaltjahrberechnung() {
    Schaltjahr schalt = new Schaltjahr();
    schalt.setJahreszahl(2012);
    return schalt.Jahreswert();
  }
  //END Schaltjahrberechnung - Schaltjahr.java

  //BEGIN BMI_Rechner.java

  public StringBuilder bmi() {
    Bmi_Rechner bmi = new Bmi_Rechner();
    Bmi_Rechner bmi2 = new Bmi_Rechner();
    bmi.bmi_berechnung(1, 185, 120);
    bmi2.bmi_berechnung(1, 120, 111);
    System.err.println("BMI: "+ bmi.getBmi() + " Wert: " + bmi.getWert());
    StringBuilder sb = new StringBuilder();
    sb.append(bmi.getBmi());
    sb.append("<br /> Wert:");
    sb.append(bmi.getWert());
    sb.append("<br /> BMI2: " + bmi2.getBmi());
    sb.append("<br /> Wert:");
    sb.append(bmi2.getWert());
    sb.append("<br />Ende vom BMI Stringbuilder");
    return sb;
  }

  //END BMI_Rechner.java

  //********************************************************************
  //  Actions : アクション
  //********************************************************************  
  //BEGIN Counter
  public String Counter() {

    StringBuilder sb = new StringBuilder();

    for (int  i = 0; i < g; i++) {
      counter++;
      sb.append(counter + "<br />");  
    }
    g = g+5;

    return sb.toString();
  }
  public static int g = 10;
  public int counter = 0;
  //END Counter

  //MyText : TBTextField = Beispiel Text Field 
  public String myText;

  //BEGIN Dropdown Menu Result after click Send
  public WOActionResults doSendAction() {
    String s = selectedPopUp == null ? "[null]" : selectedPopUp.convention();
    System.err.println("// MyText: " + myText +" // Auflistung: "+ s + "//");
    if (s == "AniNite") {
      Aninite nextPage = pageWithName(Aninite.class);
      nextPage.setConvention(s, myText);
      return nextPage;
    } else if (s == "AkiCon") {
      Akicon nextPage = pageWithName(Akicon.class);
      nextPage.setConvention(s);
      nextPage.setRandomtext(myText);
      return nextPage;
    }

    return goToMySelfAction();
  }
  //END Dropdown Menu Result after click Send

  // BMI Berechnung BEGIN

  public WOActionResults doBMIAction() {
    log.info("doBMIAction wurde aufgerufen." + getGeschlecht() + getGroesse() + gewicht);
    Gumbytext nextPage = pageWithName(Gumbytext.class);
    nextPage.setGewicht(gewicht);
    nextPage.setGeschlecht(geschlecht);
    nextPage.setGroesse(groesse);
    return nextPage;
  }
  //BMI Berechnung END

  public WOActionResults doSampleAction() {

    return goToMySelfAction();
  }

  public WOActionResults doTabAction() {
    log.info("doTabAction wurde aufgerufen.");
    return goToMySelfAction();
  }

  //********************************************************************
  //  Convention Class
  //********************************************************************

  public class Convention {

    public Convention(String convention, int besucherzahlen) {
      _convention = convention;
      _besucherzahlen = besucherzahlen;
    }

    public void setConvention(String convention) {
      _convention = convention;
    }

    public String convention() {
      return _convention;
    }

    private String _convention;

    public void setBesucherzahlen(int besucherzahlen) {
      _besucherzahlen = besucherzahlen;
    }

    public int besucherzahlen() {
      return _besucherzahlen;
    }

    private int _besucherzahlen;

  }

  // GET & SET FOR BMI
  public String getGewicht() {
    return gewicht;
  }

  public void setGewicht(String gewicht) {
    this.gewicht = gewicht;
  }

  private String gewicht;

  public String getGeschlecht() {
    return geschlecht;
  }

  public void setGeschlecht(String geschlecht) {
    this.geschlecht = geschlecht;
  }

  private String geschlecht;

  public String getGroesse() {
    return groesse;
  }

  public void setGroesse(String groesse) {
    this.groesse = groesse;
  }  
  private String groesse;

}