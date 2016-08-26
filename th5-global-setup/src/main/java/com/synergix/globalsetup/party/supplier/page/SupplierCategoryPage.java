package com.synergix.globalsetup.party.supplier.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

/**
 * @author Vincent
 * @version 20160121
 */
public class SupplierCategoryPage extends TH5PageObject {
	public SupplierCategoryPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Supplier Category";
	private static final String xPathPanelSupplierCategory = "//div[text()='Global Supplier Category']//ancestor::form[1]";

	public void click_btn_new() {
		clickBtn(xPathPanelSupplierCategory, "New");
	}

	public void click_btn_delete() {
		clickBtn(xPathPanelSupplierCategory, "Delete");
	}

	public void click_btn_close() {
		clickBtn(xPathPanelSupplierCategory, "Close");
	}

	public void click_btn_update() {
		clickBtn(xPathPanelSupplierCategory, "Update");
		clickBtnYesOnConfirmUpdate();
		if (getInfoPanelMessagesThenClickOK() == null) {
			getErrorMessagesThenClickOK();
		}
	}

	public String enter_supplier_category_code(String _supplierCategoryCode) {
		return waitTypeAndEnterThenUpdateValueReadOnlyOrError(
				xPathInputFieldWithLabel(xPathPanelSupplierCategory, "Supplier Category Code"), _supplierCategoryCode);
	}

	public boolean search_supplier_category_code(String _supplierCategoryCode) {
		clickBtn(xPathPanelSupplierCategory, "Search");
		return search("Supplier Category Code", _supplierCategoryCode);
	}

	public void enter_description(String _description) {
		enterInputFieldWithLabel("Description", _description);
	}

	// Tag company
	private String xPathTbCompanyTag = "(" + xPathPanelSupplierCategory
			+ "//table[contains(@id, 'tblCompanyList')])[1]";

	public void chooseCompany(String _companyName) {
		chooseCompany(xPathTbCompanyTag, _companyName);
	}
}
