//
// _AllergenInfoTBL.java
//
// DO NOT EDIT. 
// Make changes to AllergenInfoTBL.java instead.
//
// version 7.1.3
//
// 2008-2014 by TreasureBoat.org
//

/*
 * The following List is for Localization :
 * ----------------------------------------

  "Pages.QueryAllergenInfoTBL" = "Query AllergenInfoTBL";
  "Pages.ListAllergenInfoTBL" = "List AllergenInfoTBL";
  "Pages.InspectAllergenInfoTBL" = "Inspect AllergenInfoTBL";
  "Pages.EditAllergenInfoTBL" = "Edit AllergenInfoTBL";
  "Pages.CreateAllergenInfoTBL" = "Create AllergenInfoTBL";
  
  "Pages.QueryEmbeddedAllergenInfoTBL" = "Query Embedded AllergenInfoTBL";
  "Pages.ListEmbeddedAllergenInfoTBL" = "List Embedded AllergenInfoTBL";
  "Pages.InspectEmbeddedAllergenInfoTBL" = "Inspect Embedded AllergenInfoTBL";
  "Pages.EditEmbeddedAllergenInfoTBL" = "Edit Embedded AllergenInfoTBL";
  "Pages.CreateEmbeddedAllergenInfoTBL" = "Create Embedded AllergenInfoTBL";

  "PropertyKey.Allergen" = "Allergen";
  "PropertyKey.AllergenInfocode" = "AllergenInfocode";

 * ----------------------------------------
 */

/*
 * The following List is for D2W/D3W :
 * ----------------------------------------

  // D2W

  300 : entity.name = 'AllergenInfoTBL' => isEntityEditable = "true" [com.webobjects.directtoweb.BooleanAssignment]

  100 : pageConfiguration like '*AllergenInfoTBL' => navigationState = "XX.xx" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'CreateAllergenInfoTBL' => navigationState = "XX.xx.createAllergenInfoTBL" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'QueryAllergenInfoTBL' => navigationState = "XX.xx.queryAllergenInfoTBL" [com.webobjects.directtoweb.Assignment]
  
  401 : pageConfiguration = 'QueryAllergenInfoTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "Allergen" , "AllergenInfocode"  ) [com.webobjects.directtoweb.Assignment] 
  402 : pageConfiguration = 'ListAllergenInfoTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "Allergen" , "AllergenInfocode"  ) [com.webobjects.directtoweb.Assignment] 
  403 : pageConfiguration = 'InspectAllergenInfoTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "Allergen" , "AllergenInfocode"  ) [com.webobjects.directtoweb.Assignment] 
  404 : pageConfiguration = 'EditAllergenInfoTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "Allergen" , "AllergenInfocode"  ) [com.webobjects.directtoweb.Assignment] 
  405 : pageConfiguration = 'CreateAllergenInfoTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "Allergen" , "AllergenInfocode"  ) [com.webobjects.directtoweb.Assignment] 
   
  // D3W

  200 : EN = '#' => crud = "0100" [com.webobjects.directtoweb.Assignment]
  600 : PC = 'EditRelationshipEmbedded#' => cruds = "00001" [com.webobjects.directtoweb.Assignment]
  
  401 : PC = 'Query#' => DPK = ("[MainTab]", "(MainSection)", "Allergen", "AllergenInfocode") [com.webobjects.directtoweb.Assignment] 
  402 : PC = 'List#' => DPK = ("[MainTab]", "(MainSection)", "Allergen", "AllergenInfocode") [com.webobjects.directtoweb.Assignment] 
  403 : PC = 'Inspect#' => DPK = ("[MainTab]", "(MainSection)", "Allergen", "AllergenInfocode") [com.webobjects.directtoweb.Assignment] 
  404 : PC = 'Edit#' => DPK = ("[MainTab]", "(MainSection)", "Allergen", "AllergenInfocode") [com.webobjects.directtoweb.Assignment] 
  405 : PC = 'Create#' => DPK = ("[MainTab]", "(MainSection)", "Allergen", "AllergenInfocode") [com.webobjects.directtoweb.Assignment] 

 * ----------------------------------------
 */

package org.treasureboat.app.eo;

import org.treasureboat.app.eo.AllergenInfoTBL;

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
public abstract class _AllergenInfoTBL extends  TBEOGenericRecord {

  private static final long serialVersionUID = 1L;

  /** 
   * <a href="http://wiki.wocommunity.org/display/documentation/Wonder+Logging">new org.slf4j.Logger</a> 
   */
  static final Logger log = LoggerFactory.getLogger(AllergenInfoTBL.class);

  //********************************************************************
  //  Constructor : コンストラクター
  //********************************************************************

  public _AllergenInfoTBL() {
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
  
  /** Entity Name = AllergenInfoTBL */
  public static final String ENTITY_NAME = "AllergenInfoTBL";

  //********************************************************************
  //  Access Properties : アクセス・プロパティ
  //********************************************************************
  
  protected static String ACCSESS_CREATE = "AllergenInfoTBL.create";
  protected static String ACCSESS_READ = "AllergenInfoTBL.read";
  protected static String ACCSESS_UPDATE = "AllergenInfoTBL.update";
  protected static String ACCSESS_DELETE = "AllergenInfoTBL.delete";

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
  public static final ERXKey<String> ALLERGEN = new ERXKey<String>("Allergen");
  public static final ERXKey<Integer> ALLERGEN_INFOCODE = new ERXKey<Integer>("AllergenInfocode");

  // Attributes
  public static final String ALLERGEN_KEY = ALLERGEN.key();
  public static final String ALLERGEN_INFOCODE_KEY = ALLERGEN_INFOCODE.key();

  //********************************************************************
  //  Relationship : リレーションシップ
  //********************************************************************

  // Relationship Keys

  // Relationships

  //********************************************************************
  //  clazz methods : クラス・メソッド
  //********************************************************************

  public static class _AllergenInfoTBLClazz<T extends AllergenInfoTBL> extends ERXGenericRecord.ERXGenericRecordClazz<T> {
    /* more clazz methods here */
  }

	public AllergenInfoTBL.AllergenInfoTBLClazz clazz() {
    return AllergenInfoTBL.clazz;
  }

  //********************************************************************
  //  Attribute Accessor : アトリビュート・アクセス
  //********************************************************************

  public String Allergen() {
    return (String) storedValueForKey(ALLERGEN_KEY);
  }

  public void setAllergen(String value) {
    if (_AllergenInfoTBL.log.isDebugEnabled()) {
      _AllergenInfoTBL.log.debug("updating Allergen from {} to {}", Allergen(), value);
    }
    takeStoredValueForKey(value, ALLERGEN_KEY);
  }

  public Object validateAllergen(Object value) throws NSValidation.ValidationException {
    _AllergenInfoTBL.log.debug("validate Allergen");
    return ERXValidationException.validateForUserInfo(this, ALLERGEN_KEY, value);
  }

  public Integer AllergenInfocode() {
    return (Integer) storedValueForKey(ALLERGEN_INFOCODE_KEY);
  }

  public void setAllergenInfocode(Integer value) {
    if (_AllergenInfoTBL.log.isDebugEnabled()) {
      _AllergenInfoTBL.log.debug("updating AllergenInfocode from {} to {}", AllergenInfocode(), value);
    }
    takeStoredValueForKey(value, ALLERGEN_INFOCODE_KEY);
  }

  public Object validateAllergenInfocode(Object value) throws NSValidation.ValidationException {
    _AllergenInfoTBL.log.debug("validate AllergenInfocode");
    return ERXValidationException.validateForUserInfo(this, ALLERGEN_INFOCODE_KEY, value);
  }

  //********************************************************************
  //  ToOne relationship : ToOne リレーションシップ
  //********************************************************************

  //********************************************************************
  //  Editing Context replacement : 編集コンテキスト入れ替え
  //********************************************************************

  @Override
  public AllergenInfoTBL localInstanceIn(EOEditingContext editingContext) {
    AllergenInfoTBL localInstance = (AllergenInfoTBL)EOUtilities.localInstanceOfObject(editingContext, this);
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

  public static AllergenInfoTBL createAllergenInfoTBL(EOEditingContext editingContext
   , String Allergen
   , Integer AllergenInfocode
    )
  {
    AllergenInfoTBL eo = (AllergenInfoTBL) EOUtilities.createAndInsertInstance(editingContext, _AllergenInfoTBL.ENTITY_NAME);
    eo.setAllergen(Allergen);
    eo.setAllergenInfocode(AllergenInfocode);
    return eo;
  }
  
  /* EO creation with Stamped EO Support */
  public static AllergenInfoTBL createAllergenInfoTBLWithStampedSupport(EOEditingContext editingContext
   , String Allergen
   , Integer AllergenInfocode
    )
  {
    AllergenInfoTBL eo = (AllergenInfoTBL) EOUtilities.createAndInsertInstance(editingContext, _AllergenInfoTBL.ENTITY_NAME);
    eo.setAllergen(Allergen);
    eo.setAllergenInfocode(AllergenInfocode);
    return eo;
  }

  public static AllergenInfoTBL createAndInsertInstance(EOEditingContext context) {
    log.debug("{} : createAndInsertInstance", ENTITY_NAME);
    
    return (AllergenInfoTBL)EOUtilities.createAndInsertInstance(context, ENTITY_NAME);
  }

  // ========== [検索関連] ==========
  //********************************************************************
  //  Fetch (NSArray) : フェッチ (NSArray)
  //********************************************************************

  public static ERXFetchSpecification<AllergenInfoTBL> fetchSpec() {
    return new ERXFetchSpecification<AllergenInfoTBL>(_AllergenInfoTBL.ENTITY_NAME, null, null, false, true, null);
  }

  /* 
   * standard fetch 
   */
  public static NSArray<AllergenInfoTBL> fetchAllAllergenInfoTBLs(EOEditingContext editingContext) {
    return _AllergenInfoTBL.fetchAllAllergenInfoTBLs(editingContext, null);
  }

  public static NSArray<AllergenInfoTBL> fetchAllAllergenInfoTBLs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _AllergenInfoTBL.fetchAllergenInfoTBLs(editingContext, null, sortOrderings);
  }
 
  public static NSArray<AllergenInfoTBL> fetchAllergenInfoTBLs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_AllergenInfoTBL.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<AllergenInfoTBL> eoObjects = (NSArray<AllergenInfoTBL>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  /* 
   * coreQualifier fetch 
   */  
  public static NSArray<AllergenInfoTBL> fetchAllAllergenInfoTBLsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain) {
    return _AllergenInfoTBL.fetchAllAllergenInfoTBLsWithCoreQualifier(editingContext, domain, null);
  }
  
  public static NSArray<AllergenInfoTBL> fetchAllAllergenInfoTBLsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain, NSArray<EOSortOrdering> sortOrderings) {
    EOEntity entity = ERXEOAccessUtilities.entityNamed(editingContext, _AllergenInfoTBL.ENTITY_NAME);
    return _AllergenInfoTBL.fetchAllergenInfoTBLs(editingContext, TBWCoreQualifierBase.delegate().qualifier(entity, domain), sortOrderings);
  }
  
  public static NSArray<AllergenInfoTBL> fetchAllergenInfoTBLsWithCoreQualifier(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOEntity entity = ERXEOAccessUtilities.entityNamed(editingContext, _AllergenInfoTBL.ENTITY_NAME);

    TBWMultiDomainSupport multiDomainSupport = (TBWMultiDomainSupport) TBSession.session().multiDomain();
    ITBWDomain domain = multiDomainSupport.currentDomain();

    ERXAndQualifier andQualifier = new ERXAndQualifier(TBWCoreQualifierBase.delegate().qualifier(entity, domain), qualifier);

    EOFetchSpecification fetchSpec = new EOFetchSpecification(_AllergenInfoTBL.ENTITY_NAME, andQualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<AllergenInfoTBL> eoObjects = (NSArray<AllergenInfoTBL>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }  
  
  //********************************************************************
  //  Fetch (AllergenInfoTBL) :  フェッチ (AllergenInfoTBL)
  //********************************************************************
  
  public static AllergenInfoTBL fetchAllergenInfoTBL(EOEditingContext editingContext, String keyName, Object value) {
    return _AllergenInfoTBL.fetchAllergenInfoTBL(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static AllergenInfoTBL fetchAllergenInfoTBL(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<AllergenInfoTBL> eoObjects = _AllergenInfoTBL.fetchAllergenInfoTBLs(editingContext, qualifier, null);
    AllergenInfoTBL eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    } else if (count == 1) {
      eoObject = (AllergenInfoTBL)eoObjects.objectAtIndex(0);
    } else {
      throw new IllegalStateException("There was more than one AllergenInfoTBL that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static AllergenInfoTBL fetchRequiredAllergenInfoTBL(EOEditingContext editingContext, String keyName, Object value) {
    return _AllergenInfoTBL.fetchRequiredAllergenInfoTBL(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static AllergenInfoTBL fetchRequiredAllergenInfoTBL(EOEditingContext editingContext, EOQualifier qualifier) {
    AllergenInfoTBL eoObject = _AllergenInfoTBL.fetchAllergenInfoTBL(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no AllergenInfoTBL that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static AllergenInfoTBL fetchAllergenInfoTBLByPrimaryKey(EOEditingContext context, Object value) {
    EOEnterpriseObject eo = TBEOExternalPrimaryKeyHelper.objectWithPrimaryKeyValue(context, ENTITY_NAME, value);
    return (AllergenInfoTBL) eo;
  }

  public static AllergenInfoTBL fetchAllergenInfoTBLByEncryptedPrimaryKey(EOEditingContext context, String value) {
    return AllergenInfoTBL.fetchAllergenInfoTBLByPrimaryKey(context, TBFCrypto.crypterForAlgorithm(TBFCrypto.BLOWFISH).decrypt(value));
  }
  
  public static AllergenInfoTBL localInstanceIn(EOEditingContext editingContext, AllergenInfoTBL eo) {
    AllergenInfoTBL localInstance = (eo == null) ? null : (AllergenInfoTBL)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }

  //********************************************************************
  //  Fetch specification : フェッチ・スペシフィケーション
  //********************************************************************

}
