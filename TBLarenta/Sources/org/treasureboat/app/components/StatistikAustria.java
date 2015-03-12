package org.treasureboat.app.components;

import org.treasureboat.app.eo.BarcodeRechnungTBL;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOActionResults;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.eof.ERXEC;

public class StatistikAustria extends Main {

  /**
   * For Barcode Scanner via iPhone WebApp
   */
  private static final long serialVersionUID = 1L;

  public String barcode;

  public StatistikAustria(WOContext context) {
    super(context);
  }

  public boolean barcodeReTBL(int intbarcode) {

    BarcodeRechnungTBL testb = BarcodeRechnungTBL.fetchBarcodeRechnungTBL(editingContext(), BarcodeRechnungTBL.BARCODE.eq(intbarcode));
    
    final String ObjecttoString = testb.toString(); // Wandelt die Aufgabe in einen String um , um mit parseInt zu convertieren
    
    Integer testcode = Integer.parseInt(ObjecttoString); //Convertiert den String in Int
    if (testcode.equals(intbarcode)) { //vergleicht ob der Integer mit der eingangs intbarcode überein stimmt
      return true;
    } else {
      return false;
    }
  }
  
  public WOActionResults barcodecheck() {
    
     EOEditingContext ec = ERXEC.newEditingContext();
     BarcodeRechnungTBL newBaRechnungTBL = BarcodeRechnungTBL.createAndInsertInstance(ec);
     int intbarcode = Integer.parseInt(barcode);
     newBaRechnungTBL.setBarcode(intbarcode);
     newBaRechnungTBL.setScanned(timestamp());
    
     ec.saveChanges();
    log.info("Barcode is:" + barcode);
    
    if (barcodeReTBL(intbarcode)) { 
      log.info("Barcodevergleich ist TRUE");
    } else {
      log.info("Barcodevergleich ist FALSE");
    }
    
    return goToMySelfAction();
  }

  public NSTimestamp timestamp() {
    return new NSTimestamp();
  }

}
