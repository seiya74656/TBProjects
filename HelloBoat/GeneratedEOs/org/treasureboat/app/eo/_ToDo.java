//
// _ToDo.java
//
// DO NOT EDIT. 
// Make changes to ToDo.java instead.
//
// version 8.4
//
// 2008-2016 by TreasureBoat.org
//

/*
 * The following List is for Localization :
 * ----------------------------------------

  "Pages.QueryToDo" = "Query ToDo";
  "Pages.ListToDo" = "List ToDo";
  "Pages.InspectToDo" = "Inspect ToDo";
  "Pages.EditToDo" = "Edit ToDo";
  "Pages.CreateToDo" = "Create ToDo";
  
  "Pages.QueryEmbeddedToDo" = "Query Embedded ToDo";
  "Pages.ListEmbeddedToDo" = "List Embedded ToDo";
  "Pages.InspectEmbeddedToDo" = "Inspect Embedded ToDo";
  "Pages.EditEmbeddedToDo" = "Edit Embedded ToDo";
  "Pages.CreateEmbeddedToDo" = "Create Embedded ToDo";

  "PropertyKey.ToDo.done" = "done";
  "PropertyKey.ToDo.dueDate" = "dueDate";
  "PropertyKey.ToDo.priority" = "priority";
  "PropertyKey.ToDo.task" = "task";

 * ----------------------------------------
 */

/*
 * The following List is for D2W/D3W :
 * ----------------------------------------

  // D2W

  300 : entity.name = 'ToDo' => isEntityEditable = "true" [com.webobjects.directtoweb.BooleanAssignment]

  100 : pageConfiguration like '*ToDo' => navigationState = "XX.xx" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'CreateToDo' => navigationState = "XX.xx.createToDo" [com.webobjects.directtoweb.Assignment]
  105 : pageConfiguration = 'QueryToDo' => navigationState = "XX.xx.queryToDo" [com.webobjects.directtoweb.Assignment]
  
  401 : pageConfiguration = 'QueryToDo' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "done" , "dueDate" , "priority" , "task"  ) [com.webobjects.directtoweb.Assignment] 
  402 : pageConfiguration = 'ListToDo' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "done" , "dueDate" , "priority" , "task"  ) [com.webobjects.directtoweb.Assignment] 
  403 : pageConfiguration = 'InspectToDo' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "done" , "dueDate" , "priority" , "task"  ) [com.webobjects.directtoweb.Assignment] 
  404 : pageConfiguration = 'EditToDo' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "done" , "dueDate" , "priority" , "task"  ) [com.webobjects.directtoweb.Assignment] 
  405 : pageConfiguration = 'CreateToDo' => displayPropertyKeys = ("[MainTab]", "(MainSection)", "done" , "dueDate" , "priority" , "task"  ) [com.webobjects.directtoweb.Assignment] 
   
  // D3W

  200 : EN = '#' => crud = "0100" [com.webobjects.directtoweb.Assignment]
  600 : PC = 'EditRelationshipEmbedded#' => cruds = "00001" [com.webobjects.directtoweb.Assignment]
  
  401 : PC = 'Query#' => DPK = ("[MainTab]", "(MainSection)", "done", "dueDate", "priority", "task") [com.webobjects.directtoweb.Assignment] 
  402 : PC = 'List#' => DPK = ("[MainTab]", "(MainSection)", "done", "dueDate", "priority", "task") [com.webobjects.directtoweb.Assignment] 
  403 : PC = 'Inspect#' => DPK = ("[MainTab]", "(MainSection)", "done", "dueDate", "priority", "task") [com.webobjects.directtoweb.Assignment] 
  404 : PC = 'Edit#' => DPK = ("[MainTab]", "(MainSection)", "done", "dueDate", "priority", "task") [com.webobjects.directtoweb.Assignment] 
  405 : PC = 'Create#' => DPK = ("[MainTab]", "(MainSection)", "done", "dueDate", "priority", "task") [com.webobjects.directtoweb.Assignment] 

 * ----------------------------------------
 */

package org.treasureboat.app.eo;

import org.treasureboat.app.eo.ToDo;

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
public abstract class _ToDo extends  TBEOGenericRecord  {

  private static final long serialVersionUID = 1L;

  /** 
   * <a href="http://wiki.wocommunity.org/display/documentation/Wonder+Logging">new org.slf4j.Logger</a> 
   */
  static final Logger log = LoggerFactory.getLogger(ToDo.class);

  //********************************************************************
  //  Constructor : コンストラクター
  //********************************************************************

  public _ToDo() {
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
  
  /** Entity Name = ToDo */
  public static final String ENTITY_NAME = "ToDo";

  //********************************************************************
  //  Access Properties : アクセス・プロパティ
  //********************************************************************
  
  protected static String ACCSESS_CREATE = "ToDo.create";
  protected static String ACCSESS_READ = "ToDo.read";
  protected static String ACCSESS_UPDATE = "ToDo.update";
  protected static String ACCSESS_DELETE = "ToDo.delete";

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
  public static final ERXKey<Boolean> DONE = new ERXKey<Boolean>("done");
  public static final ERXKey<org.treasureboat.foundation.date.TBFTimestamp> DUE_DATE = new ERXKey<org.treasureboat.foundation.date.TBFTimestamp>("dueDate");
  public static final ERXKey<String> PRIORITY = new ERXKey<String>("priority");
  public static final ERXKey<String> TASK = new ERXKey<String>("task");

  // Attributes
  public static final String DONE_KEY = DONE.key();
  public static final String DUE_DATE_KEY = DUE_DATE.key();
  public static final String PRIORITY_KEY = PRIORITY.key();
  public static final String TASK_KEY = TASK.key();

  //********************************************************************
  //  Relationship : リレーションシップ
  //********************************************************************

  // Relationship Keys

  // Relationships

  //********************************************************************
  //  clazz methods : クラス・メソッド
  //********************************************************************

  public static class _ToDoClazz<T extends ToDo> extends ERXGenericRecord.ERXGenericRecordClazz<T> {
    /* more clazz methods here */
  }

	public ToDo.ToDoClazz clazz() {
    return ToDo.clazz;
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

  public Boolean done() {
    return (Boolean) storedValueForKey(DONE_KEY);
  }

  public void setDone(Boolean value) {
    if (_ToDo.log.isDebugEnabled()) {
      _ToDo.log.debug("updating done from {} to {}", done(), value);
    }
    takeStoredValueForKey(value, DONE_KEY);
  }

  public Object validateDone(Object value) throws NSValidation.ValidationException {
    _ToDo.log.debug("validate done");
    return ERXValidationException.validateForUserInfo(this, DONE_KEY, value);
  }

  public org.treasureboat.foundation.date.TBFTimestamp dueDate() {
    return (org.treasureboat.foundation.date.TBFTimestamp) storedValueForKey(DUE_DATE_KEY);
  }

  public void setDueDate(org.treasureboat.foundation.date.TBFTimestamp value) {
    if (_ToDo.log.isDebugEnabled()) {
      _ToDo.log.debug("updating dueDate from {} to {}", dueDate(), value);
    }
    takeStoredValueForKey(value, DUE_DATE_KEY);
  }

  public Object validateDueDate(Object value) throws NSValidation.ValidationException {
    _ToDo.log.debug("validate dueDate");
    return ERXValidationException.validateForUserInfo(this, DUE_DATE_KEY, value);
  }

  public String priority() {
    return (String) storedValueForKey(PRIORITY_KEY);
  }

  public void setPriority(String value) {
    if (_ToDo.log.isDebugEnabled()) {
      _ToDo.log.debug("updating priority from {} to {}", priority(), value);
    }
    takeStoredValueForKey(value, PRIORITY_KEY);
  }

  public Object validatePriority(Object value) throws NSValidation.ValidationException {
    _ToDo.log.debug("validate priority");
    return ERXValidationException.validateForUserInfo(this, PRIORITY_KEY, value);
  }

  public String task() {
    return (String) storedValueForKey(TASK_KEY);
  }

  public void setTask(String value) {
    if (_ToDo.log.isDebugEnabled()) {
      _ToDo.log.debug("updating task from {} to {}", task(), value);
    }
    takeStoredValueForKey(value, TASK_KEY);
  }

  public Object validateTask(Object value) throws NSValidation.ValidationException {
    _ToDo.log.debug("validate task");
    return ERXValidationException.validateForUserInfo(this, TASK_KEY, value);
  }

  //********************************************************************
  //  ToOne relationship : ToOne リレーションシップ
  //********************************************************************

  //********************************************************************
  //  Editing Context replacement : 編集コンテキスト入れ替え
  //********************************************************************

  @Override
  public ToDo localInstanceIn(EOEditingContext editingContext) {
    ToDo localInstance = (ToDo)EOUtilities.localInstanceOfObject(editingContext, this);
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

  public static ToDo createToDo(EOEditingContext editingContext
   , org.treasureboat.foundation.date.TBFTimestamp dueDate
   , String task
    )
  {
    ToDo eo = (ToDo) EOUtilities.createAndInsertInstance(editingContext, _ToDo.ENTITY_NAME);
    eo.setDueDate(dueDate);
    eo.setTask(task);
    return eo;
  }
  
  /* EO creation with Stamped EO Support */
  public static ToDo createToDoWithStampedSupport(EOEditingContext editingContext
   , org.treasureboat.foundation.date.TBFTimestamp dueDate
   , String task
    )
  {
    ToDo eo = (ToDo) EOUtilities.createAndInsertInstance(editingContext, _ToDo.ENTITY_NAME);
    eo.setDueDate(dueDate);
    eo.setTask(task);
    return eo;
  }

  public static ToDo createAndInsertInstance(EOEditingContext context) {
    log.debug("{} : createAndInsertInstance", ENTITY_NAME);
    
    return (ToDo)EOUtilities.createAndInsertInstance(context, ENTITY_NAME);
  }

  // ========== [検索関連] ==========
  //********************************************************************
  //  Fetch (NSArray) : フェッチ (NSArray)
  //********************************************************************

  public static ERXFetchSpecification<ToDo> fetchSpec() {
    return new ERXFetchSpecification<ToDo>(_ToDo.ENTITY_NAME, null, null, false, true, null);
  }

  /* 
   * standard fetch 
   */
  public static NSArray<ToDo> fetchAllToDos(EOEditingContext editingContext) {
    return _ToDo.fetchAllToDos(editingContext, null);
  }

  public static NSArray<ToDo> fetchAllToDos(EOEditingContext editingContext, NSArray<EOSortOrdering> sortOrderings) {
    return _ToDo.fetchToDos(editingContext, null, sortOrderings);
  }
 
  public static NSArray<ToDo> fetchToDos(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ToDo.ENTITY_NAME, qualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<ToDo> eoObjects = (NSArray<ToDo>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }

  /* 
   * coreQualifier fetch 
   */  
  public static NSArray<ToDo> fetchAllToDosWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain) {
    return _ToDo.fetchAllToDosWithCoreQualifier(editingContext, domain, null);
  }
  
  public static NSArray<ToDo> fetchAllToDosWithCoreQualifier(EOEditingContext editingContext, ITBWDomain domain, NSArray<EOSortOrdering> sortOrderings) {
    TBEntity entity = TBEntity.entityNamed(editingContext, _ToDo.ENTITY_NAME);
    return _ToDo.fetchToDos(editingContext, TBWCoreQualifierBase.delegate().qualifier(entity, domain), sortOrderings);
  }
  
  public static NSArray<ToDo> fetchToDosWithCoreQualifier(EOEditingContext editingContext, EOQualifier qualifier, NSArray<EOSortOrdering> sortOrderings) {
    TBEntity entity = TBEntity.entityNamed(editingContext, _ToDo.ENTITY_NAME);

    TBWMultiDomainSupport multiDomainSupport = (TBWMultiDomainSupport) TBSession.session().multiDomain();
    ITBWDomain domain = multiDomainSupport.currentDomain();

    TBEnterpriseAndQualifier andQualifier = new TBEnterpriseAndQualifier(TBWCoreQualifierBase.delegate().qualifier(entity, domain), qualifier);

    EOFetchSpecification fetchSpec = new EOFetchSpecification(_ToDo.ENTITY_NAME, andQualifier, sortOrderings);
    fetchSpec.setIsDeep(true);
    NSArray<ToDo> eoObjects = (NSArray<ToDo>)editingContext.objectsWithFetchSpecification(fetchSpec);
    return eoObjects;
  }  
  
  //********************************************************************
  //  Fetch (ToDo) :  フェッチ (ToDo)
  //********************************************************************
  
  public static ToDo fetchToDo(EOEditingContext editingContext, String keyName, Object value) {
    return _ToDo.fetchToDo(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ToDo fetchToDo(EOEditingContext editingContext, EOQualifier qualifier) {
    NSArray<ToDo> eoObjects = _ToDo.fetchToDos(editingContext, qualifier, null);
    ToDo eoObject;
    int count = eoObjects.count();
    if (count == 0) {
      eoObject = null;
    } else if (count == 1) {
      eoObject = (ToDo)eoObjects.objectAtIndex(0);
    } else {
      throw new IllegalStateException("There was more than one ToDo that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ToDo fetchRequiredToDo(EOEditingContext editingContext, String keyName, Object value) {
    return _ToDo.fetchRequiredToDo(editingContext, new EOKeyValueQualifier(keyName, EOQualifier.QualifierOperatorEqual, value));
  }

  public static ToDo fetchRequiredToDo(EOEditingContext editingContext, EOQualifier qualifier) {
    ToDo eoObject = _ToDo.fetchToDo(editingContext, qualifier);
    if (eoObject == null) {
      throw new NoSuchElementException("There was no ToDo that matched the qualifier '" + qualifier + "'.");
    }
    return eoObject;
  }

  public static ToDo fetchToDoByPrimaryKey(EOEditingContext context, Object value) {
    EOEnterpriseObject eo = TBEOExternalPrimaryKeyHelper.objectWithPrimaryKeyValue(context, ENTITY_NAME, value);
    return (ToDo) eo;
  }

  public static ToDo fetchToDoByEncryptedPrimaryKey(EOEditingContext context, String value) {
    return ToDo.fetchToDoByPrimaryKey(context, TBFCrypto.crypterForAlgorithm(TBFCrypto.BLOWFISH).decrypt(value));
  }
  
  public static ToDo localInstanceIn(EOEditingContext editingContext, ToDo eo) {
    ToDo localInstance = (eo == null) ? null : (ToDo)EOUtilities.localInstanceOfObject(editingContext, eo);
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
