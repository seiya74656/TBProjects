//
// BarcodeRechnungTBL.java
//
// version 7.1.3
//
// 2008-2014 by TreasureBoat.org
//
package org.treasureboat.app.eo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSValidation;

/**
 * This is the EO class for BarcodeRechnungTBL
 * before using it check all 'TO-DO' items first to improve and make an happy Application
 * wish you happy Developing with WOdka
 * 
 * Homepage :
 *    http://www.treasureboat.org/
 * Google +
 *    https://plus.google.com/u/0/b/107993064404748333102/107993064404748333102/about
 */
public class BarcodeRechnungTBL extends _BarcodeRechnungTBL
/*
implements 
ITBEnterpriseStampedEnterpriseObject // TODO StampedEnterpriseObject Support
*/
{

  private static final long serialVersionUID = 1L;

  /** 
   * <a href="http://wiki.wocommunity.org/display/documentation/Wonder+Logging">new org.slf4j.Logger</a> 
   */
  static final Logger log = LoggerFactory.getLogger(BarcodeRechnungTBL.class);
  
  //********************************************************************
  //  Properties : プロパティ
  //********************************************************************

  //********************************************************************
  //  clazz methods
  //********************************************************************

  public static final BarcodeRechnungTBLClazz<BarcodeRechnungTBL> clazz = new BarcodeRechnungTBLClazz<BarcodeRechnungTBL>();
  public static class BarcodeRechnungTBLClazz<T extends BarcodeRechnungTBL> extends _BarcodeRechnungTBL._BarcodeRechnungTBLClazz<T>
  /*
  implements 
  ITBEnterpriseVirtualDeleteSupport, // TODO Virtual Delete Support
  ITBWMultiDomainSupport,  // TODO Multi Domain Support
  ITBWSharedDomain,  // TODO Shared Domain Support
  ITBRuleEngineEntitySupport // TODO Rule Engine Support
  */
  {
      /* more clazz methods here */
   
    /* ITBWMultiDomainSupport */
    //    @Override
    //    public ERXKey<?> keyForDomain() {
    //      return null; // TODO return the releationship to Domain
    //    }

    /* ITBWSharedDomain */
    //    @Override
    //    public ERXKey<?> keyForSharedDomain() {
    //      return null; // TODO return the attribute for support the Shared Domain
    //    }
  }

  //********************************************************************
  //  setup configuration : セットアップ定義
  //********************************************************************

  @Override
  protected boolean useCoreQualifierForToManyRelationships() {
   return false;
  }
 
  //********************************************************************
  //  Initializes the EO. This is called when an EO is created, not when it is 
  //  inserted into an EC. This is the "best practice" method to place default EO initial
  //  values
  //********************************************************************  
  
  @Override
  public void init(EOEditingContext anEditingContext) {
    super.init(anEditingContext);
    
    // From Here : ここより書き込む
  }
  
  //********************************************************************
  //  Enterprise Object Override : エンタプライス・オブジェクトのオーバライド
  //********************************************************************

  @Override
  public void willInsert() {
    super.willInsert();

    // From Here : ここより書き込む
  }

  @Override
  public void didInsert() {
    super.didInsert();
  
    // From Here : ここより書き込む
  }
  
  @Override
  public void willUpdate() {
    super.willUpdate();
  
    // From Here : ここより書き込む
  }
  
  @Override
  public void didUpdate() {
    super.didUpdate();
  
    // From Here : ここより書き込む
  }
  
  @Override
  public void mightDelete() {
    super.mightDelete();
  
    // From Here : ここより書き込む
  }
  
  @Override
  public void willDelete() throws NSValidation.ValidationException {
    super.willDelete();
  
    // From Here : ここより書き込む
  }

  @Override
  public void didDelete(EOEditingContext editingContext) {  
    super.didDelete(editingContext);
  
    // From Here : ここより書き込む
  }
  
  //@Override
  //public void objectDidDeleteOrRemoveFromReleationship() {
  // super call not need
  // From Here : ここより書き込む
  //}

  //********************************************************************
  //  Database Custom Object : データベース・カスタム・オブジェクト用
  //********************************************************************

  //********************************************************************
  //  Validation : 検証ロジック
  //********************************************************************

  //********************************************************************
  //  Business Logic : ビジネス・ロジック
  //********************************************************************
}
