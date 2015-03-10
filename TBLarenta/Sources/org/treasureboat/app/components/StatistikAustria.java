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

  public WOActionResults barcodecheck() {

     EOEditingContext ec = ERXEC.newEditingContext();
     BarcodeRechnungTBL newBaRechnungTBL = BarcodeRechnungTBL.createAndInsertInstance(ec);
     int intbarcode = Integer.parseInt(barcode);
     newBaRechnungTBL.setBarcode(intbarcode);
     newBaRechnungTBL.setScanned(timestamp());
    
     ec.saveChanges();
    log.info("Barcode is:" + barcode);
    return goToMySelfAction();
  }

  public NSTimestamp timestamp() {
    return new NSTimestamp();
  }

}
