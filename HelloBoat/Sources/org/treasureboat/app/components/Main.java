package org.treasureboat.app.components;

import org.treasureboat.app.eo.ToDo;
import org.treasureboat.foundation.date.TBFTimestamp;
import org.treasureboat.foundation.image.TBFImage;
import org.treasureboat.webcore.annotations.TBNonSynchronizing;
import org.treasureboat.webcore.annotations.TBPageAccess;
import org.treasureboat.webcore.appserver.TBContext;
import org.treasureboat.webcore.appserver.iface.ITBWActionResults;
import org.treasureboat.webcore.appserver.location.TBWStaticResource;
import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.foundation.NSTimestamp;

@TBPageAccess (
    navigationState = "Welcome"
    )
@TBNonSynchronizing

public class Main extends TBComponent {

	private static final long serialVersionUID = 1L;

	//********************************************************************
	//  Constructor : コンストラクタ
	//********************************************************************

	public Main(TBContext context) {
		super(context);
	}
	
	
	public String plaintext() {
    return "This is a plain txt";
}
  
  public String plaintext2() {
    return "This is a plain txt when value is empty";
}

  public String emptytext() {
    return "";
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

public TBFImage sampleimage2(){
    return new TBFImage("static://images/logo.png", "Alt Text Image", 200, 100, "page://Main", "_blank","","-webkit-box-shadow: 10px 10px 10px 10px rgba(0, 0, 0, 1);");  //IMGURL, ALT Text, Width, Height, HREF, Target, CSS, Style
}

public String sampleMarkdownImage(){
  StringBuilder sb = new StringBuilder();
  sb.append("---\n");
  sb.append("***Markdown Image Sample***\n");
  sb.append("![WithImage](static://images/logo.png) \n");
  sb.append("---\n");
  sb.append("Link [Testlink](http://www.google.com) \n");
  return sb.toString();
  
}

public ITBWActionResults doDBTestaction(){
  
  ToDo todo = ToDo.createAndInsertInstance(editingContext());
  
  todo.setTask("my first task");
  todo.setDueDate(new TBFTimestamp()); 
  editingContext().saveChanges();
  
  System.err.println("--> we are here!");
  return goToMySelfAction();
}


public TBWStaticResource sampleimage(){
TBWStaticResource sr = new TBWStaticResource("static://images/tb.jpg");
 return sr;
 }

}
