//
// _AllergeneTBL.java
//
// DO NOT EDIT. 
// Make changes to AllergeneTBL.java instead.
//
// version 7.1.3
//
// 2008-2014 by TreasureBoat.org
//

/*
 * The following List is for Localization :
 * ----------------------------------------

  "Pages.QueryAllergeneTBL" = "Query AllergeneTBL";
  "Pages.ListAllergeneTBL" = "List AllergeneTBL";
  "Pages.InspectAllergeneTBL" = "Inspect AllergeneTBL";
  "Pages.EditAllergeneTBL" = "Edit AllergeneTBL";
  "Pages.CreateAllergeneTBL" = "Create AllergeneTBL";
  
  "Pages.QueryEmbeddedAllergeneTBL" = "Query Embedded AllergeneTBL";
  "Pages.ListEmbeddedAllergeneTBL" = "List Embedded AllergeneTBL";
  "Pages.InspectEmbeddedAllergeneTBL" = "Inspect Embedded AllergeneTBL";
  "Pages.EditEmbeddedAllergeneTBL" = "Edit Embedded AllergeneTBL";
  "Pages.CreateEmbeddedAllergeneTBL" = "Create Embedded AllergeneTBL";

  "PropertyKey.allergencode" = "allergencode";
  "PropertyKey.speisenid" = "speisenid";

 * ----------------------------------------
 */

/*
 * The following List is for D2W/D3W :
 * ----------------------------------------

  // D2W

  300 : entity.name = 'AllergeneTBL' => isEntityEditable = "true" [com.webobjects.directtoweb.BooleanAssignment]

  100 : pageConfiguration like '*AllergeneTBL' => navigationState = "XX.xx" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'CreateAllergeneTBL' => navigationState = "XX.xx.createAllergeneTBL" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'QueryAllergeneTBL' => navigationState = "XX.xx.queryAllergeneTBL" [com.webobjects.directtoweb.Assignment]
  
  401 : pageConfiguration = 'QueryAllergeneTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "allergencode" , "speisenid"  ) [com.webobjects.directtoweb.Assignment] 
  402 : pageConfiguration = 'ListAllergeneTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "allergencode" , "speisenid"  ) [com.webobjects.directtoweb.Assignment] 
  403 : pageConfiguration = 'InspectAllergeneTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "allergencode" , "speisenid"  ) [com.webobjects.directtoweb.Assignment] 
  404 : pageConfiguration = 'EditAllergeneTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "allergencode" , "speisenid"  ) [com.webobjects.directtoweb.Assignment] 
  405 : pageConfiguration = 'CreateAllergeneTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "allergencode" , "speisenid"  ) [com.webobjects.directtoweb.Assignment] 
   
  // D3W

  200 : EN = '#' => crud = "0100" [com.webobjects.directtoweb.Assignment]
  600 : PC = 'EditRelationshipEmbedded#' => cruds = "00001" [com.webobjects.directtoweb.Assignment]
  
  401 : PC = 'Query#' => DPK = ("[MainTab]", "(MainSection)", "allergencode", "speisenid") [com.webobjects.directtoweb.Assignment] 
  402 : PC = 'List#' => DPK = ("[MainTab]", "(MainSection)", "allergencode", "speisenid") [com.webobjects.directtoweb.Assignment] 
  403 : PC = 'Inspect#' => DPK = ("[MainTab]", "(MainSection)", "allergencode", "speisenid") [com.webobjects.directtoweb.Assignment] 
  404 : PC = 'Edit#' => DPK = ("[MainTab]", "(MainSection)", "allergencode", "speisenid") [com.webobjects.directtoweb.Assignment] 
  405 : PC = 'Create#' => DPK = ("[MainTab]", "(MainSection)", "allergencode", "speisenid") [com.webobjects.directtoweb.Assignment] 

 * ----------------------------------------
 */

package org.treasureboat.app.eo;

import org.treasureboat.app.eo.AllergeneTBL;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.treasureboat.enterprise.eof.TBEOExternalPrimaryKeyHelper;
import org.treasureboat.enterprise.eof.TBEOGenericRecord;
import org.treasureboat.enterprise.eof.delete.ITBEnterpriseVirtualDeleteSupport;
import org.treasureboat.foundation.crypting.TBFCrypto;
import org.treasureboat.webcore.appserver.TBSession;
import org.treasureboat.webcore.concurrency.TBWConcurrencyUtilities;
import org.treasureboat.webcore.override.core.TBWCoreQualifierBase;
import org.treasureboat.webcore.security.domain.ITBWDomain;
import org.treasureboat.webcore.security.domain.TBWMultiDomainSupport;
import org.treasureboat.webcore.security.grant.TBWGrantAccess;
import org.treasureboat.webcore.security.password.TBWAccessPermission;

import com.webobjects.eoaccess.EOEntity;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.*;
import com.webobjects.foundation.*;

import er.extensions.eof.ERXEOAccessUtilities;
import er.extensions.eof.ERXFetchSpecification;
import er.extensions.eof.ERXGenericRecord;
import er.extensions.eof.ERXKey;
import er.extensions.qualifiers.ERXAndQualifier;
import er.extensions.validation.ERXValidationException;

@SuppressWarnings("all")
public abstract class _AllergeneTBL extends  TBEOGenericRecord {

  private static final long serialVersionUID = 1L;

  /** 
   * <a href="http://wiki.wocommunity.org/display/documentation/Wonder+Logging">new org.slf4j.Logger</a> 
   */
  static final Logger log = LoggerFactory.getLogger(AllergeneTBL.class);

  //********************************************************************
  //  Constructor : コンストラクター
  //********************************************************************

  public _AllergeneTBL() {
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
  
  /** Entity Name = AllergeneTBL */
  public static final String ENTITY_NAME = "AllergeneTBL";

  //********************************************************************
  //  Access Properties : アクセス・プロパティ
  //********************************************************************
  
  protected static String ACCSESS_CREATE = "AllergeneTBL.create";
  protected static String ACCSESS_READ = "AllergeneTBL.read";
  protected static String ACCSESS_UPDATE = "AllergeneTBL.update";
  protected static String ACCSESS_DELETE = "AllergeneTBL.delete";

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
  public static final ERXKey<String> ALLERGENCODE = new ERXKey<String>("allergencode");
  public static final ERXKey<Integer> SPEISENID = new ERXKey<Integer>("speisenid");

  // Attributes
  public static final String ALLERGENCODE_KEY = ALLERGENCODE.key();
  public static final String SPEISENID_KEY = SPEISENID.key();

  //********************************************************************
  //  Relationship : リレーションシップ
  //********************************************************************

  // Relationship Keys

  // Relationships

  //********************************************************************
  //  clazz methods : クラス・メソッド
  //********************************************************************

  public static class _AllergeneTBLClazz<T extends AllergeneTBL> extends ERXGenericRecord.ERXGenericRecordClazz<T> {
    /* more clazz methods here */
  }

	public AllergeneTBL.AllergeneTBLClazz clazz() {
    return AllergeneTBL.clazz;
  }

  //********************************************************************
  //  Attribute Accessor : アトリビュート・アクセス
  //********************************************************************

  public String allergencode() {
    return (String) storedValueForKey(ALLERGENCODE_KEY);
  }

  public void setAllergencode(String value) {
    if (_AllergeneTBL.log.isDebugEnabled()) {
      _AllergeneTBL.log.debug("updating allergencode from {} to {}", allergencode(), value);
    }
    takeStoredValueForKey(value, ALLERGENCODE_KEY);
  }

  public Object validateAllergencode(Object value) throws NSValidation.ValidationException {
    _AllergeneTBL.log.debug("validate allergencode");
    return ERXValidationException.validateForUserInfo(this, ALLERGENCODE_KEY, value);
  }

  public Integer speisenid() {
    return (Integer) storedValueForKey(SPEISENID_KEY);
  }

  public void setSpeisenid(Integer value) {
    if (_AllergeneTBL.log.isDebugEnabled()) {
      _AllergeneTBL.log.debug("updating speisenid from {} to {}", speisenid(), value);
    }
    takeStoredValueForKey(value, SPEISENID_KEY);
  }

  public Object validateSpeisenid(Object value) throws NSValidation.ValidationException {
    _AllergeneTBL.log.debug("validate speisenid");
    return ERXValidationException.validateForUserInfo(this, SPEISENID_KEY, value);
  }

  //********************************************************************
  //  ToOne relationship : ToOne リレーションシップ
  //********************************************************************

  //********************************************************************
  //  Editing Context replacement : 編集コンテキスト入れ替え
  //********************************************************************

  @Override
  public AllergeneTBL localInstanceIn(EOEditingContext editingContext) {
    AllergeneTBL localInstance = (AllergeneTBL)EOUtilities.localInstanceOfObject(editingContext, this);
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

  public static AllergeneTBL createAllergeneTBL(EOEditingContext editingContext
   , String allergencode
   , Integer speisenid
    )
  {
    AllergeneTBL eo = (AllergeneTBL) EOUtilities.createAndInsertInstance(editingContext, _AllergeneTBL.ENTITY_NAME);
    eo.setAllergencode(allergencode);
    eo.setSpeisenid(speisenid);
    return eo;
  }
  
  /* EO creation with Stamped EO Support */
  public static AllergeneTBL createAllergeneTBLWithStampedSupport(EOEditingContext editingContext
   , String allergencode
   , Integer speisenid
    )
  {
    AllergeneTBL eo = (AllergeneTBL) EOUtilities.createAndInsertInstance(editingContext, _AllergeneTBL.ENTITY_NAME);
    eo.setAllergencode(allergencode);
    eo.setSpeisenid(speisenid);
    return eo;
  }

  public static AllergeneTBL createAndInsertInstance(EOEditingContext context) {
    log.debug("{} : createAndInsertInstance", ENTITY_NAME);
    
    return (AllergeneTBL)EOUtilities.createAndInsertInstance(context, ENTITY_NAME);
  }

  // ========== [検索関連] ==========
  //********************************************************************
  //  Fetch (NSArray) : フェッチ (NSArray)
  //********************************************************************

  public static ERXFetchSpecification<AllergeneTBL> fetchSpec() {
    return new ERXFetchSpecification<AllergeneTBL>(_AllergeneTBL.ENTITY_NAME, null, null, false, true, null);
  }

  /* 
   * standard fetch 
   */
  public static NSArray<AllergeneTBL> fetchAllAllergeneTBLs(EOEditingContext editingContext) {
    return _AllergeneTBL.fetchAllAllergeneTBLs(editingContext, null);
  }

  public static NSArray<AllergeneTBL> fetchAllAllergeneTBLs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _AllergeneTBL.fetchAllergeneTBLs(editingContext, null, sortOrderings);
  }
 
  public static NSArray<AllergeneTBL> fetchAllergeneTBLs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_AllergeneTBL.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<AllergeneTBL> eoObjects = (NSArray<AllergeneTBL>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  /* 
   * coreQualifier fetch 
   */  
  public static NSArray<AllergeneTBL> fetchAllAllergeneTBLsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain) {
    return _AllergeneTBL.fetchAllAllergeneTBLsWithCoreQualifier(editingContext, domain, null);
  }
  
  public static NSArray<AllergeneTBL> fetchAllAllergeneTBLsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain, NSArray<EOSortOrdering> sortOrderings) {
    EOEntity entity = ERXEOAccessUtilities.entityNamed(editingContext, _AllergeneTBL.ENTITY_NAME);
    return _AllergeneTBL.fetchAllergeneTBLs(editingContext, TBWCoreQualifierBase.delegate().qualifier(entity, domain), sortOrderings);
  }
  
  public static NSArray<AllergeneTBL> fetchAllergeneTBLsWithCoreQualifier(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOEntity entity = ERXEOAccessUtilities.entityNamed(editingContext, _AllergeneTBL.ENTITY_NAME);

    TBWMultiDomainSupport multiDomainSupport = (TBWMultiDomainSupport) TBSession.session().multiDomain();
    ITBWDomain domain = multiDomainSupport.currentDomain();

    ERXAndQualifier andQualifier = new ERXAndQualifier(TBWCoreQualifierBase.delegate().qualifier(entity, domain), qualifier);

    EOFetchSpecification fetchSpec = new EOFetchSpecification(_AllergeneTBL.ENTITY_NAME, andQualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<AllergeneTBL> eoObjects = (NSArray<AllergeneTBL>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }  
  
  //********************************************************************
  //  Fetch (AllergeneTBL) :  フェッチ (AllergeneTBL)
  //********************************************************************
  
  public static AllergeneTBL fetchAllergeneTBL(EOEditingContext editingContext, String keyName, Object value) {
    return _AllergeneTBL.fetchAllergeneTBL(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static AllergeneTBL fetchAllergeneTBL(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<AllergeneTBL> eoObjects = _AllergeneTBL.fetchAllergeneTBLs(editingContext, qualifier, null);
    AllergeneTBL eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    } else if (count == 1) {
      eoObject = (AllergeneTBL)eoObjects.objectAtIndex(0);
    } else {
      throw new IllegalStateException("There was more than one AllergeneTBL that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static AllergeneTBL fetchRequiredAllergeneTBL(EOEditingContext editingContext, String keyName, Object value) {
    return _AllergeneTBL.fetchRequiredAllergeneTBL(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static AllergeneTBL fetchRequiredAllergeneTBL(EOEditingContext editingContext, EOQualifier qualifier) {
    AllergeneTBL eoObject = _AllergeneTBL.fetchAllergeneTBL(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no AllergeneTBL that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static AllergeneTBL fetchAllergeneTBLByPrimaryKey(EOEditingContext context, Object value) {
    EOEnterpriseObject eo = TBEOExternalPrimaryKeyHelper.objectWithPrimaryKeyValue(context, ENTITY_NAME, value);
    return (AllergeneTBL) eo;
  }

  public static AllergeneTBL fetchAllergeneTBLByEncryptedPrimaryKey(EOEditingContext context, String value) {
    return AllergeneTBL.fetchAllergeneTBLByPrimaryKey(context, TBFCrypto.crypterForAlgorithm(TBFCrypto.BLOWFISH).decrypt(value));
  }
  
  public static AllergeneTBL localInstanceIn(EOEditingContext editingContext, AllergeneTBL eo) {
    AllergeneTBL localInstance = (eo == null) ? null : (AllergeneTBL)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }

  //********************************************************************
  //  Fetch specification : フェッチ・スペシフィケーション
  //********************************************************************

}
