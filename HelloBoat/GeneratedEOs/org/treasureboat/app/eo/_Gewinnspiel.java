//
// _Gewinnspiel.java
//
// DO NOT EDIT. 
// Make changes to Gewinnspiel.java instead.
//
// version 7.1.3
//
// 2008-2014 by TreasureBoat.org
//

/*
 * The following List is for Localization :
 * ----------------------------------------

  "Pages.QueryGewinnspiel" = "Query Gewinnspiel";
  "Pages.ListGewinnspiel" = "List Gewinnspiel";
  "Pages.InspectGewinnspiel" = "Inspect Gewinnspiel";
  "Pages.EditGewinnspiel" = "Edit Gewinnspiel";
  "Pages.CreateGewinnspiel" = "Create Gewinnspiel";
  
  "Pages.QueryEmbeddedGewinnspiel" = "Query Embedded Gewinnspiel";
  "Pages.ListEmbeddedGewinnspiel" = "List Embedded Gewinnspiel";
  "Pages.InspectEmbeddedGewinnspiel" = "Inspect Embedded Gewinnspiel";
  "Pages.EditEmbeddedGewinnspiel" = "Edit Embedded Gewinnspiel";
  "Pages.CreateEmbeddedGewinnspiel" = "Create Embedded Gewinnspiel";

  "PropertyKey.agb" = "agb";
  "PropertyKey.antwort" = "antwort";
  "PropertyKey.datum" = "datum";
  "PropertyKey.email" = "email";
  "PropertyKey.name" = "name";

 * ----------------------------------------
 */

/*
 * The following List is for D2W/D3W :
 * ----------------------------------------

  // D2W

  300 : entity.name = 'Gewinnspiel' => isEntityEditable = "true" [com.webobjects.directtoweb.BooleanAssignment]

  100 : pageConfiguration like '*Gewinnspiel' => navigationState = "XX.xx" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'CreateGewinnspiel' => navigationState = "XX.xx.createGewinnspiel" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'QueryGewinnspiel' => navigationState = "XX.xx.queryGewinnspiel" [com.webobjects.directtoweb.Assignment]
  
  401 : pageConfiguration = 'QueryGewinnspiel' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "agb" , "antwort" , "datum" , "email" , "name"  ) [com.webobjects.directtoweb.Assignment] 
  402 : pageConfiguration = 'ListGewinnspiel' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "agb" , "antwort" , "datum" , "email" , "name"  ) [com.webobjects.directtoweb.Assignment] 
  403 : pageConfiguration = 'InspectGewinnspiel' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "agb" , "antwort" , "datum" , "email" , "name"  ) [com.webobjects.directtoweb.Assignment] 
  404 : pageConfiguration = 'EditGewinnspiel' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "agb" , "antwort" , "datum" , "email" , "name"  ) [com.webobjects.directtoweb.Assignment] 
  405 : pageConfiguration = 'CreateGewinnspiel' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "agb" , "antwort" , "datum" , "email" , "name"  ) [com.webobjects.directtoweb.Assignment] 
   
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

import org.treasureboat.app.eo.Gewinnspiel;

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
public abstract class _Gewinnspiel extends  TBEOGenericRecord {

  private static final long serialVersionUID = 1L;

  /** 
   * <a href="http://wiki.wocommunity.org/display/documentation/Wonder+Logging">new org.slf4j.Logger</a> 
   */
  static final Logger log = LoggerFactory.getLogger(Gewinnspiel.class);

  //********************************************************************
  //  Constructor : コンストラクター
  //********************************************************************

  public _Gewinnspiel() {
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
  
  /** Entity Name = Gewinnspiel */
  public static final String ENTITY_NAME = "Gewinnspiel";

  //********************************************************************
  //  Access Properties : アクセス・プロパティ
  //********************************************************************
  
  protected static String ACCSESS_CREATE = "Gewinnspiel.create";
  protected static String ACCSESS_READ = "Gewinnspiel.read";
  protected static String ACCSESS_UPDATE = "Gewinnspiel.update";
  protected static String ACCSESS_DELETE = "Gewinnspiel.delete";

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

  public static class _GewinnspielClazz<T extends Gewinnspiel> extends ERXGenericRecord.ERXGenericRecordClazz<T> {
    /* more clazz methods here */
  }

	public Gewinnspiel.GewinnspielClazz clazz() {
    return Gewinnspiel.clazz;
  }

  //********************************************************************
  //  Attribute Accessor : アトリビュート・アクセス
  //********************************************************************

  public Boolean agb() {
    return (Boolean) storedValueForKey(AGB_KEY);
  }

  public void setAgb(Boolean value) {
    if (_Gewinnspiel.log.isDebugEnabled()) {
      _Gewinnspiel.log.debug("updating agb from {} to {}", agb(), value);
    }
    takeStoredValueForKey(value, AGB_KEY);
  }

  public Object validateAgb(Object value) throws NSValidation.ValidationException {
    _Gewinnspiel.log.debug("validate agb");
    return ERXValidationException.validateForUserInfo(this, AGB_KEY, value);
  }

  public String antwort() {
    return (String) storedValueForKey(ANTWORT_KEY);
  }

  public void setAntwort(String value) {
    if (_Gewinnspiel.log.isDebugEnabled()) {
      _Gewinnspiel.log.debug("updating antwort from {} to {}", antwort(), value);
    }
    takeStoredValueForKey(value, ANTWORT_KEY);
  }

  public Object validateAntwort(Object value) throws NSValidation.ValidationException {
    _Gewinnspiel.log.debug("validate antwort");
    return ERXValidationException.validateForUserInfo(this, ANTWORT_KEY, value);
  }

  public NSTimestamp datum() {
    return (NSTimestamp) storedValueForKey(DATUM_KEY);
  }

  public void setDatum(NSTimestamp value) {
    if (_Gewinnspiel.log.isDebugEnabled()) {
      _Gewinnspiel.log.debug("updating datum from {} to {}", datum(), value);
    }
    takeStoredValueForKey(value, DATUM_KEY);
  }

  public Object validateDatum(Object value) throws NSValidation.ValidationException {
    _Gewinnspiel.log.debug("validate datum");
    return ERXValidationException.validateForUserInfo(this, DATUM_KEY, value);
  }

  public String email() {
    return (String) storedValueForKey(EMAIL_KEY);
  }

  public void setEmail(String value) {
    if (_Gewinnspiel.log.isDebugEnabled()) {
      _Gewinnspiel.log.debug("updating email from {} to {}", email(), value);
    }
    takeStoredValueForKey(value, EMAIL_KEY);
  }

  public Object validateEmail(Object value) throws NSValidation.ValidationException {
    _Gewinnspiel.log.debug("validate email");
    return ERXValidationException.validateForUserInfo(this, EMAIL_KEY, value);
  }

  public String name() {
    return (String) storedValueForKey(NAME_KEY);
  }

  public void setName(String value) {
    if (_Gewinnspiel.log.isDebugEnabled()) {
      _Gewinnspiel.log.debug("updating name from {} to {}", name(), value);
    }
    takeStoredValueForKey(value, NAME_KEY);
  }

  public Object validateName(Object value) throws NSValidation.ValidationException {
    _Gewinnspiel.log.debug("validate name");
    return ERXValidationException.validateForUserInfo(this, NAME_KEY, value);
  }

  //********************************************************************
  //  ToOne relationship : ToOne リレーションシップ
  //********************************************************************

  //********************************************************************
  //  Editing Context replacement : 編集コンテキスト入れ替え
  //********************************************************************

  @Override
  public Gewinnspiel localInstanceIn(EOEditingContext editingContext) {
    Gewinnspiel localInstance = (Gewinnspiel)EOUtilities.localInstanceOfObject(editingContext, this);
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

  public static Gewinnspiel createGewinnspiel(EOEditingContext editingContext
   , Boolean agb
   , String antwort
   , NSTimestamp datum
   , String email
   , String name
    )
  {
    Gewinnspiel eo = (Gewinnspiel) EOUtilities.createAndInsertInstance(editingContext, _Gewinnspiel.ENTITY_NAME);
    eo.setAgb(agb);
    eo.setAntwort(antwort);
    eo.setDatum(datum);
    eo.setEmail(email);
    eo.setName(name);
    return eo;
  }
  
  /* EO creation with Stamped EO Support */
  public static Gewinnspiel createGewinnspielWithStampedSupport(EOEditingContext editingContext
   , Boolean agb
   , String antwort
   , NSTimestamp datum
   , String email
   , String name
    )
  {
    Gewinnspiel eo = (Gewinnspiel) EOUtilities.createAndInsertInstance(editingContext, _Gewinnspiel.ENTITY_NAME);
    eo.setAgb(agb);
    eo.setAntwort(antwort);
    eo.setDatum(datum);
    eo.setEmail(email);
    eo.setName(name);
    return eo;
  }

  public static Gewinnspiel createAndInsertInstance(EOEditingContext context) {
    log.debug("{} : createAndInsertInstance", ENTITY_NAME);
    
    return (Gewinnspiel)EOUtilities.createAndInsertInstance(context, ENTITY_NAME);
  }

  // ========== [検索関連] ==========
  //********************************************************************
  //  Fetch (NSArray) : フェッチ (NSArray)
  //********************************************************************

  public static ERXFetchSpecification<Gewinnspiel> fetchSpec() {
    return new ERXFetchSpecification<Gewinnspiel>(_Gewinnspiel.ENTITY_NAME, null, null, false, true, null);
  }

  /* 
   * standard fetch 
   */
  public static NSArray<Gewinnspiel> fetchAllGewinnspiels(EOEditingContext editingContext) {
    return _Gewinnspiel.fetchAllGewinnspiels(editingContext, null);
  }

  public static NSArray<Gewinnspiel> fetchAllGewinnspiels(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Gewinnspiel.fetchGewinnspiels(editingContext, null, sortOrderings);
  }
 
  public static NSArray<Gewinnspiel> fetchGewinnspiels(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Gewinnspiel.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Gewinnspiel> eoObjects = (NSArray<Gewinnspiel>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  /* 
   * coreQualifier fetch 
   */  
  public static NSArray<Gewinnspiel> fetchAllGewinnspielsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain) {
    return _Gewinnspiel.fetchAllGewinnspielsWithCoreQualifier(editingContext, domain, null);
  }
  
  public static NSArray<Gewinnspiel> fetchAllGewinnspielsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain, NSArray<EOSortOrdering> sortOrderings) {
    EOEntity entity = ERXEOAccessUtilities.entityNamed(editingContext, _Gewinnspiel.ENTITY_NAME);
    return _Gewinnspiel.fetchGewinnspiels(editingContext, TBWCoreQualifierBase.delegate().qualifier(entity, domain), sortOrderings);
  }
  
  public static NSArray<Gewinnspiel> fetchGewinnspielsWithCoreQualifier(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOEntity entity = ERXEOAccessUtilities.entityNamed(editingContext, _Gewinnspiel.ENTITY_NAME);

    TBWMultiDomainSupport multiDomainSupport = (TBWMultiDomainSupport) TBSession.session().multiDomain();
    ITBWDomain domain = multiDomainSupport.currentDomain();

    ERXAndQualifier andQualifier = new ERXAndQualifier(TBWCoreQualifierBase.delegate().qualifier(entity, domain), qualifier);

    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Gewinnspiel.ENTITY_NAME, andQualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Gewinnspiel> eoObjects = (NSArray<Gewinnspiel>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }  
  
  //********************************************************************
  //  Fetch (Gewinnspiel) :  フェッチ (Gewinnspiel)
  //********************************************************************
  
  public static Gewinnspiel fetchGewinnspiel(EOEditingContext editingContext, String keyName, Object value) {
    return _Gewinnspiel.fetchGewinnspiel(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Gewinnspiel fetchGewinnspiel(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Gewinnspiel> eoObjects = _Gewinnspiel.fetchGewinnspiels(editingContext, qualifier, null);
    Gewinnspiel eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    } else if (count == 1) {
      eoObject = (Gewinnspiel)eoObjects.objectAtIndex(0);
    } else {
      throw new IllegalStateException("There was more than one Gewinnspiel that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Gewinnspiel fetchRequiredGewinnspiel(EOEditingContext editingContext, String keyName, Object value) {
    return _Gewinnspiel.fetchRequiredGewinnspiel(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Gewinnspiel fetchRequiredGewinnspiel(EOEditingContext editingContext, EOQualifier qualifier) {
    Gewinnspiel eoObject = _Gewinnspiel.fetchGewinnspiel(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Gewinnspiel that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Gewinnspiel fetchGewinnspielByPrimaryKey(EOEditingContext context, Object value) {
    EOEnterpriseObject eo = TBEOExternalPrimaryKeyHelper.objectWithPrimaryKeyValue(context, ENTITY_NAME, value);
    return (Gewinnspiel) eo;
  }

  public static Gewinnspiel fetchGewinnspielByEncryptedPrimaryKey(EOEditingContext context, String value) {
    return Gewinnspiel.fetchGewinnspielByPrimaryKey(context, TBFCrypto.crypterForAlgorithm(TBFCrypto.BLOWFISH).decrypt(value));
  }
  
  public static Gewinnspiel localInstanceIn(EOEditingContext editingContext, Gewinnspiel eo) {
    Gewinnspiel localInstance = (eo == null) ? null : (Gewinnspiel)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }

  //********************************************************************
  //  Fetch specification : フェッチ・スペシフィケーション
  //********************************************************************

}
