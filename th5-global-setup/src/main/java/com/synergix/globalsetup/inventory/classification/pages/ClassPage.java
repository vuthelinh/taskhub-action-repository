package com.synergix.globalsetup.inventory.classification.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

/**
 * @author Vincent
 * @version 20160121
 */
public class ClassPage extends TH5PageObject {
	public ClassPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Class";
	// #Region#Element

	private String inputFieldDescription = "//td[text()='Description']/ancestor-or-self::td/following-sibling::td//input[1]";

	private String groupCostingMethod = "//span[text()='Costing Method']/ancestor-or-self::tr[1]";

	// #EndRegion#Element

	// #Region#Page Action
	private static final String xPathPanelGLInventoryClass = "//div[text()='Global Inventory Class']//ancestor::form[1]";

	public void click_btn_new() {
		clickBtn(xPathPanelGLInventoryClass, "New");
	}

	public void click_btn_delete() {
		clickBtn(xPathPanelGLInventoryClass, "Delete");
	}

	public void click_btn_close() {
		clickBtn(xPathPanelGLInventoryClass, "Close");
	}

	public boolean search_inventory_class_code(String _supplierRankCode) {
		clickBtn(xPathPanelGLInventoryClass, "Search");
		return search("Class Code", _supplierRankCode);
	}

	public String enter_inventory_class_code(String _supplierRankCode) {
		return waitTypeAndEnterThenUpdateValueReadOnlyOrError(
				xPathInputFieldWithLabel(xPathPanelGLInventoryClass, "Inventory Class Code"), _supplierRankCode);
	}

	public void enter_description(String _description) {
		waitTypeAndEnterThenUpdateValue(inputFieldDescription, _description);
	}

	public void switch_to_tab_gl_account_detail() {
		switch_to_tab("GL Account Detail");
	}

	public void switch_to_tab_company() {
		switch_to_tab("Company");
	}

	public void select_costing_method(String _costingMethod) {
		selectRadioButton(findRadioBtnByLabel(groupCostingMethod, _costingMethod));
	}

	public void enter_gl_account_detail(String _labelName, String _value) {
		enterInputFieldWithLabel(_labelName, _value);
	}

	public void click_btn_update() {
		clickBtn(xPathPanelGLInventoryClass, "Update");
		clickBtnYesOnConfirmUpdate();
		if (getInfoPanelMessagesThenClickOK() == null) {
			getErrorMessagesThenClickOK();
		}
	}
	// #EndRegion Page Action

	// #Region#ForTest==================================================================
	// #EndRegion#ForTest================================================================
}
