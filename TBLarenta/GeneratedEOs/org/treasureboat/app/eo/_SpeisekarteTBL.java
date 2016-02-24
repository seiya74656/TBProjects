//
// _SpeisekarteTBL.java
//
// DO NOT EDIT. 
// Make changes to SpeisekarteTBL.java instead.
//
// version 7.2
//
// 2008-2016 by TreasureBoat.org
//

/*
 * The following List is for Localization :
 * ----------------------------------------

  "Pages.QuerySpeisekarteTBL" = "Query SpeisekarteTBL";
  "Pages.ListSpeisekarteTBL" = "List SpeisekarteTBL";
  "Pages.InspectSpeisekarteTBL" = "Inspect SpeisekarteTBL";
  "Pages.EditSpeisekarteTBL" = "Edit SpeisekarteTBL";
  "Pages.CreateSpeisekarteTBL" = "Create SpeisekarteTBL";
  
  "Pages.QueryEmbeddedSpeisekarteTBL" = "Query Embedded SpeisekarteTBL";
  "Pages.ListEmbeddedSpeisekarteTBL" = "List Embedded SpeisekarteTBL";
  "Pages.InspectEmbeddedSpeisekarteTBL" = "Inspect Embedded SpeisekarteTBL";
  "Pages.EditEmbeddedSpeisekarteTBL" = "Edit Embedded SpeisekarteTBL";
  "Pages.CreateEmbeddedSpeisekarteTBL" = "Create Embedded SpeisekarteTBL";

  "PropertyKey.SpeisekarteTBL.beschreibung" = "beschreibung";
  "PropertyKey.SpeisekarteTBL.name" = "name";
  "PropertyKey.SpeisekarteTBL.preis" = "preis";
  "PropertyKey.SpeisekarteTBL.sortorder" = "sortorder";
  "PropertyKey.SpeisekarteTBL.sprache" = "sprache";

  "PropertyKey.SpeisekarteTBL.allergenInfoTBLs" = "allergenInfoTBLs";
 * ----------------------------------------
 */

/*
 * The following List is for D2W/D3W :
 * ----------------------------------------

  // D2W

  300 : entity.name = 'SpeisekarteTBL' => isEntityEditable = "true" [com.webobjects.directtoweb.BooleanAssignment]

  100 : pageConfiguration like '*SpeisekarteTBL' => navigationState = "XX.xx" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'CreateSpeisekarteTBL' => navigationState = "XX.xx.createSpeisekarteTBL" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'QuerySpeisekarteTBL' => navigationState = "XX.xx.querySpeisekarteTBL" [com.webobjects.directtoweb.Assignment]
  
  401 : pageConfiguration = 'QuerySpeisekarteTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "beschreibung" , "name" , "preis" , "sortorder" , "sprache"  , "allergenInfoTBLs" ) [com.webobjects.directtoweb.Assignment] 
  402 : pageConfiguration = 'ListSpeisekarteTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "beschreibung" , "name" , "preis" , "sortorder" , "sprache"  , "allergenInfoTBLs" ) [com.webobjects.directtoweb.Assignment] 
  403 : pageConfiguration = 'InspectSpeisekarteTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "beschreibung" , "name" , "preis" , "sortorder" , "sprache"  , "allergenInfoTBLs" ) [com.webobjects.directtoweb.Assignment] 
  404 : pageConfiguration = 'EditSpeisekarteTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "beschreibung" , "name" , "preis" , "sortorder" , "sprache"  , "allergenInfoTBLs" ) [com.webobjects.directtoweb.Assignment] 
  405 : pageConfiguration = 'CreateSpeisekarteTBL' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "beschreibung" , "name" , "preis" , "sortorder" , "sprache"  , "allergenInfoTBLs" ) [com.webobjects.directtoweb.Assignment] 
   
  // D3W

  200 : EN = '#' => crud = "0100" [com.webobjects.directtoweb.Assignment]
  600 : PC = 'EditRelationshipEmbedded#' => cruds = "00001" [com.webobjects.directtoweb.Assignment]
  
  401 : PC = 'Query#' => DPK = ("[MainTab]", "(MainSection)", "beschreibung", "name", "preis", "sortorder", "sprache", "allergenInfoTBLs" ) [com.webobjects.directtoweb.Assignment] 
  402 : PC = 'List#' => DPK = ("[MainTab]", "(MainSection)", "beschreibung", "name", "preis", "sortorder", "sprache", "allergenInfoTBLs" ) [com.webobjects.directtoweb.Assignment] 
  403 : PC = 'Inspect#' => DPK = ("[MainTab]", "(MainSection)", "beschreibung", "name", "preis", "sortorder", "sprache", "allergenInfoTBLs" ) [com.webobjects.directtoweb.Assignment] 
  404 : PC = 'Edit#' => DPK = ("[MainTab]", "(MainSection)", "beschreibung", "name", "preis", "sortorder", "sprache", "allergenInfoTBLs" ) [com.webobjects.directtoweb.Assignment] 
  405 : PC = 'Create#' => DPK = ("[MainTab]", "(MainSection)", "beschreibung", "name", "preis", "sortorder", "sprache", "allergenInfoTBLs" ) [com.webobjects.directtoweb.Assignment] 

 * ----------------------------------------
 */

package org.treasureboat.app.eo;

import org.treasureboat.app.eo.SpeisekarteTBL;

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
public abstract class _SpeisekarteTBL extends  TBEOGenericRecord {

  private static final long serialVersionUID = 1L;

  /** 
   * <a href="http://wiki.wocommunity.org/display/documentation/Wonder+Logging">new org.slf4j.Logger</a> 
   */
  static final Logger log = LoggerFactory.getLogger(SpeisekarteTBL.class);

  //********************************************************************
  //  Constructor : コンストラクター
  //********************************************************************

  public _SpeisekarteTBL() {
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
  
  /** Entity Name = SpeisekarteTBL */
  public static final String ENTITY_NAME = "SpeisekarteTBL";

  //********************************************************************
  //  Access Properties : アクセス・プロパティ
  //********************************************************************
  
  protected static String ACCSESS_CREATE = "SpeisekarteTBL.create";
  protected static String ACCSESS_READ = "SpeisekarteTBL.read";
  protected static String ACCSESS_UPDATE = "SpeisekarteTBL.update";
  protected static String ACCSESS_DELETE = "SpeisekarteTBL.delete";

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
  public static final ERXKey<String> BESCHREIBUNG = new ERXKey<String>("beschreibung");
  public static final ERXKey<String> NAME = new ERXKey<String>("name");
  public static final ERXKey<Double> PREIS = new ERXKey<Double>("preis");
  public static final ERXKey<Integer> SORTORDER = new ERXKey<Integer>("sortorder");
  public static final ERXKey<String> SPRACHE = new ERXKey<String>("sprache");

  // Attributes
  public static final String BESCHREIBUNG_KEY = BESCHREIBUNG.key();
  public static final String NAME_KEY = NAME.key();
  public static final String PREIS_KEY = PREIS.key();
  public static final String SORTORDER_KEY = SORTORDER.key();
  public static final String SPRACHE_KEY = SPRACHE.key();

  //********************************************************************
  //  Relationship : リレーションシップ
  //********************************************************************

  // Relationship Keys
  public static final ERXKey<org.treasureboat.app.eo.AllergenInfoTBL> ALLERGEN_INFO_TB_LS = new ERXKey<org.treasureboat.app.eo.AllergenInfoTBL>("allergenInfoTBLs");

  // Relationships
  public static final String ALLERGEN_INFO_TB_LS_KEY = ALLERGEN_INFO_TB_LS.key();

  //********************************************************************
  //  clazz methods : クラス・メソッド
  //********************************************************************

  public static class _SpeisekarteTBLClazz<T extends SpeisekarteTBL> extends ERXGenericRecord.ERXGenericRecordClazz<T> {
    /* more clazz methods here */
  }

	public SpeisekarteTBL.SpeisekarteTBLClazz clazz() {
    return SpeisekarteTBL.clazz;
  }

  //********************************************************************
  //  Attribute Accessor : アトリビュート・アクセス
  //********************************************************************

  public String beschreibung() {
    return (String) storedValueForKey(BESCHREIBUNG_KEY);
  }

  public void setBeschreibung(String value) {
    if (_SpeisekarteTBL.log.isDebugEnabled()) {
      _SpeisekarteTBL.log.debug("updating beschreibung from {} to {}", beschreibung(), value);
    }
    takeStoredValueForKey(value, BESCHREIBUNG_KEY);
  }

  public Object validateBeschreibung(Object value) throws NSValidation.ValidationException {
    _SpeisekarteTBL.log.debug("validate beschreibung");
    return ERXValidationException.validateForUserInfo(this, BESCHREIBUNG_KEY, value);
  }

  public String name() {
    return (String) storedValueForKey(NAME_KEY);
  }

  public void setName(String value) {
    if (_SpeisekarteTBL.log.isDebugEnabled()) {
      _SpeisekarteTBL.log.debug("updating name from {} to {}", name(), value);
    }
    takeStoredValueForKey(value, NAME_KEY);
  }

  public Object validateName(Object value) throws NSValidation.ValidationException {
    _SpeisekarteTBL.log.debug("validate name");
    return ERXValidationException.validateForUserInfo(this, NAME_KEY, value);
  }

  public Double preis() {
    return (Double) storedValueForKey(PREIS_KEY);
  }

  public void setPreis(Double value) {
    if (_SpeisekarteTBL.log.isDebugEnabled()) {
      _SpeisekarteTBL.log.debug("updating preis from {} to {}", preis(), value);
    }
    takeStoredValueForKey(value, PREIS_KEY);
  }

  public Object validatePreis(Object value) throws NSValidation.ValidationException {
    _SpeisekarteTBL.log.debug("validate preis");
    return ERXValidationException.validateForUserInfo(this, PREIS_KEY, value);
  }

  public Integer sortorder() {
    return (Integer) storedValueForKey(SORTORDER_KEY);
  }

  public void setSortorder(Integer value) {
    if (_SpeisekarteTBL.log.isDebugEnabled()) {
      _SpeisekarteTBL.log.debug("updating sortorder from {} to {}", sortorder(), value);
    }
    takeStoredValueForKey(value, SORTORDER_KEY);
  }

  public Object validateSortorder(Object value) throws NSValidation.ValidationException {
    _SpeisekarteTBL.log.debug("validate sortorder");
    return ERXValidationException.validateForUserInfo(this, SORTORDER_KEY, value);
  }

  public String sprache() {
    return (String) storedValueForKey(SPRACHE_KEY);
  }

  public void setSprache(String value) {
    if (_SpeisekarteTBL.log.isDebugEnabled()) {
      _SpeisekarteTBL.log.debug("updating sprache from {} to {}", sprache(), value);
    }
    takeStoredValueForKey(value, SPRACHE_KEY);
  }

  public Object validateSprache(Object value) throws NSValidation.ValidationException {
    _SpeisekarteTBL.log.debug("validate sprache");
    return ERXValidationException.validateForUserInfo(this, SPRACHE_KEY, value);
  }

  //********************************************************************
  //  ToOne relationship : ToOne リレーションシップ
  //********************************************************************

  //********************************************************************
  //  Editing Context replacement : 編集コンテキスト入れ替え
  //********************************************************************

  @Override
  public SpeisekarteTBL localInstanceIn(EOEditingContext editingContext) {
    SpeisekarteTBL localInstance = (SpeisekarteTBL)EOUtilities.localInstanceOfObject(editingContext, this);
      if (localInstance == null) {
        throw new IllegalStateException("You attempted to localInstance " + this + ", which has not yet committed.");
      }
      return localInstance;
  }

  //********************************************************************
  //  toMany relationship : toMany リレーションシップ
  //********************************************************************

  public NSArray<org.treasureboat.app.eo.AllergenInfoTBL> allergenInfoTBLs() {
    NSArray<org.treasureboat.app.eo.AllergenInfoTBL> results = (NSArray<org.treasureboat.app.eo.AllergenInfoTBL>)storedValueForKey("allergenInfoTBLs");
    if(useCoreQualifierForToManyRelationships()) { // CoreQualifier
      if(!TBWConcurrencyUtilities.isStopRestrictDeleteQualifier()) {
        NSMutableArray<org.treasureboat.app.eo.AllergenInfoTBL> marr = new NSMutableArray<org.treasureboat.app.eo.AllergenInfoTBL>(results.count());
        for (org.treasureboat.app.eo.AllergenInfoTBL one : results) {

          if (one instanceof ITBEnterpriseVirtualDeleteSupport) {
            if(one.deleted() == null) {
              marr.addObject(one);
            }
          } else {
            marr.addObject(one);
          }

        }
        results = marr.immutableClone();
      }     
    }
    return results;
  }

  public NSArray<org.treasureboat.app.eo.AllergenInfoTBL> allergenInfoTBLs(EOQualifier qualifier) {
    return allergenInfoTBLs(qualifier, null);
  }

  public NSArray<org.treasureboat.app.eo.AllergenInfoTBL> allergenInfoTBLs(EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    NSArray<org.treasureboat.app.eo.AllergenInfoTBL> results;
      results = allergenInfoTBLs();
      if (qualifier != null) {
        results = (NSArray<org.treasureboat.app.eo.AllergenInfoTBL>)EOQualifier.filteredArrayWithQualifier(results, qualifier);
      }
      if (sortOrderings != null) {
        results = (NSArray<org.treasureboat.app.eo.AllergenInfoTBL>)EOSortOrdering.sortedArrayUsingKeyOrderArray(results, sortOrderings);
      }
      return results;
  }
  
  public void addToAllergenInfoTBLs(org.treasureboat.app.eo.AllergenInfoTBL object) {
    includeObjectIntoPropertyWithKey(object, "allergenInfoTBLs");
  }

  public void removeFromAllergenInfoTBLs(org.treasureboat.app.eo.AllergenInfoTBL object) {
    excludeObjectFromPropertyWithKey(object, "allergenInfoTBLs");
  }

  public void addToAllergenInfoTBLsRelationship(org.treasureboat.app.eo.AllergenInfoTBL object) {
    _SpeisekarteTBL.log.debug("adding {} to allergenInfoTBLs relationship", object);
    if (ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      addToAllergenInfoTBLs(object);
    } else {
      addObjectToBothSidesOfRelationshipWithKey(object, "allergenInfoTBLs");
    }
  }

  public void removeFromAllergenInfoTBLsRelationship(org.treasureboat.app.eo.AllergenInfoTBL object) {
    _SpeisekarteTBL.log.debug("removing {} from allergenInfoTBLs relationship", object);
    if (ERXGenericRecord.InverseRelationshipUpdater.updateInverseRelationships()) {
      removeFromAllergenInfoTBLs(object);
    } else {
      removeObjectFromBothSidesOfRelationshipWithKey(object, "allergenInfoTBLs");
    }
  }

  public org.treasureboat.app.eo.AllergenInfoTBL createAllergenInfoTBLsRelationship() {
    EOClassDescription eoClassDesc = EOClassDescription.classDescriptionForEntityName("AllergenInfoTBL");
    EOEnterpriseObject eo = eoClassDesc.createInstanceWithEditingContext(editingContext(), null);
    editingContext().insertObject(eo);
    addObjectToBothSidesOfRelationshipWithKey(eo, "allergenInfoTBLs");
    return (org.treasureboat.app.eo.AllergenInfoTBL) eo;
  }

  public void deleteAllergenInfoTBLsRelationship(org.treasureboat.app.eo.AllergenInfoTBL object) {
    removeObjectFromBothSidesOfRelationshipWithKey(object, "allergenInfoTBLs");
      editingContext().deleteObject(object);
  }

  public void deleteAllAllergenInfoTBLsRelationships() {
    Enumeration objects = allergenInfoTBLs().immutableClone().objectEnumerator();
    while (objects.hasMoreElements()) {
      deleteAllergenInfoTBLsRelationship((org.treasureboat.app.eo.AllergenInfoTBL)objects.nextElement());
    }
  }

  //********************************************************************
  //  Instance : インスタンス化
  //********************************************************************

  public static SpeisekarteTBL createSpeisekarteTBL(EOEditingContext editingContext
   , String beschreibung
   , String name
   , Double preis
   , Integer sortorder
   , String sprache
    )
  {
    SpeisekarteTBL eo = (SpeisekarteTBL) EOUtilities.createAndInsertInstance(editingContext, _SpeisekarteTBL.ENTITY_NAME);
    eo.setBeschreibung(beschreibung);
    eo.setName(name);
    eo.setPreis(preis);
    eo.setSortorder(sortorder);
    eo.setSprache(sprache);
    return eo;
  }
  
  /* EO creation with Stamped EO Support */
  public static SpeisekarteTBL createSpeisekarteTBLWithStampedSupport(EOEditingContext editingContext
   , String beschreibung
   , String name
   , Double preis
   , Integer sortorder
   , String sprache
    )
  {
    SpeisekarteTBL eo = (SpeisekarteTBL) EOUtilities.createAndInsertInstance(editingContext, _SpeisekarteTBL.ENTITY_NAME);
    eo.setBeschreibung(beschreibung);
    eo.setName(name);
    eo.setPreis(preis);
    eo.setSortorder(sortorder);
    eo.setSprache(sprache);
    return eo;
  }

  public static SpeisekarteTBL createAndInsertInstance(EOEditingContext context) {
    log.debug("{} : createAndInsertInstance", ENTITY_NAME);
    
    return (SpeisekarteTBL)EOUtilities.createAndInsertInstance(context, ENTITY_NAME);
  }

  // ========== [検索関連] ==========
  //********************************************************************
  //  Fetch (NSArray) : フェッチ (NSArray)
  //********************************************************************

  public static ERXFetchSpecification<SpeisekarteTBL> fetchSpec() {
    return new ERXFetchSpecification<SpeisekarteTBL>(_SpeisekarteTBL.ENTITY_NAME, null, null, false, true, null);
  }

  /* 
   * standard fetch 
   */
  public static NSArray<SpeisekarteTBL> fetchAllSpeisekarteTBLs(EOEditingContext editingContext) {
    return _SpeisekarteTBL.fetchAllSpeisekarteTBLs(editingContext, null);
  }

  public static NSArray<SpeisekarteTBL> fetchAllSpeisekarteTBLs(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _SpeisekarteTBL.fetchSpeisekarteTBLs(editingContext, null, sortOrderings);
  }
 
  public static NSArray<SpeisekarteTBL> fetchSpeisekarteTBLs(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SpeisekarteTBL.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<SpeisekarteTBL> eoObjects = (NSArray<SpeisekarteTBL>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  /* 
   * coreQualifier fetch 
   */  
  public static NSArray<SpeisekarteTBL> fetchAllSpeisekarteTBLsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain) {
    return _SpeisekarteTBL.fetchAllSpeisekarteTBLsWithCoreQualifier(editingContext, domain, null);
  }
  
  public static NSArray<SpeisekarteTBL> fetchAllSpeisekarteTBLsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain, NSArray<EOSortOrdering> sortOrderings) {
    EOEntity entity = ERXEOAccessUtilities.entityNamed(editingContext, _SpeisekarteTBL.ENTITY_NAME);
    return _SpeisekarteTBL.fetchSpeisekarteTBLs(editingContext, TBWCoreQualifierBase.delegate().qualifier(entity, domain), sortOrderings);
  }
  
  public static NSArray<SpeisekarteTBL> fetchSpeisekarteTBLsWithCoreQualifier(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOEntity entity = ERXEOAccessUtilities.entityNamed(editingContext, _SpeisekarteTBL.ENTITY_NAME);

    TBWMultiDomainSupport multiDomainSupport = (TBWMultiDomainSupport) TBSession.session().multiDomain();
    ITBWDomain domain = multiDomainSupport.currentDomain();

    ERXAndQualifier andQualifier = new ERXAndQualifier(TBWCoreQualifierBase.delegate().qualifier(entity, domain), qualifier);

    EOFetchSpecification fetchSpec = new EOFetchSpecification(_SpeisekarteTBL.ENTITY_NAME, andQualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<SpeisekarteTBL> eoObjects = (NSArray<SpeisekarteTBL>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }  
  
  //********************************************************************
  //  Fetch (SpeisekarteTBL) :  フェッチ (SpeisekarteTBL)
  //********************************************************************
  
  public static SpeisekarteTBL fetchSpeisekarteTBL(EOEditingContext editingContext, String keyName, Object value) {
    return _SpeisekarteTBL.fetchSpeisekarteTBL(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SpeisekarteTBL fetchSpeisekarteTBL(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<SpeisekarteTBL> eoObjects = _SpeisekarteTBL.fetchSpeisekarteTBLs(editingContext, qualifier, null);
    SpeisekarteTBL eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    } else if (count == 1) {
      eoObject = (SpeisekarteTBL)eoObjects.objectAtIndex(0);
    } else {
      throw new IllegalStateException("There was more than one SpeisekarteTBL that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SpeisekarteTBL fetchRequiredSpeisekarteTBL(EOEditingContext editingContext, String keyName, Object value) {
    return _SpeisekarteTBL.fetchRequiredSpeisekarteTBL(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static SpeisekarteTBL fetchRequiredSpeisekarteTBL(EOEditingContext editingContext, EOQualifier qualifier) {
    SpeisekarteTBL eoObject = _SpeisekarteTBL.fetchSpeisekarteTBL(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no SpeisekarteTBL that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static SpeisekarteTBL fetchSpeisekarteTBLByPrimaryKey(EOEditingContext context, Object value) {
    EOEnterpriseObject eo = TBEOExternalPrimaryKeyHelper.objectWithPrimaryKeyValue(context, ENTITY_NAME, value);
    return (SpeisekarteTBL) eo;
  }

  public static SpeisekarteTBL fetchSpeisekarteTBLByEncryptedPrimaryKey(EOEditingContext context, String value) {
    return SpeisekarteTBL.fetchSpeisekarteTBLByPrimaryKey(context, TBFCrypto.crypterForAlgorithm(TBFCrypto.BLOWFISH).decrypt(value));
  }
  
  public static SpeisekarteTBL localInstanceIn(EOEditingContext editingContext, SpeisekarteTBL eo) {
    SpeisekarteTBL localInstance = (eo == null) ? null : (SpeisekarteTBL)EOUtilities.localInstanceOfObject(editingContext, eo);
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
