package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;

public class TBAniNite1 extends ERXMigrationDatabase.Migration {

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
	  
    ERXMigrationTable contentTable = database.newTableNamed("Content");
    contentTable.newStringColumn("category", 100, false);
    contentTable.newStringColumn("description", false);
    contentTable.newStringColumn("title", 255, false);
    contentTable.newIntegerColumn("id", false);
    contentTable.create();
    contentTable.setPrimaryKey("id");
	  
	}
	
}