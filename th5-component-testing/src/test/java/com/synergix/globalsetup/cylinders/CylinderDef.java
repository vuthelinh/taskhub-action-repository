package com.synergix.globalsetup.cylinders;

import java.util.LinkedHashMap;
import java.util.List;

import com.synergix.globalsetup.cylinders.steps.CylinderBrandSteps;
import com.synergix.globalsetup.cylinders.steps.CylinderCapacitySteps;
import com.synergix.globalsetup.cylinders.steps.CylinderInterchangeableGroupSteps;
import com.synergix.globalsetup.cylinders.steps.CylinderSteps;
import com.synergix.globalsetup.cylinders.steps.StallTypeSteps;
import com.synergix.globalsetup.inventory.steps.InventorySteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CylinderDef {

	private static final String ATTACHMENTS_FILE = "AttachmentsFileCylinder";

	private static final String CYL_CHANG_GROUP = "CylinderInterchangeableGroup";

	private static final String CYLINDER_CAPACITY = "Cylinder Capacity";

	private static final String CYLINDER_BRAND = "Cylinder Brand";

	private static final String STALLTYPE = "Stall Type";

	@Steps
	StallTypeSteps stallTypeSteps;

	@Steps
	CylinderBrandSteps cylinderBrandSteps;

	@Steps
	CylinderCapacitySteps cylinderCapacitySteps;

	@Steps
	CylinderInterchangeableGroupSteps cylinderInterchangeableGroupSteps;

	@Steps
	CylinderSteps cylinderSteps;

	@Steps
	InventorySteps inventorySteps;

	@When("^user create cylinder as \"([^\"]*)\"$")
	public void user_create_cylinder_as(String dataKey, List<List<String>> dataTable) {

		SessionData.addDataTable("Cylinder", dataTable, false);

		for (int row : SessionData.getDataTbRowsByValEqualInCol("Cylinder", "KEY", dataKey).keySet()) {

			String sCylinderCode = SessionData.getDataTbVal("Cylinder", row, "Cylinder Code");
			String sDescription = SessionData.getDataTbVal("Cylinder", row, "Description");
			String sCylinderBrandCode = SessionData.getDataTbVal("Cylinder", row, "Cylinder Brand Code");
			String sCylinderCapacityCode = SessionData.getDataTbVal("Cylinder", row, "Cylinder Capacity Code");
			String sFilledInventoryCode = SessionData.getDataTbVal("Cylinder", row, "Filled Inventory Code");
			String sEmptyInventoryCode = SessionData.getDataTbVal("Cylinder", row, "Empty Inventory Code");
			String sSerialNoTracking = SessionData.getDataTbVal("Cylinder", row, "Serial No. Tracking");
			String sForProductionSales = SessionData.getDataTbVal("Cylinder", row, "For Production / Sales");
			String sProductionCategoryNo = SessionData.getDataTbVal("Cylinder", row, "Production Category No");
			String sOrderSequence = SessionData.getDataTbVal("Cylinder", row, "Order Sequence");

			cylinderSteps.addcylinder();

			cylinderSteps.enter_cylinder_code(sCylinderCode);
			cylinderSteps.enter_description(sDescription);
			cylinderSteps.enter_cylinder_brand_code(sCylinderBrandCode);
			cylinderSteps.enter_cylinder_capacity_code(sCylinderCapacityCode);
			cylinderSteps.enter_filled_inventory_code(sFilledInventoryCode);
			cylinderSteps.enter_empty_inventory_code(sEmptyInventoryCode);
			cylinderSteps.select_serial_no_tracking(sSerialNoTracking);
			cylinderSteps.select_for_production_or_sales(sForProductionSales);
			cylinderSteps.enter_production_category_no(sProductionCategoryNo);
			cylinderSteps.enter_order_sequence(sOrderSequence);
			cylinderSteps.verify_cylinder_is_created(sCylinderCode, sDescription, sCylinderBrandCode,
					sCylinderCapacityCode, sFilledInventoryCode, sEmptyInventoryCode, sSerialNoTracking,
					sForProductionSales, sProductionCategoryNo, sOrderSequence);

		}
	}

	@When("^Cylinder added Attachments file as \"([^\"]*)\"$")
	public void Cylinder_added_Attachments_file_as(String dataKey, List<List<String>> dataTable) {

		SessionData.addDataTable(ATTACHMENTS_FILE, dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol(ATTACHMENTS_FILE, "KEY", dataKey).keySet()) {
			String sFileName = SessionData.getDataTbVal(ATTACHMENTS_FILE, row, "File Name");
			String sFileDescription = SessionData.getDataTbVal(ATTACHMENTS_FILE, row, "File Description");

			if (!sFileName.isEmpty()) {
				cylinderSteps.add_attachment_file();
				cylinderSteps.upload_file();
				cylinderSteps.enter_file_description(sFileDescription, 1);
			}
		}
	}

	@When("^user update cylinder as \"([^\"]*)\"$")
	public void user_update_cylinder_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("Cylinder", dataTable, false);

		for (int row : SessionData.getDataTbRowsByValEqualInCol("Cylinder", "KEY", dataKey).keySet()) {

			String sCylinderCode = SessionData.getDataTbVal("Cylinder", row, "Cylinder Code");
			String sDescription = SessionData.getDataTbVal("Cylinder", row, "Description");
			String sCylinderBrandCode = SessionData.getDataTbVal("Cylinder", row, "Cylinder Brand Code");
			String sCylinderCapacityCode = SessionData.getDataTbVal("Cylinder", row, "Cylinder Capacity Code");
			String sFilledInventoryCode = SessionData.getDataTbVal("Cylinder", row, "Filled Inventory Code");
			String sEmptyInventoryCode = SessionData.getDataTbVal("Cylinder", row, "Empty Inventory Code");
			String sSerialNoTracking = SessionData.getDataTbVal("Cylinder", row, "Serial No. Tracking");
			String sForProductionSales = SessionData.getDataTbVal("Cylinder", row, "For Production / Sales");
			String sProductionCategoryNo = SessionData.getDataTbVal("Cylinder", row, "Production Category No");
			String sOrderSequence = SessionData.getDataTbVal("Cylinder", row, "Order Sequence");

			cylinderSteps.addcylinder();

			cylinderSteps.search(sCylinderCode);
			cylinderSteps.enter_description(sDescription);
			cylinderSteps.enter_cylinder_brand_code(sCylinderBrandCode);
			cylinderSteps.enter_cylinder_capacity_code(sCylinderCapacityCode);
			cylinderSteps.enter_filled_inventory_code(sFilledInventoryCode);
			cylinderSteps.enter_empty_inventory_code(sEmptyInventoryCode);
			cylinderSteps.select_serial_no_tracking(sSerialNoTracking);
			cylinderSteps.select_for_production_or_sales(sForProductionSales);
			cylinderSteps.enter_production_category_no(sProductionCategoryNo);
			cylinderSteps.enter_order_sequence(sOrderSequence);

			cylinderSteps.clickUpdatebtn();
		}
	}

	@When("^user delete cylinder as \"([^\"]*)\"$")
	public void user_delete_cylinder_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("Cylinder", dataTable, false);

		for (int row : SessionData.getDataTbRowsByValEqualInCol("Cylinder", "KEY", dataKey).keySet()) {
			String sCylinderCode = SessionData.getDataTbVal("Cylinder", row, "Cylinder Code");

			cylinderSteps.addcylinder();
			cylinderSteps.search(sCylinderCode);
			cylinderSteps.deleteCylinder();
			
			cylinderSteps.verify_cylinder_is_deleted(sCylinderCode);
		}
	}

	// Cylinder Interchangeable Group
	@When("^user create cylinder interchangeable group as \"([^\"]*)\"$")
	public void user_create_cylinder_interchangeable_group_as(String dataKey, List<List<String>> dataTable) {

		SessionData.addDataTable(CYL_CHANG_GROUP, dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol(CYL_CHANG_GROUP, "KEY", dataKey).keySet()) {
			String sChangeGroupCode = SessionData.getDataTbVal(CYL_CHANG_GROUP, row, "Interchangeable Group Code");
			if (cylinderInterchangeableGroupSteps.isAlreadyExistsInDatabase(sChangeGroupCode).isEmpty()) {
				String sDescription = SessionData.getDataTbVal(CYL_CHANG_GROUP, row, "Description");
				String sEnableDRP = SessionData.getDataTbVal(CYL_CHANG_GROUP, row,
						"Enable Deposit / Refund / Purchase");
				String sDepositAmount = SessionData.getDataTbVal(CYL_CHANG_GROUP, row, "Unit Deposit Amount");
				String sefundAmount = SessionData.getDataTbVal(CYL_CHANG_GROUP, row, "Unit Refund Amount");
				String sPurchaseAmount = SessionData.getDataTbVal(CYL_CHANG_GROUP, row, "Unit Purchase Amount");

				cylinderInterchangeableGroupSteps.create_cylinder_interchangeable_group(sChangeGroupCode, sDescription,
						sEnableDRP, sDepositAmount, sefundAmount, sPurchaseAmount);

				cylinderInterchangeableGroupSteps.verify_cylinder_interchangeable_group_is_updated(sChangeGroupCode,
						sDescription, sEnableDRP, sDepositAmount, sefundAmount, sPurchaseAmount);
			}
		}
	}

	@When("^user delete cylinder interchangeable group as \"([^\"]*)\"$")
	public void user_delete_cylinder_interchangeable_group_as(String dataKey, List<List<String>> dataTable) {

		for (int row : SessionData.getDataTbRowsByValEqualInCol(CYL_CHANG_GROUP, "KEY", dataKey).keySet()) {
			String sChangeGroupCode = SessionData.getDataTbVal(CYL_CHANG_GROUP, row, "Interchangeable Group Code");

			cylinderInterchangeableGroupSteps.searchCylinderInterchangeableGroup(sChangeGroupCode);
			cylinderInterchangeableGroupSteps.delete();

			cylinderInterchangeableGroupSteps.verfiy_cylinder_interchangeable_group_is_deleted(sChangeGroupCode);
		}
	}

	@When("^user create cylinder Capacity as \"([^\"]*)\"$")
	public void user_create_cylinder_Capacity_as(String dataKey, List<List<String>> dataTable) {

		SessionData.addDataTable(CYLINDER_CAPACITY, dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol(CYLINDER_CAPACITY, "KEY", dataKey).keySet()) {
			String sCylinderCapacityCode = SessionData.getDataTbVal(CYLINDER_CAPACITY, row, "Cylinder Capacity Code");
			if (cylinderCapacitySteps.isAlreadyExistsInDatabase(sCylinderCapacityCode).isEmpty()) {
				String sDescription = SessionData.getDataTbVal(CYLINDER_CAPACITY, row, "Description");
				String sCylinderCapacity = SessionData.getDataTbVal(CYLINDER_CAPACITY, row, "Cylinder Capacity");
				String sInterchangeableGroupCode = SessionData.getDataTbVal(CYLINDER_CAPACITY, row,
						"Interchangeable Group Code");

				cylinderCapacitySteps.addCylinderCapacity();

				cylinderCapacitySteps.enter_cylinder_capacity_code(sCylinderCapacityCode);
				cylinderCapacitySteps.enter_description(sDescription);
				cylinderCapacitySteps.enter_cylinder_capacity(sCylinderCapacity);
				cylinderCapacitySteps.enter_interchangeable_group_code(sInterchangeableGroupCode);

				cylinderCapacitySteps.clickUpdatebtn();

				cylinderCapacitySteps.verify_cylinder_capacity(sCylinderCapacityCode, sDescription, sCylinderCapacity,
						sInterchangeableGroupCode);
			}
		}
	}

	@When("^user delete cylinder Capacity as \"([^\"]*)\"$")
	public void user_delete_cylinder_Capacity_as(String dataKey, List<List<String>> dataTable) {

		for (int row : SessionData.getDataTbRowsByValEqualInCol(CYLINDER_CAPACITY, "KEY", dataKey).keySet()) {
			String sCylinderCapacityCode = SessionData.getDataTbVal(CYLINDER_CAPACITY, row, "Cylinder Capacity Code");

			cylinderCapacitySteps.addCylinderCapacity();
			cylinderCapacitySteps.searchCylinderCapacity(sCylinderCapacityCode);
			cylinderCapacitySteps.deleteCylinderCapacity();

			cylinderCapacitySteps.verify_cylinder_capacity_is_deleted(sCylinderCapacityCode);
		}
	}

	@When("^user create cylinder brand as \"([^\"]*)\"$")
	public void user_create_cylinder_brand_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable(CYLINDER_BRAND, dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol(CYLINDER_BRAND, "KEY", dataKey).keySet()) {

			String sCylinderBrandCode = SessionData.getDataTbVal(CYLINDER_BRAND, row, "Cylinder Brand Code");
			if (cylinderBrandSteps.isAlreadyExistsInDatabase(sCylinderBrandCode).isEmpty()) {
				String sDescription = SessionData.getDataTbVal(CYLINDER_BRAND, row, "Description");

				cylinderBrandSteps.addCylinderBrand();

				cylinderBrandSteps.enter_cylinder_brand_code(sCylinderBrandCode);
				cylinderBrandSteps.enter_description(sDescription);
				cylinderBrandSteps.update();
				cylinderBrandSteps.addCylinderBrand();
				cylinderBrandSteps.verify_clyinder_branch_is_created(sCylinderBrandCode, sDescription);
			}
		}
	}

	@When("^user delete cylinder brand as \"([^\"]*)\"$")
	public void user_delete_cylinder_brand_as(String dataKey, List<List<String>> dataTable) {
		for (int row : SessionData.getDataTbRowsByValEqualInCol(CYLINDER_BRAND, "KEY", dataKey).keySet()) {

			String sCylinderBrandCode = SessionData.getDataTbVal(CYLINDER_BRAND, row, "Cylinder Brand Code");

			cylinderBrandSteps.addCylinderBrand();

			cylinderBrandSteps.searchCylinderBrand(sCylinderBrandCode);
			cylinderBrandSteps.delete();
			cylinderBrandSteps.verify_cylinder_brand_is_deleted(sCylinderBrandCode);
		}
	}

	@When("^user create stall type as \"([^\"]*)\"$")
	public void user_create_stall_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable(STALLTYPE, dataTable, false);
		for (int row : SessionData.getDataTbRowsByValEqualInCol(STALLTYPE, "KEY", dataKey).keySet()) {

			String sStallTypeCode = SessionData.getDataTbVal(STALLTYPE, row, "Stall Type Code");
			String sDescription = SessionData.getDataTbVal(STALLTYPE, row, "Description");

			stallTypeSteps.click_add_new_stall_type();

			stallTypeSteps.enter_stall_type_code(sStallTypeCode);
			stallTypeSteps.enter_description(sDescription);
			stallTypeSteps.click_on_update();

			stallTypeSteps.verify_stall_type(sStallTypeCode, sDescription);
		}
	}

	@When("^user delete stall type as \"([^\"]*)\"$")
	public void user_delete_stall_type_as(String dataKey, List<List<String>> dataTable) {

		for (int row : SessionData.getDataTbRowsByValEqualInCol(STALLTYPE, "KEY", dataKey).keySet()) {

			String sStallTypeCode = SessionData.getDataTbVal(STALLTYPE, row, "Stall Type Code");

			stallTypeSteps.click_add_new_stall_type();
			stallTypeSteps.search_stall_type(sStallTypeCode);
			stallTypeSteps.delete_stall_type();
			stallTypeSteps.verify_deleted(sStallTypeCode);
		}
	}

	@When("^user creates inventory that is used for Cylinder as \"([^\"]*)\"$")
	public void user_creates_inventory_that_is_used_for_cylinder_as(String dataKey, List<List<String>> dataTable) {
		String _keyDataTableName = "Inventory";
		SessionData.addDataTable(_keyDataTableName, dataTable);

		LinkedHashMap<Integer, List<String>> testData = new LinkedHashMap<>();

		testData = SessionData.getDataTbRowsByValEqualInCol(_keyDataTableName, "KEY", dataKey);

		for (int row : testData.keySet()) {

			String sInventoryCode = SessionData.getDataTbVal(_keyDataTableName, row, "Inventory Code");
			if (inventorySteps.isAlreadyExistsInDatabase(sInventoryCode).isEmpty()) {
				String sDescription = SessionData.getDataTbVal(_keyDataTableName, row, "Description");
				String sBaseUom = SessionData.getDataTbVal(_keyDataTableName, row, "Base UOM");
				String sInventoryClass = SessionData.getDataTbVal(_keyDataTableName, row, "Inventory Class");

				inventorySteps.enter_inventory_code(sInventoryCode);
				inventorySteps.enter_description(sDescription);
				inventorySteps.enter_base_uom(sBaseUom);
				inventorySteps.enter_inventory_class(sInventoryClass);
				inventorySteps.update();

			}
		}
	}
}
