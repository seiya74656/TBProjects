package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBEnterpriseMigrationDatabase;
import org.treasureboat.enterprise.migration.TBEnterpriseMigrationTable;
import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

public class TBAniNite1 extends TBEnterpriseMigrationDatabase.Migration {

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
	  
    TBEnterpriseMigrationTable contentTable = database.newTableNamed("Content");
    contentTable.newStringColumn("category", 100, false);
    contentTable.newStringColumn("description", false);
    contentTable.newStringColumn("title", 255, false);
    contentTable.newIntegerColumn("id", false);
    contentTable.create();
    contentTable.setPrimaryKey("id");
	  
	}
	
}