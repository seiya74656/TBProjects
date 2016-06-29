package org.treasureboat.app.components;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.treasureboat.app.eo.GewinnspielTBL;
import org.treasureboat.foundation.TBFString;
import org.treasureboat.foundation.date.TBFTimestamp;
import org.treasureboat.webcore.appserver.TBContext;
import org.treasureboat.webcore.appserver.TBSession;
import org.treasureboat.webcore.appserver.iface.ITBWActionResults;
import org.treasureboat.webcore.components.TBComponent;
import org.treasureboat.webcore.enums.ETBWLanguage;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.eof.ERXEC;

public class Gewinnspiel extends TBComponent {

  private static final long serialVersionUID = 1L;

  // ********************************************************************
  // Constructor : コンストラクタ
  // ********************************************************************
  public Gewinnspiel(TBContext context) {
    super(context);

  }

  // ********************************************************************
  // Methods : メソッド
  // ********************************************************************

  public String email = "";
  public String deinname = "";
  public String antwort = "";

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

  public NSArray<GewinnspielTBL> allGewinnspielTBLs() {
    return GewinnspielTBL.fetchAllGewinnspielTBLs(editingContext());
  }

  public GewinnspielTBL oneGewinnspiel;

  public ITBWActionResults doCreateAction() {

    EOEditingContext ec = ERXEC.newEditingContext();

    GewinnspielTBL newGewinnspielTBL = GewinnspielTBL.createAndInsertInstance(ec);
    newGewinnspielTBL.setAntwort("1");
    newGewinnspielTBL.setName("Rene");
    newGewinnspielTBL.setAgb(agb);
    newGewinnspielTBL.setEmail("seiya@me.com");
    newGewinnspielTBL.setDatum(new NSTimestamp());
    log.info("here------>>>");
    ec.saveChanges();

    return goToMySelfAction();
  }

  public ITBWActionResults doEnglishAction() {
    TBSession.session().setLanguage(ETBWLanguage.English.name());
    return goToMySelfAction();
  }

  public ITBWActionResults doGermanAction() {
    TBSession.session().setLanguage(ETBWLanguage.German.name());
    return goToMySelfAction();
  }

  public ITBWActionResults doJapaneseAction() {
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
  // public ITBWActionResults invokeAction(WORequest request, WOContext context) {
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

  private void writertoFile(String deinname2, String antwort2, String email2, Boolean agb2) throws IOException {
    // Datei erstellen und beschreiben

    try {

      // File file = new File("gewinnerliste.txt");
      // if (!file.exists()) {
      // file.createNewFile();
      // }
      //
      // FileWriter writerX = new FileWriter(file, true);

      FileWriter writer = new FileWriter("gewinnerliste.txt", true);
      writer.append("Date: " + timestamp() + ", \t Name: " + deinname2 + ", Email: " + email2 + ", Antwort: " + antwort2 + " AGB: " + agb2 + "\n");
      writer.close();
      log.info(">>>> Daten wurden in die Datei geschrieben!! <<<<");
    }
    catch (FileNotFoundException | UnsupportedEncodingException e) {
      log.info("File not found");
      e.printStackTrace();
    }
  }

  // Datei erstellen und beschreiben

  public ITBWActionResults doMitmachenAction() throws IOException {
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

    if (TBFString.stringIsNullOrEmpty(deinname) || TBFString.stringIsNullOrEmpty(email) || TBFString.stringIsNullOrEmpty(antwort) || !isValidEmailAddress(email)) {
      log.info("Mitmachen fehlgeschlagen!!! AGB: {}, Name: {}, Email: {}, Antwort: {}", agb, deinname, email, antwort);
    }
    else {
      log.info("Mitmachen wurde aufgerufen. AGB: {}, Name: {}, Email: {}, Antwort: {}", agb, deinname, email, antwort);
      writertoFile(deinname, antwort, email, agb);

      EOEditingContext ec = ERXEC.newEditingContext();
      GewinnspielTBL newGewinnspielTBL = GewinnspielTBL.createAndInsertInstance(ec);
      newGewinnspielTBL.setAntwort(antwort);
      newGewinnspielTBL.setName(deinname);
      newGewinnspielTBL.setAgb(agb);
      newGewinnspielTBL.setEmail(email);
      newGewinnspielTBL.setDatum(new NSTimestamp());
      log.info("gespeichert------>>>");
      ec.saveChanges();
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
