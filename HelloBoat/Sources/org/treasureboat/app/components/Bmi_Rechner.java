package org.treasureboat.app.components;

public class Bmi_Rechner  {

  public Bmi_Rechner() {
    super();
  }

  public float getBmi() {
    return bmi;
  }

  public void bmi_berechnung(int geschlecht, int groesse, int gewicht) {
    bmi =  (gewicht * 10000 / (groesse * groesse));
    
    if (geschlecht == 1){ if ( bmi < 19 ){
      System.err.println( "Untergewicht"); } else {
      if ( bmi < 29 ){
        System.err.println( "Normalgewicht" );
      } else {
        System.err.println( "Uebergewicht" ); }
      } }else {
      if ( bmi < 20 ){
        System.err.println( "Untergewicht" );
      } else {
      if ( bmi < 28 ){
        System.err.println( "Normalgewicht"); } else {
          System.err.println( "Uebergewicht" ); }
      } }
      if ( bmi > 30 ){
        System.err.println( "Dieses Gewicht ist behandlungsbeduerftig!" ); }
  }
  private float bmi;

  public String getWert() {
    return wert;
  }

  public void setWert(String wert) {
    this.wert = wert;
  }

  
  private String wert;
}