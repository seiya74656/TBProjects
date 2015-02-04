package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;

public class HelloBoat2 extends ERXMigrationDatabase.Migration {

	@Override
	public NSArray<TBWModelVersion> modelDependencies() {
		return null;
	}
  
	@Override
	public void downgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
	    // DO NOTHING
	}

  @Override
  public void upgrade(EOEditingContext editingContext, ERXMigrationDatabase database) throws Throwable {
    ERXMigrationTable gewinnspielTBLTable = database.newTableNamed("GewinnspielTBL");
    gewinnspielTBLTable.newBooleanColumn("agb", false);
    gewinnspielTBLTable.newStringColumn("antwort", 100, false);
    gewinnspielTBLTable.newTimestampColumn("datum", false);
    gewinnspielTBLTable.newStringColumn("email", 100, false);
    gewinnspielTBLTable.newIntegerColumn("id", false);
    gewinnspielTBLTable.newStringColumn("name", 100, false);
    gewinnspielTBLTable.create();
    gewinnspielTBLTable.setPrimaryKey("id");

  }
	
}