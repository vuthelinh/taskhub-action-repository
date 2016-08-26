package com.synergix.globalsetup.inventory.classification.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.util.List;

import com.google.common.base.Strings;
import com.synergix.common.LogWork;
import com.synergix.globalsetup.inventory.classification.pages.InventoryClassPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class InventoryClassSteps extends ScenarioSteps {

	InventoryClassPage classPage;
	
	public void switchToIFrame() {
		classPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		classPage.switchOutDefaultIFrame();
	}

	@Step
	public void click_btn_new() {
		LogWork.log_debug("click_btn_new");
		classPage.clickBtn("New");
		classPage.waitForAllJSCompletes();
	}

	@Step
	public void search_inventory_class(String inventoryClassCode) {
		classPage.click_search_button_on_functional_panel();
		classPage.search(inventoryClassCode);
	}

	@Step
	public void click_btn_delete() {
		classPage.click_btn_delete();
	}

	@Step
	public void click_btn_update() {
		classPage.click_update_button_on_functional_panel();
	}

	@Step
	public void enter_inventory_class_code(String inventoryClassCode) {
		classPage.enter_inventory_class_code(inventoryClassCode);
	}

	@Step
	public void enter_description(String description) {
		classPage.enter_description(description);
	}

	@Step
	public void select_costing_method(String costingMethod) {
		if (!Strings.isNullOrEmpty(costingMethod))
			classPage.select_costing_method(costingMethod);
	}

	@Step
	public void check_company(String cocmpany) {
		classPage.check_company(cocmpany);

	}

	@Step
	public void check_Allcompany() {
		classPage.check_Allcompany();
	}

	@Step
	public void into_Company_tab() {
		classPage.switch_to_tab_company();
	}

	@Step
	public void enter_inventory_glan(String inventoryGlan) {
		classPage.enter_inventory_glan(inventoryGlan);
	}

	@Step
	public void enter_sales_glan(String salesGlan) {
		classPage.enter_sales_glan(salesGlan);
	}

	@Step
	public void enter_costs_of_sales_glan(String costsOfSalesGlan) {
		classPage.enter_costs_of_sales_glan(costsOfSalesGlan);
	}

	@Step
	public void enter_sales_return_glan(String salesReturnGlan) {
		classPage.enter_sales_return_glan(salesReturnGlan);
	}

	@Step
	public void enter_costs_of_sales_return_glan(String costsOfSalesReturnGlan) {
		classPage.enter_costs_of_sales_return_glan(costsOfSalesReturnGlan);
	}

	@Step
	public void enter_costs_of_sales_ret_clearing_glan(
			String costsOfSalesRetClearingGlan) {
		classPage
				.enter_costs_of_sales_ret_clearing_glan(costsOfSalesRetClearingGlan);
	}

	@Step
	public void enter_replacement_holding_glan(String replacementHoldingGlan) {
		classPage.enter_replacement_holding_glan(replacementHoldingGlan);
	}

	@Step
	public void enter_issue_variance_glan(String issueVarianceGlan) {
		classPage.enter_issue_variance_glan(issueVarianceGlan);
	}

	@Step
	public void enter_production_variance_glan(String productionVarianceGlan) {
		classPage.enter_production_variance_glan(productionVarianceGlan);
	}

	@Step
	public void enter_inventory_expense_glan(String inventoryExpenseGlan) {
		classPage.enter_inventory_expense_glan(inventoryExpenseGlan);
	}

	@Step
	public void enter_physical_addition_glan(String physicalAdditionGlan) {
		classPage.enter_physical_addition_glan(physicalAdditionGlan);
	}

	@Step
	public void enter_physical_reduction_glan(String physicalReductionGlan) {
		classPage.enter_physical_reduction_glan(physicalReductionGlan);
	}

	@Step
	public void enter_delivery_clearing_glan(String deliveryClearingGlan) {
		classPage.enter_delivery_clearing_glan(deliveryClearingGlan);
	}

	@Step
	public void enter_work_in_progress_glan(String workInProgressGlan) {
		classPage.enter_work_in_progress_glan(workInProgressGlan);
	}

	@Step
	public void enter_calibration_glan(String calibrationGlan) {
		classPage.enter_calibration_glan(calibrationGlan);
	}

	@Step
	public void enter_scrap_expense_glan(String scrapExpenseGlan) {
		classPage.enter_scrap_expense_glan(scrapExpenseGlan);
	}

	@Step
	public void enter_rework_expense_glan(String reworkExpenseGlan) {
		classPage.enter_rework_expense_glan(reworkExpenseGlan);
	}

	@Step
	public void enter_cost_of_servicing_glan(String costOfServicingGlan) {
		classPage.enter_cost_of_servicing_glan(costOfServicingGlan);
	}

	@Step
	public void verify_inventory_class_code(String inventoryClassCode) {
		assertThat(classPage.get_text_inventory_class_code(),
				equalTo(inventoryClassCode));

	}

	@Step
	public void verify_description(String description) {
		assertThat(classPage.get_text_description(), equalTo(description));
	}

	@Step
	public void verify_costing_method(String costingMethod) {
		assertThat(classPage.get_text_costing_method(), equalTo(costingMethod));
	}

	@Step
	public void verify_inventory_glan(String inventoryGlan) {
		assertThat(classPage.get_text_inventory_glan(), equalTo(inventoryGlan));
	}

	@Step
	public void verify_sales_glan(String salesGlan) {
		assertThat(classPage.get_text_sales_glan(), equalTo(salesGlan));
	}

	@Step
	public void verify_costs_of_sales_glan(String costsOfSalesGlan) {
		assertThat(classPage.get_text_costs_of_sales_glan(),
				equalTo(costsOfSalesGlan));

	}

	@Step
	public void verify_sales_return_glan(String salesReturnGlan) {
		assertThat(classPage.get_text_sales_return_glan(),
				equalTo(salesReturnGlan));
	}

	@Step
	public void verify_costs_of_sales_return_glan(String costsOfSalesReturnGlan) {
		assertThat(classPage.get_text_costs_of_sales_return_glan(),
				equalTo(costsOfSalesReturnGlan));
	}

	@Step
	public void verify_costs_of_sales_ret_clearing_glan(
			String costsOfSalesRetClearingGlan) {
		assertThat(classPage.get_text_costs_of_sales_ret_clearing_glan(),
				equalTo(costsOfSalesRetClearingGlan));
	}

	@Step
	public void verify_replacement_holding_glan(String replacementHoldingGlan) {
		assertThat(classPage.get_text_replacement_holding_glan(),
				equalTo(replacementHoldingGlan));
	}

	@Step
	public void verify_issue_variance_glan(String issueVarianceGlan) {
		assertThat(classPage.get_text_issue_variance_glan(),
				equalTo(issueVarianceGlan));
	}

	@Step
	public void verify_production_variance_glan(String productionVarianceGlan) {
		assertThat(classPage.get_text_production_variance_glan(),
				equalTo(productionVarianceGlan));

	}

	@Step
	public void verify_inventory_expense_glan(String inventoryExpenseGlan) {

		assertThat(classPage.get_text_inventory_expense_glan(),
				equalTo(inventoryExpenseGlan));

	}

	@Step
	public void verify_physical_addition_glan(String physicalAdditionGlan) {
		assertThat(classPage.get_text_physical_addition_glan(),
				equalTo(physicalAdditionGlan));

	}

	@Step
	public void verify_physical_reduction_glan(String physicalReductionGlan) {
		assertThat(classPage.get_text_physical_reduction_glan(),
				equalTo(physicalReductionGlan));

	}

	@Step
	public void verify_delivery_clearing_glan(String deliveryClearingGlan) {
		assertThat(classPage.get_text_delivery_clearing_glan(),
				equalTo(deliveryClearingGlan));
	}

	@Step
	public void verify_work_in_progress_glan(String workInProgressGlan) {
		assertThat(classPage.get_text_work_in_progress_glan(),
				equalTo(workInProgressGlan));
	}

	@Step
	public void verify_scrap_expense_glan(String scrapExpenseGlan) {
		assertThat(classPage.get_text_scrap_expense_glan(),
				equalTo(scrapExpenseGlan));
	}

	public void verify_calibration_glan(String calibrationGlan) {
		assertThat(classPage.get_text_calibration_glan(),
				equalTo(calibrationGlan));

	}

	@Step
	public void verify_rework_expense_glan(String reworkExpenseGlan) {
		assertThat(classPage.get_text_rework_expense_glan(),
				equalTo(reworkExpenseGlan));
	}

	@Step
	public void verify_cost_of_servicing_glan(String costOfServicingGlan) {
		assertThat(classPage.get_text_cost_of_servicing_glan(),
				equalTo(costOfServicingGlan));
		System.out.println("Sucess");
	}

	@Step
	public void into_local_info() {
		classPage.switch_to_tab("Local Info");

	}

	@Step
	public void setSegment(List<String> listSegment) {
		classPage.setSegment(listSegment);
	}

	public void into_gl_account_detail() {
		classPage.switch_to_tab("GL Account Detail");
	}

	@Step
	public void verify_segment(List<String> dataSegment) {
		List<String> configSegment = classPage.listSegment();
		int size = configSegment.size();
		if (size > 1) {
			for (int j = 0; j < size; j++) {
				if (configSegment.get(j).equals("Y"))
					assertThat(classPage.get_text_segment(j + 1),
							equalTo(dataSegment.get(j)));
			}
		}
	}

	@Step
	public void verify_inventory_deleted(String sInventoryClassCode) {
		classPage.click_search_button_on_functional_panel();
		assertThat(classPage.search(sInventoryClassCode), equalTo(false));
	}

	@Step
	public void create_new_inventory_class(String sDescription,
			String sCostingMethod, String sInventoryGlan, String sSalesGlan,
			String sCostsOfSalesGlan, String sSalesReturnGlan,
			String sCostsOfSalesReturnGlan, String sCostsSalesClearingGlan,
			String sReplacementHoldingGlan, String sIssueVarianceGlan,
			String sProductionVarianceGlan, String sInventoryExpenseGlan,
			String sPhysicalAdditionGlan, String sPhysicalReductionGlan,
			String sDeliveryClearingGlan, String sWorkInProgressGlan,
			String sCalibrationGlan, String sScrapExpenseGlan,
			String sReworkExpenseGlan, String sCostOfServicingGlan) {
		enter_description(sDescription);
		select_costing_method(sCostingMethod);
		enter_inventory_glan(sInventoryGlan);
		enter_sales_glan(sSalesGlan);
		enter_costs_of_sales_glan(sCostsOfSalesGlan);
		enter_sales_return_glan(sSalesReturnGlan);
		enter_costs_of_sales_return_glan(sCostsOfSalesReturnGlan);
		enter_costs_of_sales_ret_clearing_glan(sCostsSalesClearingGlan);
		enter_replacement_holding_glan(sReplacementHoldingGlan);
		enter_issue_variance_glan(sIssueVarianceGlan);
		enter_production_variance_glan(sProductionVarianceGlan);
		enter_inventory_expense_glan(sInventoryExpenseGlan);
		enter_physical_addition_glan(sPhysicalAdditionGlan);
		enter_physical_reduction_glan(sPhysicalReductionGlan);
		enter_delivery_clearing_glan(sDeliveryClearingGlan);
		enter_work_in_progress_glan(sWorkInProgressGlan);
		enter_calibration_glan(sCalibrationGlan);
		enter_scrap_expense_glan(sScrapExpenseGlan);
		enter_rework_expense_glan(sReworkExpenseGlan);
		enter_cost_of_servicing_glan(sCostOfServicingGlan);

	}

	public void verify_inventory_class(String sInventoryClassCode,
			String sDescription, String sCostingMethod, String sInventoryGlan,
			String sSalesGlan, String sCostsOfSalesGlan,
			String sSalesReturnGlan, String sCostsOfSalesReturnGlan,
			String sCostsSalesClearingGlan, String sReplacementHoldingGlan,
			String sIssueVarianceGlan, String sProductionVarianceGlan,
			String sInventoryExpenseGlan, String sPhysicalAdditionGlan,
			String sPhysicalReductionGlan, String sDeliveryClearingGlan,
			String sWorkInProgressGlan, String sCalibrationGlan,
			String sScrapExpenseGlan, String sReworkExpenseGlan,
			String sCostOfServicingGlan) {
		verify_inventory_class_code(sInventoryClassCode);
		verify_description(sDescription);
		verify_costing_method(sCostingMethod);
		verify_inventory_glan(sInventoryGlan);
		verify_sales_glan(sSalesGlan);
		verify_costs_of_sales_glan(sCostsOfSalesGlan);
		verify_sales_return_glan(sSalesReturnGlan);
		verify_costs_of_sales_return_glan(sCostsOfSalesReturnGlan);
		verify_costs_of_sales_ret_clearing_glan(sCostsSalesClearingGlan);
		verify_replacement_holding_glan(sReplacementHoldingGlan);
		verify_issue_variance_glan(sIssueVarianceGlan);
		verify_production_variance_glan(sProductionVarianceGlan);
		verify_inventory_expense_glan(sInventoryExpenseGlan);
		verify_physical_addition_glan(sPhysicalAdditionGlan);
		verify_physical_reduction_glan(sPhysicalReductionGlan);
		verify_delivery_clearing_glan(sDeliveryClearingGlan);
		verify_work_in_progress_glan(sWorkInProgressGlan);
		verify_calibration_glan(sCalibrationGlan);
		verify_scrap_expense_glan(sScrapExpenseGlan);
		verify_rework_expense_glan(sReworkExpenseGlan);
		verify_cost_of_servicing_glan(sCostOfServicingGlan);
	}

	@Step
	public String isAlreadyExistsInDatabase(String sInventoryClassCode) {
		return classPage.check_database_exist("MT_INVENTORY_CLASS", "INVENTORY_CLASS_CODE", sInventoryClassCode);
	}
}
