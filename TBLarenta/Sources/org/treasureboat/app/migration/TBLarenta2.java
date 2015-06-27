package org.treasureboat.app.migration;

import org.treasureboat.enterprise.migration.TBEnterpriseMigrationDatabase;
import org.treasureboat.enterprise.migration.TBEnterpriseMigrationTable;
import org.treasureboat.enterprise.migration.TBWModelVersion;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.foundation.NSArray;

public class TBLarenta2 extends TBEnterpriseMigrationDatabase.Migration {

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

    TBEnterpriseMigrationTable barcodeCheckTBLTable = database.newTableNamed("BarcodeCheckTBL");
    barcodeCheckTBLTable.newIntegerColumn("barcodevalid", false);
    barcodeCheckTBLTable.newDateColumn("validDate", false);
    barcodeCheckTBLTable.newIntegerColumn("id", false);
    barcodeCheckTBLTable.create();
    barcodeCheckTBLTable.setPrimaryKey("id");

    TBEnterpriseMigrationTable barcodeRechnungTBLTable = database.newTableNamed("BarcodeRechnungTBL");
    barcodeRechnungTBLTable.newIntegerColumn("barcode", false);
    barcodeRechnungTBLTable.newIntegerColumn("id", false);
    barcodeRechnungTBLTable.newTimestampColumn("scanned", false);
    barcodeRechnungTBLTable.create();
    barcodeRechnungTBLTable.setPrimaryKey("id");


	}
	
}