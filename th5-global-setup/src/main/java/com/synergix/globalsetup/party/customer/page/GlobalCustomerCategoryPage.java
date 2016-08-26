package com.synergix.globalsetup.party.customer.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

/**
 * @author Vincent
 * @version 20160121
 */
public class GlobalCustomerCategoryPage extends TH5PageObject {
	public GlobalCustomerCategoryPage(WebDriver driver) {
		super(driver);
	}

	private static final String sPageHeader = "Customer Category";
	private static final String xPathPanelCustomerCategory = "//div[text()='Global Customer Category']//ancestor::form[1]";
	private static final String xPathLinkIndustryCodeSearch = "//tbody[@id='searchResult_Form:searchResult_Table:tb']//td[1]/a[contains(@id,'searchResult_Form')]/span";
	public void click_btn_new() {
		clickBtn(xPathPanelCustomerCategory, "New");
	}

	public void click_btn_delete() {
		clickBtn(xPathPanelCustomerCategory, "Delete");
	}

	public void click_btn_close() {
		clickBtn(xPathPanelCustomerCategory, "Close");
	}

	public void click_btn_update() {
		clickBtn(xPathPanelCustomerCategory, "Update");
		clickBtnYesOnConfirmUpdate();
		if (getInfoPanelMessagesThenClickOK() == null) {
			getErrorMessagesThenClickOK();
		}
	}

	public void enter_customer_category_code(String _customerCategoryCode) {
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathInputFieldWithLabel(xPathPanelCustomerCategory, "Customer Category Code"), _customerCategoryCode);
	}

	public void enter_description(String _description) {
		enterInputFieldWithLabel("Description", _description);
	}

	public void select_customer_type(String _customerType) {
		selectRadioButton("Customer Type", _customerType);
	}

	// Tag company
	private String xPathTbCompanyTag = "(" + xPathPanelCustomerCategory
			+ "//table[contains(@id, 'tblCompanyList')])[1]";

	public void chooseCompany(String _companyName) {
		chooseCompany(xPathTbCompanyTag, _companyName);
	}

	public void click_btn_search() {
		waitElementToBePresent("//input[@value='Search']").waitUntilClickable().click();
		
	}

	public boolean search_result(String cusCategoryCode) {
		return search("Customer Category Code", cusCategoryCode);
	}

	public void click_on_customer_category_code_link() {
		String xPath = ".//*[@id='searchResult_Form:searchResults']/div/span[text()='No Records Found!']";
		if (isElementExist(xPath)) {
			$("//img[@src='/TH5Web/img/close-icon.gif']").waitUntilClickable().click();
		} else {
			waitElementToBePresent(xPathLinkIndustryCodeSearch).waitUntilClickable().click();
		}

	}
	public void click_btn_status_popup() {
		 String xPathBtnStatusPopup = "//*[@id='statusPopupPanel_OkButton']";
		if (isElementVisible(xPathBtnStatusPopup, 1)) {
			waitElementToBePresent(xPathBtnStatusPopup).waitUntilClickable().click();
		}
	}
}
