package org.treasureboat.app.components;

import org.treasureboat.foundation.TBFConstants;
import org.treasureboat.foundation.TBFString;


public class Caesar  {

  public Caesar() {
    super();
  }

  public Caesar (String str, int key) {
    this();
    verschluesselung(str, key); 
  }

  public void verschluesselung(String str, int key) {

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

    if(TBFString.stringIsNullOrEmpty(str) || key == TBFConstants.NOT_FOUND) {
      // do nothing
    } else {

      if(f >='a' && e <= 'z') {
        System.out.println("Lowercase: " + f);
      } else {
        System.out.println("Uppercase: "+ f);      
      }    

      StringBuilder sb = new StringBuilder();

      for(int i = 0; i < str.length();i++) {
        char c =  (char) (str.charAt(i) + key);

        while (c > 'Z') {
          c = (char) (c - 'Z' +'A' - 1);
        }
        sb.append(c);

      }
      verschluesseln = sb.toString();
    }
  }

  public String verschluesseln() {
    if(TBFString.stringIsNullOrEmpty(verschluesseln)) return "HOPPALA";
    return verschluesseln;
  }

  private String verschluesseln;
}
