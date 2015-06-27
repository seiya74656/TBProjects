package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBEnterpriseMigrationDatabase;
import org.treasureboat.enterprise.migration.TBEnterpriseMigrationTable;
import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

public class TBLarenta0 extends TBEnterpriseMigrationDatabase.Migration {

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
	  
    TBEnterpriseMigrationTable allergenInfoTBLTable = database.newTableNamed("AllergenInfoTBL");
    allergenInfoTBLTable.newStringColumn("Allergen", 100, false);
    allergenInfoTBLTable.newIntegerColumn("AllergenInfocode", false);
    allergenInfoTBLTable.newIntegerColumn("id", false);
    allergenInfoTBLTable.create();
    allergenInfoTBLTable.setPrimaryKey("id");
    
    TBEnterpriseMigrationTable speisekarteTBLTable = database.newTableNamed("SpeisekarteTBL");
    speisekarteTBLTable.newStringColumn("Beschreibung", false);
    speisekarteTBLTable.newIntegerColumn("id", false);
    speisekarteTBLTable.newStringColumn("Name", 100, false);
    speisekarteTBLTable.newDoubleColumn("Preis", 0, 0, false);
    speisekarteTBLTable.newStringColumn("Sprache", 16, false);
    speisekarteTBLTable.create();
    speisekarteTBLTable.setPrimaryKey("id");

	}
	
}