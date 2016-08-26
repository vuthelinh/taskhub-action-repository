package com.synergix.globalsetup.inventory.classification.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class InventoryClassPage extends TH5PageObject{

	public InventoryClassPage (WebDriver driver) {
		    super(driver);
	}

	private static final String COSTING_METHOD = "Costing Method";
	private static final String DESCRIPTION = "Description";
	private static final String INVENTORY_CLASS_CODE = "Inventory Class Code";
	private static final String COST_OF_SERVICING_GLAN = "Cost of Servicing GLAN";
	private static final String REWORK_EXPENSE_GLAN = "Rework Expense GLAN";
	private static final String SCRAP_EXPENSE_GLAN = "Scrap Expense GLAN";
	private static final String CALIBRATION_GLAN = "Calibration GLAN";
	private static final String WORK_IN_PROGRESS_GLAN = "Work in Progress GLAN";
	private static final String DELIVERY_CLEARING_GLAN = "Delivery Clearing GLAN";
	private static final String PHYSICAL_REDUCTION_GLAN = "Physical Reduction GLAN";
	private static final String PHYSICAL_ADDITION_GLAN = "Physical Addition GLAN";
	private static final String INVENTORY_EXPENSE_GLAN = "Inventory Expense GLAN";
	private static final String PRODUCTION_VARIANCE_GLAN = "Production Variance GLAN";
	private static final String ISSUE_VARIANCE_GLAN = "Issue Variance GLAN";
	private static final String REPLACEMENT_HOLDING_GLAN = "Replacement Holding GLAN";
	private static final String COSTS_OF_SALES_RET_CLEARING_GLAN = "Costs of Sales Ret Clearing GLAN";
	private static final String COSTS_OF_SALES_RETURN_GLAN = "Costs of Sales Return GLAN";
	private static final String SALES_RETURN_GLAN = "Sales Return GLAN";
	private static final String COSTS_OF_SALES_GLAN = "Costs of Sales GLAN";
	private static final String INVENTORY_GLAN = "Inventory GLAN";
	private static final String SALES_GLAN = "Sales GLAN";

	public void click_btn_delete() {
		click_delete_button_on_functional_panel();
	}

	public void enter_inventory_class_code(String inventoryClassCode) {
		enterInputFieldCodeWithLabel(INVENTORY_CLASS_CODE, inventoryClassCode);
	}

	public void enter_description(String description) {
		enterInputFieldWithLabel(DESCRIPTION, description);
	}

	public void select_costing_method(String costingMethod) {
		selectRadioButton(COSTING_METHOD, costingMethod);
	}

	public void check_company(String cocmpany) {
		chooseCompany(cocmpany);
	}

	public void check_Allcompany() {
		chooseAllCompany();
	}

	public void enter_inventory_glan(String inventoryGlan) {
		enterInputFieldCodeWithLabel(INVENTORY_GLAN, inventoryGlan);
	}

	public void enter_sales_glan(String salesGlan) {
		enterInputFieldCodeWithLabel(SALES_GLAN, salesGlan);
	}

	public void enter_costs_of_sales_glan(String costsOfSalesGlan) {
		enterInputFieldCodeWithLabel(COSTS_OF_SALES_GLAN, costsOfSalesGlan);
	}

	public void enter_sales_return_glan(String salesReturnGlan) {
		enterInputFieldCodeWithLabel(SALES_RETURN_GLAN, salesReturnGlan);
	}

	public void enter_costs_of_sales_return_glan(String costsOfSalesReturnGlan) {
		enterInputFieldCodeWithLabel(COSTS_OF_SALES_RETURN_GLAN,
				costsOfSalesReturnGlan);
	}

	public void enter_costs_of_sales_ret_clearing_glan(
			String costsOfSalesRetClearingGlan) {
		enterInputFieldCodeWithLabel(COSTS_OF_SALES_RET_CLEARING_GLAN,
				costsOfSalesRetClearingGlan);
	}

	public void enter_replacement_holding_glan(String replacementHoldingGlan) {
		enterInputFieldCodeWithLabel(REPLACEMENT_HOLDING_GLAN,
				replacementHoldingGlan);
	}

	public void enter_issue_variance_glan(String issueVarianceGlan) {
		enterInputFieldCodeWithLabel(ISSUE_VARIANCE_GLAN, issueVarianceGlan);
	}

	public void enter_production_variance_glan(String productionVarianceGlan) {
		enterInputFieldCodeWithLabel(PRODUCTION_VARIANCE_GLAN,
				productionVarianceGlan);
	}

	public void enter_inventory_expense_glan(String inventoryExpenseGlan) {
		enterInputFieldCodeWithLabel(INVENTORY_EXPENSE_GLAN,
				inventoryExpenseGlan);
	}

	public void enter_physical_addition_glan(String physicalAdditionGlan) {
		enterInputFieldCodeWithLabel(PHYSICAL_ADDITION_GLAN,
				physicalAdditionGlan);
	}

	public void enter_physical_reduction_glan(String physicalReductionGlan) {
		enterInputFieldCodeWithLabel(PHYSICAL_REDUCTION_GLAN,
				physicalReductionGlan);
	}

	public void enter_delivery_clearing_glan(String deliveryClearingGlan) {
		enterInputFieldCodeWithLabel(DELIVERY_CLEARING_GLAN,
				deliveryClearingGlan);
	}

	public void enter_work_in_progress_glan(String workInProgressGlan) {
		enterInputFieldCodeWithLabel(WORK_IN_PROGRESS_GLAN, workInProgressGlan);
	}

	public void enter_calibration_glan(String calibrationGlan) {
		enterInputFieldCodeWithLabel(CALIBRATION_GLAN, calibrationGlan);
	}

	public void enter_scrap_expense_glan(String scrapExpenseGlan) {
		enterInputFieldCodeWithLabel(SCRAP_EXPENSE_GLAN, scrapExpenseGlan);
	}

	public void enter_rework_expense_glan(String reworkExpenseGlan) {
		enterInputFieldCodeWithLabel(REWORK_EXPENSE_GLAN, reworkExpenseGlan);
	}

	public void enter_cost_of_servicing_glan(String costOfServicingGlan) {
		enterInputFieldCodeWithLabel(COST_OF_SERVICING_GLAN,
				costOfServicingGlan);
	}

	public String get_text_with_label(String label) {
		return $(
				"(//*[text() ='" + label
						+ "']//following-sibling::*)[1]//input[@type='text']")
				.getTextValue();
	}

	public String get_text_inventory_class_code() {
		return $(
				"//table[contains(@id,'panInventoryClassDetail')]//input[contains(@id,'inpInvCode')]")
				.getTextValue();

	}

	public String get_text_description() {
		return $(
				"//td[text() = 'Description']//following-sibling::*//input[@type='text']")
				.getTextValue();

	}

	public String get_text_costing_method() {
		return $(
				"// table[contains(@id,'panInventoryClassDetail')]//table//input[@type='radio'] [@checked='checked'] //following-sibling::label")
				.getTextValue();

	}

	public String get_text_inventory_glan() {
		return get_text_with_label(INVENTORY_GLAN);
	}

	public String get_text_sales_glan() {
		return get_text_with_label(SALES_GLAN);
	}

	public String get_text_costs_of_sales_glan() {
		return get_text_with_label(COSTS_OF_SALES_GLAN);

	}

	public String get_text_sales_return_glan() {
		return get_text_with_label(SALES_RETURN_GLAN);
	}

	public String get_text_costs_of_sales_return_glan() {
		return get_text_with_label(COSTS_OF_SALES_RETURN_GLAN);
	}

	public String get_text_costs_of_sales_ret_clearing_glan() {
		return get_text_with_label(COSTS_OF_SALES_RET_CLEARING_GLAN);
	}

	public String get_text_replacement_holding_glan() {
		return get_text_with_label(REPLACEMENT_HOLDING_GLAN);
	}

	public String get_text_issue_variance_glan() {
		return get_text_with_label(ISSUE_VARIANCE_GLAN);
	}

	public String get_text_production_variance_glan() {
		return get_text_with_label(PRODUCTION_VARIANCE_GLAN);
	}

	public String get_text_inventory_expense_glan() {
		return get_text_with_label(INVENTORY_EXPENSE_GLAN);
	}

	public String get_text_physical_addition_glan() {
		return get_text_with_label(PHYSICAL_ADDITION_GLAN);

	}

	public String get_text_physical_reduction_glan() {
		return get_text_with_label(PHYSICAL_REDUCTION_GLAN);
	}

	public String get_text_delivery_clearing_glan() {
		return get_text_with_label(DELIVERY_CLEARING_GLAN);

	}

	public String get_text_work_in_progress_glan() {
		return get_text_with_label(WORK_IN_PROGRESS_GLAN);

	}

	public String get_text_scrap_expense_glan() {
		return get_text_with_label(SCRAP_EXPENSE_GLAN);

	}

	public String get_text_calibration_glan() {
		return get_text_with_label(CALIBRATION_GLAN);

	}

	public String get_text_rework_expense_glan() {
		return get_text_with_label(REWORK_EXPENSE_GLAN);

	}

	public String get_text_cost_of_servicing_glan() {
		return get_text_with_label(COST_OF_SERVICING_GLAN);

	}

	public String get_text_segment(int j) {

		return $("//input [contains (@id, 'segment" + j + "')]").getTextValue();
	}

	public boolean search(String sInventoryClassCode) {
		
		return search("Class Code", sInventoryClassCode);
	}
	
}
