package org.treasureboat.app.components;

import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;

public class AniNiteHome extends TBComponent {

  private static final long serialVersionUID = 1L;

  public boolean _isEdit = false;

  public AniNiteHome(WOContext context) {
    super(context);
    // TODO Auto-generated constructor stub
  }

  public org.treasureboat.app.eo.Content getFeatured1() {
    return org.treasureboat.app.eo.Content.fetchContent(editingContext(), org.treasureboat.app.eo.Content.CATEGORY.eq("featured1"));
  }

  public org.treasureboat.app.eo.Content getFeatured2() {
    return org.treasureboat.app.eo.Content.fetchContent(editingContext(), org.treasureboat.app.eo.Content.CATEGORY.eq("featured2"));
  }

  public org.treasureboat.app.eo.Content getFeatured3() {
    return org.treasureboat.app.eo.Content.fetchContent(editingContext(), org.treasureboat.app.eo.Content.CATEGORY.eq("featured3"));
  }

  public org.treasureboat.app.eo.Content getFeatured4() {
    return org.treasureboat.app.eo.Content.fetchContent(editingContext(), org.treasureboat.app.eo.Content.CATEGORY.eq("featured4"));
  }

  public org.treasureboat.app.eo.Content getFeatured5() {
    return org.treasureboat.app.eo.Content.fetchContent(editingContext(), org.treasureboat.app.eo.Content.CATEGORY.eq("featured5"));
  }

  public org.treasureboat.app.eo.Content getFeatured6() {
    return org.treasureboat.app.eo.Content.fetchContent(editingContext(), org.treasureboat.app.eo.Content.CATEGORY.eq("featured6"));
  }

  public org.treasureboat.app.eo.Content getFeaturedlast() {
    return org.treasureboat.app.eo.Content.fetchContent(editingContext(), org.treasureboat.app.eo.Content.CATEGORY.eq("featuredlast"));
  }
  
  public org.treasureboat.app.eo.Content getFeaturedhandler() {
    return org.treasureboat.app.eo.Content.fetchContent(editingContext(), org.treasureboat.app.eo.Content.CATEGORY.eq("handler"));
  }

  public org.treasureboat.app.eo.Content getFeaturedlist() {
    return org.treasureboat.app.eo.Content.fetchContent(editingContext(), org.treasureboat.app.eo.Content.CATEGORY.eq("festurelist"));
  }

  public org.treasureboat.app.eo.Content getFeaturedsponsor() {
    return org.treasureboat.app.eo.Content.fetchContent(editingContext(), org.treasureboat.app.eo.Content.CATEGORY.eq("sponsor"));
  }

  public org.treasureboat.app.eo.Content getFooter() {
    return org.treasureboat.app.eo.Content.fetchContent(editingContext(), org.treasureboat.app.eo.Content.CATEGORY.eq("footer"));
  }

  public org.treasureboat.app.eo.Content getSubtitle() {
    return org.treasureboat.app.eo.Content.fetchContent(editingContext(), org.treasureboat.app.eo.Content.CATEGORY.eq("subtitle"));
  }

  public org.treasureboat.app.eo.Content getMaintitle() {
    return org.treasureboat.app.eo.Content.fetchContent(editingContext(), org.treasureboat.app.eo.Content.CATEGORY.eq("maintitle"));
  }
  
  public org.treasureboat.app.eo.Content getVVK() {
    return org.treasureboat.app.eo.Content.fetchContent(editingContext(), org.treasureboat.app.eo.Content.CATEGORY.eq("vvk"));
  }

  public WOActionResults doSwitchAutomatic() {
    _isEdit = !_isEdit;

    return goToMySelfAction();
  }

  public WOActionResults saveChanges() {
    _isEdit = !_isEdit;
    editingContext().saveChanges();
    return goToMySelfAction();
  }

  
}
