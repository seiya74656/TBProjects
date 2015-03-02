/*
 * Copyright (C) NetStruxr, Inc. All rights reserved.
 *
 * This software is published under the terms of the NetStruxr
 * Public Software License version 0.5, a copy of which has been
 * included with this distribution in the LICENSE.NPL file.  */
package org.treasureboat.app.components;

import java.util.Enumeration;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.treasureboat.enterprise.foundation.TBEnterpriseArrayUtilities;
import org.treasureboat.foundation.TBFConstants;
import org.treasureboat.webcore.annotations.TBStateless;

import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSLog;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSRange;
import com.webobjects.foundation.NSSet;

import er.extensions.components.ERXNonSynchronizingComponent;

/**
 * Works around a webscript bug.<br />
 * 
 * @binding list - ERXCheckboxMatrix が反復するオブジェクトの配列。
 * @binding item - リスト配列内でのカレント・アイテム。（この属性の値はそれぞれの反復で更新されます）
 * @binding selections - 選択範囲をセットとゲットする NSArray
 * @binding maxColumns - カラム数
 * @binding goingVertically" defaults="Boolean
 * @binding contentCellOtherTagString - コンテントを囲む td タグの追加タグ情報をセットできます。
 * @binding sortKey - ソートキー
 * @binding width - テーブル幅
 * @binding cellAlign - 各セルの水平整列を指定します。この属性は HTML テーブル内の各 TD タグに渡されます。
 * @binding cellVAlign - 各セルの垂直整列を指定します。この属性は HTML テーブル内の各 TD タグに渡されます。
 * @binding cellpadding - 各セルのパッディングを指定します。この属性は HTML テーブルタグに渡されます。
 * @binding cellspacing - 各セルのスペースを指定します。この属性は HTML テーブルタグに渡されます。
 * @binding cellWidth - テーブル内のセル幅。この属性は HTML テーブル内の各 TD タグに渡されます。
 * @binding cellClass
 * @binding relationshipName
 * @binding relationshipOwner
 * @binding tableOtherTagString - どんな文字列もオープニングタグの一部にさせます。これは "checked" 又は
 *          "selected" のような独立型の属性をタグの一部にします。
 * @binding id optional ID for element wrapping checkbox matrix
 * @binding itemID optional ID for each checkbox element
 * @binding disabled
 */
@TBStateless
public class TBCheckboxMatrix extends ERXNonSynchronizingComponent {

  private static final long serialVersionUID = 1L;

  public static final Logger log = Logger.getLogger(TBCheckboxMatrix.class);

  private static final Integer DEFAULT_PADDING = Integer.valueOf(0);
  private static final Integer DEFAULT_SPACING = Integer.valueOf(0);

  public TBCheckboxMatrix(WOContext aContext) {
    super(aContext);
  }

  protected NSArray _selections;
  protected Object currentItem;
  public int index;
  public String wrapperElementID;

  @Override
  public void reset() {
    invalidateCaches();
  }

  public String onClick(boolean onOff) {
    return "TBCheckboxMatrix.checkAll(this.form, '" + wrapperElementID + "'," + (onOff ? "true" : "false") + ")";
  }

  public String selectOnClick() {
    return onClick(true);
  }

  public String deselectOnClick() {
    return onClick(false);
  }

  public Object currentItem() {
    setValueForBinding(currentItem, "item");
    return currentItem;
  }

  public void setCurrentItem(Object anItem) {
    currentItem = anItem;
    setValueForBinding(currentItem, "item");
  }

  public EOEnterpriseObject relationshipOwner() {
    return (EOEnterpriseObject) valueForBinding("relationshipOwner");
  }

  public String relationshipName() {
    Object o = valueForBinding("relationshipName");
    return o == null ? null : o.toString();
  }

  public NSArray selections() {
    if (_selections == null) {
      _selections = (NSArray) valueForBinding("selections");
    }
    return _selections;
  }

  public void setSelections(Vector v) {
    NSRange r = new NSRange(0, v.size());
    setSelections(new NSArray(v, r, true));
  }

  @Override
  public void takeValueForKey(Object value, String key) {
    try {
      super.takeValueForKey(value, key);
    }
    catch (java.lang.IllegalArgumentException e) {
      if (value instanceof Vector) {
        // convert the vector
        NSRange r = new NSRange(0, ((Vector) value).size());
        NSMutableArray a = new NSMutableArray((Vector) value, r, true);
        super.takeValueForKey(a, key);
        NSLog.out.appendln("done");
      }
      else {
        throw e;
      }
    }
  }

  public void setSelections(NSArray<String> aFormValuesArray) {
    if (aFormValuesArray != null && !disabled()) {
      // This is where we accept the formValues.

      // this can be an EOEnterpriseObject but also a list of Enums, so use
      // Object here
      NSMutableArray<Object> aSelectionsArray = new NSMutableArray<>();
      Enumeration<String> anIndexEnumerator = aFormValuesArray.objectEnumerator();
      NSArray<Object> anItemList = maybeSortedList();

      int anItemCount = anItemList.count();
      while (anIndexEnumerator.hasMoreElements()) {
        int anIndex = Integer.parseInt(anIndexEnumerator.nextElement());
        if (anIndex != TBFConstants.NOT_FOUND && anIndex < anItemCount) {
          Object anObject = anItemList.objectAtIndex(anIndex);
          aSelectionsArray.addObject(anObject);
        }
        else {
          // ** serious problem here. Raise an exception?
        }
      }

      // dt: this can be used with a subset as array for the checkboxes.
      if (relationshipName() != null && relationshipName().length() > 0 && relationshipOwner() != null && aSelectionsArray.firstObject() instanceof EOEnterpriseObject) {

        NSSet<EOEnterpriseObject> objectsToRemove = new NSSet(_selections).setBySubtractingSet(new NSSet(aSelectionsArray));
        NSSet<EOEnterpriseObject> objectsToAdd = new NSSet(aSelectionsArray).setBySubtractingSet(new NSSet(_selections));
        EOEnterpriseObject owner = relationshipOwner();
        String relname = relationshipName();
        for (Enumeration<EOEnterpriseObject> e = objectsToRemove.objectEnumerator(); e.hasMoreElements();) {
          EOEnterpriseObject eo = e.nextElement();
          owner.removeObjectFromBothSidesOfRelationshipWithKey(eo, relname);
        }
        for (Enumeration<EOEnterpriseObject> e = objectsToAdd.objectEnumerator(); e.hasMoreElements();) {
          EOEnterpriseObject eo = e.nextElement();
          owner.addObjectToBothSidesOfRelationshipWithKey(eo, relname);
        }

      }
      else {
        setValueForBinding(aSelectionsArray, "selections");
      }
      _selections = null;
    }
  }

  public String otherTagStringForCheckBox() {
    boolean isDisabled = disabled();
    boolean isChecked = selections() != null && selections().containsObject(currentItem);
    return (isDisabled ? "disabled" : TBFConstants.EMPTY_STRING) + (isDisabled && isChecked ? " " : TBFConstants.EMPTY_STRING) + (isChecked ? "checked" : TBFConstants.EMPTY_STRING);
  }

  private boolean disabled() {
    return booleanValueForBinding("disabled", false);
  }

  public void invalidateCaches() {
    _selections = null;
    currentItem = null;
    index = 0;
    wrapperElementID = null;
  }

  @Override
  public void sleep() {
    invalidateCaches();
  }

  @Override
  public void appendToResponse(WOResponse aResponse, WOContext aContext) {
    // ** By setting these to nil, we allow the dictionary to change after the
    // action and before the next cycle of this component (if the component is
    // on a page which is recycled)
    invalidateCaches();
    super.appendToResponse(aResponse, aContext);
  }

  public NSArray<Object> maybeSortedList() {
    if (hasBinding("sortKey")) {
      String sortKey = (String) valueForBinding("sortKey");
      if (sortKey != null && sortKey.length() > 0) {
        NSMutableArray sortedList = new NSMutableArray((NSArray) valueForBinding("list"));
        TBEnterpriseArrayUtilities.sortArrayWithKey(sortedList, sortKey);
        return sortedList;
      }
    }
    return (NSArray<Object>) valueForBinding("list");
  }

  public boolean isListEmpty() {
    NSArray anItemList = (NSArray) valueForBinding("list");
    return (anItemList == null || anItemList.count() == 0);
  }

  public Object cellpadding() {
    Object v = valueForBinding("cellpadding");

    if (v != null)
      return v;
    return DEFAULT_PADDING;
  }

  public Object cellspacing() {
    Object v = valueForBinding("cellspacing");

    if (v != null)
      return v;
    return DEFAULT_SPACING;
  }

}
