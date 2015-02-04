package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;

public class HelloBoat1 extends ERXMigrationDatabase.Migration {

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
    ERXMigrationTable gewinnspielTable = database.newTableNamed("Gewinnspiel");
    gewinnspielTable.newBooleanColumn("agb", false);
    gewinnspielTable.newStringColumn("antwort", 100, false);
    gewinnspielTable.newTimestampColumn("datum", false);
    gewinnspielTable.newStringColumn("email", 100, false);
    gewinnspielTable.newIntegerColumn("id", false);
    gewinnspielTable.newStringColumn("name", 100, false);
    gewinnspielTable.create();
    gewinnspielTable.setPrimaryKey("id");

  }
	
}