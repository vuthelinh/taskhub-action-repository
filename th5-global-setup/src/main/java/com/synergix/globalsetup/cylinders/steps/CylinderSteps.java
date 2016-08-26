package com.synergix.globalsetup.cylinders.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.synergix.globalsetup.cylinders.pages.CylinderPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class CylinderSteps extends ScenarioSteps {

	CylinderPage cylinderPage;

	@Step
	public void addcylinder() {
		cylinderPage.clickBtn("New");
		cylinderPage.waitForAllJSCompletes();
	}

	@Step
	public void enter_cylinder_code(String cylinderCode) {
		cylinderPage.enter_cylinder_code(cylinderCode);
	}

	@Step
	public void enter_description(String description) {
		cylinderPage.enter_description(description);
	}

	@Step
	public void enter_cylinder_brand_code(String cylinderBrandCode) {
		cylinderPage.enter_cylinder_brand_code(cylinderBrandCode);
	}

	@Step
	public void enter_cylinder_capacity_code(String cylinderCapacityCode) {
		cylinderPage.enter_cylinder_capacity_code(cylinderCapacityCode);
	}

	@Step
	public void enter_filled_inventory_code(String filledInventoryCode) {
		cylinderPage.enter_filled_inventory_code(filledInventoryCode);
	}

	@Step
	public void enter_empty_inventory_code(String emptyInventoryCode) {
		cylinderPage.enter_empty_inventory_code(emptyInventoryCode);
	}

	@Step
	public void select_serial_no_tracking(String serialNoTracking) {
		cylinderPage.select_serial_no_tracking(serialNoTracking);
	}

	@Step
	public void select_for_production_or_sales(String forProductionOrSales) {
		cylinderPage.select_for_production_or_sales(forProductionOrSales);
	}

	@Step
	public void enter_production_category_no(String productionCategoryNo) {
		cylinderPage.enter_production_category_no(productionCategoryNo);
	}

	@Step
	public void enter_order_sequence(String orderSequence) {
		cylinderPage.enter_order_sequence(orderSequence);
	}

	@Step
	public void enter_file_name(String fileName) {
		cylinderPage.enter_file_name(fileName);
	}

	@Step
	public void enter_file_description(String fileDescription, int rowIndex) {
		cylinderPage.enter_file_description(fileDescription, rowIndex);
	}

	@Step
	public void download(int rowIndex) {
		cylinderPage.download(rowIndex);
	}

	@Step
	public void check_del(int rowIndex) {
		cylinderPage.check_del(rowIndex);
	}

	public int count_attachment_file() {
		String xParentDetailTb = "//table[@id='attachmentPanel:tblAttachment']";
		return cylinderPage.getTbCountDataRow(xParentDetailTb);
	}

	@Step
	public void add_attachment_file() {
		cylinderPage.clickBtn("Add");
		cylinderPage.waitForAllJSCompletes();
	}

	@Step
	public void upload_file() {
		cylinderPage.uploadFile();
		cylinderPage.clickBtn("Upload");
		cylinderPage.waitForAllJSCompletes();
	}

	@Step
	public void intoCompanyTab() {
		cylinderPage.switch_to_tab("Company");
	}

	public void search(String sCylinderCode) {
		cylinderPage.click_search_button_on_functional_panel();
		cylinderPage.search(sCylinderCode);
	}

	@Step
	public void clickUpdatebtn() {
		cylinderPage.clickBtn("Update");
		cylinderPage.waitForAllJSCompletes();
		cylinderPage.chooseYesOnUpdateConfirmation();
		cylinderPage.waitForAllJSCompletes();
		cylinderPage.chooseOKOnInfoPanel();
		cylinderPage.waitForAllJSCompletes();
	}

	@Step
	public void deleteCylinder() {
		cylinderPage.clickBtn("Delete", 1);
		cylinderPage.waitForAllJSCompletes();
		cylinderPage.chooseYesOnUpdateConfirmation();
	}

	@Step
	public void verify_cylinder_is_created(String sCylinderCode, String sDescription, String sCylinderBrandCode,
			String sCylinderCapacityCode, String sFilledInventoryCode, String sEmptyInventoryCode,
			String sSerialNoTracking, String sForProductionSales, String sProductionCategoryNo, String sOrderSequence) {
		
		assertThat(cylinderPage.get_code(), equalTo(sCylinderCode));
		assertThat(cylinderPage.get_des(), equalTo(sDescription));
		assertThat(cylinderPage.get_cylinder_brand_code(), equalTo(sCylinderBrandCode));
		assertThat(cylinderPage.get_cylinder_capacity_code(), equalTo(sCylinderCapacityCode));
		assertThat(cylinderPage.get_fill_inventory_code(), equalTo(sFilledInventoryCode));
		assertThat(cylinderPage.get_empty_inventory_code(), equalTo(sEmptyInventoryCode));
		if(sSerialNoTracking.equals("Yes"))
			assertThat(cylinderPage.get_serial_no_tracking(sSerialNoTracking), equalTo("checked"));
		else
			assertThat(cylinderPage.get_serial_no_tracking(sSerialNoTracking), equalTo("unchecked"));
		
		if(sForProductionSales.equals("Yes"))
			assertThat(cylinderPage.get_production_or_sales(sForProductionSales), equalTo("checked"));
		else
			assertThat(cylinderPage.get_production_or_sales(sForProductionSales), equalTo("unchecked"));
		
		assertThat(cylinderPage.get_production_category_no(), equalTo(sProductionCategoryNo));
		assertThat(cylinderPage.get_order_sequence(), equalTo(sOrderSequence));
	}

	@Step
	public void verify_cylinder_is_deleted(String sCylinderCode) {
		addcylinder();
		cylinderPage.click_search_button_on_functional_panel();
		boolean found = cylinderPage.search_cylinder(sCylinderCode);
		assertThat(found, equalTo(false));
	}
}
