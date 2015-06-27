package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBEnterpriseMigrationDatabase;
import org.treasureboat.enterprise.migration.TBEnterpriseMigrationTable;
import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

public class TBLarenta1 extends TBEnterpriseMigrationDatabase.Migration {

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

	  TBEnterpriseMigrationTable speisekarteTBLAllergenInfoTBLTable = database.newTableNamed("SpeisekarteTBLAllergenInfoTBL");
	    speisekarteTBLAllergenInfoTBLTable.newIntegerColumn("allergenInfoTBLId", false);
	    speisekarteTBLAllergenInfoTBLTable.newIntegerColumn("speisekarteTBLId", false);
	    speisekarteTBLAllergenInfoTBLTable.create();
	    speisekarteTBLAllergenInfoTBLTable.setPrimaryKey("speisekarteTBLId", "allergenInfoTBLId");

	    speisekarteTBLAllergenInfoTBLTable.addForeignKey("allergenInfoTBLId", "AllergenInfoTBL", "id");
	    speisekarteTBLAllergenInfoTBLTable.addForeignKey("speisekarteTBLId", "SpeisekarteTBL", "id");


	}
	
}