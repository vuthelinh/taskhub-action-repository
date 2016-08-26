package com.synergix.operations.project.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import com.synergix.utilities.SessionData;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import com.synergix.common.TH6PageObject;

/**
 * Created by Steve, inherit some code from Ian
 */
public class ProjectEstimationPage extends TH6PageObject {

	private static final String DETAILS_TAB_LABEL = "Details";
	private static final String OUTSTANDING = "Outstanding";
	private static final String PENDING = "Pending";
	private static final String DRAFT = "Draft";
	private static final String STAR_STATE_WHEN_UNCHECKED = "fa-star-o";
	private static final String VALUE_DEMILITER = ", ";
	private static final String NO_RECORDS_FOUND = "No records found.";
	private static final int POLICY_NO_HEADER_INDEX = 1;
	private static final String PROJECT_NO = "Project No.";
	private static final int FILE_CHECKBOX = 7;
	private static final int DOWNLOAD = 6;
	private static final int FILE_SIZE = 5;
	private static final int MIME_TYPE = 4;
	private static final int FILE_DESCRIPTION = 3;
	private static final int FILE_NAME = 2;
	private static final String EXTERNAL_REMARKS = "External Remarks";
	private static final String LIQUIDATED_DAMAGE_REMARKS_LABEL = "Liquidated Damage Remarks";
	private static final String INTERNAL_REMARKS = "Internal Remarks";
	private static final String TERMS_CONDITION = "Terms & Condition";
	private static final String SUBJECT_DETAIL = "Subject Detail";
	private static final int INSURANCE_CHECKBOX = 9;
	private static final int POLICY_REMARKS = 8;
	// private static final String STATE_WHEN_UNCHECKED = "ui-state-default";
	private static final String STATE_WHEN_CHECKED = "ui-state-active";
	private static final int INSURED = 7;
	private static final String TOLERABLE_VARIANCE = "Tolerable Variance %";
	private static final String INVENTORY_LOADING_LOCATION = "Inventory Loading Location";
	private static final int RETENTION_DUE_ON = 2;
	private static final String RETENTION_DUE_DATE = "Retention Due Date";
	private static final int RETENTION_DAYS = 1;
	private static final int MAX_RETENTION_PERCENT = 2;
	private static final int MAX_RETENTION_AMT = 1;
	private static final String MAX_RETENTION = "Max Retention";
	private static final String PROGRESSIVE_RETENTION = "Progressive Retention";
	private static final int DOWNPAYMENT_AMT = 1;
	private static final int DOWNPAYMENT_PERCENT = 2;
	private static final String DOWNPAYMENT = "Downpayment";
	private static final String PROJECT_CATEGORY = "Project Category";
	private static final String CONTACT_ADDRESS = "Contact Address";
	private static final String CONTACT_PERSON = "Contact Person";
	private static final String REFERENCE_NO = "Reference No.";
	private static final String AWARDED_DATE = "Awarded Date";
	private static final String CUSTOMER_JOB_NO = "Customer Job No.";
	private static final int INSURANCE_COMPANY = 6;
	private static final int INSURANCE_END_DATE = 5;
	private static final int INSURANCE_START_DATE = 4;
	private static final int POLICY_TYPE = 3;
	private static final int POLICY_NO = 2;
	private static final String INSURANCE_TABLE_TITLE = "Insurance";
	private static final int BOND_CHECKBOX = 9;
	private static final int REMARKS = 8;
	private static final int ACTUAL_EXPIRY_DATE = 7;
	private static final int BONDS_DLP = 6;
	private static final int ISSUING_PARTY = 5;
	private static final int BOND_END_DATE = 4;
	private static final int BOND_START_DATE = 3;
	private static final int BOND_REF_NO = 2;
	private static final String BONDS = "Bonds";
	private static final String TENOR_TERM = "Tenor Term";
	private static final String PAYMENT_TENOR = "Payment Tenor";
	private static final String PAYMENT_METHOD = "Payment Method";
	private static final String PAYMENT_TERM = "Payment Term";
	private static final String PAYMENT_OPTION = "Payment Option";
	private static final String BILLING_ADDRESS = "Billing Address";
	private static final String BILLING_CONTACT = "Billing Contact";
	private static final String CUTOFF_DATE = "Cut-off Date";
	private static final String BILLING_PARTY = "Billing Party";
	private static final String BILLING_TYPE = "Billing Type";
	private static final int ROLE_IN_PROJECT_HEADER_INDEX = 2;
	private static final int EMPLOYEE_CODE = 1;
	private static final String VIEW_BY_ROLE = "View by Role";
	private static final String COSTING_SHEET_BY_PHASE_TABLE_TITLE = "Costing Sheet by Phase";
	private static final String TEAM_MEMBERS_TABLE_TITLE = "View by Employee";
	private static final int DRAWING_OBJECT_CHECKBOX = 9;
	private static final int DRAWING_OBJECT_BUDGET_COST = 8;
	private static final int DRAWING_OBJECT_MARKUP_PERCENT = 7;
	private static final int DRAWING_OBJECT_UNIT_COST = 6;
	private static final int DRAWING_OBJECT_UOM = 5;
	private static final int DRAWING_OBJECT_QTY = 5;
	private static final int ITEM_REMARKS = 4;
	private static final int ITEM_CODE_DESCRIPTION = 3;
	private static final int DRAWING_OBJECT_TYPE_HEADER_INDEX = 2;
	private static final int BUDGET_COST_IN_COSTING_SHEET = 3;
	private static final int PHASE_NO_HEADER_INDEX = 1;
	private static final String BACK_TO_PHASE_DETAILS = "Back to Phase Details";
	private static final String COSTING_SHEET = "Costing Sheet";
	private static final String PROJECT_VALUE_INCL_TAX = "6";
	private static final int SALES_TAX_INPUT_FIELD_HEADER_INDEX = 2;
	private static final String SALES_TAX_ROW_INDEX = "5";
	private static final int PROJECT_BUDGET_PROFIT_PERCENT = 2;
	private static final String PROJECT_BUDGET_PROFIT_ROW_INDEX = "4";
	private static final String PROJECT_BUDGET_COST_ROW_INDEX = "3";
	private static final int HOME_HEADER_INDEX = 4;
	private static final int NATURE_HEADER_INDEX = 3;
	private static final String PROJECT_SUM_ROW_INDEX = "2";
	private static final int EXCH_RATE_HEADER_INDEX = 4;
	private static final String EXCH_RATE_ROW_INDEX = "1";
	private static final int CURRENCY_HEADER_INDEX = 3;
	private static final String CURRENCY_ROW_INDEX = EXCH_RATE_ROW_INDEX;
	private static final int BTN_SHIFT_PHASE = 5;
	private static final int BTN_MOVE_PHASE_UP_ONE_LEVEL = 3;
	private static final int BTN_MOVE_PHASE_DOWN_ONE_LEVEL = 4;
	private static final int BTN_DELETE = 2;
	private static final int BTN_ADD_SUBPHASE = 1;
	private static final int PHASE_ACTIONS = 12;
	private static final int LIQUIDATED_DAMAGE_REMARKS = 11;
	private static final int DATE_TO_COMPLETE = 10;
	private static final int MARGIN_PERCENT = 9;
	private static final int BUDGET_PROFIT = 9;
	private static final int BUDGET_COST = 8;
	private static final int PHASE_VALUE = 7;
	private static final int DISC_AMT = 6;
	private static final int DISC_PERCENT = 6;
	private static final int UNIT_PRICE = 5;
	private static final int UOM = 4;
	private static final int Qty = 4;
	private static final int WORKHEAD_GROUP = 3;
	private static final String ABORT = "Abort";
	private static final String SBU = "SBU";
	private static final String PROJECT_CLASS = "Project Class";
	private static final String PREVIEW = "Preview";
	private static final String SUBMIT = "Submit";
	private static final String NEW = "New";
	private static final String WITH_DLP = "With DLP";
	private static final String TO = "To";
	private static final String PROJECT_DURATION_DLP = "Project Duration & DLP";
	private static final String CUSTOMER = "Customer";
	private static final String PROJECT_NAME = "Project name";
	private static final int PHASE_DESC_OR_REMARKS = 2;

	public ProjectEstimationPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * @Author: Ian
	 */
	private String iconNew = "//button[contains(@id,'syn:summaryTabs:summaryDraftForm') and span[contains(@class,' fa-file')]]";

	public void click_add_new_button_on_functional_panel() {
		$(iconNew).waitUntilClickable().click();
		waitForAllJSCompletes();
		waitABit(10000);
	}

	public void open_tab(String tabName) {
		String tabXpath = "//a[contains(text(), '" + tabName + "')]";
		clickOnElement(tabXpath);
		waitForAllJSCompletes();
	}

	public void open_tab_draft() {
		open_tab(DRAFT);
	}

	public void open_tab_pending() {
		open_tab(PENDING);
	}

	public void open_tab_outstanding() {
		open_tab(OUTSTANDING);
	}

	/**
	 * @Description: Get project number, e.g get "PJ00002475" from the title
	 *               "Project Order [PJ00002475]"
	 * 
	 */
	private String projectNo = "//span[contains(text(), 'Project Order')]";

	public String get_project_no() {
		String title = $(projectNo).getText();
		int firstSquareBracket = title.indexOf('[') + 1;
		int lastSquareBracket = title.indexOf(']');
		return title.substring(firstSquareBracket, lastSquareBracket);
	}

	/**
	 * @Description: Button New near button Back To Summary
	 * 
	 */
	public void click_btn_new() {
		clickBtn(NEW);
		waitForAllJSCompletes();
	}

	public void click_btn_submit() {
		if(isElementExist(xPathBtn(SUBMIT))) {
			clickBtn(SUBMIT);
			waitForAllJSCompletes();
		} else {
			clickBtn("submit");
			waitForAllJSCompletes();
		}

	}

	public void click_btn_preview() {
		clickBtn(PREVIEW);
		waitForAllJSCompletes();
	}

	/**
	 * @Description: Delete the project estimation
	 */
	public void click_btn_abort() {
		clickBtn(ABORT);
		waitForAllJSCompletes();
	}

	private String confirmationPanelXpath = "//div[contains(@id, 'globalConfirmationForm')]";

	public void chooseYesOnConfirmationPanel() {
		String yesBtnXpath = confirmationPanelXpath + "//button[span[text()='Yes']]";
		clickOnElement(yesBtnXpath);
		waitForAllJSCompletes();
	}

	/**
	 * Description: Click button abort then choose yes
	 */
	public void delete_project_estimation() {
		click_btn_abort();
		chooseYesOnConfirmationPanel();
	}

	public void enter_project_name(String projectName) {
		waitForAllJSCompletes();
		enterTextAreaWithLabel(PROJECT_NAME, projectName);
	}

	@Override
	public String getTextValueWithLabel(String labelName) {
		String elementXpath = "//tr[contains(@class,'synfaces-form-grid-row')]//div[text()='" + labelName
				+ "']/following-sibling::div/*";
		return waitElementToBePresent(elementXpath).getValue();
	}

	public String get_text_project_name() {
		return getTextValueWithLabel(PROJECT_NAME);
	}

	public void enter_customer(String customerName) {
		String fieldXpath = xPathInputFieldWithLabel(CUSTOMER);
		typeAndWaitForAllJSCompletesThenEnter(fieldXpath, customerName);
		waitForAllJSCompletes();
	}

	public String get_text_customer() {
		return getTextValueWithLabel(CUSTOMER);
	}

	public void pick_project_duration_and_dlp_from(String projectDurationAndDlpFrom) {
		String fromDate = xPathInputFieldWithLabel(PROJECT_DURATION_DLP);
		$(fromDate).waitUntilClickable().click();
		waitForAllJSCompletes();
		setCalendarDate(projectDurationAndDlpFrom);
		waitForAllJSCompletes();
	}

	public String get_project_duration_and_dlp_from() {
		String fromDate = xPathInputFieldWithLabel(PROJECT_DURATION_DLP);
		return $(fromDate).getValue();
	}

	private String toDate = "//*[text()='" + TO + "']//following-sibling::*//input";

	public void pick_project_duration_and_dlp_to(String projectDurationAndDlpTo) {
		$(toDate).click();
		waitForAllJSCompletes();
		setCalendarDate(projectDurationAndDlpTo);
		waitForAllJSCompletes();
	}

	public String get_project_duration_and_dlp_to() {
		return $(toDate).getValue();
	}

	private String withDlp = "//label[text()='" + WITH_DLP + "']//following-sibling::input";

	public void enter_dlp(String numOfMonths) {
		$(withDlp).sendKeys(numOfMonths);
	}

	public String get_text_dlp() {
		return $(withDlp).getValue();
	}

	// Header tab
	public void enter_customer_job_no(String customerJobNo) {
		enterInputFieldWithLabel(CUSTOMER_JOB_NO, customerJobNo);
	}

	public String get_text_customer_job_no() {
		return getTextValueWithLabel(CUSTOMER_JOB_NO);
	}

	/**
	 * @param awardedDate
	 *            in format ddmmyyyy
	 */
	public void enter_awarded_date(String awardedDate) {
		String fieldXpath = xPathInputFieldWithLabel(AWARDED_DATE);
		clickOnElement(fieldXpath);
		waitForAllJSCompletes();
		setCalendarDate(awardedDate);
	}

	public String get_text_awarded_date() {
		String awardedDate = xPathInputFieldWithLabel(AWARDED_DATE);
		return waitElementToBePresent(awardedDate).getValue();
	}

	public void enter_reference_no(String referenceNo) {
		enterInputFieldWithLabel(REFERENCE_NO, referenceNo);
	}

	public String get_text_reference_no() {
		return getTextValueWithLabel(REFERENCE_NO);
	}

	/**
	 * @param contact:
	 *            is contact code or party contact name
	 */
	public void enter_contact_person(String contact) {
		String fieldXpath = xPathInputFieldWithLabel(CONTACT_PERSON);
		typeAndWaitForAllJSCompletesThenEnter(fieldXpath, contact);
		waitForAllJSCompletes();
	}

	public String get_text_contact_person() {
		return getTextValueWithLabel(CONTACT_PERSON);
	}

	/**
	 * @param contactAddress:
	 *            is address code or party address description
	 */
	public void enter_contact_address(String contactAddress) {
		String fieldXpath = xPathInputFieldWithLabel(CONTACT_ADDRESS);
		typeAndWaitForAllJSCompletesThenEnter(fieldXpath, contactAddress);
		waitForAllJSCompletes();
	}

	public String get_text_contact_address() {
		return getTextValueWithLabel(CONTACT_ADDRESS);
	}

	/**
	 * @param projectClass:
	 *            is project class code or project class description
	 */
	public void enter_project_class(String projectClass) {
		String fieldXpath = xPathInputFieldWithLabel(PROJECT_CLASS);
		typeAndWaitForAllJSCompletesThenEnter(fieldXpath, projectClass);
		waitForAllJSCompletes();
	}

	public String get_text_project_class() {
		return getTextValueWithLabel(PROJECT_CLASS);
	}

	/**
	 * 
	 * @param projectCategory:
	 *            is project category code or project category description
	 */
	public void enter_project_category(String projectCategory) {
		String fieldXpath = xPathInputFieldWithLabel(PROJECT_CATEGORY);
		typeAndWaitForAllJSCompletesThenEnter(fieldXpath, projectCategory);
		waitForAllJSCompletes();
	}

	public String get_text_project_category() {
		return getTextValueWithLabel(PROJECT_CATEGORY);
	}

	/**
	 * 
	 * @param sbu:
	 *            can be sbu code or sbu description
	 */
	public void enter_sbu(String sbu) {
		String fieldXpath = xPathInputFieldWithLabel(SBU);
		typeAndWaitForAllJSCompletesThenEnter(fieldXpath, sbu);
		waitForAllJSCompletes();
	}

	public String get_text_sbu() {
		return getTextValueWithLabel(SBU);
	}

	public void enter_downpayment_amt(String downpaymentAmt) {
		String fieldXpath = xPathInputFieldWithLabel(DOWNPAYMENT, DOWNPAYMENT_AMT);
		waitTypeAndEnter(fieldXpath, downpaymentAmt);
	}

	public String get_text_downpayment_amt() {
		String fieldXpath = xPathInputFieldWithLabel(DOWNPAYMENT, DOWNPAYMENT_AMT);
		return waitElementToBePresent(fieldXpath).getValue();
	}

	public void enter_downpayment_percent(String downpaymentPercent) {
		String fieldXpath = xPathInputFieldWithLabel(DOWNPAYMENT, DOWNPAYMENT_PERCENT);
		waitTypeAndEnter(fieldXpath, downpaymentPercent);
	}

	public String get_text_downpayment_percent() {
		String fieldXpath = xPathInputFieldWithLabel(DOWNPAYMENT, DOWNPAYMENT_PERCENT);
		return waitElementToBePresent(fieldXpath).getValue();
	}

	public void enter_progressive_retention(String progressiveRetention) {
		enterInputFieldWithLabel(PROGRESSIVE_RETENTION, progressiveRetention);
	}

	public String get_text_progressive_retention() {
		return getTextValueWithLabel(PROGRESSIVE_RETENTION);
	}

	public void enter_max_retention_amt(String maxRetentionAmt) {
		String fieldXpath = xPathInputFieldWithLabel(MAX_RETENTION, MAX_RETENTION_AMT);
		waitTypeAndEnter(fieldXpath, maxRetentionAmt);
	}

	public String get_text_max_retention_amt() {
		String fieldXpath = xPathInputFieldWithLabel(MAX_RETENTION, MAX_RETENTION_AMT);
		return waitElementToBePresent(fieldXpath).getValue();
	}

	public void enter_max_retention_percent(String maxRetentionPercent) {
		String fieldXpath = xPathInputFieldWithLabel(MAX_RETENTION, MAX_RETENTION_PERCENT);
		waitTypeAndEnter(fieldXpath, maxRetentionPercent);
	}

	public String get_text_max_retention_percent() {
		String fieldXpath = xPathInputFieldWithLabel(MAX_RETENTION, MAX_RETENTION_PERCENT);
		return waitElementToBePresent(fieldXpath).getValue();
	}

	public void enter_retention_due_date_days(String retentionDays) {
		String fieldXpath = xPathInputFieldWithLabel(RETENTION_DUE_DATE, RETENTION_DAYS);
		waitTypeAndEnter(fieldXpath, retentionDays);
	}

	public String get_text_retention_due_date_days() {
		String fieldXpath = xPathInputFieldWithLabel(RETENTION_DUE_DATE, RETENTION_DAYS);
		return waitElementToBePresent(fieldXpath).getValue();
	}

	public void enter_retention_due_date_due_on(String retentionDueDate) {
		String fieldXpath = xPathInputFieldWithLabel(RETENTION_DUE_DATE, RETENTION_DUE_ON);
		clickOnElement(fieldXpath);
		waitForAllJSCompletes();
		setCalendarDate(retentionDueDate);
	}

	public String get_text_retention_due_date_due_on() {
		String fieldXpath = xPathInputFieldWithLabel(RETENTION_DUE_DATE, RETENTION_DUE_ON);
		return waitElementToBePresent(fieldXpath).getValue();
	}

	/**
	 * 
	 * @param inventoryLoadingLocation:
	 *            can be location code or location name
	 */
	public void enter_inventory_loading_location(String inventoryLoadingLocation) {
		String fieldXpath = xPathInputFieldWithLabel(INVENTORY_LOADING_LOCATION);
		typeAndWaitForAllJSCompletesThenEnter(fieldXpath, inventoryLoadingLocation);
		waitForAllJSCompletes();
	}

	public String get_text_inventory_loading_location() {
		return getTextValueWithLabel(INVENTORY_LOADING_LOCATION);
	}

	public void enter_tolerable_variance(String tolerableVariance) {
		enterInputFieldWithLabel(TOLERABLE_VARIANCE, tolerableVariance);
	}

	public String get_text_tolerable_variance() {
		return getTextValueWithLabel(TOLERABLE_VARIANCE);
	}

	public void click_btn_add_main_phase() {
		String btnAddMainPhaseXpath = detailsTabXpath + "//button[span[contains(@class,' fa-plus')]][1]";
		clickOnElement(btnAddMainPhaseXpath);
		waitForAllJSCompletes();
	}

	public void click_btn_delete_all_phase() {
		String btnAddMainPhaseXpath = detailsTabXpath + "//button[span[contains(@class,' fa-plus')]][1]";
		$(btnAddMainPhaseXpath).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void click_btn_import_data_from_excel() {
		String importExcelIconButtonXpath = detailsTabXpath + "//button[contains(@id, 'importExcelIconButton')]";
		waitForAllJSCompletes();
		waitElementToBePresent(importExcelIconButtonXpath).click();
	}

	public void click_btn_costing_sheet() {
		clickBtn(detailsTabXpath, COSTING_SHEET);
		waitForAllJSCompletes();
	}

	public void click_btn_back_to_phase_details() {
		clickBtn(detailsTabXpath, BACK_TO_PHASE_DETAILS);
		waitForAllJSCompletes();
	}

	public void click_on_phase_no_in_costing_sheet(String phaseNo) {
		String cellXpath = xPathTbDataCellByPosition(phaseDetailsTableXpath, phaseNoToRowIndex(phaseNo),
				PHASE_NO_HEADER_INDEX);
		waitElementToBeClickable(cellXpath).click();
		waitForAllJSCompletes();
	}

	/**
	 * Description: Get the total budget cost displayed in abtract version of
	 * phase details table after clicking on button costing sheet
	 * 
	 * @param phaseNo
	 * @return
	 */
	public String get_text_budget_cost_in_costing_sheet(String phaseNo) {
		String cellXpath = xPathTbDataCellByPosition(phaseDetailsTableXpath, phaseNoToRowIndex(phaseNo),
				BUDGET_COST_IN_COSTING_SHEET);
		return waitElementToBePresent(cellXpath).getText();
	}

	private String xPathAddBtnByTbTitle(String tableTitle) {
		String addBtnXpath = "//div[text()='" + tableTitle + "']//button[*[contains(@class, 'fa-plus')]]";
		return addBtnXpath;
	}

	private String xPathDeleteBtnByTbTitle(String tableTitle) {
		String deleteBtnXpath = "//div[text()='" + tableTitle + "']//button[*[contains(@class, 'fa-trash-o')]]";
		return deleteBtnXpath;
	}

	public void click_btn_add_drawing_object() {
		String addDrawingObjectBtnXpath = xPathAddBtnByTbTitle(COSTING_SHEET_BY_PHASE_TABLE_TITLE);
		waitElementToBeClickable(addDrawingObjectBtnXpath).click();
		waitForAllJSCompletes();
	}

	public void click_btn_delete_drawing_object() {
		String deleteDrawingObjectBtnXpath = xPathDeleteBtnByTbTitle(COSTING_SHEET_BY_PHASE_TABLE_TITLE);
		waitElementToBeClickable(deleteDrawingObjectBtnXpath).click();
		waitForAllJSCompletes();
	}
	private String detailsTabXpath = "//body/div[@id='centerPane']//h3[text()='" + DETAILS_TAB_LABEL + "']//following-sibling::div[1]";
	private String costingSheetTableXpath = detailsTabXpath + xPathTbDataWithTitle(COSTING_SHEET_BY_PHASE_TABLE_TITLE);

	public void select_in_drawing_object_type(String drawingObjectNo, String drawingObjectType) {
		String cellXpath = xPathTbDataCellByPosition(costingSheetTableXpath, Integer.parseInt(drawingObjectNo),
				DRAWING_OBJECT_TYPE_HEADER_INDEX);
		String labelXpath = cellXpath + "//label[contains(@id, 'costItemForms:costItemTable')]";
		clickOnElement(labelXpath);
		waitForAllJSCompletes();

		// For each select box, there is a corresponding tag ul which is display
		// when we click on the select box. ul for select box in row 1 has this
		// part in id: "costItemForms:costItemTable:0"
		// so there is a subtraction by 1 here
		int ulNo = Integer.parseInt(drawingObjectNo) - 1;
		String optionXpath = "//ul[contains(@id,'costItemForms:costItemTable:" + ulNo
				+ "') and @role='listbox']/li[text()='" + drawingObjectType + "']";
		$(optionXpath).waitUntilPresent().waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public String get_text_drawing_object_type(String drawingObjectNo) {
		waitForAllJSCompletes();
		String cellXpath = xPathTbDataCellByPosition(costingSheetTableXpath, LAST_ROW,
				DRAWING_OBJECT_TYPE_HEADER_INDEX);

		// After selecting a value in select box, the value chosen will be
		// updated in tag label
		String labelXpath = cellXpath + "//label[contains(@id, 'costItemForms:costItemTable')]";
		return $(labelXpath).waitUntilVisible().getText();
	}

	public void clickSearchIcon(String cellXpath) {
		String searchIconXpath = cellXpath + "//button[span[text()='ui-button']]";
		clickOnElement(searchIconXpath);
		waitForAllJSCompletes();
	}

	/**
	 * @param _parentXpath
	 * @param _givenText
	 * @param _cellOrder
	 * @return xPath
	 * @Description xPath of Table Data Cell by any given text insides Data
	 *              Cell.
	 * @author Vincent, customized by Steve
	 */
	@Override
	public String xPathTbDataCellByText(String _parentXpath, String _givenText, int _cellOrder) {
		String[] aGivenText = _givenText.split(" ");
		String sSearchPattern = "";
		int numText = aGivenText.length;
		if (numText > 1) {
			sSearchPattern = "descendant-or-self::*[contains(@value,'" + aGivenText[0] + "') or contains(text(),'"
					+ aGivenText[0] + "')]";
			for (int i = 1; i < numText; i++) {
				sSearchPattern += " and descendant-or-self::*[contains(@value,'" + aGivenText[i]
						+ "') or contains(text(),'" + aGivenText[i] + "')]";
			}
			return "(" + _parentXpath + "//tbody//descendant-or-self::td[" + sSearchPattern + "])[" + _cellOrder + "]";
		} else {
			sSearchPattern = "[descendant-or-self::*[contains(@value,'" + _givenText + "') or contains(text(),'"
					+ _givenText + "')]]";
			return "(" + _parentXpath + "//tbody//descendant-or-self::td" + sSearchPattern + ")[" + _cellOrder + "]";
		}
	}

	/**
	 * Description: Enter valueUsedToSearch to the field with label labelName
	 * 
	 * @param labelName
	 * @param valueUsedToSearch
	 * @Author Nancy, customized by Steve
	 */
	public boolean get_result_search(String labelName, String valueUsedToSearch) {
		String searchParameterPanel = "//table[@id='searchParameterPanel']";
		// String searchResultForm = "//form[@id='searchResultsForm']";

		String xPathFirstRow = "//form[@id='searchResultsForm']//*[text()='" + valueUsedToSearch
				+ "']/ancestor-or-self::a";
		String inputFieldXpath = searchParameterPanel + "//*[text()='" + labelName
				+ "']/ancestor::td/following-sibling::td[1]//input";
		waitTypeAndEnter(inputFieldXpath, valueUsedToSearch);

		if (findAll(xPathFirstRow).size() > 0) {
			if ($(xPathFirstRow).getText().toLowerCase().equals(valueUsedToSearch.toLowerCase())) {
				$(xPathFirstRow).waitUntilClickable().click();
				waitForAllJSCompletes();
				return true;
			}
		}
		return false;
	}

	/**
	 * Description: Click on search icon near a field in a cell in a data table
	 * then enter valueUsedToSearch to the field with label searchBy to search
	 * and click on the first result
	 * 
	 * @param cellXpath
	 * @param searchBy
	 * @param valueUsedToSearch
	 */
	public void enter_value_by_search(String cellXpath, String searchBy, String valueUsedToSearch) {
		clickSearchIcon(cellXpath);
		waitForAllJSCompletes();
		get_result_search(searchBy, valueUsedToSearch);
	}

	/**
	 * Description: Enter item code in the last row by searching by searchBy
	 * (label name of a search field)
	 * 
	 * @param itemCodeDescription
	 */
	public void enter_item_code_by_description(String rowIndex, String itemCodeDescription) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(costingSheetTableXpath, rowIndex, ITEM_CODE_DESCRIPTION, defaultOrderOfFieldInCell);
		typeAndWaitForAllJSCompletesThenEnter(fieldInCellXpath, itemCodeDescription);
		waitForAllJSCompletes();
	}

	public String get_text_item_code(String rowIndex) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(costingSheetTableXpath, rowIndex, ITEM_CODE_DESCRIPTION,
				defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public String get_text_item_code_description(String drawingObjectNo) {
		String cellXpath = xPathTbDataFieldByPosition(costingSheetTableXpath, drawingObjectNo, ITEM_CODE_DESCRIPTION,
				defaultOrderOfFieldInCell);
		return waitElementToBePresent(cellXpath).getText();
	}

	public void enter_item_remarks(String drawingObjectNo, String itemRemarks) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(costingSheetTableXpath, drawingObjectNo, ITEM_REMARKS,
				defaultOrderOfFieldInCell);
		waitTypeAndEnter(fieldInCellXpath, itemRemarks);
	}

	public String get_text_item_remarks(String drawingObjectNo) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(costingSheetTableXpath, drawingObjectNo, ITEM_REMARKS,
				defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public void enter_drawing_object_qty(String drawingObjectNo, String qty) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(costingSheetTableXpath, drawingObjectNo,
				DRAWING_OBJECT_QTY, defaultOrderOfFieldInCell);
		waitTypeAndEnter(fieldInCellXpath, qty);
		waitForAllJSCompletes();
	}

	public String get_text_drawing_object_qty(String drawingObjectNo) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(costingSheetTableXpath, drawingObjectNo,
				DRAWING_OBJECT_QTY, defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public String get_text_drawing_object_uom(String drawingObjectNo) {
		String cellXpath = xPathTbDataCellByPosition(costingSheetTableXpath, Integer.parseInt(drawingObjectNo),
				DRAWING_OBJECT_UOM);
		String elementInCellXpath = cellXpath + "//*[text() != '']";
		return waitElementToBePresent(elementInCellXpath).getText();
	}

	public void enter_drawing_object_unit_cost(String drawingObjectNo, String unitCost) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(costingSheetTableXpath, drawingObjectNo,
				DRAWING_OBJECT_UNIT_COST, defaultOrderOfFieldInCell);
		waitTypeAndEnter(fieldInCellXpath, unitCost);
		waitForAllJSCompletes();
	}

	public String get_text_unit_cost(String drawingObjectNo) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(costingSheetTableXpath, drawingObjectNo,
				DRAWING_OBJECT_UNIT_COST, defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public void enter_drawing_object_markup_percent(String drawingObjectNo, String markupPercent) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(costingSheetTableXpath, drawingObjectNo,
				DRAWING_OBJECT_MARKUP_PERCENT, defaultOrderOfFieldInCell);
		waitTypeAndEnter(fieldInCellXpath, markupPercent);
		waitForAllJSCompletes();
	}

	public String get_text_drawing_object_markup_percent(String drawingObjectNo) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(costingSheetTableXpath, drawingObjectNo,
				DRAWING_OBJECT_MARKUP_PERCENT, defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public String get_text_drawing_object_budget_cost(String drawingObjectNo) {
		String cellXpath = xPathTbDataCellByPosition(costingSheetTableXpath, Integer.parseInt(drawingObjectNo),
				DRAWING_OBJECT_BUDGET_COST);
		String elementInCellXpath = cellXpath + "//*[text() != '']";
		return waitElementToBePresent(elementInCellXpath).getText();
	}

	public void check_drawing_object(String drawingObjectNo) {
		String cellXpath = xPathTbDataCellByPosition(costingSheetTableXpath, Integer.parseInt(drawingObjectNo),
				DRAWING_OBJECT_CHECKBOX);
		String elementInCellXpath = cellXpath + "//div[contains(@class, 'ui-chkbox-box')]";
		if (!waitElementToBePresent(elementInCellXpath).getAttribute("class").contains(STATE_WHEN_CHECKED)) {
			clickOnElement(elementInCellXpath);
			waitForAllJSCompletes();
		}
	}

	public void uncheck_drawing_object(String drawingObjectNo) {
		String cellXpath = xPathTbDataCellByPosition(costingSheetTableXpath, Integer.parseInt(drawingObjectNo),
				DRAWING_OBJECT_CHECKBOX);
		String elementInCellXpath = cellXpath + "//div[contains(@class, 'ui-chkbox-box')]";
		if (waitElementToBePresent(elementInCellXpath).getAttribute("class").contains(STATE_WHEN_CHECKED)) {
			clickOnElement(elementInCellXpath);
			waitForAllJSCompletes();
		}
	}

	public boolean is_checked_drawing_object(String drawingObjectNo) {
		String cellXpath = xPathTbDataCellByPosition(costingSheetTableXpath, Integer.parseInt(drawingObjectNo),
				DRAWING_OBJECT_CHECKBOX);
		String elementInCellXpath = cellXpath + "//div[contains(@class, 'ui-chkbox-box')]";
		return waitElementToBePresent(elementInCellXpath).getAttribute("class").contains(STATE_WHEN_CHECKED);
	}

	public void expand_phase(String phaseNo) {
		waitForAllJSCompletes();
		String cellXpath = xPathTbDataCellByPosition(phaseDetailsTableXpath, phaseNoToRowIndex(phaseNo),
				PHASE_NO_HEADER_INDEX);
		String toggleButtonXpath = cellXpath + "/span[contains(@class, 'ui-treetable-toggler')]";
		if ($(toggleButtonXpath).getAttribute("class").contains("ui-icon-triangle-1-e")) {
			waitElementToBeClickable(toggleButtonXpath).click();
			waitForAllJSCompletes();
		}
	}

	/**
	 * 
	 * @param phaseNo,
	 *            e.g 1, 1.1, 1.1.1
	 * @return row index corresponding to phase no, e.g if phase no = 1.1.1,
	 *         then output is 3. When output is 0, it means last rows will be
	 *         considered (just a convention)
	 */
	public int phaseNoToRowIndex(String phaseNo) {
		if (phaseNo.isEmpty()) {
			return 0;
		} else {
			String cellXpath = phaseDetailsTableXpath + "//td[text()='" + phaseNo + "']";
			return getTbRowIndexOfDataCell(cellXpath);
		}
	}
	
	private String phaseDetailsTableXpath = detailsTabXpath + "//table[@role='treegrid']";

	/**
	 * @Description: Normally there is only one field in a cell in data table
	 */
	private int defaultOrderOfFieldInCell = 1;

	public String xPathTbDataFieldByPosition(String parentXpath, String phaseNo, int columnIndex,
			int OrderOfFieldInCell) {
		String cellXpath;
		if (parentXpath.equals(phaseDetailsTableXpath)) {
			cellXpath = xPathTbDataCellByPosition(parentXpath, phaseNoToRowIndex(phaseNo), columnIndex);
		} else {
			int rowIndex;
			if (phaseNo.isEmpty()) {
				rowIndex = 0;
			} else {
				rowIndex = Integer.parseInt(phaseNo);
			}

			cellXpath = xPathTbDataCellByPosition(parentXpath, rowIndex, columnIndex);
		}

		// This xpath is used for input, textarea and select tag
		String fieldInCellXpath = cellXpath + "//input[" + OrderOfFieldInCell + "]" + " | " + cellXpath + "//textarea["
				+ OrderOfFieldInCell + "]";
		return fieldInCellXpath;
	}

	public void enter_phase_desc_or_remarks(String phaseNo, String phaseDescOrRemarks) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, PHASE_DESC_OR_REMARKS,
				defaultOrderOfFieldInCell);
		waitTypeAndEnter(fieldInCellXpath, phaseDescOrRemarks);
		waitForAllJSCompletes();
	}

	public String get_text_phase_desc_or_remarks(String phaseNo) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, PHASE_DESC_OR_REMARKS,
				defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public void enter_workhead_group(String phaseNo, String workheadGroup) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, WORKHEAD_GROUP,
				defaultOrderOfFieldInCell);
		waitTypeAndEnter(fieldInCellXpath, workheadGroup);
	}

	public String get_text_workhead_group(String phaseNo) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, WORKHEAD_GROUP,
				defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public void enter_qty(String phaseNo, String qty) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, Qty,
				defaultOrderOfFieldInCell);
		waitTypeAndEnter(fieldInCellXpath, qty);
		waitForAllJSCompletes();
	}

	public String get_text_qty(String phaseNo) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, Qty,
				defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public void enter_uom(String phaseNo, String uom) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, UOM, 2);
		waitTypeAndEnter(fieldInCellXpath, uom);
		waitForAllJSCompletes();
	}

	public String get_text_uom(String phaseNo) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, UOM, 2);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public void enter_unit_price(String phaseNo, String unitPrice) {
		waitForAllJSCompletes();
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, UNIT_PRICE,
				defaultOrderOfFieldInCell);
		waitTypeAndEnter(fieldInCellXpath, unitPrice);
		waitForAllJSCompletes();
	}

	public String get_text_unit_price(String phaseNo) {
		String cellXpath = xPathTbDataCellByPosition(phaseDetailsTableXpath, phaseNoToRowIndex(phaseNo), UNIT_PRICE);
		if (!waitElementToBePresent(cellXpath).getText().isEmpty()) {
			return $(cellXpath).getText();
		} else {
			String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, UNIT_PRICE,
					defaultOrderOfFieldInCell);
			return waitElementToBePresent(fieldInCellXpath).getValue();
		}
	}

	public void enter_disc_percent(String phaseNo, String discPercent) {
		waitForAllJSCompletes();
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, DISC_PERCENT,
				defaultOrderOfFieldInCell);
		waitTypeAndEnter(fieldInCellXpath, discPercent);
		waitForAllJSCompletes();
	}

	public String get_text_disc_percent(String phaseNo) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, DISC_PERCENT,
				defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public void enter_disc_amt(String phaseNo, String discAmt) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, DISC_AMT, 2);
		waitTypeAndEnterThenUpdateValue(fieldInCellXpath, discAmt);
		waitForAllJSCompletes();
	}

	public String get_text_disc_amt(String phaseNo) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, DISC_AMT, 2);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public String get_text_phase_value(String phaseNo) {
		String cellXpath = xPathTbDataCellByPosition(phaseDetailsTableXpath, phaseNoToRowIndex(phaseNo), PHASE_VALUE);
		return waitElementToBePresent(cellXpath).getText();
	}

	public void enter_budget_cost(String phaseNo, String budgetCost) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, BUDGET_COST,
				defaultOrderOfFieldInCell);
		waitTypeAndEnter(fieldInCellXpath, budgetCost);
		waitForAllJSCompletes();
	}

	public String get_text_budget_cost(String phaseNo) {
		String cellXpath = xPathTbDataCellByPosition(phaseDetailsTableXpath, phaseNoToRowIndex(phaseNo), BUDGET_COST);
		if (!waitElementToBePresent(cellXpath).getText().isEmpty()) {
			return $(cellXpath).getText();
		} else {
			String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, BUDGET_COST,
					defaultOrderOfFieldInCell);
			return waitElementToBePresent(fieldInCellXpath).getValue();
		}
	}

	public String get_text_budget_profit(String phaseNo) {
		String cellXpath = xPathTbDataCellByPosition(phaseDetailsTableXpath, phaseNoToRowIndex(phaseNo), BUDGET_PROFIT);
		return waitElementToBePresent(cellXpath).getText();
	}

	public void enter_margin_percent(String phaseNo, String marginPercent) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, MARGIN_PERCENT,
				defaultOrderOfFieldInCell);
		waitTypeAndEnter(fieldInCellXpath, marginPercent);
		waitForAllJSCompletes();
	}

	public String get_text_margin_percent(String phaseNo) {
		try {
			String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, MARGIN_PERCENT,
					defaultOrderOfFieldInCell);

			return waitElementToBePresent(fieldInCellXpath).getValue();
		} catch (Exception e) {
			String cellXpath = xPathTbDataCellByPosition(phaseDetailsTableXpath, phaseNoToRowIndex(phaseNo),
					MARGIN_PERCENT);
			return waitElementToBePresent(cellXpath).getText();
		}
	}

	public void pick_date_to_complete(String phaseNo, String dateToComplete) {
		waitForAllJSCompletes();
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, DATE_TO_COMPLETE,
				defaultOrderOfFieldInCell);
		waitElementToBePresent(fieldInCellXpath).waitUntilClickable().click();
		setCalendarDate(dateToComplete);
	}

	public String get_text_date_to_complete(String phaseNo) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, DATE_TO_COMPLETE,
				defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public void enter_liquidated_damage_remarks_for_a_phase(String phaseNo, String liquidatedDamageRemarks) {
		waitForAllJSCompletes();
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, LIQUIDATED_DAMAGE_REMARKS,
				defaultOrderOfFieldInCell);
		waitTypeAndTab(fieldInCellXpath, liquidatedDamageRemarks);
	}

	public String get_text_liquidated_damage_remarks(String phaseNo) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, LIQUIDATED_DAMAGE_REMARKS,
				defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public String get_parent_phase(String phaseNo) {
		final String NO_PARENT_PHASE = "";
		if (!phaseNo.contains(".")) {
			return NO_PARENT_PHASE;
		} else {
			return phaseNo.substring(0, phaseNo.lastIndexOf("."));
		}
	}

	public void click_btn_add_subphase(String parentPhaseNo) {
		String cellXpath = xPathTbDataCellByPosition(phaseDetailsTableXpath, phaseNoToRowIndex(parentPhaseNo),
				PHASE_ACTIONS);
		String addSubphaseButtonXpath = cellXpath + "/*[" + BTN_ADD_SUBPHASE + "]";
		waitForAllJSCompletes();
		waitElementToBePresent(addSubphaseButtonXpath).waitUntilClickable().click();
		waitForAllJSCompletes();
		expand_phase(parentPhaseNo);
		waitForAllJSCompletes();
	}

	public void click_btn_delete_phase(String phaseNo) {
		String cellXpath = xPathTbDataCellByPosition(phaseDetailsTableXpath, phaseNoToRowIndex(phaseNo), PHASE_ACTIONS);
		String addSubphaseButtonXpath = cellXpath + "/*[" + BTN_DELETE + "]";
		waitElementToBePresent(addSubphaseButtonXpath).click();
		waitForAllJSCompletes();
	}

	public void click_btn_move_phase_up_one_level(String phaseNo) {
		String cellXpath = xPathTbDataCellByPosition(phaseDetailsTableXpath, phaseNoToRowIndex(phaseNo), PHASE_ACTIONS);
		String addSubphaseButtonXpath = cellXpath + "/*[" + BTN_MOVE_PHASE_UP_ONE_LEVEL + "]";
		waitElementToBePresent(addSubphaseButtonXpath).click();
		waitForAllJSCompletes();
	}

	public void click_btn_move_phase_down_one_level(String phaseNo) {
		String cellXpath = xPathTbDataCellByPosition(phaseDetailsTableXpath, phaseNoToRowIndex(phaseNo), PHASE_ACTIONS);
		String addSubphaseButtonXpath = cellXpath + "/*[" + BTN_MOVE_PHASE_DOWN_ONE_LEVEL + "]";
		waitElementToBePresent(addSubphaseButtonXpath).click();
		waitForAllJSCompletes();
	}

	public void click_btn_shift_phase(String phaseNo, String toPhaseNo) {
		String cellXpath = xPathTbDataCellByPosition(phaseDetailsTableXpath, phaseNoToRowIndex(phaseNo), PHASE_ACTIONS);
		String addSubphaseButtonXpath = cellXpath + "/*[" + BTN_SHIFT_PHASE + "]";
		waitElementToBePresent(addSubphaseButtonXpath).click();
		String fieldInCellXpath = xPathTbDataFieldByPosition(phaseDetailsTableXpath, phaseNo, PHASE_DESC_OR_REMARKS,
				defaultOrderOfFieldInCell);
		waitTypeAndEnter(fieldInCellXpath, toPhaseNo);
		waitForAllJSCompletes();
	}

	private String projectOrderSummaryTableXpath = "//table[contains(@id, 'pjOrderSummaryTable')]";

	public void enter_currency(String currency) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(projectOrderSummaryTableXpath, CURRENCY_ROW_INDEX,
				CURRENCY_HEADER_INDEX, defaultOrderOfFieldInCell);
		typeAndWaitForAllJSCompletesThenEnter(fieldInCellXpath, currency);
		waitForAllJSCompletes();
	}

	public String get_text_currency() {
		String fieldInCellXpath = xPathTbDataFieldByPosition(projectOrderSummaryTableXpath, CURRENCY_ROW_INDEX,
				CURRENCY_HEADER_INDEX, defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}
	
	public String get_text_exch_rate() {
		String fieldInCellXpath = xPathTbDataFieldByPosition(projectOrderSummaryTableXpath, EXCH_RATE_ROW_INDEX,
				EXCH_RATE_HEADER_INDEX, defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public String get_text_nature_project_sum() {
		String cellXpath = xPathTbDataCellByPosition(projectOrderSummaryTableXpath,
				Integer.parseInt(PROJECT_SUM_ROW_INDEX), NATURE_HEADER_INDEX);
		return waitElementToBePresent(cellXpath).getText();
	}

	public String get_text_home_project_sum() {
		String cellXpath = xPathTbDataCellByPosition(projectOrderSummaryTableXpath,
				Integer.parseInt(PROJECT_SUM_ROW_INDEX), HOME_HEADER_INDEX);
		return waitElementToBePresent(cellXpath).getText();
	}

	public String get_text_nature_project_budget_cost() {
		String cellXpath = xPathTbDataCellByPosition(projectOrderSummaryTableXpath,
				Integer.parseInt(PROJECT_BUDGET_COST_ROW_INDEX), NATURE_HEADER_INDEX);
		return waitElementToBePresent(cellXpath).getText();
	}

	public String get_text_home_project_budget_cost() {
		String cellXpath = xPathTbDataCellByPosition(projectOrderSummaryTableXpath,
				Integer.parseInt(PROJECT_BUDGET_COST_ROW_INDEX), HOME_HEADER_INDEX);
		return waitElementToBePresent(cellXpath).getText();
	}

	public String get_text_nature_project_budget_profit() {
		String cellXpath = xPathTbDataCellByPosition(projectOrderSummaryTableXpath,
				Integer.parseInt(PROJECT_BUDGET_PROFIT_ROW_INDEX), NATURE_HEADER_INDEX);
		return waitElementToBePresent(cellXpath).getText();
	}

	public String get_text_home_project_budget_profit() {
		String cellXpath = xPathTbDataCellByPosition(projectOrderSummaryTableXpath,
				Integer.parseInt(PROJECT_BUDGET_PROFIT_ROW_INDEX), HOME_HEADER_INDEX);
		return waitElementToBePresent(cellXpath).getText();
	}

	public String get_text_project_budget_percent() {
		String cellXpath = xPathTbDataCellByPosition(projectOrderSummaryTableXpath,
				Integer.parseInt(PROJECT_BUDGET_PROFIT_ROW_INDEX), PROJECT_BUDGET_PROFIT_PERCENT);
		String result = waitElementToBePresent(cellXpath).getText();
		String number = result.substring(0, result.indexOf("%"));
		return number;
	}

	public void enter_sales_tax(String salesTax) {
		waitForAllJSCompletes();
		String fieldInCellXpath = xPathTbDataFieldByPosition(projectOrderSummaryTableXpath, SALES_TAX_ROW_INDEX,
				SALES_TAX_INPUT_FIELD_HEADER_INDEX, defaultOrderOfFieldInCell);
		typeAndWaitForAllJSCompletesThenEnter(fieldInCellXpath, salesTax);
		waitForAllJSCompletes();
	}

	/**
	 * 
	 * @param salesTax
	 * @return Sales Tax Code
	 */
	public String get_text_sales_tax() {
		String fieldInCellXpath = xPathTbDataFieldByPosition(projectOrderSummaryTableXpath, SALES_TAX_ROW_INDEX,
				SALES_TAX_INPUT_FIELD_HEADER_INDEX, defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public String get_text_nature_sales_tax() {
		String cellXpath = xPathTbDataCellByPosition(projectOrderSummaryTableXpath,
				Integer.parseInt(SALES_TAX_ROW_INDEX), NATURE_HEADER_INDEX);
		return waitElementToBePresent(cellXpath).getText();
	}

	public String get_text_home_sales_tax() {
		String cellXpath = xPathTbDataCellByPosition(projectOrderSummaryTableXpath,
				Integer.parseInt(SALES_TAX_ROW_INDEX), HOME_HEADER_INDEX);
		return waitElementToBePresent(cellXpath).getText();
	}

	public String get_text_nature_project_value_incl_tax() {
		String cellXpath = xPathTbDataCellByPosition(projectOrderSummaryTableXpath,
				Integer.parseInt(PROJECT_VALUE_INCL_TAX), NATURE_HEADER_INDEX);
		return waitElementToBePresent(cellXpath).getText();
	}

	public String get_text_home_project_value_incl_tax() {
		String cellXpath = xPathTbDataCellByPosition(projectOrderSummaryTableXpath,
				Integer.parseInt(PROJECT_VALUE_INCL_TAX), HOME_HEADER_INDEX);
		return waitElementToBePresent(cellXpath).getText();
	}

	// Team Members
	public void click_btn_add_employees() {
		String addTeamMembersButtonXpath = xPathAddBtnByTbTitle(TEAM_MEMBERS_TABLE_TITLE);
		waitForAllJSCompletes();
		waitElementToBeClickable(addTeamMembersButtonXpath).click();
		waitForAllJSCompletes();
	}

	public void click_btn_delete_employees() {
		String deleteTeamMembersBtnXpath = xPathDeleteBtnByTbTitle(TEAM_MEMBERS_TABLE_TITLE);
		waitElementToBeClickable(deleteTeamMembersBtnXpath).click();
		waitForAllJSCompletes();
	}

	public void click_btn_view_by_role(String viewByRole) {
		clickBtn(VIEW_BY_ROLE);
		waitForAllJSCompletes();
	}

	private String teamMembersTableXpath = xPathTbDataWithTitle(TEAM_MEMBERS_TABLE_TITLE);

	public void typeAndWaitForAllJSCompletesThenEnter(String elementXpath, String valueToType) {
		$(elementXpath).clear();
		$(elementXpath).sendKeys(valueToType);
		waitForAllJSCompletes();
		$(elementXpath).sendKeys(Keys.ENTER);
	}

	/**
	 * Description: Enter employee code to the last row
	 * 
	 * @param employee: can be employee code or employee name
	 */
	public void enter_employee(String employee) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(teamMembersTableXpath, Integer.toString(LAST_ROW),
				EMPLOYEE_CODE, defaultOrderOfFieldInCell);
		typeAndWaitForAllJSCompletesThenEnter(fieldInCellXpath, employee);
		waitForAllJSCompletes();
	}

	public void enter_employee(String employee, String rowIndex) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(teamMembersTableXpath, rowIndex, EMPLOYEE_CODE,
				defaultOrderOfFieldInCell);
		typeAndWaitForAllJSCompletesThenEnter(fieldInCellXpath, employee);
		waitForAllJSCompletes();
	}

	public String get_text_employee_code(String employeeCode, String rowIndex) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(teamMembersTableXpath, rowIndex, EMPLOYEE_CODE,
				defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public String get_text_employee_name(String rowIndex) {
		String cellXpath = xPathTbDataCellByPosition(teamMembersTableXpath, Integer.parseInt(rowIndex), EMPLOYEE_CODE);
		return waitElementToBePresent(cellXpath).getText();
	}

	/**
	 * 
	 * @param employee:
	 *            can be employee code or employee name
	 * @param chkboxLabel
	 * @param rowIndex
	 * @Description: Employee code must be input before using this method
	 */
	public void check_role_in_project_with_employee_name(String employeeName, String chkboxLabelList) {
		String[] labelList = chkboxLabelList.split(VALUE_DEMILITER);
		for (String label : labelList) {
			String chkboxXpath = teamMembersTableXpath + "//td[text()='" + employeeName + "']/following-sibling::td["
					+ (ROLE_IN_PROJECT_HEADER_INDEX - 1) + "]//div[span[text()='" + label
					+ "'] and contains(@class, 'chkbox')]/div[contains(@class, 'ui-state')]";
			if (!waitElementToBePresent(chkboxXpath).getAttribute("class").contains(STATE_WHEN_CHECKED)) {
				clickOnElement(chkboxXpath);
				waitForAllJSCompletes();
			}
		}
	}

	public boolean is_checked_role_in_project_with_employee_name(String employeeName, String chkboxLabelList) {
		String[] labelList = chkboxLabelList.split(VALUE_DEMILITER);
		for (String label : labelList) {
			String chkboxXpath = teamMembersTableXpath + "//td[text()='" + employeeName + "']/following-sibling::td["
					+ (ROLE_IN_PROJECT_HEADER_INDEX - 1) + "]//div[span[text()='" + label
					+ "'] and contains(@class, 'chkbox')]";
			if (!waitElementToBePresent(chkboxXpath).getAttribute("class").contains(STATE_WHEN_CHECKED)) {
				return false;
			}
		}
		return true;
	}

	public void make_key_person(String employeeName, String roleNameList) {
		String[] roleList = roleNameList.split(VALUE_DEMILITER);
		for (String role : roleList) {
			String starXpath = teamMembersTableXpath + "//td[text()='" + employeeName + "']/following-sibling::td["
					+ (ROLE_IN_PROJECT_HEADER_INDEX - 1) + "]//div[span[text()='" + role
					+ "'] and contains(@class, 'chkbox')]" + "/preceding-sibling::button";
			String spanTagInButtonTagXpath = starXpath + "//span[contains(@class, 'ui-icon')]";
			waitForAllJSCompletes();
			if (waitElementToBePresent(spanTagInButtonTagXpath).getAttribute("class")
					.contains(STAR_STATE_WHEN_UNCHECKED)) {
				clickOnElement(starXpath);
				waitForAllJSCompletes();
			}
		}

	}

	public boolean is_made_key_person(String employeeName, String roleNameList) {
		String[] roleList = roleNameList.split(VALUE_DEMILITER);
		for (String role : roleList) {
			String starXpath = teamMembersTableXpath + "//td[text()='" + employeeName + "']/following-sibling::td[" + (ROLE_IN_PROJECT_HEADER_INDEX - 1)
					+ "]//div[span[text()='" + role + "'] and contains(@class, 'chkbox')]"
					+ "/preceding-sibling::button";
			String spanTagInButtonTagXpath = starXpath + "//span[contains(@class, 'ui-icon')]";
			waitForAllJSCompletes();
			if (waitElementToBePresent(spanTagInButtonTagXpath).getAttribute("class")
					.contains(STAR_STATE_WHEN_UNCHECKED)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @Description: Assume that the precondition is that the check box is not
	 *               checked
	 * @param employeeName
	 */
	public void check_employee(String employeeName) {
		String chkboxXpath = teamMembersTableXpath + "//td[text()='" + employeeName + "']/following-sibling::td[last()]//div[contains(@class, 'chkbox')]";
		clickOnElement(chkboxXpath);
		waitForAllJSCompletes();
	}

	// Payment Info
	private void select_in_dropdown_list_with_label(String labelName, String value) {
		String labelXpath = "//*[text()='" + labelName + "']/ancestor::td//label";
		clickOnElement(labelXpath);
		waitForAllJSCompletes();

		String optionXpath = "//ul[@role='listbox']/li[text()='" + value + "']";
		$(optionXpath).waitUntilPresent().waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	private void select_in_dropdown_list_with_label(String labelName, String value, int labelOrder) {
		String labelXpath = "//*[text()='" + labelName + "']/ancestor::td//label";
		waitForAllJSCompletes();
		clickOnElement(labelXpath);
		waitForAllJSCompletes();

		String optionXpath = "(//ul[@role='listbox']/li[text()='" + value + "'])[" + labelOrder + "]";
		waitForAllJSCompletes();
		$(optionXpath).waitUntilPresent().waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	/**
	 * @Description: Get selected value from dropdown list with label name
	 * @param labelName
	 */
	private String get_selected_value_of_dropdown_list_with_label(String labelName) {
		String labelXpath = "//*[text()='" + labelName + "']/ancestor::td//label";
		return waitElementToBePresent(labelXpath).getText();
	}

	public void select_in_billing_type(String billingType) {
		select_in_dropdown_list_with_label(BILLING_TYPE, billingType);
	}

	public String get_text_billing_type() {
		return get_selected_value_of_dropdown_list_with_label(BILLING_TYPE);
	}

	public void enter_cutoff_date(String cutoffDate) {
		enterInputFieldWithLabel(CUTOFF_DATE, cutoffDate);
	}

	public String get_text_cutoff_date() {
		return getTextValueWithLabel(CUTOFF_DATE);
	}

	/**
	 * 
	 * @param billingParty:
	 *            can be customer code or customer name
	 */
	public void enter_billing_party(String billingParty) {
		String fieldXpath = xPathInputFieldWithLabel(BILLING_PARTY);
		typeAndWaitForAllJSCompletesThenEnter(fieldXpath, billingParty);
		waitForAllJSCompletes();
	}

	public String get_text_billing_party() {
		return getTextValueWithLabel(BILLING_PARTY);
	}

	public void enter_billing_contact(String billingContact) {
		String fieldXpath = xPathInputFieldWithLabel(BILLING_CONTACT);
		typeAndWaitForAllJSCompletesThenEnter(fieldXpath, billingContact);
		waitForAllJSCompletes();
	}

	public String get_text_billing_contact() {
		return getTextValueWithLabel(BILLING_CONTACT);
	}

	/**
	 * 
	 * @param billingAddress:
	 *            can be address code or party address description
	 */
	public void enter_billing_address(String billingAddress) {
		String fieldXpath = xPathInputFieldWithLabel(BILLING_ADDRESS);
		typeAndWaitForAllJSCompletesThenEnter(fieldXpath, billingAddress);
		waitForAllJSCompletes();
	}

	public String get_text_billing_address() {
		return getTextValueWithLabel(BILLING_ADDRESS);
	}

	public void select_in_payment_option(String paymentOption) {
		select_in_dropdown_list_with_label(PAYMENT_OPTION, paymentOption);
	}

	public String get_text_payment_option() {
		return get_selected_value_of_dropdown_list_with_label(PAYMENT_OPTION);
	}

	public void select_in_payment_term(String paymentTerm) {
		if (paymentTerm.equals("Cash on Delivery") || paymentTerm.equals("Advance Payment")) {
			select_in_dropdown_list_with_label(PAYMENT_TERM, paymentTerm, 2);
		} else {
			select_in_dropdown_list_with_label(PAYMENT_TERM, paymentTerm);
		}
	}

	public String get_text_payment_term() {
		return get_selected_value_of_dropdown_list_with_label(PAYMENT_TERM);
	}

	public void select_in_payment_method(String paymentMethod) {
		select_in_dropdown_list_with_label(PAYMENT_METHOD, paymentMethod);
	}

	public String get_text_payment_method() {
		return get_selected_value_of_dropdown_list_with_label(PAYMENT_TERM);
	}

	public void enter_payment_tenor(String paymentTenor) {
		enterInputFieldWithLabel(PAYMENT_TENOR, paymentTenor);
	}

	public String get_text_payment_tenor() {
		return getTextValueWithLabel(PAYMENT_TENOR);
	}

	public void enter_tenor_term(String tenorTerm) {
		String fieldXpath = xPathInputFieldWithLabel(TENOR_TERM);
		typeAndWaitForAllJSCompletesThenEnter(fieldXpath, tenorTerm);
		waitForAllJSCompletes();
	}

	public String get_text_tenor_term() {
		return getTextValueWithLabel(TENOR_TERM);
	}

	private String xPathTbDataWithTitle(String title) {
		return "//*[text()='" + title + "']/ancestor::form//table[@role='grid']";
	}

	private String xpathTableBonds = xPathTbDataWithTitle(BONDS);

	// Bonds and Insurance
	public void click_btn_add_bonds() {
		String btnAddBondsXpath = xPathAddBtnByTbTitle(BONDS);
		waitElementToBeClickable(btnAddBondsXpath).click();
		waitForAllJSCompletes();
	}

	public void click_btn_delete_bonds(String deleteBonds) {
		String btnDeleteBondsXpath = xPathDeleteBtnByTbTitle(BONDS);
		waitElementToBeClickable(btnDeleteBondsXpath).click();
		waitForAllJSCompletes();
	}

	public void enter_bond_ref_no(String bondRefNo, String rowIndex) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(xpathTableBonds, rowIndex, BOND_REF_NO,
				defaultOrderOfFieldInCell);
		waitTypeAndEnter(fieldInCellXpath, bondRefNo);
	}

	private final int LAST_ROW = 0;

	@Override
	public String xPathTbDataCellByPosition(String _parentXpath, int _rowIndex, int _headerIndex) {
		// Convention: when rowIndex = 0, we will return xpath of the cell in
		// the last row
		if (_rowIndex == LAST_ROW) {
			return "((" + _parentXpath + "//tbody[preceding::thead])[1]//tr/td[" + _headerIndex + "])[" + "last()"
					+ "]";
		} else {
			return "((" + _parentXpath + "//tbody[preceding::thead])[1]//tr/td[" + _headerIndex + "])[" + _rowIndex
					+ "]";
		}
	}

	/**
	 * 
	 * @param parentXpath
	 * @param headerIndex
	 * @return xpath of the cell in the last row
	 */
	public String xPathTbDataCellByPosition(String parentXpath, int headerIndex) {
		return xPathTbDataCellByPosition(parentXpath, LAST_ROW, headerIndex);
	}

	/**
	 * 
	 * @param parentXpath
	 * @param headerIndex
	 * @return xpath of field in the last row
	 */
	public String xPathTbDataFieldByPosition(String parentXpath, int headerIndex) {
		return xPathTbDataFieldByPosition(parentXpath, "", headerIndex, defaultOrderOfFieldInCell);
	}

	public void enter_bond_ref_no(String bondRefNo) {
		waitForAllJSCompletes();
		String fieldInCellXpath = xPathTbDataFieldByPosition(xpathTableBonds, BOND_REF_NO);
		waitTypeAndEnter(fieldInCellXpath, bondRefNo);
	}

	public String get_text_bond_ref_no(String rowIndex) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(xpathTableBonds, rowIndex, BOND_REF_NO,
				defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getText();
	}

	/**
	 * @Description: Search for xpath of a field or textarea using value in a
	 *               key field, e.g using employee code to find the row, then
	 *               use header index to find field
	 * @Note: Only the case searchedFieldHeaderIndex > keyFieldHeaderIndex is
	 *        considered currently
	 */
	public String xPathTbDataFieldByKeyField(String parentXpath, String keyFieldValue, int keyFieldHeaderIndex,
			int searchedFieldHeaderIndex, int orderOfFieldInCell) {
		if (searchedFieldHeaderIndex > keyFieldHeaderIndex) {
			// This xpath find all td in the same row that are behind td
			// containing key field
			String cellXpathWithKeyField = "//input[@value='" + keyFieldValue + "']/ancestor::td/following-sibling::td["
					+ (searchedFieldHeaderIndex - keyFieldHeaderIndex) + "]";
			String cellXpathWithKeyFieldAndParent = parentXpath + cellXpathWithKeyField;
			String fieldInCellXpath = cellXpathWithKeyFieldAndParent + "//input[" + orderOfFieldInCell + "]" + " | "
					+ cellXpathWithKeyFieldAndParent + "//textarea[" + orderOfFieldInCell + "]";

			return fieldInCellXpath;
		} else {
			return "";
		}

	}

	public String xPathTbDataFieldByKeyField(String parentXpath, String keyFieldValue, int keyFieldHeaderIndex,
			int searchedFieldHeaderIndex) {
		return xPathTbDataFieldByKeyField(parentXpath, keyFieldValue, keyFieldHeaderIndex, searchedFieldHeaderIndex,
				defaultOrderOfFieldInCell);
	}

	/**
	 * 
	 * @param startDate
	 *            in format ddmmyyyy
	 * @param bondRefNo
	 */
	public void pick_start_date_with_bond_ref_no(String startDate, String bondRefNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(xpathTableBonds, bondRefNo, BOND_REF_NO, BOND_START_DATE);
		clickOnElement(fieldInCellXpath);
		waitForAllJSCompletes();
		setCalendarDate(startDate);
		waitForAllJSCompletes();
	}

	public String get_text_start_date_with_bond_ref_no(String bondRefNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(xpathTableBonds, bondRefNo, BOND_REF_NO, BOND_START_DATE);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	/**
	 * 
	 * @param endDate
	 *            in format ddmmyyyy
	 * @param bondRefNo
	 */
	public void pick_end_date_with_bond_ref_no(String endDate, String bondRefNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(xpathTableBonds, bondRefNo, BOND_REF_NO, BOND_END_DATE);
		waitForAllJSCompletes();
		clickOnElement(fieldInCellXpath);
		waitForAllJSCompletes();
		setCalendarDate(endDate);
		waitForAllJSCompletes();
	}

	public String get_text_end_date_with_bond_ref_no(String bondRefNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(xpathTableBonds, bondRefNo, BOND_REF_NO, BOND_END_DATE);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	/**
	 * 
	 * @param issuingParty:
	 *            can be party code or party name
	 * @param bondRefNo
	 */
	public void enter_issuing_party_with_bond_ref_no(String issuingParty, String bondRefNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(xpathTableBonds, bondRefNo, BOND_REF_NO, ISSUING_PARTY);
		typeAndWaitForAllJSCompletesThenEnter(fieldInCellXpath, issuingParty);
		waitForAllJSCompletes();
	}

	public String get_text_issuing_party_with_bond_ref_no(String bondRefNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(xpathTableBonds, bondRefNo, BOND_REF_NO, ISSUING_PARTY);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public void enter_bond_dlp_with_bond_ref_no(String dlp, String bondRefNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(xpathTableBonds, bondRefNo, BOND_REF_NO, BONDS_DLP);
		waitForAllJSCompletes();
		waitTypeAndEnter(fieldInCellXpath, dlp);
	}

	public String get_text_bond_dlp_with_bond_ref_no(String bondRefNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(xpathTableBonds, bondRefNo, BOND_REF_NO, BONDS_DLP);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public void pick_actual_expiry_date_with_bond_ref_no(String actualExpiryDate, String bondRefNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(xpathTableBonds, bondRefNo, BOND_REF_NO,
				ACTUAL_EXPIRY_DATE);
		clickOnElement(fieldInCellXpath);
		waitForAllJSCompletes();
		setCalendarDate(actualExpiryDate);
		waitForAllJSCompletes();
	}

	public String get_text_actual_expiry_date_with_bond_ref_no(String bondRefNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(xpathTableBonds, bondRefNo, BOND_REF_NO,
				ACTUAL_EXPIRY_DATE);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public void enter_remarks_with_bond_ref_no(String remarks, String bondRefNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(xpathTableBonds, bondRefNo, BOND_REF_NO, REMARKS);
		waitTypeAndTab(fieldInCellXpath, remarks);
		waitForAllJSCompletes();
	}

	public String get_text_remarks_with_bond_ref_no(String bondRefNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(xpathTableBonds, bondRefNo, BOND_REF_NO, REMARKS);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	/**
	 * @Description: Assume that the precondition is that the check box is not
	 *               checked
	 * @param bondRefNo
	 */
	public void check_bond_with_bond_ref_no(String bondRefNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(xpathTableBonds, bondRefNo, BOND_REF_NO, BOND_CHECKBOX);
		clickOnElement(fieldInCellXpath);
		waitForAllJSCompletes();
	}

	// Insurance
	public void click_btn_add_policies() {
		waitForAllJSCompletes();
		String elementxPath = xPathAddBtnByTbTitle(INSURANCE_TABLE_TITLE);
		waitElementToBePresent(elementxPath).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public void click_btn_delete_policies() {
		clickOnElement(xPathAddBtnByTbTitle(INSURANCE_TABLE_TITLE));
		waitForAllJSCompletes();
	}

	private String insuranceTableXpath = xPathTbDataWithTitle(INSURANCE_TABLE_TITLE);

	/**
	 * Description: Go to the last row and enter policy no
	 * 
	 * @param policyNo
	 */
	public void enter_policy_no(String policyNo) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(insuranceTableXpath, POLICY_NO);
		waitForAllJSCompletes();
		waitTypeAndEnter(fieldInCellXpath, policyNo);
	}

	/**
	 * Description: Get policy no using row index
	 * 
	 * @param rowIndex
	 */
	public String get_text_policy_no(String rowIndex) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(insuranceTableXpath, rowIndex, POLICY_NO,
				defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	/**
	 * Description: Go to the last row and enter policy type
	 * 
	 * @param policyType:
	 *            can be policy type code or policy type description
	 */
	public void enter_policy_type(String policyType) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(insuranceTableXpath, POLICY_TYPE);
		typeAndWaitForAllJSCompletesThenEnter(fieldInCellXpath, policyType);
		waitForAllJSCompletes();
	}

	public String get_text_policy_type_with_policy_no(String policyNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(insuranceTableXpath, policyNo, POLICY_NO, POLICY_TYPE);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	/**
	 * Description: Go to the last row and enter start date
	 * 
	 * @param startDate
	 *            in format ddmmyyyy
	 */
	public void pick_policy_start_date(String startDate) {
		waitForAllJSCompletes();
		String fieldInCellXpath = xPathTbDataFieldByPosition(insuranceTableXpath, INSURANCE_START_DATE);
		clickOnElement(fieldInCellXpath);
		waitForAllJSCompletes();
		setCalendarDate(startDate);
		waitForAllJSCompletes();
	}

	public String get_text_start_date_with_policy_no(String policyNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(insuranceTableXpath, policyNo, POLICY_NO,
				INSURANCE_START_DATE);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	/**
	 * Description: Go to the last row and enter end date
	 * 
	 * @param endDate
	 *            in format ddmmyyyy
	 */
	public void pick_policy_end_date(String endDate) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(insuranceTableXpath, INSURANCE_END_DATE);
		waitForAllJSCompletes();
		clickOnElement(fieldInCellXpath);
		waitForAllJSCompletes();
		setCalendarDate(endDate);
		waitForAllJSCompletes();
	}

	public String get_text_end_date_with_policy_no(String policyNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(insuranceTableXpath, policyNo, POLICY_NO,
				INSURANCE_END_DATE);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	/**
	 * Description: Go to the last row and enter insurance company
	 * 
	 * @param insuranceCompany:
	 *            can be party code or party name
	 */
	public void enter_insurance_company(String insuranceCompany) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(insuranceTableXpath, INSURANCE_COMPANY);
		typeAndWaitForAllJSCompletesThenEnter(fieldInCellXpath, insuranceCompany);
		waitForAllJSCompletes();
	}

	public String get_text_insurance_company_with_policy_no(String policyNo) {
		String fieldInCellXpath = xPathTbDataFieldByKeyField(insuranceTableXpath, policyNo, POLICY_NO,
				INSURANCE_COMPANY);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public void check_insured_with_policy_no(String insuredList, String policyNo) {
		String[] insList = insuredList.split(", ");
		for (String ins : insList) {
			String chkboxXpath = insuranceTableXpath + "//input[@value='" + policyNo
					+ "']/ancestor::td/following-sibling::td[" + (INSURED - POLICY_NO) + "]//div[span[text()='" + ins
					+ "'] and contains(@class, 'chkbox')]";
			if (!waitElementToBePresent(chkboxXpath).getAttribute("class").contains(STATE_WHEN_CHECKED)) {
				clickOnElement(chkboxXpath);
				waitForAllJSCompletes();
			}
		}
	}

	public boolean is_checked_insured_with_policy_no(String insuredList, String policyNo) {
		String[] insList = insuredList.split(", ");
		for (String ins : insList) {
			String chkboxXpath = insuranceTableXpath + "//input[@value='" + policyNo
					+ "']/ancestor::td/following-sibling::td[" + (INSURED - POLICY_NO) + "]//div[span[text()='" + ins
					+ "'] and contains(@class, 'chkbox')]";
			if (!waitElementToBePresent(chkboxXpath).getAttribute("class").contains(STATE_WHEN_CHECKED)) {
				return false;
			}
		}
		return true;
	}

	public void enter_policy_remarks(String remarks) {
		waitForAllJSCompletes();
		String fieldInCellXpath = xPathTbDataFieldByPosition(insuranceTableXpath, POLICY_REMARKS);
		waitTypeAndTab(fieldInCellXpath, remarks);
		waitForAllJSCompletes();
	}

	public String get_text_policy_remarks_with_policy_no(String policyNo) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(insuranceTableXpath, policyNo, POLICY_NO, POLICY_REMARKS);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public String xPathTbDataChkboxByPosition(String parentXpath, String rowIndex, int headerIndex) {
		String cellXpath = xPathTbDataCellByPosition(parentXpath, Integer.parseInt(rowIndex), headerIndex);
		String chkboxInCellXpath = cellXpath + "//div[contains(@class, 'ui-chkbox-box')]";
		return chkboxInCellXpath;
	}

	public void check_policy_with_policy_no(String policyNo) {
		String elementInCellXpath = xPathTbDataChkboxByPosition(insuranceTableXpath, policyNo, INSURANCE_CHECKBOX);
		if (!waitElementToBePresent(elementInCellXpath).getAttribute("class").contains(STATE_WHEN_CHECKED)) {
			clickOnElement(elementInCellXpath);
			waitForAllJSCompletes();
		}
	}

	// Remarks and attachments
	public void enter_subject_detail(String subjectDetail) {
		enterTextAreaWithLabel(SUBJECT_DETAIL, subjectDetail);
	}

	public String get_text_subject_detail() {
		return getTextValueWithLabel(SUBJECT_DETAIL);
	}

	public void enter_terms_and_condition(String termsAndCondition) {
		enterTextAreaWithLabel(TERMS_CONDITION, termsAndCondition);
		waitForAllJSCompletes();
	}

	public String get_text_terms_and_condition() {
		return getTextValueWithLabel(TERMS_CONDITION);
	}

	public void enter_internal_remarks(String internalRemarks) {
		enterTextAreaWithLabel(INTERNAL_REMARKS, internalRemarks);
		waitForAllJSCompletes();
	}

	public String get_text_internal_remarks() {
		return getTextValueWithLabel(INTERNAL_REMARKS);
	}

	public void enter_external_remarks(String externalRemarks) {
		enterTextAreaWithLabel(EXTERNAL_REMARKS, externalRemarks);
	}

	public String get_text_external_remarks() {
		return getTextValueWithLabel(EXTERNAL_REMARKS);
	}

	public void enter_liquidated_damage_remarks(String liquidatedDamageRemarks) {
		enterTextAreaWithLabel(LIQUIDATED_DAMAGE_REMARKS_LABEL, LIQUIDATED_DAMAGE_REMARKS_LABEL);
	}

	public String get_text_liquidated_damage_remarks() {
		return getTextValueWithLabel(LIQUIDATED_DAMAGE_REMARKS_LABEL);
	}

	private String uploadFormXpath = "//form[contains(@id, 'fileAttachmentComponentForm')]";

	/**
	 * Description: Add a file Install.log in C:\\Install.log
	 */
	public void add_a_file(String fileName) {
		waitForAllJSCompletes();
		String addFileBtnXpath = uploadFormXpath + "//button[*[contains(@class, 'fa-plus')]]";
		waitElementToBePresentThenScrollIntoView(addFileBtnXpath).waitUntilClickable().click();
		waitForAllJSCompletes();

		StringSelection ss = new StringSelection(fileName);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void click_btn_delete_files(String deleteFiles) {
		String deleteBtnXpath = uploadFormXpath + "//button[*[contains(@class, 'fa-trash-o')]]";
		waitElementToBePresent(deleteBtnXpath).click();
		waitForAllJSCompletes();
	}

	private String uploadTableXpath = uploadFormXpath + "//table[@role='grid']";

	public String get_text_file_name(String rowIndex) {
		String cellXpath = xPathTbDataCellByPosition(uploadTableXpath, Integer.parseInt(rowIndex), FILE_NAME);
		return waitElementToBePresent(cellXpath).getText();
	}

	public void enter_file_description(String fileDescription, int rowIndex) {
		waitForAllJSCompletes();
		String fieldInCellXpath = xPathTbDataFieldByPosition(uploadTableXpath, Integer.toString(rowIndex),
				FILE_DESCRIPTION, defaultOrderOfFieldInCell);
		waitTypeAndEnter(fieldInCellXpath, fileDescription);
	}

	public String get_text_file_description(String rowIndex) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(uploadTableXpath, rowIndex, FILE_DESCRIPTION,
				defaultOrderOfFieldInCell);
		return waitElementToBePresent(fieldInCellXpath).getValue();
	}

	public String get_text_mime_type(String rowIndex) {
		String cellXpath = xPathTbDataCellByPosition(uploadTableXpath, Integer.parseInt(rowIndex), MIME_TYPE);
		return waitElementToBePresent(cellXpath).getText();
	}

	public String get_text_file_size(String rowIndex) {
		String cellXpath = xPathTbDataCellByPosition(uploadTableXpath, Integer.parseInt(rowIndex), FILE_SIZE);
		return waitElementToBePresent(cellXpath).getText();
	}

	public void click_btn_dowload(String rowIndex) {
		String cellXpath = xPathTbDataCellByPosition(uploadTableXpath, Integer.parseInt(rowIndex), DOWNLOAD);
		String btnInCellXpath = cellXpath + "//button";
		clickOnElement(btnInCellXpath);
		waitForAllJSCompletes();
	}

	public void check_file(String rowIndex) {
		String elementInCellXpath = xPathTbDataChkboxByPosition(uploadTableXpath, rowIndex, FILE_CHECKBOX);
		if (!waitElementToBePresent(elementInCellXpath).getAttribute("class").contains(STATE_WHEN_CHECKED)) {
			clickOnElement(elementInCellXpath);
			waitForAllJSCompletes();
		}
	}

	// Summary screen

	/// In Draft Tab
	private String draftSummaryTableXpath = "//form[@id='syn:summaryTabs:summaryDraftForm']";

	/**
	 * Description: Search for project estimation by entering project no to
	 * field in header then click on the result in the first row
	 * 
	 * @param projectNo
	 * @return
	 */
	public boolean is_there_project_estimation_by_project_no(String projectNo) {
		String headerCellXpath = xPathTbHeaderCell(PROJECT_NO);
		filterDataByHeader(headerCellXpath, projectNo);
		String firstCellInFirstRowXpath = draftSummaryTableXpath + "//tr[1]//td[1]";
		if (waitElementToBePresent(firstCellInFirstRowXpath).getText().equals(NO_RECORDS_FOUND)) {
			return false;
		} else {
			String linkInFirstCell = firstCellInFirstRowXpath + "//a";
			clickOnElement(linkInFirstCell);
			waitForAllJSCompletes();
			return true;
		}
	}

	public String xPathTbDataLinkXpath(String tableXpath, String rowIndex, int headerIndex) {
		String cellXpath = xPathTbDataCellByPosition(tableXpath, Integer.parseInt(rowIndex), POLICY_NO_HEADER_INDEX);
		String linkInCellXpath = cellXpath + "//a";
		return linkInCellXpath;
	}

    public void enterExchangeRate(String exchangeRate) {
		String fieldInCellXpath = xPathTbDataFieldByPosition(projectOrderSummaryTableXpath, CURRENCY_ROW_INDEX,
				4, defaultOrderOfFieldInCell);
		typeAndWaitForAllJSCompletesThenEnter(fieldInCellXpath, exchangeRate);
		waitForAllJSCompletes();
    }

	public void saveProjectOrderVoucher() {
		String dataKey = "Project Order Voucher";

		SessionData.addToListString(dataKey, get_project_no());
	}

}
