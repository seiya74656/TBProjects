package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBEnterpriseMigrationDatabase;
import org.treasureboat.enterprise.migration.TBEnterpriseMigrationTable;
import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

public class HelloBoat1 extends TBEnterpriseMigrationDatabase.Migration {

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
    TBEnterpriseMigrationTable gewinnspielTable = database.newTableNamed("Gewinnspiel");
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