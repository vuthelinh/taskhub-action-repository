package com.synergix.mtsetup.administration.documentnumbering.steps;

import com.synergix.mtsetup.administration.documentnumbering.pages.ProcessingNumberingPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * @author Vincent
 * @version 20160121
 */
public class ProcessingNumberingSteps extends ScenarioSteps {
	ProcessingNumberingPage processingNumberingPage;

	public void switchToIFrame() {
		processingNumberingPage.switchToIFrame();
	}

	public void switchOutDefaultIFrame() {
		processingNumberingPage.switchOutDefaultIFrame();
	}

	@Step
	public void click_btn_close() {
		processingNumberingPage.click_btn_close();
	}

	@Step
	public void enter_module_code(String _moduleCode) {
		processingNumberingPage.enter_module_code(_moduleCode);
	}

	@Step
	public void enter_module_desc(String _moduleDesc) {
		processingNumberingPage.enter_module_desc(_moduleDesc);
	}

	@Step
	public void enter_transaction_type_code(String _transactionTypeCode) {
		processingNumberingPage.enter_transaction_type_code(_transactionTypeCode);
	}

	@Step
	public void enter_transaction_type_desc(String _transactionTypeDesc) {
		processingNumberingPage.enter_transaction_type_desc(_transactionTypeDesc);
	}

	@Step
	public int get_data_row_index_by_combine_text(String _givenAnyText) {
		return processingNumberingPage.get_data_row_index_by_combine_text(_givenAnyText);
	}

	@Step
	public void set_auto_number(int _rowIndex, String _autoNumber) {
		processingNumberingPage.set_auto_number(_rowIndex, _autoNumber);
	}

	@Step
	public void select_first_result_module() {
		processingNumberingPage.select_first_result_module();
	}

	@Step
	public void set_first_result_auto_number(String _autoNumber) {
		processingNumberingPage.set_first_result_auto_number(_autoNumber);
	}

	// Numbering Scheme
	@Step
	public void click_btn_ns_close() {
		processingNumberingPage.click_btn_ns_close();
	}

	@Step
	public void click_btn_ns_add() {
		processingNumberingPage.click_btn_ns_add();
	}

	@Step
	public void click_btn_ns_delete() {
		processingNumberingPage.click_btn_ns_delete();
	}

	@Step
	public void set_ns_auto_number(String _autoNumber) {
		processingNumberingPage.set_ns_auto_number(_autoNumber);
	}

	@Step
	public int enter_ns_new_numbering_scheme_code(String _numberingSchemeCode) {
		return processingNumberingPage.enter_ns_new_numbering_scheme_code(_numberingSchemeCode);
	}

	@Step
	public String enter_ns_numbering_scheme_code(String _numberingSchemeCode) {
		processingNumberingPage.enter_ns_numbering_scheme_code(_numberingSchemeCode);
		return processingNumberingPage.getErrorMessagesThenClickOK();
	}

	@Step
	public void enter_ns_description(int _rowIndex, String _description) {
		processingNumberingPage.enter_ns_description(_rowIndex, _description);
	}

	@Step
	public void set_ns_is_manual_numbering(int _rowIndex, String _isManualNumbering) {
		processingNumberingPage.set_ns_is_manual_numbering(_rowIndex, _isManualNumbering);
	}

	@Step
	public int search_ns_numbering_scheme_code(String _numberingSchemeCode) {
		return processingNumberingPage.search_ns_numbering_scheme_code(_numberingSchemeCode);
	}

	@Step
	public void select_numbering_scheme_code(String _numberingSchemeCode) {
		processingNumberingPage.select_numbering_scheme_code(_numberingSchemeCode);
	}

	@Step
	public void switch_to_tab_numbering_scheme_maintenance() {
		processingNumberingPage.switch_to_tab_numbering_scheme_maintenance();
	}

	@Step
	public void enter_ns_last_number(String _lastNumber) {
		processingNumberingPage.enter_ns_last_number(_lastNumber);
	}

	@Step
	public void enter_ns_prefix(String _prefix) {
		processingNumberingPage.enter_ns_prefix(_prefix);
	}

	@Step
	public void enter_ns_suffix(String _suffix) {
		processingNumberingPage.enter_ns_suffix(_suffix);
	}

	@Step
	public void enter_ns_fill_character(String _fillCharacter) {
		processingNumberingPage.enter_ns_fill_character(_fillCharacter);
	}

	@Step
	public void enter_ns_maximum_length_of_code(String _maximumLengthOfCode) {
		processingNumberingPage.enter_ns_maximum_length_of_code(_maximumLengthOfCode);
	}

	@Step
	public void enter_ns_length_of_code(String _lengthOfCode) {
		processingNumberingPage.enter_ns_length_of_code(_lengthOfCode);
	}

	@Step
	public void set_ns_allow_user_to_overwrite(String _allowUserToOverwrite) {
		processingNumberingPage.set_ns_allow_user_to_overwrite(_allowUserToOverwrite);
	}

	@Step
	public void enter_ns_device_id(String _deviceId) {
		processingNumberingPage.enter_ns_device_id(_deviceId);
	}

	// Tag Users To Numbering Scheme
	@Step
	public void switch_to_tab_tag_users_to_numbering_scheme() {
		processingNumberingPage.switch_to_tab_tag_users_to_numbering_scheme();
	}

	@Step
	public void click_btn_tag_user_insert() {
		processingNumberingPage.click_btn_tag_user_insert();
	}

	@Step
	public void click_btn_tag_user_add() {
		processingNumberingPage.click_btn_tag_user_add();
	}

	@Step
	public void click_btn_tag_user_delete() {
		processingNumberingPage.click_btn_tag_user_delete();
	}

	@Step
	public void enter_tag_user_testkey(String _testkey) {
		processingNumberingPage.enter_tag_user_testkey(_testkey);
	}

	@Step
	public void enter_tag_user_user_id_from(String _userIdFrom) {
		processingNumberingPage.enter_tag_user_user_id_from(_userIdFrom);
	}

	@Step
	public void enter_tag_user_user_id_to(String _userIdTo) {
		processingNumberingPage.enter_tag_user_user_id_to(_userIdTo);
	}

	@Step
	public void enter_tag_user_user_name_from(String _userNameFrom) {
		processingNumberingPage.enter_tag_user_user_name_from(_userNameFrom);
	}

	@Step
	public void enter_tag_user_user_name_to(String _userNameTo) {
		processingNumberingPage.enter_tag_user_user_name_to(_userNameTo);
	}

	@Step
	public int search_tag_user_by_user_id(String _userId) {
		return processingNumberingPage.search_tag_user_by_user_id(_userId);
	}

	@Step
	public void enter_tag_user_new_user_id(String _userId) {
		processingNumberingPage.enter_tag_user_new_user_id(_userId);
	}

	@Step
	public String enter_tag_user_user_id(String _userId) {
		processingNumberingPage.enter_tag_user_user_id(_userId);
		return processingNumberingPage.getErrorMessagesThenClickOK();
	}

	@Step
	public void enter_tag_user_new_user_name(String _userName) {
		processingNumberingPage.enter_tag_user_new_user_name(_userName);
	}

	@Step
	public String enter_tag_user_user_name(String _userName) {
		processingNumberingPage.enter_tag_user_user_name(_userName);
		return processingNumberingPage.getErrorMessagesThenClickOK();
	}

	@Step
	public void verify_tag_user_employee_code(String _userId, String _employeeCode) {
		processingNumberingPage.verify_tag_user_employee_code(_userId, _employeeCode);
	}

	@Step
	public void verify_tag_user_employee_name(String _userId, String _employeeName) {
		processingNumberingPage.verify_tag_user_employee_name(_userId, _employeeName);
	}
}
