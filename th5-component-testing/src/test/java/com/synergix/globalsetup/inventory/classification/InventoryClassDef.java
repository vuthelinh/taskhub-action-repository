package com.synergix.globalsetup.inventory.classification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.thucydides.core.annotations.Steps;
import com.synergix.globalsetup.inventory.classification.steps.InventoryClassSteps;
import com.synergix.utilities.SessionData;
import cucumber.api.java.en.When;

public class InventoryClassDef {
	private static final String CLASS_TABLE = "CLASS TABLE";
	private static final String CLASS_TABLE_DELETE = "TABLE DELETE";

	@Steps
	InventoryClassSteps classSteps;

	@When("^user create a new inventory class as \"([^\"]*)\"$")
	public void user_create_a_new_class_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable(CLASS_TABLE, dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol(CLASS_TABLE, "KEY", dataKey).keySet()) {

			String sInventoryClassCode = SessionData.getDataTbVal(CLASS_TABLE, row, "Inventory Class Code");
			if (classSteps.isAlreadyExistsInDatabase(sInventoryClassCode).isEmpty()) {
				String sDescription = SessionData.getDataTbVal(CLASS_TABLE, row, "Description");
				String sCostingMethod = SessionData.getDataTbVal(CLASS_TABLE, row, "Costing Method");
				String sInventoryGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Inventory GLAN");
				String sSalesGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Sales GLAN");
				String sCostsOfSalesGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Costs of Sales GLAN");
				String sSalesReturnGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Sales Return GLAN");
				String sCostsOfSalesReturnGlan = SessionData.getDataTbVal(CLASS_TABLE, row,
						"Costs of Sales Return GLAN");
				String sCostsSalesClearingGlan = SessionData.getDataTbVal(CLASS_TABLE, row,
						"Costs of Sales Ret Clearing GLAN");
				String sReplacementHoldingGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Replacement Holding GLAN");
				String sIssueVarianceGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Issue Variance GLAN");
				String sProductionVarianceGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Production Variance GLAN");
				String sInventoryExpenseGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Inventory Expense GLAN");
				String sPhysicalAdditionGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Physical Addition GLAN");
				String sPhysicalReductionGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Physical Reduction GLAN");
				String sDeliveryClearingGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Delivery Clearing GLAN");
				String sWorkInProgressGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Work in Progress GLAN");
				String sCalibrationGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Calibration GLAN");
				String sScrapExpenseGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Scrap Expense GLAN");
				String sReworkExpenseGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Rework Expense GLAN");
				String sCostOfServicingGlan = SessionData.getDataTbVal(CLASS_TABLE, row, "Cost of Servicing GLAN");
				String segment1 = SessionData.getDataTbVal(CLASS_TABLE, row, "Seg1");
				String segment2 = SessionData.getDataTbVal(CLASS_TABLE, row, "Seg2");
				String segment3 = SessionData.getDataTbVal(CLASS_TABLE, row, "Seg3");
				String segment4 = SessionData.getDataTbVal(CLASS_TABLE, row, "Seg4");

				classSteps.click_btn_new();

				classSteps.enter_inventory_class_code(sInventoryClassCode);
				classSteps.create_new_inventory_class(sDescription, sCostingMethod, sInventoryGlan, sSalesGlan,
						sCostsOfSalesGlan, sSalesReturnGlan, sCostsOfSalesReturnGlan, sCostsSalesClearingGlan,
						sReplacementHoldingGlan, sIssueVarianceGlan, sProductionVarianceGlan, sInventoryExpenseGlan,
						sPhysicalAdditionGlan, sPhysicalReductionGlan, sDeliveryClearingGlan, sWorkInProgressGlan,
						sCalibrationGlan, sScrapExpenseGlan, sReworkExpenseGlan, sCostOfServicingGlan);

				classSteps.click_btn_update();

				classSteps.verify_inventory_class(sInventoryClassCode, sDescription, sCostingMethod, sInventoryGlan,
						sSalesGlan, sCostsOfSalesGlan, sSalesReturnGlan, sCostsOfSalesReturnGlan,
						sCostsSalesClearingGlan, sReplacementHoldingGlan, sIssueVarianceGlan, sProductionVarianceGlan,
						sInventoryExpenseGlan, sPhysicalAdditionGlan, sPhysicalReductionGlan, sDeliveryClearingGlan,
						sWorkInProgressGlan, sCalibrationGlan, sScrapExpenseGlan, sReworkExpenseGlan,
						sCostOfServicingGlan);

				classSteps.into_local_info();
				List<String> listSegment = new ArrayList<>();
				listSegment.addAll(Arrays.asList(segment1, segment2, segment3, segment4));
				classSteps.setSegment(listSegment);
				classSteps.click_btn_update();
				classSteps.into_local_info();
				classSteps.verify_segment(listSegment);
				classSteps.click_btn_update();
			}
		}

	}

	@When("^user delete class as \"([^\"]*)\"$")
	public void user_delete_class_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable(CLASS_TABLE_DELETE, dataTable);
		for (int row : SessionData.getDataTbRowsByValEqualInCol(CLASS_TABLE_DELETE, "KEY", dataKey).keySet()) {
			String sInventoryClassCode = SessionData.getDataTbVal(CLASS_TABLE_DELETE, row, "Inventory Class Code");
			classSteps.search_inventory_class(sInventoryClassCode);
			classSteps.click_btn_delete();
			classSteps.verify_inventory_deleted(sInventoryClassCode);

		}
	}

}