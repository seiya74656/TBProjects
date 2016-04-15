//
// _GewinnspielTeilnehmer.java
//
// DO NOT EDIT. 
// Make changes to GewinnspielTeilnehmer.java instead.
//
// version 7.2
//
// 2008-2016 by TreasureBoat.org
//

/*
 * The following List is for Localization :
 * ----------------------------------------

  "Pages.QueryGewinnspielTeilnehmer" = "Query GewinnspielTeilnehmer";
  "Pages.ListGewinnspielTeilnehmer" = "List GewinnspielTeilnehmer";
  "Pages.InspectGewinnspielTeilnehmer" = "Inspect GewinnspielTeilnehmer";
  "Pages.EditGewinnspielTeilnehmer" = "Edit GewinnspielTeilnehmer";
  "Pages.CreateGewinnspielTeilnehmer" = "Create GewinnspielTeilnehmer";
  
  "Pages.QueryEmbeddedGewinnspielTeilnehmer" = "Query Embedded GewinnspielTeilnehmer";
  "Pages.ListEmbeddedGewinnspielTeilnehmer" = "List Embedded GewinnspielTeilnehmer";
  "Pages.InspectEmbeddedGewinnspielTeilnehmer" = "Inspect Embedded GewinnspielTeilnehmer";
  "Pages.EditEmbeddedGewinnspielTeilnehmer" = "Edit Embedded GewinnspielTeilnehmer";
  "Pages.CreateEmbeddedGewinnspielTeilnehmer" = "Create Embedded GewinnspielTeilnehmer";

  "PropertyKey.GewinnspielTeilnehmer.agb" = "agb";
  "PropertyKey.GewinnspielTeilnehmer.antwort" = "antwort";
  "PropertyKey.GewinnspielTeilnehmer.datum" = "datum";
  "PropertyKey.GewinnspielTeilnehmer.email" = "email";
  "PropertyKey.GewinnspielTeilnehmer.name" = "name";

 * ----------------------------------------
 */

/*
 * The following List is for D2W/D3W :
 * ----------------------------------------

  // D2W

  300 : entity.name = 'GewinnspielTeilnehmer' => isEntityEditable = "true" [com.webobjects.directtoweb.BooleanAssignment]

  100 : pageConfiguration like '*GewinnspielTeilnehmer' => navigationState = "XX.xx" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'CreateGewinnspielTeilnehmer' => navigationState = "XX.xx.createGewinnspielTeilnehmer" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'QueryGewinnspielTeilnehmer' => navigationState = "XX.xx.queryGewinnspielTeilnehmer" [com.webobjects.directtoweb.Assignment]
  
  401 : pageConfiguration = 'QueryGewinnspielTeilnehmer' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "agb" , "antwort" , "datum" , "email" , "name"  ) [com.webobjects.directtoweb.Assignment] 
  402 : pageConfiguration = 'ListGewinnspielTeilnehmer' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "agb" , "antwort" , "datum" , "email" , "name"  ) [com.webobjects.directtoweb.Assignment] 
  403 : pageConfiguration = 'InspectGewinnspielTeilnehmer' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "agb" , "antwort" , "datum" , "email" , "name"  ) [com.webobjects.directtoweb.Assignment] 
  404 : pageConfiguration = 'EditGewinnspielTeilnehmer' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "agb" , "antwort" , "datum" , "email" , "name"  ) [com.webobjects.directtoweb.Assignment] 
  405 : pageConfiguration = 'CreateGewinnspielTeilnehmer' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "agb" , "antwort" , "datum" , "email" , "name"  ) [com.webobjects.directtoweb.Assignment] 
   
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

import org.treasureboat.app.eo.GewinnspielTeilnehmer;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.treasureboat.enterprise.eof.TBEOExternalPrimaryKeyHelper;
import org.treasureboat.enterprise.eof.TBEOGenericRecord;
import org.treasureboat.enterprise.eof.delete.ITBEnterpriseVirtualDeleteSupport;
import org.treasureboat.foundation.NSData;
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
public abstract class _GewinnspielTeilnehmer extends  TBEOGenericRecord {

  private static final long serialVersionUID = 1L;

  /** 
   * <a href="http://wiki.wocommunity.org/display/documentation/Wonder+Logging">new org.slf4j.Logger</a> 
   */
  static final Logger log = LoggerFactory.getLogger(GewinnspielTeilnehmer.class);

  //********************************************************************
  //  Constructor : コンストラクター
  //********************************************************************

  public _GewinnspielTeilnehmer() {
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
  
  /** Entity Name = GewinnspielTeilnehmer */
  public static final String ENTITY_NAME = "GewinnspielTeilnehmer";

  //********************************************************************
  //  Access Properties : アクセス・プロパティ
  //********************************************************************
  
  protected static String ACCSESS_CREATE = "GewinnspielTeilnehmer.create";
  protected static String ACCSESS_READ = "GewinnspielTeilnehmer.read";
  protected static String ACCSESS_UPDATE = "GewinnspielTeilnehmer.update";
  protected static String ACCSESS_DELETE = "GewinnspielTeilnehmer.delete";

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
  public static final ERXKey<Integer> ANTWORT = new ERXKey<Integer>("antwort");
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

  public static class _GewinnspielTeilnehmerClazz<T extends GewinnspielTeilnehmer> extends ERXGenericRecord.ERXGenericRecordClazz<T> {
    /* more clazz methods here */
  }

	public GewinnspielTeilnehmer.GewinnspielTeilnehmerClazz clazz() {
    return GewinnspielTeilnehmer.clazz;
  }

  //********************************************************************
  //  Attribute Accessor : アトリビュート・アクセス
  //********************************************************************

  public Boolean agb() {
    return (Boolean) storedValueForKey(AGB_KEY);
  }

  public void setAgb(Boolean value) {
    if (_GewinnspielTeilnehmer.log.isDebugEnabled()) {
      _GewinnspielTeilnehmer.log.debug("updating agb from {} to {}", agb(), value);
    }
    takeStoredValueForKey(value, AGB_KEY);
  }

  public Object validateAgb(Object value) throws NSValidation.ValidationException {
    _GewinnspielTeilnehmer.log.debug("validate agb");
    return ERXValidationException.validateForUserInfo(this, AGB_KEY, value);
  }

  public Integer antwort() {
    return (Integer) storedValueForKey(ANTWORT_KEY);
  }

  public void setAntwort(Integer value) {
    if (_GewinnspielTeilnehmer.log.isDebugEnabled()) {
      _GewinnspielTeilnehmer.log.debug("updating antwort from {} to {}", antwort(), value);
    }
    takeStoredValueForKey(value, ANTWORT_KEY);
  }

  public Object validateAntwort(Object value) throws NSValidation.ValidationException {
    _GewinnspielTeilnehmer.log.debug("validate antwort");
    return ERXValidationException.validateForUserInfo(this, ANTWORT_KEY, value);
  }

  public NSTimestamp datum() {
    return (NSTimestamp) storedValueForKey(DATUM_KEY);
  }

  public void setDatum(NSTimestamp value) {
    if (_GewinnspielTeilnehmer.log.isDebugEnabled()) {
      _GewinnspielTeilnehmer.log.debug("updating datum from {} to {}", datum(), value);
    }
    takeStoredValueForKey(value, DATUM_KEY);
  }

  public Object validateDatum(Object value) throws NSValidation.ValidationException {
    _GewinnspielTeilnehmer.log.debug("validate datum");
    return ERXValidationException.validateForUserInfo(this, DATUM_KEY, value);
  }

  public String email() {
    return (String) storedValueForKey(EMAIL_KEY);
  }

  public void setEmail(String value) {
    if (_GewinnspielTeilnehmer.log.isDebugEnabled()) {
      _GewinnspielTeilnehmer.log.debug("updating email from {} to {}", email(), value);
    }
    takeStoredValueForKey(value, EMAIL_KEY);
  }

  public Object validateEmail(Object value) throws NSValidation.ValidationException {
    _GewinnspielTeilnehmer.log.debug("validate email");
    return ERXValidationException.validateForUserInfo(this, EMAIL_KEY, value);
  }

  public String name() {
    return (String) storedValueForKey(NAME_KEY);
  }

  public void setName(String value) {
    if (_GewinnspielTeilnehmer.log.isDebugEnabled()) {
      _GewinnspielTeilnehmer.log.debug("updating name from {} to {}", name(), value);
    }
    takeStoredValueForKey(value, NAME_KEY);
  }

  public Object validateName(Object value) throws NSValidation.ValidationException {
    _GewinnspielTeilnehmer.log.debug("validate name");
    return ERXValidationException.validateForUserInfo(this, NAME_KEY, value);
  }

  //********************************************************************
  //  ToOne relationship : ToOne リレーションシップ
  //********************************************************************

  //********************************************************************
  //  Editing Context replacement : 編集コンテキスト入れ替え
  //********************************************************************

  @Override
  public GewinnspielTeilnehmer localInstanceIn(EOEditingContext editingContext) {
    GewinnspielTeilnehmer localInstance = (GewinnspielTeilnehmer)EOUtilities.localInstanceOfObject(editingContext, this);
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

  public static GewinnspielTeilnehmer createGewinnspielTeilnehmer(EOEditingContext editingContext
   , Boolean agb
   , Integer antwort
   , NSTimestamp datum
   , String email
   , String name
    )
  {
    GewinnspielTeilnehmer eo = (GewinnspielTeilnehmer) EOUtilities.createAndInsertInstance(editingContext, _GewinnspielTeilnehmer.ENTITY_NAME);
    eo.setAgb(agb);
    eo.setAntwort(antwort);
    eo.setDatum(datum);
    eo.setEmail(email);
    eo.setName(name);
    return eo;
  }
  
  /* EO creation with Stamped EO Support */
  public static GewinnspielTeilnehmer createGewinnspielTeilnehmerWithStampedSupport(EOEditingContext editingContext
   , Boolean agb
   , Integer antwort
   , NSTimestamp datum
   , String email
   , String name
    )
  {
    GewinnspielTeilnehmer eo = (GewinnspielTeilnehmer) EOUtilities.createAndInsertInstance(editingContext, _GewinnspielTeilnehmer.ENTITY_NAME);
    eo.setAgb(agb);
    eo.setAntwort(antwort);
    eo.setDatum(datum);
    eo.setEmail(email);
    eo.setName(name);
    return eo;
  }

  public static GewinnspielTeilnehmer createAndInsertInstance(EOEditingContext context) {
    log.debug("{} : createAndInsertInstance", ENTITY_NAME);
    
    return (GewinnspielTeilnehmer)EOUtilities.createAndInsertInstance(context, ENTITY_NAME);
  }

  // ========== [検索関連] ==========
  //********************************************************************
  //  Fetch (NSArray) : フェッチ (NSArray)
  //********************************************************************

  public static ERXFetchSpecification<GewinnspielTeilnehmer> fetchSpec() {
    return new ERXFetchSpecification<GewinnspielTeilnehmer>(_GewinnspielTeilnehmer.ENTITY_NAME, null, null, false, true, null);
  }

  /* 
   * standard fetch 
   */
  public static NSArray<GewinnspielTeilnehmer> fetchAllGewinnspielTeilnehmers(EOEditingContext editingContext) {
    return _GewinnspielTeilnehmer.fetchAllGewinnspielTeilnehmers(editingContext, null);
  }

  public static NSArray<GewinnspielTeilnehmer> fetchAllGewinnspielTeilnehmers(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _GewinnspielTeilnehmer.fetchGewinnspielTeilnehmers(editingContext, null, sortOrderings);
  }
 
  public static NSArray<GewinnspielTeilnehmer> fetchGewinnspielTeilnehmers(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_GewinnspielTeilnehmer.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<GewinnspielTeilnehmer> eoObjects = (NSArray<GewinnspielTeilnehmer>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  /* 
   * coreQualifier fetch 
   */  
  public static NSArray<GewinnspielTeilnehmer> fetchAllGewinnspielTeilnehmersWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain) {
    return _GewinnspielTeilnehmer.fetchAllGewinnspielTeilnehmersWithCoreQualifier(editingContext, domain, null);
  }
  
  public static NSArray<GewinnspielTeilnehmer> fetchAllGewinnspielTeilnehmersWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain, NSArray<EOSortOrdering> sortOrderings) {
    EOEntity entity = ERXEOAccessUtilities.entityNamed(editingContext, _GewinnspielTeilnehmer.ENTITY_NAME);
    return _GewinnspielTeilnehmer.fetchGewinnspielTeilnehmers(editingContext, TBWCoreQualifierBase.delegate().qualifier(entity, domain), sortOrderings);
  }
  
  public static NSArray<GewinnspielTeilnehmer> fetchGewinnspielTeilnehmersWithCoreQualifier(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOEntity entity = ERXEOAccessUtilities.entityNamed(editingContext, _GewinnspielTeilnehmer.ENTITY_NAME);

    TBWMultiDomainSupport multiDomainSupport = (TBWMultiDomainSupport) TBSession.session().multiDomain();
    ITBWDomain domain = multiDomainSupport.currentDomain();

    ERXAndQualifier andQualifier = new ERXAndQualifier(TBWCoreQualifierBase.delegate().qualifier(entity, domain), qualifier);

    EOFetchSpecification fetchSpec = new EOFetchSpecification(_GewinnspielTeilnehmer.ENTITY_NAME, andQualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<GewinnspielTeilnehmer> eoObjects = (NSArray<GewinnspielTeilnehmer>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }  
  
  //********************************************************************
  //  Fetch (GewinnspielTeilnehmer) :  フェッチ (GewinnspielTeilnehmer)
  //********************************************************************
  
  public static GewinnspielTeilnehmer fetchGewinnspielTeilnehmer(EOEditingContext editingContext, String keyName, Object value) {
    return _GewinnspielTeilnehmer.fetchGewinnspielTeilnehmer(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static GewinnspielTeilnehmer fetchGewinnspielTeilnehmer(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<GewinnspielTeilnehmer> eoObjects = _GewinnspielTeilnehmer.fetchGewinnspielTeilnehmers(editingContext, qualifier, null);
    GewinnspielTeilnehmer eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    } else if (count == 1) {
      eoObject = (GewinnspielTeilnehmer)eoObjects.objectAtIndex(0);
    } else {
      throw new IllegalStateException("There was more than one GewinnspielTeilnehmer that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static GewinnspielTeilnehmer fetchRequiredGewinnspielTeilnehmer(EOEditingContext editingContext, String keyName, Object value) {
    return _GewinnspielTeilnehmer.fetchRequiredGewinnspielTeilnehmer(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static GewinnspielTeilnehmer fetchRequiredGewinnspielTeilnehmer(EOEditingContext editingContext, EOQualifier qualifier) {
    GewinnspielTeilnehmer eoObject = _GewinnspielTeilnehmer.fetchGewinnspielTeilnehmer(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no GewinnspielTeilnehmer that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static GewinnspielTeilnehmer fetchGewinnspielTeilnehmerByPrimaryKey(EOEditingContext context, Object value) {
    EOEnterpriseObject eo = TBEOExternalPrimaryKeyHelper.objectWithPrimaryKeyValue(context, ENTITY_NAME, value);
    return (GewinnspielTeilnehmer) eo;
  }

  public static GewinnspielTeilnehmer fetchGewinnspielTeilnehmerByEncryptedPrimaryKey(EOEditingContext context, String value) {
    return GewinnspielTeilnehmer.fetchGewinnspielTeilnehmerByPrimaryKey(context, TBFCrypto.crypterForAlgorithm(TBFCrypto.BLOWFISH).decrypt(value));
  }
  
  public static GewinnspielTeilnehmer localInstanceIn(EOEditingContext editingContext, GewinnspielTeilnehmer eo) {
    GewinnspielTeilnehmer localInstance = (eo == null) ? null : (GewinnspielTeilnehmer)EOUtilities.localInstanceOfObject(editingContext, eo);
    if (localInstance == null && eo != null) {
      throw new IllegalStateException("You attempted to localInstance " + eo + ", which has not yet committed.");
    }
    return localInstance;
  }

  //********************************************************************
  //  TBEnterpriseCopyable
  //********************************************************************


  //********************************************************************
  //  Fetch specification : フェッチ・スペシフィケーション
  //********************************************************************

}
