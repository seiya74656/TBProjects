package org.treasureboat.app.components;

import org.treasureboat.app.eo.Content;
import org.treasureboat.webcore.appserver.TBContext;
import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOActionResults;

public class AniNiteHome extends TBComponent {

  private static final long serialVersionUID = 1L;

  public boolean _isEdit = false;

  public AniNiteHome(TBContext context) {
    super(context);
    // TODO Auto-generated constructor stub
  }

  public Content getFeatured1() {
    return Content.fetchContent(editingContext(), Content.CATEGORY.eq("featured1"));
  }

  public Content getFeatured2() {
    return Content.fetchContent(editingContext(), Content.CATEGORY.eq("featured2"));
  }

  public Content getFeatured3() {
    return Content.fetchContent(editingContext(), Content.CATEGORY.eq("featured3"));
  }

  public Content getFeatured4() {
    return Content.fetchContent(editingContext(), Content.CATEGORY.eq("featured4"));
  }

  public Content getFeatured5() {
    return Content.fetchContent(editingContext(), Content.CATEGORY.eq("featured5"));
  }

  public Content getFeatured6() {
    return Content.fetchContent(editingContext(), Content.CATEGORY.eq("featured6"));
  }

  public Content getFeaturedlast() {
    return Content.fetchContent(editingContext(), Content.CATEGORY.eq("featuredlast"));
  }
  
  public Content getFeaturedhandler() {
    return Content.fetchContent(editingContext(), Content.CATEGORY.eq("handler"));
  }

  public Content getFeaturedlist() {
    return Content.fetchContent(editingContext(), Content.CATEGORY.eq("festurelist"));
  }

  public Content getFeaturedsponsor() {
    return Content.fetchContent(editingContext(), Content.CATEGORY.eq("sponsor"));
  }

  public Content getFooter() {
    return Content.fetchContent(editingContext(), Content.CATEGORY.eq("footer"));
  }

  public Content getSubtitle() {
    return Content.fetchContent(editingContext(), Content.CATEGORY.eq("subtitle"));
  }

  public Content getMaintitle() {
    return Content.fetchContent(editingContext(), Content.CATEGORY.eq("maintitle"));
  }
  
  public Content getVVK() {
    return Content.fetchContent(editingContext(), Content.CATEGORY.eq("vvk"));
  }

  public Content getTicketinfo() {
    return Content.fetchContent(editingContext(), Content.CATEGORY.eq("ticketinfo"));
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
