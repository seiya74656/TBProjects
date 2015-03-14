package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

import er.extensions.migration.ERXMigrationDatabase;
import er.extensions.migration.ERXMigrationTable;

public class TBLarenta2 extends ERXMigrationDatabase.Migration {

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

    ERXMigrationTable barcodeCheckTBLTable = database.newTableNamed("BarcodeCheckTBL");
    barcodeCheckTBLTable.newIntegerColumn("barcodevalid", false);
    barcodeCheckTBLTable.newDateColumn("validDate", false);
    barcodeCheckTBLTable.newIntegerColumn("id", false);
    barcodeCheckTBLTable.create();
    barcodeCheckTBLTable.setPrimaryKey("id");

    ERXMigrationTable barcodeRechnungTBLTable = database.newTableNamed("BarcodeRechnungTBL");
    barcodeRechnungTBLTable.newIntegerColumn("barcode", false);
    barcodeRechnungTBLTable.newIntegerColumn("id", false);
    barcodeRechnungTBLTable.newTimestampColumn("scanned", false);
    barcodeRechnungTBLTable.create();
    barcodeRechnungTBLTable.setPrimaryKey("id");


	}
	
}