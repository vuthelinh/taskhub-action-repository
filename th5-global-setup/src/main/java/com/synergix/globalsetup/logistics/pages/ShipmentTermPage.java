package com.synergix.globalsetup.logistics.pages;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Vincent
 * @version Vincent
 */
public class ShipmentTermPage extends TH5PageObject {
	public ShipmentTermPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Shipment Term";

	// #Region#Element
	@FindBy(xpath = "//span[@id='formHeaderAtHeader:formTitle']")
	private WebElementFacade pageHeader;

	private String xPathTbShipmentTerm = "(//table[contains(@id, 'shmTermTable')])[1]";
	private String xPathTbCompanyTag = "(//table[contains(@id, 'tblCompanyList')])[1]";

	// #EndRegion#Element

	// #Region#Page Action
	public void click_btn_add() {
		clickBtn("Add");
		String ret = getErrorMessagesThenClickOK();
		if (ret != null && ret.contains("Please input Shipment Term Code")) {
			System.out.println("***** WARNING ***** : New row was display for inputing");
		}
	}

	public void click_btn_update() {
		clickBtn("Update");
		clickBtnYesOnConfirmUpdate();
		if (getInfoPanelMessagesThenClickOK() == null) {
			getErrorMessagesThenClickOK();
		}
	}

	public void click_btn_close() {
		clickBtn("Close");
	}

	public void click_btn_delete() {
		clickBtn("Delete");
	}

	/**
	 * @author Vincent
	 * @param _shipmentMode
	 */
	public void select_shipment_mode(String _shipmentMode) {
		selectDdlWithLabelByText("Shipment Mode", _shipmentMode);
	}

	public void enter_holding_bay_period(String _holdingBayPeriod) {
		enterInputFieldWithLabel("Holding Bay Period", _holdingBayPeriod);
	}

	public String enter_new_shipment_term_code(String _shipment_term_code) {
		return waitTypeAndEnterThenUpdateValueReadOnlyOrError(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbShipmentTerm,
						getTbColHeaderIndex(xPathTbShipmentTerm, "Shipment Term Code")) + "//input[@type='text']",
				_shipment_term_code);
	}

	public int get_row_index_by_shipment_term_code(String _shipment_term_code) {
		return searchInTbMultiPage(xPathTbShipmentTerm, "Shipment Term Code", 1, _shipment_term_code, true);
	}

	public void enter_description(int _rowIndex, String _description) {
		waitTypeAndEnter(xPathTbDataCellByPosition(xPathTbShipmentTerm, _rowIndex,
				getTbColHeaderIndex(xPathTbShipmentTerm, "Description")) + "//input", _description);
	}

	public void switch_to_tab_shipment_term() {
		switch_to_tab("Shipment Term");
	}

	public void switch_to_tab_company() {
		switch_to_tab("Company");
	}

	public void chooseCompany(String _companyName) {
		chooseCompany(xPathTbCompanyTag, _companyName);
	}
	// #EndRegion Page Action
}
