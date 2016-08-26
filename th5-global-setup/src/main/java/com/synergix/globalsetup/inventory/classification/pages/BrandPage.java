package com.synergix.globalsetup.inventory.classification.pages;

import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

/**
 * @author Lily.Hoang
 *
 */
public class BrandPage extends TH5PageObject {
	public BrandPage(WebDriver driver) {
		super(driver);
	}
	// private static final String GL_ACCOUNT_CODE = "GL Account Code";

	// Button Public
	private String xPathBtnClose = "//input[contains(@id,'brandForm')] [@type='button'][@value='Close']";
	private String xPathBtnNew = "//input[@value='New']";
	private String xPathBtnDelete = "//input[contains(@id,'brandForm')] [@type='button'][@value='Delete']";
	private String xPathBtnSearch = "//input[contains(@id,'brandForm')] [@type='button'][@value='Search']";
	private String xPathBtnUpdate = "//input[contains(@id,'brandForm')] [@type='button'][@value='Update']";
	// Button inside tab
	private String xPathBtnServiceLevelAdd = "//*[@id='brandForm:serviceLevelAddButton']";
	private String xPathBtnServiceLevelDelete = "//*[@id='brandForm:serviceLevelDeleteButton']";
	private String xPathBtnEOQAdd = "//*[@id='brandForm:eoqAddBtn']";
	private String xPathBtnEOQDelete = "//*[@id='brandForm:eoqDeleteButton']";
	private String xPathBtnSupplierAdd = "//*[@id='brandForm:supplierAddButton']";
	private String xPathBtnSupplierDelete = "//*[@id='brandForm:supplierDeleteButton']";
	// Tab
	private String xPathTabForecast = "";
	private String xPathTabServiceLevel = "";
	private String xPathTabEOQCalculation = "";
	private String xPathTabSupplier = "";
	private String xPathTabCompany = "";
	// General Infomation
	private String xPathTxtInventoryBrandCode = "//*[@id='brandForm:inpInvCode']";
	private String xPathTxtInventoryBrandDescription = "//*[text()='Description']/following-sibling::td/input";
	// Inside tab Forecast
	private String xPathTxtTargetMonthSupplyQty = "//*[@id='brandForm:targetMonthSupply']";
	private String xPathTxtTargetValue = "//*[@id='brandForm:targetValue']";
	// Inside tab Service Level
	private String xPathTxtServiceLevelCode = "//tbody[@id='brandForm:serviceLevelTable:tb']/tr[last()]//input[contains(@id,'code')]";
	private String xPathTxtServiceLevelDescription = "//tbody[@id='brandForm:serviceLevelTable:tb']/tr[last()]//input[contains(@id,'desc')]";
	private String xPathTxtServiceLevelValue = "//tbody[@id='brandForm:serviceLevelTable:tb']/tr[last()]//input[contains(@id,'value')]";
	private String xPathTxtZValue = "//tbody[@id='brandForm:serviceLevelTable:tb']/tr[last()]//input[contains(@id,'zValue')]";
	private String xPathCboxServiceLeveldel = "//tbody[@id='brandForm:serviceLevelTable:tb']/tr[last()]//input[contains(@id,'chkDelSplit')]";
	// Inside TAB: EOQ Calculation
	private String xPathTxtEOQCode = "//tbody[@id='brandForm:eoqCalculationTable:tb']/tr[last()]//input[contains(@id,'code')]";
	private String xPathTxtEOQDescription = "//tbody[@id='brandForm:eoqCalculationTable:tb']/tr[last()]//input[contains(@id,'desc')]";
	private String xPathTxtEOQValue = "//tbody[@id='brandForm:eoqCalculationTable:tb']/tr[last()]//input[contains(@id,'value')]";
	private String xPathCboxEOQDel = "//tbody[@id='brandForm:eoqCalculationTable:tb']/tr[last()]//input[contains(@id,'value')]/parent::*/following-sibling::td/input[@type='checkbox']";
	// TAB: Supplier
	private String xPathTxtSupplierCode = "//tbody[@id='brandForm:supplierTable:tb']/tr[last()]//input[contains(@id,'supplierCode')]";
	private String xPathTxtMinOrderQty = "//tbody[@id='brandForm:supplierTable:tb']/tr[last()]//input[contains(@id,'minOrderQty')]";
	private String xPathLinkLeadTime = "//tbody[@id='brandForm:supplierTable:tb']/tr[last()]//a[contains(@id,'leadTimePerDayLink')]";
	private String xPathRboxSupplierDefault = "//tbody[@id='brandForm:supplierTable:tb']/tr[last()]//a[contains(@id,'leadTimePerDayLink')]/parent::span/parent::td/following-sibling::td/descendant-or-self::input[@type='radio']";
	private String xPathCboxSupplierDel = "//tbody[@id='brandForm:supplierTable:tb']/tr[last()]//a[contains(@id,'chkDelSplit')]";
	private String xPathBtnLeadTimeAdd = "//*[contains(@id,'supLeadTimeAddBtn')]";
	private String xPathBtnLeadTimeDelete = "//*[contains(@id,'supLeadTimeDeleteButton']";
	private String xPathBtnLeadTimeDone = "//*[@value='Done'][@type='button']";
	private String xPathTxtLeadTimeCode = "//tbody[contains(@id,'supLeadTimeTable:tb')]/tr[last()]//input[contains(@id,'supLeadTimeCode')]";
	private String xPathTxtLeadTimeDesc = "//tbody[contains(@id,'supLeadTimeTable:tb')]/tr[last()]//input[contains(@id,'supLeadTimeDesc')]";
	private String xPathTxtLeadTimeValue = "//tbody[contains(@id,'supLeadTimeTable:tb')]/tr[last()]//input[contains(@id,'supLeadTimeValue')]";
	private String xPathChbLeadTimeDel = "//tbody[contains(@id,'supLeadTimeTable:tb')]/tr[last()]//input[contains(@id,'supLeadTimeValue')]/parent::td/following-sibling::td/input[@type='checkbox']";

	// TAB: COMPANY
	private String xPathTxtCompanyName = "//span[text()='Company Name']/parent::div/following-sibling::div/input";
	private String xPathCboxTag = "//*[contains(@id,'tblCompanyList')]/tr[last()]//input[@type='checkbox']";
	private String xPathCboxTagAll = "//div[text()='Tag']/input[@type='checkbox']";
	// Search form
	private String xPathTxtBrandCodeSearch = "//*[text()='Brand Code']/ancestor::td[@align='left']/following-sibling::td//input";
	private String xPathLinkBrandCodeSearch = "//tbody[@id='searchResult_Form:searchResult_Table:tb']//td[1]/a[contains(@id,'searchResult_Form')]/span";
	private String xPathBtnBrandCodeSearch = "//*[text()='Brand Code']/parent::span/parent::td//following-sibling::td[2]//input[@value='Search']";
	// Other

	private String xPathBtnConfirmYes = "//*[@id='confirmationPanel_Form:confirmationPanel_YesButton']";
	private String xPathBtnStatusPopup = "//*[@id='statusPopupPanel_OkButton']";
	private String xPathTblServiceLevel = "//tbody[@id='brandForm:serviceLevelTable:tb']";
	private String xPathTblEOQCalculation = "//tbody[@id='brandForm:eoqCalculationTable:tb']";
	private String xPathTblSupplier = "//tbody[@id='brandForm:supplierTable:tb']";

	/* START- ĐỊNH NGHĨA CÁC BUTTON */
	public void click_btn_close() {
		waitElementToBePresent(xPathBtnClose).waitUntilClickable().click();
	}

	public void click_btn_new() {
		waitElementToBePresent(xPathBtnNew).waitUntilClickable().click();
	}

	public void click_btn_delete() {
		waitElementToBePresent(xPathBtnDelete).waitUntilClickable().click();
	}

	public void click_btn_search() {
		waitElementToBePresent(xPathBtnSearch).waitUntilClickable().click();
	}

	public void click_btn_update() {
		waitElementToBePresent(xPathBtnUpdate).waitUntilClickable().click();
	}

	// Button inside TAB
	public void click_btn_service_level_add() {
		waitElementToBePresent(xPathBtnServiceLevelAdd).waitUntilClickable().click();
	}

	public void click_btn_service_level_delete() {
		waitElementToBePresent(xPathBtnServiceLevelDelete).waitUntilClickable().click();
	}

	public void click_btn_eoq_add() {
		waitElementToBePresent(xPathBtnEOQAdd).waitUntilClickable().click();
	}

	public void click_btn_eoq_delete() {
		waitElementToBePresent(xPathBtnEOQDelete).waitUntilClickable().click();
	}

	public void click_btn_supplier_add() {
		waitElementToBePresent(xPathBtnSupplierAdd).waitUntilClickable().click();
	}

	public void click_btn_supplier_delete() {
		waitElementToBePresent(xPathBtnSupplierDelete).waitUntilClickable().click();
	}

	/* END - ĐỊNH NGHĨA CÁC BUTTON */

	/* START- ĐỊNH NGHĨA CÁC TAB */
	public void switch_tab_forecast() {
		switch_to_tab("Forecast");
	}

	public void switch_tab_service_level() {
		switch_to_tab("Service Level");
	}

	public void switch_tab_eoq_calculation() {
		switch_to_tab("EOQ Calculation");
	}

	public void switch_tab_supplier() {
		switch_to_tab("Supplier");
	}

	public void switch_tab_company() {
		switch_to_tab("Company");
	}
	/* END - ĐỊNH NGHĨA CÁC TAB */

	/* START - ĐỊNH NGHĨA CÁC TRƯỜNG THÔNG TIN */

	// TAB: General Infomation
	public void enter_inventory_brand_code(String inventoryBrandCode) {
		waitTypeAndEnterThenUpdateValueOrError(xPathTxtInventoryBrandCode, inventoryBrandCode);
		waitForAllJSCompletes();
		assertThat(get_text_inventory_brand_code()).isEqualTo(inventoryBrandCode);

	}

	public String get_text_inventory_brand_code() {
		return waitElementToBePresent(xPathTxtInventoryBrandCode).getAttribute("value");
	}

	public void click_txt_inventory_brand_code() {
		waitElementToBePresent(xPathTxtInventoryBrandCode).waitUntilClickable().click();
	}

	public boolean is_readonly_inventory_brand_code() {
		String readonly = $(xPathTxtInventoryBrandCode).getAttribute("readonly");
		if (readonly != null) {
			return true;
		}
		return false;
	}

	public void enter_description(String description) {
		waitTypeAndEnterThenUpdateValue(xPathTxtInventoryBrandDescription, description);

	}

	// TAB: Forecast
	public void enter_target_month_supply_qty(String targetMonthSupplyQty) {
		waitTypeAndEnter(xPathTxtTargetMonthSupplyQty, targetMonthSupplyQty);
		waitForAllJSCompletes();
		assertThat(get_text_target_month_supply_qty()).isEqualTo(targetMonthSupplyQty);
	}

	public String get_text_target_month_supply_qty() {
		return waitElementToBePresent(xPathTxtTargetMonthSupplyQty).getAttribute("value");
	}

	public void enter_target_value(String targetValue) {
		waitTypeAndEnter(xPathTxtTargetValue, targetValue);
		waitForAllJSCompletes();
		assertThat(get_text_target_value()).isEqualTo(targetValue);
	}

	public String get_text_target_value() {
		return waitElementToBePresent(xPathTxtTargetValue).getAttribute("value");
	}

	// TAB: Service Level
	public void enter_service_level_code(String serviceLevelCode) {

		waitTypeAndEnter(xPathTxtServiceLevelCode, serviceLevelCode);
		waitForAllJSCompletes();
		assertThat(get_text_service_level_code()).isEqualTo(serviceLevelCode);
	}

	public String get_text_service_level_code() {
		return waitElementToBePresent(xPathTxtServiceLevelCode).getAttribute("value");
	}

	public void enter_service_level_description(String serviceLevelDescription) {

		waitTypeAndEnter(xPathTxtServiceLevelDescription, serviceLevelDescription);
		waitForAllJSCompletes();
		assertThat(get_text_service_level_description()).isEqualTo(serviceLevelDescription);
	}

	public String get_text_service_level_description() {
		return waitElementToBePresent(xPathTxtServiceLevelDescription).getAttribute("value");
	}

	public void enter_service_level_value(String serviceLevelValue) {

		waitTypeAndEnter(xPathTxtServiceLevelValue, serviceLevelValue);
		waitForAllJSCompletes();
		assertThat(get_text_service_level_value()).isEqualTo(serviceLevelValue);
	}

	public String get_text_service_level_value() {
		return waitElementToBePresent(xPathTxtServiceLevelValue).getAttribute("value");
	}

	public void enter_z_value(String zValue) {

		waitTypeAndEnter(xPathTxtZValue, zValue);
		waitForAllJSCompletes();

	}

	public String get_text_z_value() {
		return waitElementToBePresent(xPathTxtZValue).getAttribute("value");
	}

	public void check_service_level_del() {

		checkChkbox(xPathCboxServiceLeveldel);
	}

	public void uncheck_service_level_del() {

		uncheckChkbox(xPathCboxServiceLeveldel);
	}

	// TAB: EOQ Calculation
	public void enter_eoq_code(String eoqCode) {
		waitTypeAndEnter(xPathTxtEOQCode, eoqCode);
		waitForAllJSCompletes();
	}

	public String get_text_eoq_code() {
		return waitElementToBePresent(xPathTxtEOQCode).getAttribute("value");
	}

	public void enter_eoq_description(String eoqDescription) {
		waitTypeAndEnter(xPathTxtEOQDescription, eoqDescription);
		waitForAllJSCompletes();
	}

	public String get_text_eoq_description() {
		return waitElementToBePresent(xPathTxtEOQDescription).getAttribute("value");
	}

	public void enter_eoq_value(String eoqValue) {
		waitTypeAndEnter(xPathTxtEOQValue, eoqValue);
		waitForAllJSCompletes();
	}

	public String get_text_eoq_value() {
		return waitElementToBePresent(xPathTxtEOQValue).getAttribute("value");
	}

	public void check_eoq_del() {
		checkChkbox(xPathCboxEOQDel);
	}

	public void uncheck_eoq_del() {
		uncheckChkbox(xPathCboxEOQDel);
	}

	// TAB: Supplier
	public void enter_supplier_code(String supplierCode) {
		waitTypeAndEnter(xPathTxtSupplierCode, supplierCode);
		waitForAllJSCompletes();

	}

	public String get_text_supplier_code() {
		return waitElementToBePresent(xPathTxtSupplierCode).getAttribute("value");
	}

	public void enter_min_order_qty(String minOrderQty) {
		waitTypeAndEnter(xPathTxtMinOrderQty, minOrderQty);
		waitForAllJSCompletes();
	}

	public String get_text_min_order_qty() {
		return waitElementToBePresent(xPathTxtMinOrderQty).getAttribute("value");
	}

	public void click_on_lead_time() {
		waitElementToBePresent(xPathLinkLeadTime).waitUntilClickable().click();

	}

	public void select_supplier_default() {
		selectRadioButton(xPathRboxSupplierDefault);
	}

	public void check_supplier_del() {
		checkChkbox(xPathCboxSupplierDel);
	}

	public void uncheck_supplier_del() {
		uncheckChkbox(xPathCboxSupplierDel);
	}

	public void click_btn_leadtime_add() {
		waitElementToBePresent(xPathBtnLeadTimeAdd).waitUntilClickable().click();

	}

	public void click_btn_leadtime_delete() {
		waitElementToBePresent(xPathBtnLeadTimeDelete).waitUntilClickable().click();

	}

	public void click_btn_leadtime_done() {
		waitElementToBePresent(xPathBtnLeadTimeDone).waitUntilClickable().click();

	}

	public void enter_leadtime_code(String leadtimeCode) {
		waitTypeAndEnter(xPathTxtLeadTimeCode, leadtimeCode);
		waitForAllJSCompletes();

	}

	public void enter_leadtime_desc(String leadtimeDesc) {
		waitTypeAndEnter(xPathTxtLeadTimeDesc, leadtimeDesc);
		waitForAllJSCompletes();

	}

	public void enter_leadtime_value(String leadtimevalue) {
		waitTypeAndEnter(xPathTxtLeadTimeValue, leadtimevalue);
		waitForAllJSCompletes();

	}

	public void check_leadtime_del() {
		checkChkbox(xPathChbLeadTimeDel);
	}

	public void uncheck_leadtime_del() {
		uncheckChkbox(xPathChbLeadTimeDel);
	}

	// TAB: COMPANY
	public void enter_company_name(String companyName) {
		waitTypeAndEnter(xPathTxtCompanyName, companyName);
	}

	public String get_text_company_name() {
		return waitElementToBePresent(xPathTxtCompanyName).getAttribute("value");
	}

	public void check_tag() {
		checkChkbox(xPathCboxTag);
	}

	public void uncheck_tag() {
		uncheckChkbox(xPathCboxTag);
	}

	public void check_tag_all() {
		checkChkbox(xPathCboxTagAll);
	}

	public void uncheck_tag_all() {
		uncheckChkbox(xPathCboxTagAll);
	}

	public boolean is_checked_tag() {
		String ischecked = $(xPathCboxTag).getAttribute("checked");
		if (ischecked != null) {
			return true;
		}
		return false;
	}

	public boolean is_checked_tag_all() {
		String ischecked = $(xPathCboxTagAll).getAttribute("checked");
		if (ischecked != null) {
			return true;
		}
		return false;
	}
	// search form

	public void enter_brand_code_search(String brandCodeSearch) {
		waitTypeAndEnter(xPathTxtBrandCodeSearch, brandCodeSearch);
	}

	public void click_on_brand_code_link() {
		String xPath = ".//*[@id='searchResult_Form:searchResults']/div/span[text()='No Records Found!']";
		if (isElementExist(xPath)) {
			$("//img[@src='/TH5Web/img/close-icon.gif']").waitUntilClickable().click();
		} else {
			waitElementToBePresent(xPathLinkBrandCodeSearch).waitUntilClickable().click();
		}

	}

	public boolean search_result(String brandCodeSearch) {
		return search("Brand Code", brandCodeSearch);

	}

	public String get_text_brand_code_link() {
		String brandCodeLink = $(xPathCboxTag).getAttribute("text");
		return brandCodeLink;
	}

	public void click_btn_brand_code_search() {
		waitElementToBePresent(xPathBtnBrandCodeSearch).waitUntilClickable().click();
	}

	// Other
	public void click_btn_confirm_yes() {
		waitElementToBePresent(xPathBtnConfirmYes).waitUntilClickable().click();
	}

	public void click_btn_status_popup() {
		if (isElementVisible(xPathBtnStatusPopup, 1)) {
			waitElementToBePresent(xPathBtnStatusPopup).waitUntilClickable().click();
		}
	}

	public int count_table_row_service_level() {
		if (isElementVisible(xPathTblServiceLevel, 1)) {
			return getTbCountDataRow(xPathTblServiceLevel);
		}
		return 0;
	}

	public int count_table_row_eoq_calculation() {
		if (isElementVisible(xPathTblEOQCalculation, 1)) {
			return getTbCountDataRow(xPathTblEOQCalculation);
		}
		return 0;

	}

	public int count_table_row_supplier() {
		if (isElementVisible(xPathTblSupplier, 1)) {
			return getTbCountDataRow(xPathTblSupplier);
		}
		return 0;

	}

	public void find_and_check_checkbox_service_level(int i) {
		boolean isElementExist = isElementExist("//input[contains(@id,'" + i + ":chkDelSplit')]");
		if (isElementExist) {
			waitElementToBePresent("//input[contains(@id,'" + i + ":chkDelSplit')]").waitUntilClickable().click();
		}

	}

	public void find_and_check_checkbox_eoq_calculation(int i) {
		boolean isElementExist = isElementExist(
				"//input[contains(@name,'brandForm:eoqCalculationTable:" + i + "')][@type='checkbox']");
		if (isElementExist) {
			waitElementToBePresent(
					"//input[contains(@name,'brandForm:eoqCalculationTable:" + i + "')][@type='checkbox']")
							.waitUntilClickable().click();
		}

	}

	public void find_and_check_checkbox_supplier(int i) {
		boolean isElementExist = isElementExist(
				"//input[contains(@id,'brandForm:supplierTable:" + i + ":chkDelSplit')]");
		if (isElementExist) {
			waitElementToBePresent("//input[contains(@id,'brandForm:supplierTable:" + i + ":chkDelSplit')]")
					.waitUntilClickable().click();
		}

	}
	// chooseYesOnUpdateConfirmation

}
