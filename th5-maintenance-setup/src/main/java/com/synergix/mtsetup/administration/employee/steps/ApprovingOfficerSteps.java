package com.synergix.mtsetup.administration.employee.steps;

import com.synergix.mtsetup.administration.employee.pages.ApprovingOfficerPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

/**
 * Created by Ian on 8/5/2016.
 */
public class ApprovingOfficerSteps extends ScenarioSteps {
	private ApprovingOfficerPage approvingOfficerPage;

	// #Begin Region# Vincent
	@Step
	public void click_btn_add() {
		approvingOfficerPage.click_btn_add();
	}

	@Step
	public void filter_module_code_desc(String _moduleCodeDesc) {
		approvingOfficerPage.filter_module_code_desc(_moduleCodeDesc);
	}

	@Step
	public void filter_transaction_type_desc(String _transactionTypeDesc) {
		approvingOfficerPage.filter_transaction_type_desc(_transactionTypeDesc);
	}

	@Step
	public void select_first_transaction() {
		approvingOfficerPage.select_first_transaction();
	}

	@Step
	public void select_approving_method(int _rowIndex, String _approvingMethod) {
		approvingOfficerPage.select_approving_method(_rowIndex, _approvingMethod);
	}

	@Step
	public void select_reject_remarks_mandatory(int _rowIndex, String _rejectRemarksMandatory) {
		approvingOfficerPage.select_reject_remarks_mandatory(_rowIndex, _rejectRemarksMandatory);
	}

	@Step
	public void filter_sbu_code(String _sbuCode) {
		approvingOfficerPage.filter_sbu_code(_sbuCode);
	}

	@Step
	public void filter_sbu_desc(String _sbuDesc) {
		approvingOfficerPage.filter_sbu_desc(_sbuDesc);
	}

	@Step
	public void select_first_sbu() {
		approvingOfficerPage.select_first_sbu();
	}

	@Step
	public boolean add_approving_officer_by_employee_code(String _employeeCode) {
		boolean ret = true;
		approvingOfficerPage.add_approving_officer_by_employee_code(_employeeCode);
		String sErrMessage = approvingOfficerPage.getErrorMessagesThenClickOK();
		if (approvingOfficerPage.getErrorMessagesThenClickOK() != null) {
			if (sErrMessage.contains("Approving Officer already exists")) {
				System.out.println("***** WARNING **** Approving Officer already exists: " + _employeeCode);
			} else {
				ret = false;
			}
		}
		return ret;
	}

	@Step
	public int search_approving_officer(String _approvingOfficer) {
		return approvingOfficerPage.search_approving_officer(_approvingOfficer);
	}

	@Step
	public void verify_adding_approving_officer(String _approvingOfficer) {
		approvingOfficerPage.verify_adding_approving_officer(_approvingOfficer);
	}

	@Step
	public void enter_approval_home_amount_limit_per_voucher(String _approvingOfficer,
			String _approvalHomeAmountLimitPerVoucher, String _officeForSingleSupplier) {
		approvingOfficerPage.enter_approval_home_amount_limit_per_voucher(_approvingOfficer,
				_approvalHomeAmountLimitPerVoucher, _officeForSingleSupplier);
	}

	@Step
	public void enter_approval_home_amount_limit_per_voucher(String _approvingOfficer,
			String _approvalHomeAmountLimitPerVoucher) {
		approvingOfficerPage.enter_approval_home_amount_limit_per_voucher(_approvingOfficer,
				_approvalHomeAmountLimitPerVoucher);
	}

	@Step
	public void enter_approval_home_amount_limit_per_voucher_sbu(String _approvingOfficer,
			String _approvalHomeAmountLimitPerVoucher) {
		approvingOfficerPage.enter_approval_home_amount_limit_per_voucher_sbu(_approvingOfficer,
				_approvalHomeAmountLimitPerVoucher);
	}

	@Step
	public void verify_adding_approving_officer_in_AOSbu(String _approvingOfficer) {
		approvingOfficerPage.verify_adding_approving_officer_in_AOSbu(_approvingOfficer);
	}

	// Table adding SBU
	@Step
	public void click_btn_multi_by_sbu_add() {
		approvingOfficerPage.click_btn_multi_by_sbu_add();
	}

	@Step
	public void enter_new_sbu_code(String _SBUCode) {
		approvingOfficerPage.enter_new_sbu_code(_SBUCode);
	}

	@Step
	public void select_sbu_by_sbu_code(String _SBUCode) {
		approvingOfficerPage.select_sbu_by_sbu_code(_SBUCode);
	}

	// Approving Officer (Multiple Level)
	@Step
	public void click_btn_add_ao_in_multiple_level() {
		approvingOfficerPage.click_btn_add_ao_in_multiple_level();
	}

	@Step
	public void enter_mutiple_ao_level(String _level) {
		approvingOfficerPage.enter_mutiple_ao_level(_level);
	}

	@Step
	public void enter_mutiple_ao_approving_officer(String _approvingOfficer) {
		approvingOfficerPage.enter_mutiple_ao_approving_officer(_approvingOfficer);
	}

	// Layer Detail
	@Step
	public void click_btn_add_layer() {
		approvingOfficerPage.click_btn_add_layer();
	}

	@Step
	public int get_layer_row(String _layer) {
		return approvingOfficerPage.get_layer_row(_layer);
	}

	@Step
	public void select_layer_detail(int _rowIndex) {
		approvingOfficerPage.select_layer_detail(_rowIndex);
	}

	@Step
	public void select_layer_type(int _rowIndex, String _layerType) {
		approvingOfficerPage.select_layer_type(_rowIndex, _layerType);
	}

	// Parameter Definition
	@Step
	public void click_btn_add_parameter_definition() {
		approvingOfficerPage.click_btn_add_parameter_definition();
	}

	@Step
	public void enter_new_param_defi_project_catagory(String _projectCategory) {
		approvingOfficerPage.enter_new_param_defi_project_catagory(_projectCategory);
	}

	@Step
	public void enter_new_param_defi_sbu(String _sbu) {
		approvingOfficerPage.enter_new_param_defi_sbu(_sbu);
	}

	@Step
	public void enter_new_param_defi_project_type(String _projectType) {
		approvingOfficerPage.enter_new_param_defi_project_type(_projectType);
	}

	@Step
	public void select_param_defi(String _projectCategory, String _sbu, String _projectType) {
		approvingOfficerPage.select_param_defi(_projectCategory, _sbu, _projectType);
	}

	// Approving Levels
	@Step
	public void click_btn_al_add() {
		approvingOfficerPage.click_btn_al_add();
	}

	@Step
	public int get_al_row_by_level(String _level) {
		return approvingOfficerPage.get_al_row_by_level(_level);
	}

	@Step
	public void enter_al_approval_home_amt_limit(int _rowIndex, String _approvalHomeAmtLimit) {
		approvingOfficerPage.enter_al_approval_home_amt_limit(_rowIndex, _approvalHomeAmtLimit);
	}

	@Step
	public void select_approving_levels_by_level(int rowIndex) {
		approvingOfficerPage.select_approving_levels_by_level(rowIndex);
	}

	// Approving Levels - Approving Officer
	@Step
	public void click_btn_al_ao_add() {
		approvingOfficerPage.click_btn_al_ao_add();
	}

	@Step
	public void enter_al_ao_new_employee_code(String _employeeCode) {
		approvingOfficerPage.enter_al_ao_new_employee_code(_employeeCode);
	}
	// #End Region# Vincent
	// #Begin Region# Ian

	public void switch_to_iframe() {
		approvingOfficerPage.switchToIFrame();
	}

	public void switch_out_iframe() {
		approvingOfficerPage.switchOutDefaultIFrame();
	}

	public void search_by_modulecode_transaction_desc(String moduleCodeDesc, String transactionTypeDesc) {
		approvingOfficerPage.enterModuleCodeDesc(moduleCodeDesc);
		approvingOfficerPage.enterTransactionTypeDesc(transactionTypeDesc);
	}

	public void select_first_result() {
		approvingOfficerPage.select_first_result();
	}

	public void add_officer_with_amount_limit(String employeeCode, String approvalHomeAmountLimit) {
		approvingOfficerPage.clickAddNewOfficer();
		approvingOfficerPage.enterEmployeeCode(employeeCode);
		approvingOfficerPage.selectFirstEmployee(employeeCode);
		approvingOfficerPage.enterApprovalAmount(employeeCode, approvalHomeAmountLimit);
	}
	// #End Region# Ian
}
