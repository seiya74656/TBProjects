//
// _GewinnspielTBL.java
//
// DO NOT EDIT. 
// Make changes to GewinnspielTBL.java instead.
//
// version 8.5
//
// 2008-2016 by TreasureBoat.org
//

/*
 * The following List is for Localization :
 * ----------------------------------------

  "Pages.QueryGewinnspielTBL" = "Query GewinnspielTBL";
  "Pages.ListGewinnspielTBL" = "List GewinnspielTBL";
  "Pages.InspectGewinnspielTBL" = "Inspect GewinnspielTBL";
  "Pages.EditGewinnspielTBL" = "Edit GewinnspielTBL";
  "Pages.CreateGewinnspielTBL" = "Create GewinnspielTBL";
  
  "Pages.QueryEmbeddedGewinnspielTBL" = "Query Embedded GewinnspielTBL";
  "Pages.ListEmbeddedGewinnspielTBL" = "List Embedded GewinnspielTBL";
  "Pages.InspectEmbeddedGewinnspielTBL" = "Inspect Embedded GewinnspielTBL";
  "Pages.EditEmbeddedGewinnspielTBL" = "Edit Embedded GewinnspielTBL";
  "Pages.CreateEmbeddedGewinnspielTBL" = "Create Embedded GewinnspielTBL";

  "PropertyKey.GewinnspielTBL.agb" = "agb";
  "PropertyKey.GewinnspielTBL.antwort" = "antwort";
  "PropertyKey.GewinnspielTBL.datum" = "datum";
  "PropertyKey.GewinnspielTBL.email" = "email";
  "PropertyKey.GewinnspielTBL.name" = "name";

 * ----------------------------------------
 */

/*
 * The following List is for D2W/D3W :
 * ----------------------------------------

  // D2W

  300 : entity.name = 'GewinnspielTBL' => isEntityEditable = "true" [com.webobjects.directtoweb.BooleanAssignment]

  100 : pageConfiguration like '*GewinnspielTBL' => navigationState = "XX.xx" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'CreateGewinnspielTBL' => navigationState = "XX.xx.createGewinnspielTBL" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'QueryGewinnspielTBL' => navigationState = "XX.xx.queryGewinnspielTBL" [com.webobjects.directtoweb.Assignment]
  
  401 : pageConfiguration = 'QueryGewinnspielTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "agb" , "antwort" , "datum" , "email" , "name"  ) [com.webobjects.directtoweb.Assignment] 
  402 : pageConfiguration = 'ListGewinnspielTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "agb" , "antwort" , "datum" , "email" , "name"  ) [com.webobjects.directtoweb.Assignment] 
  403 : pageConfiguration = 'InspectGewinnspielTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "agb" , "antwort" , "datum" , "email" , "name"  ) [com.webobjects.directtoweb.Assignment] 
  404 : pageConfiguration = 'EditGewinnspielTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "agb" , "antwort" , "datum" , "email" , "name"  ) [com.webobjects.directtoweb.Assignment] 
  405 : pageConfiguration = 'CreateGewinnspielTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "agb" , "antwort" , "datum" , "email" , "name"  ) [com.webobjects.directtoweb.Assignment] 
   
  // D3W

  200 : EN = '#' => crud = "0100" [com.webobjects.directtoweb.Assignment]
  600 : PC = 'EditRelationshipEmbedded#' => cruds = "00001" [com.webobjects.directtoweb.Assignment]
  
  401 : PC = 'Query#' => DPK = ("[MainTab]", "(MainSection)", "agb", "antwort", "datum", "email", "name") [com.webobjects.directtoweb.Assignment] 
  402 : PC = 'List#' => DPK = ("[MainTab]", "(MainSection)", "agb", "antwort", "datum", "email", "name") [com.webobjects.directtoweb.Assignment] 
  403 : PC = 'Inspect#' => DPK = ("[MainTab]", "(MainSection)", "agb", "antwort", "datum", "email", "name") [com.webobjects.directtoweb.Assignment] 
  404 : PC = 'Edit#' => DPK = ("[MainTab]", "(MainSection)", "agb", "antwort", "datum", "email", "name") [com.webobjects.directtoweb.Assignment] 
  405 : PC = 'Create#' => DPK = ("[MainTab]", "(MainSection)", "agb", "antwort", "datum", "email", "name") [com.webobjects.directtoweb.Assignment] 

 * ----------------------------------------
 */

package org.treasureboat.app.eo;

import org.treasureboat.app.eo.GewinnspielTBL;

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
public abstract class _GewinnspielTBL extends  TBEOGenericRecord  {

  private static final long serialVersionUID = 1L;

  /** 
   * <a href="http://wiki.wocommunity.org/display/documentation/Wonder+Logging">new org.slf4j.Logger</a> 
   */
  static final Logger log = LoggerFactory.getLogger(GewinnspielTBL.class);

  //********************************************************************
  //  Constructor : コンストラクター
  //********************************************************************

  public _GewinnspielTBL() {
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
  
  /** Entity Name = GewinnspielTBL */
  public static final String ENTITY_NAME = "GewinnspielTBL";

  //********************************************************************
  //  Access Properties : アクセス・プロパティ
  //********************************************************************
  
  protected static String ACCSESS_CREATE = "GewinnspielTBL.create";
  protected static String ACCSESS_READ = "GewinnspielTBL.read";
  protected static String ACCSESS_UPDATE = "GewinnspielTBL.update";
  protected static String ACCSESS_DELETE = "GewinnspielTBL.delete";

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
  
  protected static String BUTTON_INSPECT = "GewinnspielTBL.hide.inspect";
  protected static String BUTTON_EDIT = "GewinnspielTBL.hide.edit";
  protected static String BUTTON_DELETE = "GewinnspielTBL.hide.delete";
  protected static String BUTTON_REMOVE = "GewinnspielTBL.hide.remove";

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
  public static final ERXKey<Boolean> AGB = new ERXKey<Boolean>("agb");
  public static final ERXKey<String> ANTWORT = new ERXKey<String>("antwort");
  public static final ERXKey<NSTimestamp> DATUM = new ERXKey<NSTimestamp>("datum");
  public static final ERXKey<String> EMAIL = new ERXKey<String>("email");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");

  // Attributes
  public static final String AGB_KEY = AGB.key();
  public static final String ANTWORT_KEY = ANTWORT.key();
  public static final String DATUM_KEY = DATUM.key();
  public static final String EMAIL_KEY = EMAIL.key();
  public static final String NAME_KEY = NAME.key();

  //********************************************************************
  //  Relationship : リレーションシップ
  //********************************************************************

  // Relationship Keys

  // Relationships

  //********************************************************************
  //  clazz methods : クラス・メソッド
  //********************************************************************

  public static class _GewinnspielTBLClazz<T extends GewinnspielTBL> extends ERXGenericRecord.ERXGenericRecordClazz<T> {
    /* more clazz methods here */
  }

	public GewinnspielTBL.GewinnspielTBLClazz clazz() {
    return GewinnspielTBL.clazz;
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

  public Boolean agb() {
    return (Boolean) storedValueForKey(AGB_KEY);
  }

  public void setAgb(Boolean value) {
    if (_GewinnspielTBL.log.isDebugEnabled()) {
      _GewinnspielTBL.log.debug("updating agb from {} to {}", agb(), value);
    }
    takeStoredValueForKey(value, AGB_KEY);
  }

  public Object validateAgb(Object value) throws NSValidation.ValidationException {
    _GewinnspielTBL.log.debug("validate agb");
    return ERXValidationException.validateForUserInfo(this, AGB_KEY, value);
  }

  public String antwort() {
    return (String) storedValueForKey(ANTWORT_KEY);
  }

  public void setAntwort(String value) {
    if (_GewinnspielTBL.log.isDebugEnabled()) {
      _GewinnspielTBL.log.debug("updating antwort from {} to {}", antwort(), value);
    }
    takeStoredValueForKey(value, ANTWORT_KEY);
  }

  public Object validateAntwort(Object value) throws NSValidation.ValidationException {
    _GewinnspielTBL.log.debug("validate antwort");
    return ERXValidationException.validateForUserInfo(this, ANTWORT_KEY, value);
  }

  public NSTimestamp datum() {
    return (NSTimestamp) storedValueForKey(DATUM_KEY);
  }

  public void setDatum(NSTimestamp value) {
    if (_GewinnspielTBL.log.isDebugEnabled()) {
      _GewinnspielTBL.log.debug("updating datum from {} to {}", datum(), value);
    }
    takeStoredValueForKey(value, DATUM_KEY);
  }

  public Object validateDatum(Object value) throws NSValidation.ValidationException {
    _GewinnspielTBL.log.debug("validate datum");
    return ERXValidationException.validateForUserInfo(this, DATUM_KEY, value);
  }

  public String email() {
    return (String) storedValueForKey(EMAIL_KEY);
  }

  public void setEmail(String value) {
    if (_GewinnspielTBL.log.isDebugEnabled()) {
      _GewinnspielTBL.log.debug("updating email from {} to {}", email(), value);
    }
    takeStoredValueForKey(value, EMAIL_KEY);
  }

  public Object validateEmail(Object value) throws NSValidation.ValidationException {
    _GewinnspielTBL.log.debug("validate email");
    return ERXValidationException.validateForUserInfo(this, EMAIL_KEY, value);
  }

  public String name() {
    return (String) storedValueForKey(NAME_KEY);
  }

  public void setName(String value) {
    if (_GewinnspielTBL.log.isDebugEnabled()) {
      _GewinnspielTBL.log.debug("updating name from {} to {}", name(), value);
    }
    takeStoredValueForKey(value, NAME_KEY);
  }

  public Object validateName(Object value) throws NSValidation.ValidationException {
    _GewinnspielTBL.log.debug("validate name");
    return ERXValidationException.validateForUserInfo(this, NAME_KEY, value);
  }

  //********************************************************************
  //  ToOne relationship : ToOne リレーションシップ
  //********************************************************************

  //********************************************************************
  //  Editing Context replacement : 編集コンテキスト入れ替え
  //********************************************************************

  @Override
  public GewinnspielTBL localInstanceIn(EOEditingContext editingContext) {
    GewinnspielTBL localInstance = (GewinnspielTBL)EOUtilities.localInstanceOfObject(editingContext, this);
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

  public static GewinnspielTBL createGewinnspielTBL(EOEditingContext editingContext
   , Boolean agb
   , String antwort
   , NSTimestamp datum
   , String email
   , String name
    )
  {
    GewinnspielTBL eo = (GewinnspielTBL) EOUtilities.createAndInsertInstance(editingContext, _GewinnspielTBL.ENTITY_NAME);
    eo.setAgb(agb);
    eo.setAntwort(antwort);
    eo.setDatum(datum);
    eo.setEmail(email);
    eo.setName(name);
    return eo;
  }
  
  /* EO creation with Stamped EO Support */
  public static GewinnspielTBL createGewinnspielTBLWithStampedSupport(EOEditingContext editingContext
   , Boolean agb
   , String antwort
   , NSTimestamp datum
   , String email
   , String name
    )
  {
    GewinnspielTBL eo = (GewinnspielTBL) EOUtilities.createAndInsertInstance(editingContext, _GewinnspielTBL.ENTITY_NAME);
    eo.setAgb(agb);
    eo.setAntwort(antwort);
    eo.setDatum(datum);
    eo.setEmail(email);
    eo.setName(name);
    return eo;
  }

  public static GewinnspielTBL createAndInsertInstance(EOEditingContext context) {
    log.debug("{} : createAndInsertInstance", ENTITY_NAME);
    
    return (GewinnspielTBL)EOUtilities.createAndInsertInstance(context, ENTITY_NAME);
  }

  // ========== [検索関連] ==========
  //********************************************************************
  //  Fetch (NSArray) : フェッチ (NSArray)
  //********************************************************************

  public static ERXFetchSpecification<GewinnspielTBL> fetchSpec() {
    return new ERXFetchSpecification<GewinnspielTBL>(_GewinnspielTBL.ENTITY_NAME, null, null, false, true, null);
  }

  /* 
   * standard fetch 
   */
  public static NSArray<GewinnspielTBL> fetchAllGewinnspielTBLs(EOEditingContext editingContext) {
    return _GewinnspielTBL.fetchAllGewinnspielTBLs(editingContext, null);
  }

  public static NSArray<GewinnspielTBL> fetchAllGewinnspielTBLs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _GewinnspielTBL.fetchGewinnspielTBLs(editingContext, null, sortOrderings);
  }
 
  public static NSArray<GewinnspielTBL> fetchGewinnspielTBLs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_GewinnspielTBL.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<GewinnspielTBL> eoObjects = (NSArray<GewinnspielTBL>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  /* 
   * coreQualifier fetch 
   */  
  public static NSArray<GewinnspielTBL> fetchAllGewinnspielTBLsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain) {
    return _GewinnspielTBL.fetchAllGewinnspielTBLsWithCoreQualifier(editingContext, domain, null);
  }
  
  public static NSArray<GewinnspielTBL> fetchAllGewinnspielTBLsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain, NSArray<EOSortOrdering> sortOrderings) {
    TBEntity entity = TBEntity.entityNamed(editingContext, _GewinnspielTBL.ENTITY_NAME);
    return _GewinnspielTBL.fetchGewinnspielTBLs(editingContext, TBWCoreQualifierBase.delegate().qualifier(entity, domain), sortOrderings);
  }
  
  public static NSArray<GewinnspielTBL> fetchGewinnspielTBLsWithCoreQualifier(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    TBEntity entity = TBEntity.entityNamed(editingContext, _GewinnspielTBL.ENTITY_NAME);

    TBWMultiDomainSupport multiDomainSupport = TBSession.session().multiDomain();
    ITBWDomain domain = multiDomainSupport.currentDomain();

    TBEnterpriseAndQualifier andQualifier = new TBEnterpriseAndQualifier(TBWCoreQualifierBase.delegate().qualifier(entity, domain), qualifier);

    EOFetchSpecification fetchSpec = new EOFetchSpecification(_GewinnspielTBL.ENTITY_NAME, andQualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<GewinnspielTBL> eoObjects = (NSArray<GewinnspielTBL>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }  
  
  //********************************************************************
  //  Fetch (GewinnspielTBL) :  フェッチ (GewinnspielTBL)
  //********************************************************************
  
  public static GewinnspielTBL fetchGewinnspielTBL(EOEditingContext editingContext, String keyName, Object value) {
    return _GewinnspielTBL.fetchGewinnspielTBL(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static GewinnspielTBL fetchGewinnspielTBL(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<GewinnspielTBL> eoObjects = _GewinnspielTBL.fetchGewinnspielTBLs(editingContext, qualifier, null);
    GewinnspielTBL eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    } else if (count == 1) {
      eoObject = (GewinnspielTBL)eoObjects.objectAtIndex(0);
    } else {
      throw new IllegalStateException("There was more than one GewinnspielTBL that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static GewinnspielTBL fetchRequiredGewinnspielTBL(EOEditingContext editingContext, String keyName, Object value) {
    return _GewinnspielTBL.fetchRequiredGewinnspielTBL(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static GewinnspielTBL fetchRequiredGewinnspielTBL(EOEditingContext editingContext, EOQualifier qualifier) {
    GewinnspielTBL eoObject = _GewinnspielTBL.fetchGewinnspielTBL(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no GewinnspielTBL that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static GewinnspielTBL fetchGewinnspielTBLByPrimaryKey(EOEditingContext context, Object value) {
    EOEnterpriseObject eo = TBEOExternalPrimaryKeyHelper.objectWithPrimaryKeyValue(context, ENTITY_NAME, value);
    return (GewinnspielTBL) eo;
  }

  public static GewinnspielTBL fetchGewinnspielTBLByEncryptedPrimaryKey(EOEditingContext context, String value) {
    return GewinnspielTBL.fetchGewinnspielTBLByPrimaryKey(context, TBFCrypto.crypterForAlgorithm(TBFCrypto.BLOWFISH).decrypt(value));
  }
  
  public static GewinnspielTBL localInstanceIn(EOEditingContext editingContext, GewinnspielTBL eo) {
    GewinnspielTBL localInstance = (eo == null) ? null : (GewinnspielTBL)EOUtilities.localInstanceOfObject(editingContext, eo);
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
