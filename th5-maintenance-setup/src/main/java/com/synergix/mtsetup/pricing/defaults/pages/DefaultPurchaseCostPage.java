package com.synergix.mtsetup.pricing.defaults.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

/**
 * @author Vincent
 * @version 20160812
 */
public class DefaultPurchaseCostPage extends TH5PageObject {

	public DefaultPurchaseCostPage(WebDriver driver) {
		super(driver);
	}

	public void click_btn_close() {
		clickBtn("Close");
	}

	public void click_btn_update() {
		clickBtn("Update");
		clickBtnYesOnConfirmUpdate();
		if (getInfoPanelMessagesThenClickOK() == null) {
			getErrorMessagesThenClickOK();
		}
	}

	// Inventory Pricing
	private static final String xPathPanelInventoryPricing = "//table[contains(@id,'tblInvenPrice')]";

	public void enter_inventory_pricing_default_cost_new_priority(String _description, String _newPriority) {
		waitTypeAndEnterThenUpdateValue("(" + xPathPanelInventoryPricing + "//td//descendant-or-self::*["
				+ sSpecialTextPredicates(_description) + "][string-length()<=" + _description.length()
				+ "]/ancestor-or-self::td[1]/following-sibling::td//input[@type='text'])[1]", _newPriority);
	}

	public String get_inventory_pricing_default_cost_priority(String _description) {
		return waitElementToBePresentThenScrollIntoView("(" + xPathPanelInventoryPricing
				+ "//td//descendant-or-self::*[" + sSpecialTextPredicates(_description) + "][string-length()<="
				+ _description.length() + "]/ancestor-or-self::td[1]/following-sibling::td//span)[1]").getText();
	}

	public void enter_inventory_pricing_default_supplier_info_to_or_ccf_new_priority(String _description,
			String _newPriority) {
		waitTypeAndEnterThenUpdateValue("(" + xPathPanelInventoryPricing + "//td//descendant-or-self::*["
				+ sSpecialTextPredicates(_description) + "][string-length()<=" + _description.length()
				+ "]/ancestor-or-self::td[1]/following-sibling::td//input[@type='text'])[2]", _newPriority);
	}

	public String get_inventory_pricing_default_supplier_info_to_or_ccf_priority(String _description) {
		return waitElementToBePresentThenScrollIntoView("(" + xPathPanelInventoryPricing
				+ "//td//descendant-or-self::*[" + sSpecialTextPredicates(_description) + "][string-length()<="
				+ _description.length() + "]/ancestor-or-self::td[1]/following-sibling::td//span)[2]").getText();
	}

	// Service Pricing
	private static final String xPathPanelServicePricing = "//table[contains(@id,'tblSerPrice')]";

	public void enter_service_pricing_default_cost_new_priority(String _description, String _newPriority) {
		waitTypeAndEnterThenUpdateValue("(" + xPathPanelServicePricing + "//td//descendant-or-self::*["
				+ sSpecialTextPredicates(_description) + "][string-length()<=" + _description.length()
				+ "]/ancestor-or-self::td[1]/following-sibling::td//input[@type='text'])[1]", _newPriority);
	}

	public String get_service_pricing_default_cost_priority(String _description) {
		return waitElementToBePresentThenScrollIntoView("(" + xPathPanelServicePricing + "//td//descendant-or-self::*["
				+ sSpecialTextPredicates(_description) + "][string-length()<=" + _description.length()
				+ "]/ancestor-or-self::td[1]/following-sibling::td//span)[1]").getText();
	}

	public void enter_service_pricing_default_supplier_info_to_or_ccf_new_priority(String _description,
			String _newPriority) {
		waitTypeAndEnterThenUpdateValue("(" + xPathPanelServicePricing + "//td//descendant-or-self::*["
				+ sSpecialTextPredicates(_description) + "][string-length()<=" + _description.length()
				+ "]/ancestor-or-self::td[1]/following-sibling::td//input[@type='text'])[2]", _newPriority);
	}

	public String get_service_pricing_default_supplier_info_to_or_ccf_priority(String _description) {
		return waitElementToBePresentThenScrollIntoView("(" + xPathPanelServicePricing + "//td//descendant-or-self::*["
				+ sSpecialTextPredicates(_description) + "][string-length()<=" + _description.length()
				+ "]/ancestor-or-self::td[1]/following-sibling::td//span)[2]").getText();
	}
}
