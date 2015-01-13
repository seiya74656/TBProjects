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

    setWert(geschlecht, bmi);
  }
  private float bmi;

  public String getWert() {
    return wert;
  }

  public void setWert(int geschlecht, float bmi) {
    if (geschlecht == 1){ if ( bmi < 19 ){
      wert = "Untergewicht"; } else {
        if ( bmi < 29 ){
          wert = "Normalgewicht";
        } else {
          wert = "Uebergewicht"; }
      } }else {
        if ( bmi < 20 ){
          wert = "Untergewicht";
        } else {
          if ( bmi < 28 ){
            wert = "Normalgewicht"; } else {
              wert = "Uebergewicht"; }
        } }
    if ( bmi > 30 ){
      wert = "Dieses Gewicht ist behandlungsbeduerftig!"; }
  }


  private String wert;
}