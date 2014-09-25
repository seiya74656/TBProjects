package org.treasureboat.app.components;

import org.treasureboat.webcore.annotations.TBNonSynchronizing;
import org.treasureboat.webcore.annotations.TBPageAccess;
import org.treasureboat.webcore.appserver.location.TBWStaticResource;
import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;
import com.webobjects.foundation.NSTimestamp;

@TBPageAccess (
    navigationState = "Welcome"
    )
@TBNonSynchronizing

public class Main extends TBComponent {
	/**
	 * Do I need to update serialVersionUID?
	 * See section 5.6 <cite>Type Changes Affecting Serialization</cite> on page 51 of the 
	 * <a href="http://java.sun.com/j2se/1.4/pdf/serial-spec.pdf">Java Object Serialization Spec</a>
	 */
	private static final long serialVersionUID = 1L;

	//********************************************************************
	//  Constructor : コンストラクタ
	//********************************************************************

	public Main(WOContext context) {
		super(context);
	}

	public String plaintext() {
    return "This is a plain txt";
}

  public String emptytext() {
    return "This is a plain txt";
}
  
  public int number(){
    return 5;
    
  }
 public NSTimestamp timestamp() {
   return new NSTimestamp();
   
 }
 
 public String htmltext(){
   return "Hello <strong> World</strong>";
   
 }
 public String markdowntext(){
   return "Hello **Strong** markdown Text [default link](da://default)";

 }  
public String someJavascript(){
  return "var a = 1";
}

public TBWStaticResource sampleimage(){
TBWStaticResource sr = new TBWStaticResource("static://images/tb.jpg");
 return sr;
 }
}
