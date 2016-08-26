package com.synergix.globalsetup.administration.company.steps;

import com.synergix.globalsetup.administration.company.pages.StrategicBusinessUnitPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Ian and Steve on 8/3/2016.
 */
public class StrategicBusinessUnitSteps extends ScenarioSteps {
	
	private static final long serialVersionUID = 1L;
	StrategicBusinessUnitPage onStrategicBusinessUnit;

	public void switch_to_iframe() {
		onStrategicBusinessUnit.switchToIFrame();
	}
	
	public void switch_out_default_iframe() {
		onStrategicBusinessUnit.switchOutDefaultIFrame();
	}
	
	@Step
	public void click_btn_close() {
		onStrategicBusinessUnit.click_close_button_on_functional_panel();
	}

	@Step
	public void click_btn_new() {
		onStrategicBusinessUnit.click_add_new_button_on_functional_panel();
	}

	@Step
	public void click_btn_delete() {
		onStrategicBusinessUnit.click_delete_button_on_functional_panel();;
	}

	@Step
	public void click_btn_search() {
		onStrategicBusinessUnit.click_search_button_on_functional_panel();
	}

	@Step
	public void update() {
		onStrategicBusinessUnit.click_update_button_on_functional_panel();
	}

	@Step
	public void enter_sbu_code(String sbuCode) {
		onStrategicBusinessUnit.enter_sbu_code(sbuCode);
	}

	@Step
	public String get_text_sbu_code() {
		return onStrategicBusinessUnit.get_text_sbu_code();
	}

	@Step
	public void enter_description(String description) {
		onStrategicBusinessUnit.enter_description(description);
	}

	@Step
	public String get_text_description() {
		return onStrategicBusinessUnit.get_text_description();
	}

	@Step
	public void enter_detailed_description(String detailedDescription) {
		onStrategicBusinessUnit.enter_detailed_description(detailedDescription);
	}

	@Step
	public String get_text_detailed_description() {
		return onStrategicBusinessUnit.get_text_detailed_description();
	}

	@Step
	public void enter_cti_code(String ctiCode) {
		onStrategicBusinessUnit.enter_cti_code(ctiCode);
	}

	@Step
	public String get_text_cti_code() {
		return onStrategicBusinessUnit.get_text_cti_code();
	}

	@Step
	public void select_global_status(String globalStatus) {
		onStrategicBusinessUnit.select_global_status(globalStatus);
	}

	@Step
	public void switch_tab_purchaser_in_charge() {
		onStrategicBusinessUnit.switch_tab_purchaser_in_charge();
	}

	@Step
	public void switch_tab_accessible_inventory() {
		onStrategicBusinessUnit.switch_tab_accessible_inventory();
	}

	@Step
	public void enter_purchaser_in_charge(String employeeCode) {
		onStrategicBusinessUnit.enter_purchaser_in_charge(employeeCode);
	}

	@Step
	public String get_text_purchaser_in_charge() {
		return onStrategicBusinessUnit.get_text_purchaser_in_charge();
	}

	@Step
	public void click_btn_add_in_tab() {
		onStrategicBusinessUnit.click_btn_add_in_tab();
		onStrategicBusinessUnit.waitForAllJSCompletes();
	}

	@Step
	public void click_btn_delete_in_tab() {
		onStrategicBusinessUnit.click_btn_delete_in_tab();
		onStrategicBusinessUnit.waitForAllJSCompletes();
	}

	@Step
	public boolean search_sbu(String sbuCode) {
		return onStrategicBusinessUnit.search_sbu(sbuCode);
	}

	@Step
	public int get_inventory_class_table_count_data_row() {
		return onStrategicBusinessUnit.get_inventory_class_table_count_data_row();
	}

	@Step
	public void enter_inventory_class(String inventoryClass, int rowIndex) {
		onStrategicBusinessUnit.enter_inventory_class(inventoryClass, rowIndex);
	}

	@Step
	public String get_text_inventory_class(int rowIndex) {
		return onStrategicBusinessUnit.get_text_inventory_class(rowIndex);
	}

	@Step
	public String get_text_inventory_description(int rowIndex) {
		return onStrategicBusinessUnit.get_text_inventory_description(rowIndex);
	}

	@Step
	public void check_del(int rowIndex) {
		onStrategicBusinessUnit.check_del(rowIndex);
	}

	@Step
	public void uncheck_del(int rowIndex) {
		onStrategicBusinessUnit.uncheck_del(rowIndex);
	}
	
	@Step
	public void switch_tab_company(){
		onStrategicBusinessUnit.switch_tab_company();
	}

	@Step
	public void choose_company(String companyList) {
		onStrategicBusinessUnit.switch_tab_company();
		onStrategicBusinessUnit.chooseCompany(companyList);
	}

	@Step
	public void create_new_strategic_business_unit(String sbuCode, String description) {
		onStrategicBusinessUnit.switchToIFrame("th5frame");

		onStrategicBusinessUnit.click_add_new_button_on_functional_panel();
		onStrategicBusinessUnit.waitForAllJSCompletes();

		onStrategicBusinessUnit.enterInputFieldCodeWithLabel("SBU Code", sbuCode);
		onStrategicBusinessUnit.waitForAllJSCompletes();

		onStrategicBusinessUnit.enterInputFieldCodeWithLabel("Description", description);
		onStrategicBusinessUnit.waitForAllJSCompletes();

		onStrategicBusinessUnit.click_update_button_on_functional_panel();
		onStrategicBusinessUnit.waitForAllJSCompletes();

		onStrategicBusinessUnit.switchOutDefaultIFrame();
	}

	@Step
	public boolean is_checked_global_status(String globalStatus) {
		return onStrategicBusinessUnit.is_checked_global_status(globalStatus);
	}

	@Step
	public void verify_sbu_code(String subCode) {
		assertThat(onStrategicBusinessUnit.get_text_sbu_code(), equalTo(subCode));
	}

	@Step
	public void verify_sbu_description(String description) {
		assertThat(onStrategicBusinessUnit.get_text_description(), equalTo(description));
	}

	@Step
	public void verify_detailed_description(String detailedDescription) {
		assertThat(onStrategicBusinessUnit.get_text_detailed_description(), equalTo(detailedDescription));
	}

	@Step
	public void verify_cti_code(String ctiCode) {
		assertThat(onStrategicBusinessUnit.get_text_cti_code(), equalTo(ctiCode.toUpperCase()));
	}

	@Step
	public void verify_global_status(String globalStatus) {
		assertThat(onStrategicBusinessUnit.is_checked_global_status(globalStatus), equalTo(true));
	}

	@Step
	public void verify_purchaser_in_charge(String employeeCode) {
		assertThat(onStrategicBusinessUnit.get_text_purchaser_in_charge(), equalTo(employeeCode));
	}

	@Step
	public void verify_purchaser_in_charge_name(String employeeName) {
		assertThat(onStrategicBusinessUnit.get_text_purchaser_name(), equalTo(employeeName));
	}

	@Step
	public void verify_inventory_class(int rowIndex, String inventoryClassCode) {
		assertThat(onStrategicBusinessUnit.get_text_inventory_class(rowIndex), equalTo(inventoryClassCode));
	}

	@Step
	public void verify_inventory_description(int rowIndex, String inventoryClassDescription) {
		assertThat(onStrategicBusinessUnit.get_text_inventory_description(rowIndex),
				equalTo(inventoryClassDescription));
	}

	@Step
	public void delete_sbu(){
		click_btn_delete();
	}
	
	@Step
	public void verify_sbu_code_not_found(String sbuCode){
		assertThat(onStrategicBusinessUnit.search_sbu(sbuCode), equalTo(false));
	}	
	
}
