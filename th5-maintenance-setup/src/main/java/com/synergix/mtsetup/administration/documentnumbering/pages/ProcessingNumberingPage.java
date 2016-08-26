package com.synergix.mtsetup.administration.documentnumbering.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Vincent
 * @version 20160121
 */
public class ProcessingNumberingPage extends TH5PageObject {
	public ProcessingNumberingPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Processing Numbering";
	@FindBy(xpath = "//span[@id='formHeaderAtHeader:formTitle']")
	private WebElementFacade pageHeader;
	private String xPathTbTransactionType = "(//table[contains(@id,'transactionTypeTable')])[1]";
	private String xPathTbNumberingScheme = "(//table[contains(@id,'schemeTable')])[1]";
	private String xPathPanelTagUser = "//*[contains(@id,'tagUser')]//form";

	// #Region#Page Action
	// Processing Numbering
	public void click_btn_close() {
		clickBtn("Close");
	}

	public void enter_module_code(String _moduleCode) {
		filterDataByHeader(xPathTbHeaderCell(xPathTbTransactionType, "Module Code"), _moduleCode);
	}

	public void enter_module_desc(String _moduleDesc) {
		filterDataByHeader(xPathTbHeaderCell(xPathTbTransactionType, "Module Desc"), _moduleDesc);
	}

	public void enter_transaction_type_code(String _transactionTypeCode) {
		filterDataByHeader(xPathTbHeaderCell(xPathTbTransactionType, "Transaction Type Code"), _transactionTypeCode);
	}

	public void enter_transaction_type_desc(String _transactionTypeDesc) {
		filterDataByHeader(xPathTbHeaderCell(xPathTbTransactionType, "Transaction Type Desc"), _transactionTypeDesc);
	}

	public int get_data_row_index_by_combine_text(String _givenAnyText) {
		String xPathResRow = xPathTbDataRowsByAnyText(xPathTbTransactionType, _givenAnyText);
		return getTbRowIndexOfDataCell("(" + xPathResRow + ")[1]");
	}

	public void set_auto_number(int _rowIndex, String _autoNumber) {
		setChkbox(
				xPathTbDataCellByPosition(xPathTbTransactionType, _rowIndex,
						getTbColHeaderIndex(xPathTbTransactionType, "Auto Number")) + "//input[@type='checkbox']",
				_autoNumber);

	}

	public void select_first_result_module() {
		clickOnElement(xPathTbDataCellByPosition(xPathTbTransactionType, 1,
				getTbColHeaderIndex(xPathTbTransactionType, "Module Code")) + "//a");
	}

	public void set_first_result_auto_number(String _autoNumber) {
		setChkbox(
				xPathTbDataCellByPosition(xPathTbTransactionType, 1,
						getTbColHeaderIndex(xPathTbTransactionType, "Auto Number")) + "//input[@type='checkbox']",
				_autoNumber);
	}

	// Numbering Scheme
	public void click_btn_ns_close() {
		clickBtn("Close", 2);
	}

	public void click_btn_ns_add() {
		clickBtn("Add");
	}

	public void click_btn_ns_delete() {
		clickBtn("Delete");
	}

	public void set_ns_auto_number(String _autoNumber) {
		setChkbox(xPathChkboxWithGroupLabel("Auto Number", ""), _autoNumber);
	}

	public int enter_ns_new_numbering_scheme_code(String _numberingSchemeCode) {
		int colIndex = getTbColHeaderIndex(xPathTbNumberingScheme, "Numbering Scheme Code");
		waitTypeAndEnter(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbNumberingScheme, colIndex) + "//input[@type='text']",
				_numberingSchemeCode);
		return search_ns_numbering_scheme_code(_numberingSchemeCode);
	}

	public void enter_ns_numbering_scheme_code(String _numberingSchemeCode) {
		int colIndex = getTbColHeaderIndex(xPathTbNumberingScheme, "Numbering Scheme Code");
		waitTypeAndEnter(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbNumberingScheme, colIndex) + "//input[@type='text']",
				_numberingSchemeCode);
	}

	public void enter_ns_description(int _rowIndex, String _description) {
		int colIndex = getTbColHeaderIndex(xPathTbNumberingScheme, "Description");
		waitTypeAndEnterThenUpdateValue(
				xPathTbDataCellByPosition(xPathTbNumberingScheme, _rowIndex, colIndex) + "//input", _description);
	}

	public void set_ns_is_manual_numbering(int _rowIndex, String _isManualNumbering) {
		int colIndex = getTbColHeaderIndex(xPathTbNumberingScheme, "Is Manual Numbering");
		setChkbox(xPathTbDataCellByPosition(xPathTbNumberingScheme, _rowIndex, colIndex) + "//input[@type='checkbox']",
				_isManualNumbering);
	}

	public int search_ns_numbering_scheme_code(String _numberingSchemeCode) {
		return searchInTbMultiPage(xPathTbNumberingScheme, "Numbering Scheme Code", 1, _numberingSchemeCode, true);
	}

	/**
	 *
	 * @param _numberingSchemeCode
	 * @edit Ian
	 */
	public void select_numbering_scheme_code(String _numberingSchemeCode) {
		int colIndex = getTbColHeaderIndex(xPathTbNumberingScheme, "Numbering Scheme Code");
		int rowIndex = getTbRowIndexOfDataCell(xPathTbNumberingScheme + "//td[.='" +_numberingSchemeCode +"']");
		clickOnElement(xPathTbDataCellByPosition(xPathTbNumberingScheme, rowIndex, colIndex) + "//a");
	}

	public void switch_to_tab_numbering_scheme_maintenance() {
		switch_to_tab("Numbering Scheme Maintenance");
	}

	public void enter_ns_last_number(String _lastNumber) {
		enterInputFieldWithLabel("Last Number", _lastNumber);
	}

	public void enter_ns_prefix(String _prefix) {
		enterInputFieldWithLabel("Prefix", _prefix);
	}

	public void enter_ns_suffix(String _suffix) {
		enterInputFieldWithLabel("Suffix", _suffix);
	}

	public void enter_ns_fill_character(String _fillCharacter) {
		enterInputFieldWithLabel("Fill Character", _fillCharacter);
	}

	public void enter_ns_maximum_length_of_code(String _maximumLengthOfCode) {
		enterInputFieldWithLabel("Maximum Length of Code", _maximumLengthOfCode);
	}

	public void enter_ns_length_of_code(String _lengthOfCode) {
		enterInputFieldWithLabel("Length of Code", _lengthOfCode);
	}

	public void set_ns_allow_user_to_overwrite(String _allowUserToOverwrite) {
		setChkbox(xPathChkboxWithGroupLabel("Allow User to Overwrite", ""), _allowUserToOverwrite);
	}

	public void enter_ns_device_id(String _deviceId) {
		enterInputFieldWithLabel("Device ID", _deviceId);
	}

	// Tag Users To Numbering Scheme
	public void switch_to_tab_tag_users_to_numbering_scheme() {
		switch_to_tab("Tag Users To Numbering Scheme");
	}

	public void click_btn_tag_user_insert() {
		clickBtn(xPathPanelTagUser, "Insert");
	}

	public void click_btn_tag_user_add() {
		clickBtn(xPathPanelTagUser, "Add");
	}

	public void click_btn_tag_user_delete() {
		clickBtn(xPathPanelTagUser, "Delete");
	}

	public void enter_tag_user_testkey(String _testkey) {
		enterInputFieldWithLabel("TestKey", _testkey);
	}

	public void enter_tag_user_user_id_from(String _userIdFrom) {
		enterInputFieldWithLabel("User ID From", _userIdFrom);
	}

	public void enter_tag_user_user_id_to(String _userIdTo) {
		enterInputFieldWithLabel("User ID To", _userIdTo);
	}

	public void enter_tag_user_user_name_from(String _userNameFrom) {
		clickOnElement(xPathSearchIconWithLabel("User ID From", 1));
		search("User Name", _userNameFrom);
	}

	public void enter_tag_user_user_name_to(String _userNameTo) {
		clickOnElement(xPathSearchIconWithLabel("User ID To", 1));
		search("User Name", _userNameTo);
	}

	public int search_tag_user_by_user_id(String _userId) {
		return searchInTbMultiPage(xPathPanelTagUser, "User ID", 1, _userId, true);
	}

	public void enter_tag_user_new_user_id(String _userId) {
		int colIndex = getTbColHeaderIndex(xPathPanelTagUser, "User ID");
		waitTypeAndEnter(xPathTbGetLastDataCellByHeaderIndex(xPathPanelTagUser, colIndex) + "//input[@type='text']",
				_userId);
		assertThat(search_tag_user_by_user_id(_userId) != 0).isTrue();
	}

	public void enter_tag_user_user_id(String _userId) {
		int colIndex = getTbColHeaderIndex(xPathPanelTagUser, "User ID");
		waitTypeAndEnter(xPathTbGetLastDataCellByHeaderIndex(xPathPanelTagUser, colIndex) + "//input[@type='text']",
				_userId);
	}

	public void enter_tag_user_new_user_name(String _userName) {
		int colIndex = getTbColHeaderIndex(xPathPanelTagUser, "User ID");
		clickOnElement(xPathTbGetLastDataCellByHeaderIndex(xPathPanelTagUser, colIndex)
				+ "//img[contains(@src,'lookup.gif')]");
		if (search("User Name", _userName)) {
			withAction().sendKeys(Keys.ENTER).perform();
		} else {
			Assert.assertFalse(false, "User name not found.");
		}
	}

	public void enter_tag_user_user_name(String _userName) {
		int colIndex = getTbColHeaderIndex(xPathPanelTagUser, "User ID");
		clickOnElement(xPathTbGetLastDataCellByHeaderIndex(xPathPanelTagUser, colIndex)
				+ "//img[contains(@src,'lookup.gif')]");
		if (search("User Name", _userName)) {
			withAction().sendKeys(Keys.ENTER).perform();
		} else {
			Assert.assertFalse(false, "User name not found.");
		}
	}

	public void verify_tag_user_employee_code(String _userId, String _employeeCode) {
		int rowIndex = search_tag_user_by_user_id(_userId);
		int colIndex = getTbColHeaderIndex(xPathPanelTagUser, "Employee Code");
		assertThat(waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelTagUser, rowIndex, colIndex)).getText()
				.equals(_employeeCode)).isTrue();
	}

	public void verify_tag_user_employee_name(String _userId, String _employeeName) {
		int rowIndex = search_tag_user_by_user_id(_userId);
		int colIndex = getTbColHeaderIndex(xPathPanelTagUser, "Employee Name");
		assertThat(waitElementToBePresent(xPathTbDataCellByPosition(xPathPanelTagUser, rowIndex, colIndex)).getText()
				.equals(_employeeName)).isTrue();
	}

	// #EndRegion#Page Action
}
