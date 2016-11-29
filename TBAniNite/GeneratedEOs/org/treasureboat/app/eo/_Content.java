//
// _Content.java
//
// DO NOT EDIT. 
// Make changes to Content.java instead.
//
// version 8.5
//
// 2008-2016 by TreasureBoat.org
//

/*
 * The following List is for Localization :
 * ----------------------------------------

  "Pages.QueryContent" = "Query Content";
  "Pages.ListContent" = "List Content";
  "Pages.InspectContent" = "Inspect Content";
  "Pages.EditContent" = "Edit Content";
  "Pages.CreateContent" = "Create Content";
  
  "Pages.QueryEmbeddedContent" = "Query Embedded Content";
  "Pages.ListEmbeddedContent" = "List Embedded Content";
  "Pages.InspectEmbeddedContent" = "Inspect Embedded Content";
  "Pages.EditEmbeddedContent" = "Edit Embedded Content";
  "Pages.CreateEmbeddedContent" = "Create Embedded Content";

  "PropertyKey.Content.category" = "category";
  "PropertyKey.Content.description" = "description";
  "PropertyKey.Content.title" = "title";

 * ----------------------------------------
 */

/*
 * The following List is for D2W/D3W :
 * ----------------------------------------

  // D2W

  300 : entity.name = 'Content' => isEntityEditable = "true" [com.webobjects.directtoweb.BooleanAssignment]

  100 : pageConfiguration like '*Content' => navigationState = "XX.xx" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'CreateContent' => navigationState = "XX.xx.createContent" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'QueryContent' => navigationState = "XX.xx.queryContent" [com.webobjects.directtoweb.Assignment]
  
  401 : pageConfiguration = 'QueryContent' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "category" , "description" , "title"  ) [com.webobjects.directtoweb.Assignment] 
  402 : pageConfiguration = 'ListContent' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "category" , "description" , "title"  ) [com.webobjects.directtoweb.Assignment] 
  403 : pageConfiguration = 'InspectContent' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "category" , "description" , "title"  ) [com.webobjects.directtoweb.Assignment] 
  404 : pageConfiguration = 'EditContent' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "category" , "description" , "title"  ) [com.webobjects.directtoweb.Assignment] 
  405 : pageConfiguration = 'CreateContent' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "category" , "description" , "title"  ) [com.webobjects.directtoweb.Assignment] 
   
  // D3W

  200 : EN = '#' => crud = "0100" [com.webobjects.directtoweb.Assignment]
  600 : PC = 'EditRelationshipEmbedded#' => cruds = "00001" [com.webobjects.directtoweb.Assignment]
  
  401 : PC = 'Query#' => DPK = ("[MainTab]", "(MainSection)", "category", "description", "title") [com.webobjects.directtoweb.Assignment] 
  402 : PC = 'List#' => DPK = ("[MainTab]", "(MainSection)", "category", "description", "title") [com.webobjects.directtoweb.Assignment] 
  403 : PC = 'Inspect#' => DPK = ("[MainTab]", "(MainSection)", "category", "description", "title") [com.webobjects.directtoweb.Assignment] 
  404 : PC = 'Edit#' => DPK = ("[MainTab]", "(MainSection)", "category", "description", "title") [com.webobjects.directtoweb.Assignment] 
  405 : PC = 'Create#' => DPK = ("[MainTab]", "(MainSection)", "category", "description", "title") [com.webobjects.directtoweb.Assignment] 

 * ----------------------------------------
 */

package org.treasureboat.app.eo;

import org.treasureboat.app.eo.Content;

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
public abstract class _Content extends  TBEOGenericRecord  {

  private static final long serialVersionUID = 1L;

  /** 
   * <a href="http://wiki.wocommunity.org/display/documentation/Wonder+Logging">new org.slf4j.Logger</a> 
   */
  static final Logger log = LoggerFactory.getLogger(Content.class);

  //********************************************************************
  //  Constructor : コンストラクター
  //********************************************************************

  public _Content() {
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
  
  /** Entity Name = Content */
  public static final String ENTITY_NAME = "Content";

  //********************************************************************
  //  Access Properties : アクセス・プロパティ
  //********************************************************************
  
  protected static String ACCSESS_CREATE = "Content.create";
  protected static String ACCSESS_READ = "Content.read";
  protected static String ACCSESS_UPDATE = "Content.update";
  protected static String ACCSESS_DELETE = "Content.delete";

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
  
  protected static String BUTTON_INSPECT = "Content.hide.inspect";
  protected static String BUTTON_EDIT = "Content.hide.edit";
  protected static String BUTTON_DELETE = "Content.hide.delete";
  protected static String BUTTON_REMOVE = "Content.hide.remove";

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
  public static final ERXKey<String> CATEGORY = new ERXKey<String>("category");
  public static final ERXKey<String> DESCRIPTION = new ERXKey<String>("description");
  public static final ERXKey<String> TITLE = new ERXKey<String>("title");

  // Attributes
  public static final String CATEGORY_KEY = CATEGORY.key();
  public static final String DESCRIPTION_KEY = DESCRIPTION.key();
  public static final String TITLE_KEY = TITLE.key();

  //********************************************************************
  //  Relationship : リレーションシップ
  //********************************************************************

  // Relationship Keys

  // Relationships

  //********************************************************************
  //  clazz methods : クラス・メソッド
  //********************************************************************

  public static class _ContentClazz<T extends Content> extends ERXGenericRecord.ERXGenericRecordClazz<T> {
    /* more clazz methods here */
  }

	public Content.ContentClazz clazz() {
    return Content.clazz;
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

  public String category() {
    return (String) storedValueForKey(CATEGORY_KEY);
  }

  public void setCategory(String value) {
    if (_Content.log.isDebugEnabled()) {
      _Content.log.debug("updating category from {} to {}", category(), value);
    }
    takeStoredValueForKey(value, CATEGORY_KEY);
  }

  public Object validateCategory(Object value) throws NSValidation.ValidationException {
    _Content.log.debug("validate category");
    return ERXValidationException.validateForUserInfo(this, CATEGORY_KEY, value);
  }

  public String description() {
    return (String) storedValueForKey(DESCRIPTION_KEY);
  }

  public void setDescription(String value) {
    if (_Content.log.isDebugEnabled()) {
      _Content.log.debug("updating description from {} to {}", description(), value);
    }
    takeStoredValueForKey(value, DESCRIPTION_KEY);
  }

  public Object validateDescription(Object value) throws NSValidation.ValidationException {
    _Content.log.debug("validate description");
    return ERXValidationException.validateForUserInfo(this, DESCRIPTION_KEY, value);
  }

  public String title() {
    return (String) storedValueForKey(TITLE_KEY);
  }

  public void setTitle(String value) {
    if (_Content.log.isDebugEnabled()) {
      _Content.log.debug("updating title from {} to {}", title(), value);
    }
    takeStoredValueForKey(value, TITLE_KEY);
  }

  public Object validateTitle(Object value) throws NSValidation.ValidationException {
    _Content.log.debug("validate title");
    return ERXValidationException.validateForUserInfo(this, TITLE_KEY, value);
  }

  //********************************************************************
  //  ToOne relationship : ToOne リレーションシップ
  //********************************************************************

  //********************************************************************
  //  Editing Context replacement : 編集コンテキスト入れ替え
  //********************************************************************

  @Override
  public Content localInstanceIn(EOEditingContext editingContext) {
    Content localInstance = (Content)EOUtilities.localInstanceOfObject(editingContext, this);
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

  public static Content createContent(EOEditingContext editingContext
   , String category
   , String description
   , String title
    )
  {
    Content eo = (Content) EOUtilities.createAndInsertInstance(editingContext, _Content.ENTITY_NAME);
    eo.setCategory(category);
    eo.setDescription(description);
    eo.setTitle(title);
    return eo;
  }
  
  /* EO creation with Stamped EO Support */
  public static Content createContentWithStampedSupport(EOEditingContext editingContext
   , String category
   , String description
   , String title
    )
  {
    Content eo = (Content) EOUtilities.createAndInsertInstance(editingContext, _Content.ENTITY_NAME);
    eo.setCategory(category);
    eo.setDescription(description);
    eo.setTitle(title);
    return eo;
  }

  public static Content createAndInsertInstance(EOEditingContext context) {
    log.debug("{} : createAndInsertInstance", ENTITY_NAME);
    
    return (Content)EOUtilities.createAndInsertInstance(context, ENTITY_NAME);
  }

  // ========== [検索関連] ==========
  //********************************************************************
  //  Fetch (NSArray) : フェッチ (NSArray)
  //********************************************************************

  public static ERXFetchSpecification<Content> fetchSpec() {
    return new ERXFetchSpecification<Content>(_Content.ENTITY_NAME, null, null, false, true, null);
  }

  /* 
   * standard fetch 
   */
  public static NSArray<Content> fetchAllContents(EOEditingContext editingContext) {
    return _Content.fetchAllContents(editingContext, null);
  }

  public static NSArray<Content> fetchAllContents(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _Content.fetchContents(editingContext, null, sortOrderings);
  }
 
  public static NSArray<Content> fetchContents(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Content.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Content> eoObjects = (NSArray<Content>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  /* 
   * coreQualifier fetch 
   */  
  public static NSArray<Content> fetchAllContentsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain) {
    return _Content.fetchAllContentsWithCoreQualifier(editingContext, domain, null);
  }
  
  public static NSArray<Content> fetchAllContentsWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain, NSArray<EOSortOrdering> sortOrderings) {
    TBEntity entity = TBEntity.entityNamed(editingContext, _Content.ENTITY_NAME);
    return _Content.fetchContents(editingContext, TBWCoreQualifierBase.delegate().qualifier(entity, domain), sortOrderings);
  }
  
  public static NSArray<Content> fetchContentsWithCoreQualifier(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    TBEntity entity = TBEntity.entityNamed(editingContext, _Content.ENTITY_NAME);

    TBWMultiDomainSupport multiDomainSupport = TBSession.session().multiDomain();
    ITBWDomain domain = multiDomainSupport.currentDomain();

    TBEnterpriseAndQualifier andQualifier = new TBEnterpriseAndQualifier(TBWCoreQualifierBase.delegate().qualifier(entity, domain), qualifier);

    EOFetchSpecification fetchSpec = new EOFetchSpecification(_Content.ENTITY_NAME, andQualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<Content> eoObjects = (NSArray<Content>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }  
  
  //********************************************************************
  //  Fetch (Content) :  フェッチ (Content)
  //********************************************************************
  
  public static Content fetchContent(EOEditingContext editingContext, String keyName, Object value) {
    return _Content.fetchContent(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Content fetchContent(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<Content> eoObjects = _Content.fetchContents(editingContext, qualifier, null);
    Content eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    } else if (count == 1) {
      eoObject = (Content)eoObjects.objectAtIndex(0);
    } else {
      throw new IllegalStateException("There was more than one Content that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Content fetchRequiredContent(EOEditingContext editingContext, String keyName, Object value) {
    return _Content.fetchRequiredContent(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static Content fetchRequiredContent(EOEditingContext editingContext, EOQualifier qualifier) {
    Content eoObject = _Content.fetchContent(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no Content that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static Content fetchContentByPrimaryKey(EOEditingContext context, Object value) {
    EOEnterpriseObject eo = TBEOExternalPrimaryKeyHelper.objectWithPrimaryKeyValue(context, ENTITY_NAME, value);
    return (Content) eo;
  }

  public static Content fetchContentByEncryptedPrimaryKey(EOEditingContext context, String value) {
    return Content.fetchContentByPrimaryKey(context, TBFCrypto.crypterForAlgorithm(TBFCrypto.BLOWFISH).decrypt(value));
  }
  
  public static Content localInstanceIn(EOEditingContext editingContext, Content eo) {
    Content localInstance = (eo == null) ? null : (Content)EOUtilities.localInstanceOfObject(editingContext, eo);
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
