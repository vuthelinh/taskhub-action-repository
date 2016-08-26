package com.synergix.operations.salesreturn.processing.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH6PageObject;
/**
 * 
 * @author Zoe
 *
 */

public class SalesReturnPage extends TH6PageObject {

	
	private static final String SOURCE_SHIPMENT_NO = "Source Shipment No.";
	private static final String CUSTOMER_SUPPORT = "Customer Support";
	private static final String BTN_SUBMIT = "//span[text()='Submit']";
	private static final String BTN_ABORT = "//span[text()='Abort']";
	private static final String BTN_RETURN_ALL = "//span[text()='Return All']";

	public SalesReturnPage(WebDriver driver) {
		super(driver);
	}

	@Override
	public String getTextValueWithLabel(String label) {
		String commonXpath = "//*[text()='" + label + "']/following-sibling::div//input";
		return $(commonXpath).getTextValue();

	}

	@Override
	public void enterInputFieldWithLabel(String label, String value) {
		String commonXpath = "//*[text()='" + label + "']/following-sibling::div//input";
		$(commonXpath).type(value);
		waitForAllJSCompletes();
		$(commonXpath).sendKeys(Keys.ENTER);
	}

	public String getTextInputShmInfoValue(String label) {
		String commonXpath = "//*[text()='" + label + "']/following-sibling::div/span";
		return $(commonXpath).getTextValue();
	}

	public String getTextInputShmInfoValue2(String label) {
		String commonXpath = "//*[text()='" + label + "']/following-sibling::div";
		return $(commonXpath).getTextValue();
	}

	public void enter_return_request_date(String returnRequestDate) {
		clickOnElement("//*[text()='Return Request Date']/following-sibling::div//input");
		waitForAllJSCompletes();
		setCalendarDate(returnRequestDate);
		waitForAllJSCompletes();
	}

	public String get_return_request_date() {
		return getTextValueWithLabel("Return Request Date");
	}

	public void enter_customer_support(String customerSupport) {
		clickOnElement("//*[text()='Customer Support']/following-sibling::div//input");
		enterInputFieldWithLabel(CUSTOMER_SUPPORT, customerSupport);
	}

	public String get_text_customer_support() {
		return getTextValueWithLabel(CUSTOMER_SUPPORT);
	}

	public void enter_source_shipment_no(String sourceShipmentNo) {
		enterInputFieldWithLabel(SOURCE_SHIPMENT_NO, sourceShipmentNo);
		waitForAllJSCompletes();
	}

	public String get_text_source_shipment_no() {
		return getTextValueWithLabel(SOURCE_SHIPMENT_NO);
	}

	public void click_btn_submit() {
		waitElementToBePresent(BTN_SUBMIT).waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void click_btn_abort() {
		waitElementToBePresent(BTN_ABORT).waitUntilClickable().click();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void click_btn_ReturnAll() {
		waitElementToBePresent(BTN_RETURN_ALL).waitUntilClickable().click();
		waitForAllJSCompletes();
	}

	public String get_text_source_do_no() {
		return getTextInputShmInfoValue("Source DO No.");

	}

	public String get_text_source_so_no() {
		return getTextInputShmInfoValue("Source SO No.");
	}

	public String get_text_customer_po_no() {
		return getTextInputShmInfoValue2("Customer PO No.");
	}

	public String get_text_salesperson() {
		String xPath = "//*[text()='Salesperson']/following-sibling::div/div";
		return $(xPath).getTextValue();
	}

	public String get_text_ship_to_address() {
		return getTextInputShmInfoValue2("Ship To Address");
	}

	public String get_text_ship_to_contact() {
		return getTextInputShmInfoValue2("Ship To Contact");
	}

	public String get_actual_shipment_date() {
		return getTextInputShmInfoValue2("Actual Shipment Date");
	}

	public String get_text_loading_location() {
		return getTextInputShmInfoValue2("Loading Location");
	}

	public String get_text_collection_address() {

		String xpath = "//*[text()='Collection Address']/following-sibling::div/textarea";
		return $(xpath).getTextValue();
	}

	public String get_text_collection_contact() {
		String xpath = "//*[text()='Collection Contact']/following-sibling::div/textarea";
		return $(xpath).getTextValue();
	}

	public void enter_collection_date(String collectionDate) {
		clickOnElement("//*[text()='Collection Date']/following-sibling::div/span");
		waitForAllJSCompletes();
		setCalendarDate(collectionDate);
	}

	public String get_collection_date() {
		String xpath="//*[text()='Collection Date']/following-sibling::div/span/input";
		return $(xpath).getTextValue();
	}

	public String get_text_return_qty(String returnQty) {
		String xPathQty = "//input[contains(@id,'returnQty') and @role='textbox']";
		return $(xPathQty).getTextValue();
	}

	public String get_text_customer() {
		String xPathCus = "//*[text()='Customer']/following-sibling::div";
		return $(xPathCus).getTextValue();
	}
	public String get_text_internalRM(){
		String xpathINR = "//*[text()='Internal Remarks']/following-sibling::div/span/textarea";
		return $(xpathINR).getTextValue();
	}
	public String get_text_externalRM(){
		String xpathEXR = "//*[text()='External Remarks']/following-sibling::div/span/textarea";
		return $(xpathEXR).getTextValue();
	}
	public String get_code(){
		String xpathCode="//*[text()='Sales Return No.']/following-sibling::div";
		return $(xpathCode).getTextValue();
	}
	public void enter_code_mainPanel(String sCode){
		String xpathClickOnElement="//*[@class='ui-commandlink ui-widget']";
		String xpathCode="//*[text()='Sales Return No.']/following-sibling::input";
		waitTypeAndEnter(xpathCode, sCode);
		clickOnElement(xpathClickOnElement);
	}
	public void enter_code_without_click(String sCode){
		String xpathCode="//*[text()='Sales Return No.']/following-sibling::input";
		waitTypeAndEnter(xpathCode, sCode);
	}
	public String get_result_code() {
		return $("//*[contains(@class,'ui-widget-content ui-datatable-empty-message')]").waitUntilPresent().getText();
	}
}
