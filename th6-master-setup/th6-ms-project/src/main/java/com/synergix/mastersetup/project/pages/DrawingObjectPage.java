package com.synergix.mastersetup.project.pages;

import com.synergix.common.TH6PageObject;
import com.thoughtworks.selenium.webdriven.commands.GetXpathCount;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Ian on 8/4/2016.
 */
public class DrawingObjectPage extends TH6PageObject {

	public static final String BRAND_IVN_TABLE = "//div[contains(@id,'brand_inv_Table') and @class='ui-datatable ui-widget']";
	public static final String BUTTON_ADD_IN_TABLE = "//button[span[contains(@class,'fa-plus')]]";
	private static final String LABOUR_BUDGET_TABLE = "//div[contains(@id,'bgtLaborTable') and @class='ui-datatable ui-widget']";

	public DrawingObjectPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Edited by Steve on 25/08/2016
	 */
	public void clickNewBtn() {
		String btnXpath = "//button[child::span[text()='New' or contains(@class, 'fa-file')]]";
		clickOnElement(btnXpath);
		waitForAllJSCompletes();
	}

	public void clickNewBrandInventory() {
		clickOnElement(BRAND_IVN_TABLE + BUTTON_ADD_IN_TABLE);
	}

	@FindBy(xpath = BRAND_IVN_TABLE
			+ "//table[@role='grid']/tbody/tr/td[1]//input[@aria-readonly='false' and @aria-readonly='false']")
	WebElementFacade addBrandInput;

	public void enterInputAddBrandCode(String brand) {
		addBrandInput.type(brand);
		waitForAllJSCompletes();
		addBrandInput.sendKeys(Keys.ENTER);
	}

	private String xpathRowByFirstCol(String parentXpath, String firstColValue) {
		return parentXpath + "//table[@role='grid']/tbody/tr[td[.//input[@value='" + firstColValue + "']]]";
	}

	public void enterInputInventoryForBrand(String brand, String inventory) {
		waitForAllJSCompletes();
		$(xpathRowByFirstCol(BRAND_IVN_TABLE, brand) + "/td[2]//input").type(inventory);
		waitForAllJSCompletes();
		$(xpathRowByFirstCol(BRAND_IVN_TABLE, brand) + "/td[2]//input").sendKeys(Keys.ENTER);
	}

	public void clickUpdateBtn() {
		clickBtn("Update");
	}

	private String xPathBtnYesConfirmUpdate = "//div[contains(@id,'globalConfirmation')]//button[.='Yes']";

	public void clickBtnYesOnConfirmUpdate() {
		waitFor(xPathBtnYesConfirmUpdate);
		clickOnElement(xPathBtnYesConfirmUpdate);
		waitForAllJSCompletes();
	}

	public void clickNewLabourBudget() {
		clickOnElement(LABOUR_BUDGET_TABLE + BUTTON_ADD_IN_TABLE);
	}

	public void enterLastDateFrom(String dateFrom) {
		System.out.println("datefrom " + dateFrom);
		clickOnElement(LABOUR_BUDGET_TABLE + "//table/tbody/tr[last()]/td[1]//input");
		waitForAllJSCompletes();
		setCalendarDate(dateFrom);

	}

	public void enterDateTo(String dateFrom, String dateTo) {

		System.out.println("dateto " + dateTo);

		$(xpathRowByFirstCol(LABOUR_BUDGET_TABLE, dateFrom) + "/td[2]//input").click();
		$(xpathRowByFirstCol(LABOUR_BUDGET_TABLE, dateFrom) + "/td[2]//input").sendKeys(dateTo + Keys.ENTER);
	}

	public void enterQty(String dateFrom, String qty) {
		waitTypeAndEnter(xpathRowByFirstCol(LABOUR_BUDGET_TABLE, dateFrom) + "/td[3]//input", qty);

	}

	public void enterUOM(String dateFrom, String uom) {
		
		String xpath= xpathRowByFirstCol(LABOUR_BUDGET_TABLE, dateFrom) + "/td[4]//input";
		$(xpath).sendKeys(uom);
		waitForAllJSCompletes();
		$(xpath).sendKeys(Keys.ENTER);
		waitForAllJSCompletes();
	}

	/**
	 * Created by Zoe on 8/10/2016.
	 */

	private static final String BUTTON_DELETE = "//button[span[contains(@class,'fa-trash-o')]]";
	private static final String DRAWING_OBJECT_CODE="//*[text()='Drawing Object Code']/following-sibling::input";

	@Override
	public String getTextValueWithLabel(String label) {
		String commonXpath = "//*[text()='" + label + "']/following-sibling::div/input";
		return $(commonXpath).getTextValue();

	}
	public void enter_cost_item_group(String sCodeItem){
		String xpath=xPathInputFieldWithLabel("Cost Item Group");
		$(xpath).sendKeys(sCodeItem);
		waitForAllJSCompletes();
		$(xpath).sendKeys(Keys.ENTER);
		waitForAllJSCompletes();
	}

	public void btn_back_to_summary() {
		back_to_summary();
	}

	public void enter_code_subPanel(String sCode) {
		String xPathClickOnElement = "//*[contains(@class,'ui-commandlink ui-widget')]";

		waitTypeAndEnter(DRAWING_OBJECT_CODE, sCode);
		clickOnElement(xPathClickOnElement);
	}
	public void enter_code_mainPanel(String sCode){
		waitTypeAndEnter(DRAWING_OBJECT_CODE, sCode);
	}

	public String get_text_drawing_object_code() {
		return getTextValueWithLabel("Drawing Object Code");

	}

	public String get_text_description(String description) {
		return getTextValueWithLabel("Description");

	}

	public String get_text_cost_Item() {
		String xPathCostItem = "//*[text()='Cost Item Group']/following-sibling::div/span/span/input[1]";
		return $(xPathCostItem).getTextValue();
	}

	public String get_text_dateFrom() {
		String xPathDateFrom = "//div[contains(@id,'bgtLaborTable') and @class='ui-datatable ui-widget']//table/tbody/tr/td[1]//input";
		return $(xPathDateFrom).getTextValue();
	}

	public String get_text_dateTo() {
		String xPathDateTo = "//div[contains(@id,'bgtLaborTable') and @class='ui-datatable ui-widget']//table/tbody/tr/td[2]//input";
		return $(xPathDateTo).getTextValue();
	}

	public String get_text_qty() {
		String xPathQty = "//div[contains(@id,'bgtLaborTable') and @class='ui-datatable ui-widget']//table/tbody/tr/td[3]//input";
		return $(xPathQty).getTextValue();
	}

	public String get_text_uOM() {
		String xPathUOM = "//div[contains(@id,'bgtLaborTable') and @class='ui-datatable ui-widget']//table/tbody/tr/td[4]//input[1]";
		return $(xPathUOM).getTextValue();
	}

	public String get_text_brand() {
		String xPathBrand = "//div[contains(@id,'brand_inv_Table') and @class='ui-datatable ui-widget']//table[@role='grid']/tbody/tr/td[1]//input[@aria-readonly='true' and @aria-disabled='false']";
		return $(xPathBrand).getTextValue();
	}

	public String get_text_inventory() {
		String xPathInventory = "//div[contains(@id,'brand_inv_Table') and @class='ui-datatable ui-widget']//table[@role='grid']/tbody/tr/td[2]//input[@aria-readonly='false' and @aria-disabled='false']";
		return $(xPathInventory).getTextValue();
	}

	public void click_btn_delete_drawingObject() {

		String xBtnDelete = "//span[text()='Delete']";

		waitElementToBePresent(xBtnDelete).waitUntilClickable().click();

		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();

	}

	public void click_delete_laborBudget() {
		String xBtnDelete = LABOUR_BUDGET_TABLE + BUTTON_DELETE;

		waitElementToBePresent(xBtnDelete).waitUntilClickable().click();

		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void click_delete_brand_inventory() {
		String xBtnDelete = BRAND_IVN_TABLE + BUTTON_DELETE;

		waitElementToBePresent(xBtnDelete).waitUntilClickable().click();

		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void choose_laborBudget() {
		String xPathChkBox = "//tbody[contains(@id,'bgtLaborTable') and @class='ui-datatable-data ui-widget-content']//tr/td[6]/div/div[2]";

		if (waitElementToBePresent(xPathChkBox).getAttribute("checked") == null) {
			highlightElement(xPathChkBox + "//ancestor-or-self::td[1]");
			clickOnElement(xPathChkBox);

		} else {
			highlightElement(xPathChkBox + "//ancestor-or-self::td[1]");
		}

	}

	public void choose_brand_inventory() {
		String xPathChkBox = "//tbody[contains(@id,'brand_inv_Table') and @class='ui-datatable-data ui-widget-content']//tr/td[4]/div/div[2]";

		if (waitElementToBePresent(xPathChkBox).getAttribute("checked") == null) {
			highlightElement(xPathChkBox + "//ancestor-or-self::td[1]");
			clickOnElement(xPathChkBox);

		} else {
			highlightElement(xPathChkBox + "//ancestor-or-self::td[1]");
		}
	}

	public String get_result_code() {
		return $("//*[contains(@class,'ui-widget-content ui-datatable-empty-message')]").waitUntilPresent().getText();
	}
	
}

