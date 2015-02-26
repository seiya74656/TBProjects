package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;

public class TBLarenta1 extends ERXMigrationDatabase.Migration {

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

	  ERXMigrationTable speisekarteTBLAllergenInfoTBLTable = database.newTableNamed("SpeisekarteTBLAllergenInfoTBL");
	    speisekarteTBLAllergenInfoTBLTable.newIntegerColumn("allergenInfoTBLId", false);
	    speisekarteTBLAllergenInfoTBLTable.newIntegerColumn("speisekarteTBLId", false);
	    speisekarteTBLAllergenInfoTBLTable.create();
	    speisekarteTBLAllergenInfoTBLTable.setPrimaryKey("speisekarteTBLId", "allergenInfoTBLId");

	    speisekarteTBLAllergenInfoTBLTable.addForeignKey("allergenInfoTBLId", "AllergenInfoTBL", "id");
	    speisekarteTBLAllergenInfoTBLTable.addForeignKey("speisekarteTBLId", "SpeisekarteTBL", "id");


	}
	
}