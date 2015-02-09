package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;

public class TBAniNite0 extends ERXMigrationDatabase.Migration {

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
	  
	    ERXMigrationTable gewinnspielTeilnehmerTable = database.newTableNamed("GewinnspielTeilnehmer");
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