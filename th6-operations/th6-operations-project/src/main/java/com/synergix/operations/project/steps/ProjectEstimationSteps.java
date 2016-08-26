package com.synergix.operations.project.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.synergix.operations.project.pages.ProjectEstimationPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ProjectEstimationSteps extends ScenarioSteps {

	private static final long serialVersionUID = 1L;
	ProjectEstimationPage onProjectEstimationPage;

	@Step
	public void i_test_the_method(String phaseNo) {
		onProjectEstimationPage.phaseNoToRowIndex(phaseNo);
	}

	@Step
	public void click_add_new_button_on_functional_panel() {
		onProjectEstimationPage.click_add_new_button_on_functional_panel();
	}

	public String get_project_no() {
		return onProjectEstimationPage.get_project_no();
	}

	@Step
	public void click_btn_back_to_summary() {
		onProjectEstimationPage.back_to_summary();
	}

	/**
	 * @Description: Button New near button Back To Summary
	 * 
	 */
	@Step
	public void click_btn_new() {
		onProjectEstimationPage.click_btn_new();
	}

	@Step
	public void click_btn_submit() {
		onProjectEstimationPage.click_btn_submit();
	}

	@Step
	public void click_btn_preview() {
		onProjectEstimationPage.click_btn_preview();
	}

	@Step
	public void click_btn_abort() {
		onProjectEstimationPage.click_btn_abort();
	}

	@Step
	public void delete_project_estimation() {
		onProjectEstimationPage.delete_project_estimation();
	}

	@Step
	public void enter_project_name(String projectName) {
		onProjectEstimationPage.enter_project_name(projectName);
	}

	@Step
	public void verify_project_name(String expectedProjectName) {
		assertThat(onProjectEstimationPage.get_text_project_name(), equalTo(expectedProjectName));
	}

	@Step
	/**
	 * @param customer:
	 *            is customer code or customer name
	 * 
	 */
	public void enter_customer(String customer) {
		onProjectEstimationPage.enter_customer(customer);
	}

	@Step
	public void verify_customer_name(String expectedCustomerName) {
		assertThat(onProjectEstimationPage.get_text_customer(), equalTo(expectedCustomerName));
	}

	@Step
	public void pick_project_duration_and_dlp_from(String projectDurationAndDlpFrom) {
		onProjectEstimationPage.pick_project_duration_and_dlp_from(projectDurationAndDlpFrom);
	}

	@Step
	public void verify_project_duration_and_dlp_from(String expectedDate) {
		assertThat(onProjectEstimationPage.get_project_duration_and_dlp_from(), equalTo(expectedDate));
	}

	@Step
	public void pick_project_duration_and_dlp_to(String projectDurationAndDlpTo) {
		onProjectEstimationPage.pick_project_duration_and_dlp_to(projectDurationAndDlpTo);
	}

	@Step
	public void verify_project_duration_and_dlp_to(String expectedDate) {
		assertThat(onProjectEstimationPage.get_project_duration_and_dlp_to(), equalTo(expectedDate));
	}

	@Step
	public void enter_dlp(String withDlp) {
		onProjectEstimationPage.enter_dlp(withDlp);
	}

	@Step
	public void verify_dlp(String expectedDlp) {
		assertThat(onProjectEstimationPage.get_text_dlp(), equalTo(expectedDlp));
	}

	@Step
	public void enter_customer_job_no(String customerJobNo) {
		onProjectEstimationPage.enter_customer_job_no(customerJobNo);
	}

	@Step
	public void verify_customer_job_no(String expectedCustomerJobNo) {
		assertThat(onProjectEstimationPage.get_text_customer_job_no(), equalTo(expectedCustomerJobNo));
	}

	@Step
	public void enter_awarded_date(String awardedDate) {
		onProjectEstimationPage.enter_awarded_date(awardedDate);
	}

	@Step
	public void verify_awarded_date(String expectedAwardedDate) {
		assertThat(onProjectEstimationPage.get_text_awarded_date(), equalTo(expectedAwardedDate));
	}

	@Step
	public void enter_reference_no(String referenceNo) {
		onProjectEstimationPage.enter_reference_no(referenceNo);
	}

	@Step
	public void verify_reference_no(String expectedReferenceNo) {
		assertThat(onProjectEstimationPage.get_text_reference_no(), equalTo(expectedReferenceNo));
	}

	@Step
	/**
	 * @param contact:
	 *            is contact code or party contact name
	 */
	public void enter_contact_person(String contactPerson) {
		onProjectEstimationPage.enter_contact_person(contactPerson);
	}

	@Step
	public void verify_contact_person(String expectedContactPerson) {
		assertThat(onProjectEstimationPage.get_text_contact_person(), equalTo(expectedContactPerson));
	}

	@Step
	/**
	 * @param contactAddress:
	 *            is address code or party address description
	 */
	public void enter_contact_address(String contactAddress) {
		onProjectEstimationPage.enter_contact_address(contactAddress);
	}

	@Step
	public String get_text_contact_address() {
		return onProjectEstimationPage.get_text_contact_address();
	}

	@Step
	public void verify_contact_address(String expectedContactAddress) {
		assertThat(onProjectEstimationPage.get_text_contact_address(), equalTo(expectedContactAddress));
	}

	@Step
	/**
	 * 
	 * @param projectCategory:
	 *            is project category code or project category description
	 */
	public void enter_project_category(String projectCategory) {
		onProjectEstimationPage.enter_project_category(projectCategory);
	}

	@Step
	public String get_text_project_category() {
		return onProjectEstimationPage.get_text_project_category();
	}

	@Step
	public void verify_project_category(String expectedProjectCategory) {
		assertThat(onProjectEstimationPage.get_text_project_category(), equalTo(expectedProjectCategory));
	}

	public void enter_project_class(String projectClass) {
		onProjectEstimationPage.enter_project_class(projectClass);
	}

	@Step
	public String get_text_project_class() {
		return onProjectEstimationPage.get_text_project_class();
	}

	@Step
	public void verify_project_class(String expectedProjectClass) {
		assertThat(onProjectEstimationPage.get_text_project_class(), equalTo(expectedProjectClass));
	}

	@Step
	/**
	 * 
	 * @param sbu:
	 *            can be sbu code or sbu description
	 */
	public void enter_sbu(String sbu) {
		onProjectEstimationPage.enter_sbu(sbu);
	}

	@Step
	public String get_text_sbu() {
		return onProjectEstimationPage.get_text_sbu();
	}

	@Step
	public void verify_sbu(String expectedSbu) {
		assertThat(onProjectEstimationPage.get_text_sbu(), equalTo(expectedSbu));
	}

	@Step
	public void enter_downpayment_amt(String downpaymentAmt) {
		onProjectEstimationPage.enter_downpayment_amt(downpaymentAmt);
	}

	@Step
	public String get_text_downpayment_amt() {
		return onProjectEstimationPage.get_text_downpayment_amt();
	}

	@Step
	public void verify_downpayment_amt(String expected) {
		assertThat(onProjectEstimationPage.get_text_downpayment_amt(), equalTo(expected));
	}

	@Step
	public void enter_downpayment_percent(String downpaymentPercent) {
		onProjectEstimationPage.enter_downpayment_percent(downpaymentPercent);
	}

	@Step
	public String get_text_downpayment_percent() {
		return onProjectEstimationPage.get_text_downpayment_percent();
	}

	@Step
	public void verify_downpayment_percent(String expected) {
		assertThat(onProjectEstimationPage.get_text_downpayment_percent(), equalTo(expected));
	}

	@Step
	public void enter_progressive_retention(String progressiveRetention) {
		onProjectEstimationPage.enter_progressive_retention(progressiveRetention);
	}

	@Step
	public String get_text_progressive_retention() {
		return onProjectEstimationPage.get_text_progressive_retention();
	}

	@Step
	public void verify_progressive_retention(String expected) {
		assertThat(onProjectEstimationPage.get_text_progressive_retention(), equalTo(expected));
	}

	@Step
	public void enter_max_retention_amt(String maxRetentionAmt) {
		onProjectEstimationPage.enter_max_retention_amt(maxRetentionAmt);
	}

	@Step
	public String get_text_max_retention_amt() {
		return onProjectEstimationPage.get_text_max_retention_amt();
	}

	@Step
	public void verify_retention_amt(String expected) {
		assertThat(onProjectEstimationPage.get_text_max_retention_amt(), equalTo(expected));
	}

	@Step
	public void enter_max_retention_percent(String maxRetentionPercent) {
		onProjectEstimationPage.enter_max_retention_percent(maxRetentionPercent);
	}

	@Step
	public String get_text_max_retention_percent() {
		return onProjectEstimationPage.get_text_max_retention_percent();
	}

	@Step
	public void verify_max_retention_percent(String expected) {
		assertThat(onProjectEstimationPage.get_text_max_retention_percent(), equalTo(expected));
	}

	@Step
	public void verify_max_retention_amt(String expected) {
		assertThat(onProjectEstimationPage.get_text_max_retention_amt(), equalTo(expected));
	}

	@Step
	public void enter_retention_due_date_days(String retentionDays) {
		onProjectEstimationPage.enter_retention_due_date_days(retentionDays);
	}

	@Step
	public String get_text_retention_due_date_days() {
		return onProjectEstimationPage.get_text_retention_due_date_days();
	}

	@Step
	public void verify_retention_due_date_days(String expected) {
		assertThat(onProjectEstimationPage.get_text_retention_due_date_days(), equalTo(expected));
	}

	@Step
	public void enter_retention_due_date_due_on(String retentionDueDate) {
		onProjectEstimationPage.enter_retention_due_date_due_on(retentionDueDate);
	}

	@Step
	public String get_text_retention_due_date_due_on() {
		return onProjectEstimationPage.get_text_retention_due_date_due_on();
	}

	@Step
	public void verify_retention_due_date_due_on(String expected) {
		assertThat(onProjectEstimationPage.get_text_retention_due_date_due_on(), equalTo(expected));
	}

	@Step
	/**
	 * 
	 * @param inventoryLoadingLocation:
	 *            can be location code or location name
	 */
	public void enter_inventory_loading_location(String inventoryLoadingLocation) {
		onProjectEstimationPage.enter_inventory_loading_location(inventoryLoadingLocation);
	}

	@Step
	public String get_text_inventory_loading_location() {
		return onProjectEstimationPage.get_text_inventory_loading_location();
	}

	@Step
	public void verify_inventory_loading_location(String expected) {
		assertThat(onProjectEstimationPage.get_text_inventory_loading_location(), equalTo(expected));
	}

	@Step
	public void enter_tolerable_variance(String tolerableVariance) {
		onProjectEstimationPage.enter_tolerable_variance(tolerableVariance);
	}

	@Step
	public String get_text_tolerable_variance() {
		return onProjectEstimationPage.get_text_tolerable_variance();
	}

	@Step
	public void verify_tolerable_variance(String expected) {
		assertThat(onProjectEstimationPage.get_text_tolerable_variance(), equalTo(expected));
	}

	public void click_btn_add_main_phase() {
		onProjectEstimationPage.click_btn_add_main_phase();
	}

	@Step
	public void click_btn_import_data_from_excel() {
		onProjectEstimationPage.click_btn_import_data_from_excel();
	}

	@Step
	public void click_btn_costing_sheet() {
		onProjectEstimationPage.click_btn_costing_sheet();
	}

	@Step
	public void click_btn_back_to_phase_details() {
		onProjectEstimationPage.click_btn_back_to_phase_details();
	}

	@Step
	public void click_on_phase_no_in_costing_sheet(String phaseNo) {
		onProjectEstimationPage.click_on_phase_no_in_costing_sheet(phaseNo);
	}

	@Step
	public String get_text_budget_cost_in_costing_sheet(String phaseNo) {
		return onProjectEstimationPage.get_text_budget_cost_in_costing_sheet(phaseNo);
	}

	@Step
	public void verify_budget_cost_in_costing_sheet(String phaseNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_budget_cost_in_costing_sheet(phaseNo), equalTo(expected));
	}

	@Step
	public void click_btn_add_drawing_object() {
		onProjectEstimationPage.click_btn_add_drawing_object();
	}

	@Step
	public void click_btn_delete_drawing_object() {
		onProjectEstimationPage.click_btn_delete_drawing_object();
		onProjectEstimationPage.chooseYesOnConfirmationPanel();
	}

	@Step
	public void select_in_drawing_object_type(String drawingObjectNo, String drawingObjectType) {
		onProjectEstimationPage.select_in_drawing_object_type(drawingObjectNo, drawingObjectType);
	}

	@Step
	public String get_text_drawing_object_type(String drawingObjectNo) {
		return onProjectEstimationPage.get_text_drawing_object_type(drawingObjectNo);
	}

	@Step
	public void verify_drawing_object_type(String drawingObjectNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_drawing_object_type(drawingObjectNo), equalTo(expected));
	}

	@Step
	public void enter_item_code_by_description(String itemNo, String itemCodeDescription) {
		onProjectEstimationPage.enter_item_code_by_description(itemNo, itemCodeDescription);
	}

	@Step
	public String get_text_item_code(String rowIndex) {
		return onProjectEstimationPage.get_text_item_code(rowIndex);
	}

	@Step
	public void verify_item_code(String rowIndex, String expected) {
		assertThat(onProjectEstimationPage.get_text_item_code(rowIndex), equalTo(expected));
	}

	@Step
	public String get_text_item_code_description(String drawingObjectNo) {
		return onProjectEstimationPage.get_text_item_code_description(drawingObjectNo);
	}

	@Step
	public void verify_item_code_description(String drawingObjectNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_item_code_description(drawingObjectNo), equalTo(expected));
	}

	@Step
	public void enter_item_remarks(String drawingObjectNo, String itemRemarks) {
		onProjectEstimationPage.enter_item_remarks(drawingObjectNo, itemRemarks);
	}

	@Step
	public String get_text_item_remarks(String drawingObjectNo) {
		return onProjectEstimationPage.get_text_item_remarks(drawingObjectNo);
	}

	@Step
	public void verify_item_remarks(String drawingObjectNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_item_remarks(drawingObjectNo), equalTo(expected));
	}

	@Step
	public void enter_drawing_object_qty(String drawingObjectNo, String qty) {
		onProjectEstimationPage.enter_drawing_object_qty(drawingObjectNo, qty);
	}

	@Step
	public String get_text_drawing_object_qty(String drawingObjectNo) {
		return onProjectEstimationPage.get_text_drawing_object_qty(drawingObjectNo);
	}

	@Step
	public void verify_drawing_object_qty(String drawingObjectNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_drawing_object_qty(drawingObjectNo), equalTo(expected));
	}

	@Step
	public String get_text_drawing_object_uom(String drawingObjectNo) {
		return onProjectEstimationPage.get_text_drawing_object_uom(drawingObjectNo);
	}

	@Step
	public void verify_drawing_object_uom(String drawingObjectNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_drawing_object_uom(drawingObjectNo), equalTo(expected));
	}

	@Step
	public void enter_drawing_object_unit_cost(String drawingObjectNo, String unitCost) {
		onProjectEstimationPage.enter_drawing_object_unit_cost(drawingObjectNo, unitCost);
	}

	@Step
	public String get_text_unit_cost(String drawingObjectNo) {
		return onProjectEstimationPage.get_text_unit_cost(drawingObjectNo);
	}

	@Step
	public void verify_unit_cost(String drawingObjectNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_unit_cost(drawingObjectNo), equalTo(expected));
	}

	@Step
	public void enter_drawing_object_markup_percent(String drawingObjectNo, String markupPercent) {
		onProjectEstimationPage.enter_drawing_object_markup_percent(drawingObjectNo, markupPercent);
	}

	@Step
	public String get_text_drawing_object_markup_percent(String drawingObjectNo) {
		return onProjectEstimationPage.get_text_drawing_object_markup_percent(drawingObjectNo);
	}

	@Step
	public void verify_drawing_object_markup_percent(String drawingObjectNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_drawing_object_markup_percent(drawingObjectNo), equalTo(expected));
	}

	@Step
	public String get_text_drawing_object_budget_cost(String drawingObjectNo) {
		return onProjectEstimationPage.get_text_drawing_object_budget_cost(drawingObjectNo);
	}

	@Step
	public void verify_drawing_object_budget_cost(String drawingObjectNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_drawing_object_budget_cost(drawingObjectNo), equalTo(expected));
	}

	@Step
	public void check_drawing_object(String drawingObject) {
		onProjectEstimationPage.check_drawing_object(drawingObject);
	}

	@Step
	public void uncheck_drawing_object(String drawingObject) {
		onProjectEstimationPage.uncheck_drawing_object(drawingObject);
	}

	@Step
	public boolean is_checked_drawing_object(String drawingObject) {
		return onProjectEstimationPage.is_checked_drawing_object(drawingObject);
	}

	@Step
	public void expand_phase(String phaseNo) {
		onProjectEstimationPage.expand_phase(phaseNo);
	}

	@Step
	public void enter_phase_desc_or_remarks(String phaseNo, String phaseDescOrRemarks) {
		onProjectEstimationPage.enter_phase_desc_or_remarks(phaseNo, phaseDescOrRemarks);
	}

	@Step
	public String get_text_phase_desc_or_remarks(String phaseNo) {
		return onProjectEstimationPage.get_text_phase_desc_or_remarks(phaseNo);
	}

	@Step
	public void verify_phase_desc_or_remarks(String phaseNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_phase_desc_or_remarks(phaseNo), equalTo(expected));
	}

	@Step
	public void enter_workhead_group(String phaseNo, String workheadGroup) {
		onProjectEstimationPage.enter_workhead_group(phaseNo, workheadGroup);
	}

	@Step
	public String get_text_workhead_group(String phaseNo) {
		return onProjectEstimationPage.get_text_workhead_group(phaseNo);
	}

	@Step
	public void verify_workhead_group(String phaseNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_workhead_group(phaseNo), equals(expected));
	}

	@Step
	public void enter_qty(String phaseNo, String qty) {
		onProjectEstimationPage.enter_qty(phaseNo, qty);
	}

	@Step
	public String get_text_qty(String phaseNo) {
		return onProjectEstimationPage.get_text_qty(phaseNo);
	}

	@Step
	public void verify_qty(String phaseNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_qty(phaseNo), equalTo(expected));
	}

	@Step
	public void enter_uom(String phaseNo, String uom) {
		onProjectEstimationPage.enter_uom(phaseNo, uom);
	}

	@Step
	public String get_text_uom(String phaseNo) {
		return onProjectEstimationPage.get_text_uom(phaseNo);
	}

	@Step
	public void verify_text_uom(String phaseNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_uom(phaseNo), equalTo(expected));
	}

	@Step
	public void enter_unit_price(String phaseNo, String unitPrice) {
		onProjectEstimationPage.enter_unit_price(phaseNo, unitPrice);
	}

	@Step
	public String get_text_unit_price(String phaseNo) {
		return onProjectEstimationPage.get_text_unit_price(phaseNo);
	}

	@Step
	public void verify_unit_price(String phaseNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_unit_price(phaseNo), equalTo(expected));
	}

	@Step
	public void enter_disc_percent(String phaseNo, String discPercent) {
		onProjectEstimationPage.enter_disc_percent(phaseNo, discPercent);
	}

	@Step
	public String get_text_disc_percent(String phaseNo) {
		return onProjectEstimationPage.get_text_disc_percent(phaseNo);
	}

	@Step
	public void verify_disc_percent(String phaseNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_disc_percent(phaseNo), equalTo(expected));
	}

	@Step
	public void enter_disc_amt(String phaseNo, String discAmt) {
		onProjectEstimationPage.enter_disc_amt(phaseNo, discAmt);
	}

	@Step
	public String get_text_disc_amt(String phaseNo) {
		return onProjectEstimationPage.get_text_disc_amt(phaseNo);
	}

	@Step
	public void verify_disc_amt(String phaseNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_disc_amt(phaseNo), equalTo(expected));
	}

	@Step
	public String get_text_phase_value(String phaseNo) {
		return onProjectEstimationPage.get_text_phase_value(phaseNo);
	}

	@Step
	public void verify_phase_value(String phaseNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_phase_value(phaseNo), equalTo(expected));
	}

	@Step
	public void enter_budget_cost(String phaseNo, String budgetCost) {
		onProjectEstimationPage.enter_budget_cost(phaseNo, budgetCost);
	}

	@Step
	public String get_text_budget_cost(String phaseNo) {
		return onProjectEstimationPage.get_text_budget_cost(phaseNo);
	}

	@Step
	public void verify_budget_cost(String phaseNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_budget_cost(phaseNo), equalTo(expected));
	}

	@Step
	public String get_text_budget_profit(String phaseNo) {
		return onProjectEstimationPage.get_text_budget_profit(phaseNo);
	}

	@Step
	public void verify_budget_profit(String phaseNo, String expected) {
		if (onProjectEstimationPage.get_text_budget_profit(phaseNo).contains(expected)) {
			assertThat(true, equalTo(true));
		} else {
			assertThat(true, equalTo(false));
		}
	}

	@Step
	public void enter_margin_percent(String phaseNo, String marginPercent) {
		onProjectEstimationPage.enter_margin_percent(phaseNo, marginPercent);
	}

	@Step
	public String get_text_margin_percent(String phaseNo) {
		return onProjectEstimationPage.get_text_margin_percent(phaseNo);
	}

	@Step
	public void verify_margin_percent(String phaseNo, String expected) {
		if (onProjectEstimationPage.get_text_margin_percent(phaseNo).contains(expected)) {
			assertThat(true, equalTo(true));
		} else {
			assertThat(true, equalTo(false));
		}
	}

	@Step
	public void pick_date_to_complete(String phaseNo, String dateToComplete) {
		onProjectEstimationPage.pick_date_to_complete(phaseNo, dateToComplete);
	}

	@Step
	public String get_text_date_to_complete(String phaseNo) {
		return onProjectEstimationPage.get_text_date_to_complete(phaseNo);
	}

	@Step
	public void verify_date_to_complete(String phaseNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_date_to_complete(phaseNo), equalTo(expected));
	}

	@Step
	public void enter_liquidated_damage_remarks_for_a_phase(String phaseNo, String liquidatedDamageRemarks) {
		onProjectEstimationPage.enter_liquidated_damage_remarks_for_a_phase(phaseNo, liquidatedDamageRemarks);
	}

	@Step
	public String get_text_liquidated_damage_remarks(String phaseNo) {
		return onProjectEstimationPage.get_text_liquidated_damage_remarks(phaseNo);
	}

	@Step
	public void verify_liquidated_damage_remarks(String phaseNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_liquidated_damage_remarks(phaseNo), equalTo(expected));
	}

	@Step
	public void click_btn_add_subphase(String toParentPhaseNo) {
		onProjectEstimationPage.click_btn_add_subphase(toParentPhaseNo);
	}

	@Step
	/**
	 * Description: if phaseNo = 1, add a main phase, if phaseNo = 1.1, add a
	 * subphase to phase 1
	 * 
	 * @param phaseNo
	 */
	public void add_a_phase(String phaseNo) {
		String parentPhaseNo = onProjectEstimationPage.get_parent_phase(phaseNo);
		if (parentPhaseNo.isEmpty()) {
			onProjectEstimationPage.click_btn_add_main_phase();
		} else {
			onProjectEstimationPage.click_btn_add_subphase(parentPhaseNo);
		}
	}

	@Step
	public void click_btn_delete_phase(String phaseNo) {
		onProjectEstimationPage.click_btn_delete_phase(phaseNo);
		onProjectEstimationPage.chooseYesOnConfirmationPanel();
	}

	@Step
	public void click_btn_move_phase_down_one_level(String phaseNo) {
		onProjectEstimationPage.click_btn_move_phase_down_one_level(phaseNo);
	}

	@Step
	public void click_btn_move_phase_up_one_level(String phaseNo) {
		onProjectEstimationPage.click_btn_move_phase_up_one_level(phaseNo);
	}

	@Step
	public void click_btn_shift_phase(String phaseNo, String toPhaseNo) {
		onProjectEstimationPage.click_btn_shift_phase(phaseNo, toPhaseNo);
	}

	@Step
	public void enter_currency(String currency) {
		onProjectEstimationPage.enter_currency(currency);
	}

	@Step
	public String get_text_currency() {
		return onProjectEstimationPage.get_text_currency();
	}

	@Step
	public void verify_currency(String expected) {
		assertThat(onProjectEstimationPage.get_text_currency(), equalTo(expected));
	}

	@Step
	public String get_text_exch_rate() {
		return onProjectEstimationPage.get_text_exch_rate();
	}

	@Step
	public void verify_exch_rate(String expected) {
		assertThat(onProjectEstimationPage.get_text_exch_rate(), equalTo(expected));
	}

	@Step
	public String get_text_nature_project_sum() {
		return onProjectEstimationPage.get_text_nature_project_sum();
	}

	@Step
	public void verify_nature_project_sum(String expected) {
		assertThat(onProjectEstimationPage.get_text_nature_project_sum(), equalTo(expected));
	}

	@Step
	public String get_text_home_project_sum() {
		return onProjectEstimationPage.get_text_home_project_sum();
	}

	@Step
	public void verify_home_project_sum(String expected) {
		assertThat(onProjectEstimationPage.get_text_home_project_sum(), equalTo(expected));
	}

	@Step
	public String get_text_nature_project_budget_cost() {
		return onProjectEstimationPage.get_text_nature_project_budget_cost();
	}

	@Step
	public void verify_nature_project_budget_cost(String expected) {
		assertThat(onProjectEstimationPage.get_text_nature_project_budget_cost(), equalTo(expected));
	}

	@Step
	public String get_text_home_project_budget_cost() {
		return onProjectEstimationPage.get_text_home_project_budget_cost();
	}

	@Step
	public void verify_home_project_budget_cost(String expected) {
		assertThat(onProjectEstimationPage.get_text_home_project_budget_cost(), equalTo(expected));
	}

	@Step
	public String get_text_nature_project_budget_profit() {
		return onProjectEstimationPage.get_text_nature_project_budget_profit();
	}

	@Step
	public void verify_nature_project_budget_profit(String expected) {
		assertThat(onProjectEstimationPage.get_text_nature_project_budget_profit(), equalTo(expected));
	}

	@Step
	public String get_text_home_project_budget_profit() {
		return onProjectEstimationPage.get_text_home_project_budget_profit();
	}

	@Step
	public void verify_home_project_budget_profit(String expected) {
		assertThat(onProjectEstimationPage.get_text_home_project_budget_profit(), equalTo(expected));
	}

	@Step
	public String get_text_project_budget_percent() {
		return onProjectEstimationPage.get_text_project_budget_percent();
	}

	@Step
	public void verify_project_budget_percent(String expected) {
		assertThat(onProjectEstimationPage.get_text_project_budget_percent(), equalTo(expected));
	}

	@Step
	public void enter_sales_tax(String salesTax) {
		onProjectEstimationPage.enter_sales_tax(salesTax);
	}

	@Step
	public String get_text_sales_tax() {
		return onProjectEstimationPage.get_text_sales_tax();
	}

	@Step
	public void verify_sales_tax(String expected) {
		assertThat(onProjectEstimationPage.get_text_sales_tax(), equalTo(expected));
	}

	@Step
	public String get_text_home_sales_tax() {
		return onProjectEstimationPage.get_text_home_sales_tax();
	}

	@Step
	public void verify_home_sales_tax(String expected) {
		assertThat(onProjectEstimationPage.get_text_home_sales_tax(), equalTo(expected));
	}

	@Step
	public String get_text_nature_sales_tax() {
		return onProjectEstimationPage.get_text_nature_sales_tax();
	}

	@Step
	public void verify_nature_sales_tax(String expected) {
		assertThat(onProjectEstimationPage.get_text_nature_sales_tax(), equalTo(expected));
	}

	@Step
	public String get_text_nature_project_value_incl_tax() {
		return onProjectEstimationPage.get_text_nature_project_value_incl_tax();
	}

	@Step
	public void verify_nature_project_value_incl_tax(String expected) {
		assertThat(onProjectEstimationPage.get_text_nature_project_value_incl_tax(), equalTo(expected));
	}

	@Step
	public String get_text_home_project_value_incl_tax() {
		return onProjectEstimationPage.get_text_home_project_value_incl_tax();
	}

	@Step
	public void verify_home_project_value_incl_tax(String expected) {
		assertThat(onProjectEstimationPage.get_text_home_project_value_incl_tax(), equalTo(expected));
	}

	// Team members
	@Step
	public void click_btn_add_employees() {
		onProjectEstimationPage.click_btn_add_employees();
	}

	@Step
	public void click_btn_delete_employees() {
		onProjectEstimationPage.click_btn_delete_employees();
	}

	@Step
	public void click_btn_view_by_role(String viewByRole) {
		onProjectEstimationPage.click_btn_view_by_role(viewByRole);
	}

	@Step
	public void enter_employee(String employeeName, String rowIndex) {
		onProjectEstimationPage.enter_employee(employeeName, rowIndex);
	}

	/**
	 * Description: Enter employee code to the last row
	 * 
	 * @param employeeName
	 */
	@Step
	public void enter_employee(String employeeName) {
		onProjectEstimationPage.enter_employee(employeeName);
	}

	@Step
	public void check_role_in_project_with_employee_name(String employeeName, String chkboxLabelList) {
		onProjectEstimationPage.check_role_in_project_with_employee_name(employeeName, chkboxLabelList);
	}

	@Step
	public boolean is_checked_role_in_project_with_employee_name(String employeeName, String chkboxLabelList) {
		return onProjectEstimationPage.is_checked_role_in_project_with_employee_name(employeeName, chkboxLabelList);
	}

	@Step
	public void make_key_person(String employeeName, String roleNameList) {
		onProjectEstimationPage.make_key_person(employeeName, roleNameList);
	}

	@Step
	public boolean is_made_key_person(String employeeName, String roleNameList) {
		return onProjectEstimationPage.is_made_key_person(employeeName, roleNameList);
	}

	@Step
	public void check_employee(String employeeCode) {
		onProjectEstimationPage.check_employee(employeeCode);
	}

	@Step
	public void select_in_billing_type(String billingType) {
		onProjectEstimationPage.select_in_billing_type(billingType);
	}

	@Step
	public String get_text_billing_type() {
		return onProjectEstimationPage.get_text_billing_type();
	}

	@Step
	public void verify_billing_type(String expected) {
		assertThat(onProjectEstimationPage.get_text_billing_type(), equalTo(expected));
	}

	@Step
	public void enter_cutoff_date(String cutoffDate) {
		onProjectEstimationPage.enter_cutoff_date(cutoffDate);
	}

	@Step
	public String get_text_cutoff_date() {
		return onProjectEstimationPage.get_text_cutoff_date();
	}

	@Step
	public void verify_cutoff_date(String expected) {
		assertThat(onProjectEstimationPage.get_text_cutoff_date(), equalTo(expected));
	}

	@Step
	/**
	 * 
	 * @param billingParty:
	 *            can be customer code or customer name
	 */
	public void enter_billing_party(String billingParty) {
		onProjectEstimationPage.enter_billing_party(billingParty);
	}

	@Step
	public String get_text_billing_party() {
		return onProjectEstimationPage.get_text_billing_party();
	}

	@Step
	public void verify_billing_party(String expected) {
		assertThat(onProjectEstimationPage.get_text_billing_party(), equalTo(expected));
	}

	@Step
	public void enter_billing_contact(String billingContact) {
		onProjectEstimationPage.enter_billing_contact(billingContact);
	}

	@Step
	public String get_text_billing_contact() {
		return onProjectEstimationPage.get_text_billing_contact();
	}

	@Step
	public void verify_billing_contact(String expected) {
		assertThat(onProjectEstimationPage.get_text_billing_contact(), equalTo(expected));
	}

	@Step
	/**
	 * 
	 * @param billingAddress:
	 *            can be address code or party address description
	 */
	public void enter_billing_address(String billingAddress) {
		onProjectEstimationPage.enter_billing_address(billingAddress);
	}

	@Step
	public String get_text_billing_address() {
		return onProjectEstimationPage.get_text_billing_address();
	}

	@Step
	public void verify_billing_address(String expected) {
		assertThat(onProjectEstimationPage.get_text_billing_address(), equalTo(expected));
	}

	@Step
	public void select_in_payment_option(String paymentOption) {
		onProjectEstimationPage.select_in_payment_option(paymentOption);
	}

	@Step
	public void verify_payment_option(String expected) {
		assertThat(onProjectEstimationPage.get_text_payment_option(), equals(expected));
	}

	@Step
	public void select_in_payment_term(String paymentTerm) {
		onProjectEstimationPage.select_in_payment_term(paymentTerm);
	}

	@Step
	public void verify_payment_term(String expected) {
		assertThat(onProjectEstimationPage.get_text_payment_term(), equalTo(expected));
	}

	@Step
	public void select_in_payment_method(String paymentMethod) {
		onProjectEstimationPage.select_in_payment_method(paymentMethod);
	}

	@Step
	public void verify_payment_method(String expected) {
		assertThat(onProjectEstimationPage.get_text_payment_method(), equalTo(expected));
	}

	@Step
	public void enter_payment_tenor(String paymentTenor) {
		onProjectEstimationPage.enter_payment_tenor(paymentTenor);
	}

	@Step
	public String get_text_payment_tenor() {
		return onProjectEstimationPage.get_text_payment_tenor();
	}

	@Step
	public void verify_payment_tenor(String expected) {
		assertThat(onProjectEstimationPage.get_text_payment_tenor(), equalTo(expected));
	}

	@Step
	public void enter_tenor_term(String tenorTerm) {
		onProjectEstimationPage.enter_tenor_term(tenorTerm);
	}

	@Step
	public String get_text_tenor_term() {
		return onProjectEstimationPage.get_text_tenor_term();
	}

	@Step
	public void verify_tenor_term(String expected) {
		assertThat(onProjectEstimationPage.get_text_tenor_term(), equalTo(expected));
	}

	@Step
	public void click_btn_add_bonds() {
		onProjectEstimationPage.click_btn_add_bonds();
	}

	@Step
	public void click_btn_delete_bonds(String deleteBonds) {
		onProjectEstimationPage.click_btn_delete_bonds(deleteBonds);
	}

	@Step
	public void pick_start_date_with_bond_ref_no(String startDate, String bondRefNo) {
		onProjectEstimationPage.pick_start_date_with_bond_ref_no(startDate, bondRefNo);
	}

	@Step
	public String get_text_start_date_with_bond_ref_no(String bondRefNo) {
		return onProjectEstimationPage.get_text_start_date_with_bond_ref_no(bondRefNo);
	}

	@Step
	public void verify_start_date_with_bond_ref_no(String bondRefNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_start_date_with_bond_ref_no(bondRefNo), equalTo(expected));
	}

	@Step
	public void pick_end_date_with_bond_ref_no(String endDate, String bondRefNo) {
		onProjectEstimationPage.pick_end_date_with_bond_ref_no(endDate, bondRefNo);
	}

	@Step
	public String get_text_end_date_with_bond_ref_no(String bondRefNo) {
		return onProjectEstimationPage.get_text_end_date_with_bond_ref_no(bondRefNo);
	}

	@Step
	public void verify_end_date_with_bond_ref_no(String bondRefNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_end_date_with_bond_ref_no(bondRefNo), equalTo(expected));
	}

	@Step
	/**
	 * 
	 * @param issuingParty:
	 *            can be party code or party name
	 * @param bondRefNo
	 */
	public void enter_issuing_party_with_bond_ref_no(String issuingParty, String bondRefNo) {
		onProjectEstimationPage.enter_issuing_party_with_bond_ref_no(issuingParty, bondRefNo);
	}

	@Step
	public String get_text_issuing_party_with_bond_ref_no(String bondRefNo) {
		return onProjectEstimationPage.get_text_issuing_party_with_bond_ref_no(bondRefNo);
	}

	@Step
	public void verify_issuing_party_with_bond_ref_no(String bondRefNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_issuing_party_with_bond_ref_no(bondRefNo), equalTo(expected));
	}

	@Step
	public void enter_bond_ref_no(String bondRefNo) {
		onProjectEstimationPage.enter_bond_ref_no(bondRefNo);
	}

	@Step
	public void enter_bond_dlp_with_bond_ref_no(String dlp, String bondRefNo) {
		onProjectEstimationPage.enter_bond_dlp_with_bond_ref_no(dlp, bondRefNo);
	}

	@Step
	public String get_text_bond_dlp_with_bond_ref_no(String bondRefNo) {
		return onProjectEstimationPage.get_text_bond_dlp_with_bond_ref_no(bondRefNo);
	}

	@Step
	public void verify_bond_dlp_with_bond_ref_no(String bondRefNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_bond_dlp_with_bond_ref_no(bondRefNo), equalTo(expected));
	}

	@Step
	public void pick_actual_expiry_date_with_bond_ref_no(String actualExpiryDate, String bondRefNo) {
		onProjectEstimationPage.pick_actual_expiry_date_with_bond_ref_no(actualExpiryDate, bondRefNo);
	}

	@Step
	public String get_text_actual_expiry_date_with_bond_ref_no(String bondRefNo) {
		return onProjectEstimationPage.get_text_actual_expiry_date_with_bond_ref_no(bondRefNo);
	}

	@Step
	public void verify_actual_expiry_date_with_bond_ref_no(String bondRefNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_actual_expiry_date_with_bond_ref_no(bondRefNo), equalTo(expected));
	}

	@Step
	public void enter_remarks_with_bond_ref_no(String remarks, String bondRefNo) {
		onProjectEstimationPage.enter_remarks_with_bond_ref_no(remarks, bondRefNo);
	}

	@Step
	public String get_text_remarks_with_bond_ref_no(String bondRefNo) {
		return onProjectEstimationPage.get_text_remarks_with_bond_ref_no(bondRefNo);
	}

	@Step
	public void verify_remarks_with_bond_ref_no(String bondRefNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_remarks_with_bond_ref_no(bondRefNo), equalTo(expected));
	}

	@Step
	public void check_bond_with_bond_ref_no(String bondRefNo) {
		onProjectEstimationPage.check_bond_with_bond_ref_no(bondRefNo);
	}

	@Step
	public void click_btn_add_policies() {
		onProjectEstimationPage.click_btn_add_policies();
	}

	@Step
	public void click_btn_delete_policies() {
		onProjectEstimationPage.click_btn_delete_policies();
	}

	@Step
	public void enter_policy_no(String policyNo) {
		onProjectEstimationPage.enter_policy_no(policyNo);
	}

	@Step
	public String get_text_policy_no(String rowIndex) {
		return onProjectEstimationPage.get_text_policy_no(rowIndex);
	}

	@Step
	public void verify_policy_no(String rowIndex, String expected) {
		assertThat(onProjectEstimationPage.get_text_policy_no(rowIndex), equalTo(expected));
	}

	@Step
	public void enter_policy_type(String policyType) {
		onProjectEstimationPage.enter_policy_type(policyType);
	}

	@Step
	public String get_text_policy_type_with_policy_no(String policyNo) {
		return onProjectEstimationPage.get_text_policy_type_with_policy_no(policyNo);
	}

	@Step
	public void verify_policy_type_with_policy_no(String policyNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_policy_type_with_policy_no(policyNo), equalTo(expected));
	}

	@Step
	public void pick_policy_start_date(String startDate) {
		onProjectEstimationPage.pick_policy_start_date(startDate);
	}

	@Step
	public String get_text_start_date_with_policy_no(String policyNo) {
		return onProjectEstimationPage.get_text_start_date_with_policy_no(policyNo);
	}

	@Step
	public void verify_start_date_with_policy_no(String policyNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_start_date_with_policy_no(policyNo), equalTo(expected));
	}

	@Step
	public void pick_policy_end_date(String endDate) {
		onProjectEstimationPage.pick_policy_end_date(endDate);
	}

	@Step
	public String get_text_end_date_with_policy_no(String policyNo) {
		return onProjectEstimationPage.get_text_end_date_with_policy_no(policyNo);
	}

	@Step
	public void verify_end_date_with_policy_no(String policyNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_end_date_with_policy_no(policyNo), equalTo(expected));
	}

	@Step
	public void enter_insurance_company(String insuranceCompany) {
		onProjectEstimationPage.enter_insurance_company(insuranceCompany);
	}

	@Step
	public String get_text_insurance_company_with_policy_no(String policyNo) {
		return onProjectEstimationPage.get_text_insurance_company_with_policy_no(policyNo);
	}

	@Step
	public void verify_insurance_company_with_policy_no(String policyNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_insurance_company_with_policy_no(policyNo), equalTo(expected));
	}

	@Step
	public void check_insured_with_policy_no(String insuredBy, String policyNo) {
		onProjectEstimationPage.check_insured_with_policy_no(insuredBy, policyNo);
	}

	@Step
	public boolean is_checked_insured_with_policy_no(String insuredBy, String policyNo) {
		return onProjectEstimationPage.is_checked_insured_with_policy_no(insuredBy, policyNo);
	}

	@Step
	public void enter_policy_remarks(String remarks) {
		onProjectEstimationPage.enter_policy_remarks(remarks);
	}

	@Step
	public String get_text_policy_remarks_with_policy_no(String policyNo) {
		return onProjectEstimationPage.get_text_policy_remarks_with_policy_no(policyNo);
	}

	@Step
	public void verify_policy_remarks(String policyNo, String expected) {
		assertThat(onProjectEstimationPage.get_text_policy_remarks_with_policy_no(policyNo), equalTo(expected));
	}

	@Step
	public void check_policy_with_policy_no(String insurance) {
		onProjectEstimationPage.check_policy_with_policy_no(insurance);
	}

	@Step
	public void enter_subject_detail(String subjectDetail) {
		onProjectEstimationPage.enter_subject_detail(subjectDetail);
	}

	@Step
	public String get_text_subject_detail() {
		return onProjectEstimationPage.get_text_subject_detail();
	}

	@Step
	public void verify_subject_detail(String expected) {
		assertThat(onProjectEstimationPage.get_text_subject_detail(), equalTo(expected));
	}

	@Step
	public void enter_terms_and_condition(String termsAndCondition) {
		onProjectEstimationPage.enter_terms_and_condition(termsAndCondition);
	}

	@Step
	public String get_text_terms_and_condition() {
		return onProjectEstimationPage.get_text_terms_and_condition();
	}

	@Step
	public void verify_terms_and_condition(String expected) {
		assertThat(onProjectEstimationPage.get_text_terms_and_condition(), equalTo(expected));
	}

	@Step
	public void enter_internal_remarks(String internalRemarks) {
		onProjectEstimationPage.enter_internal_remarks(internalRemarks);
	}

	@Step
	public String get_text_internal_remarks() {
		return onProjectEstimationPage.get_text_internal_remarks();
	}

	@Step
	public void verify_internal_remarks(String expected) {
		assertThat(onProjectEstimationPage.get_text_internal_remarks(), equalTo(expected));
	}

	@Step
	public void enter_external_remarks(String externalRemarks) {
		onProjectEstimationPage.enter_external_remarks(externalRemarks);
	}

	@Step
	public String get_text_external_remarks() {
		return onProjectEstimationPage.get_text_external_remarks();
	}

	@Step
	public void verify_external_remarks(String expected) {
		assertThat(onProjectEstimationPage.get_text_external_remarks(), equalTo(expected));
	}

	@Step
	public void enter_liquidated_damage_remarks(String liquidatedDamageRemarks) {
		onProjectEstimationPage.enter_liquidated_damage_remarks(liquidatedDamageRemarks);
	}

	@Step
	public String get_text_liquidated_damage_remarks() {
		return onProjectEstimationPage.get_text_liquidated_damage_remarks();
	}

	@Step
	public void verify_liquidated_damage_remarks(String expected) {
		assertThat(onProjectEstimationPage.get_text_liquidated_damage_remarks(), equalTo(expected));
	}

	@Step
	public void add_a_file(String fileName) {
		onProjectEstimationPage.add_a_file(fileName);
	}

	@Step
	public void click_btn_delete_files(String deleteFiles) {
		onProjectEstimationPage.click_btn_delete_files(deleteFiles);
	}

	@Step
	public String get_text_file_name(String rowIndex) {
		return onProjectEstimationPage.get_text_file_name(rowIndex);
	}

	@Step
	public void verify_file_name(String rowIndex, String expected) {
		assertThat(onProjectEstimationPage.get_text_file_name(rowIndex), equalTo(expected));
	}

	@Step
	public void enter_file_description(String fileDescription, int rowIndex) {
		onProjectEstimationPage.enter_file_description(fileDescription, rowIndex);
	}

	@Step
	public String get_text_file_description(String rowIndex) {
		return onProjectEstimationPage.get_text_file_description(rowIndex);
	}

	@Step
	public void verify_file_description(String rowIndex, String expected) {
		assertThat(onProjectEstimationPage.get_text_file_description(rowIndex), equalTo(expected));
	}

	@Step
	public String get_text_mime_type(String rowIndex) {
		return onProjectEstimationPage.get_text_mime_type(rowIndex);
	}

	@Step
	public String get_text_file_size(String rowIndex) {
		return onProjectEstimationPage.get_text_file_size(rowIndex);
	}

	@Step
	public void verify_file_size(String rowIndex, String expected) {
		assertThat(onProjectEstimationPage.get_text_file_size(rowIndex), equalTo(expected));
	}

	@Step
	public void click_btn_dowload(String rowIndex) {
		onProjectEstimationPage.click_btn_dowload(rowIndex);
	}

	@Step
	public void check_file(String rowIndex) {
		onProjectEstimationPage.check_file(rowIndex);
	}

	// Summary screen
	/// Draft Tab
	@Step
	public boolean is_there_project_estimation_by_project_no(String projectNo) {
		return onProjectEstimationPage.is_there_project_estimation_by_project_no(projectNo);
	}

	@Step
    public void enter_exchange_rate(String rate) {
		onProjectEstimationPage.enterExchangeRate(rate);
    }

	@Step
	public void submit_the_project_order() {
		onProjectEstimationPage.click_btn_submit();
		onProjectEstimationPage.chooseYesOnConfirmationPanel();
	}

	@Step
	public void save_project_order_voucher() {
		onProjectEstimationPage.saveProjectOrderVoucher();

	}

	@Step
	public void enter_new_value_for_phase(String phaseNo, String newValues){
		String[] valuesArray = newValues.split(";");
		String value, label;
		String[] labelAndValue;
		for (String valueExpression: valuesArray){
			labelAndValue = valueExpression.split("=");
			label = labelAndValue[0];
			value = labelAndValue[1];
			switch(label){
			case "Qty":
				onProjectEstimationPage.enter_qty(phaseNo, value);
				break;
			case "Unit Price":
				onProjectEstimationPage.enter_unit_price(phaseNo, value);
				break;
			case "Budget Cost":
				onProjectEstimationPage.enter_budget_cost(phaseNo, value);
				break;
			}
		}
	}
}
