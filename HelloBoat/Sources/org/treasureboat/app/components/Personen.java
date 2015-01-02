package org.treasureboat.app.components;

public class Personen {
  
  public Personen(String vorName, String nachName){
    super(); //WHY SUPER
    
    _vorName = vorName;
    this.nachName = nachName;        
  }

  public void setNachName(String nachName) {
    this.nachName = nachName;
  }
  public String nachName(){
    return nachName;
  }
  private String nachName;

  public void setVorName(String vorName) {
    _vorName = vorName;
  }
  public String vorName(){
    return _vorName;
  }
  private String _vorName;

}