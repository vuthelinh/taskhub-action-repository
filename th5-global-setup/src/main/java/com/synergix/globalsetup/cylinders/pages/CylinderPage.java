package com.synergix.globalsetup.cylinders.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.WebDriver;

import com.synergix.common.TH5PageObject;

public class CylinderPage extends TH5PageObject {
	private static final String FOR_PRODUCTION_SALES = "For Production / Sales";
	private static final String SERIAL_NO_TRACKING = "Serial No. Tracking";
	private static final String ORDER_SEQUENCE = "Order Sequence";
	private static final String PRODUCTION_CATEGORY_NO = "Production Category No";
	private static final String EMPTY_INVENTORY_CODE = "Empty Inventory Code";
	private static final String FILLED_INVENTORY_CODE = "Filled Inventory Code";
	private static final String CYLINDER_CAPACITY_CODE = "Cylinder Capacity Code";
	private static final String CYLINDER_BRAND_CODE = "Cylinder Brand Code";
	private static final String DESCRIPTION = "Description";
	private static final String CYLINDER_CODE = "Cylinder Code";

	public CylinderPage(WebDriver driver) {
		super(driver);
	}

	public void enter_cylinder_code(String cylinderCode) {
		enterInputFieldCodeWithLabel(CYLINDER_CODE, cylinderCode);
	}

	public void enter_description(String description) {
		enterInputFieldWithLabel(DESCRIPTION, description);
	}

	public void enter_cylinder_brand_code(String cylinderBrandCode) {
		enterInputFieldWithLabel(CYLINDER_BRAND_CODE, cylinderBrandCode);
	}

	public void enter_cylinder_capacity_code(String cylinderCapacityCode) {
		enterInputFieldWithLabel(CYLINDER_CAPACITY_CODE, cylinderCapacityCode);
	}

	public void enter_filled_inventory_code(String filledInventoryCode) {
		enterInputFieldWithLabel(FILLED_INVENTORY_CODE, filledInventoryCode);
	}

	public void enter_empty_inventory_code(String emptyInventoryCode) {
		enterInputFieldWithLabel(EMPTY_INVENTORY_CODE, emptyInventoryCode);
	}

	public void select_serial_no_tracking(String serialNoTracking) {
		selectRadioButton(SERIAL_NO_TRACKING, serialNoTracking);
	}

	public void select_for_production_or_sales(String forProductionOrSales) {
		selectRadioButton(FOR_PRODUCTION_SALES, forProductionOrSales);
	}

	public void enter_production_category_no(String productionCategoryNo) {
		enterInputFieldWithLabel(PRODUCTION_CATEGORY_NO, productionCategoryNo);
	}

	public void enter_order_sequence(String orderSequence) {
		enterInputFieldWithLabel(ORDER_SEQUENCE, orderSequence);
	}

	private String parenttableXpath = "//table[@id='attachmentPanel:tblAttachment']";

	public void enter_file_name(String fileName) {
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

	public void enter_file_description(String fileDescription, int rowIndex) {
		int colIndex = getTbColHeaderIndex(parenttableXpath, "File Description");
		$("(((//table[@id='attachmentPanel:tblAttachment']//tbody[preceding::thead][not(ancestor::tfoot)])[1]//tr/td[contains(@class,'rich-table-cell')]["+colIndex+"])["+rowIndex+"]//input)[1]").sendKeys(fileDescription);
		waitForAllJSCompletes();
	}

	public void intoCompanyTab() {
	switch_to_tab_company();
	}

	public void check_del(int rowIndex) {
		int colIndex = getTbColHeaderIndex(parenttableXpath, "Del");
		clickOnElement("((("
				+ parenttableXpath
				+ "//tbody[preceding::thead][not(ancestor::tfoot)])[1]//tr/td[contains(@class,'rich-table-cell')]["
				+ colIndex + "])[" + rowIndex + "]//input)");
		waitForAllJSCompletes();
	}

	public void download(int rowIndex) {
		int colIndex = getTbColHeaderIndex(parenttableXpath, "File Name")+1;
		clickOnElement("((("
				+ parenttableXpath
				+ "//tbody[preceding::thead][not(ancestor::tfoot)])[1]//tr/td[contains(@class,'rich-table-cell')]["
				+ colIndex + "])[" + rowIndex + "]//input)");
		waitForAllJSCompletes();
		Robot robot;
		try {
			robot = new Robot();
			
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void uploadFile() {
		String fileUpload = System.getProperty("user.dir") +  "\\pom.xml";
		$("//input[@type='file']").sendKeys(fileUpload);
		waitForAllJSCompletes();
	}

	public void Delete_file_attchment(int rowIndex) {
		int colIndex = getTbColHeaderIndex(parenttableXpath, "Del") - 1;
		clickOnElement("((("
				+ parenttableXpath
				+ "//tbody[preceding::thead][not(ancestor::tfoot)])[1]//tr/td[contains(@class,'rich-table-cell')]["
				+ colIndex + "])[" + rowIndex + "]//a)");
		waitForAllJSCompletes();
		chooseYesOnUpdateConfirmation();
		waitForAllJSCompletes();
	}

	public void search(String sCylinderCode) {
		search(CYLINDER_CODE, sCylinderCode);
	}

	public String get_code() {
		return getTextValueWithLabel(CYLINDER_CODE,2);
	}

	public String get_des() {
		return getTextValueWithLabel(DESCRIPTION,2);
	}

	public String get_cylinder_brand_code() {
		return getTextValueWithLabel(CYLINDER_BRAND_CODE,2);
	}

	public String get_cylinder_capacity_code() {
		return getTextValueWithLabel(CYLINDER_CAPACITY_CODE,2);
	}

	public String get_fill_inventory_code() {
		return getTextValueWithLabel(FILLED_INVENTORY_CODE,2);
	}

	public String get_empty_inventory_code() {
		return getTextValueWithLabel(EMPTY_INVENTORY_CODE,2);
	}

	public String get_production_category_no() {
		return getTextValueWithLabel(PRODUCTION_CATEGORY_NO,2);
	}

	public String get_order_sequence() {
		return getTextValueWithLabel(ORDER_SEQUENCE,2);
	}

	public String get_serial_no_tracking(String valueOption) {
		return isChecked(SERIAL_NO_TRACKING, valueOption);
	}

	public String get_production_or_sales(String sForProductionSales) {
		return isChecked(FOR_PRODUCTION_SALES, sForProductionSales);
	}

	public boolean search_cylinder(String sCylinderCode) {
		return search(CYLINDER_CODE, sCylinderCode);
	}
}
