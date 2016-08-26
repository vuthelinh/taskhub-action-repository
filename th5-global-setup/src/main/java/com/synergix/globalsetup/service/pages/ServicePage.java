package com.synergix.globalsetup.service.pages;



import org.openqa.selenium.WebDriver;

import com.synergix.common.LogWork;
import com.synergix.common.TH5PageObject;



public class ServicePage extends TH5PageObject {
	private static final String DEFAULT_SALES_TAX = "Default Sales Tax";
	private static final String ACCRUED_COST_GLAN = "Accrued Cost GLAN";
	private static final String INTERCOMPANY_SALES_TAX = "Intercompany Sales Tax";
	private static final String OVERHEAD_GLAN = "Overhead GLAN";
	private static final String UNEARNED_REVENUE_GLAN = "Unearned Revenue GLAN";
	private static final String UOM2 = "UOM";
	private static final String SERVICE_CATEGORY = "Service Category";
	private static final String EXPENSE_GLAN = "Expense GLAN";
	private static final String REVENUE_GLAN = "Revenue GLAN";
	private static final String SERVICE_DESCRIPTION = "Service Description";
	public static final String SEVICE_CODE = "Service Code";

	public ServicePage(WebDriver driver) {
		super(driver);
	}

	public void enter_service_code(String serviceCode) {
		enterInputFieldCodeWithLabel(SEVICE_CODE, serviceCode);

	}
	
	public String get_service_code() {
		return getTextValueWithLabel(SEVICE_CODE);

	}

	public String get_text_service_code() {
		return getTextValueWithLabel(SEVICE_CODE);
	}

	public void enter_service_description(String serviceDescription) {
		enterInputFieldWithLabel(SERVICE_DESCRIPTION, serviceDescription);
	}

	public String get_text_service_description() {
		return getTextValueWithLabel(SERVICE_DESCRIPTION);
	}

	public void check_service_type(String serviceType) {
		
		checkChkbox(getXpathCheckboxByText(serviceType));
	}

	public String is_serviceType_Revenue(){
		
		String expect = $(getXpathCheckboxByText("Revenue (Deduction)")).getAttribute("checked");
		LogWork.log_debug("Revenue (Deduction): " + expect);
		return expect;

	}

	public void enter_revenue_glan(String revenueGlan) {
		enterInputFieldWithLabel(REVENUE_GLAN, revenueGlan);

	}

	public String get_text_revenue_glan() {
		return getValue(REVENUE_GLAN);
		
	}

	public void enter_expense_glan(String expenseGlan) {
		enterInputFieldWithLabel(EXPENSE_GLAN, expenseGlan);
	}

	public String get_text_expense_glan() {
		return getValue(EXPENSE_GLAN);
		
	}

	public void click_btn_search() {
		click_search_button_on_functional_panel();
	}
	public String get_result_search_service(){
		return $("//table[@id='searchResult_Form:searchResult_Table']/following-sibling::span").waitUntilPresent().getText();
	}

	public void search_by_code(String svCode) {
		search(SEVICE_CODE, svCode);
	}

	public void click_btn_new() {

		click_add_new_button_on_functional_panel();
	}

	public void click_btn_update() {
		click_update_button_on_functional_panel();

	}

	

	public void enter_service_category(String serviceCategory) {
		enterInputFieldWithLabel(SERVICE_CATEGORY, serviceCategory);
	}
	
	

	public String get_text_service_category() {
		return getTextValueWithLabel(SERVICE_CATEGORY);
	}

	public void enter_uom(String uom) {
		enterInputFieldWithLabel(UOM2, uom);
	}

	public String get_text_uom() {
		return getTextValueWithLabel(UOM2);
	}

	public void enter_unearned_revenue_glan(String unearnedRevenueGlan) {
		enterInputFieldWithLabel(UNEARNED_REVENUE_GLAN, unearnedRevenueGlan);
	}

	public String get_text_unearned_revenue_glan() {
		return getValue(UNEARNED_REVENUE_GLAN);
		
	}

	public void enter_overhead_glan(String overheadGlan) {
		enterInputFieldWithLabel(OVERHEAD_GLAN, overheadGlan);
	}

	public String get_text_overhead_glan() 
	{
		
		return getValue(OVERHEAD_GLAN);
		
	}

	public void enter_intercompany_sales_tax(String intercompanySalesTax) {
		enterInputFieldWithLabel(INTERCOMPANY_SALES_TAX, intercompanySalesTax);
	}

	public String get_text_intercompany_sales_tax() {
		return getValue(INTERCOMPANY_SALES_TAX);
		
	}

	public void enter_accrued_cost_glan(String accruedCostGlan) {
		enterInputFieldWithLabel(ACCRUED_COST_GLAN, accruedCostGlan);
	}

	public String get_text_accrued_cost_glan() {
		return getValue(ACCRUED_COST_GLAN);
		
	}

	public void select_in_default_sales_tax(String saleTax) {
		selectDdlByText(xPathDdlWithLabel(DEFAULT_SALES_TAX), saleTax);
	}

	public String get_default_salesTax(){
		return $(xPathDdlWithLabel(DEFAULT_SALES_TAX) + "//option[@selected='selected']").getText();
		
	}
	public void click_btn_delete() {
		click_delete_button_on_functional_panel();
	}
	
}
