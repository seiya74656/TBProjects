package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBEnterpriseMigrationDatabase;
import org.treasureboat.enterprise.migration.TBEnterpriseMigrationTable;
import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

public class HelloBoat0 extends TBEnterpriseMigrationDatabase.Migration {

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
	  
	  TBEnterpriseMigrationTable toDoTable = database.newTableNamed("ToDo");
    toDoTable.newIntegerColumn("id", false);
    toDoTable.create();
    toDoTable.setPrimaryKey("id");
    toDoTable.newTimestampColumn("dueDate", false);
    toDoTable.newStringColumn("task", 100, false);
	  
	}
	
}