package org.treasureboat.app.components;

import org.treasureboat.app.eo.BarcodeCheckTBL;
import org.treasureboat.app.eo.BarcodeRechnungTBL;
import org.treasureboat.foundation.TBFString;
import org.treasureboat.foundation.date.TBFTimestamp;
import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;

public class StatistikAustria extends TBComponent {

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

  // NOT WORKING , try to generate a NSArray with intbarcode, and count Array, if array higher als 0 , check is true
  //  public NSArray<BarcodeRechnungTBL> allBarcodeRechnungTBLs(int intbarcode) {
  //    return BarcodeRechnungTBL.fetchAllBarcodeRechnungTBLs(editingContext(), BarcodeRechnungTBL.BARCODE.eq(intbarcode));
  //  }

  public WOActionResults barcodecheck() {


    if (!TBFString.stringIsNullOrEmpty(barcode)) {
      TBFTimestamp now = new TBFTimestamp();

      int intBarCode = TBFString.digitStringAsInt(barcode);

      if (intBarCode > 0) {
        
        NSArray<BarcodeCheckTBL> barcodeChecks = BarcodeCheckTBL.fetchBarcodeCheckTBLs(editingContext(), BarcodeCheckTBL.BARCODEVALID.eq(intBarCode).and(BarcodeCheckTBL.VALID_DATE.after(now)), BarcodeCheckTBL.VALID_DATE.asc().array());
        if (barcodeChecks.count() != 0) {
//          BarcodeCheckTBL barcodeCheck = barcodeChecks.firstObject();
          @SuppressWarnings("unused")
          BarcodeRechnungTBL barcodeRechnung = BarcodeRechnungTBL.createBarcodeRechnungTBL(editingContext(), intBarCode, now.timestamp());      
          editingContext().saveChanges();
        } else {
          // show error
          
        }
      }
    }









    //     EOEditingContext ec = ERXEC.newEditingContext();
    //     BarcodeRechnungTBL newBaRechnungTBL = BarcodeRechnungTBL.createAndInsertInstance(ec);
    //     newBaRechnungTBL.setBarcode(intbarcode);
    //     newBaRechnungTBL.setScanned(timestamp());
    //    
    //     ec.saveChanges();
    //    log.info("Barcode is:" + barcode);
    //    
    //    if (barcodeReTBL(intbarcode)) { 
    //      log.info("Barcodevergleich ist TRUE");
    //    } else {
    //      log.info("Barcodevergleich ist FALSE");
    //    }

    return goToMySelfAction();
  }

  public NSTimestamp timestamp() {
    return new NSTimestamp();
  }

}
