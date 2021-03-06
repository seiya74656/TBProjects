//
// _BarcodeCheckTBL.java
//
// DO NOT EDIT. 
// Make changes to BarcodeCheckTBL.java instead.
//
// version 8.5
//
// 2008-2016 by TreasureBoat.org
//

/*
 * The following List is for Localization :
 * ----------------------------------------

  "Pages.QueryBarcodeCheckTBL" = "Query BarcodeCheckTBL";
  "Pages.ListBarcodeCheckTBL" = "List BarcodeCheckTBL";
  "Pages.InspectBarcodeCheckTBL" = "Inspect BarcodeCheckTBL";
  "Pages.EditBarcodeCheckTBL" = "Edit BarcodeCheckTBL";
  "Pages.CreateBarcodeCheckTBL" = "Create BarcodeCheckTBL";
  
  "Pages.QueryEmbeddedBarcodeCheckTBL" = "Query Embedded BarcodeCheckTBL";
  "Pages.ListEmbeddedBarcodeCheckTBL" = "List Embedded BarcodeCheckTBL";
  "Pages.InspectEmbeddedBarcodeCheckTBL" = "Inspect Embedded BarcodeCheckTBL";
  "Pages.EditEmbeddedBarcodeCheckTBL" = "Edit Embedded BarcodeCheckTBL";
  "Pages.CreateEmbeddedBarcodeCheckTBL" = "Create Embedded BarcodeCheckTBL";

  "PropertyKey.BarcodeCheckTBL.barcodevalid" = "barcodevalid";
  "PropertyKey.BarcodeCheckTBL.validDate" = "validDate";

 * ----------------------------------------
 */

/*
 * The following List is for D2W/D3W :
 * ----------------------------------------

  // D2W

  300 : entity.name = 'BarcodeCheckTBL' => isEntityEditable = "true" [com.webobjects.directtoweb.BooleanAssignment]

  100 : pageConfiguration like '*BarcodeCheckTBL' => navigationState = "XX.xx" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'CreateBarcodeCheckTBL' => navigationState = "XX.xx.createBarcodeCheckTBL" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'QueryBarcodeCheckTBL' => navigationState = "XX.xx.queryBarcodeCheckTBL" [com.webobjects.directtoweb.Assignment]
  
  401 : pageConfiguration = 'QueryBarcodeCheckTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "barcodevalid" , "validDate"  ) [com.webobjects.directtoweb.Assignment] 
  402 : pageConfiguration = 'ListBarcodeCheckTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "barcodevalid" , "validDate"  ) [com.webobjects.directtoweb.Assignment] 
  403 : pageConfiguration = 'InspectBarcodeCheckTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "barcodevalid" , "validDate"  ) [com.webobjects.directtoweb.Assignment] 
  404 : pageConfiguration = 'EditBarcodeCheckTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "barcodevalid" , "validDate"  ) [com.webobjects.directtoweb.Assignment] 
  405 : pageConfiguration = 'CreateBarcodeCheckTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "barcodevalid" , "validDate"  ) [com.webobjects.directtoweb.Assignment] 
   
  // D3W

  200 : EN = '#' => crud = "0100" [com.webobjects.directtoweb.Assignment]
  600 : PC = 'EditRelationshipEmbedded#' => cruds = "00001" [com.webobjects.directtoweb.Assignment]
  
  401 : PC = 'Query#' => DPK = ("[MainTab]", "(MainSection)", "barcodevalid", "validDate") [com.webobjects.directtoweb.Assignment] 
  402 : PC = 'List#' => DPK = ("[MainTab]", "(MainSection)", "barcodevalid", "validDate") [com.webobjects.directtoweb.Assignment] 
  403 : PC = 'Inspect#' => DPK = ("[MainTab]", "(MainSection)", "barcodevalid", "validDate") [com.webobjects.directtoweb.Assignment] 
  404 : PC = 'Edit#' => DPK = ("[MainTab]", "(MainSection)", "barcodevalid", "validDate") [com.webobjects.directtoweb.Assignment] 
  405 : PC = 'Create#' => DPK = ("[MainTab]", "(MainSection)", "barcodevalid", "validDate") [com.webobjects.directtoweb.Assignment] 

 * ----------------------------------------
 */

package org.treasureboat.app.eo;

import org.treasureboat.app.eo.BarcodeCheckTBL;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.treasureboat.enterprise.eof.TBEOExternalPrimaryKeyHelper;
import org.treasureboat.enterprise.eof.TBEOGenericRecord;
import org.treasureboat.enterprise.eof.delete.ITBEnterpriseVirtualDeleteSupport;
import org.treasureboat.foundation.NSData;
import org.treasureboat.enterprise.qualifiers.TBEnterpriseAndQualifier;
import org.treasureboat.foundation.crypting.TBFCrypto;
import org.treasureboat.foundation.security.TBFAccessPermission;
import org.treasureboat.webcore.appserver.TBSession;
import org.treasureboat.webcore.concurrency.TBWConcurrencyUtilities;
import org.treasureboat.webcore.override.core.TBWCoreQualifierBase;
import org.treasureboat.webcore.security.domain.ITBWDomain;
import org.treasureboat.webcore.security.domain.TBWMultiDomainSupport;
import org.treasureboat.webcore.security.grant.TBWGrantAccess;

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
public abstract class _BarcodeCheckTBL extends  TBEOGenericRecord  {

  private static final long serialVersionUID = 1L;

  /** 
   * <a href="http://wiki.wocommunity.org/display/documentation/Wonder+Logging">new org.slf4j.Logger</a> 
   */
  static final Logger log = LoggerFactory.getLogger(BarcodeCheckTBL.class);

  //********************************************************************
  //  Constructor : コンストラクター
  //********************************************************************

  public _BarcodeCheckTBL() {
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
  
  /** Entity Name = BarcodeCheckTBL */
  public static final String ENTITY_NAME = "BarcodeCheckTBL";

  //********************************************************************
  //  Access Properties : アクセス・プロパティ
  //********************************************************************
  
  protected static String ACCSESS_CREATE = "BarcodeCheckTBL.create";
  protected static String ACCSESS_READ = "BarcodeCheckTBL.read";
  protected static String ACCSESS_UPDATE = "BarcodeCheckTBL.update";
  protected static String ACCSESS_DELETE = "BarcodeCheckTBL.delete";

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
    return TBFAccessPermission.instance().can(ACCSESS_CREATE);
  }

  /**
   * you can override or use the role system
   * 
   * @return true if it allowed to read Data
   */
  public boolean canRead() {
    return TBFAccessPermission.instance().can(ACCSESS_READ);
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
    return TBFAccessPermission.instance().can(ACCSESS_UPDATE);
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
    return TBFAccessPermission.instance().can(ACCSESS_DELETE);
  }
  
  protected static String BUTTON_INSPECT = "BarcodeCheckTBL.hide.inspect";
  protected static String BUTTON_EDIT = "BarcodeCheckTBL.hide.edit";
  protected static String BUTTON_DELETE = "BarcodeCheckTBL.hide.delete";
  protected static String BUTTON_REMOVE = "BarcodeCheckTBL.hide.remove";

  /**
   * this is a helper method that helps to decide to show the inspect button on a list page used in D3W, can be used in other places also
   * 
   * @return usually return true except there is something with this object
   */
  @Override
  public boolean canDisplayInspectButton() {
    return !TBFAccessPermission.instance().can(BUTTON_INSPECT);
  }

  /**
   * this is a helper method that helps to decide to show the edit button on a list page used in D3W, can be used in other places also
   * 
   * @return usually returns true except there is something with this object
   */
  @Override
  public boolean canDisplayEditButton() {
    return !TBFAccessPermission.instance().can(BUTTON_EDIT);
  }

  /**
   * this is a helper method that helps to decide to show the delete button on a list page used in D3W, can be used in other places also
   * 
   * @return usually returns true except there is something with this object
   */
  @Override
  public boolean canDisplayDeleteButton() {
    return !TBFAccessPermission.instance().can(BUTTON_DELETE);
  }

  /**
   * this is a helper method that helps to decide to show the remove button on a list page used in D3W, can be used in other places also
   * 
   * @return usually returns true except there is something with this object
   */
  @Override
  public boolean canDisplayRemoveButton() {
    return !TBFAccessPermission.instance().can(BUTTON_REMOVE);
  }

  //********************************************************************
  //  Attribute : アトリビュート
  //********************************************************************

  // Attribute Keys
  public static final ERXKey<Integer> BARCODEVALID = new ERXKey<Integer>("barcodevalid");
  public static final ERXKey<NSTimestamp> VALID_DATE = new ERXKey<NSTimestamp>("validDate");

  // Attributes
  public static final String BARCODEVALID_KEY = BARCODEVALID.key();
  public static final String VALID_DATE_KEY = VALID_DATE.key();

  //********************************************************************
  //  Relationship : リレーションシップ
  //********************************************************************

  // Relationship Keys

  // Relationships

  //********************************************************************
  //  clazz methods : クラス・メソッド
  //********************************************************************

  public static class _BarcodeCheckTBLClazz<T extends BarcodeCheckTBL> extends ERXGenericRecord.ERXGenericRecordClazz<T> {
    /* more clazz methods here */
  }

	public BarcodeCheckTBL.BarcodeCheckTBLClazz clazz() {
    return BarcodeCheckTBL.clazz;
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

  public Integer barcodevalid() {
    return (Integer) storedValueForKey(BARCODEVALID_KEY);
  }

  public void setBarcodevalid(Integer value) {
    if (_BarcodeCheckTBL.log.isDebugEnabled()) {
      _BarcodeCheckTBL.log.debug("updating barcodevalid from {} to {}", barcodevalid(), value);
    }
    takeStoredValueForKey(value, BARCODEVALID_KEY);
  }

  public Object validateBarcodevalid(Object value) throws NSValidation.ValidationException {
    _BarcodeCheckTBL.log.debug("validate barcodevalid");
    return ERXValidationException.validateForUserInfo(this, BARCODEVALID_KEY, value);
  }

  public NSTimestamp validDate() {
    return (NSTimestamp) storedValueForKey(VALID_DATE_KEY);
  }

  public void setValidDate(NSTimestamp value) {
    if (_BarcodeCheckTBL.log.isDebugEnabled()) {
      _BarcodeCheckTBL.log.debug("updating validDate from {} to {}", validDate(), value);
    }
    takeStoredValueForKey(value, VALID_DATE_KEY);
  }

  public Object validateValidDate(Object value) throws NSValidation.ValidationException {
    _BarcodeCheckTBL.log.debug("validate validDate");
    return ERXValidationException.validateForUserInfo(this, VALID_DATE_KEY, value);
  }

  //********************************************************************
  //  ToOne relationship : ToOne リレーションシップ
  //********************************************************************

  //********************************************************************
  //  Editing Context replacement : 編集コンテキスト入れ替え
  //********************************************************************

  @Override
  public BarcodeCheckTBL localInstanceIn(EOEditingContext editingContext) {
    BarcodeCheckTBL localInstance = (BarcodeCheckTBL)EOUtilities.localInstanceOfObject(editingContext, this);
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

  public static BarcodeCheckTBL createBarcodeCheckTBL(EOEditingContext editingContext
   , Integer barcodevalid
   , NSTimestamp validDate
    )
  {
    BarcodeCheckTBL eo = (BarcodeCheckTBL) EOUtilities.createAndInsertInstance(editingContext, _BarcodeCheckTBL.ENTITY_NAME);
    eo.setBarcodevalid(barcodevalid);
    eo.setValidDate(validDate);
    return eo;
  }
  
  /* EO creation with Stamped EO Support */
  public static BarcodeCheckTBL createBarcodeCheckTBLWithStampedSupport(EOEditingContext editingContext
   , Integer barcodevalid
   , NSTimestamp validDate
    )
  {
    BarcodeCheckTBL eo = (BarcodeCheckTBL) EOUtilities.createAndInsertInstance(editingContext, _BarcodeCheckTBL.ENTITY_NAME);
    eo.setBarcodevalid(barcodevalid);
    eo.setValidDate(validDate);
    return eo;
  }

  public static BarcodeCheckTBL createAndInsertInstance(EOEditingContext context) {
    log.debug("{} : createAndInsertInstance", ENTITY_NAME);
    
    return (BarcodeCheckTBL)EOUtilities.createAndInsertInstance(context, ENTITY_NAME);
  }

  // ========== [検索関連] ==========
  //********************************************************************
  //  Fetch (NSArray) : フェッチ (NSArray)
  //********************************************************************

  public static ERXFetchSpecification<BarcodeCheckTBL> fetchSpec() {
    return new ERXFetchSpecification<BarcodeCheckTBL>(_BarcodeCheckTBL.ENTITY_NAME, null, null, false, true, null);
  }

  /* 
   * standard fetch 
   */
  public static NSArray<BarcodeCheckTBL> fetchAllBarcodeCheckTBLs(EOEditingContext editingContext) {
    return _BarcodeCheckTBL.fetchAllBarcodeCheckTBLs(editingContext, null);
  }

  public static NSArray<BarcodeCheckTBL> fetchAllBarcodeCheckTBLs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _BarcodeCheckTBL.fetchBarcodeCheckTBLs(editingContext, null, sortOrderings);
  }
 
  public static NSArray<BarcodeCheckTBL> fetchBarcodeCheckTBLs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_BarcodeCheckTBL.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<BarcodeCheckTBL> eoObjects = (NSArray<BarcodeCheckTBL>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  /* 
   * coreQualifier fetch 
   */  
  public static NSArray<BarcodeCheckTBL> fetchAllBarcodeCheckTBLsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain) {
    return _BarcodeCheckTBL.fetchAllBarcodeCheckTBLsWithCoreQualifier(editingContext, domain, null);
  }
  
  public static NSArray<BarcodeCheckTBL> fetchAllBarcodeCheckTBLsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain, NSArray<EOSortOrdering> sortOrderings) {
    TBEntity entity = TBEntity.entityNamed(editingContext, _BarcodeCheckTBL.ENTITY_NAME);
    return _BarcodeCheckTBL.fetchBarcodeCheckTBLs(editingContext, TBWCoreQualifierBase.delegate().qualifier(entity, domain), sortOrderings);
  }
  
  public static NSArray<BarcodeCheckTBL> fetchBarcodeCheckTBLsWithCoreQualifier(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    TBEntity entity = TBEntity.entityNamed(editingContext, _BarcodeCheckTBL.ENTITY_NAME);

    TBWMultiDomainSupport multiDomainSupport = TBSession.session().multiDomain();
    ITBWDomain domain = multiDomainSupport.currentDomain();

    TBEnterpriseAndQualifier andQualifier = new TBEnterpriseAndQualifier(TBWCoreQualifierBase.delegate().qualifier(entity, domain), qualifier);

    EOFetchSpecification fetchSpec = new EOFetchSpecification(_BarcodeCheckTBL.ENTITY_NAME, andQualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<BarcodeCheckTBL> eoObjects = (NSArray<BarcodeCheckTBL>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }  
  
  //********************************************************************
  //  Fetch (BarcodeCheckTBL) :  フェッチ (BarcodeCheckTBL)
  //********************************************************************
  
  public static BarcodeCheckTBL fetchBarcodeCheckTBL(EOEditingContext editingContext, String keyName, Object value) {
    return _BarcodeCheckTBL.fetchBarcodeCheckTBL(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BarcodeCheckTBL fetchBarcodeCheckTBL(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<BarcodeCheckTBL> eoObjects = _BarcodeCheckTBL.fetchBarcodeCheckTBLs(editingContext, qualifier, null);
    BarcodeCheckTBL eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    } else if (count == 1) {
      eoObject = (BarcodeCheckTBL)eoObjects.objectAtIndex(0);
    } else {
      throw new IllegalStateException("There was more than one BarcodeCheckTBL that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BarcodeCheckTBL fetchRequiredBarcodeCheckTBL(EOEditingContext editingContext, String keyName, Object value) {
    return _BarcodeCheckTBL.fetchRequiredBarcodeCheckTBL(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static BarcodeCheckTBL fetchRequiredBarcodeCheckTBL(EOEditingContext editingContext, EOQualifier qualifier) {
    BarcodeCheckTBL eoObject = _BarcodeCheckTBL.fetchBarcodeCheckTBL(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no BarcodeCheckTBL that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static BarcodeCheckTBL fetchBarcodeCheckTBLByPrimaryKey(EOEditingContext context, Object value) {
    EOEnterpriseObject eo = TBEOExternalPrimaryKeyHelper.objectWithPrimaryKeyValue(context, ENTITY_NAME, value);
    return (BarcodeCheckTBL) eo;
  }

  public static BarcodeCheckTBL fetchBarcodeCheckTBLByEncryptedPrimaryKey(EOEditingContext context, String value) {
    return BarcodeCheckTBL.fetchBarcodeCheckTBLByPrimaryKey(context, TBFCrypto.crypterForAlgorithm(TBFCrypto.BLOWFISH).decrypt(value));
  }
  
  public static BarcodeCheckTBL localInstanceIn(EOEditingContext editingContext, BarcodeCheckTBL eo) {
    BarcodeCheckTBL localInstance = (eo == null) ? null : (BarcodeCheckTBL)EOUtilities.localInstanceOfObject(editingContext, eo);
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
