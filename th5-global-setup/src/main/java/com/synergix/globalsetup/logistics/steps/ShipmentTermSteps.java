package com.synergix.globalsetup.logistics.steps;

import com.synergix.globalsetup.logistics.pages.ShipmentTermPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160121
 */
public class ShipmentTermSteps extends ScenarioSteps {
	
	private static final long serialVersionUID = 1L;
	ShipmentTermPage shipmentTermPage;

	@Step
	public void click_btn_add() {
		shipmentTermPage.click_btn_add();
	}

	@Step
	public void click_btn_update() {
		shipmentTermPage.click_btn_update();
	}

	@Step
	public void click_btn_close() {
		shipmentTermPage.click_btn_close();
	}

	@Step
	public void click_btn_delete() {
		shipmentTermPage.click_btn_delete();
	}

	@Step
	public void select_shipment_mode(String _shipmentMode) {
		shipmentTermPage.select_shipment_mode(_shipmentMode);
	}

	@Step
	public void enter_holding_bay_period(String _holdingBayPeriod) {
		shipmentTermPage.enter_holding_bay_period(_holdingBayPeriod);
	}

	@Step
	public String enter_new_shipment_term_code(String _shipment_term_code) {
		String ret= shipmentTermPage.enter_new_shipment_term_code(_shipment_term_code);
		if (!ret.isEmpty()) {
			ret = shipmentTermPage.getErrorMessagesThenClickOK();
		}
		return ret;
	}

	@Step
	public int get_row_index_by_shipment_term_code(String _shipment_term_code) {
		return shipmentTermPage.get_row_index_by_shipment_term_code(_shipment_term_code);
	}

	@Step
	public void enter_description(int _rowIndex, String _description) {
		shipmentTermPage.enter_description(_rowIndex, _description);
	}

	@Step
	public void switch_to_tab_shipment_term() {
		shipmentTermPage.switch_to_tab_shipment_term();
	}

	@Step
	public void switch_to_tab_company() {
		shipmentTermPage.switch_to_tab_company();
	}

	@Step
	public void tag_company(String _companyName) {
		shipmentTermPage.chooseCompany(_companyName);
	}

}
