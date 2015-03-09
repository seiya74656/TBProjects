package org.treasureboat.app.components;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOActionResults;

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
    log.info("Barcode is:" + barcode);
    return goToMySelfAction();
  }

}
