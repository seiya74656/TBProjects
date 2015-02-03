package org.treasureboat.app.components;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.treasureboat.foundation.TBFFile;
import org.treasureboat.foundation.TBFFileUtilities;
import org.treasureboat.foundation.TBFString;
import org.treasureboat.foundation.date.TBFTimestamp;
import org.treasureboat.webcore.appserver.TBSession;
import org.treasureboat.webcore.components.TBComponent;
import org.treasureboat.webcore.enums.ETBWLanguage;

import com.webobjects.appserver.WOActionResults;
import com.webobjects.appserver.WOContext;

public class Gewinnspiel extends TBComponent {

  private static final long serialVersionUID = 1L;

  // ********************************************************************
  // Constructor : コンストラクタ
  // ********************************************************************
  public Gewinnspiel(WOContext context) {
    super(context);

  }

  // ********************************************************************
  // Methods : メソッド
  // ********************************************************************

  public String email = "";
  public String deinname = "";
  public String antwort = "2";

  public boolean agb = false;

  // ********************************************************************
  // Actions : アクション
  // ********************************************************************
  public boolean isValidEmailAddress(String emailadress) {
    String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
    java.util.regex.Matcher m = p.matcher(emailadress);
    return m.matches();
  }

  public WOActionResults doEnglishAction() {
    TBSession.session().setLanguage(ETBWLanguage.English.name());
    return goToMySelfAction();
  }

  public WOActionResults doGermanAction() {
    TBSession.session().setLanguage(ETBWLanguage.German.name());
    return goToMySelfAction();
  }

  public WOActionResults doJapaneseAction() {
    TBSession.session().setLanguage(ETBWLanguage.Japanese.name());
    return goToMySelfAction();
  }

  // public String elementID() {
  // if (TBFString.stringIsNullOrEmpty(_elementID)) {
  // _elementID = context().elementID();
  // }
  // return _elementID;
  // }
  // private String _elementID;

  // Response Request Loop

  // @Override
  // public void awake() {
  // super.awake();
  // }
  //
  // @Override
  // public void takeValuesFromRequest(WORequest request, WOContext context) {
  // super.takeValuesFromRequest(request, context);
  // }

  // @Override
  // public WOActionResults invokeAction(WORequest request, WOContext context) {
  // return super.invokeAction(request, context);
  // }
  //
  // @Override
  // public void appendToResponse(WOResponse response, WOContext context) {
  // super.appendToResponse(response, context);
  // _elementID = null;
  // }
  //
  // @Override
  // public void sleep() {
  // super.sleep();
  // }

  private void writertoFile(String name, String antwort, String email, Boolean agb) throws IOException {
    // Datei erstellen und beschreiben

    try {
      
      
//      File file = new File("gewinnerliste.txt");
//      if (!file.exists()) {
//        file.createNewFile();
//      }
//      
//      FileWriter writerX = new FileWriter(file, true);
      
      
      FileWriter writer = new FileWriter("gewinnerliste.txt", true);
      writer.append("Date: " + timestamp() + ", \t Name: " + deinname + ", Email: " + email + ", Antwort: " + antwort + " AGB: " + agb + "\n");
      writer.close();
      log.info(">>>> Daten wurden in die Datei geschrieben!! <<<<");
    }
    catch (FileNotFoundException | UnsupportedEncodingException e) {
      log.info("File not found");
      e.printStackTrace();
    }
  }
  // Datei erstellen und beschreiben


  public WOActionResults doMitmachenAction() throws IOException {
    // WOContext context = context();
    // System.err.println("WOContext --> " + context);
    // System.err.println("WORequest --> " + context.request());
    // System.err.println("WOResponse --> " + context.response());

    // Other way to get Information from html form context antwortX!

    // WORequest request = context.request();
    // System.err.println(request.formValueKeys());
    // System.err.println("=== " + request.formValuesForKey("antwortX"));

    // Email

    // System.err.println(TBFEmailChecker.emailCharFullCheck("rene@yahoo.com"));
    // System.err.println(TBFEmailChecker.emailCharFullCheck("rene@yahoo.c"));

    if (!agb || TBFString.stringIsNullOrEmpty(deinname) || TBFString.stringIsNullOrEmpty(email) || TBFString.stringIsNullOrEmpty(antwort) || !isValidEmailAddress(email)) {
      log.info("Mitmachen fehlgeschlagen!!! AGB: {}, Name: {}, Email: {}, Antwort: {}", agb, deinname, email, antwort);
    }
    else {
      log.info("Mitmachen wurde aufgerufen. AGB: {}, Name: {}, Email: {}, Antwort: {}", agb, deinname, email, antwort);
      writertoFile(deinname, antwort, email, agb);

      /*
       * ERJavaMail sendmail = new ERJavaMail();
       * sendmail.isValidEmail(email);
       */
      // ERMailDeliveryPlainText mail = new ERMailDeliveryPlainText();
      // mail.setTextContent("Hello TreasureBoat!");
      // try {
      //
      // mail.setSubject("TreasureBoat Test Mail!");
      // mail.sendMail();
      //
      // mail.newMail();
      // mail.setFromAddress("renate@ebone.at");
      // mail.setReplyToAddress("seiya@me.com");
      // mail.setSubject("Test ueberschrift");
      // mail.setToAddress("seiya74656@gmail.com");
      // mail.sendMail();
      // } catch (Exception e) {
      // System.err.println("Mailsenden fehlgeschlagen: " + e);
      // }

    }
    return goToMySelfAction();
  }

  public TBFTimestamp timestamp() {
    return new TBFTimestamp();
  }

}
