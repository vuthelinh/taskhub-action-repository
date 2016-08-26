package com.synergix.globalsetup.inventory.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

/**
 * @author Vincent
 * @version 20160121
 */
public class InventoryPage extends TH5PageObject {
	public InventoryPage(WebDriver driver) {
		super(driver);
	}

	// private static final String sPageHeader = "Inventory";
	// #Region#Element
	@FindBy(xpath = "//span[@id='formHeaderAtHeader:formTitle']")
	private WebElementFacade pageHeader;

	private String xPathPanelSummary = "//form[@id='summaryform']";
	private String xPathPanelGlobalInventory = "//div[@id='globalInventoryHdr']";

	private String inputFieldInventoryCode = "//span[text()='Inventory Code']/ancestor-or-self::td/following-sibling::td//input[1]";

	private String xPathBtnAddDrugDetail = "//input[@class='button' and contains(@name,'btnAddDrugDetail')]";
	private String xPathBtnAddDrugUse = "//input[@class='button' and contains(@name,'btnAddDrugUse')]";
	private String xPathBtnAddDrugAddInfo = "//input[@class='button' and contains(@name,'btnAddDrugAddInfo')]";
	private String xPathBtnAddPackSizeCd = "//input[@class='button' and contains(@name,'btnAddPackSize')]";
	private String xPathBtnAddSupplierInventory = "//input[@class='button' and contains(@name,'btnAddSupplier')]";
	private String xPathBtnAddAttachment = "//input[@type='button' and @value='Add' and contains(@name,'AttachmentForm')]";
	private String xPathBtnAttChooseFile = "//input[@type='file' and contains(@name,'inventoryTabAttachmentForm')]";
	private String xPathBtnAttUpload = "//input[@type='submit' and @value='Upload']";
	// private String xPathBtnAttCancel = "//input[@type='button' and
	// @value='Cancel']";
	private String xPathBtnAddLocationInformation = "//input[@type='button' and @value='Add' and contains(@id,'inventoryTabLocationForm') and not(contains(@id,'binAddBtn'))]";
	private String xPathBtnAddBinInformation = "//input[@type='button' and @value='Add' and contains(@id,'binAddBtn')]";
	private String xPathBtnAddCusInformation = "//input[@type='button' and @value='Add' and contains(@id,'inventoryTabCustomerForm')]";
	private String xPathBtnAddDoc = "//input[@type='button' and @value='Add' and contains(@id,'btnAddCustomerDoc')]";
	private String xPathBtnAddListPrice = "//input[@type='button' and @value='Add' and contains(@id,'ListPrice')]";
	private String xPathBtnAddContent = "//span[contains(@id,'contentPanel')]//input[@type='button' and @value='Add']";
	private String xpathChkboxEnableBaseUOMInMobilePreSales = "//input[@type='checkbox' and contains(@id,'enableBaseUomInMobile')]";
	// Table
	private String xPathTbDrugUse = "//th[text()='Drug Use']//ancestor::table[1]";
	private String xPathTbPackSize = "(//table[contains(@id,'tblPackSizeList')])[1]";
	private String xPathTbAdditionalInformation = "//th[text()='Additional Information']//ancestor::table[1]";
	private String xPathTbSupplierInv = "//th[text()='Supplier Inventory']//ancestor::table[1]";
	private String xPathTbAttachment = "//th[text()='Attachment(s)']//ancestor::table[1]";
	private String xPathTbLocationInformation = "//th[text()='Location information']//ancestor::table[1]";
	private String xPathTbBinInformation = "//th[text()='Bin Information']//ancestor::table[1]";
	private String xPathTbCustomerInformation = "//th[text()='Customer Information']//ancestor::table[1]";
	private String xPathTbDoc = "(//table[contains(@id,'tblCustomerDocList')])[1]";
	private String xPathTbListPrice = "(//table[contains(@id,'inventoryTabListPriceForm')])[1]";
	private String xPathTbContent = "(//table[contains(@id,'contentTable')])[1]";

	// #EndRegion#Element

	// #Region#Page Action
	// BEGIN General
	public void click_btn_new_of_summary() {
		if (isElementExist("//form[@id='summaryform']//input[@value='New']")) {
			findBtn(xPathPanelSummary, "New").waitUntilClickable().click();
		}
		
	}

	public void click_btn_new_of_global_inv() {
		findBtn(xPathPanelGlobalInventory, "New").waitUntilClickable().click();
	}

	public void click_btn_search() {
		findBtn(xPathPanelGlobalInventory, "Search").waitUntilClickable().click();
	}

	public void click_btn_delete() {
		findBtn(xPathPanelGlobalInventory, "Delete").waitUntilClickable().click();
	}

	public void click_btn_update() {
		findBtn(xPathPanelGlobalInventory, "Update").waitUntilClickable().click();
		waitForAllJSCompletes();
		clickBtnYesOnConfirmUpdate();
		if (getInfoPanelMessagesThenClickOK() == null) {
			getErrorMessagesThenClickOK();
		}
	}

	public void click_btn_close() {
		findBtn(xPathPanelGlobalInventory, "Close").waitUntilClickable().click();
	}

	public void click_btn_copy() {
		findBtn(xPathPanelGlobalInventory, "Copy").waitUntilEnabled().waitUntilClickable().click();
	}

	public void click_btn_change() {
		findBtn(xPathPanelGlobalInventory, "Change").waitUntilEnabled().waitUntilClickable().click();
	}

	public void click_btn_clear() {
		findBtn(xPathPanelGlobalInventory, "Clear").waitUntilEnabled().waitUntilClickable().click();
	}

	public void click_search_icon_copy_from_inventory() {
		clickSearchIconWithLabel(xPathPanelGlobalInventory, "Copy From Inventory");
	}

	public String enter_inventory_code(String _inventoryCode) {
		return waitTypeAndEnterThenUpdateValueReadOnlyOrError(inputFieldInventoryCode, _inventoryCode);
	}

	public boolean search_inventory_code(String _inventoryCode) {
		clickBtn(xPathPanelGlobalInventory, "Search");
		return search("Inventory Code", _inventoryCode);
	}

	public void enter_description(String _description) {
		enterInputFieldWithLabel("Description", _description);
	}

	public void enter_copy_from_inv(String _copyFromInventory) {
		enterInputFieldWithLabel("Copy From Inventory", _copyFromInventory);
	}

	public void enter_short_description(String _shortDescription) {
		enterInputFieldWithLabel("Short Description", _shortDescription);
	}

	public void enter_detailed_description(String _detailedDescription) {
		enterTextAreaWithLabel("Detailed Description", _detailedDescription);
	}

	public void enter_base_uom(String _baseUom) {
		enterInputFieldWithLabel("Base UOM", _baseUom);
	}

	public void enter_inventory_class(String _inventoryClass) {
		enterInputFieldWithLabel("Inventory Class", _inventoryClass);
	}

	public void enter_inventory_category(String _inventoryCategory) {
		enterInputFieldWithLabel("Inventory Category", _inventoryCategory);
	}

	public void enter_budget_category_code(String _budgetCategoryCode) {
		enterInputFieldWithLabel("Budget Category Code", _budgetCategoryCode);
	}

	public void enter_inventory_brand(String _inventoryBrand) {
		enterInputFieldWithLabel("Inventory Brand", _inventoryBrand);
	}

	public void enter_series_1(String _series1) {
		enterInputFieldWithLabel("Series 1", _series1);
	}

	public void enter_series_2(String _series2) {
		enterInputFieldWithLabel("Series 2", _series2);
	}

	public void enter_series_3(String _series3) {
		enterInputFieldWithLabel("Series 3", _series3);
	}

	public void enter_series_4(String _series4) {
		enterInputFieldWithLabel("Series 4", _series4);
	}

	public void enter_report_grouping_code(String _reportGroupingCode) {
		enterInputFieldWithLabel("Report Grouping Code", _reportGroupingCode);
	}

	public void enter_country_of_origin(String _countryOfOrigin) {
		enterInputFieldWithLabel("Country of Origin", _countryOfOrigin);
	}

	public void enter_receipt_minimum_shelf_life(String _receiptMinimumShelfLife) {
		enterInputFieldWithLabel("Receipt Minimum Shelf Life", _receiptMinimumShelfLife);
	}

	public void enter_issue_minimum_expiry(String _issueMinimumExpiry) {
		enterInputFieldWithLabel("Issue Minimum Expiry", _issueMinimumExpiry);
	}

	public void select_option_auto_break_pack_to_base_uom(String _radioBtnLabel) {
		selectRadioButton(xPathPanelGlobalInventory, "Auto Break Pack To Base UOM", _radioBtnLabel);
	}

	public void select_option_inventory_type(String _radioBtnLabel) {
		selectRadioButton(xPathPanelGlobalInventory, "Inventory Type", _radioBtnLabel);
	}

	public void select_option_lot_no_tracking(String _radioBtnLabel) {
		selectRadioButton(xPathPanelGlobalInventory, "Lot No. Tracking", _radioBtnLabel);
	}

	public void select_option_serial_no_tracking(String _radioBtnLabel) {
		selectRadioButton(xPathPanelGlobalInventory, "Serial No. Tracking", _radioBtnLabel);
	}

	public void select_option_warranty_tracking(String _radioBtnLabel) {
		selectRadioButton(xPathPanelGlobalInventory, "Warranty Tracking", _radioBtnLabel);
	}

	public void select_option_exchange_of_expired_lot(String _exchangeOfExpiredLot) {
		selectRadioButton(xPathPanelGlobalInventory, "Exchange of Expired Lot", _exchangeOfExpiredLot);
	}

	public void enter_exchange_allowable_within(String _exchangeAllowableWithin) {
		enterInputFieldWithLabel("Exchange Allowable Within", _exchangeAllowableWithin);
	}

	// END General
	// BEGIN Specification
	public void enter_length_inch(String _lengthInch) {
		enterInputFieldWithLabel("Length/Breadth/Height", _lengthInch, 1);
	}

	public void enter_breadth_inch(String _breadthInch) {
		enterInputFieldWithLabel("Length/Breadth/Height", _breadthInch, 2);
	}

	public void enter_height_inch(String _heightInch) {
		enterInputFieldWithLabel("Length/Breadth/Height", _heightInch, 3);
	}

	public void enter_length_mm(String _lengthMm) {
		enterInputFieldWithLabel("Length/Breadth/Height", _lengthMm, 4);
	}

	public void enter_breadth_mm(String _breadthMm) {
		enterInputFieldWithLabel("Length/Breadth/Height", _breadthMm, 5);
	}

	public void enter_height_mm(String _heightMm) {
		enterInputFieldWithLabel("Length/Breadth/Height", _heightMm, 6);
	}

	public void enter_volume(String _volume) {
		enterInputFieldWithLabel("Volume", _volume);
	}

	public void enter_outer_diameter_inch(String _outerDiameterInch) {
		enterInputFieldWithLabel("Outer Diameter/Inner Diameter/Length", _outerDiameterInch, 1);
	}

	public void enter_inner_diameter_inch(String _innerDiameterInch) {
		enterInputFieldWithLabel("Outer Diameter/Inner Diameter/Length", _innerDiameterInch, 2);
	}

	public void enter_outer_length_inch(String _outerLengthInch) {
		enterInputFieldWithLabel("Outer Diameter/Inner Diameter/Length", _outerLengthInch, 3);
	}

	public void enter_outer_diameter_mm(String _outerDiameterMm) {
		enterInputFieldWithLabel("Outer Diameter/Inner Diameter/Length", _outerDiameterMm, 4);
	}

	public void enter_inner_diameter_mm(String _innerDiameterMm) {
		enterInputFieldWithLabel("Outer Diameter/Inner Diameter/Length", _innerDiameterMm, 5);
	}

	public void enter_outer_length_mm(String _outerLengthMm) {
		enterInputFieldWithLabel("Outer Diameter/Inner Diameter/Length", _outerLengthMm, 6);
	}

	public void enter_gross_weight(String _grossWeight) {
		enterInputFieldWithLabel("Gross Weight", _grossWeight);
	}

	public void enter_nett_weight(String _nettWeight) {
		enterInputFieldWithLabel("Nett Weight", _nettWeight);
	}

	public void enter_weight_uom(String _weightUom) {
		enterInputFieldWithLabel("Weight UOM", _weightUom);
	}

	public void enter_density(String _density) {
		enterInputFieldWithLabel("Density", _density);
	}

	public void enter_measure_type(String _measureType) {
		selectRadioButton("Measure Type", _measureType);
	}

	// END Specification
	// BEGIN Healthcare
	public void enter_drug_name(String _drugName) {
		enterInputFieldWithLabel("Drug Name", _drugName);
	}

	public void enter_trade_name(String _tradeName) {
		enterInputFieldWithLabel("Trade Name", _tradeName);
	}

	public void enter_strength(String _strength) {
		enterInputFieldWithLabel("Strength", _strength);
	}

	public void enter_route(String _route) {
		enterInputFieldWithLabel("Route", _route);
	}

	public void select_option_controlled_drug_moh_reporting_req(String _controlledDrugMohReportingReq) {
		selectRadioButton("Controlled Drug, MOH reporting req", _controlledDrugMohReportingReq);
	}

	public void select_option_generate_product_label(String _generateProductLabel) {
		selectRadioButton("Generate Product Label", _generateProductLabel);
	}

	public void enter_prescription_desc(String _prescriptionDesc) {
		enterInputFieldWithLabel("Prescription Desc", _prescriptionDesc);
	}

	public void enter_qty(String _qty) {
		enterInputFieldWithLabel("Qty", _qty);
	}

	public void enter_uom(String _uom) {
		enterInputFieldWithLabel("UOM", _uom);
	}

	public void enter_frequency(String _frequency) {
		enterInputFieldWithLabel("Frequency", _frequency);
	}

	public void enter_frequency_desc(String _frequencyDesc) {
		enterInputFieldWithLabel("Frequency Desc", _frequencyDesc);
	}

	public void enter_duration(String _duration) {
		enterInputFieldWithLabel("Duration", _duration);
	}

	public void enter_new_drug_use_code(String _drugUseCode) {
		int colIndexDrugUseCode = getTbColHeaderIndex(xPathTbDrugUse, "Drug Use Code");
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbDrugUse, colIndexDrugUseCode) + "//input[@type='text']",
				_drugUseCode);
	}

	public void enter_new_drug_add_info(String _drugAddInfo) {
		int colIndexDrugAddInfo = getTbColHeaderIndex(xPathTbAdditionalInformation, "Additional Info Code");
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbAdditionalInformation, colIndexDrugAddInfo)
						+ "//input[@type='text']",
				_drugAddInfo);
	}

	public void click_btn_add_drug_detail() {
		waitElementToBePresent(xPathBtnAddDrugDetail).waitUntilClickable().click();
	}

	public void click_btn_add_drug_use() {
		waitElementToBePresent(xPathBtnAddDrugUse).waitUntilClickable().click();
	}

	public void click_btn_add_drug_add_info() {
		waitElementToBePresent(xPathBtnAddDrugAddInfo).waitUntilClickable().click();
	}

	// END Healthcare
	// START Pack Size
	public void click_btn_add_pack_size_cd() {
		waitElementToBePresent(xPathBtnAddPackSizeCd).waitUntilClickable().click();
	}

	public void set_chkbox_enable_base_uom_in_Mobile_Pre_Sales(String _value) {
		if (!waitElementToBePresent(xpathChkboxEnableBaseUOMInMobilePreSales).isSelected()) {
			waitElementToBePresent(xpathChkboxEnableBaseUOMInMobilePreSales).waitUntilClickable().click();
			if (!waitElementToBePresent(xpathChkboxEnableBaseUOMInMobilePreSales).isSelected()) {
				// Assesrt fail here
				System.out.println("is select function for this element not work");
			}
		}
	}

	public void enter_new_pack_size_code(String _packSizeCode) {
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbPackSize,
						getTbColHeaderIndex(xPathTbPackSize, "Pack Size Code")) + "//input[@type='text']",
				_packSizeCode);
	}

	public void enter_new_pack_size_cd_description(String _description) {
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbPackSize,
				getTbColHeaderIndex(xPathTbPackSize, "Description")) + "//input[@type='text']", _description);
	}

	public void select_new_convert_from_pack_size(String _convertFromPackSize) {
		selectDdlByText(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbPackSize,
						getTbColHeaderIndex(xPathTbPackSize, "Convert from Pack Size")) + "//select",
				_convertFromPackSize);
	}

	public void enter_new_qty_in_other_pack_size(String _qtyInOtherPackSize) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbPackSize,
						getTbColHeaderIndex(xPathTbPackSize, "Qty in Other Pack Size")) + "//input[@type='text']",
				_qtyInOtherPackSize);
	}

	public void enter_new_qty_in_base_uom(String _qtyInBaseUom) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbPackSize,
						getTbColHeaderIndex(xPathTbPackSize, "Qty in Base UOM")) + "//input[@type='text']",
				_qtyInBaseUom);
	}

	public void set_enable_in_mobile_pre_sales(String _value) {
		setChkbox(xPathTbGetLastDataCellByHeaderIndex(xPathTbPackSize,
				getTbColHeaderIndex(xPathTbPackSize, "Enable in Mobile Pre Sales")) + "//input[@type='checkbox']",
				_value);
	}
	// END Pack Size

	// BEGIN Supplier
	public void click_btn_add_supplier() {
		waitElementToBePresent(xPathBtnAddSupplierInventory).waitUntilClickable().click();
	}

	public void enter_new_supplier(String _supplier) {
		waitTypeAndEnterThenUpdateValueReadOnly(xPathTbGetLastDataCellByHeaderIndex(xPathTbSupplierInv,
				getTbColHeaderIndex(xPathTbSupplierInv, "Supplier")) + "//input[@type='text']", _supplier);
	}

	public void enter_new_party_inventory_code(String _partyInventoryCode) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbSupplierInv,
						getTbColHeaderIndex(xPathTbSupplierInv, "Party Inventory Code")) + "//input[@type='text']",
				_partyInventoryCode);
	}

	public void enter_new_default_description(String _defaultDescription) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbSupplierInv,
						getTbColHeaderIndex(xPathTbSupplierInv, "Default Description")) + "//input[@type='text']",
				_defaultDescription);
	}

	public void enter_new_billing_description(String _billingDescription) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbSupplierInv,
						getTbColHeaderIndex(xPathTbSupplierInv, "Billing Description")) + "//input[@type='text']",
				_billingDescription);
	}

	public void enter_new_remarks(String _remarks) {
		waitElementToBePresent(xPathTbGetLastDataCellByHeaderIndex(xPathTbSupplierInv,
				getTbColHeaderIndex(xPathTbSupplierInv, "Remarks")) + "//img[contains(@src,'remarks.gif')]")
						.waitUntilClickable().click();
		String xPathPopupRemarks = "(//div[contains(@id,'RemarksPopupHeader') and text()='Remarks']//ancestor::table[1])[last()]";
		waitElementToBePresent(xPathPopupRemarks).shouldBeVisible();
		waitTypeAndTab(xPathPopupRemarks + "//textarea", _remarks);
		waitElementToBePresent(xPathPopupRemarks + "//input[@class='button' and @value='Close']").waitUntilClickable()
				.click();
		waitElementToBePresent(xPathPopupRemarks).shouldNotBeVisible();
	}

	public void enter_new_min_order_qty(String _minOrderQty) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbSupplierInv,
						getTbColHeaderIndex(xPathTbSupplierInv, "Min Order Qty")) + "//input[@type='text']",
				_minOrderQty);
	}

	public void enter_new_lead_time_in_days(String _leadTimeInDays) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbSupplierInv,
						getTbColHeaderIndex(xPathTbSupplierInv, "Lead Time in Days")) + "//input[@type='text']",
				_leadTimeInDays);
	}

	public void enter_new_std_pack_size(String _stdPackSize) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbSupplierInv,
						getTbColHeaderIndex(xPathTbSupplierInv, "Std Pack Size")) + "//input[@type='text']",
				_stdPackSize);
	}

	public void enter_new_home_unit_cost(String _homeUnitCost) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbSupplierInv,
						getTbColHeaderIndex(xPathTbSupplierInv, "Home Unit Cost")) + "//input[@type='text']",
				_homeUnitCost);
	}

	public void set_default_supplier(String _value) {
		if (_value.toLowerCase().equals("true")) {
			selectRadioButton(xPathTbGetLastDataCellByHeaderIndex(xPathTbSupplierInv,
					getTbColHeaderIndex(xPathTbSupplierInv, "Default")) + "//input[@type='radio']");
		}
	}

	// END Supplier
	// BEGIN Content
	public void click_btn_add_new_content() {
		waitElementToBePresent(xPathBtnAddContent).waitUntilClickable().click();
	}

	public void enter_new_content_code(String _contentCode) {
		waitTypeAndEnterThenNoInput(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbContent, getTbColHeaderIndex(xPathTbContent, "Content Code"))
						+ "//input[@type='text']",
				_contentCode);
	}

	public void verify_new_content_description(String _description) {
		// TODOLATER
	}

	public void enter_content_new_default_percentage(String _defaultPercentage) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbContent,
						getTbColHeaderIndex(xPathTbContent, "Default Percentage")) + "//input[@type='text']",
				_defaultPercentage);
	}

	public void enter_content_new_default_recovery_rate(String _defaultRecoveryRate) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbContent,
						getTbColHeaderIndex(xPathTbContent, "Default Recovery Rate")) + "//input[@type='text']",
				_defaultRecoveryRate);
	}

	// END content
	// BEGIN Attachment(s)
	public void click_btn_add_new_attachment() {
		waitElementToBePresent(xPathBtnAddAttachment).waitUntilClickable().click();
	}

	public void choose_attachment_file(String _filePath) {
		waitElementToBePresent(xPathBtnAttChooseFile).sendKeys(_filePath);
	}

	// NOTE: maybe error TH error, it not update state of A4J when finish upload
	public void click_btn_upload_attachment() {
		waitElementToBePresent(xPathBtnAttUpload).waitUntilClickable().click();
		withTimeoutOf(60, TimeUnit.SECONDS).waitForAbsenceOf(xPathBtnAttUpload);
		findBy("//div[@id='globalInventoryHdr']//input[@type='button' and @value='Update']").waitUntilClickable()
				.click();
		waitForAllJSCompletes();
		clickBtnYesOnConfirmUpdate();
		if (getInfoPanelMessagesThenClickOK() == null) {
			getErrorMessagesThenClickOK();
		}
	}

	public void enter_new_file_description(String _fileDescription) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbAttachment,
						getTbColHeaderIndex(xPathTbAttachment, "File Description")) + "//input[@type='text']",
				_fileDescription);
	}

	// END Attachment(s)
	// BEGIN Local Info
	public void enter_home_base_cost(String _homeBaseCost) {
		enterInputFieldWithLabel("Home Base Cost", _homeBaseCost);
	}

	public void enter_procurement_lead_time(String _procurementLeadTime) {
		enterInputFieldWithLabel("Procurement Lead Time", _procurementLeadTime);
	}

	public void select_option_allow_issue_more_than_alloc_qty(String _allowIssueMoreThanAllocQty) {
		selectRadioButton("Allow Issue More Than Alloc Qty", _allowIssueMoreThanAllocQty);
	}

	public void verify_inventory_category_loc_info(String _inventoryCategory) {
		// TODOLATER
	}

	public void enter_inventory_model(String _inventoryModel) {
		enterInputFieldWithLabel("Inventory Model", _inventoryModel);
	}

	// Location
	public void click_btn_add_location_information() {
		waitElementToBePresent(xPathBtnAddLocationInformation).waitUntilClickable().click();
	}

	public void enter_new_location_code(String _locationCode) {
		waitTypeAndEnterThenLink(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbLocationInformation,
						getTbColHeaderIndex(xPathTbLocationInformation, "Location Code")) + "//input[@type='text']",
				_locationCode);
	}

	/**
	 * Created by Steve on 15/08/2016
	 * @param locationCode
	 * @return
	 */
	public boolean is_added_location_code(String locationCode) {
		String elementXpath = xPathTbLocationInformation + "//td//*[text()='" + locationCode + "']";
		return isElementExist(elementXpath);
	}
	public void verify_location_name(String _locationName) {
		// TODOLATER
	}

	public void enter_new_min_holding_qty(String _minHoldingQty) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbLocationInformation,
						getTbColHeaderIndex(xPathTbLocationInformation, "Min Holding Qty")) + "//input[@type='text']",
				_minHoldingQty);
	}

	public void enter_new_max_holding_qty(String _maxHoldingQty) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbLocationInformation,
						getTbColHeaderIndex(xPathTbLocationInformation, "Max Holding Qty")) + "//input[@type='text']",
				_maxHoldingQty);
	}

	public void enter_new_local_information_remarks(String _remarks) {
		waitElementToBePresent(xPathTbGetLastDataCellByHeaderIndex(xPathTbLocationInformation,
				getTbColHeaderIndex(xPathTbLocationInformation, "Remarks")) + "//img[contains(@src,'remarks.gif')]")
						.waitUntilClickable().click();
		String xPathPopupRemarks = "(//div[contains(@id,'remarksModalPanelHeader') and text()='Remarks']//ancestor::table[1])[last()]";
		waitElementToBePresent(xPathPopupRemarks).shouldBeVisible();
		waitTypeAndTab(xPathPopupRemarks + "//textarea", _remarks);
		waitElementToBePresent(xPathPopupRemarks + "//input[@type='button' and @value='Ok']").waitUntilClickable()
				.click();
		waitForAbsenceOf(xPathPopupRemarks);
	}

	// Bin Information
	public void click_btn_add_bin_information() {
		waitElementToBePresent(xPathBtnAddBinInformation).waitUntilClickable().click();
	}

	public void enter_new_bin_row(String _row) {
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbBinInformation,
				getTbColHeaderIndex(xPathTbBinInformation, "Row")) + "//input[@type='text']", _row);
	}

	public void enter_new_bincolumn(String _column) {
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbBinInformation,
				getTbColHeaderIndex(xPathTbBinInformation, "Column")) + "//input[@type='text']", _column);
	}

	public void enter_new_binlevel(String _level) {
		waitTypeAndEnterThenNoInput(xPathTbGetLastDataCellByHeaderIndex(xPathTbBinInformation,
				getTbColHeaderIndex(xPathTbBinInformation, "Level")) + "//input[@type='text']", _level);
	}

	public void enter_new_bin_description(String _description) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbBinInformation,
						getTbColHeaderIndex(xPathTbBinInformation, "Description")) + "//input[@type='text']",
				_description);
	}

	// Customer information
	public void click_btn_add_cus_information() {
		waitElementToBePresent(xPathBtnAddCusInformation).waitUntilClickable().click();
	}

	public void enter_moq_in_loose(String _moqInLoose) {
		enterInputFieldWithLabel("MOQ In Loose", _moqInLoose);
	}

	public void enter_new_cus_customer(String _customer) {
		waitTypeAndEnterThenNoInput(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbCustomerInformation,
						getTbColHeaderIndex(xPathTbCustomerInformation, "Customer")) + "//input[@type='text']",
				_customer);
	}

	public void verify_new_cus_customer_name(String _customerName) {
		// TODOLATER
	}

	public void enter_new_cus_party_inventory_code(String _partyInventoryCode) {
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbCustomerInformation,
				getTbColHeaderIndex(xPathTbCustomerInformation, "Party Inventory Code")) + "//input[@type='text']",
				_partyInventoryCode);
	}

	public void enter_new_cus_default_description(String _defaultDescription) {
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbCustomerInformation,
				getTbColHeaderIndex(xPathTbCustomerInformation, "Default Description")) + "//input[@type='text']",
				_defaultDescription);
	}

	public void enter_new_cus_billing_description(String _billingDescription) {
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbCustomerInformation,
				getTbColHeaderIndex(xPathTbCustomerInformation, "Billing Description")) + "//input[@type='text']",
				_billingDescription);
	}

	public void enter_new_cus_d_sales_(String _dSales) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbCustomerInformation,
						getTbColHeaderIndex(xPathTbCustomerInformation, "D-Sales %")) + "//input[@type='text']",
				_dSales);
	}

	public void enter_new_cus_o_sales(String _oSales) {
		waitTypeAndEnterThenUpdateValue(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbCustomerInformation,
						getTbColHeaderIndex(xPathTbCustomerInformation, "O-Sales %")) + "//input[@type='text']",
				_oSales);
	}

	public void enter_new_cus_remarks(String _remarks) {
		waitElementToBePresent(xPathTbGetLastDataCellByHeaderIndex(xPathTbCustomerInformation,
				getTbColHeaderIndex(xPathTbCustomerInformation, "Remarks")) + "//img[contains(@src,'remarks.gif')]")
						.waitUntilClickable().click();
		String xPathPopupRemarks = "(//div[contains(@id,'remarksModalPanelHeader') and text()='Remarks']//ancestor::table[1])[last()]";
		waitElementToBePresent(xPathPopupRemarks).shouldBeVisible();
		waitTypeAndTab(xPathPopupRemarks + "//textarea", _remarks);
		waitElementToBePresent(xPathPopupRemarks + "//input[@type='button' and @value='Ok']").waitUntilClickable()
				.click();
		waitForAbsenceOf(xPathPopupRemarks);
	}

	// END Local Info
	// BEGIN Customer Doc
	public void click_btn_add_document() {
		waitElementToBePresent(xPathBtnAddDoc).waitUntilClickable().click();
	}

	public void enter_doc_new_document_code(String _documentCode) {
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbDoc, getTbColHeaderIndex(xPathTbDoc, "Document Code"))
						+ "//input[@type='text']",
				_documentCode);
	}

	public void verify_doc_new_description(String _description) {
		// TODOLATER
	}

	public void verify_doc_new_document_type(String _documentType) {
		// TODOLATER
	}

	public void verify_doc_new_current_revision(String _currentRevision) {
		// TODOLATER
	}

	public void verify_doc_new_attachment(String _attachment) {
		// TODOLATER
	}

	// END Customer Doc
	// BEGIN List Price By Type
	public void click_btn_add_list_price_by_type() {
		waitElementToBePresent(xPathBtnAddListPrice).waitUntilClickable().click();
	}

	public void enter_lpbt_new_currency_code(String _currencyCode) {
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbListPrice,
						getTbColHeaderIndex(xPathTbListPrice, "Currency Code")) + "//input[@type='text']",
				_currencyCode);
	}

	public void enter_lpbt_new_list_price_type_code(String _listPriceTypeCode) {
		waitTypeAndEnterThenUpdateValueReadOnly(
				xPathTbGetLastDataCellByHeaderIndex(xPathTbListPrice,
						getTbColHeaderIndex(xPathTbListPrice, "List Price Type Code")) + "//input[@type='text']",
				_listPriceTypeCode);
	}

	public void verify_lpbt_new_list_price_type_desc(String _listPriceTypeDesc) {
		// TODOLATER
	}

	public void enter_lpbt_new_list_price(String _listPrice) {
		waitTypeAndEnterThenUpdateValue(xPathTbGetLastDataCellByHeaderIndex(xPathTbListPrice,
				getTbColHeaderIndex(xPathTbListPrice, "List Price", 3)) + "//input[@type='text']", _listPrice);
	}

	public void set_lpbt_new_is_default(String _isDefault) {
		setChkbox(xPathTbGetLastDataCellByHeaderIndex(xPathTbListPrice,
				getTbColHeaderIndex(xPathTbListPrice, "Is Default")) + "//input[@type='checkbox']", _isDefault);
	}

	public void set_lpbt_new_for_set_price_distribution(String _forSetPriceDistribution) {
		setChkbox(xPathTbGetLastDataCellByHeaderIndex(xPathTbListPrice,
				getTbColHeaderIndex(xPathTbListPrice, "For Set Price Distribution")) + "//input[@type='checkbox']",
				_forSetPriceDistribution);
	}

	// END List Price By Type
	// BEGIN TAB
	public void switch_to_tab_general() {
		switch_to_tab("General");
	}

	public void switch_to_tab_specification() {
		switch_to_tab("Specification");
	}

	public void switch_to_tab_healthcare() {
		switch_to_tab("Healthcare");
	}

	public void switch_to_tab_pack_size() {
		switch_to_tab("Pack Size");
	}

	public void switch_to_tab_supplier() {
		switch_to_tab("Supplier");
	}

	public void switch_to_tab_content() {
		switch_to_tab("Content");
	}

	public void switch_to_tab_attachments() {
		switch_to_tab("Attachments");
	}

	public void switch_to_tab_company() {
		switch_to_tab("Company");
	}

	public void switch_to_tab_local_info() {
		switch_to_tab("Local Info");
	}

	public void switch_to_tab_locinfo_general() {
		switch_to_tab("General", 2);
	}

	public void switch_to_tab_locinfo_specification() {
		switch_to_tab("Specification", 2);
	}

	public void switch_to_tab_locinfo_location() {
		switch_to_tab("Location");
	}

	public void switch_to_tab_locinfo_drawing() {
		switch_to_tab("Drawing");
	}

	public void switch_to_tab_locinfo_customer() {
		switch_to_tab("Customer");
	}

	public void switch_to_tab_locinfo_customer_doc() {
		switch_to_tab("Customer Doc");
	}

	public void switch_to_tab_locinfo_list_price_by_type() {
		switch_to_tab("List Price By Type");
	}

	// Tag company
	private String xPathTbCompanyTag = "(//table[contains(@id, 'tblCompanyList')])[1]";

	public void chooseCompany(String _companyName) {
		chooseCompany(xPathTbCompanyTag, _companyName);
	}

	// END TAB
	// #EndRegion Page Action

	public void click_on_inventory_code_link() {
		String xPath = ".//*[@id='searchResult_Form:searchResults']//div//span[text()='No Records Found!']";
		if (isElementExist(xPath)) {
			$("//img[@src='/TH5Web/img/close-icon.gif']").waitUntilClickable().click();
		} else {
			waitElementToBePresent("//*[contains(@id,'searchResult_Form:searchResult_Table')]//tbody/tr[1]/td[1]//span").waitUntilClickable().click();
		}

	}
	
	
	
	// #Region#ForTest===================================================================
	// #EndRegion#ForTest================================================================
}
