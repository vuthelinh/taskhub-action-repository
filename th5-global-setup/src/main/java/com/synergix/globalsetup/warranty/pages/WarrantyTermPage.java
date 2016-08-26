package com.synergix.globalsetup.warranty.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

/**
 * @author Vincent
 * @version 20160121
 */
public class WarrantyTermPage extends TH5PageObject {
	public WarrantyTermPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Warranty Term";
	private static final String xPathPanelWarrantyTerm = "//div[text()='Global Warranty Term']//ancestor::div[1]";

	public void click_btn_new_summary() {
		clickBtn("New");
	}

	public void click_btn_new() {
		clickBtn(xPathPanelWarrantyTerm, "New");
	}

	public void click_btn_delete() {
		clickBtn(xPathPanelWarrantyTerm, "Delete");
	}

	public void click_btn_close() {
		clickBtn(xPathPanelWarrantyTerm, "Close");
	}

	public void click_btn_update() {
		clickBtn(xPathPanelWarrantyTerm, "Update");
		clickBtnYesOnConfirmUpdate();
		if (getInfoPanelMessagesThenClickOK() == null) {
			getErrorMessagesThenClickOK();
		}
	}

	public void enter_warranty_term_code(String _warrantyTermCode) {
		waitTypeAndEnterThenUpdateValueReadOnly(xPathInputFieldWithLabel(xPathPanelWarrantyTerm, "Warranty Term Code"),
				_warrantyTermCode);
	}

	public void enter_description(String _description) {
		enterInputFieldWithLabel("Description", _description);
	}

	public void enter_warranty_days(String _warrantyDays) {
		enterInputFieldWithLabel("Warranty Days", _warrantyDays);
	}

	public String get_global_status() {
		return getTextWithLabel("Global Status");
	}

	public void switch_to_tab_company() {
		switch_to_tab("Company");
	}

	public void switch_to_tab_local_info() {
		switch_to_tab("Local Info");
	}

	public void select_global_status(String _globalStatus) {
		selectRadioButton("Global Status", _globalStatus);
	}

	// Local Info
	public void select_local_info(String _localInfo) {
		selectRadioButton(xPathRadioBtnWithLabel("//span[contains(@id,'detailsOutputPanel')]", _localInfo));
	}

	// Tag company
	private String xPathTbCompanyTag = "(" + xPathPanelWarrantyTerm + "//table[contains(@id, 'tblCompanyList')])[1]";

	public void chooseCompany(String _companyName) {
		chooseCompany(xPathTbCompanyTag, _companyName);
	}
}
