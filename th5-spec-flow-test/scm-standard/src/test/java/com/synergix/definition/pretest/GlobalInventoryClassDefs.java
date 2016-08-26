package com.synergix.definition.pretest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.synergix.globalsetup.inventory.classification.steps.ClassSteps;
import com.synergix.utilities.SessionData;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

public class GlobalInventoryClassDefs {

	@Steps
	ClassSteps glInvClassSteps;

	@Then("^user maintains Global Inventory Class as \"([^\"]*)\"$")
	public void user_maintains_Global_Inventory_Class_as(String dataKey, List<List<String>> dataTable) {
		SessionData.addDataTable("MT_GLOBAL_INVENTORY_CLASS", dataTable, false);
		String sTemp = "";
		for (int row : SessionData.getDataTbRowsByValEqualInCol("MT_GLOBAL_INVENTORY_CLASS", "KEY", dataKey).keySet()) {
			String sInventoryClassCode = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row,
					"Inventory Class Code");
			String sNextInventoryClassCode = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row + 1,
					"Inventory Class Code");
			String sCompanyName = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row, "Company Name");
			String sDescription = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row, "Description");
			String sCostingMethod = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row, "Costing Method");
			String sInventoryGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row, "Inventory GLAN");
			String sInventoryExpenseGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row,
					"Inventory Expense GLAN");
			String sSalesGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row, "Sales GLAN");
			String sPhysicalAdditionGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row,
					"Physical Addition GLAN");
			String sCostsOfSalesGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row,
					"Costs of Sales GLAN");
			String sPhysicalReductionGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row,
					"Physical Reduction GLAN");
			String sSalesReturnGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row, "Sales Return GLAN");
			String sDeliveryClearingGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row,
					"Delivery Clearing GLAN");
			String sCostsOfSalesReturnGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row,
					"Costs of Sales Return GLAN");
			String sWorkInProgressGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row,
					"Work in Progress GLAN");
			String sCostsOfSalesRetClearingGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row,
					"Costs of Sales Ret Clearing GLAN");
			String sCalibrationGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row, "Calibration GLAN");
			String sReplacementHoldingGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row,
					"Replacement Holding GLAN");
			String sScrapExpenseGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row, "Scrap Expense GLAN");
			String sIssueVarianceGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row,
					"Issue Variance GLAN");
			String sReworkExpenseGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row,
					"Rework Expense GLAN");
			String sProductionVarianceGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row,
					"Production Variance GLAN");
			String sCostOfServicingGlan = SessionData.getDataTbVal("MT_GLOBAL_INVENTORY_CLASS", row,
					"Cost of Servicing GLAN");
			
			boolean inventoryClassExist = false;
			glInvClassSteps.switch_to_tab_gl_account_detail();
			if (!sInventoryClassCode.isEmpty()) {
				if (!sInventoryClassCode.equals(sTemp)) {
					glInvClassSteps.click_btn_new();
					if (!glInvClassSteps.enter_inventory_class_code(sInventoryClassCode).isEmpty()) {
						assertThat(glInvClassSteps.search_inventory_class_code(sInventoryClassCode)).isTrue();
						//If assertion gives fail, inventoryClassExist will not be set to true
						inventoryClassExist = true;
					}
				}
				sTemp = sInventoryClassCode;
			} else {
				continue;
			}
			
			if (!inventoryClassExist){
				if (!sCostingMethod.isEmpty()) {
					glInvClassSteps.enter_inventory_class_code(sInventoryClassCode);
				}
				glInvClassSteps.select_costing_method(sCostingMethod);
			}
			
			if (!sCostingMethod.isEmpty())
				glInvClassSteps.enter_description(sDescription);						
			if (!sInventoryGlan.isEmpty())
				glInvClassSteps.enter_detail_inv_glan(sInventoryGlan);
			if (!sInventoryExpenseGlan.isEmpty())
				glInvClassSteps.enter_detail_inv_expense_glan(sInventoryExpenseGlan);
			if (!sSalesGlan.isEmpty())
				glInvClassSteps.enter_detail_sales_glan(sSalesGlan);
			if (!sPhysicalAdditionGlan.isEmpty())
				glInvClassSteps.enter_detail_physical_addition_glan(sPhysicalAdditionGlan);
			if (!sCostsOfSalesGlan.isEmpty())
				glInvClassSteps.enter_detail_costs_of_sales_glan(sCostsOfSalesGlan);
			if (!sPhysicalReductionGlan.isEmpty())
				glInvClassSteps.enter_detail_physical_reduction_glan(sPhysicalReductionGlan);
			if (!sSalesReturnGlan.isEmpty())
				glInvClassSteps.enter_detail_sales_return_glan(sSalesReturnGlan);
			if (!sDeliveryClearingGlan.isEmpty())
				glInvClassSteps.enter_detail_delivery_clearing_glan(sDeliveryClearingGlan);
			if (!sCostsOfSalesReturnGlan.isEmpty())
				glInvClassSteps.enter_detail_costs_of_sales_return_glan(sCostsOfSalesReturnGlan);
			if (!sWorkInProgressGlan.isEmpty())
				glInvClassSteps.enter_detail_work_in_progress_glan(sWorkInProgressGlan);
			if (!sCostsOfSalesRetClearingGlan.isEmpty())
				glInvClassSteps.enter_detail_costs_of_sales_ret_clearing_glan(sCostsOfSalesRetClearingGlan);
			if (!sCalibrationGlan.isEmpty())
				glInvClassSteps.enter_detail_calibration_glan(sCalibrationGlan);
			if (!sReplacementHoldingGlan.isEmpty())
				glInvClassSteps.enter_detail__replacement_holding_glan(sReplacementHoldingGlan);
			if (!sScrapExpenseGlan.isEmpty())
				glInvClassSteps.enter_detail_scrap_expense_glan(sScrapExpenseGlan);
			if (!sIssueVarianceGlan.isEmpty())
				glInvClassSteps.enter_detail_issue_variance_glan(sIssueVarianceGlan);
			if (!sReworkExpenseGlan.isEmpty())
				glInvClassSteps.enter_detail_rework_expense_glan(sReworkExpenseGlan);
			if (!sProductionVarianceGlan.isEmpty())
				glInvClassSteps.enter_detail_production_variance_glan(sProductionVarianceGlan);
			if (!sCostOfServicingGlan.isEmpty())
				glInvClassSteps.enter_detail_cost_of_servicing_glan(sCostOfServicingGlan);
			// tag company
			if (!sCompanyName.isEmpty()) {
				glInvClassSteps.switch_to_tab_company();
				glInvClassSteps.tag_company_name(sCompanyName);
			}
			if (!sInventoryClassCode.equals(sNextInventoryClassCode)) {
				glInvClassSteps.update();
			}
		}

	}

}
