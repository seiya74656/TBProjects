package org.treasureboat.app.components;

import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;

public class AniNiteHome extends TBComponent {

  private static final long serialVersionUID = 1L;

  public AniNiteHome(WOContext context) {
    super(context);
    // TODO Auto-generated constructor stub
  }

  public org.treasureboat.app.eo.Content getContent() {
    return org.treasureboat.app.eo.Content.fetchContent(editingContext(), org.treasureboat.app.eo.Content.CATEGORY.eq("Cosplay"));
  }

  
}
