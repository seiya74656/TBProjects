package org.treasureboat.app.components;

import org.treasureboat.app.businesslogic.Schaltjahr;
import org.treasureboat.foundation.TBFString;
import org.treasureboat.foundation.TBFV;
import org.treasureboat.webcore.appserver.TBContext;
import org.treasureboat.webcore.appserver.iface.ITBWActionResults;
import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.foundation.NSArray;

public class Gumbytext extends TBComponent implements SampleInterface {

  private static final long serialVersionUID = 1L;

  //********************************************************************
  //  Constructor : コンストラクタ
  //********************************************************************
  public Gumbytext(TBContext context) throws Exception {
    super(context);
    Zeitungsabo("Java Magazin", "Jahresabo");
    Program();
  }
  //********************************************************************
  //  Methods : メソッド
  //********************************************************************

  public Convention selectedPopUp;
  public Convention selectedTab;

  private NSArray<Convention> _tabs;
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

  //BEGIN Test eines StringBuilder mit dem BMI_Rechner.java

  public StringBuilder bmi() {
    StringBuilder sb = new StringBuilder();
/*  Bmi_Rechner bmi = new Bmi_Rechner();
    Bmi_Rechner bmi2 = new Bmi_Rechner();
    bmi.bmi_berechnung(1, 185, 120);
    bmi2.bmi_berechnung(1, 120, 111);
    System.err.println("BMI: "+ bmi.getBmi() + " Wert: " + bmi.getWert());
    sb.append(bmi.getBmi());
    sb.append("<br /> Wert:");
    sb.append(bmi.getWert());
    sb.append("<br /> BMI2: " + bmi2.getBmi());
    sb.append("<br /> Wert:");
    sb.append(bmi2.getWert());
    sb.append("<br />Ende vom BMI Stringbuilder");
*/
    return sb;
  } 

  //END BMI_Rechner.java

  //********************************************************************
  //  Actions : アクション
  //********************************************************************  
  
  //BEGIN Counter
  
  public String counter() {
    return counter(10);
  }
  
  public String counter(int max) {
    int counter = 0;
    
    StringBuilder sb = new StringBuilder();

    for (int  i = 0; i < max; i++) {
      counter++;
      sb.append(counter + "<br />");  
    }
    max = max + 5;

    return sb.toString();
  }
 
  //END Counter

  
  
  
  //MyText : TBTextField = Beispiel Text Field 
  public String myText;

  //BEGIN Dropdown Menu Result after click Send
  public ITBWActionResults doSendAction() {
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

  public ITBWActionResults doCaesarAction() {
    caesarAus = new Caesar(verschluesselungsstring, 1);
    return goToMySelfAction();
  }
  public Caesar caesarAus;

  // BMI Berechnung BEGIN

  public ITBWActionResults doBMIAction() {
//    Nach dem "doBMIAction" anklicken, sollten am besten gleich alle Werte abgefragt werden um fehler zu vermeinden.
//    Die TBFString.stringIsNullorEmpty() Methode prüft alle möglichen Variationen ob ein String "null" oder 0 ist. 
    if (TBFString.stringIsNullOrEmpty(geschlecht) || TBFString.stringIsNullOrEmpty(groesse) || TBFString.stringIsNullOrEmpty(gewicht)) {
      // no data do Nothing
    } else {
//    {} ist wie printf, Vorteil mit dieser schreibweise ist, wenn ein feld Leer ist , wird nichts zurückgegeben, und kein error generiert.
      log.info("doBMIAction wurde aufgerufen. {}, {}, {}", geschlecht, groesse, gewicht);

//    Übergibt alle Werte gleich an den Constructor, welcher automatisch die funktion aufruft.
//    mit TBFV.intValue() können werte umgewandeltwerden, die Methode führt dabei gleich mehrere Checks durch.
//    Browser übermitteln die Daten als String, weshalb Sie für die Berechnung zu einem anderen Value umgewandelt werden müssen. (Beispiel int)
      myBMIRechner = new Bmi_Rechner(TBFV.intValue(geschlecht), TBFV.intValue(groesse), TBFV.intValue(gewicht));
//      Weitere Möglichkeit den BMI_Rechner zu benutzen, mit getrennten Constructor, Methoden.
//      Bmi_Rechner bmi5 = new Bmi_Rechner();
//      bmi5.bmi_berechnung(TBFV.intValue(geschlecht), TBFV.intValue(groesse), TBFV.intValue(gewicht));
    }
//        Wäre auch richtig. Ist aber nicht nötig wenn man sich selbst aufruft. Sofern man eine Weitere Page aufruft ist dies die Richtige wahl.
//        Gumbytext nextPage = pageWithName(Gumbytext.class);
//        nextPage.setGewicht(gewicht);
//        nextPage.setGeschlecht(geschlecht);
//        nextPage.setGroesse(groesse);

//  return context().page(); <- macht das selbe wie goToMySelfAction();
    return goToMySelfAction();
  }
  // Wird als Getter benutzt, womit man dann auf die Get Methoden über das HTML zugreiffen kann. Beispiel: $myBMIRechner.wert
  public Bmi_Rechner myBMIRechner;

  
  
  
  //BMI Berechnung END

  public ITBWActionResults doSampleAction() {

    return goToMySelfAction();
  }

  public ITBWActionResults doTabAction() {
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

  // GET & SET FOR BMI NICHT NOTWENDIG , DA DIESE NICHT WEITER VERWENDET WERDEN, UND NUR AUSGEGEBEN WERDEN.
  // public damit die Bmi_Rechner Klasse darauf zugreiffen kann.

  public String gewicht;
  public String geschlecht;
  public String groesse;
  public String verschluesselungsstring;

  @Override
  public void Zeitungsabo(String Zeitung, String Abo) {
    log.info("Zeitungsabo:" + Abo + Zeitung);
    
  }
  
// Geschwindigkeitsvergleich zwischen Interface und direkt Aufruf.
  class Perl implements Tester {
    public void test(int value) throws Exception {
  // Some useless logic.
  if (value < 0) {
      throw new Exception();
  }
    }
  }

    public void Program() throws Exception {

  Tester test = new Perl();
  Perl perl = (Perl) test;

  long t1 = System.currentTimeMillis();

  // ... Version 1: Aufruf über das Interface.
  for (int i = 0; i < 10000000; i++) {
      test.test(i);
  }

  long t2 = System.currentTimeMillis();

  // ... Version 2: direkter Aufruf der Perl Klasse.
  for (int i = 0; i < 10000000; i++) {
      perl.test(i);
  }

  long t3 = System.currentTimeMillis();

  // ... Times.
  System.out.println(t2 - t1 + " ms (Interface Method)");
  System.out.println(t3 - t2 + " ms (Direkter Aufruf)");
    }
}

