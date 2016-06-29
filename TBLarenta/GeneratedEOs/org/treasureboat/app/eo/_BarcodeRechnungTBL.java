//
// _BarcodeRechnungTBL.java
//
// DO NOT EDIT. 
// Make changes to BarcodeRechnungTBL.java instead.
//
// version 8.4
//
// 2008-2016 by TreasureBoat.org
//

/*
 * The following List is for Localization :
 * ----------------------------------------

  "Pages.QueryBarcodeRechnungTBL" = "Query BarcodeRechnungTBL";
  "Pages.ListBarcodeRechnungTBL" = "List BarcodeRechnungTBL";
  "Pages.InspectBarcodeRechnungTBL" = "Inspect BarcodeRechnungTBL";
  "Pages.EditBarcodeRechnungTBL" = "Edit BarcodeRechnungTBL";
  "Pages.CreateBarcodeRechnungTBL" = "Create BarcodeRechnungTBL";
  
  "Pages.QueryEmbeddedBarcodeRechnungTBL" = "Query Embedded BarcodeRechnungTBL";
  "Pages.ListEmbeddedBarcodeRechnungTBL" = "List Embedded BarcodeRechnungTBL";
  "Pages.InspectEmbeddedBarcodeRechnungTBL" = "Inspect Embedded BarcodeRechnungTBL";
  "Pages.EditEmbeddedBarcodeRechnungTBL" = "Edit Embedded BarcodeRechnungTBL";
  "Pages.CreateEmbeddedBarcodeRechnungTBL" = "Create Embedded BarcodeRechnungTBL";

  "PropertyKey.BarcodeRechnungTBL.barcode" = "barcode";
  "PropertyKey.BarcodeRechnungTBL.scanned" = "scanned";

 * ----------------------------------------
 */

/*
 * The following List is for D2W/D3W :
 * ----------------------------------------

  // D2W

  300 : entity.name = 'BarcodeRechnungTBL' => isEntityEditable = "true" [com.webobjects.directtoweb.BooleanAssignment]

  100 : pageConfiguration like '*BarcodeRechnungTBL' => navigationState = "XX.xx" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'CreateBarcodeRechnungTBL' => navigationState = "XX.xx.createBarcodeRechnungTBL" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'QueryBarcodeRechnungTBL' => navigationState = "XX.xx.queryBarcodeRechnungTBL" [com.webobjects.directtoweb.Assignment]
  
  401 : pageConfiguration = 'QueryBarcodeRechnungTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "barcode" , "scanned"  ) [com.webobjects.directtoweb.Assignment] 
  402 : pageConfiguration = 'ListBarcodeRechnungTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "barcode" , "scanned"  ) [com.webobjects.directtoweb.Assignment] 
  403 : pageConfiguration = 'InspectBarcodeRechnungTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "barcode" , "scanned"  ) [com.webobjects.directtoweb.Assignment] 
  404 : pageConfiguration = 'EditBarcodeRechnungTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "barcode" , "scanned"  ) [com.webobjects.directtoweb.Assignment] 
  405 : pageConfiguration = 'CreateBarcodeRechnungTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "barcode" , "scanned"  ) [com.webobjects.directtoweb.Assignment] 
   
  // D3W

  200 : EN = '#' => crud = "0100" [com.webobjects.directtoweb.Assignment]
  600 : PC = 'EditRelationshipEmbedded#' => cruds = "00001" [com.webobjects.directtoweb.Assignment]
  
  401 : PC = 'Query#' => DPK = ("[MainTab]", "(MainSection)", "barcode", "scanned") [com.webobjects.directtoweb.Assignment] 
  402 : PC = 'List#' => DPK = ("[MainTab]", "(MainSection)", "barcode", "scanned") [com.webobjects.directtoweb.Assignment] 
  403 : PC = 'Inspect#' => DPK = ("[MainTab]", "(MainSection)", "barcode", "scanned") [com.webobjects.directtoweb.Assignment] 
  404 : PC = 'Edit#' => DPK = ("[MainTab]", "(MainSection)", "barcode", "scanned") [com.webobjects.directtoweb.Assignment] 
  405 : PC = 'Create#' => DPK = ("[MainTab]", "(MainSection)", "barcode", "scanned") [com.webobjects.directtoweb.Assignment] 

 * ----------------------------------------
 */

package org.treasureboat.app.eo;

import org.treasureboat.app.eo.BarcodeRechnungTBL;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.treasureboat.enterprise.eof.TBEOExternalPrimaryKeyHelper;
import org.treasureboat.enterprise.eof.TBEOGenericRecord;
import org.treasureboat.enterprise.eof.delete.ITBEnterpriseVirtualDeleteSupport;
import org.treasureboat.foundation.NSData;
import org.treasureboat.enterprise.qualifiers.TBEnterpriseAndQualifier;
import org.treasureboat.foundation.crypting.TBFCrypto;
import org.treasureboat.webcore.appserver.TBSession;
import org.treasureboat.webcore.concurrency.TBWConcurrencyUtilities;
import org.treasureboat.webcore.override.core.TBWCoreQualifierBase;
import org.treasureboat.webcore.security.domain.ITBWDomain;
import org.treasureboat.webcore.security.domain.TBWMultiDomainSupport;
import org.treasureboat.webcore.security.grant.TBWGrantAccess;
import org.treasureboat.webcore.security.password.TBWAccessPermission;

// Logic : TBEnterpriseCopyable
// Logic : TBTag
// Logic : ITBEnterpriseStampedEnterpriseObject Support
// Final Logic

// Imports
import com.webobjects.eoaccess.TBEntity;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

import er.extensions.eof.ERXEOAccessUtilities;
import er.extensions.eof.ERXFetchSpecification;
import er.extensions.eof.ERXGenericRecord;
import er.extensions.eof.ERXKey;
import er.extensions.eof.ERXKeyGlobalID;
import er.extensions.validation.ERXValidationException;

@SuppressWarnings("all")
public abstract class _BarcodeRechnungTBL extends  TBEOGenericRecord  {

  private static final long serialVersionUID = 1L;

  /** 
   * <a href="http://wiki.wocommunity.org/display/documentation/Wonder+Logging">new org.slf4j.Logger</a> 
   */
  static final Logger log = LoggerFactory.getLogger(BarcodeRechnungTBL.class);

  //********************************************************************
  //  Constructor : コンストラクター
  //********************************************************************

  public _BarcodeRechnungTBL() {
    super();
    
    addFetchSpecificationToEntity();
  }

  //********************************************************************
  //  D2W Fetchspecification : D2W 用フェッチ・スペシフィケーション
  //********************************************************************

  /** 
   * add FetchSpecifications that are coming from the EO Model
   * 
   * エンティティにフェッチ・スペシフィケーションを追加バインディングします 
   */
  public void addFetchSpecificationToEntity() {
    if(_addFetchSpecificationToEntity == null) {
      addFetchSpecification();
      _addFetchSpecificationToEntity = Boolean.TRUE;
    }
  }
  private static Boolean _addFetchSpecificationToEntity = null;
  
  protected void addFetchSpecification() {}
  
  //********************************************************************
  //  setup configuration : セットアップ定義
  //********************************************************************

  protected boolean useCoreQualifierForToManyRelationships() {
   return false;
  }
 
  //********************************************************************
  //  Entity : エンティティ
  //********************************************************************
  
  /** Entity Name = BarcodeRechnungTBL */
  public static final String ENTITY_NAME = "BarcodeRechnungTBL";

  //********************************************************************
  //  Access Properties : アクセス・プロパティ
  //********************************************************************
  
  protected static String ACCSESS_CREATE = "BarcodeRechnungTBL.create";
  protected static String ACCSESS_READ = "BarcodeRechnungTBL.read";
  protected static String ACCSESS_UPDATE = "BarcodeRechnungTBL.update";
  protected static String ACCSESS_DELETE = "BarcodeRechnungTBL.delete";

  /**
   * you can override, TBWGrantAccess or use the role system
   * 
   * @return true if it allowed to create Data
   */
  public static boolean canCreate() {
    // Check Grant for Batch Processing
    if(TBWGrantAccess.isEntityGrantForCreate(ENTITY_NAME)) {
      return true;
    }
    return TBWAccessPermission.instance().can(ACCSESS_CREATE);
  }

  /**
   * you can override or use the role system
   * 
   * @return true if it allowed to read Data
   */
  public boolean canRead() {
    return TBWAccessPermission.instance().can(ACCSESS_READ);
  }
  
  /** 
   * you can override, TBWGrantAccess or use the role system
   * 
   * @return true if it allowed to update Data
   */
  @Override
  public boolean canUpdate() {
    // Check Grant for Batch Processing
    if(TBWGrantAccess.isEntityGrantForUpdate(ENTITY_NAME)) {
      return true;
    }
    return TBWAccessPermission.instance().can(ACCSESS_UPDATE);
  }
  
  /** 
   * you can override, TBWGrantAccess or use the role system
   * 
   * @return true if it allowed to delete Data
   */
  @Override
  public boolean canDelete() {
    // Check Grant for Batch Processing
    if(TBWGrantAccess.isEntityGrantForDelete(ENTITY_NAME)) {
      return true;
    } 
    return TBWAccessPermission.instance().can(ACCSESS_DELETE);
  }

  //********************************************************************
  //  Attribute : アトリビュート
  //********************************************************************

  // Attribute Keys
  public static final ERXKey<Integer> BARCODE = new ERXKey<Integer>("barcode");
  public static final ERXKey<NSTimestamp> SCANNED = new ERXKey<NSTimestamp>("scanned");

  // Attributes
  public static final String BARCODE_KEY = BARCODE.key();
  public static final String SCANNED_KEY = SCANNED.key();

  //********************************************************************
  //  Relationship : リレーションシップ
  //********************************************************************

  // Relationship Keys

  // Relationships

  //********************************************************************
  //  clazz methods : クラス・メソッド
  //********************************************************************

  public static class _BarcodeRechnungTBLClazz<T extends BarcodeRechnungTBL> extends ERXGenericRecord.ERXGenericRecordClazz<T> {
    /* more clazz methods here */
  }

	public BarcodeRechnungTBL.BarcodeRechnungTBLClazz clazz() {
    return BarcodeRechnungTBL.clazz;
  }

  //********************************************************************
  //  Enterprise Object Override : エンタプライス・オブジェクトのオーバライド
  //********************************************************************

  @Override
  public void willDelete() throws NSValidation.ValidationException {
    super.willDelete();
  }

  //********************************************************************
  //  Attribute Accessor : アトリビュート・アクセス
  //********************************************************************

  public Integer barcode() {
    return (Integer) storedValueForKey(BARCODE_KEY);
  }

  public void setBarcode(Integer value) {
    if (_BarcodeRechnungTBL.log.isDebugEnabled()) {
      _BarcodeRechnungTBL.log.debug("updating barcode from {} to {}", barcode(), value);
    }
    takeStoredValueForKey(value, BARCODE_KEY);
  }

  public Object validateBarcode(Object value) throws NSValidation.ValidationException {
    _BarcodeRechnungTBL.log.debug("validate barcode");
    return ERXValidationException.validateForUserInfo(this, BARCODE_KEY, value);
  }

  public NSTimestamp scanned() {
    return (NSTimestamp) storedValueForKey(SCANNED_KEY);
  }

  public void setScanned(NSTimestamp value) {
    if (_BarcodeRechnungTBL.log.isDebugEnabled()) {
      _BarcodeRechnungTBL.log.debug("updating scanned from {} to {}", scanned(), value);
    }
    takeStoredValueForKey(value, SCANNED_KEY);
  }

  public Object validateScanned(Object value) throws NSValidation.ValidationException {
    _BarcodeRechnungTBL.log.debug("validate scanned");
    return ERXValidationException.validateForUserInfo(this, SCANNED_KEY, value);
  }

  //********************************************************************
  //  ToOne relationship : ToOne リレーションシップ
  //********************************************************************

  //********************************************************************
  //  Editing Context replacement : 編集コンテキスト入れ替え
  //********************************************************************

  @Override
  public BarcodeRechnungTBL localInstanceIn(EOEditingContext editingContext) {
    BarcodeRechnungTBL localInstance = (BarcodeRechnungTBL)EOUtilities.localInstanceOfObject(editingContext, this);
      if (localInstance == null) {
        throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
      }
      return localInstance;
  }

  //********************************************************************
  //  toMany relationship : toMany リレーションシップ
  //********************************************************************

  //********************************************************************
  //  Instance : インスタンス化
  //********************************************************************

  public static BarcodeRechnungTBL createBarcodeRechnungTBL(EOEditingContext editingContext
   , Integer barcode
   , NSTimestamp scanned
    )
  {
    BarcodeRechnungTBL eo = (BarcodeRechnungTBL) EOUtilities.createAndInsertInstance(editingContext, _BarcodeRechnungTBL.ENTITY_NAME);
    eo.setBarcode(barcode);
    eo.setScanned(scanned);
    return eo;
  }
  
  /* EO creation with Stamped EO Support */
  public static BarcodeRechnungTBL createBarcodeRechnungTBLWithStampedSupport(EOEditingContext editingContext
   , Integer barcode
   , NSTimestamp scanned
    )
  {
    BarcodeRechnungTBL eo = (BarcodeRechnungTBL) EOUtilities.createAndInsertInstance(editingContext, _BarcodeRechnungTBL.ENTITY_NAME);
    eo.setBarcode(barcode);
    eo.setScanned(scanned);
    return eo;
  }

  public static BarcodeRechnungTBL createAndInsertInstance(EOEditingContext context) {
    log.debug("{} : createAndInsertInstance", ENTITY_NAME);
    
    return (BarcodeRechnungTBL)EOUtilities.createAndInsertInstance(context, ENTITY_NAME);
  }

  // ========== [検索関連] ==========
  //********************************************************************
  //  Fetch (NSArray) : フェッチ (NSArray)
  //********************************************************************

  public static ERXFetchSpecification<BarcodeRechnungTBL> fetchSpec() {
    return new ERXFetchSpecification<BarcodeRechnungTBL>(_BarcodeRechnungTBL.ENTITY_NAME, null, null, false, true, null);
  }

  /* 
   * standard fetch 
   */
  public static NSArray<BarcodeRechnungTBL> fetchAllBarcodeRechnungTBLs(EOEditingContext editingContext) {
    return _BarcodeRechnungTBL.fetchAllBarcodeRechnungTBLs(editingContext, null);
  }

  public static NSArray<BarcodeRechnungTBL> fetchAllBarcodeRechnungTBLs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _BarcodeRechnungTBL.fetchBarcodeRechnungTBLs(editingContext, null, sortOrderings);
  }
 
  public static NSArray<BarcodeRechnungTBL> fetchBarcodeRechnungTBLs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_BarcodeRechnungTBL.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<BarcodeRechnungTBL> eoObjects = (NSArray<BarcodeRechnungTBL>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  /* 
   * coreQualifier fetch 
   */  
  public static NSArray<BarcodeRechnungTBL> fetchAllBarcodeRechnungTBLsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain) {
    return _BarcodeRechnungTBL.fetchAllBarcodeRechnungTBLsWithCoreQualifier(editingContext, domain, null);
  }
  
  public static NSArray<BarcodeRechnungTBL> fetchAllBarcodeRechnungTBLsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain, NSArray<EOSortOrdering> sortOrderings) {
    TBEntity entity = TBEntity.entityNamed(editingContext, _BarcodeRechnungTBL.ENTITY_NAME);
    return _BarcodeRechnungTBL.fetchBarcodeRechnungTBLs(editingContext, TBWCoreQualifierBase.delegate().qualifier(entity, domain), sortOrderings);
  }
  
  public static NSArray<BarcodeRechnungTBL> fetchBarcodeRechnungTBLsWithCoreQualifier(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    TBEntity entity = TBEntity.entityNamed(editingContext, _BarcodeRechnungTBL.ENTITY_NAME);

    TBWMultiDomainSupport multiDomainSupport = (TBWMultiDomainSupport) TBSession.session().multiDomain();
    ITBWDomain domain = multiDomainSupport.currentDomain();

    TBEnterpriseAndQualifier andQualifier = new TBEnterpriseAndQualifier(TBWCoreQualifierBase.delegate().qualifier(entity, domain), qualifier);

    EOFetchSpecification fetchSpec = new EOFetchSpecification(_BarcodeRechnungTBL.ENTITY_NAME, andQualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<BarcodeRechnungTBL> eoObjects = (NSArray<BarcodeRechnungTBL>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }  
  
  //********************************************************************
  //  Fetch (BarcodeRechnungTBL) :  フェッチ (BarcodeRechnungTBL)
  //********************************************************************
  
  public static BarcodeRechnungTBL fetchBarcodeRechnungTBL(EOEditingContext editingContext, String keyName, Object value) {
    return _BarcodeRechnungTBL.fetchBarcodeRechnungTBL(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BarcodeRechnungTBL fetchBarcodeRechnungTBL(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<BarcodeRechnungTBL> eoObjects = _BarcodeRechnungTBL.fetchBarcodeRechnungTBLs(editingContext, qualifier, null);
    BarcodeRechnungTBL eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    } else if (count == 1) {
      eoObject = (BarcodeRechnungTBL)eoObjects.objectAtIndex(0);
    } else {
      throw new IllegalStateException("There was more than one BarcodeRechnungTBL that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BarcodeRechnungTBL fetchRequiredBarcodeRechnungTBL(EOEditingContext editingContext, String keyName, Object value) {
    return _BarcodeRechnungTBL.fetchRequiredBarcodeRechnungTBL(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BarcodeRechnungTBL fetchRequiredBarcodeRechnungTBL(EOEditingContext editingContext, EOQualifier qualifier) {
    BarcodeRechnungTBL eoObject = _BarcodeRechnungTBL.fetchBarcodeRechnungTBL(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no BarcodeRechnungTBL that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BarcodeRechnungTBL fetchBarcodeRechnungTBLByPrimaryKey(EOEditingContext context, Object value) {
    EOEnterpriseObject eo = TBEOExternalPrimaryKeyHelper.objectWithPrimaryKeyValue(context, ENTITY_NAME, value);
    return (BarcodeRechnungTBL) eo;
  }

  public static BarcodeRechnungTBL fetchBarcodeRechnungTBLByEncryptedPrimaryKey(EOEditingContext context, String value) {
    return BarcodeRechnungTBL.fetchBarcodeRechnungTBLByPrimaryKey(context, TBFCrypto.crypterForAlgorithm(TBFCrypto.BLOWFISH).decrypt(value));
  }
  
  public static BarcodeRechnungTBL localInstanceIn(EOEditingContext editingContext, BarcodeRechnungTBL eo) {
    BarcodeRechnungTBL localInstance = (eo == null) ? null : (BarcodeRechnungTBL)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }

  //********************************************************************
  //  TBEnterpriseCopyable
  //********************************************************************


  //********************************************************************
  //  TBTag
  //********************************************************************


  //********************************************************************
  //  Fetch specification : フェッチ・スペシフィケーション
  //********************************************************************

}
