package org.treasureboat.app.components;

import org.treasureboat.foundation.TBFString;
import org.treasureboat.webcore.components.TBComponent;

import com.webobjects.appserver.WOContext;

public class Convention extends TBComponent {

  private static final long serialVersionUID = 1L;

  //********************************************************************
  //  Constructor : コンストラクタ
  //********************************************************************


  public Convention(WOContext context) {
    super(context);
  }

  //********************************************************************
  //  Actions : アクション
  //********************************************************************


  public String getConvention() {
    return _convention;
  }

  public void setConvention(String convention) {
    _convention = convention;
  }

  public void setConvention(String convention, String beschreibung) {
    _convention = "<h2>Convention: <b>" + convention + " </h2> " + beschreibung + "</b><br/>";
  }
  private String _convention;

  public String getRandomtext() {
    return _randomtext;
  }

  public void setRandomtext(String Randomtext) {
    _randomtext = Randomtext;
    caesar(Randomtext, 1);

  }

  private String _randomtext;


  public void caesar(String str, int key) {

    String d = "Abc";
    char e = (char) (d.charAt(0)+1);
    char f = (char) (d.charAt(1)+4);
    System.out.println("CHAR ohne Plus: " + e); // Gibt "B" zurück"

    System.out.println("CHAR mit Plus: " + f); // Gibt "e" zurück (a + 4 = e) -> a,b,c,d,e.....

    if(e >='a' && e <= 'z') {
      System.out.println("Lowercase: " + e);
    } else {
      System.out.println("Uppercase: " + e);      
    }

    if(TBFString.stringIsNullOrEmpty(str) || key < 0) {
      // do nothing
    } else {

      if(f >='a' && e <= 'z') {
        System.out.println("Lowercase: " + f);
      } else {
        System.out.println("Uppercase: "+ f);      
      }    


      for(int i = 0; i < str.length();i++) {
        str = str.toUpperCase();
        char c =  (char) (str.charAt(i) + key);
        //  System.out.println("Char in der For:" + c);



        while (c > 'Z') {
          c = (char) (c - 'Z' +'A' - 1);
        }

        // System.out.println("DDD:" + c);
      }

    }
  }
}