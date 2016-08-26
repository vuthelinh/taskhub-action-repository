package com.synergix.globalsetup.party.supplier.page;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

/**
 * @author Vincent
 * @version 20160121
 */
public class SupplierRankPage extends TH5PageObject {
	public SupplierRankPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Rank";
	private static final String xPathPanelSupplierRank = "//div[text()='Global Supplier Rank']//ancestor::form[1]";

	public void click_btn_new() {
		clickBtn(xPathPanelSupplierRank, "New");
	}

	public void click_btn_delete() {
		clickBtn(xPathPanelSupplierRank, "Delete");
	}

	public void click_btn_close() {
		clickBtn(xPathPanelSupplierRank, "Close");
	}

	public void click_btn_update() {
		clickBtn(xPathPanelSupplierRank, "Update");
		clickBtnYesOnConfirmUpdate();
		if (getInfoPanelMessagesThenClickOK() == null) {
			getErrorMessagesThenClickOK();
		}
	}

	public boolean search_supplier_rank_code(String _supplierRankCode) {
		clickBtn(xPathPanelSupplierRank, "Search");
		return search("Supplier Rank Code", _supplierRankCode);
	}

	public String enter_supplier_rank_code(String _supplierRankCode) {
		return waitTypeAndEnterThenUpdateValueReadOnlyOrError(
				xPathInputFieldWithLabel(xPathPanelSupplierRank, "Supplier Rank Code"), _supplierRankCode);
	}

	public void enter_description(String _description) {
		enterInputFieldWithLabel("Description", _description);
	}

	// Tag company
	private String xPathTbCompanyTag = "(" + xPathPanelSupplierRank + "//table[contains(@id, 'tblCompanyList')])[1]";

	public void chooseCompany(String _companyName) {
		chooseCompany(xPathTbCompanyTag, _companyName);
	}
}
