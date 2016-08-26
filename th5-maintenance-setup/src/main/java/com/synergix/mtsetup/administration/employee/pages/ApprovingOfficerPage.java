package com.synergix.mtsetup.administration.employee.pages;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.WebDriver;

/**
 * Created by Ian on 8/5/2016.
 */
public class ApprovingOfficerPage extends TH5PageObject {

	public ApprovingOfficerPage(WebDriver driver) {
		super(driver);
	}

	// #Begin Region# Vincent
	private static final String sPageHeader = "Approving Officer";
	@FindBy(xpath = "//span[@id='formHeaderAtHeader:formTitle']")
	private WebElementFacade pageHeader;

	private String xPathTbTransactionType = "//table[contains(@id,'TransactionTypeTable')]";
	private String xPathTbSBU = "//table[contains(@id,'sbuTable')]";
	private String xPathTbApprovingOfficerSbu = "//table[contains(@id,'ApprovingOfficerSbuTable')]";
	private String xPathTbApprovingOfficer = "//table[contains(@id,'ApprovingOfficerTable')]";

	public void click_btn_add() {
		clickBtn("Add");
	}

	public void filter_module_code_desc(String _moduleCodeDesc) {
		filterDataByHeader(xPathTbHeaderCell(xPathTbTransactionType, "Module Code Desc"), _moduleCodeDesc);
	}

	public void filter_transaction_type_desc(String _transactionTypeDesc) {
		filterDataByHeader(xPathTbHeaderCell(xPathTbTransactionType, "Transaction Type Desc"), _transactionTypeDesc);
	}

	public void select_first_transaction() {
		clickGreenArrow(xPathTbTransactionType, 1);
	}

	public void select_approving_method(int _rowIndex, String _approvingMethod) {
		selectDdlByText(
				xPathTbDataCellByPosition(xPathTbTransactionType, _rowIndex,
						getTbColHeaderIndex(xPathTbTransactionType, "Approving Method")) + "//select",
				_approvingMethod);
	}

	public void select_reject_remarks_mandatory(int _rowIndex, String _rejectRemarksMandatory) {
		selectRadioButton(xPathRadioBtnWithLabel(
				xPathTbDataCellByPosition(xPathTbTransactionType, _rowIndex,
						getTbColHeaderIndex(xPathTbTransactionType, "Reject Remarks Mandatory")),
				_rejectRemarksMandatory));
	}

	public void filter_sbu_code(String _sbuCode) {
		filterDataByHeader(xPathTbHeaderCell(xPathTbSBU, "SBU Code"), _sbuCode);
	}

	public void filter_sbu_desc(String _sbuDesc) {
		filterDataByHeader(xPathTbHeaderCell(xPathTbSBU, "SBU Desc"), _sbuDesc);
	}

	public void select_first_sbu() {
		waitElementToBeClickable(xPathTbDataCellByPosition(xPathTbSBU, 1, 1)).click();
	}

	public void add_approving_officer_by_employee_code(String _employeeCode) {
		if (_employeeCode.equals("@LOGINUSERNAME@")) {
			search("Employee Name", getLoginUserName());
		} else {
			search("Employee Code", _employeeCode);
		}
	}

	public int search_approving_officer(String _approvingOfficer) {
		return searchInTbMultiPage(xPathTbApprovingOfficer, "Approving Officer", 1, _approvingOfficer, true);
	}

	public void verify_adding_approving_officer(String _approvingOfficer) {
		assertThat(searchInTbMultiPage(xPathTbApprovingOfficer, "Approving Officer", 1, _approvingOfficer, true) != 0)
				.isTrue();
	}

	public int search_approving_officer_sbu(String _approvingOfficer) {
		return searchInTbMultiPage(xPathTbApprovingOfficerSbu, "Approving Officer", 1, _approvingOfficer, true);
	}

	public void enter_approval_home_amount_limit_per_voucher(String _approvingOfficer,
			String _approvalHomeAmountLimitPerVoucher, String _officeForSingleSupplier) {
		int rowIndex = search_approving_officer(_approvingOfficer);
		waitTypeAndEnter(xPathTbDataCellByPosition(xPathTbApprovingOfficer, rowIndex,
				getTbColHeaderIndex(xPathTbApprovingOfficer, "Approval Home Amount Limit (Per Voucher)")) + "//input",
				_approvalHomeAmountLimitPerVoucher);
		if (!_officeForSingleSupplier.isEmpty()) {
			setChkbox(xPathTbDataCellByPosition(xPathTbApprovingOfficer, rowIndex,
					getTbColHeaderIndex(xPathTbApprovingOfficer, "Officer For Single Supplier"))
					+ "//input[@type='checkbox']", _officeForSingleSupplier);
		}
	}

	public void enter_approval_home_amount_limit_per_voucher(String _approvingOfficer,
			String _approvalHomeAmountLimitPerVoucher) {
		int rowIndex = search_approving_officer(_approvingOfficer);
		waitTypeAndEnter(xPathTbDataCellByPosition(xPathTbApprovingOfficer, rowIndex,
				getTbColHeaderIndex(xPathTbApprovingOfficer, "Approval Home Amount Limit (Per Voucher)")) + "//input",
				_approvalHomeAmountLimitPerVoucher);
	}

	public void verify_adding_approving_officer_in_AOSbu(String _approvingOfficer) {
		assertThat(
				searchInTbMultiPage(xPathTbApprovingOfficerSbu, "Approving Officer", 1, _approvingOfficer, true) != 0)
						.isTrue();
	}

	public void enter_approval_home_amount_limit_per_voucher_sbu(String _approvingOfficer,
			String _approvalHomeAmountLimitPerVoucher) {
		int rowIndex = search_approving_officer_sbu(_approvingOfficer);
		waitTypeAndEnter(xPathTbDataCellByPosition(xPathTbApprovingOfficerSbu, rowIndex,
				getTbColHeaderIndex(xPathTbApprovingOfficerSbu, "Approval Home Amount Limit (Per Voucher)"))
				+ "//input", _approvalHomeAmountLimitPerVoucher);
	}

	// Table adding SBU
	private String xPathPanelMultiLevelBySBU = "//div[contains(@id,'multiLevelBySBUPanel_body')]";
	private String xPathTbAddSBU = "//table[contains(@id,'tblSBU')]";

	public void click_btn_multi_by_sbu_add() {
		clickBtn(xPathPanelMultiLevelBySBU, "Add");
	}

	public void enter_new_sbu_code(String _SBUCode) {
		int colIndexSBUCode = getTbColHeaderIndex(xPathTbAddSBU, "SBU Code");
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbAddSBU, colIndexSBUCode) + "//input[@type='text']",
				_SBUCode);
	}

	public void select_sbu_by_sbu_code(String _SBUCode) {
		int colIndexSBUCode = getTbColHeaderIndex(xPathTbAddSBU, "SBU Code");
		clickGreenArrow(xPathTbAddSBU,
				getTbRowIndexOfDataCell(xPathTbDataCellByTextEqualInCol(xPathTbAddSBU, _SBUCode, 1, colIndexSBUCode)));
	}

	// Approving Officer (Multiple Level)
	private String xPathPanelApprovingOfficer = "//div[contains(@id,'officerPanel')]";

	public void click_btn_add_ao_in_multiple_level() {
		clickBtn(xPathPanelApprovingOfficer, "Add");
	}

	public void enter_mutiple_ao_level(String _level) {
		int colIndexLevel = getTbColHeaderIndex(xPathPanelApprovingOfficer, "Level");
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathPanelApprovingOfficer, colIndexLevel)
				+ "//input[@type='text']", _level);
	}

	public void enter_mutiple_ao_approving_officer(String _approvingOfficer) {
		int colIndexAO = getTbColHeaderIndex(xPathPanelApprovingOfficer, "Approving Officer");
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathTbGetLastDataCellByHeaderIndex(xPathPanelApprovingOfficer, colIndexAO) + "//input[@type='text']",
				_approvingOfficer);
	}

	// Layer Detail
	private String xPathPanelLayerDetail = "//div[contains(@id,'layerPanel_body')]";

	public void click_btn_add_layer() {
		clickBtn(xPathPanelLayerDetail, "Add");
	}

	public int get_layer_row(String _layer) {
		return getTbRowIndexOfDataCell(xPathTbDataCellByTextInCol(xPathPanelLayerDetail, _layer, 1,
				getTbColHeaderIndex(xPathPanelLayerDetail, "Layer")));
	}

	public void select_layer_detail(int _rowIndex) {
		clickGreenArrow(xPathPanelLayerDetail, _rowIndex);
	}

	public void select_layer_type(int _rowIndex, String _layerType) {
		String xPathDataCell = xPathTbDataCellByPosition(xPathPanelLayerDetail, _rowIndex,
				getTbColHeaderIndex(xPathPanelLayerDetail, "Type"));
		if (_layerType.equals("Operation Manager") || _layerType.equals("Claim Officer")) {

			selectRadioButton(xPathRadioBtnWithLabel(xPathDataCell, "Specific"));
			selectDdlByText(xPathDataCell + "//select", _layerType);
		} else {
			selectRadioButton(xPathRadioBtnWithLabel(xPathDataCell, _layerType));
		}
	}

	// Parameter Definition
	private String xPathPanelParameterDefinition = "//div[contains(@id,'commonParamPanel_body') or contains(@id,'specConParamPanel_body')]";

	public void click_btn_add_parameter_definition() {
		clickBtn(xPathPanelParameterDefinition, "Add");
	}

	public void enter_new_param_defi_project_catagory(String _projectCategory) {
		int colIndex = getTbColHeaderIndex(xPathPanelParameterDefinition, "Project Category");
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathPanelParameterDefinition, colIndex) + "//input[@type='text']",
				_projectCategory);
	}

	public void enter_new_param_defi_sbu(String _sbu) {
		int colIndex = getTbColHeaderIndex(xPathPanelParameterDefinition, "SBU");
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathPanelParameterDefinition, colIndex) + "//input[@type='text']",
				_sbu);
	}

	public void enter_new_param_defi_project_type(String _projectType) {
		int colIndex = getTbColHeaderIndex(xPathPanelParameterDefinition, "Project Type");
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathPanelParameterDefinition, colIndex) + "//input[@type='text']",
				_projectType);
	}

	public void select_param_defi(String _projectCategory, String _sbu, String _projectType) {
		String xPathResRow = xPathTbDataRowsByAnyText(xPathPanelParameterDefinition,
				_projectCategory + " " + _sbu + " " + _projectType);
		int rowIndex = getTbRowIndexOfDataCell("(" + xPathResRow + ")[1]");
		clickGreenArrow(xPathPanelParameterDefinition, rowIndex);
	}

	// Approving Levels
	String xPathPanelApprovingLevels = xPathPanelParameterDefinition + "//div[contains(@id,'commLevelsPanel_body')]";

	public void click_btn_al_add() {
		clickBtn(xPathPanelApprovingLevels, "Add");
	}

	public int get_al_row_by_level(String _level) {
		return getTbRowIndexOfDataCell(
				xPathTbDataCellByTextEqualInCol(xPathPanelApprovingLevels, _level, 1, "Level", 1));
	}

	public void enter_al_approval_home_amt_limit(int _rowIndex, String _approvalHomeAmtLimit) {
		waitTypeAndEnterThenUpdateValue(xPathTbDataCellByPosition(xPathPanelApprovingLevels, _rowIndex,
				getTbColHeaderIndex(xPathPanelApprovingLevels, "Approval Home Amt Limit (per Voucher)")) + "//input",
				_approvalHomeAmtLimit);
	}

	public void select_approving_levels_by_level(int rowIndex) {
		clickGreenArrow(xPathPanelApprovingLevels, rowIndex);
	}

	// Approving Levels - Approving Officer
	private String xPathPanelALApprovingOfficer = xPathPanelApprovingLevels
			+ "//div[contains(@id,'commLevelOffcPanel_body')]";

	public void click_btn_al_ao_add() {
		clickBtn(xPathPanelALApprovingOfficer, "Add");
	}

	public void enter_al_ao_new_employee_code(String _employeeCode) {
		int colIndex = getTbColHeaderIndex(xPathPanelALApprovingOfficer, "Employee Code");
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathPanelALApprovingOfficer, colIndex) + "//input[@type='text']",
				_employeeCode);
	}
	// #End Region# Vincent
	// #Begin Region# Ian
	public static final String TRANSACTION_TYPE_TABLE = "//form/table[contains(@id,'mtTransactionTypeTable')]";
	public static final String OFFICER_TABLE = "//form/table[contains(@id,'mtApprovingOfficerTable')]";

	public void enterModuleCodeDesc(String moduleCodeDesc) {
		filterDataByHeader(xPathTbHeaderCell(TRANSACTION_TYPE_TABLE, "Module Code Desc"), moduleCodeDesc);
	}

	public void enterTransactionTypeDesc(String transactionTypeDesc) {
		filterDataByHeader(xPathTbHeaderCell(TRANSACTION_TYPE_TABLE, "Transaction Type Desc"), transactionTypeDesc);
	}

	public void select_first_result() {
		clickOnElement(TRANSACTION_TYPE_TABLE + "/tbody/tr[1]/td/a");
	}

	public void clickAddNewOfficer() {
		clickBtn("Add");
	}

	public void enterEmployeeCode(String employeeCode) {
		enterInputFieldCodeWithLabel("Employee Code", employeeCode);
	}

	public void selectFirstEmployee(String employeeCode) {
		getResultSearch("Employee Code", employeeCode);
	}

	public void enterApprovalAmount(String employeeCode, String approvalHomeAmountLimit) {
		$(OFFICER_TABLE + "/tbody/tr[td[.='" + employeeCode + "']]/td[1]//input").typeAndEnter(approvalHomeAmountLimit);
	}
	// #End Region# Ian
}
