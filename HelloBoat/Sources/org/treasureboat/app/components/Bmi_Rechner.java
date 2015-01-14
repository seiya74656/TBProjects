package org.treasureboat.app.components;

public class Bmi_Rechner  {

  public Bmi_Rechner() {
    super();

    // bmi = 50;
  }

  public Bmi_Rechner(int geschlecht, int groesse, int gewicht) {
    // this(); Ruft den Main Constructor auf , und führt dann den Code unterhalb aus. Da super() schon im Main Constructor inizialisiert wird.
    this(); 

    bmi_berechnung(geschlecht, groesse, gewicht);
  }

  public void bmi_berechnung(int geschlecht, int groesse, int gewicht) {
    bmi =  (gewicht * 10000 / (groesse * groesse));

    setWert(geschlecht, bmi);
  }

  public float bmi() {
    return bmi;
  }

  private float bmi = 0;


  public String wert() {
    return wert;
  }

  private String wert;


  private void setWert(int geschlecht, float bmi) {

    if (geschlecht == 1) {
      if ( bmi < 19 ) {
        wert = "Untergewicht"; 
      } else if ( bmi < 29 ) {
        wert = "Normalgewicht";
      } else {
        wert = "Uebergewicht"; 
      }

    } else {
      if ( bmi < 20 ) {
        wert = "Untergewicht";
      } else if ( bmi < 28 ) {
        wert = "Normalgewicht"; 
      } else {
        wert = "Uebergewicht";
      }
    }

    if ( bmi > 30 ){
      wert = "Dieses Gewicht ist behandlungsbeduerftig!";
    }
  }

}