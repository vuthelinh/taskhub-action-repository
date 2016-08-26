package com.synergix.globalsetup.inventory.classification.steps;

import com.synergix.globalsetup.inventory.classification.pages.ClassPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160121
 */
public class ClassSteps extends ScenarioSteps {
	ClassPage classPage;

	@Step
	public void click_btn_new() {
		classPage.click_btn_new();
	}

	@Step
	public String enter_inventory_class_code(String _inventoryClassCode) {
		String ret = classPage.enter_inventory_class_code(_inventoryClassCode);
		if (!ret.isEmpty()) {
			ret = classPage.getErrorMessagesThenClickOK();
		}
		return ret;
	}

	@Step
	public boolean search_inventory_class_code(String _inventoryClassCode) {
		return classPage.search_inventory_class_code(_inventoryClassCode);
	}

	@Step
	public void enter_description(String _description) {
		classPage.enter_description(_description);
	}

	@Step
	public void select_costing_method(String _costingMethod) {
		classPage.select_costing_method(_costingMethod);
	}

	@Step
	public void tag_company_name(String _companyName) {
		classPage.chooseCompany(_companyName);
	}

	@Step
	public void switch_to_tab_gl_account_detail() {
		classPage.switch_to_tab_gl_account_detail();
	}

	@Step
	public void switch_to_tab_company() {
		classPage.switch_to_tab_company();
	}

	@Step
	public void enter_detail_inv_glan(String _invGLAN) {
		classPage.enter_gl_account_detail("Inventory GLAN", _invGLAN);
	}

	@Step
	public void enter_detail_inv_expense_glan(String _invExpenseGLAN) {
		classPage.enter_gl_account_detail("Inventory Expense GLAN", _invExpenseGLAN);
	}

	@Step
	public void enter_detail_sales_glan(String _salesGLAN) {
		classPage.enter_gl_account_detail("Sales GLAN", _salesGLAN);
	}

	@Step
	public void enter_detail_physical_addition_glan(String _physicalAdditionGLAN) {
		classPage.enter_gl_account_detail("Physical Addition GLAN", _physicalAdditionGLAN);
	}

	@Step
	public void enter_detail_costs_of_sales_glan(String _costsOfSalesGLAN) {
		classPage.enter_gl_account_detail("Costs of Sales GLAN", _costsOfSalesGLAN);
	}

	@Step
	public void enter_detail_physical_reduction_glan(String _physicalReductionGLAN) {
		classPage.enter_gl_account_detail("Physical Reduction GLAN", _physicalReductionGLAN);
	}

	@Step
	public void enter_detail_sales_return_glan(String _salesReturnGLAN) {
		classPage.enter_gl_account_detail("Sales Return GLAN", _salesReturnGLAN);
	}

	@Step
	public void enter_detail_delivery_clearing_glan(String _deliveryClearingGLAN) {
		classPage.enter_gl_account_detail("Delivery Clearing GLAN", _deliveryClearingGLAN);
	}

	@Step
	public void enter_detail_costs_of_sales_return_glan(String _CostsOfSalesReturnGLAN) {
		classPage.enter_gl_account_detail("Costs of Sales Return GLAN", _CostsOfSalesReturnGLAN);
	}

	@Step
	public void enter_detail_work_in_progress_glan(String _WorkInProgressGLAN) {
		classPage.enter_gl_account_detail("Work in Progress GLAN", _WorkInProgressGLAN);
	}

	@Step
	public void enter_detail_costs_of_sales_ret_clearing_glan(String _costsOfSalesRetClearingGLAN) {
		classPage.enter_gl_account_detail("Costs of Sales Ret Clearing GLAN",
				_costsOfSalesRetClearingGLAN);
	}

	@Step
	public void enter_detail_calibration_glan(String _calibrationGLAN) {
		classPage.enter_gl_account_detail("Calibration GLAN", _calibrationGLAN);
	}

	@Step
	public void enter_detail__replacement_holding_glan(String _replacementHoldingGLAN) {
		classPage.enter_gl_account_detail("Replacement Holding GLAN", _replacementHoldingGLAN);
	}

	@Step
	public void enter_detail_scrap_expense_glan(String _scrapExpenseGLAN) {
		classPage.enter_gl_account_detail("Scrap Expense GLAN", _scrapExpenseGLAN);
	}

	@Step
	public void enter_detail_issue_variance_glan(String _issueVarianceGLAN) {
		classPage.enter_gl_account_detail("Issue Variance GLAN", _issueVarianceGLAN);
	}

	@Step
	public void enter_detail_rework_expense_glan(String _ReworkExpenseGLAN) {
		classPage.enter_gl_account_detail("Rework Expense GLAN", _ReworkExpenseGLAN);
	}

	@Step
	public void enter_detail_production_variance_glan(String _productionVarianceGLAN) {
		classPage.enter_gl_account_detail("Production Variance GLAN", _productionVarianceGLAN);
	}

	@Step
	public void enter_detail_cost_of_servicing_glan(String _CostOfServicingGLAN) {
		classPage.enter_gl_account_detail("Cost of Servicing GLAN", _CostOfServicingGLAN);
	}

	@Step
	public void update() {
		classPage.click_btn_update();
	}
}
