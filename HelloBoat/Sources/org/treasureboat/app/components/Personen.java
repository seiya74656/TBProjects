package org.treasureboat.app.components;

public class Personen {
  private String vorName;
  private String nachName;

  public Personen(String vorName, String nachName){
    super(); //WHY SUPER
    this.vorName = vorName;
    this.nachName = nachName;        
  }

  public String nachName(){
    return nachName;
  }

  public void setnachName(String nachName) {
    this.nachName = nachName;
  }

  public String vorName(){
    return vorName;
  }

  public void setvorName(String vorName) {
    this.vorName = vorName;
  }

}