package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;

public class TBLarenta0 extends ERXMigrationDatabase.Migration {

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
	  
    ERXMigrationTable allergenInfoTBLTable = database.newTableNamed("AllergenInfoTBL");
    allergenInfoTBLTable.newStringColumn("Allergen", 100, false);
    allergenInfoTBLTable.newIntegerColumn("AllergenInfocode", false);
    allergenInfoTBLTable.newIntegerColumn("id", false);
    allergenInfoTBLTable.create();
    allergenInfoTBLTable.setPrimaryKey("id");

    ERXMigrationTable allergeneTBLTable = database.newTableNamed("AllergeneTBL");
    allergeneTBLTable.newIntegerColumn("Allergencode", false);
    allergeneTBLTable.newIntegerColumn("id", false);
    allergeneTBLTable.newIntegerColumn("SpeisenID", false);
    allergeneTBLTable.create();
    allergeneTBLTable.setPrimaryKey("id");

    ERXMigrationTable speisekarteTBLTable = database.newTableNamed("SpeisekarteTBL");
    speisekarteTBLTable.newStringColumn("Beschreibung", false);
    speisekarteTBLTable.newIntegerColumn("id", false);
    speisekarteTBLTable.newStringColumn("Name", 100, false);
    speisekarteTBLTable.newDoubleColumn("Preis", 0, 0, false);
    speisekarteTBLTable.newStringColumn("Sprache", 16, false);
    speisekarteTBLTable.create();
    speisekarteTBLTable.setPrimaryKey("id");

	}
	
}