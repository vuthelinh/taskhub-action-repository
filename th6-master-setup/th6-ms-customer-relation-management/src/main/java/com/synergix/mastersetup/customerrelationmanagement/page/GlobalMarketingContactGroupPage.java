package com.synergix.mastersetup.customerrelationmanagement.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;

public class GlobalMarketingContactGroupPage extends TH6PageObject {
	

	private static final String DESCRIPTION = "Description";
	public static final String MARKETING_CONTACT_GROUP_CODE = "Marketing Contact Group Code";

	@Override
	public String getTextValueWithLabel(String label) {
		String commonXpath = "//*[text()='" + label + "']/following-sibling::div/input";
		return $(commonXpath).getTextValue();

	}

	public GlobalMarketingContactGroupPage(WebDriver driver) {
		super(driver);
	}

	public void enter_global_marketing_contact_group_code(String marketingContactGroupCode) {
		enterInputFieldCodeWithLabel(MARKETING_CONTACT_GROUP_CODE, marketingContactGroupCode);
	}

	public String get_text_global_marketing_contact_group_code() {
		return getTextValueWithLabel(MARKETING_CONTACT_GROUP_CODE);

	}

	public void enter_global_marketing_contact_group_code_1(String marketingContactGroupCode) {

		String xPathTbl = "//div[@id='syn:glbMktSummaryInclude:marketingContactGroupSummaryForm:marketingContactGroupSummaryTable']";
		String xPathClickOnElement = "//*[contains(@class,'ui-commandlink ui-widget')]";

		filterDataByHeader(xPathTbl, marketingContactGroupCode);
		clickOnElement(xPathClickOnElement);
	}

	public void enter_code(String sCode) {
		String xPathTbl = "//div[@id='syn:glbMktSummaryInclude:marketingContactGroupSummaryForm:marketingContactGroupSummaryTable']";
		filterDataByHeader(xPathTbl, sCode);
	}

	public void enter_description(String description) {
		enterInputFieldWithLabel(DESCRIPTION, description);
	}

	public String get_text_description(String description) {
		return getTextValueWithLabel(DESCRIPTION);

	}

	public void click_btn_new() {
		clickBtn("New");
	}

	public void click_btn_back_to_summary() {

		back_to_summary();
	}

	public void click_btn_update() {
		String xBtnUpdate = "//span[text()='Update']";
		waitElementToBePresent(xBtnUpdate).waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void click_btn_delete() {

		String xBtnDelete = "//span[text()='Delete']";

		waitElementToBePresent(xBtnDelete).waitUntilClickable().click();

		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();

	}

	public String get_result_code() {
		return $("//*[contains(@class,'ui-widget-content ui-datatable-empty-message')]").waitUntilPresent().getText();
	}

}
