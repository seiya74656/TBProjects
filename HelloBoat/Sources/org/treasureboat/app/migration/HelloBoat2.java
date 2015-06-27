package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBEnterpriseMigrationDatabase;
import org.treasureboat.enterprise.migration.TBEnterpriseMigrationTable;
import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

public class HelloBoat2 extends TBEnterpriseMigrationDatabase.Migration {

	@Override
	public NSArray<TBWModelVersion> modelDependencies() {
		return null;
	}
  
	@Override
	public void downgrade(EOEditingContext editingContext, TBEnterpriseMigrationDatabase database) throws Throwable {
	    // DO NOTHING
	}

  @Override
  public void upgrade(EOEditingContext editingContext, TBEnterpriseMigrationDatabase database) throws Throwable {
    TBEnterpriseMigrationTable gewinnspielTBLTable = database.newTableNamed("GewinnspielTBL");
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