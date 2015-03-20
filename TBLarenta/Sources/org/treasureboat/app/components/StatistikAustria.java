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

  public WOActionResults barcodecheck() {


    if (!TBFString.stringIsNullOrEmpty(barcode)) {
      TBFTimestamp now = new TBFTimestamp();

      int intBarCode = TBFString.digitStringAsInt(barcode);

      if (intBarCode > 0) {
        
        BarcodeCheckTBL barcodeCheck = BarcodeCheckTBL.fetchBarcodeCheckTBL(editingContext(), BarcodeCheckTBL.BARCODEVALID.eq(intBarCode).and(BarcodeCheckTBL.VALID_DATE.after(now)));
        NSArray<BarcodeCheckTBL> barcodeChecks = BarcodeCheckTBL.fetchBarcodeCheckTBLs(editingContext(), BarcodeCheckTBL.BARCODEVALID.eq(intBarCode).and(BarcodeCheckTBL.VALID_DATE.after(now)), BarcodeCheckTBL.VALID_DATE.asc().array());
        if (barcodeChecks.count() != 0) {
//          BarcodeCheckTBL barcodeCheck = barcodeChecks.firstObject();

          log.info(barcodeCheck.barcodevalid().toString() + barcodeChecks.firstObject());
          
          @SuppressWarnings("unused")
          BarcodeRechnungTBL barcodeRechnung = BarcodeRechnungTBL.createBarcodeRechnungTBL(editingContext(), intBarCode, now.timestamp());      
//          editingContext().saveChanges();
        } else {
          // show error
          
        }
      }
    }

    //     EOEditingContext ec = ERXEC.newEditingContext();
    //     BarcodeRechnungTBL newBaRechnungTBL = BarcodeRechnungTBL.createAndInsertInstance(ec);
    //     newBaRechnungTBL.setBarcode(intbarcode);
    //     newBaRechnungTBL.setScanned(timestamp());

    return goToMySelfAction();
  }


}
