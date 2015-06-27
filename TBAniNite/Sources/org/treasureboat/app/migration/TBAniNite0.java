package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBEnterpriseMigrationDatabase;
import org.treasureboat.enterprise.migration.TBEnterpriseMigrationTable;
import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

public class TBAniNite0 extends TBEnterpriseMigrationDatabase.Migration {

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
	  
	    TBEnterpriseMigrationTable gewinnspielTeilnehmerTable = database.newTableNamed("GewinnspielTeilnehmer");
	    gewinnspielTeilnehmerTable.newBooleanColumn("agb", false);
	    gewinnspielTeilnehmerTable.newIntegerColumn("antwort", false);
	    gewinnspielTeilnehmerTable.newTimestampColumn("datum", false);
	    gewinnspielTeilnehmerTable.newStringColumn("email", 100, false);
	    gewinnspielTeilnehmerTable.newIntegerColumn("id", false);
	    gewinnspielTeilnehmerTable.newStringColumn("name", 100, false);
	    gewinnspielTeilnehmerTable.create();
	    gewinnspielTeilnehmerTable.setPrimaryKey("id");
	  
	}
	
}