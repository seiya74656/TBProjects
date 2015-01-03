package org.treasureboat.app.components;

public class Adventkalendar {

  public Adventkalendar (String tag, String code, String frage) {
    super();

    _tag = tag;
    _code = code;
    _frage = frage;

  }


  public void setTag(String tag) {
    _tag = tag;
  }
  public String tag() {
    return _tag;
  }
  private String _tag;

  public String code() {
    return _code;
  }

  public void setCode(String code) {
    _code = code;
  }

  private String _code;


  public String frage() {
    return _frage;
  }

  public void setFrage(String frage) {
    _frage = frage;
  }

  private String _frage;

}
