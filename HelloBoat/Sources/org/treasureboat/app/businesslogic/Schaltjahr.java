package org.treasureboat.app.components;


public class Schaltjahr {  

  public Schaltjahr() {
    super();
  }

  public int Jahreszahl() {
    return jahreszahl;
  }

  public void setJahreszahl(int jahreszahl) {
    this.jahreszahl = jahreszahl;

    if ( jahreszahl % 4 == 0 ){
      if ( jahreszahl % 100 == 0 ){
        if ( jahreszahl % 400 == 0 ){
          setJahreswert(( "" + jahreszahl + " ist ein Schaltjahr!")); }
        else {
          setJahreswert(( "" + jahreszahl + " ist kein Schaltjahr!")); }
      }
      else {
        setJahreswert(( "" + jahreszahl + " ist ein Schaltjahr!")); }
    }
    else {
      setJahreswert(("" + jahreszahl + " ist kein Schaltjahr!"));
    }
  }

  private int jahreszahl;

  public String Jahreswert() {
    return jahreswert;
  }

  public void setJahreswert(String jahreswert) {
    this.jahreswert = jahreswert;
  }

  private String jahreswert;

}
