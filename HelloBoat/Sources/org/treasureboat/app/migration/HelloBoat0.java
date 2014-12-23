package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;

public class HelloBoat0 extends ERXMigrationDatabase.Migration {

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
	  
	  ERXMigrationTable toDoTable = database.newTableNamed("ToDo");
    toDoTable.newTimestampColumn("dueDate", false);
    toDoTable.newIntegerColumn("id", false);
    toDoTable.newStringColumn("task", 100, false);
    toDoTable.create();
    toDoTable.setPrimaryKey("id");
	  
	}
	
}